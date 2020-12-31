/*
 * Created by JFormDesigner on Tue Dec 22 10:41:33 CST 2020
 */

package GUI.Put_In_Storage_GUI;

import Entity.Activity_Status;
import Model.In_Storage_Table_Model;
import Services.Put_In_Storage_Ser.In_Storage_Service;
import Utils.Dates;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 2
 */
public class In_Storage_GUI extends JFrame {
    private In_Storage_Service in_storage_service=new In_Storage_Service();
    public In_Storage_GUI() {
        initComponents();
    }
    public static void main(String[] args) {
        new In_Storage_GUI().UI_init();
    }
    public String getSelectedDate()//获取当前combox的内容
    {
        String year=String.valueOf(instorage_year_combox.getSelectedItem());
        String month,day;
        if ((int)instorage_month_combox.getSelectedItem()<10)
        { month="0"+(int)instorage_month_combox.getSelectedItem(); }
        else
        { month=String.valueOf(instorage_month_combox.getSelectedItem()); }
        if ((int)instorage_day_combox.getSelectedItem()<10)
        { day="0"+(int)instorage_day_combox.getSelectedItem(); }
        else { day=String.valueOf((int)instorage_day_combox.getSelectedItem()); }
        //System.out.println(year+month+day);
        return year+month+day;
    }
    public void Table_init()//默认table初始化
    {
        //设置启动该模块时候的默认选项和表格，即当天的入库信息
        //用来搞日期候选框的
        String year=Dates.getLocalYear();
        String month=Dates.getLocalMonth();
        String day=Dates.getLocalDay();
        instorage_year_combox.setSelectedItem(Integer.parseInt(year));
        if (month.charAt(0)=='0')
        { instorage_month_combox.setSelectedItem(Integer.parseInt(String.valueOf(month.charAt(1)))); }
        else { instorage_month_combox.setSelectedItem(Integer.parseInt(month)); }
        if (day.charAt(0)=='0')
        { instorage_day_combox.setSelectedItem(Integer.parseInt(String.valueOf(day.charAt(1)))); }
        else { instorage_day_combox.setSelectedItem(Integer.parseInt(day)); }
        //初始化默认的table
        instorage_table.setModel(new In_Storage_Table_Model(in_storage_service.In_Storage_Search_Ser(year+month+day)));
    }
    public void Table_init(String date)//重载函数，用来初始化固定日期的table
    { instorage_table.setModel(new In_Storage_Table_Model(in_storage_service.In_Storage_Search_Ser(date))); }
    public void UI_init()//初始化整个UI
    {
        for (int i=2001;i<=2025;i++)
        {
            instorage_year_combox.addItem(i);
        }
        for (int i=1;i<=12;i++)
        {
            instorage_month_combox.addItem(i);
        }
        Table_init();
        setVisible(true);
        setDefaultCloseOperation(3);
    }
    private void instorage_month_comboxItemStateChanged(ItemEvent e) {
        //*这里用来解决闰年和月份的问题
        if ((int)instorage_year_combox.getSelectedItem()%4==0||(int)instorage_year_combox.getSelectedItem()%400==0)
        {
            instorage_day_combox.removeAllItems();
            if ((int)instorage_month_combox.getSelectedItem()==2)
            {
                instorage_day_combox.removeAllItems();
                for (int i=1;i<=29;i++)
                {
                    instorage_day_combox.addItem(i);
                }
            }else if (
                    (int)instorage_month_combox.getSelectedItem()==4||
                    (int)instorage_month_combox.getSelectedItem()==6||
                    (int)instorage_month_combox.getSelectedItem()==9||
                    (int)instorage_month_combox.getSelectedItem()==11)
            {
                instorage_day_combox.removeAllItems();
                for (int i=1;i<=30;i++)
                {
                    instorage_day_combox.addItem(i);
                }
            }
            else
            {
                instorage_day_combox.removeAllItems();
                for (int i=1;i<=31;i++)
                {
                    instorage_day_combox.addItem(i);
                }
            }
        }
        else
        {

            instorage_day_combox.removeAllItems();
            if ((int)instorage_month_combox.getSelectedItem()==2)
            {
                instorage_day_combox.removeAllItems();
                for (int i=1;i<=28;i++)
                {
                    instorage_day_combox.addItem(i);
                }
            }else if (
                    (int)instorage_month_combox.getSelectedItem()==4||
                    (int)instorage_month_combox.getSelectedItem()==6||
                    (int)instorage_month_combox.getSelectedItem()==9||
                    (int)instorage_month_combox.getSelectedItem()==11)
            {
                instorage_day_combox.removeAllItems();
                for (int i=1;i<=30;i++)
                {
                    instorage_day_combox.addItem(i);
                }
            }
            else
            {
                instorage_day_combox.removeAllItems();
                for (int i=1;i<=31;i++)
                {
                    instorage_day_combox.addItem(i);
                }
            }
        }
        // TODO add your code here
    }
    private void instorage_search_buttonActionPerformed(ActionEvent e) {//查询按钮事件//这里把日期处理一下，方便后期查询
        instorage_table.setModel(new In_Storage_Table_Model(in_storage_service.In_Storage_Search_Ser(getSelectedDate())));
    }
    private void instorage_add_buttonActionPerformed(ActionEvent e) {
        new In_Storage_Add_Dialog(this).setVisible(true);
        this.setEnabled(false);
    }
    private void thisWindowGainedFocus(WindowEvent e) {//当添加完成之后返回，然后刷新该页面的table，实现添加后自动刷新
        Table_init(getSelectedDate());
        // TODO add your code here
    }
    private void instorage_delete_buttonActionPerformed(ActionEvent e) {//删除信息
        String book_bar_seletcted=(String) instorage_table.getValueAt(instorage_table.getSelectedRow(),2);
        if (JOptionPane.showConfirmDialog(this,"确认删除？")==JOptionPane.OK_OPTION)
        { in_storage_service.In_Storage_Delete_Ser(book_bar_seletcted);
            Table_init(getSelectedDate()); }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        instorage_year_combox = new JComboBox();
        instorage_month_combox = new JComboBox();
        instorage_search_button = new JButton();
        instorage_day_combox = new JComboBox();
        scrollPane1 = new JScrollPane();
        instorage_table = new JTable();
        instorage_add_button = new JButton();
        instorage_delete_button = new JButton();

        //======== this ========
        addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                thisWindowGainedFocus(e);
            }
        });
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u9009\u62e9\u5165\u5e93\u67e5\u8be2\u65e5\u671f\uff1a");
        label1.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));

        //---- instorage_month_combox ----
        instorage_month_combox.addItemListener(e -> instorage_month_comboxItemStateChanged(e));

        //---- instorage_search_button ----
        instorage_search_button.setText("\u67e5\u8be2");
        instorage_search_button.addActionListener(e -> instorage_search_buttonActionPerformed(e));

        //======== scrollPane1 ========
        {

            //---- instorage_table ----
            instorage_table.setFont(new Font(Font.DIALOG, Font.PLAIN, 24));
            instorage_table.setRowHeight(30);
            scrollPane1.setViewportView(instorage_table);
        }

        //---- instorage_add_button ----
        instorage_add_button.setText("\u6dfb\u52a0\u5165\u5e93\u4fe1\u606f");
        instorage_add_button.addActionListener(e -> instorage_add_buttonActionPerformed(e));

        //---- instorage_delete_button ----
        instorage_delete_button.setText("\u5220\u9664\u5165\u5e93\u4fe1\u606f");
        instorage_delete_button.addActionListener(e -> instorage_delete_buttonActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(label1)
                    .addGap(12, 12, 12)
                    .addComponent(instorage_year_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12)
                    .addComponent(instorage_month_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(6, 6, 6)
                    .addComponent(instorage_day_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(6, 6, 6)
                    .addComponent(instorage_search_button)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 499, Short.MAX_VALUE)
                    .addComponent(instorage_add_button)
                    .addGap(18, 18, 18)
                    .addComponent(instorage_delete_button)
                    .addGap(27, 27, 27))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 1471, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(label1)
                        .addComponent(instorage_year_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(instorage_month_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(instorage_day_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(instorage_search_button)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(instorage_add_button)
                            .addComponent(instorage_delete_button)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JComboBox instorage_year_combox;
    private JComboBox instorage_month_combox;
    private JButton instorage_search_button;
    private JComboBox instorage_day_combox;
    private JScrollPane scrollPane1;
    private JTable instorage_table;
    private JButton instorage_add_button;
    private JButton instorage_delete_button;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
