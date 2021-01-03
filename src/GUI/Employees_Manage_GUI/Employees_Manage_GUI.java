/*
 * Created by JFormDesigner on Sun Jan 03 09:27:52 CST 2021
 */

package GUI.Employees_Manage_GUI;

import Entity.Employee_Search_Info;
import Model.Employee_Manage_Table_Model;
import Services.Employee_Manage_Ser.Employee_Manage_Ser;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 2
 */
public class Employees_Manage_GUI extends JFrame {
    private Employee_Manage_Ser employee_manage_ser=new Employee_Manage_Ser();

    /*public static void main(String[] args) {
        new Employees_Manage_GUI().UI_init();
    }*/
    public Employees_Manage_GUI() {
        initComponents();
    }
    public void Table_init(String condition,String value)
    {
        emploee_man_table.setModel(new Employee_Manage_Table_Model(employee_manage_ser.Employee_Search_Ser(new Employee_Search_Info(condition,value))));
        emploee_man_table.getTableHeader().setResizingAllowed(false);//设置不可拉动表格
        emploee_man_table.getTableHeader().setReorderingAllowed(false);//设置不可移动列
    }
    public void Combox_init()
    {
        emploee_man_comb.addItem("姓名");
        emploee_man_comb.addItem("手机号");
        emploee_man_comb.addItem("职位");
        emploee_man_comb.addItem("身份");
    }
    public String getSelectedCombox(String combox_content)
    {
        if (combox_content.equals("姓名"))
            return "Name";
        else if (combox_content.equals("手机号"))
            return "Phone_Number";
        else if (combox_content.equals("职位"))
            return "Job";
        else if (combox_content.equals("身份"))
            return "Type_Of_Identity";
        else
            return null;
    }

    public void UI_init()
    {
        Combox_init();
        Table_init(null,null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }
    //事件
    private void emploee_man_btnActionPerformed(ActionEvent e) {
        Table_init(getSelectedCombox((String) emploee_man_comb.getSelectedItem()),emploee_man_tf.getText());
    }
    private void emploee_man_add_btnActionPerformed(ActionEvent e) {
        new Employee_Add_Dialog(this).UI_init();
        this.setEnabled(false);
    }
    private void thisWindowGainedFocus(WindowEvent e) {
        Table_init(getSelectedCombox((String) emploee_man_comb.getSelectedItem()),emploee_man_tf.getText());
    }
    private void emploee_man_del_btnActionPerformed(ActionEvent e) {
        String employee_number_seletcted=(String)emploee_man_table.getValueAt(emploee_man_table.getSelectedRow(),2);
        if (JOptionPane.showConfirmDialog(this,"确认删除？")==JOptionPane.OK_OPTION)
        {
            employee_manage_ser.Delete_Employee_Information_Ser(employee_number_seletcted);
            Table_init(getSelectedCombox((String) emploee_man_comb.getSelectedItem()),emploee_man_tf.getText());
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        emploee_man_comb = new JComboBox();
        emploee_man_tf = new JTextField();
        emploee_man_btn = new JButton();
        scrollPane1 = new JScrollPane();
        emploee_man_table = new JTable();
        emploee_man_add_btn = new JButton();
        emploee_man_del_btn = new JButton();

        //======== this ========
        addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                thisWindowGainedFocus(e);
            }
        });
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u5458\u5de5\u4fe1\u606f\u7ba1\u7406");
        label1.setFont(new Font(Font.DIALOG, Font.PLAIN, 26));

        //---- label2 ----
        label2.setText("\u8bf7\u9009\u62e9\u67e5\u8be2\u6761\u4ef6\uff1a");
        label2.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));

        //---- emploee_man_btn ----
        emploee_man_btn.setText("\u67e5\u8be2");
        emploee_man_btn.addActionListener(e -> emploee_man_btnActionPerformed(e));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(emploee_man_table);
        }

        //---- emploee_man_add_btn ----
        emploee_man_add_btn.setText("\u6dfb\u52a0");
        emploee_man_add_btn.addActionListener(e -> emploee_man_add_btnActionPerformed(e));

        //---- emploee_man_del_btn ----
        emploee_man_del_btn.setText("\u5220\u9664");
        emploee_man_del_btn.addActionListener(e -> emploee_man_del_btnActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(393, 393, 393)
                                    .addComponent(label1))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(label2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(emploee_man_comb, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(emploee_man_tf, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(emploee_man_btn)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(emploee_man_add_btn)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(emploee_man_del_btn)))
                            .addGap(0, 27, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(emploee_man_comb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(emploee_man_tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(emploee_man_btn)
                        .addComponent(emploee_man_add_btn)
                        .addComponent(emploee_man_del_btn))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
                    .addGap(7, 7, 7))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JComboBox emploee_man_comb;
    private JTextField emploee_man_tf;
    private JButton emploee_man_btn;
    private JScrollPane scrollPane1;
    private JTable emploee_man_table;
    private JButton emploee_man_add_btn;
    private JButton emploee_man_del_btn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
