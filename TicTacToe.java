/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamescenter;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 *
 *  TicTacToe Game 
 *  The winner get 6 points.
 * 
 */
public class TicTacToe implements ActionListener {

     Random random = new Random();
    JFrame frame = new JFrame();
     JPanel title_panel = new JPanel();
     JPanel btn_panel = new JPanel();
     JLabel textfield = new JLabel();
     JButton[] buttons = new JButton[9];
     boolean player1_turn;
    static String name1;//
    static String name2;//
    static boolean Xwin = false, Owin = false;
    
    /**
     * Constructor
     */
     TicTacToe(String name1, String name2) {
        
        UIManager.put("Button.background", new Color(255, 255, 255));

       this.name1 = name1;
       this.name2 = name2;


        explainTheGame();
       // name1 = name1;
       // name2 = name2;
        
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setTitle("IT College Arabic");
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(125, 125, 125));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("IT College");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 100, 800);

        btn_panel.setLayout(new GridLayout(3, 3));
        btn_panel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            btn_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.EAST);
        frame.add(btn_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn \n" + name2);/////
                        check();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X turn \n" + name1);////
                        check();
                    }
                }
            }
        }
    }
    
    /**
     * 
     */
    public void firstTurn() {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        player1_turn = true;
        textfield.setText("X turn \n" + name1);

    }

    public void check() {
        int count = 0;
        //check X win conditions
        if ((buttons[0].getText() == "X")
                && (buttons[1].getText() == "X")
                && (buttons[2].getText() == "X")) {
            xWins(0, 1, 2);
        }
        if ((buttons[3].getText() == "X")
                && (buttons[4].getText() == "X")
                && (buttons[5].getText() == "X")) {
            xWins(3, 4, 5);
        }
        if ((buttons[6].getText() == "X")
                && (buttons[7].getText() == "X")
                && (buttons[8].getText() == "X")) {
            xWins(6, 7, 8);
        }
        if ((buttons[0].getText() == "X")
                && (buttons[3].getText() == "X")
                && (buttons[6].getText() == "X")) {
            xWins(0, 3, 6);
        }
        if ((buttons[1].getText() == "X")
                && (buttons[4].getText() == "X")
                && (buttons[7].getText() == "X")) {
            xWins(1, 4, 7);
        }
        if ((buttons[2].getText() == "X")
                && (buttons[5].getText() == "X")
                && (buttons[8].getText() == "X")) {
            xWins(2, 5, 8);
        }
        if ((buttons[0].getText() == "X")
                && (buttons[4].getText() == "X")
                && (buttons[8].getText() == "X")) {
            xWins(0, 4, 8);
        }
        if ((buttons[2].getText() == "X")
                && (buttons[4].getText() == "X")
                && (buttons[6].getText() == "X")) {
            xWins(2, 4, 6);
        }
        //check O win conditions
        if ((buttons[0].getText() == "O")
                && (buttons[1].getText() == "O")
                && (buttons[2].getText() == "O")) {
            oWins(0, 1, 2);
        }
        if ((buttons[3].getText() == "O")
                && (buttons[4].getText() == "O")
                && (buttons[5].getText() == "O")) {
            oWins(3, 4, 5);
        }
        if ((buttons[6].getText() == "O")
                && (buttons[7].getText() == "O")
                && (buttons[8].getText() == "O")) {
            oWins(6, 7, 8);
        }
        if ((buttons[0].getText() == "O")
                && (buttons[3].getText() == "O")
                && (buttons[6].getText() == "O")) {
            oWins(0, 3, 6);
        }
        if ((buttons[1].getText() == "O")
                && (buttons[4].getText() == "O")
                && (buttons[7].getText() == "O")) {
            oWins(1, 4, 7);
        }
        if ((buttons[2].getText() == "O")
                && (buttons[5].getText() == "O")
                && (buttons[8].getText() == "O")) {
            oWins(2, 5, 8);
        }
        if ((buttons[0].getText() == "O")
                && (buttons[4].getText() == "O")
                && (buttons[8].getText() == "O")) {
            oWins(0, 4, 8);
        }
        if ((buttons[2].getText() == "O")
                && (buttons[4].getText() == "O")
                && (buttons[6].getText() == "O")) {
            oWins(2, 4, 6);
        } //check draw if draw end the game.
        else {
            for (int i = 0; i < 9; i++) {
                if (buttons[i].getText() == "X" || buttons[i].getText() == "O") {
                    count++;
                }
                if (count == 9) {
                    Xwin = false;
                    Owin = false;
                    checkWinner();
                    Playing.theEnd();
                }
            }
        }
    }

    /**
     * if x wins end the game
     * @param a button
     * @param b button
     * @param c button
     */
    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.yellow);
        buttons[b].setBackground(Color.yellow);
        buttons[c].setBackground(Color.yellow);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins " + name1);
        Owin = false;
        Xwin = true;
        checkWinner();
        Playing.theEnd();
        
    }
    /**
     * if o wins end the game
     * @param a button
     * @param b button
     * @param c button
     */
    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.yellow);
        buttons[b].setBackground(Color.yellow);
        buttons[c].setBackground(Color.yellow);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O wins  " + name2);
        Owin = true;
        Xwin = false;
        checkWinner();
        Playing.theEnd();
        
    }

    /**
     * This method return the Winner of the game.
     * @return the name of winner
     */
    public static String checkWinner() {
        //int points = 0;
        
        if (Xwin) {
            return name1;
            
        } else if (Owin) {            
            return name2;
            
        } else {
            return "draw";
        }
    }

    /**
     * This method give simple explanation of the game
     */
    public void explainTheGame() {
        JOptionPane.showMessageDialog(null,
                "In this game you we will play against each other. One will be X"
                + "and other will be O.\n"
                + "There are 9 places to put the mark in.\n"
                + "The first Player get 3 of his/her mark in row(up,"
                + " down, across orr diagonlly) is winner.\n"
                + "The winner get 6 points.\n",
                "TicTacToe", 2);
    }
}

