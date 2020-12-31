package Entity;

public class Sales_Add_Search_Info {
    private String Book_Name;
    private String Publisher;
    private String Book_bar_code;
    private String Stock;

    public Sales_Add_Search_Info(String book_Name, String publisher, String book_bar_code, String stock) {
        Book_Name = book_Name;
        Publisher = publisher;
        Book_bar_code = book_bar_code;
        Stock = stock;
    }

    public Sales_Add_Search_Info() {
    }

    @Override
    public String toString() {
        return "Sales_Add_Search_Info{" +
                "Book_Name='" + Book_Name + '\'' +
                ", Publisher='" + Publisher + '\'' +
                ", Book_bar_code='" + Book_bar_code + '\'' +
                ", Stock='" + Stock + '\'' +
                '}';
    }

    public String getBook_Name() {
        return Book_Name;
    }

    public void setBook_Name(String book_Name) {
        Book_Name = book_Name;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public String getBook_bar_code() {
        return Book_bar_code;
    }

    public void setBook_bar_code(String book_bar_code) {
        Book_bar_code = book_bar_code;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String stock) {
        Stock = stock;
    }
}
