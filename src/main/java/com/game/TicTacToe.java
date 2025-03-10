package com.game;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[25];
    boolean player1_turns;

    TicTacToe(){
    // adding the frame to the code
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(650,650);
    frame.getContentPane().setBackground(Color.BLACK);
    // setting the up the layout style i chose the borderlayout
    frame.setLayout(new BorderLayout());
    // adding the textfield to the top of the frame first 
    //setting the background color of the textfield
    textField.setBackground(Color.BLACK);
    // setting the text in the textField
    textField.setText("TicTacToe");
    //setting the font color and the font
    textField.setForeground(Color.BLACK);
    textField.setFont(new Font("Comic Sans MS",Font.ITALIC,50));
    textField.setHorizontalAlignment(JLabel.CENTER);

    
    //because the textfield is in the panel we have to make the panel first and then add the textfield into the panel later 
    panel.setLayout(new BorderLayout());
    panel.setBounds(0,0,250,70);

    // set up the button panel fist 
    button_panel.setLayout(new GridLayout(5,5));
    button_panel.setBackground(Color.GRAY);


    // now it's time to add the buttons 
    for(int i = 0; i < 25; i++){
        buttons[i] = new JButton();
        button_panel.add(buttons[i]);
        buttons[i].setFont(new Font("Comic Sans MS",Font.ITALIC,50));
        buttons[i].setBackground(Color.BLACK);
        buttons[i].setFocusable(false);
    }
    
    panel.add(textField);
    frame.add(panel,BorderLayout.NORTH);
    frame.add(button_panel);
    frame.setVisible(true);

    first_turn();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 25; i++){
            if (e.getSource() == buttons[i]) {
                if (player1_turns) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.white);
                        buttons[i].setText("X");
                        player1_turns = false;
                        textField.setText("O turns");
                        check();
                    }
                }
                else{
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.white);
                        buttons[i].setText("O");
                        player1_turns = true;
                        textField.setText("X turns");
                        check();
                }
            }
        }
    }
}
    public void first_turn(){
        
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (random.nextInt(2)==0) {
            player1_turns = true;
            textField.setText("X turn");
        }
        else{
            player1_turns = false;
            textField.setText("O turns");
        }
    }
    public void check(){

    }
    public void xWIn(){

    }
    public void oWIn(){

    }
}
