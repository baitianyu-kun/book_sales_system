/*
 * Created by JFormDesigner on Tue Dec 22 09:48:03 CST 2020
 */

package GUI.Sales_GUI;

import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 2
 */
public class Sales_Add_GUI extends JFrame {
    public Sales_Add_GUI() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        sale_add_year_combox = new JComboBox();
        sale_add_month_combox = new JComboBox();
        sale_add_day_combox = new JComboBox();
        label2 = new JLabel();
        sale_add_name_textfie = new JTextField();
        scrollPane1 = new JScrollPane();
        sale_add_table = new JTable();
        sale_add_add_button = new JButton();
        sale_add_back_button = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u4ea4\u6613\u65f6\u95f4\uff1a");

        //---- label2 ----
        label2.setText("\u8f93\u5165\u56fe\u4e66\u540d\u79f0\uff1a");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(sale_add_table);
        }

        //---- sale_add_add_button ----
        sale_add_add_button.setText("\u6dfb\u52a0");

        //---- sale_add_back_button ----
        sale_add_back_button.setText("\u8fd4\u56de");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGap(0, 73, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label1)
                                .addComponent(label2))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(sale_add_year_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(sale_add_month_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(sale_add_day_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addComponent(sale_add_name_textfie))
                            .addGap(99, 99, 99))))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(455, Short.MAX_VALUE)
                    .addComponent(sale_add_add_button)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(sale_add_back_button)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(sale_add_year_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(sale_add_month_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(sale_add_day_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(sale_add_name_textfie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(sale_add_add_button)
                        .addComponent(sale_add_back_button))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JComboBox sale_add_year_combox;
    private JComboBox sale_add_month_combox;
    private JComboBox sale_add_day_combox;
    private JLabel label2;
    private JTextField sale_add_name_textfie;
    private JScrollPane scrollPane1;
    private JTable sale_add_table;
    private JButton sale_add_add_button;
    private JButton sale_add_back_button;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
