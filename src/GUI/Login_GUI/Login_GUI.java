/*
 * Created by JFormDesigner on Mon Dec 21 09:50:14 CST 2020
 */

package GUI.Login_GUI;

import java.awt.*;
import Entity.Activity_Status;
import Entity.User_Info;
import GUI.Main_GUI.Main_GUI;
import GUI.Register_GUI.Register_GUI;
import Services.Login_Register_Ser.Login_Register_Service;
import Utils.Dates;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 2
 */
public class Login_GUI extends JFrame {

    private Login_Register_Service login_register_service=new Login_Register_Service();
    public Login_GUI() {
        initComponents();
    }
    public void UI_init()
    {
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(3);
    }
    public User_Info User_info_init()//用来记录登录信息
    {
        User_Info user_info=new User_Info();
        user_info.setAccount(address_textfield.getText());
        user_info.setLogin_in_Time(Dates.getLocalDate_AND_Time());
        user_info.setLogin_Date(Dates.getLocalDate());
        if (address_textfield.getText().substring(0,5).equals("admin"))
            user_info.setIdentity("管理员");
        else
            user_info.setIdentity("普通用户");

        return user_info;
    }
    private void login_buttonActionPerformed(ActionEvent e) {
        if (login_register_service.Login_Ser(new User_Info(address_textfield.getText(),String.valueOf(password_textfield.getPassword())))
        == Activity_Status.LOGIN_SUCCESS)
        {
            JOptionPane.showMessageDialog(this,"登录成功！");
            new Main_GUI().UI_init(address_textfield.getText(),User_info_init());//传入用户名和登录信息
            this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(this,"登录失败！请检查账号密码！");
        }
    }
    private void register_buttonActionPerformed(ActionEvent e) {
        new Register_GUI().UI_init();
    }
    private void forget_psw_lableMouseClicked(MouseEvent e) {
        new Find_Password_Dialog(this).UI_init();
        this.setEnabled(false);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        login_button = new JButton();
        register_button = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        address_textfield = new JTextField();
        password_textfield = new JPasswordField();
        label3 = new JLabel();
        forget_psw_lable = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //---- login_button ----
        login_button.setText("\u767b\u5f55");
        login_button.addActionListener(e -> login_buttonActionPerformed(e));

        //---- register_button ----
        register_button.setText("\u6ce8\u518c");
        register_button.addActionListener(e -> register_buttonActionPerformed(e));

        //---- label1 ----
        label1.setText("\u8d26\u53f7\uff1a");

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");

        //---- label3 ----
        label3.setText("\u6b22\u8fce\u767b\u5f55\u56fe\u4e66\u8fdb\u5b58\u9500\u7cfb\u7edf");
        label3.setFont(new Font(Font.DIALOG, Font.PLAIN, 26));

        //---- forget_psw_lable ----
        forget_psw_lable.setText("\u5fd8\u8bb0\u5bc6\u7801\uff1f");
        forget_psw_lable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                forget_psw_lableMouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(77, 77, 77)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addGap(18, 18, 18)
                                    .addComponent(address_textfield, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label2)
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(login_button, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(register_button, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                            .addGap(41, 41, 41))
                                        .addComponent(password_textfield, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)))
                                .addComponent(label3, GroupLayout.Alignment.TRAILING)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(215, 215, 215)
                            .addComponent(forget_psw_lable)))
                    .addContainerGap(100, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addGap(33, 33, 33)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(address_textfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(password_textfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(register_button)
                        .addComponent(login_button))
                    .addGap(18, 18, 18)
                    .addComponent(forget_psw_lable)
                    .addGap(33, 33, 33))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton login_button;
    private JButton register_button;
    private JLabel label1;
    private JLabel label2;
    private JTextField address_textfield;
    private JPasswordField password_textfield;
    private JLabel label3;
    private JLabel forget_psw_lable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
