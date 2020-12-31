package Dao_Implements.Sales_Dao_Impl;

import Dao.Sales_Dao.Sales_Activity_Dao;
import Entity.Activity_Status;
import Entity.Sales_Add_Info;
import Entity.Sales_Add_Search_Info;
import Entity.Sales_Information;
import Utils.DB_Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Sales_Act_Dao_Impl implements Sales_Activity_Dao {
    private PreparedStatement preparedStatement;
    private PreparedStatement preparedStatement_temp;
    private Connection connection;
    private ResultSet resultSet;
    private ResultSet resultSet_temp;
    //单元测试
    //public static void main(String[] args) {
        /*for (int i=60000000;i<=60000050;i++)
        {
            new Sales_Act_Dao_Impl().Sales_Add(new Sales_Information(
                    "20201230",
                    "大学语文",
                    "河北出版社",
                    5,
                    50.5,
                    50.5*5,
                    String.valueOf(i)
            ));
        }*/

        /*ArrayList<Sales_Information> sales_informations=new Sales_Act_Dao_Impl().Sales_Search("20201231");
        for (int i=0;i<sales_informations.size();i++)
        {
            Sales_Information sales_information=sales_informations.get(i);
            System.out.println(sales_information.getBook_Name()+" "+sales_information.getDate_of_Transaction());
        }*/
        //new Sales_Act_Dao_Impl().Sales_Delete("69865412");
        //new Sales_Act_Dao_Impl().Sales_add_Search("'大学心理学'");//中文查找时候记得加单引号
        //new Sales_Act_Dao_Impl().Sales_Add(new Sales_Add_Info("10000006",5,"20201231"));
        //System.out.println(new Sales_Act_Dao_Impl().judge_have_bar_code("1245685"));
    //}
    @Override
    public ArrayList<Sales_Information> Sales_Search(String date) {
        ArrayList<Sales_Information> sales_informations=new ArrayList<>();
        try {
            connection= DB_Utils.getConnection();
            String sql="select * from Sales_Information where Date_of_Transaction="+date+";";
            preparedStatement=connection.prepareStatement(sql);
            resultSet= preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Sales_Information sales_information=new Sales_Information(
                        resultSet.getString("Date_of_Transaction"),
                        resultSet.getString("Book_Name"),
                        resultSet.getString("Publisher"),
                        resultSet.getInt("Counts"),
                        resultSet.getDouble("Unit_Price"),
                        resultSet.getDouble("Total_Price"),
                        resultSet.getString("Book_bar_code")
                );
                sales_informations.add(sales_information);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return sales_informations;
    }

    public int judge_have_bar_code(String book_bar_code)
    {
        int flag=0;
        try {
            connection=DB_Utils.getConnection();
            String sql="select Book_bar_code from Sales_Information";
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next())
            {
                if (resultSet.getString("Book_bar_code").equals(book_bar_code))
                {
                    flag=1;
                    break;
                }
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        if (flag==0)
            return Activity_Status.NOT_HAVE;
        else
            return Activity_Status.ALREADY_HAVE;
    }
    @Override
    public int Sales_Add(Sales_Add_Info sales_add_info) {
            //先删除对应的一条信息，然后再添加
            connection=DB_Utils.getConnection();
            int count_old=0;//用来保存我这次要增加的销量
            if (judge_have_bar_code(sales_add_info.getBook_bar_code())==Activity_Status.ALREADY_HAVE)
            {
                try {
                    String sql_get_old_count="select Counts from Sales_Information where Book_bar_code="+sales_add_info.getBook_bar_code()+";";
                    preparedStatement_temp=connection.prepareStatement(sql_get_old_count);
                    resultSet_temp=preparedStatement_temp.executeQuery();
                    while (resultSet_temp.next())
                    {
                        count_old=sales_add_info.getCount();//用来保存我这次要增加的销量，用于给后面更新使用
                        sales_add_info.setCount(sales_add_info.getCount()+resultSet_temp.getInt("Counts"));
                        //这个是给表中重新添加，即已经存在了的书，总销量应当等于我添加的销量加上以前的销量，所以在给后面添加时候，
                        //我要改变这个对象里的count值，让重新添加的这条数据的总销量和总价钱更新
                    }
                    String sql="delete from Sales_Information where Book_bar_code="+sales_add_info.getBook_bar_code()+";";
                    preparedStatement=connection.prepareStatement(sql);
                    preparedStatement.executeUpdate();
                }catch (SQLException e)
                {
                    e.printStackTrace();
                    return Activity_Status.INSERT_FAILED;
                }
            }
            //加入新的信息，不管存在有相同的书或者不存在相同的书都会添加
            try {
                String sql1="select Book_Name,Publisher,Book_Bar_code,Unit_Price from Book_Information where Book_Bar_code="+sales_add_info.getBook_bar_code()+";";
                PreparedStatement search_book_info_pre=connection.prepareStatement(sql1);
                ResultSet search_book_info_res=search_book_info_pre.executeQuery();
                String sql2="insert into Sales_Information values(?,?,?,?,?,?,?);";
                PreparedStatement insert_sales_info_pre=connection.prepareStatement(sql2);
                while (search_book_info_res.next())
                {
                    insert_sales_info_pre.setString(1,sales_add_info.getDate_Of_Transaction());
                    insert_sales_info_pre.setString(2,search_book_info_res.getString("Book_Name"));
                    insert_sales_info_pre.setString(3,search_book_info_res.getString("Publisher"));
                    insert_sales_info_pre.setInt(4,sales_add_info.getCount());
                    insert_sales_info_pre.setDouble(5,search_book_info_res.getDouble("Unit_Price"));
                    insert_sales_info_pre.setDouble(6,sales_add_info.getCount()*search_book_info_res.getDouble("Unit_Price"));//单价乘以数量
                    insert_sales_info_pre.setString(7,sales_add_info.getBook_bar_code());
                }
                //更新另一个表中的库存数量
                String sql3="update Book_Information set Stock=Stock-"+count_old+" where Book_Bar_code="+sales_add_info.getBook_bar_code()+";";
                PreparedStatement update_book_info_pre=connection.prepareStatement(sql3);
                update_book_info_pre.executeUpdate();
                return insert_sales_info_pre.executeUpdate();
            }catch (SQLException e)
            {
                e.printStackTrace();
                return Activity_Status.INSERT_FAILED;
            }
    }

    @Override
    public int Sales_Delete(String book_bar_code) {
        try {
            connection=DB_Utils.getConnection();
            String sql="delete from Sales_Information where Book_bar_code="+book_bar_code+";";
            preparedStatement= connection.prepareStatement(sql);
            return preparedStatement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
            return Activity_Status.DELETE_FAILED;
        }
    }

    @Override
    public ArrayList<Sales_Add_Search_Info> Sales_add_Search(String Book_Name) {
        ArrayList<Sales_Add_Search_Info>sales_add_search_infos=new ArrayList<>();
        try {
            connection=DB_Utils.getConnection();
            String sql="select * from Book_Information where Book_Name='"+Book_Name+"';";
            //中文查找要带单引号
            preparedStatement= connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Sales_Add_Search_Info sales_add_search_info=new Sales_Add_Search_Info(
                        resultSet.getString("Book_Name"),
                        resultSet.getString("Publisher"),
                        resultSet.getString("Book_Bar_code"),
                        resultSet.getString("Stock")
                );
                sales_add_search_infos.add(sales_add_search_info);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return sales_add_search_infos;
    }
}
