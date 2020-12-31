package Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Dates {
    public static String getLocalDate()
    {
        LocalDate date = LocalDate.now(); // 获取当前日期
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return date.format(formatter);
    }
    public static String getLocalYear()
    {
        LocalDate date = LocalDate.now(); // get the current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        return date.format(formatter);
    }
    public static String getLocalMonth()
    {
        LocalDate date = LocalDate.now(); // get the current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
        return date.format(formatter);
    }
    public static String getLocalDay()
    {
        LocalDate date = LocalDate.now(); // get the current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        return date.format(formatter);
    }
}
