package Entity;

public class Employee_Search_Info {
    private String Search_condition;
    private String Value;

    public Employee_Search_Info() {
    }

    public Employee_Search_Info(String search_condition, String value) {
        Search_condition = search_condition;
        Value = value;
    }

    public String getSearch_condition() {
        return Search_condition;
    }

    public void setSearch_condition(String search_condition) {
        Search_condition = search_condition;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
