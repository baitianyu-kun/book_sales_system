/*
 * Created by JFormDesigner on Mon Dec 21 09:50:14 CST 2020
 */

package GUI.Login_GUI;

import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 2
 */
public class Login_GUI extends JFrame {
    public Login_GUI() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        login_button = new JButton();
        register_button = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        address_textfield = new JTextField();
        password_passwordfield = new JPasswordField();
        label3 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //---- login_button ----
        login_button.setText("\u767b\u5f55");

        //---- register_button ----
        register_button.setText("\u6ce8\u518c");

        //---- label1 ----
        label1.setText("\u8d26\u53f7\uff1a");

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");

        //---- label3 ----
        label3.setText("\u6b22\u8fce\u767b\u5f55\u56fe\u4e66\u8fdb\u5b58\u9500\u7cfb\u7edf");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label2)
                            .addGap(18, 18, 18)
                            .addComponent(password_passwordfield, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(18, 18, 18)
                            .addComponent(address_textfield, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(85, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(149, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(login_button, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
                        .addComponent(register_button, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)))
                    .addGap(133, 133, 133))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(address_textfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(password_passwordfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                    .addComponent(login_button)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(register_button)
                    .addGap(28, 28, 28))
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
    private JPasswordField password_passwordfield;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
