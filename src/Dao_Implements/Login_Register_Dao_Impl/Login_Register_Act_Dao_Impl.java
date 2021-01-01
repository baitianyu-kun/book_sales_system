package Dao_Implements.Login_Register_Dao_Impl;

import Dao.Login_Register_Dao.Login_Register_Activity_Dao;
import Entity.Activity_Status;
import Entity.User_Info;
import Utils.DB_Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login_Register_Act_Dao_Impl implements Login_Register_Activity_Dao {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    //单元测试
    public static void main(String[] args) {
        //System.out.println(new Login_Register_Act_Dao_Impl().Login(new User_Info("123456","1234")));
        //System.out.println(new Login_Register_Act_Dao_Impl().Exist_Employee("192030411"));
        //System.out.println(new Login_Register_Act_Dao_Impl().Register(new User_Info("11","19211","192030411")));
    }
    @Override
    public int Login(User_Info user_info) {
        try {
            connection= DB_Utils.getConnection();
            String sql="select Password from Login_Info where Account="+user_info.getAccount()+";";
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
    @Override
    public int Register(User_Info user_info) {
        try {
            if (Exist_Employee(user_info.getEmployee_number())==Activity_Status.EMPLOYEE_EXIST)
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
                return Activity_Status.EMPLOYEE_NOT_EXIST;
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
            return Activity_Status.REGISTER_FAILED;
        }
    }
}
