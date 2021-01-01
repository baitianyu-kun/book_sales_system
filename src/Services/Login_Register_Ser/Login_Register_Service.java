package Services.Login_Register_Ser;

import Dao_Implements.Login_Register_Dao_Impl.Login_Register_Act_Dao_Impl;
import Entity.Activity_Status;
import Entity.Find_Password_Info;
import Entity.User_Info;

public class Login_Register_Service {
    private Login_Register_Act_Dao_Impl login_register_act_dao_impl=new Login_Register_Act_Dao_Impl();
    public int Login_Ser(User_Info user_info)
    {
        if (login_register_act_dao_impl.Login(user_info)== Activity_Status.LOGIN_SUCCESS)
            return Activity_Status.LOGIN_SUCCESS;
        else
            return Activity_Status.LOGIN_FAILED;
    }
    public int Register_Ser(User_Info user_info)
    {
        int temp=login_register_act_dao_impl.Register(user_info);
        if (temp==Activity_Status.REGISTER_SUCCESS)
            return Activity_Status.REGISTER_SUCCESS;
        else if (temp==Activity_Status.EMPLOYEE_NOT_EXIST)
            return Activity_Status.EMPLOYEE_NOT_EXIST;
        else if (temp==Activity_Status.ACCOUNT_EXIST)
            return Activity_Status.ACCOUNT_EXIST;
        else
            return Activity_Status.REGISTER_FAILED;
    }
    public int Find_Password_Ser(Find_Password_Info find_password_info)
    {
        int temp=login_register_act_dao_impl.Find_Password(find_password_info);
        if (temp==Activity_Status.CHANGE_SUCCESS)
            return Activity_Status.CHANGE_SUCCESS;
        else if (temp==Activity_Status.EMPLOYEE_NOT_EXIST)
            return Activity_Status.EMPLOYEE_NOT_EXIST;
        else
            return Activity_Status.CHANGE_FAILED;
    }
}
