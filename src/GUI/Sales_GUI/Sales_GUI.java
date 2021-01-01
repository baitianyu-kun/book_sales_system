/*
 * Created by JFormDesigner on Thu Dec 31 15:02:28 CST 2020
 */

package GUI.Sales_GUI;

import java.awt.event.*;

import Model.Sales_Table_Model;
import Services.Sales_Ser.Sales_Service;
import Utils.Dates;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 2
 */
public class Sales_GUI extends JFrame {
    private Sales_Service sales_service=new Sales_Service();
    private Sales_Table_Model sales_table_model;
    public Sales_GUI() {
        initComponents();
    }
    /*public static void main(String[] args) {
        new Sales_GUI().UI_init();
    }*/
    //总初始化
    public void UI_init()
    {
        for (int i=2001;i<=2025;i++)
        {
            sales_year_combox.addItem(i);
        }
        for (int i=1;i<=12;i++)
        {
            sales_month_combox.addItem(i);
        }
        Table_lable_init(setNowDate());
        Button_init();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public void Button_init()
    {
        sale_delete_button.setEnabled(false);//防止误触删除按钮
    }
    public String getSelectedDate()//获取当前combox的内容,处理一下日期方便查询
    {
        String year=String.valueOf(sales_year_combox.getSelectedItem());
        String month,day;
        if ((int)sales_month_combox.getSelectedItem()<10)
        { month="0"+(int)sales_month_combox.getSelectedItem(); }
        else
        { month=String.valueOf(sales_month_combox.getSelectedItem()); }
        if ((int)sales_day_combox.getSelectedItem()<10)
        { day="0"+(int)sales_day_combox.getSelectedItem(); }
        else { day=String.valueOf((int)sales_day_combox.getSelectedItem()); }
        return year+month+day;
    }
    public String setNowDate()
    {
        //设置启动该模块时候的默认选项
        //用来搞默认日期候选框的
        String year= Dates.getLocalYear();
        String month=Dates.getLocalMonth();
        String day=Dates.getLocalDay();
        sales_year_combox.setSelectedItem(Integer.parseInt(year));
        if (month.charAt(0)=='0')
        { sales_month_combox.setSelectedItem(Integer.parseInt(String.valueOf(month.charAt(1)))); }
        else { sales_month_combox.setSelectedItem(Integer.parseInt(month)); }
        if (day.charAt(0)=='0')
        { sales_day_combox.setSelectedItem(Integer.parseInt(String.valueOf(day.charAt(1)))); }
        else { sales_day_combox.setSelectedItem(Integer.parseInt(day)); }
        return year+month+day;
    }
    public void Table_lable_init(String date)//用来返回时候更新数据和界面上的销量和销售额lable
    {
        sales_table_model=new Sales_Table_Model(sales_service.Sales_Search_Ser(date));
        sale_total_lable.setText(String.valueOf(sales_table_model.return_sum_count()));//界面上的两个lable的数据的初始化
        sale_money_lable.setText(String.valueOf(sales_table_model.return_sum_price()));
        sales_table.setModel(sales_table_model);
        sales_table.getTableHeader().setResizingAllowed(false);//设置不可拉动表格
        sales_table.getTableHeader().setReorderingAllowed(false);//设置不可移动列
    }


    //事件
    private void sales_month_comboxItemStateChanged(ItemEvent e) {
        //*这里用来解决闰年和月份的问题
        if ((int)sales_year_combox.getSelectedItem()%4==0||(int)sales_year_combox.getSelectedItem()%400==0)
        {
            sales_day_combox.removeAllItems();
            if ((int)sales_month_combox.getSelectedItem()==2)
            {
                sales_day_combox.removeAllItems();
                for (int i=1;i<=29;i++)
                {
                    sales_day_combox.addItem(i);
                }
            }else if (
                    (int)sales_month_combox.getSelectedItem()==4||
                            (int)sales_month_combox.getSelectedItem()==6||
                            (int)sales_month_combox.getSelectedItem()==9||
                            (int)sales_month_combox.getSelectedItem()==11)
            {
                sales_day_combox.removeAllItems();
                for (int i=1;i<=30;i++)
                {
                    sales_day_combox.addItem(i);
                }
            }
            else
            {
                sales_day_combox.removeAllItems();
                for (int i=1;i<=31;i++)
                {
                    sales_day_combox.addItem(i);
                }
            }
        }
        else
        {

            sales_day_combox.removeAllItems();
            if ((int)sales_month_combox.getSelectedItem()==2)
            {
                sales_day_combox.removeAllItems();
                for (int i=1;i<=28;i++)
                {
                    sales_day_combox.addItem(i);
                }
            }else if (
                    (int)sales_month_combox.getSelectedItem()==4||
                            (int)sales_month_combox.getSelectedItem()==6||
                            (int)sales_month_combox.getSelectedItem()==9||
                            (int)sales_month_combox.getSelectedItem()==11)
            {
                sales_day_combox.removeAllItems();
                for (int i=1;i<=30;i++)
                {
                    sales_day_combox.addItem(i);
                }
            }
            else
            {
                sales_day_combox.removeAllItems();
                for (int i=1;i<=31;i++)
                {
                    sales_day_combox.addItem(i);
                }
            }
        }
    }
    private void sales_search_buttonActionPerformed(ActionEvent e) {
        sales_table_model=new Sales_Table_Model(sales_service.Sales_Search_Ser(getSelectedDate()));
        sale_total_lable.setText(String.valueOf(sales_table_model.return_sum_count()));//界面上的两个lable的数据的初始化
        sale_money_lable.setText(String.valueOf(sales_table_model.return_sum_price()));
        sales_table.setModel(sales_table_model);
    }
    private void sale_delete_buttonActionPerformed(ActionEvent e) {
        //sales_table.setRowSelectionInterval(0,0);//默认选中第一行
        String book_bar_seletcted=(String) sales_table.getValueAt(sales_table.getSelectedRow(),6);
        if (JOptionPane.showConfirmDialog(this,"确认删除？")==JOptionPane.OK_OPTION)
        {
            sales_service.Sales_Delete_Ser(book_bar_seletcted);
            Table_lable_init(getSelectedDate());
        }
    }
    private void sale_add_buttonActionPerformed(ActionEvent e) {
        new Sales_Add_Dialog(this).UI_init();
        this.setEnabled(false);
    }
    private void thisWindowGainedFocus(WindowEvent e) {
        Table_lable_init(getSelectedDate());
    }
    private void sales_tableMouseClicked(MouseEvent e) {
        sale_delete_button.setEnabled(true);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        sales_year_combox = new JComboBox();
        sales_month_combox = new JComboBox();
        sales_day_combox = new JComboBox();
        scrollPane1 = new JScrollPane();
        sales_table = new JTable();
        sales_search_button = new JButton();
        label4 = new JLabel();
        sale_total_lable = new JLabel();
        sale_add_button = new JButton();
        sale_delete_button = new JButton();
        sale_money_lable = new JLabel();
        label7 = new JLabel();

        //======== this ========
        addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                thisWindowGainedFocus(e);
            }
        });
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u9009\u62e9\u65e5\u671f\uff1a");
        label1.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));

        //---- sales_month_combox ----
        sales_month_combox.addItemListener(e -> sales_month_comboxItemStateChanged(e));

        //======== scrollPane1 ========
        {

            //---- sales_table ----
            sales_table.setRowHeight(30);
            sales_table.setFont(new Font(Font.DIALOG, Font.PLAIN, 24));
            sales_table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    sales_tableMouseClicked(e);
                }
            });
            scrollPane1.setViewportView(sales_table);
        }

        //---- sales_search_button ----
        sales_search_button.setText("\u67e5\u8be2");
        sales_search_button.addActionListener(e -> sales_search_buttonActionPerformed(e));

        //---- label4 ----
        label4.setText("\u9500\u552e\u603b\u91cf/\u672c\uff1a");
        label4.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));

        //---- sale_total_lable ----
        sale_total_lable.setText("text");
        sale_total_lable.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));

        //---- sale_add_button ----
        sale_add_button.setText("\u6dfb\u52a0\u8bb0\u5f55");
        sale_add_button.addActionListener(e -> sale_add_buttonActionPerformed(e));

        //---- sale_delete_button ----
        sale_delete_button.setText("\u5220\u9664\u8bb0\u5f55");
        sale_delete_button.addActionListener(e -> sale_delete_buttonActionPerformed(e));

        //---- sale_money_lable ----
        sale_money_lable.setText("text");
        sale_money_lable.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));

        //---- label7 ----
        label7.setText("\u9500\u552e\u603b\u989d/\u5143:");
        label7.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(12, 12, 12)
                            .addComponent(sales_year_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(sales_month_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(sales_day_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(sales_search_button)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label4)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(sale_total_lable, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addComponent(label7)
                            .addGap(30, 30, 30)
                            .addComponent(sale_money_lable, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 682, Short.MAX_VALUE)
                            .addComponent(sale_add_button)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(sale_delete_button)
                            .addGap(18, 18, 18))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 1476, Short.MAX_VALUE)
                            .addContainerGap())))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(label1))
                        .addComponent(sales_year_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(sales_month_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(sales_day_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(sales_search_button))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(sale_add_button)
                                .addComponent(sale_delete_button)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label4)
                                    .addComponent(sale_total_lable, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label7)
                                    .addComponent(sale_money_lable, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))))
                    .addGap(8, 8, 8)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 567, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JComboBox sales_year_combox;
    private JComboBox sales_month_combox;
    private JComboBox sales_day_combox;
    private JScrollPane scrollPane1;
    private JTable sales_table;
    private JButton sales_search_button;
    private JLabel label4;
    private JLabel sale_total_lable;
    private JButton sale_add_button;
    private JButton sale_delete_button;
    private JLabel sale_money_lable;
    private JLabel label7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
