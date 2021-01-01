/*
 * Created by JFormDesigner on Tue Dec 22 10:57:02 CST 2020
 */

package GUI.Storage_GUI;

import java.awt.*;
import java.awt.event.*;

import Entity.Activity_Status;
import Entity.Storage_Search_Info;
import Model.Storage_publish_Model;
import Model.Storage_search_Model;
import Model.Storage_type_Table_Model;
import Services.Put_In_Storage_Ser.In_Storage_Service;
import Services.Storage_Ser.Storage_Service;

import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 2
 */
public class Storage_GUI extends JFrame {
    private Storage_Service storage_service=new Storage_Service();
    private In_Storage_Service in_storage_service=new In_Storage_Service();
    public Storage_GUI() {
        initComponents();
    }

    public static void main(String[] args) {
        new Storage_GUI().UI_init();
    }

    public String getSelectedDate()//获取当前combox的内容
    {
        String year=String.valueOf(storage_sear_year_com.getSelectedItem());
        if (year.equals(String.valueOf(Activity_Status.ANYTHING)))
        {
            return String.valueOf(Activity_Status.ANYTHING);
        }
        else {
            String month,day;
            if ((int)storage_sear_month_com.getSelectedItem()<10)
            { month="0"+(int)storage_sear_month_com.getSelectedItem(); }
            else
            { month=String.valueOf(storage_sear_month_com.getSelectedItem()); }
            if ((int)storage_sear_day_com.getSelectedItem()<10)
            { day="0"+(int)storage_sear_day_com.getSelectedItem(); }
            else { day=String.valueOf((int)storage_sear_day_com.getSelectedItem()); }
            return year+month+day;
        }
    }
    //图书种类管理panel初始化
    public void Storage_type_table_init(String book_type)
    {
        storage_kind_table.setModel(new Storage_type_Table_Model(storage_service.Book_Type_Search_Ser(book_type)));
        storage_kind_table.getTableHeader().setResizingAllowed(false);//设置不可拉动表格
        storage_kind_table.getTableHeader().setReorderingAllowed(false);//设置不可移动列
    }
    public void Storage_type_panel_init()
    {
        Storage_type_table_init(null);
        for (String s:storage_service.Get_All_Book_Type_Ser())
        {
            storage_type_combox.addItem(s);
        }
    }

    //出版社管理panel初始化
    public void Storage_publisher_table_init(String publisher)
    {
        storage_publisher_table.setModel(new Storage_publish_Model(storage_service.Book_Publisher_Search_Ser(publisher)));
        storage_publisher_table.getTableHeader().setResizingAllowed(false);//设置不可拉动表格
        storage_publisher_table.getTableHeader().setReorderingAllowed(false);//设置不可移动列
    }
    public void Storage_publisher_panel_init()
    {
        Storage_publisher_table_init(null);
        for (String s:storage_service.Get_All_Publisher_Ser())
        {
            storage_publisher_combox.addItem(s);
        }
    }

    //库存管理panel初始化
    public void Storage_search_table_date_init(String date)
    {
        storage_search_table.setModel(new Storage_search_Model(storage_service.Book_Stock_Search_Date_Ser(date)));
        storage_search_table.getTableHeader().setResizingAllowed(false);//设置不可拉动表格
        storage_search_table.getTableHeader().setReorderingAllowed(false);//设置不可移动列
    }
    public void Storage_search_table_name_init(String book_name)
    {
        storage_search_table.setModel(new Storage_search_Model(storage_service.Book_Stock_Search_Name_Ser(book_name)));
        storage_search_table.getTableHeader().setResizingAllowed(false);//设置不可拉动表格
        storage_search_table.getTableHeader().setReorderingAllowed(false);//设置不可移动列
    }
    public void Storage_search_table_name_date_init(Storage_Search_Info storage_search_info)
    {
        storage_search_table.setModel(new Storage_search_Model(storage_service.Book_Stock_Search_Ser(storage_search_info)));
        storage_search_table.getTableHeader().setResizingAllowed(false);//设置不可拉动表格
        storage_search_table.getTableHeader().setReorderingAllowed(false);//设置不可移动列
    }
    public void Storage_search_panel_init()
    {
        Storage_search_table_date_init(null);
        storage_sear_year_com.addItem(Activity_Status.ANYTHING);//表示任意的日期
        storage_sear_month_com.addItem(Activity_Status.ANYTHING);
        for (int i=2001;i<=2025;i++)
        {
            storage_sear_year_com.addItem(i);
        }
        for (int i=1;i<=12;i++)
        {
            storage_sear_month_com.addItem(i);
        }
    }
    public void UI_init()
    {
        Storage_type_panel_init();
        Storage_publisher_panel_init();
        Storage_search_panel_init();
        setVisible(true);
        setDefaultCloseOperation(3);
    }
    //事件
    private void book_type_search_buttonActionPerformed(ActionEvent e) {
        Storage_type_table_init((String) storage_type_combox.getSelectedItem());
    }
    private void publisher_search_buttonActionPerformed(ActionEvent e) {
        Storage_publisher_table_init((String) storage_publisher_combox.getSelectedItem());
    }
    private void storage_sear_month_comItemStateChanged(ItemEvent e) {
        //*这里用来解决闰年和月份的问题
        if ((int)storage_sear_year_com.getSelectedItem()%4==0||(int)storage_sear_year_com.getSelectedItem()%400==0)
        {
            storage_sear_day_com.removeAllItems();
            storage_sear_day_com.addItem(Activity_Status.ANYTHING);
            if ((int)storage_sear_month_com.getSelectedItem()==2)
            {
                storage_sear_day_com.removeAllItems();
                storage_sear_day_com.addItem(Activity_Status.ANYTHING);
                for (int i=1;i<=29;i++)
                {
                    storage_sear_day_com.addItem(i);
                }
            }else if (
                    (int)storage_sear_month_com.getSelectedItem()==4||
                            (int)storage_sear_month_com.getSelectedItem()==6||
                            (int)storage_sear_month_com.getSelectedItem()==9||
                            (int)storage_sear_month_com.getSelectedItem()==11)
            {
                storage_sear_day_com.removeAllItems();
                storage_sear_day_com.addItem(Activity_Status.ANYTHING);
                for (int i=1;i<=30;i++)
                {
                    storage_sear_day_com.addItem(i);
                }
            }
            else
            {
                storage_sear_day_com.removeAllItems();
                storage_sear_day_com.addItem(Activity_Status.ANYTHING);
                for (int i=1;i<=31;i++)
                {
                    storage_sear_day_com.addItem(i);
                }
            }
        }
        else
        {

            storage_sear_day_com.removeAllItems();
            storage_sear_day_com.addItem(Activity_Status.ANYTHING);
            if ((int)storage_sear_month_com.getSelectedItem()==2)
            {
                storage_sear_day_com.removeAllItems();
                storage_sear_day_com.addItem(Activity_Status.ANYTHING);
                for (int i=1;i<=28;i++)
                {
                    storage_sear_day_com.addItem(i);
                }
            }else if (
                    (int)storage_sear_month_com.getSelectedItem()==4||
                            (int)storage_sear_month_com.getSelectedItem()==6||
                            (int)storage_sear_month_com.getSelectedItem()==9||
                            (int)storage_sear_month_com.getSelectedItem()==11)
            {
                storage_sear_day_com.removeAllItems();
                storage_sear_day_com.addItem(Activity_Status.ANYTHING);
                for (int i=1;i<=30;i++)
                {
                    storage_sear_day_com.addItem(i);
                }
            }
            else
            {
                storage_sear_day_com.removeAllItems();
                storage_sear_day_com.addItem(Activity_Status.ANYTHING);
                for (int i=1;i<=31;i++)
                {
                    storage_sear_day_com.addItem(i);
                }
            }
        }
    }
    private void storage_sear_year_comItemStateChanged(ItemEvent e) {
        //设置只要年份选择的是任意，则后两个也是任意
        if ((int)storage_sear_year_com.getSelectedItem()==Activity_Status.ANYTHING)
        {
            storage_sear_month_com.setSelectedItem(Activity_Status.ANYTHING);
            storage_sear_day_com.setSelectedItem(Activity_Status.ANYTHING);
        }
    }
    private void storage_sear_buttonActionPerformed(ActionEvent e) {
        String date=getSelectedDate();
        //System.out.println("date="+date);
        if (date.equals(String.valueOf(Activity_Status.ANYTHING)))
        {
            Storage_search_table_name_init(storage_sear_bookname_tf.getText());
        }
        else if (storage_sear_bookname_tf.getText().length()==0){
            Storage_search_table_date_init(date);
        }
        else
        {
            Storage_search_table_name_date_init(new Storage_Search_Info(storage_sear_bookname_tf.getText(),getSelectedDate()));
        }
    }
    private void button1ActionPerformed(ActionEvent e) {
        String book_bar_seletcted=(String) storage_search_table.getValueAt(storage_search_table.getSelectedRow(),4);
        if (JOptionPane.showConfirmDialog(this,"确认删除？")==JOptionPane.OK_OPTION)
        {
            in_storage_service.In_Storage_Delete_Ser(book_bar_seletcted);
            String date=getSelectedDate();
            if (date.equals(String.valueOf(Activity_Status.ANYTHING)))
            {
                Storage_search_table_name_init(storage_sear_bookname_tf.getText());
            }
            else if (storage_sear_bookname_tf.getText().length()==0)
            {
                Storage_search_table_date_init(date);
            }
            else
            {
                Storage_search_table_name_date_init(new Storage_Search_Info(storage_sear_bookname_tf.getText(),getSelectedDate()));
            }
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        storage_search_panel = new JPanel();
        scoolpanel = new JScrollPane();
        storage_search_table = new JTable();
        label3 = new JLabel();
        storage_sear_year_com = new JComboBox();
        storage_sear_month_com = new JComboBox();
        storage_sear_day_com = new JComboBox();
        label4 = new JLabel();
        storage_sear_bookname_tf = new JTextField();
        storage_sear_button = new JButton();
        label5 = new JLabel();
        button1 = new JButton();
        storage_type_panel = new JPanel();
        scrollPane1 = new JScrollPane();
        storage_kind_table = new JTable();
        label1 = new JLabel();
        storage_type_combox = new JComboBox();
        book_type_search_button = new JButton();
        storage_publisher_panel = new JPanel();
        scrollPane3 = new JScrollPane();
        storage_publisher_table = new JTable();
        label2 = new JLabel();
        storage_publisher_combox = new JComboBox();
        publisher_search_button = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== tabbedPane1 ========
        {

            //======== storage_search_panel ========
            {

                //======== scoolpanel ========
                {

                    //---- storage_search_table ----
                    storage_search_table.setRowHeight(30);
                    storage_search_table.setFont(new Font(Font.DIALOG, Font.PLAIN, 24));
                    scoolpanel.setViewportView(storage_search_table);
                }

                //---- label3 ----
                label3.setText("\u8bf7\u9009\u62e9\u65e5\u671f\uff1a");

                //---- storage_sear_year_com ----
                storage_sear_year_com.addItemListener(e -> storage_sear_year_comItemStateChanged(e));

                //---- storage_sear_month_com ----
                storage_sear_month_com.addItemListener(e -> storage_sear_month_comItemStateChanged(e));

                //---- label4 ----
                label4.setText("\u8bf7\u8f93\u5165\u4e66\u540d:");

                //---- storage_sear_button ----
                storage_sear_button.setText("\u67e5\u8be2");
                storage_sear_button.addActionListener(e -> storage_sear_buttonActionPerformed(e));

                //---- label5 ----
                label5.setText("\u63d0\u793a\uff1a\u65e5\u671f\u548c\u4e66\u540d\u5747\u53ef\u4ee5\u5355\u72ec\u67e5\u8be2");

                //---- button1 ----
                button1.setText("\u5220\u9664\u5e93\u5b58");
                button1.addActionListener(e -> button1ActionPerformed(e));

                GroupLayout storage_search_panelLayout = new GroupLayout(storage_search_panel);
                storage_search_panel.setLayout(storage_search_panelLayout);
                storage_search_panelLayout.setHorizontalGroup(
                    storage_search_panelLayout.createParallelGroup()
                        .addGroup(storage_search_panelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(storage_search_panelLayout.createParallelGroup()
                                .addGroup(storage_search_panelLayout.createSequentialGroup()
                                    .addComponent(scoolpanel, GroupLayout.DEFAULT_SIZE, 1461, Short.MAX_VALUE)
                                    .addContainerGap())
                                .addGroup(storage_search_panelLayout.createSequentialGroup()
                                    .addComponent(label3)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(storage_sear_year_com, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(storage_sear_month_com, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(storage_sear_day_com, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label4)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(storage_sear_bookname_tf, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label5)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                                    .addComponent(storage_sear_button)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(button1)
                                    .addGap(15, 15, 15))))
                );
                storage_search_panelLayout.setVerticalGroup(
                    storage_search_panelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, storage_search_panelLayout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(storage_search_panelLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, storage_search_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(button1)
                                    .addComponent(storage_sear_button))
                                .addGroup(GroupLayout.Alignment.TRAILING, storage_search_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label3)
                                    .addComponent(storage_sear_year_com, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(storage_sear_month_com, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(storage_sear_day_com, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label4)
                                    .addComponent(storage_sear_bookname_tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label5)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(scoolpanel, GroupLayout.PREFERRED_SIZE, 571, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
            }
            tabbedPane1.addTab("\u5e93\u5b58\u7ba1\u7406", storage_search_panel);

            //======== storage_type_panel ========
            {

                //======== scrollPane1 ========
                {

                    //---- storage_kind_table ----
                    storage_kind_table.setRowHeight(30);
                    storage_kind_table.setFont(new Font(Font.DIALOG, Font.PLAIN, 24));
                    scrollPane1.setViewportView(storage_kind_table);
                }

                //---- label1 ----
                label1.setText("\u8bf7\u9009\u62e9\u56fe\u4e66\u79cd\u7c7b:");

                //---- book_type_search_button ----
                book_type_search_button.setText("\u67e5\u8be2");
                book_type_search_button.addActionListener(e -> book_type_search_buttonActionPerformed(e));

                GroupLayout storage_type_panelLayout = new GroupLayout(storage_type_panel);
                storage_type_panel.setLayout(storage_type_panelLayout);
                storage_type_panelLayout.setHorizontalGroup(
                    storage_type_panelLayout.createParallelGroup()
                        .addGroup(storage_type_panelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(storage_type_panelLayout.createParallelGroup()
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 1461, Short.MAX_VALUE)
                                .addGroup(storage_type_panelLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(storage_type_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 1107, Short.MAX_VALUE)
                                    .addComponent(book_type_search_button, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap())
                );
                storage_type_panelLayout.setVerticalGroup(
                    storage_type_panelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, storage_type_panelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(storage_type_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(storage_type_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(book_type_search_button))
                            .addGap(12, 12, 12)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
            }
            tabbedPane1.addTab("\u56fe\u4e66\u79cd\u7c7b\u7ba1\u7406", storage_type_panel);

            //======== storage_publisher_panel ========
            {

                //======== scrollPane3 ========
                {

                    //---- storage_publisher_table ----
                    storage_publisher_table.setFont(new Font(Font.DIALOG, Font.PLAIN, 24));
                    storage_publisher_table.setRowHeight(30);
                    scrollPane3.setViewportView(storage_publisher_table);
                }

                //---- label2 ----
                label2.setText("\u51fa\u7248\u793e\u9009\u62e9\uff1a");

                //---- publisher_search_button ----
                publisher_search_button.setText("\u67e5\u8be2");
                publisher_search_button.addActionListener(e -> publisher_search_buttonActionPerformed(e));

                GroupLayout storage_publisher_panelLayout = new GroupLayout(storage_publisher_panel);
                storage_publisher_panel.setLayout(storage_publisher_panelLayout);
                storage_publisher_panelLayout.setHorizontalGroup(
                    storage_publisher_panelLayout.createParallelGroup()
                        .addGroup(storage_publisher_panelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(storage_publisher_panelLayout.createParallelGroup()
                                .addGroup(storage_publisher_panelLayout.createSequentialGroup()
                                    .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 1461, Short.MAX_VALUE)
                                    .addContainerGap())
                                .addGroup(storage_publisher_panelLayout.createSequentialGroup()
                                    .addComponent(label2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(storage_publisher_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 1135, Short.MAX_VALUE)
                                    .addComponent(publisher_search_button)
                                    .addGap(14, 14, 14))))
                );
                storage_publisher_panelLayout.setVerticalGroup(
                    storage_publisher_panelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, storage_publisher_panelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(storage_publisher_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(storage_publisher_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(publisher_search_button))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                            .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
            }
            tabbedPane1.addTab("\u51fa\u7248\u793e\u7ba1\u7406", storage_publisher_panel);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(tabbedPane1)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane1;
    private JPanel storage_search_panel;
    private JScrollPane scoolpanel;
    private JTable storage_search_table;
    private JLabel label3;
    private JComboBox storage_sear_year_com;
    private JComboBox storage_sear_month_com;
    private JComboBox storage_sear_day_com;
    private JLabel label4;
    private JTextField storage_sear_bookname_tf;
    private JButton storage_sear_button;
    private JLabel label5;
    private JButton button1;
    private JPanel storage_type_panel;
    private JScrollPane scrollPane1;
    private JTable storage_kind_table;
    private JLabel label1;
    private JComboBox storage_type_combox;
    private JButton book_type_search_button;
    private JPanel storage_publisher_panel;
    private JScrollPane scrollPane3;
    private JTable storage_publisher_table;
    private JLabel label2;
    private JComboBox storage_publisher_combox;
    private JButton publisher_search_button;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
