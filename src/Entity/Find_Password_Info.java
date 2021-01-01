package Entity;

public class Find_Password_Info {
    private String Password;
    private String Certifi_ID;
    private String Employee_Number;

    public Find_Password_Info() {
    }

    public Find_Password_Info(String password, String certifi_ID, String employee_Number) {
        Password = password;
        Certifi_ID = certifi_ID;
        Employee_Number = employee_Number;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getCertifi_ID() {
        return Certifi_ID;
    }

    public void setCertifi_ID(String certifi_ID) {
        Certifi_ID = certifi_ID;
    }

    public String getEmployee_Number() {
        return Employee_Number;
    }

    public void setEmployee_Number(String employee_Number) {
        Employee_Number = employee_Number;
    }
}
