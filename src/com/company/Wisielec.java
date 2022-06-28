package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class Wisielec implements ActionListener {

    JFrame frame = new JFrame();
    JLabel result = new JLabel();
    JLabel life_label = new JLabel();
    String haslo = "KO";
    JButton[] buttons = new JButton[3];
    JPanel buttons_panel = new JPanel();
    char[] zgad = new char[haslo.length()];
    char[] odp = new char[3];
    int n;
    int k = zgad.length;
    int life = 3;
    Wisielec()
    {
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(1200,600);
      frame.getContentPane().setBackground(new Color(75,102,20));
      frame.setLayout(new FlowLayout());
      frame.setVisible(true);
      frame.setResizable(false);

      life_label.setHorizontalAlignment(JLabel.CENTER);
      life_label.setBackground(new Color(75,102,20));
      life_label.setFont(new Font("Agency FB",Font.PLAIN,50));
      life_label.setPreferredSize(new Dimension(1100,100));


      result.setForeground(new Color(0,0,0));
      result.setBackground(new Color(75,102,20));
      result.setFont(new Font("American Typewriter",Font.BOLD,90));
      result.setHorizontalAlignment(JLabel.CENTER);
      result.setOpaque(true);
      result.setPreferredSize(new Dimension(1100,200));

      for(int i=0;i<haslo.length();i++){
          zgad[i]='_';
      }

    for(int i=0;i<3;i++){
        buttons[i] = new JButton();
        buttons_panel.add(buttons[i]);
        buttons[i].setFocusable(false);
        buttons[i].addActionListener(this);
        buttons[i].setFont(new Font("American Typewriter",Font.BOLD,75));
    }

      buttons_panel.setLayout(new GridLayout(1,3,30,0));
      buttons_panel.setPreferredSize(new Dimension(1100,200));
      buttons_panel.setBackground(new Color(75,102,20));



      generowanie_odp();
      frame.add(life_label);
      frame.add(result);
      frame.add(buttons_panel);
      show();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<3;i++){
            if(e.getSource() == buttons[i]){
                if(buttons[i].getText().charAt(0)==odp[n]){
                    zgad[find(odp[n])] = odp[n];
                    show();
                    if(k!=1){
                    generowanie_odp();
                    k-=1;
                    System.out.println(k);
                    }else{
                        new newWindow(true);
                    }
                }else if(life>1)
                {
                    life-=1;
                    generowanie_odp();
                    show();
                }else{
                    life-=1;
                    show();
                    new newWindow(false);
                }
            }
        }
    }
    public void show()
    {
        String wyswietlane;
        result.setText("");
        for(int i=0;i<haslo.length();i++) {
            wyswietlane = result.getText();
            result.setText(wyswietlane+zgad[i]+" ");
        }
        life_label.setText("Lifes: "+life);

    }
    public void generowanie_odp()
    {
        Random rand = new Random();
         n = rand.nextInt(3);
        for(int i=0;i<3;i++){
            if(i==n){
                odp[n] = haslo.charAt(rand.nextInt(haslo.length()));
                for(int j=0;j<zgad.length;j++){
                    if(odp[n]==zgad[j]){
                        i-=1;
                        break;
                    }else{
                        buttons[i].setText(Character.toString(odp[i]));
                    }
                }
            }
            else if(i>=0){
                odp[i] = (char)(rand.nextInt(26)+65);
                if(find(odp[i])!=-1 || odp[i]==odp[n]){
                    i-=1;
                }else{
                    buttons[i].setText(Character.toString(odp[i]));
                }
            }


        }
    }
    public int find(char x){
        for(int i=0;i<haslo.length();i++){
            if(x==haslo.charAt(i)){
                return i;
            }
        }
        return -1;
    }
}