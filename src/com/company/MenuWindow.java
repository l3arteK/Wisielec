package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class MenuWindow extends JFrame implements ActionListener {

    JLabel[] napis = new JLabel[3];
    JTextField[] dane = new JTextField[2];
    JButton button = new JButton();

    MenuWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.getContentPane().setBackground(new Color(75, 102, 20));
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 30));
        this.setVisible(true);
        this.setResizable(false);

        for (int i = 0; i < 3; i++) {
            napis[i] = new JLabel();
            napis[i].setHorizontalAlignment(JLabel.CENTER);
            napis[i].setFont(new Font("Myanmar Text", Font.BOLD, 20));
            napis[i].setPreferredSize(new Dimension(600, 30));
            napis[i].setForeground(Color.black);
        }
        napis[0].setFont(new Font(null, Font.BOLD, 42));
        napis[0].setText("Ustawienia gry");
        napis[0].setPreferredSize(new Dimension(600,100));
        this.add(napis[0]);
        napis[1].setText("Podaj haslo do zgadniecia:");
        napis[2].setText("Podaj ilosc zyc:");

        for (int i = 1; i < 3; i++) {
            this.add(napis[i]);
            dane[i - 1] = new JTextField();
            dane[i - 1].setPreferredSize(new Dimension(400,50));
            dane[i -1].setFont(new Font(null, Font.PLAIN, 16));
            this.add(dane[i - 1]);

        }

        button.setText("Start");
        button.addActionListener(this);
        this.add(button);


        this.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            new Wisielec(dane[0].getText().toUpperCase(Locale.ROOT),Integer.parseInt(dane[1].getText()));
            this.dispose();
        }

    }
}
