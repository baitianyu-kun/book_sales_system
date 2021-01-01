/*
 * Created by JFormDesigner on Mon Dec 21 09:38:20 CST 2020
 */

package GUI.Main_GUI;

import com.sun.tools.javac.Main;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 2
 */
public class Main_GUI extends JFrame {
    public Main_GUI() {
        initComponents();
    }

    public static void main(String[] args) {
        new Main_GUI().setVisible(true);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        panel1 = new JPanel();
        ruku_manage_button = new JButton();
        xiaoshou_manage_button = new JButton();
        kucun_manage_button = new JButton();
        yonghu_manage_button = new JButton();
        label2 = new JLabel();
        login_account_lable = new JLabel();
        login_out_button = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u6b22\u8fce\u4f7f\u7528\u56fe\u4e66\u8fdb\u5b58\u9500\u7cfb\u7edf");
        label1.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 48));

        //======== panel1 ========
        {

            //---- ruku_manage_button ----
            ruku_manage_button.setText("\u5165\u5e93\u7ba1\u7406");
            ruku_manage_button.setFont(new Font(Font.DIALOG, Font.PLAIN, 28));

            //---- xiaoshou_manage_button ----
            xiaoshou_manage_button.setText("\u9500\u552e\u7ba1\u7406");
            xiaoshou_manage_button.setFont(new Font(Font.DIALOG, Font.PLAIN, 28));

            //---- kucun_manage_button ----
            kucun_manage_button.setText("\u5e93\u5b58\u7ba1\u7406");
            kucun_manage_button.setFont(new Font(Font.DIALOG, Font.PLAIN, 28));

            //---- yonghu_manage_button ----
            yonghu_manage_button.setText("\u7528\u6237\u7ba1\u7406");
            yonghu_manage_button.setFont(new Font(Font.DIALOG, Font.PLAIN, 28));

            //---- label2 ----
            label2.setText("\u5c0a\u656c\u7684\u7528\u6237\uff1a");
            label2.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));

            //---- login_account_lable ----
            login_account_lable.setText("text");
            login_account_lable.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));

            //---- login_out_button ----
            login_out_button.setText("\u9000\u51fa\u767b\u5f55");

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(ruku_manage_button, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(xiaoshou_manage_button, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kucun_manage_button, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(yonghu_manage_button, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
                        .addComponent(label2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(login_account_lable, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(login_out_button)
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(ruku_manage_button, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(xiaoshou_manage_button, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kucun_manage_button, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(yonghu_manage_button, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label2)
                                    .addComponent(login_out_button)
                                    .addComponent(login_account_lable))))
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
                    .addContainerGap(404, Short.MAX_VALUE)
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
    private JButton ruku_manage_button;
    private JButton xiaoshou_manage_button;
    private JButton kucun_manage_button;
    private JButton yonghu_manage_button;
    private JLabel label2;
    private JLabel login_account_lable;
    private JButton login_out_button;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}