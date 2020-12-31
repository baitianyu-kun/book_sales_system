package Entity;

public class Login_Info {
    private String Account;
    private String Password;

    @Override
    public String toString() {
        return "Login_Info{" +
                "Account='" + Account + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    public Login_Info(String account, String password) {
        Account = account;
        Password = password;
    }

    public Login_Info() {
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
}
