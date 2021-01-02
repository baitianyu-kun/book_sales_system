package Model;

import Entity.Book_Information;
import Entity.User_Info;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Iterator;

public class System_Manage_Table_Model extends AbstractTableModel {
    private String[] columnNames = { "登陆日期","账户", "登录时间","退出登录时间","身份"};
    private Object[][] data;
    public System_Manage_Table_Model(ArrayList<User_Info> user_infos)
    {
        Iterator<User_Info> iterator=user_infos.iterator();
        data=new Object[user_infos.size()][5];
        int i=0,j;
        while (iterator.hasNext())
        {
            j=0;
            User_Info user_info= iterator.next();
            data[i][j]=user_info.getLogin_Date();
            j++;
            data[i][j]=user_info.getAccount();
            j++;
            data[i][j]=user_info.getLogin_in_Time();
            j++;
            data[i][j]=user_info.getLogin_out_Time();
            j++;
            data[i][j]=user_info.getIdentity();
            j++;
            i++;
        }
    }
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }

    /**
     * 重写方法，得到表格列数
     */
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }

    /**
     * 得到表格行数
     */
    @Override
    public int getRowCount()
    {
        return data.length;
    }

    /**
     * 得到数据所对应对象
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        return data[rowIndex][columnIndex];
    }

    /**
     * 得到指定列的数据类型
     */
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return data[0][columnIndex].getClass();
    }
}
