package com.QuizApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener{
    JButton next,submit;
    public static int count = 0;
    public static int timer = 15;
    public static int ans_given = 0;
    public static int score = 0;
    JLabel questionNo,question;
    ButtonGroup bg;
    String username;
    JRadioButton option1,option2,option3,option4;

    String[][] q = new String[10][5];
    String[][] ans = new String[10][1];
    String[][] qa = new String[10][2];

    Quiz(String username){
        this.username = username;
        setBounds(150,50,1040,700);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("pic/quiztime.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0,0,1040,300);
        add(l1);

        questionNo = new JLabel("");
        questionNo.setFont(new Font("Times New Roman",Font.BOLD,20));
        questionNo.setBounds(100,350,60,40);
        add(questionNo);

        question = new JLabel("");
        question.setFont(new Font("Times New Roman",Font.BOLD,20));
        question.setBounds(130,350,900,40);
        add(question);

        q[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        q[0][1] = "JVM";
        q[0][2] = "JDB";
        q[0][3] = "JDK";
        q[0][4] = "JRE";

        q[1][0] = "What is the return type of the hashCode() method in the Object class?";
        q[1][1] = "int";
        q[1][2] = "Object";
        q[1][3] = "long";
        q[1][4] = "void";

        q[2][0] = "Which package contains the Random class?";
        q[2][1] = "java.util package";
        q[2][2] = "java.lang package";
        q[2][3] = "java.awt package";
        q[2][4] = "java.io package";

        q[3][0] = "An interface with no fields or methods is known as?";
        q[3][1] = "Runnable Interface";
        q[3][2] = "Abstract Interface";
        q[3][3] = "Marker Interface";
        q[3][4] = "CharSequence Interface";

        q[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        q[4][1] = "Stack";
        q[4][2] = "String memory";
        q[4][3] = "Random storage space";
        q[4][4] = "Heap memory";

        q[5][0] = "Which of the following is a marker interface?";
        q[5][1] = "Runnable interface";
        q[5][2] = "Remote interface";
        q[5][3] = "Readable interface";
        q[5][4] = "Result interface";

        q[6][0] = "Which keyword is used for accessing the features of a package?";
        q[6][1] = "import";
        q[6][2] = "package";
        q[6][3] = "extends";
        q[6][4] = "export";

        q[7][0] = "In java, jar stands for?";
        q[7][1] = "Java Archive Runner";
        q[7][2] = "Java Archive";
        q[7][3] = "Java Application Resource";
        q[7][4] = "Java Application Runner";

        q[8][0] = "Which of the following is a mutable class in java?";
        q[8][1] = "java.lang.StringBuilder";
        q[8][2] = "java.lang.Short";
        q[8][3] = "java.lang.Byte";
        q[8][4] = "java.lang.String";

        q[9][0] = "Which of the following option leads to the portability and security of Java?";
        q[9][1] = "Bytecode is executed by JVM";
        q[9][2] = "The applet makes the Java code secure and portable";
        q[9][3] = "Use of exception handling";
        q[9][4] = "Dynamic binding between objects";

        qa[0][1] = "JDB";
        qa[1][1] = "int";
        qa[2][1] = "java.util package";
        qa[3][1] = "Marker Interface";
        qa[4][1] = "Heap memory";
        qa[5][1] = "Remote interface";
        qa[6][1] = "import";
        qa[7][1] = "Java Archive";
        qa[8][1] = "java.lang.StringBuilder";
        qa[9][1] = "Bytecode is executed by JVM";

        option1 = new JRadioButton("");
        option1.setBounds(200,400,500,60);
        option1.setBackground(Color.white);
        option1.setFont(new Font("Times New Roman",Font.PLAIN , 18));
        add(option1);

        option2 = new JRadioButton("");
        option2.setBounds(200,440,500,60);
        option2.setBackground(Color.white);
        option2.setFont(new Font("Times New Roman",Font.PLAIN , 18));
        add(option2);

        option3 = new JRadioButton("");
        option3.setBounds(200,480,500,60);
        option3.setBackground(Color.white);
        option3.setFont(new Font("Times New Roman",Font.PLAIN , 18));
        add(option3);

        option4 = new JRadioButton("");
        option4.setBounds(200,520,500,60);
        option4.setBackground(Color.white);
        option4.setFont(new Font("Times New Roman",Font.PLAIN , 18));
        add(option4);

        bg = new ButtonGroup();
        bg.add(option1);
        bg.add(option2);
        bg.add(option3);
        bg.add(option4);

        next = new JButton("Next");
        next.addActionListener(this);
        next.setBounds(700,600,100,35);
        next.setFont(new Font("Times New Roman",Font.PLAIN,20));
        next.setBackground(Color.BLUE);
        next.setForeground(Color.white);
        add(next);

        submit = new JButton("Submit");
        submit.setEnabled(false);
        submit.setBounds(850,600,100,35);
        submit.addActionListener(this);
        submit.setFont(new Font("Times New Roman",Font.PLAIN,20));
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.white);
        add(submit);

        //setVisible(true);
        start(0);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==next){
            repaint();
            ans_given = 1;
            if(bg.getSelection() == null){
                ans[count][0]="";
            }else {
                ans[count][0] = bg.getSelection().getActionCommand();
            }
            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        }else if(actionEvent.getSource()==submit){
            ans_given = 1;
            if(bg.getSelection() == null){
                ans[count][0]="";
            }else {
                ans[count][0] = bg.getSelection().getActionCommand();
            }
            for (int i = 0; i < ans.length ; i++) {
                if(ans[i][0].equals(qa[i][1])){
                    score+=10;
                }else {
                    score+=0;
                }
            }
            //System.out.println(score);
            this.setVisible(false);
            new Score(username, score).setVisible(true);
        }
    }
    public void paint(Graphics g){
        super.paint(g);
        String time = "Time left - "+ timer +" sec";
        g.setColor(Color.RED);
        g.setFont(new Font("Times New Roman",Font.PLAIN,18));
        if(timer > 0){
            g.drawString(time,880,410);
        }else {
            g.drawString("time up!!",880,410);
        }
        timer--;

        try {
            Thread.sleep(1000);
            repaint();
        }catch (Exception e){
            e.printStackTrace();
        }
        if(ans_given == 1){
            ans_given = 0;
            timer = 15;
        }else if(timer < 0){
            timer = 15;
            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count == 9){
                if(bg.getSelection() == null){
                    ans[count][0]="";
                }else {
                    ans[count][0] = bg.getSelection().getActionCommand();
                }
                for (int i = 0; i < ans.length ; i++) {
                    if(ans[i][0].equals(qa[i][1])){
                        score+=10;
                    }else {
                        score+=0;
                    }
                }
                this.setVisible(false);
                new Score(username , score).setVisible(true);
                //.setvisible(true);
            }else {
                if(bg.getSelection() == null){
                    ans[count][0]="";
                }else {
                    ans[count][0] = bg.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }
    }
    private void start(int count) {
        questionNo.setText(""+ (count+1)+ ". ");
        question.setText(q[count][0]);
        option1.setLabel(q[count][1]);
        option1.setActionCommand(q[count][1]);
        option2.setLabel(q[count][2]);
        option2.setActionCommand(q[count][2]);
        option3.setLabel(q[count][3]);
        option3.setActionCommand(q[count][3]);
        option4.setLabel(q[count][4]);
        option4.setActionCommand(q[count][4]);
        bg.clearSelection();
    }
    public static void main(String[] args) {
        // quizPage qp = new quizPage();
        Quiz q = new Quiz("");
        q.setVisible(true);
        q.setResizable(false);

    }
}
//class quizPage extends JFrame implements ActionListener {
//    JButton next,submit;
//    public static int count = 0;
//    public static int timer = 15;
//    public static int ans_given = 0;
//    public static int score = 0;
//    JLabel questionNo,question;
//    ButtonGroup bg;
//    String username;
//    JRadioButton option1,option2,option3,option4;
//    String[][] q = new String[10][5];
//    String[][] ans = new String[10][1];
//    String[][] qa = new String[10][2];

// public void quiz(String username){
//        this.username = username;
//        setBounds(150,50,1040,700);
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("pic/quiztime.jpg"));
//        JLabel l1 = new JLabel(i1);
//        l1.setBounds(0,0,1040,300);
//        add(l1);
//
//        questionNo = new JLabel("");
//        questionNo.setFont(new Font("Times New Roman",Font.BOLD,20));
//        questionNo.setBounds(100,350,60,40);
//        add(questionNo);
//
//        question = new JLabel("");
//        question.setFont(new Font("Times New Roman",Font.BOLD,20));
//        question.setBounds(130,350,900,40);
//        add(question);
//
//        q[0][0] = "Which is used to find and fix bugs in the Java programs.?";
//        q[0][1] = "JVM";
//        q[0][2] = "JDB";
//        q[0][3] = "JDK";
//        q[0][4] = "JRE";
//
//        q[1][0] = "What is the return type of the hashCode() method in the Object class?";
//        q[1][1] = "int";
//        q[1][2] = "Object";
//        q[1][3] = "long";
//        q[1][4] = "void";
//
//        q[2][0] = "Which package contains the Random class?";
//        q[2][1] = "java.util package";
//        q[2][2] = "java.lang package";
//        q[2][3] = "java.awt package";
//        q[2][4] = "java.io package";
//
//        q[3][0] = "An interface with no fields or methods is known as?";
//        q[3][1] = "Runnable Interface";
//        q[3][2] = "Abstract Interface";
//        q[3][3] = "Marker Interface";
//        q[3][4] = "CharSequence Interface";
//
//        q[4][0] = "In which memory a String is stored, when we create a string using new operator?";
//        q[4][1] = "Stack";
//        q[4][2] = "String memory";
//        q[4][3] = "Random storage space";
//        q[4][4] = "Heap memory";
//
//        q[5][0] = "Which of the following is a marker interface?";
//        q[5][1] = "Runnable interface";
//        q[5][2] = "Remote interface";
//        q[5][3] = "Readable interface";
//        q[5][4] = "Result interface";
//
//        q[6][0] = "Which keyword is used for accessing the features of a package?";
//        q[6][1] = "import";
//        q[6][2] = "package";
//        q[6][3] = "extends";
//        q[6][4] = "export";
//
//        q[7][0] = "In java, jar stands for?";
//        q[7][1] = "Java Archive Runner";
//        q[7][2] = "Java Archive";
//        q[7][3] = "Java Application Resource";
//        q[7][4] = "Java Application Runner";
//
//        q[8][0] = "Which of the following is a mutable class in java?";
//        q[8][1] = "java.lang.StringBuilder";
//        q[8][2] = "java.lang.Short";
//        q[8][3] = "java.lang.Byte";
//        q[8][4] = "java.lang.String";
//
//        q[9][0] = "Which of the following option leads to the portability and security of Java?";
//        q[9][1] = "Bytecode is executed by JVM";
//        q[9][2] = "The applet makes the Java code secure and portable";
//        q[9][3] = "Use of exception handling";
//        q[9][4] = "Dynamic binding between objects";
//
//        qa[0][1] = "JDB";
//        qa[1][1] = "int";
//        qa[2][1] = "java.util package";
//        qa[3][1] = "Marker Interface";
//        qa[4][1] = "Heap memory";
//        qa[5][1] = "Remote interface";
//        qa[6][1] = "import";
//        qa[7][1] = "Java Archive";
//        qa[8][1] = "java.lang.StringBuilder";
//        qa[9][1] = "Bytecode is executed by JVM";
//
//        option1 = new JRadioButton("");
//        option1.setBounds(200,400,500,60);
//        option1.setBackground(Color.white);
//        option1.setFont(new Font("Times New Roman",Font.PLAIN , 18));
//        add(option1);
//
//        option2 = new JRadioButton("");
//        option2.setBounds(200,440,500,60);
//        option2.setBackground(Color.white);
//        option2.setFont(new Font("Times New Roman",Font.PLAIN , 18));
//        add(option2);
//
//        option3 = new JRadioButton("");
//        option3.setBounds(200,480,500,60);
//        option3.setBackground(Color.white);
//        option3.setFont(new Font("Times New Roman",Font.PLAIN , 18));
//        add(option3);
//
//        option4 = new JRadioButton("");
//        option4.setBounds(200,520,500,60);
//        option4.setBackground(Color.white);
//        option4.setFont(new Font("Times New Roman",Font.PLAIN , 18));
//        add(option4);
//
//        bg = new ButtonGroup();
//        bg.add(option1);
//        bg.add(option2);
//        bg.add(option3);
//        bg.add(option4);
//
//        next = new JButton("Next");
//        next.addActionListener(this);
//        next.setBounds(700,600,100,35);
//        next.setFont(new Font("Times New Roman",Font.PLAIN,20));
//        next.setBackground(Color.BLUE);
//        next.setForeground(Color.white);
//        add(next);
//
//        submit = new JButton("Submit");
//        submit.setEnabled(false);
//        submit.setBounds(850,600,100,35);
//        submit.addActionListener(this);
//        submit.setFont(new Font("Times New Roman",Font.PLAIN,20));
//        submit.setBackground(Color.BLUE);
//        submit.setForeground(Color.white);
//        add(submit);
//
//        //setVisible(true);
//        start(0);
//    }
//
//    private void start(int count) {
//        questionNo.setText(""+ (count+1)+ ". ");
//        question.setText(q[count][0]);
//        option1.setLabel(q[count][1]);
//        option1.setActionCommand(q[count][1]);
//        option2.setLabel(q[count][2]);
//        option2.setActionCommand(q[count][2]);
//        option3.setLabel(q[count][3]);
//        option3.setActionCommand(q[count][3]);
//        option4.setLabel(q[count][4]);
//        option4.setActionCommand(q[count][4]);
//        bg.clearSelection();
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent actionEvent) {
//        if(actionEvent.getSource()==next){
//            repaint();
//            ans_given = 1;
//            if(bg.getSelection() == null){
//                ans[count][0]="";
//            }else {
//                ans[count][0] = bg.getSelection().getActionCommand();
//            }
//            if(count == 8){
//                next.setEnabled(false);
//                submit.setEnabled(true);
//            }
//            count++;
//            start(count);
//        }else if(actionEvent.getSource()==submit){
//            ans_given = 1;
//            if(bg.getSelection() == null){
//                ans[count][0]="";
//            }else {
//                ans[count][0] = bg.getSelection().getActionCommand();
//            }
//            for (int i = 0; i < ans.length ; i++) {
//                if(ans[i][0].equals(qa[i][1])){
//                    score+=10;
//                }else {
//                    score+=0;
//                }
//            }
//            System.out.println(score);
//            this.setVisible(false);
//            new score(username, score).setVisible(true);
//        }
//    }
//    public void paint(Graphics g){
//        super.paint(g);
//        String time = "Time left - "+ timer +" sec";
//        g.setColor(Color.RED);
//        g.setFont(new Font("Times New Roman",Font.PLAIN,18));
//        if(timer > 0){
//            g.drawString(time,880,410);
//        }else {
//            g.drawString("time up!!",880,410);
//        }
//        timer--;
//
//        try {
//            Thread.sleep(1000);
//            repaint();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        if(ans_given == 1){
//            ans_given = 0;
//            timer = 15;
//        }else if(timer < 0){
//            timer = 15;
//            if(count == 8){
//                next.setEnabled(false);
//                submit.setEnabled(true);
//            }
//            if(count == 9){
//                if(bg.getSelection() == null){
//                    ans[count][0]="";
//                }else {
//                    ans[count][0] = bg.getSelection().getActionCommand();
//                }
//                for (int i = 0; i < ans.length ; i++) {
//                        if(ans[i][0].equals(qa[i][1])){
//                            score+=10;
//                        }else {
//                            score+=0;
//                        }
//                }
//                this.setVisible(false);
//                new score(username , score).setVisible(true);
//            }else {
//                if(bg.getSelection() == null){
//                    ans[count][0]="";
//                }else {
//                    ans[count][0] = bg.getSelection().getActionCommand();
//                }
//                count++;
//                start(count);
//            }
//        }
//    }
//}
