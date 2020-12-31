package Services.Put_In_Storage_Ser;

import Dao_Implements.Put_In_Storage_Dao_Impl.In_Stor_Act_Dao_Impl;
import Entity.Activity_Status;
import Entity.Book_Information;

import java.util.ArrayList;
//service层和dao层相连
public class In_Storage_Service {
    private In_Stor_Act_Dao_Impl in_stor_act_dao_=new In_Stor_Act_Dao_Impl();

    //public static void main(String[] args) {
        /*for (int i=30000700;i<30000750;i++)
        {
            new In_Storage_Service().In_Storage_Add_Ser(new Book_Information(
                    "大学语文",
                    "教育出版社",
                    String.valueOf(i),
                    "150",
                    "教材",
                    "35.8",
                    "20201228"));
        }*/
        //*单元测试
        /*new In_Storage_Service().In_Storage_Add_Ser(new Book_Information(
                "高等数学",
                "清华大学出版社",
                "64266543",
                "65",
                "教材",
                "52.6",
                "20201221"));*/
        //new In_Storage_Service().In_Storage_Delete_Ser("69567895");
        /*ArrayList<Book_Information> book_informations=new In_Storage_Service().In_Storage_Search_Ser("20201205");
        for (int i=0;i<book_informations.size();i++)
        {
            Book_Information book_information=book_informations.get(i);
            System.out.println(book_information.getBook_Name()+" "+book_information.getBook_Bar_code());
        }*/
    //}

    public int In_Storage_Add_Ser(Book_Information book_information){
        if (in_stor_act_dao_.In_Storage_Add(book_information)!=0) return Activity_Status.INSERT_SUCCESS;
        else return Activity_Status.INSERT_FAILED;
    }
    public ArrayList<Book_Information> In_Storage_Search_Ser(String date){
        ArrayList<Book_Information> book_informations=in_stor_act_dao_.In_Storage_Search(date);
        return book_informations;
    }
    public int In_Storage_Delete_Ser(String book_bar_code)
    {
        if (in_stor_act_dao_.In_Storage_Delete(book_bar_code)!=0)
        return Activity_Status.DELETE_SUCCESS; else return Activity_Status.DELETE_FAILED;
    }
}
