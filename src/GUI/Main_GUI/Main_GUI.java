/*
 * Created by JFormDesigner on Mon Dec 21 09:38:20 CST 2020
 */

package GUI.Main_GUI;

import java.awt.event.*;

import Entity.User_Info;
import GUI.Login_GUI.Change_Password_Dialog;
import GUI.Login_GUI.Login_GUI;
import GUI.Put_In_Storage_GUI.In_Storage_GUI;
import GUI.Sales_GUI.Sales_GUI;
import GUI.Storage_GUI.Storage_GUI;
import GUI.System_Manage_GUI.System_Manage_GUI;
import Services.Login_Register_Ser.Login_Register_Service;
import Utils.Dates;
import com.sun.tools.javac.Main;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 2
 */
public class Main_GUI extends JFrame {
    private Login_Register_Service login_register_service=new Login_Register_Service();
    private String User_Name;
    private User_Info user_info;

    public Main_GUI() {
        initComponents();
    }

    public void UI_init(String User_Name, User_Info user_info)//传入主界面用户名和登录时候的信息
    {
        this.User_Name=User_Name;
        this.user_info=user_info;
        Lable_init();
        Button_init();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(3);
    }
    public void Lable_init()
    {
        login_account_lable.setText(User_Name);
    }
    public void Button_init()
    {
        if (User_Name.substring(0,5).equals("admin"))
            System_manage_button.setEnabled(true);
        else
            System_manage_button.setEnabled(false);
    }
    //事件
    private void InStorage_manage_buttonActionPerformed(ActionEvent e) {
        new In_Storage_GUI().UI_init();
    }
    private void Sales_manage_buttonActionPerformed(ActionEvent e) {
        new Sales_GUI().UI_init();
    }
    private void Storage_manage_buttonActionPerformed(ActionEvent e) {
        new Storage_GUI().UI_init();
    }
    private void login_out_buttonActionPerformed(ActionEvent e) {//按下退出登录时候也记录登录信息
        user_info.setLogin_out_Time(Dates.getLocalDate_AND_Time());
        login_register_service.Login_Log_Create_Ser(user_info);
        this.dispose();
        new Login_GUI().UI_init();
    }
    private void change_psw_buttonActionPerformed(ActionEvent e) {
        new Change_Password_Dialog(this).UI_init(User_Name);
        this.setEnabled(false);
    }

    private void System_manage_buttonActionPerformed(ActionEvent e) {
        new System_Manage_GUI().UI_init();
    }

    private void thisWindowClosing(WindowEvent e) {//当窗口关闭时候添加登录信息
        user_info.setLogin_out_Time(Dates.getLocalDate_AND_Time());
        login_register_service.Login_Log_Create_Ser(user_info);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        panel1 = new JPanel();
        InStorage_manage_button = new JButton();
        Sales_manage_button = new JButton();
        Storage_manage_button = new JButton();
        label2 = new JLabel();
        login_account_lable = new JLabel();
        login_out_button = new JButton();
        change_psw_button = new JButton();
        System_manage_button = new JButton();

        //======== this ========
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u6b22\u8fce\u4f7f\u7528\u56fe\u4e66\u8fdb\u5b58\u9500\u7cfb\u7edf");
        label1.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 48));

        //======== panel1 ========
        {

            //---- InStorage_manage_button ----
            InStorage_manage_button.setText("\u5165\u5e93\u7ba1\u7406");
            InStorage_manage_button.setFont(new Font(Font.DIALOG, Font.PLAIN, 28));
            InStorage_manage_button.addActionListener(e -> InStorage_manage_buttonActionPerformed(e));

            //---- Sales_manage_button ----
            Sales_manage_button.setText("\u9500\u552e\u7ba1\u7406");
            Sales_manage_button.setFont(new Font(Font.DIALOG, Font.PLAIN, 28));
            Sales_manage_button.addActionListener(e -> Sales_manage_buttonActionPerformed(e));

            //---- Storage_manage_button ----
            Storage_manage_button.setText("\u5e93\u5b58\u7ba1\u7406");
            Storage_manage_button.setFont(new Font(Font.DIALOG, Font.PLAIN, 28));
            Storage_manage_button.addActionListener(e -> Storage_manage_buttonActionPerformed(e));

            //---- label2 ----
            label2.setText("\u5c0a\u656c\u7684\u7528\u6237\uff1a");
            label2.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));

            //---- login_account_lable ----
            login_account_lable.setText("text");
            login_account_lable.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));

            //---- login_out_button ----
            login_out_button.setText("\u9000\u51fa\u767b\u5f55");
            login_out_button.addActionListener(e -> login_out_buttonActionPerformed(e));

            //---- change_psw_button ----
            change_psw_button.setText("\u4fee\u6539\u5bc6\u7801");
            change_psw_button.addActionListener(e -> change_psw_buttonActionPerformed(e));

            //---- System_manage_button ----
            System_manage_button.setText("\u7cfb\u7edf\u7ba1\u7406");
            System_manage_button.setFont(new Font(Font.DIALOG, Font.PLAIN, 28));
            System_manage_button.addActionListener(e -> System_manage_buttonActionPerformed(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(InStorage_manage_button, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Sales_manage_button, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Storage_manage_button, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(System_manage_button, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
                        .addComponent(label2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(login_account_lable, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(change_psw_button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(login_out_button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(InStorage_manage_button, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Sales_manage_button, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Storage_manage_button, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(System_manage_button, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label2)
                                    .addComponent(login_out_button)
                                    .addComponent(login_account_lable))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(change_psw_button)))
                        .addContainerGap(21, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(50, 404, Short.MAX_VALUE)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 554, GroupLayout.PREFERRED_SIZE)
                    .addGap(390, 390, 390))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(55, 55, 55)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(263, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JPanel panel1;
    private JButton InStorage_manage_button;
    private JButton Sales_manage_button;
    private JButton Storage_manage_button;
    private JLabel label2;
    private JLabel login_account_lable;
    private JButton login_out_button;
    private JButton change_psw_button;
    private JButton System_manage_button;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
