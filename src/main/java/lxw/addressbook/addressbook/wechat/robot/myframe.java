package lxw.addressbook.addressbook.wechat.robot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myframe extends JFrame {
    private JTextArea jTextAreaofShow;
    private JTextArea jTextAreaofSend;
    private JScrollPane scrollPaneofShow;//滚动框
    private JScrollPane scrollPaneofSend;
    private JPanel panel;
    private JButton jButton;
    private Test robot;
    public  myframe(String title,int x,int y,int w,int h) {
        super(title);
        robot=new Test();//初始化机器人
        //为send部分设置面板
        panel=new JPanel();
        panel.setLayout(new FlowLayout());
        jButton=new JButton("发送");
        jButton.addActionListener(new buttonlistener());//为button设置监听器
        jTextAreaofSend=new JTextArea();
        //设置send文本框的大小  2行20列
        jTextAreaofSend.setRows(2);
        jTextAreaofSend.setColumns(50);
        jTextAreaofShow=new JTextArea();
        jTextAreaofShow.setRows(10);
        jTextAreaofShow.setColumns(50);
        jTextAreaofShow.setEditable(false);//设置show文本框不可编辑
        //为两个文本框设置滚轮
        scrollPaneofSend=new JScrollPane(jTextAreaofSend);
        scrollPaneofShow=new JScrollPane(jTextAreaofShow);
        //send文本框和按钮添加到面板
        panel.add(scrollPaneofSend);
        panel.add(jButton);
        add(scrollPaneofShow,BorderLayout.CENTER);
        add(panel,BorderLayout.SOUTH);
        setBounds(x,y,w,h);//设置边界大小
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置关闭事件
    }
    public class buttonlistener implements ActionListener{//监听器
        @Override
        public void actionPerformed(ActionEvent e) {
            String message=jTextAreaofSend.getText();
            if(message!=null){
                String result=Test.chart(message);
                String show=jTextAreaofShow.getText();
                StringBuilder showbuider=new StringBuilder(show);
                showbuider.append("我说:"+message+"\n");
                showbuider.append("小管家:"+result+"\n");
                jTextAreaofShow.setText(showbuider.toString());
                jTextAreaofSend.setText("");
            }
        }
    }
}

