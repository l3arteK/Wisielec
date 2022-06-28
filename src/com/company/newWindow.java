package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class newWindow implements ActionListener {
    JFrame frame2 = new JFrame();
    JLabel napis = new JLabel();
    JButton[] buttons = new JButton[2];
    newWindow(boolean win){
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(400,400);
        frame2.getContentPane().setBackground(new Color(75,102,20));
        frame2.setVisible(true);
        frame2.setResizable(false);
        frame2.setLayout(new FlowLayout());



        napis.setHorizontalAlignment(JLabel.CENTER);
        if(win) {
            napis.setText("Udalo Ci się! Co chcesz zrobić teraz?");
        }
        else{
            napis.setText("Nie udało się! Może spróbujesz jeszcze raz?!");
        }
        napis.setFont(new Font(null,Font.PLAIN,16));
        napis.setForeground(new Color(0,0,0));
        frame2.add(napis);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
