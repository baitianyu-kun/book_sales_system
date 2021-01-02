package Dao.Login_Register_Dao;

import Entity.Employees_Information;
import Entity.Find_Password_Info;
import Entity.User_Info;

import java.util.ArrayList;

public interface Login_Register_Activity_Dao {
    int Login(User_Info user_info);
    int Register(User_Info user_info);
    int Find_Password(Find_Password_Info find_password_info);
    int Change_Password(User_Info user_info);
    int Login_Log_Create(User_Info user_info);
    ArrayList<User_Info> User_Info_Display(String date);
}
