package Dao_Implements.Storage_Dao_Impl;

import Dao.Storage_Dao.Storage_Activity_Dao;
import Entity.Book_Information;
import Entity.Storage_Search_Info;
import Utils.DB_Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Storage_Act_Dao_Impl implements Storage_Activity_Dao {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    //单元测试
    //public static void main(String[] args) {
        //ArrayList<Book_Information>book_informations=new Storage_Act_Dao_Impl().Book_Stock_Search_Name("高等数学");
        //ArrayList<Book_Information>book_informations=new Storage_Act_Dao_Impl().Book_Stock_Search_Date("20201231");
        //ArrayList<Book_Information>book_informations=new Storage_Act_Dao_Impl().Book_Stock_Search(new Storage_Search_Info("高等数学","20201221"));
        /*for (int i=0;i<book_informations.size();i++)
        {
            Book_Information book_information=book_informations.get(i);
            System.out.println(book_information.getBook_Name()+" "+book_information.getBook_Bar_code());
        }*/
    //}
    @Override
    public ArrayList<Book_Information> Book_Type_Search(String Book_Type) {
        ArrayList<Book_Information> book_informations=new ArrayList<>();
        try {
            connection= DB_Utils.getConnection();
            String sql="select * from Book_Information where Type="+Book_Type+";";
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Book_Information book_information=new Book_Information(
                        resultSet.getString("Book_Name"),
                        resultSet.getString("Publisher"),
                        resultSet.getString("Book_Bar_code"),
                        resultSet.getString("Stock"),
                        resultSet.getString("Type"),
                        resultSet.getString("Unit_Price"),
                        resultSet.getString("In_Storage_Time")
                );
                book_informations.add(book_information);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return book_informations;
    }

    @Override
    public ArrayList<Book_Information> Book_Publisher_Search(String Book_Publisher) {
        ArrayList<Book_Information> book_informations=new ArrayList<>();
        try {
            connection= DB_Utils.getConnection();
            String sql="select * from Book_Information where Publisher='"+Book_Publisher+"';";
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Book_Information book_information=new Book_Information(
                        resultSet.getString("Book_Name"),
                        resultSet.getString("Publisher"),
                        resultSet.getString("Book_Bar_code"),
                        resultSet.getString("Stock"),
                        resultSet.getString("Type"),
                        resultSet.getString("Unit_Price"),
                        resultSet.getString("In_Storage_Time")
                );
                book_informations.add(book_information);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return book_informations;
    }
    @Override
    public ArrayList<Book_Information> Book_Stock_Search_Date(String date) {
        ArrayList<Book_Information> book_informations=new ArrayList<>();
        try {
            connection= DB_Utils.getConnection();
            String sql="select * from Book_Information where In_Storage_Time="+date+";";
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Book_Information book_information=new Book_Information(
                        resultSet.getString("Book_Name"),
                        resultSet.getString("Publisher"),
                        resultSet.getString("Book_Bar_code"),
                        resultSet.getString("Stock"),
                        resultSet.getString("Type"),
                        resultSet.getString("Unit_Price"),
                        resultSet.getString("In_Storage_Time")
                );
                book_informations.add(book_information);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return book_informations;
    }

    @Override
    public ArrayList<Book_Information> Book_Stock_Search_Name(String Book_Name) {
        ArrayList<Book_Information> book_informations=new ArrayList<>();
        try {
            connection= DB_Utils.getConnection();
            String sql="select * from Book_Information where Book_Name='"+Book_Name+"';";
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Book_Information book_information=new Book_Information(
                        resultSet.getString("Book_Name"),
                        resultSet.getString("Publisher"),
                        resultSet.getString("Book_Bar_code"),
                        resultSet.getString("Stock"),
                        resultSet.getString("Type"),
                        resultSet.getString("Unit_Price"),
                        resultSet.getString("In_Storage_Time")
                );
                book_informations.add(book_information);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return book_informations;
    }

    @Override
    public ArrayList<Book_Information> Book_Stock_Search(Storage_Search_Info storage_search_info) {
        ArrayList<Book_Information> book_informations=new ArrayList<>();
        try {
            connection= DB_Utils.getConnection();
            String sql="select * from Book_Information where Book_Name='"+storage_search_info.getBook_Name()+"' and In_Storage_Time="+storage_search_info.getDate()+";";
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Book_Information book_information=new Book_Information(
                        resultSet.getString("Book_Name"),
                        resultSet.getString("Publisher"),
                        resultSet.getString("Book_Bar_code"),
                        resultSet.getString("Stock"),
                        resultSet.getString("Type"),
                        resultSet.getString("Unit_Price"),
                        resultSet.getString("In_Storage_Time")
                );
                book_informations.add(book_information);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return book_informations;
    }
}
