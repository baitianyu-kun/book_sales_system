package Entity;

public class Storage_Search_Info {
    private String Book_Name;
    private String Date;

    public Storage_Search_Info(String book_Name, String date) {
        Book_Name = book_Name;
        Date = date;
    }

    public Storage_Search_Info() {
    }

    public String getBook_Name() {
        return Book_Name;
    }

    public void setBook_Name(String book_Name) {
        Book_Name = book_Name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
