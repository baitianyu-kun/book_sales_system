/*
 * Created by JFormDesigner on Fri Jan 01 21:23:45 CST 2021
 */

package GUI.Login_GUI;

import Entity.Activity_Status;
import Entity.Find_Password_Info;
import Services.Login_Register_Ser.Login_Register_Service;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 2
 */
public class Find_Password extends JDialog {
    private Login_Register_Service login_register_service=new Login_Register_Service();
    public Find_Password(Window owner) {
        super(owner);
        initComponents();
    }
    public void UI_init()
    {
        setVisible(true);
        setResizable(false);
    }
    private void change_btnActionPerformed(ActionEvent e) {
        if (Psw_input_tf.getText().equals(Psw_again_input_tf.getText()))
        {
            int temp=login_register_service.Find_Password_Ser(new Find_Password_Info(Psw_input_tf.getText(),Certifi_input_tf.getText(),Account_input_tf.getText()));
            if (temp== Activity_Status.EMPLOYEE_NOT_EXIST)
                JOptionPane.showMessageDialog(this,"不存在该人！请重新填写！");
            else if (temp==Activity_Status.CHANGE_SUCCESS)
            {
                JOptionPane.showMessageDialog(this,"密码重置成功！");
                this.dispose();
                this.getOwner().setEnabled(true);
            }
            else
                JOptionPane.showMessageDialog(this,"密码重置失败！");
        }
        else {
            JOptionPane.showMessageDialog(this,"两次密码不一致！");
        }
    }
    private void thisWindowClosing(WindowEvent e) {
        this.dispose();
        this.getOwner().setEnabled(true);
    }
    private void back_btnActionPerformed(ActionEvent e) {
        this.dispose();
        this.getOwner().setEnabled(true);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        Certifi_input_tf = new JTextField();
        Psw_input_tf = new JTextField();
        Psw_again_input_tf = new JTextField();
        change_btn = new JButton();
        back_btn = new JButton();
        label4 = new JLabel();
        Account_input_tf = new JTextField();

        //======== this ========
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u8bf7\u8f93\u5165\u8eab\u4efd\u8bc1\u53f7\uff1a");

        //---- label2 ----
        label2.setText("\u8bf7\u8f93\u5165\u65b0\u5bc6\u7801\uff1a");

        //---- label3 ----
        label3.setText("\u8bf7\u518d\u6b21\u8f93\u5165\u65b0\u5bc6\u7801\uff1a");

        //---- change_btn ----
        change_btn.setText("\u66f4\u6539");
        change_btn.addActionListener(e -> change_btnActionPerformed(e));

        //---- back_btn ----
        back_btn.setText("\u8fd4\u56de");
        back_btn.addActionListener(e -> back_btnActionPerformed(e));

        //---- label4 ----
        label4.setText("\u8bf7\u8f93\u5165\u8d26\u53f7\uff1a");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(38, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label2)
                                        .addComponent(label1)
                                        .addComponent(label4))
                                    .addGap(23, 23, 23))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addComponent(label3)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(Certifi_input_tf)
                                .addComponent(Psw_input_tf)
                                .addComponent(Psw_again_input_tf, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                .addComponent(Account_input_tf, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(81, 81, 81)
                            .addComponent(change_btn, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(back_btn, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(Account_input_tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(Certifi_input_tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1))
                    .addGap(23, 23, 23)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(Psw_input_tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(22, 22, 22)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(Psw_again_input_tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(back_btn)
                        .addComponent(change_btn))
                    .addGap(16, 16, 16))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField Certifi_input_tf;
    private JTextField Psw_input_tf;
    private JTextField Psw_again_input_tf;
    private JButton change_btn;
    private JButton back_btn;
    private JLabel label4;
    private JTextField Account_input_tf;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
