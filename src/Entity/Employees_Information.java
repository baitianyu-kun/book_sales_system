package Entity;

public class Employees_Information {
    private String Name;
    private String Sex;
    private String Employee_Number;
    private String Certificate_ID_Number;//身份证号码
    private String Job;
    private String Type_Of_Identity;
    private String Phone_Number;

    public Employees_Information(String name, String sex, String employee_Number, String certificate_ID_Number, String job, String type_Of_Identity, String phone_Number) {
        Name = name;
        Sex = sex;
        Employee_Number = employee_Number;
        Certificate_ID_Number = certificate_ID_Number;
        Job = job;
        Type_Of_Identity = type_Of_Identity;
        Phone_Number = phone_Number;
    }

    public Employees_Information() {
    }

    @Override
    public String toString() {
        return "Employees_Information{" +
                "Name='" + Name + '\'' +
                ", Sex='" + Sex + '\'' +
                ", Employee_Number='" + Employee_Number + '\'' +
                ", Certificate_ID_Number='" + Certificate_ID_Number + '\'' +
                ", Job='" + Job + '\'' +
                ", Type_Of_Identity='" + Type_Of_Identity + '\'' +
                ", Phone_Number='" + Phone_Number + '\'' +
                '}';
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getEmployee_Number() {
        return Employee_Number;
    }

    public void setEmployee_Number(String employee_Number) {
        Employee_Number = employee_Number;
    }

    public String getCertificate_ID_Number() {
        return Certificate_ID_Number;
    }

    public void setCertificate_ID_Number(String certificate_ID_Number) {
        Certificate_ID_Number = certificate_ID_Number;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }

    public String getType_Of_Identity() {
        return Type_Of_Identity;
    }

    public void setType_Of_Identity(String type_Of_Identity) {
        Type_Of_Identity = type_Of_Identity;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }
}
