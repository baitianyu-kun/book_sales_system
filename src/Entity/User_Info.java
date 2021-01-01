package Entity;

public class User_Info {
    private String Account;//账号为工号就行吧
    private String Password;
    private String Employee_number;
    private String Login_in_Time;
    private String Login_out_Time;

    public User_Info(String account, String password, String employee_number) {
        Account = account;
        Password = password;
        Employee_number = employee_number;
    }

    public User_Info(String account, String password) {
        Account = account;
        Password = password;
    }

    public User_Info() {
    }

    public User_Info(String account, String password, String employee_number, String login_in_Time, String login_out_Time) {
        Account = account;
        Password = password;
        Employee_number = employee_number;
        Login_in_Time = login_in_Time;
        Login_out_Time = login_out_Time;
    }

    public String getEmployee_number() {
        return Employee_number;
    }

    public void setEmployee_number(String employee_number) {
        Employee_number = employee_number;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }



    public String getLogin_in_Time() {
        return Login_in_Time;
    }

    public void setLogin_in_Time(String login_in_Time) {
        Login_in_Time = login_in_Time;
    }

    public String getLogin_out_Time() {
        return Login_out_Time;
    }

    public void setLogin_out_Time(String login_out_Time) {
        Login_out_Time = login_out_Time;
    }


}
