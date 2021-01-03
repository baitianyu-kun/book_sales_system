/*
 * Created by JFormDesigner on Sun Jan 03 10:05:11 CST 2021
 */

package GUI.Employees_Manage_GUI;

import java.awt.event.*;

import Entity.Activity_Status;
import Entity.Employees_Information;
import Services.Employee_Manage_Ser.Employee_Manage_Ser;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 2
 */
public class Employee_Add_Dialog extends JDialog {
    private Employee_Manage_Ser employee_manage_ser=new Employee_Manage_Ser();
    private Employees_Information employees_information=new Employees_Information();
    public Employee_Add_Dialog(Window owner) {
        super(owner);
        initComponents();
    }

    public void UI_init()
    {
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }
    public String getEmployee_Number()
    {
        String number= employee_manage_ser.Return_Last_Employee_Number_Ser();
        int number_int=Integer.parseInt(number);
        number_int=number_int+1;
        return String.valueOf(number_int);
    }
    private void emplo_add_add_btnActionPerformed(ActionEvent e) {
        employees_information.setEmployee_Number(getEmployee_Number());
        employees_information.setName(emplo_add_name.getText());
        employees_information.setSex(emplo_add_sex.getText());
        employees_information.setJob(emplo_add_job.getText());
        employees_information.setPhone_Number(emplo_add_phone.getText());
        employees_information.setCertificate_ID_Number(emplo_add_certifi_ID.getText());
        employees_information.setType_Of_Identity(emplo_add_identity.getText());
        if (employee_manage_ser.Add_Employee_Information_Ser(employees_information)== Activity_Status.INSERT_SUCCESS)
        {
            JOptionPane.showMessageDialog(this,"添加成功！");
            this.getOwner().setEnabled(true);
            this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(this,"添加失败！");
        }
    }

    private void thisWindowClosing(WindowEvent e) {
        this.getOwner().setEnabled(true);
        this.dispose();
    }

    private void emplo_add_cancel_btnActionPerformed(ActionEvent e) {
        this.getOwner().setEnabled(true);
        this.dispose();
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        emplo_add_name = new JTextField();
        label2 = new JLabel();
        emplo_add_sex = new JTextField();
        label3 = new JLabel();
        emplo_add_job = new JTextField();
        label4 = new JLabel();
        emplo_add_identity = new JTextField();
        label5 = new JLabel();
        emplo_add_phone = new JTextField();
        label6 = new JLabel();
        emplo_add_certifi_ID = new JTextField();
        emplo_add_add_btn = new JButton();
        emplo_add_cancel_btn = new JButton();
        label7 = new JLabel();

        //======== this ========
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u5458\u5de5\u59d3\u540d\uff1a");

        //---- label2 ----
        label2.setText("\u6027\u522b\uff1a");

        //---- label3 ----
        label3.setText("\u804c\u4f4d\uff1a");

        //---- label4 ----
        label4.setText("\u8eab\u4efd\uff1a");

        //---- label5 ----
        label5.setText("\u624b\u673a\u53f7\uff1a");

        //---- label6 ----
        label6.setText("\u8eab\u4efd\u8bc1\u53f7\uff1a");

        //---- emplo_add_add_btn ----
        emplo_add_add_btn.setText("\u6dfb\u52a0");
        emplo_add_add_btn.addActionListener(e -> emplo_add_add_btnActionPerformed(e));

        //---- emplo_add_cancel_btn ----
        emplo_add_cancel_btn.setText("\u53d6\u6d88");
        emplo_add_cancel_btn.addActionListener(e -> emplo_add_cancel_btnActionPerformed(e));

        //---- label7 ----
        label7.setText("*\u8eab\u4efd\u53ea\u6709\u201cadmin\u201d\u548c\u201cordinary\u201d");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label1)
                                        .addComponent(label2)
                                        .addComponent(label3)
                                        .addComponent(label4)
                                        .addComponent(label5))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(emplo_add_name, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                        .addComponent(emplo_add_sex, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                        .addComponent(emplo_add_job, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                        .addComponent(emplo_add_identity, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                        .addComponent(emplo_add_phone, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label6)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(emplo_add_certifi_ID, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)))
                            .addContainerGap(46, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label7)
                                    .addContainerGap(145, Short.MAX_VALUE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(emplo_add_add_btn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(emplo_add_cancel_btn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(39, 39, 39))))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(emplo_add_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(emplo_add_sex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(emplo_add_job, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(emplo_add_identity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(emplo_add_phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label6)
                        .addComponent(emplo_add_certifi_ID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(label7)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(emplo_add_cancel_btn)
                        .addComponent(emplo_add_add_btn))
                    .addContainerGap(15, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField emplo_add_name;
    private JLabel label2;
    private JTextField emplo_add_sex;
    private JLabel label3;
    private JTextField emplo_add_job;
    private JLabel label4;
    private JTextField emplo_add_identity;
    private JLabel label5;
    private JTextField emplo_add_phone;
    private JLabel label6;
    private JTextField emplo_add_certifi_ID;
    private JButton emplo_add_add_btn;
    private JButton emplo_add_cancel_btn;
    private JLabel label7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
