/*
 * Created by JFormDesigner on Mon Dec 21 09:58:51 CST 2020
 */

package GUI.Sales_GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 2
 */
public class Sales_GUI {
    public Sales_GUI() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        销售管理界面 = new JFrame();
        label1 = new JLabel();
        sales_year_combox = new JComboBox();
        sales_month_combox = new JComboBox();
        sales_day_combox = new JComboBox();
        scrollPane1 = new JScrollPane();
        sales_table = new JTable();
        sales_search_button = new JButton();
        label2 = new JLabel();
        now_sale_date_lable = new JLabel();
        label4 = new JLabel();
        sale_total_lable = new JLabel();
        sale_add_button = new JButton();
        sale_delete_button = new JButton();
        sale_money_lable = new JLabel();
        label7 = new JLabel();

        //======== 销售管理界面 ========
        {
            var 销售管理界面ContentPane = 销售管理界面.getContentPane();

            //---- label1 ----
            label1.setText("\u9009\u62e9\u65e5\u671f\uff1a");
            label1.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(sales_table);
            }

            //---- sales_search_button ----
            sales_search_button.setText("\u67e5\u8be2");

            //---- label2 ----
            label2.setText("\u5f53\u524d\u4ea4\u6613\u65e5\u671f\uff1a");

            //---- now_sale_date_lable ----
            now_sale_date_lable.setText("text");

            //---- label4 ----
            label4.setText("\u9500\u552e\u603b\u91cf\uff1a");

            //---- sale_total_lable ----
            sale_total_lable.setText("text");

            //---- sale_add_button ----
            sale_add_button.setText("\u6dfb\u52a0\u8bb0\u5f55");

            //---- sale_delete_button ----
            sale_delete_button.setText("\u5220\u9664\u8bb0\u5f55");

            //---- sale_money_lable ----
            sale_money_lable.setText("text");

            //---- label7 ----
            label7.setText("\u9500\u552e\u603b\u989d\uff1a");

            GroupLayout 销售管理界面ContentPaneLayout = new GroupLayout(销售管理界面ContentPane);
            销售管理界面ContentPane.setLayout(销售管理界面ContentPaneLayout);
            销售管理界面ContentPaneLayout.setHorizontalGroup(
                销售管理界面ContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, 销售管理界面ContentPaneLayout.createSequentialGroup()
                        .addGap(0, 482, Short.MAX_VALUE)
                        .addComponent(label1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sales_year_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(sales_month_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sales_day_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sales_search_button)
                        .addGap(446, 446, 446))
                    .addGroup(GroupLayout.Alignment.TRAILING, 销售管理界面ContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(销售管理界面ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 1476, Short.MAX_VALUE)
                            .addGroup(销售管理界面ContentPaneLayout.createSequentialGroup()
                                .addComponent(label2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(now_sale_date_lable, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(label4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sale_total_lable, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(label7)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sale_money_lable, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sale_add_button)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sale_delete_button)))
                        .addContainerGap())
            );
            销售管理界面ContentPaneLayout.setVerticalGroup(
                销售管理界面ContentPaneLayout.createParallelGroup()
                    .addGroup(销售管理界面ContentPaneLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(销售管理界面ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label1)
                            .addComponent(sales_year_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(sales_day_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(sales_month_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(sales_search_button))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(销售管理界面ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(sale_delete_button)
                            .addComponent(sale_add_button)
                            .addComponent(label7)
                            .addComponent(sale_money_lable, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4)
                            .addComponent(sale_total_lable, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                            .addComponent(now_sale_date_lable))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 573, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
            销售管理界面.pack();
            销售管理界面.setLocationRelativeTo(销售管理界面.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame 销售管理界面;
    private JLabel label1;
    private JComboBox sales_year_combox;
    private JComboBox sales_month_combox;
    private JComboBox sales_day_combox;
    private JScrollPane scrollPane1;
    private JTable sales_table;
    private JButton sales_search_button;
    private JLabel label2;
    private JLabel now_sale_date_lable;
    private JLabel label4;
    private JLabel sale_total_lable;
    private JButton sale_add_button;
    private JButton sale_delete_button;
    private JLabel sale_money_lable;
    private JLabel label7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
