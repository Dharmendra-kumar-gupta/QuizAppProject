package com.QuizApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame implements ActionListener{
    public static void main(String[] args) {
        new Score("",0).setVisible(true);
    }
    Score(String username, int score){

        setBounds(350,150,600,500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("pic/score.png"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0,0,400,250);
        add(l1);

        JLabel l2 = new JLabel("Thank you"+username+" for taking this test..");
        l2.setBounds(80,0,500,80);
        l2.setFont(new Font("Times New Roman",Font.ITALIC,35));
        add(l2);

        JLabel l3 = new JLabel("Your Score is "+score);
        l3.setBounds(150,0,500,600);
        l3.setFont(new Font("Times New Roman",Font.ITALIC,40));
        l3.setForeground(new Color(199,21,133));
        add(l3);

        JButton b1 = new JButton("Play Again");
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(200,350,150,50);
        add(b1);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.setVisible(false);
        new QuizApp().setVisible(true);
    }
}

// class score extends JFrame implements ActionListener {

//    public void myScore(String username , int score){
//
//        setBounds(350,150,600,500);
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("pic/score.png"));
//        JLabel l1 = new JLabel(i1);
//        l1.setBounds(0,0,400,250);
//        add(l1);
//
//        JLabel l2 = new JLabel("Thank you"+username+" for taking this test..");
//        l2.setBounds(80,0,500,80);
//        l2.setFont(new Font("Times New Roman",Font.ITALIC,35));
//        add(l2);
//
//        JLabel l3 = new JLabel("Your Score is "+score);
//        l3.setBounds(150,0,500,600);
//        l3.setFont(new Font("Times New Roman",Font.ITALIC,40));
//        l3.setForeground(new Color(199,21,133));
//        add(l3);
//
//        JButton b1 = new JButton("Play Again");
//        b1.setBackground(Color.BLUE);
//        b1.setForeground(Color.WHITE);
//        b1.setBounds(200,350,150,50);
//        add(b1);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent actionEvent) {
//        this.setVisible(false);
//        new QuizApp().setVisible(true);
//    }
//}
