package Dao_Implements.Login_Register_Dao_Impl;

import Dao.Login_Register_Dao.Login_Register_Activity_Dao;
import Entity.Activity_Status;
import Entity.Employees_Information;
import Entity.Find_Password_Info;
import Entity.User_Info;
import Utils.DB_Utils;
import Utils.Dates;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

public class Login_Register_Act_Dao_Impl implements Login_Register_Activity_Dao {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    //单元测试
    //public static void main(String[] args) {
        //System.out.println(new Login_Register_Act_Dao_Impl().Login(new User_Info("123456","123456")));
        //System.out.println(new Login_Register_Act_Dao_Impl().Exist_Employee("192030411"));
        //System.out.println(new Login_Register_Act_Dao_Impl().Register(new User_Info("11","19211","192030411")));
        //System.out.println(new Login_Register_Act_Dao_Impl().Exist_Account("19230411"));
        //System.out.println(new Login_Register_Act_Dao_Impl().Find_Password(new Find_Password_Info("54188","13073020050625258X","192030411")));
        //System.out.println(new Login_Register_Act_Dao_Impl().Change_Password(new User_Info("19203411","789")));
        //System.out.println(new Login_Register_Act_Dao_Impl().Account_Equals_Psw("123456","123456"));
        /*User_Info user_info=new User_Info();
        user_info.setNew_Password("54188");
        user_info.setAccount("192030411");
        user_info.setOld_Password("1314527");
        System.out.println(new Login_Register_Act_Dao_Impl().Change_Password(user_info));*/
        /*User_Info user_info=new User_Info();
        user_info.setAccount("192030411");
        user_info.setLogin_in_Time(Dates.getLocalDate_AND_Time());
        user_info.setLogin_out_Time(Dates.getLocalDate_AND_Time());
        user_info.setIdentity("管理员");
        System.out.println(new Login_Register_Act_Dao_Impl().Login_Log(user_info));*/
        /*ArrayList<User_Info>test=new Login_Register_Act_Dao_Impl().User_Info_Display("20210102");
        for (int i=0;i<test.size();i++)
        {
            User_Info user_info=test.get(i);
            System.out.println(user_info.toString());
        }*/
    //}
    @Override
    public int Login(User_Info user_info) {
        try {
            connection= DB_Utils.getConnection();
            String sql="select Password from Login_Info where Account='"+user_info.getAccount()+"';";
            preparedStatement= connection.prepareStatement(sql);
            resultSet= preparedStatement.executeQuery();
            resultSet.next();
            if (user_info.getPassword().equals(resultSet.getString("Password")))
                return Activity_Status.LOGIN_SUCCESS;
            else
                return Activity_Status.LOGIN_FAILED;
        }catch (SQLException e)
        {
            e.printStackTrace();
            return Activity_Status.LOGIN_FAILED;
        }
    }
    public int Exist_Employee(String Employee_Number)//判断是否存在该员工，存在才可以注册
    {
        try {
            connection=DB_Utils.getConnection();
            String sql="select Employee_Number from Employees_Information where Employee_Number="+Employee_Number+";";
            preparedStatement= connection.prepareStatement(sql);
            resultSet= preparedStatement.executeQuery();
            if (resultSet.next())
                return Activity_Status.EMPLOYEE_EXIST;
            else
                return Activity_Status.EMPLOYEE_NOT_EXIST;
        }catch (SQLException e)
        {
            e.printStackTrace();
            return Activity_Status.EMPLOYEE_NOT_EXIST;
        }
    }
    public int Exist_Account(String account)
    {
        try {
            connection=DB_Utils.getConnection();
            String sql="select Account from Login_Info where Account='"+account+"';";
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            if (resultSet.next())
                return Activity_Status.ACCOUNT_EXIST;
            else
                return Activity_Status.ACCOUNT_NOT_EXIST;
        }catch (SQLException e)
        {
            e.printStackTrace();
            return Activity_Status.ACCOUNT_NOT_EXIST;
        }
    }
    public int Account_Equals_Psw(String account,String Psw)//用来判断该账号密码是否与数据库中匹配
    {
        try {
                connection=DB_Utils.getConnection();
                String sql="select * from Login_Info where Account="+account+";";
                preparedStatement= connection.prepareStatement(sql);
                resultSet= preparedStatement.executeQuery();
                resultSet.next();
                if (resultSet.getString("Password").equals(Psw))
                    return Activity_Status.EQUALS;
                else
                    return Activity_Status.NOT_EQUALS;
        }catch (SQLException e)
        {
            e.printStackTrace();
            return Activity_Status.NOT_EQUALS;
        }
    }
    public int Judge_Identity(String Employee_Number)
    {
        try {
            connection=DB_Utils.getConnection();
            String sql="select Type_Of_Identity from Employees_Information where Employee_Number="+Employee_Number+";";
            preparedStatement= connection.prepareStatement(sql);
            resultSet= preparedStatement.executeQuery();
            resultSet.next();
            if (resultSet.getString("Type_Of_Identity").equals("admin"))
                return Activity_Status.ADMIN_USER;
            else
                return Activity_Status.ORDINARY_USER;
        }catch (SQLException e)
        {
            e.printStackTrace();
            return 9999;
        }
    }
    @Override
    public int Register(User_Info user_info)
    {
        try {
            if (Exist_Employee(user_info.getEmployee_number())==Activity_Status.EMPLOYEE_EXIST)
            {
                if (Judge_Identity(user_info.getEmployee_number())==Activity_Status.ADMIN_USER)
                {

                    user_info.setAccount("admin"+user_info.getAccount());

                    if (Exist_Account(user_info.getAccount())==Activity_Status.ACCOUNT_NOT_EXIST)
                    {
                        connection=DB_Utils.getConnection();
                        String sql="insert into Login_Info values(?,?);";
                        preparedStatement=connection.prepareStatement(sql);
                        preparedStatement.setString(1,user_info.getAccount());
                        preparedStatement.setString(2, user_info.getPassword());
                        if (preparedStatement.executeUpdate()!=0)
                            return Activity_Status.REGISTER_ADMIN_USER_SUCCESS;
                        else
                            return Activity_Status.REGISTER_ADMIN_USER_FAILED;
                    }
                    else {
                        return Activity_Status.ACCOUNT_EXIST;
                    }
                }
                else
                {
                    user_info.setAccount(user_info.getAccount());
                    if (Exist_Account(user_info.getAccount())==Activity_Status.ACCOUNT_NOT_EXIST)
                    {
                        connection=DB_Utils.getConnection();
                        String sql="insert into Login_Info values(?,?);";
                        preparedStatement=connection.prepareStatement(sql);
                        preparedStatement.setString(1,user_info.getAccount());
                        preparedStatement.setString(2, user_info.getPassword());
                        if (preparedStatement.executeUpdate()!=0)
                            return Activity_Status.REGISTER_SUCCESS;
                        else
                            return Activity_Status.REGISTER_FAILED;
                    }
                    else {
                        return Activity_Status.ACCOUNT_EXIST;
                    }
                }
            }
            else {
                return Activity_Status.EMPLOYEE_NOT_EXIST;
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
            return Activity_Status.REGISTER_FAILED;
        }
    }
    public int Exist_Employee(String Certificate_ID_Number,String Employee_Number)//判断是否存在该身份证号，并且该身份证号对应的工号是否和输入的相同（因为账号和工号是一样的）
    {
        try {
            connection=DB_Utils.getConnection();
            String sql="select Certificate_ID_Number,Employee_Number from Employees_Information where Certificate_ID_Number='"+Certificate_ID_Number+"';";
            preparedStatement= connection.prepareStatement(sql);
            resultSet= preparedStatement.executeQuery();
            boolean temp=resultSet.next();
            if (temp&&resultSet.getString("Employee_Number").equals(Employee_Number))
                return Activity_Status.EMPLOYEE_EXIST;
            else
                return Activity_Status.EMPLOYEE_NOT_EXIST;
        }catch (SQLException e)
        {
            e.printStackTrace();
            return 9999;
        }
    }
    @Override
    public int Find_Password(Find_Password_Info find_password_info) {
        try {
            if (Exist_Employee(find_password_info.getCertifi_ID(),find_password_info.getEmployee_Number())==Activity_Status.EMPLOYEE_EXIST)
            {
                String account,password;
                if (find_password_info.getAdmin_account().length()!=0)//用来判断是否是管理员，如果是管理员的话就把账号变成admin+工号的形式
                {
                    account= find_password_info.getAdmin_account();
                    password= find_password_info.getPassword();
                }
                else {
                    account= find_password_info.getEmployee_Number();
                    password= find_password_info.getPassword();
                }
                connection=DB_Utils.getConnection();
                String sql="update Login_Info set Password='"+password+"' where Account='"+account+"';";
                preparedStatement= connection.prepareStatement(sql);
                if (preparedStatement.executeUpdate()!=0)
                    return Activity_Status.CHANGE_SUCCESS;
                else
                    return Activity_Status.CHANGE_FAILED;
            }
            else {
                return Activity_Status.EMPLOYEE_NOT_EXIST;
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
            return Activity_Status.CHANGE_FAILED;
        }
    }

    @Override
    public int Change_Password(User_Info user_info) {
        try {
            int temp=Account_Equals_Psw(user_info.getAccount(),user_info.getOld_Password());
            if (temp==Activity_Status.EQUALS)
            {
                connection=DB_Utils.getConnection();
                String sql="update Login_Info set Password='"+user_info.getNew_Password()+"' where Account="+user_info.getAccount()+";";
                preparedStatement=connection.prepareStatement(sql);
                if (preparedStatement.executeUpdate()!=0)
                    return Activity_Status.CHANGE_SUCCESS;
                else
                    return Activity_Status.CHANGE_FAILED;
            }
            else
                return Activity_Status.NOT_EQUALS;
        }catch (SQLException e)
        {
            e.printStackTrace();
            return Activity_Status.CHANGE_FAILED;
        }
    }

    @Override
    public int Login_Log_Create(User_Info user_info) {
        try {
            connection=DB_Utils.getConnection();
            String sql="insert into Login_Log values(?,?,?,?,?);";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user_info.getAccount());
            preparedStatement.setString(2,user_info.getLogin_in_Time());
            preparedStatement.setString(3,user_info.getLogin_out_Time());
            preparedStatement.setString(4,user_info.getIdentity());
            preparedStatement.setString(5,user_info.getLogin_Date());
            if (preparedStatement.executeUpdate()!=0)
                return Activity_Status.INSERT_SUCCESS;
            else
                return Activity_Status.INSERT_FAILED;
        }catch (SQLException e) {
            e.printStackTrace();
            return Activity_Status.INSERT_FAILED;
        }
    }
    @Override
    public ArrayList<User_Info> User_Info_Display(String date) {
        ArrayList<User_Info>user_infos=new ArrayList<>();
        try {
            User_Info user_info=new User_Info();
            connection=DB_Utils.getConnection();
            String sql="select * from Login_Log where Login_Date="+date+";";
            preparedStatement= connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next())
            {
                user_info.setAccount(resultSet.getString("Account"));
                user_info.setLogin_in_Time(resultSet.getString("Login_in_Time"));
                user_info.setLogin_out_Time(resultSet.getString("Login_out_Time"));
                user_info.setIdentity(resultSet.getString("Identity"));
                user_info.setLogin_Date(resultSet.getString("Login_Date"));
                user_infos.add(user_info);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return user_infos;
    }
}
