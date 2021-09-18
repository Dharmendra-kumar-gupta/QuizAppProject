package com.QuizApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApp extends JFrame implements ActionListener {

    JButton b1,b2;
    JTextField t1;
    QuizApp(){
        setBounds(200, 150, 1000, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("pic/quiz.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0,0,700,500);
        add(l1);
        JLabel l2 = new JLabel("Quiz Game");
        l2.setFont(new Font("Z003",Font.BOLD,40));
        l2.setBounds(730,50,300,45);
        l2.setForeground(Color.BLUE);
        add(l2);

        JLabel l3 = new JLabel("Name");
        l3.setFont(new Font("Rainbow",Font.BOLD,18));
        l3.setBounds(810,150,300,20);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(750,190,200,25);
        t1.setFont(new Font("Times New Roman",Font.PLAIN,18));
        add(t1);

        b1 = new JButton("Rules");
        b1.setBounds(750,250,80,35);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Exit");
        b2.setBounds(870,250,80,35);
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        setResizable(false);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            String name = t1.getText();
            this.setVisible(false);
            Rules r = new Rules(name);
        }else {
            System.exit(0);
        }
    }
    public static void main(String[] args) {

        QuizApp qa = new QuizApp();
    }


}
