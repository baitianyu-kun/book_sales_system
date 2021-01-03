package Services.Employee_Manage_Ser;

import Dao_Implements.Employee_Manage_Dao_Impl.Employee_Manage_Dao_Impl;
import Entity.Activity_Status;
import Entity.Employee_Search_Info;
import Entity.Employees_Information;

import java.util.ArrayList;

public class Employee_Manage_Ser {
    private Employee_Manage_Dao_Impl employee_manage_dao_impl=new Employee_Manage_Dao_Impl();
    public ArrayList<Employees_Information> Employee_Search_Ser(Employee_Search_Info employee_search_info)
    {
        return employee_manage_dao_impl.Employee_Search(employee_search_info);
    }
    public int Add_Employee_Information_Ser(Employees_Information employees_information)
    {
        int temp= employee_manage_dao_impl.Add_Employee_Information(employees_information);
        if (temp== Activity_Status.INSERT_SUCCESS)
            return Activity_Status.INSERT_SUCCESS;
        else
            return Activity_Status.INSERT_FAILED;
    }
    public int Delete_Employee_Information_Ser(String Employee_Number)
    {
        int temp=employee_manage_dao_impl.Delete_Employee_Information(Employee_Number);
        if (temp==Activity_Status.DELETE_SUCCESS)
            return Activity_Status.DELETE_SUCCESS;
        else
            return Activity_Status.DELETE_FAILED;
    }
    public String Return_Last_Employee_Number_Ser()
    {
        return employee_manage_dao_impl.Return_Last_Employee_Number();
    }
}
