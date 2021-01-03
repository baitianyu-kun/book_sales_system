package Dao_Implements.Employee_Manage_Dao_Impl;

import Dao.Emplpoyee_Manage_Dao.Employee_Manage_Dao;
import Entity.Activity_Status;
import Entity.Employee_Search_Info;
import Entity.Employees_Information;
import Utils.DB_Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Employee_Manage_Dao_Impl implements Employee_Manage_Dao {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    //单元测试
    //public static void main(String[] args) {
        /*ArrayList<Employees_Information>arrayList=new Employee_Manage_Dao_Impl().Employee_Search(new Employee_Search_Info("Type_Of_Identity","admin"));
        for (int i=0;i< arrayList.size();i++)
        {
            Employees_Information employees_information= arrayList.get(i);
            System.out.println(employees_information.getName()+" "+employees_information.getPhone_Number());
        }*/
        //System.out.println(new Employee_Manage_Dao_Impl().Return_Last_Employee_Number());
        //new Employee_Manage_Dao_Impl().Delete_Employee_Information("192030465");
    //}



    @Override
    public ArrayList<Employees_Information> Employee_Search(Employee_Search_Info employee_search_info) {
        ArrayList<Employees_Information> employees_informations=new ArrayList<>();
        try {
            connection= DB_Utils.getConnection();
            String sql="select * from Employees_Information where "+employee_search_info.getSearch_condition()+"='"+employee_search_info.getValue()+"';";
            preparedStatement= connection.prepareStatement(sql);
            resultSet= preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Employees_Information employees_information=new Employees_Information();
                employees_information.setName(resultSet.getString("Name"));
                employees_information.setSex(resultSet.getString("Sex"));
                employees_information.setEmployee_Number(resultSet.getString("Employee_Number"));
                employees_information.setJob(resultSet.getString("Job"));
                employees_information.setType_Of_Identity(resultSet.getString("Type_Of_Identity"));
                employees_information.setPhone_Number(resultSet.getString("Phone_Number"));
                employees_information.setCertificate_ID_Number(resultSet.getString("Certificate_ID_Number"));
                employees_informations.add(employees_information);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return employees_informations;
    }

    @Override
    public int Delete_Employee_Information(String Employee_Number) {
        try {
            connection=DB_Utils.getConnection();
            String sql="delete from Employees_Information where Employee_Number="+Employee_Number+";";
            preparedStatement= connection.prepareStatement(sql);
            if (preparedStatement.executeUpdate()!=0)
                return Activity_Status.DELETE_SUCCESS;
            else
                return Activity_Status.DELETE_FAILED;
        }catch (SQLException e)
        {
            e.printStackTrace();
            return Activity_Status.DELETE_FAILED;
        }
    }

    @Override
    public int Add_Employee_Information(Employees_Information employees_information) {
        try {
            connection=DB_Utils.getConnection();
            String sql="insert into Employees_Information values (?,?,?,?,?,?,?);";
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1, employees_information.getName());
            preparedStatement.setString(2, employees_information.getSex());
            preparedStatement.setString(3,employees_information.getEmployee_Number());
            preparedStatement.setString(4, employees_information.getJob());
            preparedStatement.setString(5, employees_information.getType_Of_Identity());
            preparedStatement.setString(6, employees_information.getPhone_Number());
            preparedStatement.setString(7, employees_information.getCertificate_ID_Number());
            if (preparedStatement.executeUpdate()!=0)
                return Activity_Status.INSERT_SUCCESS;
            else
                return Activity_Status.INSERT_FAILED;
        }catch (SQLException e)
        {
            e.printStackTrace();
            return Activity_Status.INSERT_FAILED;
        }
    }

    @Override
    public String Return_Last_Employee_Number() {
        String employee_number;
        try {
            connection=DB_Utils.getConnection();
            String sql="SELECT Employee_Number FROM Employees_Information order by Employee_Number desc limit 1;";
            preparedStatement= connection.prepareStatement(sql);
            resultSet= preparedStatement.executeQuery();
            resultSet.next();
            employee_number=resultSet.getString("Employee_Number");
            return employee_number;
        }catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }

    }
}
