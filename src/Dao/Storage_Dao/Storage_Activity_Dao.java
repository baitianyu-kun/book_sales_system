package Dao.Storage_Dao;
import Entity.Book_Information;
import Entity.Storage_Search_Info;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Set;

public interface Storage_Activity_Dao {
    ArrayList<Book_Information> Book_Type_Search(String Book_Type);
    ArrayList<Book_Information> Book_Publisher_Search(String Book_Publisher);
    ArrayList<Book_Information> Book_Stock_Search_Date(String date);
    ArrayList<Book_Information> Book_Stock_Search_Name(String Book_Name);
    ArrayList<Book_Information> Book_Stock_Search(Storage_Search_Info storage_search_info);
    Set<String> Get_All_Book_Type();
    Set<String> Get_All_Publisher();
}
