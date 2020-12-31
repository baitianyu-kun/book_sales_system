package Entity;

public class Sales_Information {
    private String Date_of_Transaction;
    private String Book_Name;
    private String Publisher;
    private int Counts;
    private double Unit_Price;
    private double Total_Price;
    private String Book_bar_code;

    @Override
    public String toString() {
        return "Sales_Information{" +
                "Date_of_Transaction='" + Date_of_Transaction + '\'' +
                ", Book_Name='" + Book_Name + '\'' +
                ", Publisher='" + Publisher + '\'' +
                ", Counts=" + Counts +
                ", Unit_Price=" + Unit_Price +
                ", Total_Price=" + Total_Price +
                ", Book_bar_code='" + Book_bar_code + '\'' +
                '}';
    }

    public Sales_Information() {
    }

    public Sales_Information(String date_of_Transaction, String book_Name, String publisher, int counts, double unit_Price, double total_Price, String book_bar_code) {
        Date_of_Transaction = date_of_Transaction;
        Book_Name = book_Name;
        Publisher = publisher;
        Counts = counts;
        Unit_Price = unit_Price;
        Total_Price = total_Price;
        Book_bar_code = book_bar_code;
    }

    public String getDate_of_Transaction() {
        return Date_of_Transaction;
    }

    public void setDate_of_Transaction(String date_of_Transaction) {
        Date_of_Transaction = date_of_Transaction;
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

    public int getCounts() {
        return Counts;
    }

    public void setCounts(int counts) {
        Counts = counts;
    }

    public double getUnit_Price() {
        return Unit_Price;
    }

    public void setUnit_Price(double unit_Price) {
        Unit_Price = unit_Price;
    }

    public double getTotal_Price() {
        return Total_Price;
    }

    public void setTotal_Price(double total_Price) {
        Total_Price = total_Price;
    }

    public String getBook_bar_code() {
        return Book_bar_code;
    }

    public void setBook_bar_code(String book_bar_code) {
        Book_bar_code = book_bar_code;
    }
}
