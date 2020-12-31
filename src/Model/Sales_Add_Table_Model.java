package Model;
import Entity.Sales_Add_Search_Info;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Iterator;

public class Sales_Add_Table_Model extends AbstractTableModel {
    private String[] columnNames = { "图书名称", "出版社","图书条码","库存量"};
    private Object[][] data;
    public Sales_Add_Table_Model(ArrayList<Sales_Add_Search_Info> sales_add_search_infos)
    {
        Iterator<Sales_Add_Search_Info> iterator=sales_add_search_infos.iterator();
        data=new Object[sales_add_search_infos.size()][7];
        int i=0,j;
        while (iterator.hasNext())
        {
            j=0;
            Sales_Add_Search_Info sales_add_search_info= iterator.next();
            data[i][j]=sales_add_search_info.getBook_Name();
            j++;
            data[i][j]=sales_add_search_info.getPublisher();
            j++;
            data[i][j]=sales_add_search_info.getBook_bar_code();
            j++;
            data[i][j]=sales_add_search_info.getStock();
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
