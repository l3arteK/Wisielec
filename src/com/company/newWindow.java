package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class newWindow implements ActionListener {
    JFrame frame2 = new JFrame();
    JLabel napis = new JLabel();
    JButton[] buttons = new JButton[3];
    newWindow(boolean win){
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(600,200);
        frame2.getContentPane().setBackground(new Color(75,102,20));
        frame2.setVisible(true);
        frame2.setResizable(false);
        frame2.setLayout(new FlowLayout(FlowLayout.CENTER,50,20));


        for(int i=0;i<3;i++){
            buttons[i] = new JButton();
            buttons[i].addActionListener(this);
            buttons[i].setPreferredSize(new Dimension(100,50));
            buttons[i].setFont(new Font(null,Font.BOLD,14));
            buttons[i].setFocusable(false);
        }
        buttons[0].setText("Od nowa");
        buttons[1].setText("Wyjście");
        buttons[2].setText("Menu");



        napis.setHorizontalAlignment(JLabel.CENTER);
        napis.setPreferredSize(new Dimension(600,50));
        if(win) {
            napis.setText("Udalo Ci się! Co chcesz zrobić teraz?");
        }
        else{
            napis.setText("Nie udało się! Może spróbujesz jeszcze raz?!");
        }
        napis.setFont(new Font(null,Font.BOLD,20));
        napis.setForeground(new Color(0,0,0));
        frame2.add(napis);
        frame2.add(buttons[0]);
        frame2.add(buttons[1]);
        frame2.add(buttons[2]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttons[0]){
            Wisielec.restart();
            frame2.dispose();
        }else if(e.getSource()==buttons[1]){
            frame2.dispose();
            Wisielec.frame.dispose();
        }else if(e.getSource()==buttons[2]){
            Wisielec.frame.dispose();
            new MenuWindow();
            frame2.dispose();
        }

        }

    }

