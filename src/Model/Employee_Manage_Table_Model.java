package Model;

import Entity.Employees_Information;
import Entity.User_Info;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Iterator;

public class Employee_Manage_Table_Model extends AbstractTableModel {
    private String[] columnNames = { "姓名","性别", "工号","职位","身份","手机号","身份证号"};
    private Object[][] data;
    public Employee_Manage_Table_Model(ArrayList<Employees_Information> employees_informations)
    {
        Iterator<Employees_Information> iterator=employees_informations.iterator();
        data=new Object[employees_informations.size()][7];
        int i=0,j;
        while (iterator.hasNext())
        {
            j=0;
            Employees_Information employees_information= iterator.next();
            data[i][j]=employees_information.getName();
            j++;
            data[i][j]=employees_information.getSex();
            j++;
            data[i][j]=employees_information.getEmployee_Number();
            j++;
            data[i][j]=employees_information.getJob();
            j++;
            data[i][j]=employees_information.getType_Of_Identity();
            j++;
            data[i][j]=employees_information.getPhone_Number();
            j++;
            data[i][j]=employees_information.getCertificate_ID_Number();
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
