package Dao_Implements.Put_In_Storage_Dao_Impl;
import Utils.DB_Utils;
import Dao.Put_In_Storage_Dao.In_Storage_Activity_Dao;
import Entity.Activity_Status;
import Entity.Book_Information;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class In_Stor_Act_Dao_Impl implements In_Storage_Activity_Dao {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    @Override
    public int In_Storage_Add(Book_Information book_information) {
        try {
            connection= DB_Utils.getConnection();
            String sql="insert into Book_Information values (?,?,?,?,?,?,?);";
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1,book_information.getBook_Name());
            preparedStatement.setString(2,book_information.getPublisher());
            preparedStatement.setString(3,book_information.getBook_Bar_code());
            preparedStatement.setString(4,book_information.getStock());
            preparedStatement.setString(5,book_information.getType());
            preparedStatement.setString(6,book_information.getUnit_Price());
            preparedStatement.setString(7,book_information.getIn_Storage_Time());
            return preparedStatement.executeUpdate();//增加和删除返回的是受影响的行数,应当判断是否等于0
        }catch (SQLException e)
        {
            e.printStackTrace();
            return Activity_Status.INSERT_FAILED;
        }
    }
    @Override
    public ArrayList<Book_Information> In_Storage_Search(String date) {
        ArrayList<Book_Information> book_informations=new ArrayList<>();
        try {
            connection=DB_Utils.getConnection();
            String sql="select * from Book_Information where In_Storage_Time="+date+";";
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Book_Information book_information=new Book_Information(
                resultSet.getString("Book_Name")
                ,resultSet.getString("Publisher")
                ,resultSet.getString("Book_Bar_code")
                ,resultSet.getString("Stock")
                ,resultSet.getString("Type")
                ,resultSet.getString("Unit_Price")
                ,resultSet.getString("In_Storage_Time"));
                book_informations.add(book_information);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return book_informations;
    }

    @Override
    public int In_Storage_Delete(String book_bar_code) {
        try {
            connection=DB_Utils.getConnection();
            String sql="delete from Book_Information where Book_Bar_Code="+book_bar_code+";";
            preparedStatement=connection.prepareStatement(sql);
            return preparedStatement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
            return Activity_Status.DELETE_FAILED;
        }
    }
}
