package Dao.Login_Register_Dao;

import Entity.User_Info;

public interface Login_Register_Activity_Dao {
    int Login(User_Info user_info);
    int Register(User_Info user_info);
}
