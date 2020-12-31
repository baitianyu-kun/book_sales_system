package Dao.Put_In_Storage_Dao;

import Entity.Book_Information;

import java.util.ArrayList;

public interface In_Storage_Activity_Dao {
    int In_Storage_Add(Book_Information book_information);//添加信息，传入的应该是一个实体类,返回是否添加成功
    ArrayList<Book_Information> In_Storage_Search(String date);//查找入库信息，传入从combox上获得的日期，然后返回从数据库中查找之后的结果的集合
    int In_Storage_Delete(String book_bar_code);//删除入库信息，选择某一行之后得到那个bookbarcode，然后返回是否删除成功
}
