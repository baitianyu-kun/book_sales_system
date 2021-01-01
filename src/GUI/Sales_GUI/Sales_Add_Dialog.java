/*
 * Created by JFormDesigner on Tue Dec 22 09:48:03 CST 2020
 */

package GUI.Sales_GUI;

import Entity.Activity_Status;
import Entity.Sales_Add_Info;
import Model.Sales_Add_Table_Model;
import Services.Sales_Ser.Sales_Service;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.security.PublicKey;

/**
 * @author 2
 */
public class Sales_Add_Dialog extends JDialog {
    private Sales_Service sales_service=new Sales_Service();
    public Sales_Add_Dialog(Window owner) {
        super(owner);
        initComponents();
    }

    //单元测试
    /*public static void main(String[] args) {
        new Sales_Add_Dialog(null).setVisible(true);
    }*/
    public void UI_init()
    {
        setVisible(true);
        setResizable(false);
    }
    public void Table_init()
    {
        sale_add_table.getTableHeader().setResizingAllowed(false);//设置不可拉动表格
        sale_add_table.getTableHeader().setReorderingAllowed(false);//设置不可移动列
    }
    public void Table_init(String book_name)
    {
        sale_add_table.setModel(new Sales_Add_Table_Model(sales_service.Sales_Add_Search_Info(book_name)));
        sale_add_table.getTableHeader().setResizingAllowed(false);//设置不可拉动表格
        sale_add_table.getTableHeader().setReorderingAllowed(false);//设置不可移动列
    }
    private void sale_add_search_buttonActionPerformed(ActionEvent e) {
        Table_init(sale_add_name_tf.getText());//点击查询按钮之后初始化表格
    }

    private void sale_add_add_buttonActionPerformed(ActionEvent e) {
        String book_bar_code=(String) sale_add_table.getValueAt(sale_add_table.getSelectedRow(),2);
        String date_input=JOptionPane.showInputDialog(null,"请输入交易日期：");
        int count_input=Integer.parseInt(JOptionPane.showInputDialog(null,"请输入销量："));
        //System.out.println("count_input="+count_input);
        Sales_Add_Info sales_add_info=new Sales_Add_Info(book_bar_code,count_input,date_input);
        if (sales_service.Sales_Add_Ser(sales_add_info)== Activity_Status.INSERT_SUCCESS)
        {
            JOptionPane.showMessageDialog(this,"添加成功！");
        }
        else JOptionPane.showMessageDialog(this,"添加失败！");
    }
    private void thisWindowGainedFocus(WindowEvent e) {
        Table_init(sale_add_name_tf.getText());
    }
    private void thisWindowClosing(WindowEvent e) {
        this.dispose();
        this.getOwner().setEnabled(true);
    }

    private void sale_add_back_buttonActionPerformed(ActionEvent e) {
        this.dispose();
        this.getOwner().setEnabled(true);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label2 = new JLabel();
        sale_add_name_tf = new JTextField();
        scrollPane1 = new JScrollPane();
        sale_add_table = new JTable();
        sale_add_add_button = new JButton();
        sale_add_back_button = new JButton();
        sale_add_search_button = new JButton();

        //======== this ========
        addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                thisWindowGainedFocus(e);
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        var contentPane = getContentPane();

        //---- label2 ----
        label2.setText("\u8f93\u5165\u56fe\u4e66\u540d\u79f0\uff1a");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(sale_add_table);
        }

        //---- sale_add_add_button ----
        sale_add_add_button.setText("\u6dfb\u52a0");
        sale_add_add_button.addActionListener(e -> sale_add_add_buttonActionPerformed(e));

        //---- sale_add_back_button ----
        sale_add_back_button.setText("\u8fd4\u56de");
        sale_add_back_button.addActionListener(e -> sale_add_back_buttonActionPerformed(e));

        //---- sale_add_search_button ----
        sale_add_search_button.setText("\u67e5\u8be2");
        sale_add_search_button.addActionListener(e -> sale_add_search_buttonActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGap(0, 449, Short.MAX_VALUE)
                            .addComponent(sale_add_add_button)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(sale_add_back_button))
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE))
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(label2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(sale_add_name_tf, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(sale_add_search_button)
                    .addContainerGap(36, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(sale_add_name_tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2))
                        .addComponent(sale_add_search_button))
                    .addGap(12, 12, 12)
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
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
    private JLabel label2;
    private JTextField sale_add_name_tf;
    private JScrollPane scrollPane1;
    private JTable sale_add_table;
    private JButton sale_add_add_button;
    private JButton sale_add_back_button;
    private JButton sale_add_search_button;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
