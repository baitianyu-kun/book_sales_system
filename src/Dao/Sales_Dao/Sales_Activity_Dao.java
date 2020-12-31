package Dao.Sales_Dao;

import Entity.Sales_Add_Info;
import Entity.Sales_Add_Search_Info;
import Entity.Sales_Information;

import java.util.ArrayList;

public interface Sales_Activity_Dao {
    ArrayList<Sales_Information> Sales_Search(String date);//查询销售信息
    int Sales_Add(Sales_Add_Info sales_add_info);//添加销售信息
    int Sales_Delete(String book_bar_code);//删除销售信息，应当传入的是图书的条码，即唯一标识
    ArrayList<Sales_Add_Search_Info> Sales_add_Search(String Book_Name);//销售记录添加界面查询库存量
}
