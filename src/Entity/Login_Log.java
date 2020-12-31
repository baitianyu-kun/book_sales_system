package Entity;

import java.time.LocalDate;

public class Login_Log {
    private String Account;
    private String Login_Date_Time;

    @Override
    public String toString() {
        return "Login_Log{" +
                "Account='" + Account + '\'' +
                ", Login_Date_Time='" + Login_Date_Time + '\'' +
                '}';
    }

    public Login_Log(String account, String login_Date_Time) {
        Account = account;
        Login_Date_Time = login_Date_Time;
    }

    public Login_Log() {
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getLogin_Date_Time() {
        return Login_Date_Time;
    }

    public void setLogin_Date_Time(String login_Date_Time) {
        Login_Date_Time = login_Date_Time;
    }
}
