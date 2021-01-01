/*
 * Created by JFormDesigner on Wed Dec 30 11:54:24 CST 2020
 */

package GUI.Put_In_Storage_GUI;

import Entity.Activity_Status;
import Entity.Book_Information;
import Services.Put_In_Storage_Ser.In_Storage_Service;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 2
 */
public class In_Storage_Add_Dialog extends JDialog {
    private In_Storage_Service in_storage_service=new In_Storage_Service();
    public In_Storage_Add_Dialog(Window owner) {
        super(owner);
        initComponents();
    }
    public void UI_init()
    {
        setVisible(true);
        setResizable(false);
    }
    private void instorage_add_add_buttonActionPerformed(ActionEvent e) {
        Book_Information book_information=new Book_Information();
        book_information.setBook_Name(book_name_tf.getText());
        book_information.setPublisher(publisher_tf.getText());
        book_information.setStock(book_number_tf.getText());
        book_information.setBook_Bar_code(book_bar_tf.getText());
        book_information.setUnit_Price(book_price_tf.getText());
        book_information.setType(book_type_tf.getText());
        book_information.setIn_Storage_Time(in_storage_time_tf.getText());
        if (in_storage_service.In_Storage_Add_Ser(book_information)== Activity_Status.INSERT_SUCCESS)
        {
            JOptionPane.showMessageDialog(this,"添加成功！");
            this.dispose();
            this.getOwner().setEnabled(true);//用来返回父窗口
        }
        else {
            JOptionPane.showMessageDialog(this,"添加失败！请检查是否全部输入正确！");
        }

    }

    private void instorage_add_back_buttonActionPerformed(ActionEvent e) {
        this.dispose();
        this.getOwner().setEnabled(true);
    }
    private void thisWindowClosing(WindowEvent e) {//设置窗口关闭时候返回父窗口
        this.dispose();
        this.getOwner().setEnabled(true);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        book_name_tf = new JTextField();
        publisher_tf = new JTextField();
        book_number_tf = new JTextField();
        label5 = new JLabel();
        label6 = new JLabel();
        book_price_tf = new JTextField();
        book_bar_tf = new JTextField();
        label7 = new JLabel();
        label8 = new JLabel();
        book_type_tf = new JTextField();
        instorage_add_add_button = new JButton();
        instorage_add_back_button = new JButton();
        label2 = new JLabel();
        in_storage_time_tf = new JTextField();
        label9 = new JLabel();

        //======== this ========
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u8bf7\u5728\u4e0b\u65b9\u8f93\u5165\u56fe\u4e66\u4fe1\u606f\uff1a");
        label1.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));

        //---- label3 ----
        label3.setText("\u56fe\u4e66\u540d\u79f0\uff1a");

        //---- label4 ----
        label4.setText("\u51fa\u7248\u793e\u540d\u79f0\uff1a");

        //---- label5 ----
        label5.setText("\u56fe\u4e66\u6570\u91cf\uff1a");

        //---- label6 ----
        label6.setText("\u56fe\u4e66\u5355\u4ef7\uff1a");

        //---- label7 ----
        label7.setText("\u6761\u7801\u4fe1\u606f\uff1a");

        //---- label8 ----
        label8.setText("\u56fe\u4e66\u79cd\u7c7b\uff1a");

        //---- instorage_add_add_button ----
        instorage_add_add_button.setText("\u6dfb\u52a0");
        instorage_add_add_button.addActionListener(e -> instorage_add_add_buttonActionPerformed(e));

        //---- instorage_add_back_button ----
        instorage_add_back_button.setText("\u8fd4\u56de");
        instorage_add_back_button.addActionListener(e -> instorage_add_back_buttonActionPerformed(e));

        //---- label2 ----
        label2.setText("\u5165\u5e93\u65f6\u95f4\uff1a");

        //---- label9 ----
        label9.setText("*\u5165\u5e93\u65e5\u671f\u8bf7\u6309\u716720200510\u7c7b\u4f3c\u683c\u5f0f\u586b\u5199");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(label9)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                    .addComponent(instorage_add_add_button)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(instorage_add_back_button)
                    .addGap(21, 21, 21))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap(182, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label5)
                                .addComponent(label7)
                                .addComponent(label8)
                                .addComponent(label2)
                                .addComponent(label4)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label3)
                                        .addComponent(label6))))
                            .addGap(64, 64, 64))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(book_name_tf, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                        .addComponent(publisher_tf, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                        .addComponent(in_storage_time_tf, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                        .addComponent(book_type_tf, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                        .addComponent(book_bar_tf, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                        .addComponent(book_price_tf, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                        .addComponent(book_number_tf, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
                    .addGap(155, 155, 155))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3)
                                .addComponent(book_name_tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(12, 12, 12)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4)
                                .addComponent(publisher_tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(8, 8, 8)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                .addComponent(book_number_tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(10, 10, 10)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label6)
                                .addComponent(book_price_tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(22, 22, 22)
                            .addComponent(label7))
                        .addComponent(book_bar_tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label8)
                        .addComponent(book_type_tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(11, 11, 11)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(in_storage_time_tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label9)
                        .addComponent(instorage_add_add_button)
                        .addComponent(instorage_add_back_button))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label3;
    private JLabel label4;
    private JTextField book_name_tf;
    private JTextField publisher_tf;
    private JTextField book_number_tf;
    private JLabel label5;
    private JLabel label6;
    private JTextField book_price_tf;
    private JTextField book_bar_tf;
    private JLabel label7;
    private JLabel label8;
    private JTextField book_type_tf;
    private JButton instorage_add_add_button;
    private JButton instorage_add_back_button;
    private JLabel label2;
    private JTextField in_storage_time_tf;
    private JLabel label9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
