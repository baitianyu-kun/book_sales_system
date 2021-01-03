/*
 * Created by JFormDesigner on Mon Dec 21 09:53:50 CST 2020
 */

package GUI.Register_GUI;

import Entity.Activity_Status;
import Entity.User_Info;
import Services.Login_Register_Ser.Login_Register_Service;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author 2
 */
public class Register_GUI extends JFrame {
    private Login_Register_Service login_register_service=new Login_Register_Service();
    public Register_GUI() {
        initComponents();
    }

    public void UI_init()
    {
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(2);
    }

    private void registe_buttonActionPerformed(ActionEvent e) {
        String employee_number=employee_number_textfield.getText();
        String password=String.valueOf(register_password_pswfield.getPassword());
        String password_again=String.valueOf(register_pswensure_pswfield.getPassword());
        if (password.equals(password_again))
        {
            int temp=login_register_service.Register_Ser(new User_Info(employee_number,password,employee_number));
            if (temp== Activity_Status.REGISTER_SUCCESS)
            {
                JOptionPane.showMessageDialog(this,"注册成功！账号即为员工号！");
                this.dispose();
            }
            else if (temp==Activity_Status.REGISTER_ADMIN_USER_SUCCESS)
            {
                JOptionPane.showMessageDialog(null,"注册成功！账号为：“admin+员工号”！");
                this.dispose();
            }
            else if (temp==Activity_Status.EMPLOYEE_NOT_EXIST)
                JOptionPane.showMessageDialog(null,"不存在该员工！请检查员工号信息！");
            else if (temp==Activity_Status.ACCOUNT_EXIST)
                JOptionPane.showMessageDialog(null,"已经注册过了！");
            else
                JOptionPane.showMessageDialog(null,"注册失败！");
        }
        else {
            JOptionPane.showMessageDialog(null,"两次密码不一致！");
        }
    }

    private void back_buttonActionPerformed(ActionEvent e) {
        this.dispose();
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        employee_number_textfield = new JTextField();
        register_password_pswfield = new JPasswordField();
        register_pswensure_pswfield = new JPasswordField();
        label4 = new JLabel();
        buttonBar = new JPanel();
        registe_button = new JButton();
        back_button = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- label1 ----
                label1.setText("\u5458  \u5de5  \u53f7\uff1a");

                //---- label2 ----
                label2.setText("\u5bc6         \u7801\uff1a");

                //---- label3 ----
                label3.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");

                //---- label4 ----
                label4.setText("\u6b22\u8fce\u6ce8\u518c\u56fe\u4e66\u8fdb\u5b58\u9500\u7cfb\u7edf");
                label4.setFont(new Font(Font.DIALOG, Font.PLAIN, 26));

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(label3)
                                .addComponent(label2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(employee_number_textfield, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
                                .addComponent(register_pswensure_pswfield, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
                                .addComponent(register_password_pswfield))
                            .addContainerGap(45, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(109, Short.MAX_VALUE)
                            .addComponent(label4)
                            .addGap(99, 99, 99))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(label4)
                            .addGap(18, 18, 18)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(employee_number_textfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addComponent(register_password_pswfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(16, 16, 16)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addComponent(register_pswensure_pswfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(3, Short.MAX_VALUE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- registe_button ----
                registe_button.setText("\u6ce8\u518c");
                registe_button.addActionListener(e -> registe_buttonActionPerformed(e));
                buttonBar.add(registe_button, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- back_button ----
                back_button.setText("\u8fd4\u56de");
                back_button.addActionListener(e -> back_buttonActionPerformed(e));
                buttonBar.add(back_button, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField employee_number_textfield;
    private JPasswordField register_password_pswfield;
    private JPasswordField register_pswensure_pswfield;
    private JLabel label4;
    private JPanel buttonBar;
    private JButton registe_button;
    private JButton back_button;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
