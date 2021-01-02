/*
 * Created by JFormDesigner on Sat Jan 02 11:15:43 CST 2021
 */

package GUI.System_Manage_GUI;

import Model.In_Storage_Table_Model;
import Model.System_Manage_Table_Model;
import Services.Login_Register_Ser.Login_Register_Service;
import Utils.Dates;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 2
 */
public class System_Manage_GUI extends JFrame {
    private Login_Register_Service login_register_service=new Login_Register_Service();
    public System_Manage_GUI() {
        initComponents();
    }
    /*public static void main(String[] args) {
        new System_Manage_GUI().UI_init();
    }*/
    public String getSelectedDate()//获取当前combox的内容
    {
        String year=String.valueOf(system_man_year_com.getSelectedItem());
        String month,day;
        if ((int)system_man_month_com.getSelectedItem()<10)
        { month="0"+(int)system_man_month_com.getSelectedItem(); }
        else
        { month=String.valueOf(system_man_month_com.getSelectedItem()); }
        if ((int)system_man_day_com.getSelectedItem()<10)
        { day="0"+(int)system_man_day_com.getSelectedItem(); }
        else { day=String.valueOf((int)system_man_day_com.getSelectedItem()); }
        System.out.println(year+month+day);
        return year+month+day;
    }
    public void UI_init()
    {
        Combox_init();
        Table_init();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }
    public void Table_init()//默认table初始化
    {
        //设置启动该模块时候的默认选项和表格，即当天的登录信息
        //用来搞日期候选框的
        String year= Dates.getLocalYear();
        String month=Dates.getLocalMonth();
        String day=Dates.getLocalDay();
        String date=year+month+day;
        system_man_year_com.setSelectedItem(Integer.parseInt(year));
        if (month.charAt(0)=='0')
        { system_man_month_com.setSelectedItem(Integer.parseInt(String.valueOf(month.charAt(1)))); }
        else { system_man_month_com.setSelectedItem(Integer.parseInt(month)); }
        if (day.charAt(0)=='0')
        { system_man_day_com.setSelectedItem(Integer.parseInt(String.valueOf(day.charAt(1)))); }
        else { system_man_day_com.setSelectedItem(Integer.parseInt(day)); }
        //初始化默认的table
        system_manage_table.setModel(new System_Manage_Table_Model(login_register_service.User_Info_Display_Ser(date)));
        system_manage_table.getTableHeader().setResizingAllowed(false);//设置不可拉动表格
        system_manage_table.getTableHeader().setReorderingAllowed(false);//设置不可移动列
    }
    public void Table_init(String date)
    {
        system_manage_table.setModel(new System_Manage_Table_Model(login_register_service.User_Info_Display_Ser(date)));
        system_manage_table.getTableHeader().setResizingAllowed(false);//设置不可拉动表格
        system_manage_table.getTableHeader().setReorderingAllowed(false);//设置不可移动列
    }
    public void Combox_init()
    {
        for (int i=2001;i<=2025;i++)
        {
            system_man_year_com.addItem(i);
        }
        for (int i=1;i<=12;i++)
        {
            system_man_month_com.addItem(i);
        }
    }
    private void system_man_month_comItemStateChanged(ItemEvent e) {
        //*这里用来解决闰年和月份的问题
        if ((int)system_man_year_com.getSelectedItem()%4==0||(int)system_man_year_com.getSelectedItem()%400==0)
        {
            system_man_day_com.removeAllItems();
            if ((int)system_man_month_com.getSelectedItem()==2)
            {
                system_man_day_com.removeAllItems();
                for (int i=1;i<=29;i++)
                {
                    system_man_day_com.addItem(i);
                }
            }else if (
                    (int)system_man_month_com.getSelectedItem()==4||
                            (int)system_man_month_com.getSelectedItem()==6||
                            (int)system_man_month_com.getSelectedItem()==9||
                            (int)system_man_month_com.getSelectedItem()==11)
            {
                system_man_day_com.removeAllItems();
                for (int i=1;i<=30;i++)
                {
                    system_man_day_com.addItem(i);
                }
            }
            else
            {
                system_man_day_com.removeAllItems();
                for (int i=1;i<=31;i++)
                {
                    system_man_day_com.addItem(i);
                }
            }
        }
        else
        {

            system_man_day_com.removeAllItems();
            if ((int)system_man_month_com.getSelectedItem()==2)
            {
                system_man_day_com.removeAllItems();
                for (int i=1;i<=28;i++)
                {
                    system_man_day_com.addItem(i);
                }
            }else if (
                    (int)system_man_month_com.getSelectedItem()==4||
                            (int)system_man_month_com.getSelectedItem()==6||
                            (int)system_man_month_com.getSelectedItem()==9||
                            (int)system_man_month_com.getSelectedItem()==11)
            {
                system_man_day_com.removeAllItems();
                for (int i=1;i<=30;i++)
                {
                    system_man_day_com.addItem(i);
                }
            }
            else
            {
                system_man_day_com.removeAllItems();
                for (int i=1;i<=31;i++)
                {
                    system_man_day_com.addItem(i);
                }
            }
        }
    }
    private void system_man_search_btnActionPerformed(ActionEvent e) {
        Table_init(getSelectedDate());
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        system_manage_table = new JTable();
        label2 = new JLabel();
        system_man_year_com = new JComboBox();
        system_man_month_com = new JComboBox();
        system_man_day_com = new JComboBox();
        system_man_search_btn = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u7cfb\u7edf\u767b\u5f55\u65e5\u5fd7");
        label1.setFont(new Font(Font.DIALOG, Font.PLAIN, 36));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(system_manage_table);
        }

        //---- label2 ----
        label2.setText("\u65f6\u95f4\uff1a");

        //---- system_man_month_com ----
        system_man_month_com.addItemListener(e -> system_man_month_comItemStateChanged(e));

        //---- system_man_search_btn ----
        system_man_search_btn.setText("\u67e5\u8be2");
        system_man_search_btn.addActionListener(e -> system_man_search_btnActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 341, Short.MAX_VALUE)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
                    .addGap(335, 335, 335))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 892, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(system_man_year_com, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(system_man_month_com, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(system_man_day_com, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(system_man_search_btn)))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(system_man_year_com, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(system_man_month_com, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(system_man_day_com, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(system_man_search_btn))
                    .addGap(4, 4, 4)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable system_manage_table;
    private JLabel label2;
    private JComboBox system_man_year_com;
    private JComboBox system_man_month_com;
    private JComboBox system_man_day_com;
    private JButton system_man_search_btn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
