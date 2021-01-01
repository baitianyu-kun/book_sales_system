package Model;

import Entity.Book_Information;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Iterator;

public class Storage_publish_Model extends AbstractTableModel {
    private String[] columnNames = { "出版社", "图书名称","图书种类","图书条码","库存量","单价","入库时间"};
    private Object[][] data;
    public Storage_publish_Model(ArrayList<Book_Information> book_informations)
    {
        Iterator<Book_Information> iterator=book_informations.iterator();
        data=new Object[book_informations.size()][7];
        int i=0,j;
        while (iterator.hasNext())
        {
            j=0;
            Book_Information book_information= iterator.next();
            data[i][j]=book_information.getPublisher();
            j++;
            data[i][j]=book_information.getBook_Name();
            j++;
            data[i][j]=book_information.getType();
            j++;
            data[i][j]=book_information.getBook_Bar_code();
            j++;
            data[i][j]=book_information.getStock();
            j++;
            data[i][j]=book_information.getUnit_Price();
            j++;
            data[i][j]=book_information.getIn_Storage_Time();
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
