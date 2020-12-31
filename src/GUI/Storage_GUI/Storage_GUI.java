/*
 * Created by JFormDesigner on Tue Dec 22 10:57:02 CST 2020
 */

package GUI.Storage_GUI;

import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 2
 */
public class Storage_GUI extends JFrame {
    public Storage_GUI() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        storage_kind_table = new JTable();
        label1 = new JLabel();
        storage_kind_combox = new JComboBox();
        storage_kind_delete_button = new JButton();
        panel2 = new JPanel();
        scrollPane3 = new JScrollPane();
        storage_publisher_table = new JTable();
        label2 = new JLabel();
        storage_publisher_combox = new JComboBox();
        storage_delete_button = new JButton();
        panel3 = new JPanel();
        scoolpanel = new JScrollPane();
        storage_storage_search_table = new JTable();
        label3 = new JLabel();
        storage_sear_year_com = new JComboBox();
        storage_sear_month_com = new JComboBox();
        storage_sear_day_com = new JComboBox();
        label4 = new JLabel();
        storage_sear_bookname_tef = new JTextField();
        label5 = new JLabel();
        storage_sear_kind_com = new JComboBox();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== tabbedPane1 ========
        {

            //======== panel1 ========
            {

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(storage_kind_table);
                }

                //---- label1 ----
                label1.setText("\u8bf7\u9009\u62e9\u56fe\u4e66\u79cd\u7c7b:");

                //---- storage_kind_delete_button ----
                storage_kind_delete_button.setText("\u5220\u9664\u8bb0\u5f55");

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 1461, Short.MAX_VALUE)
                                    .addContainerGap())
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(storage_kind_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 1099, Short.MAX_VALUE)
                                    .addComponent(storage_kind_delete_button)
                                    .addGap(14, 14, 14))))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(storage_kind_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(storage_kind_delete_button))
                            .addGap(14, 14, 14)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
            }
            tabbedPane1.addTab("\u56fe\u4e66\u79cd\u7c7b\u7ba1\u7406", panel1);

            //======== panel2 ========
            {

                //======== scrollPane3 ========
                {
                    scrollPane3.setViewportView(storage_publisher_table);
                }

                //---- label2 ----
                label2.setText("\u51fa\u7248\u793e\u9009\u62e9\uff1a");

                //---- storage_delete_button ----
                storage_delete_button.setText("\u5220\u9664\u8bb0\u5f55");

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 1461, Short.MAX_VALUE)
                                    .addContainerGap())
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addComponent(label2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(storage_publisher_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 1121, Short.MAX_VALUE)
                                    .addComponent(storage_delete_button)
                                    .addGap(14, 14, 14))))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(storage_publisher_combox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(storage_delete_button))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                            .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
            }
            tabbedPane1.addTab("\u51fa\u7248\u793e\u7ba1\u7406", panel2);

            //======== panel3 ========
            {

                //======== scoolpanel ========
                {
                    scoolpanel.setViewportView(storage_storage_search_table);
                }

                //---- label3 ----
                label3.setText("\u8bf7\u9009\u62e9\u65e5\u671f\uff1a");

                //---- label4 ----
                label4.setText("\u8bf7\u8f93\u5165\u4e66\u540d:");

                //---- label5 ----
                label5.setText("\u8bf7\u9009\u62e9\u79cd\u7c7b");

                //---- button2 ----
                button2.setText("\u67e5\u8be2");

                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel3Layout.createParallelGroup()
                                .addGroup(panel3Layout.createSequentialGroup()
                                    .addComponent(scoolpanel, GroupLayout.DEFAULT_SIZE, 1461, Short.MAX_VALUE)
                                    .addContainerGap())
                                .addGroup(panel3Layout.createSequentialGroup()
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
                                    .addComponent(storage_sear_bookname_tef, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label5)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(storage_sear_kind_com, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 339, Short.MAX_VALUE)
                                    .addComponent(button2)
                                    .addGap(27, 27, 27))))
                );
                panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel3Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label5)
                                    .addComponent(button2)
                                    .addComponent(storage_sear_kind_com, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label3)
                                    .addComponent(storage_sear_year_com, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(storage_sear_month_com, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(storage_sear_day_com, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label4)
                                    .addComponent(storage_sear_bookname_tef, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(scoolpanel, GroupLayout.PREFERRED_SIZE, 571, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
            }
            tabbedPane1.addTab("\u5e93\u5b58\u67e5\u8be2", panel3);
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
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable storage_kind_table;
    private JLabel label1;
    private JComboBox storage_kind_combox;
    private JButton storage_kind_delete_button;
    private JPanel panel2;
    private JScrollPane scrollPane3;
    private JTable storage_publisher_table;
    private JLabel label2;
    private JComboBox storage_publisher_combox;
    private JButton storage_delete_button;
    private JPanel panel3;
    private JScrollPane scoolpanel;
    private JTable storage_storage_search_table;
    private JLabel label3;
    private JComboBox storage_sear_year_com;
    private JComboBox storage_sear_month_com;
    private JComboBox storage_sear_day_com;
    private JLabel label4;
    private JTextField storage_sear_bookname_tef;
    private JLabel label5;
    private JComboBox storage_sear_kind_com;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
