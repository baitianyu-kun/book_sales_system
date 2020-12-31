package Model;

import Entity.Sales_Information;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Iterator;

public class Sales_Table_Model extends AbstractTableModel {
    private String[] columnNames = { "交易日期", "图书名称","出版社","数量","单价","总价","图书条码"};
    private Object[][] data;
    private static int sum_count=0;
    private static double sum_price=0.0;
    public Sales_Table_Model(ArrayList<Sales_Information> sales_informations)
    {
        sum_count=0;sum_price=0.0;
        Iterator<Sales_Information> iterator=sales_informations.iterator();
        data=new Object[sales_informations.size()][7];
        int i=0,j;
        while (iterator.hasNext())
        {
            j=0;
            Sales_Information sales_information= iterator.next();
            data[i][j]=sales_information.getDate_of_Transaction();
            j++;
            data[i][j]=sales_information.getBook_Name();
            j++;
            data[i][j]=sales_information.getPublisher();
            j++;
            data[i][j]=sales_information.getCounts();
            sum_count=sum_count+(int)data[i][j];
            j++;
            data[i][j]=sales_information.getUnit_Price();
            j++;
            data[i][j]=sales_information.getTotal_Price();
            sum_price=sum_price+(double)data[i][j];
            j++;
            data[i][j]=sales_information.getBook_bar_code();
            j++;
            i++;
        }
    }
    public static int return_sum_count()
    { return sum_count; }
    public static double return_sum_price()
    { return sum_price; }
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
