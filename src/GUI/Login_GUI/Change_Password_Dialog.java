/*
 * Created by JFormDesigner on Sat Jan 02 09:26:41 CST 2021
 */

package GUI.Login_GUI;

import Entity.Activity_Status;
import Entity.User_Info;
import Services.Login_Register_Ser.Login_Register_Service;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 2
 */
public class Change_Password_Dialog extends JDialog {
    private Login_Register_Service login_register_service=new Login_Register_Service();
    private String account_input;
    public Change_Password_Dialog(Window owner) {
        super(owner);
        initComponents();
    }
    public void UI_init(String account)
    {
        account_input=account;
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    private void chang_psw_btnActionPerformed(ActionEvent e) {
        User_Info user_info=new User_Info();
        user_info.setAccount(account_input);
        user_info.setOld_Password(old_psw_tf.getText());
        user_info.setNew_Password(new_psw_tf.getText());
        int temp=login_register_service.Change_Password_Ser(user_info);
        if (temp== Activity_Status.CHANGE_SUCCESS)
        {
            JOptionPane.showMessageDialog(this,"更改成功！！");
            this.dispose();
            this.getOwner().setEnabled(true);
        }
        else if (temp==Activity_Status.NOT_EQUALS)
            JOptionPane.showMessageDialog(this,"旧密码与账户不匹配！请重新输入！");
        else
            JOptionPane.showMessageDialog(this,"更改失败！！");
    }

    private void thisWindowClosing(WindowEvent e) {
        this.dispose();
        this.getOwner().setEnabled(true);
    }

    private void cancel_psw_btnActionPerformed(ActionEvent e) {
        this.dispose();
        this.getOwner().setEnabled(true);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        old_psw_tf = new JTextField();
        new_psw_tf = new JTextField();
        chang_psw_btn = new JButton();
        cancel_psw_btn = new JButton();

        //======== this ========
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u8bf7\u8f93\u5165\u65e7\u5bc6\u7801\uff1a");

        //---- label2 ----
        label2.setText("\u8bf7\u8f93\u5165\u65b0\u5bc6\u7801\uff1a");

        //---- chang_psw_btn ----
        chang_psw_btn.setText("\u66f4\u6539");
        chang_psw_btn.addActionListener(e -> chang_psw_btnActionPerformed(e));

        //---- cancel_psw_btn ----
        cancel_psw_btn.setText("\u53d6\u6d88");
        cancel_psw_btn.addActionListener(e -> cancel_psw_btnActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(new_psw_tf))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(old_psw_tf, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(32, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(115, Short.MAX_VALUE)
                    .addComponent(chang_psw_btn)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(cancel_psw_btn)
                    .addGap(111, 111, 111))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(75, 75, 75)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(old_psw_tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(new_psw_tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(chang_psw_btn)
                        .addComponent(cancel_psw_btn))
                    .addGap(36, 36, 36))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField old_psw_tf;
    private JTextField new_psw_tf;
    private JButton chang_psw_btn;
    private JButton cancel_psw_btn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
