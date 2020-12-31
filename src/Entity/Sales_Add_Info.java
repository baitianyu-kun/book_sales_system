package Entity;

public class Sales_Add_Info {
    private String book_bar_code;
    private int count;
    private  String Date_Of_Transaction;

    public Sales_Add_Info() {
    }

    public Sales_Add_Info(String book_bar_code, int count, String date_Of_Transaction) {
        this.book_bar_code = book_bar_code;
        this.count = count;
        Date_Of_Transaction = date_Of_Transaction;
    }

    public String getBook_bar_code() {
        return book_bar_code;
    }

    public void setBook_bar_code(String book_bar_code) {
        this.book_bar_code = book_bar_code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDate_Of_Transaction() {
        return Date_Of_Transaction;
    }

    public void setDate_Of_Transaction(String date_Of_Transaction) {
        Date_Of_Transaction = date_Of_Transaction;
    }
}
