package Services.Storage_Ser;

import Dao_Implements.Storage_Dao_Impl.Storage_Act_Dao_Impl;
import Entity.Book_Information;
import Entity.Storage_Search_Info;
import com.sun.source.doctree.SeeTree;

import java.util.ArrayList;
import java.util.Set;

public class Storage_Service {
    private Storage_Act_Dao_Impl storage_act_dao_impl=new Storage_Act_Dao_Impl();
    public ArrayList<Book_Information> Book_Type_Search_Ser(String Book_Type)
    {
        return storage_act_dao_impl.Book_Type_Search(Book_Type);
    }
    public ArrayList<Book_Information> Book_Publisher_Search_Ser(String Book_Publisher)
    {
        return storage_act_dao_impl.Book_Publisher_Search(Book_Publisher);
    }
    public ArrayList<Book_Information> Book_Stock_Search_Date_Ser(String date)
    {
        return storage_act_dao_impl.Book_Stock_Search_Date(date);
    }
    public ArrayList<Book_Information> Book_Stock_Search_Name_Ser(String Book_Name)
    {
        return storage_act_dao_impl.Book_Stock_Search_Name(Book_Name);
    }
    public ArrayList<Book_Information> Book_Stock_Search_Ser(Storage_Search_Info storage_search_info)
    {
        return storage_act_dao_impl.Book_Stock_Search(storage_search_info);
    }
    public Set<String> Get_All_Book_Type_Ser()
    {
        return storage_act_dao_impl.Get_All_Book_Type();
    }
    public Set<String> Get_All_Publisher_Ser()
    {
        return storage_act_dao_impl.Get_All_Publisher();
    }
}
