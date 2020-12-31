package Services.Sales_Ser;

import Dao_Implements.Sales_Dao_Impl.Sales_Act_Dao_Impl;
import Entity.Activity_Status;
import Entity.Sales_Add_Info;
import Entity.Sales_Add_Search_Info;
import Entity.Sales_Information;

import java.util.ArrayList;

public class Sales_Service {
    private Sales_Act_Dao_Impl sales_act_dao_Impl=new Sales_Act_Dao_Impl();
    public ArrayList<Sales_Information> Sales_Search_Ser(String date)
    {
        return sales_act_dao_Impl.Sales_Search(date);
    }
    public int Sales_Add_Ser(Sales_Add_Info sales_add_info)
    {
        if (sales_act_dao_Impl.Sales_Add(sales_add_info)!=0)
            return Activity_Status.INSERT_SUCCESS;
        else return Activity_Status.INSERT_FAILED;
    }
    public int Sales_Delete_Ser(String book_bar_code)
    {
        if (sales_act_dao_Impl.Sales_Delete(book_bar_code)!=0)
            return Activity_Status.DELETE_SUCCESS;
        else return Activity_Status.DELETE_FAILED;
    }
    public ArrayList<Sales_Add_Search_Info> Sales_Add_Search_Info(String book_name)
    {
        return sales_act_dao_Impl.Sales_add_Search(book_name);
    }
}
