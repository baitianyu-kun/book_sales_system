package Dao.Emplpoyee_Manage_Dao;

import Entity.Employee_Search_Info;
import Entity.Employees_Information;

import java.util.ArrayList;

public interface Employee_Manage_Dao {
    ArrayList<Employees_Information>Employee_Search(Employee_Search_Info employee_search_info);
    int Delete_Employee_Information(String Employee_Number);
    int Add_Employee_Information(Employees_Information employees_information);
    String Return_Last_Employee_Number();
}
