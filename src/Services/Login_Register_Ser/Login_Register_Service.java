package Services.Login_Register_Ser;

import Dao_Implements.Login_Register_Dao_Impl.Login_Register_Act_Dao_Impl;
import Entity.Activity_Status;
import Entity.Find_Password_Info;
import Entity.User_Info;

import java.util.ArrayList;

public class Login_Register_Service {
    //单元测试
    //public static void main(String[] args) {
        /*User_Info user_info=new User_Info();
        user_info.setOld_Password("bai1");
        user_info.setNew_Password("bai");
        user_info.setAccount("192030411");
        System.out.println(new Login_Register_Service().Change_Password_Ser(user_info));*/
        /*User_Info user_info=new User_Info();
        user_info.setAccount("192030411");
        user_info.setPassword("123");
        user_info.setEmployee_number("192030411");
        System.out.println(new Login_Register_Service().Register_Ser(user_info));*/

   // }
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
        else if (temp==Activity_Status.REGISTER_ADMIN_USER_FAILED)
            return Activity_Status.REGISTER_ADMIN_USER_FAILED;
        else if (temp==Activity_Status.REGISTER_ADMIN_USER_SUCCESS)
            return Activity_Status.REGISTER_ADMIN_USER_SUCCESS;
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
    public int Change_Password_Ser(User_Info user_info)
    {
        int temp=login_register_act_dao_impl.Change_Password(user_info);
        if (temp==Activity_Status.CHANGE_SUCCESS)
            return Activity_Status.CHANGE_SUCCESS;
        else if (temp==Activity_Status.NOT_EQUALS)
            return Activity_Status.NOT_EQUALS;
        else
            return Activity_Status.CHANGE_FAILED;
    }
    public int Login_Log_Create_Ser(User_Info user_info)
    {
        if (login_register_act_dao_impl.Login_Log_Create(user_info)==Activity_Status.INSERT_SUCCESS)
            return Activity_Status.INSERT_SUCCESS;
        else
            return Activity_Status.INSERT_FAILED;
    }
    public ArrayList<User_Info> User_Info_Display_Ser(String date)
    {
        return login_register_act_dao_impl.User_Info_Display(date);
    }
}
