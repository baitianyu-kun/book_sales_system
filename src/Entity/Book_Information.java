package Entity;

public class Book_Information {
    private String Book_Name;
    private String Publisher;
    private String Book_Bar_code;
    private String Stock;//库存
    private String Type;
    private String Unit_Price;
    private String In_Storage_Time;

    public String getIn_Storage_Time() {
        return In_Storage_Time;
    }

    public void setIn_Storage_Time(String in_Storage_Time) {
        In_Storage_Time = in_Storage_Time;
    }

    public Book_Information(String book_Name, String publisher, String book_Bar_code, String stock, String type, String unit_Price, String in_Storage_Time) {
        Book_Name = book_Name;
        Publisher = publisher;
        Book_Bar_code = book_Bar_code;
        Stock = stock;
        Type = type;
        Unit_Price = unit_Price;
        In_Storage_Time = in_Storage_Time;
    }

    public Book_Information() {
    }

    @Override
    public String toString() {
        return "Book_Information{" +
                "Book_Name='" + Book_Name + '\'' +
                ", Publisher='" + Publisher + '\'' +
                ", Book_Bar_code='" + Book_Bar_code + '\'' +
                ", Stock='" + Stock + '\'' +
                ", Type='" + Type + '\'' +
                ", Unit_Price='" + Unit_Price + '\'' +
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

    public String getBook_Bar_code() {
        return Book_Bar_code;
    }

    public void setBook_Bar_code(String book_Bar_code) {
        Book_Bar_code = book_Bar_code;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String stock) {
        Stock = stock;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getUnit_Price() {
        return Unit_Price;
    }

    public void setUnit_Price(String unit_Price) {
        Unit_Price = unit_Price;
    }
}
