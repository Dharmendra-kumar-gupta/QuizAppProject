package com.QuizApp;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener {

    JLabel l2,l1;
    JButton b1,b2;
    String username;
    Rules(String username){
        this.username=username;
        setBounds(350,150,700,500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        l1 = new JLabel("Welcome " + username + " in java Quiz ");
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Times New Roman",Font.BOLD,38));
        l1.setBounds(50,20,700,40);
        add(l1);

        l2 = new JLabel("");
        l2.setBounds(30,100,600,300);
        l2.setFont(new Font("Times New Roman",Font.ITALIC,16));
        l2.setText(
                "<html>"+
                        "1. This quiz for beginner Student"+"<br><be>"+
                        "2. No negative marking in wrong answer if you are done wrong"+"<br><br>"+
                        "3. You have time limit for each question"+"<br><br>"+
                        "<html>"
        );
        add(l2);
        b1 = new JButton("Back");
        b1.setBounds(200,400,80,35);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Start");
        b2.setBounds(400,400,80,35);
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        //Rules r = new Rules("");
        new Rules("");
        //new Rules();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==b1){
            this.setVisible(false);
            new QuizApp().setVisible(true);
        }else if(actionEvent.getSource()==b2){
            this.setVisible(false);
            //new quizPage(username).setVisible(true);
            new Quiz(username).setVisible(true);

        }
    }
}

