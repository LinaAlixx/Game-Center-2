/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamescenter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

/**
 *
 *  Rock-Paper-Scissors Game.
 *  The winner get 2 points and if it is a draw each player get one point.
 */
public class RockPaperScissors extends JFrame {

    private ImageIcon icon, RImage, PImage, SImage;
    private JButton start, rock, paper, scissors, end;
    private JLabel RLabel, PLabel, SLabel, resultLsbel, resultLsbel2;
    private JPanel resultPanel;
    private int theSelected;
    private static int points = 0;

    /**
     * Constructor
     */
    public RockPaperScissors() {

        //set points to 0 and call motheds that will display explaintion of the 
        //game and display the beging of the game.
        points = 0;
        explainTheGame();
        gameName();
    }

    /**
     * This method give simple explanation of the game
     */
    public void explainTheGame() {
        //cahnge the background color of JOpationpane.
        UIManager.put("OptionPane.background", new Color(255, 102, 178));
        UIManager.put("Panel.background", new Color(255, 255, 255));
        UIManager.put("Button.background", new Color(153, 205, 255));

        //display simple explanation of the game.
        JOptionPane.showMessageDialog(null,
                "In this game choose rock, paper or scissors."
                + " Also, the program will choose one of them at random.\n"
                + "Rock cruhes scissors, "
                + "scissor cut paper and paper covers rock.\n"
                + "You will get one point if you win",
                "RockPaperSicssor", 2);
    }

    /**
     * This method show the name of the game
     */
    public void gameName() {
        //set the title.
        setTitle("RockPaperScissors");

        //specify action for the close button.
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //set the size of the window.
        setSize(300, 300);

        //set grid layout manger.
        setLayout(new BorderLayout());

        //create paneles.
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();

        //create labels.
        JLabel label1 = new JLabel("Welcome ");
        JLabel label2 = new JLabel("To ");
        JLabel label3 = new JLabel("Rock ");
        JLabel label4 = new JLabel("Paper ");
        JLabel label5 = new JLabel("Scissors ");
        JLabel label6 = new JLabel("GAME! ");

        //change background color of panels.
        panel1.setBackground(new Color(255, 128, 0));
        panel2.setBackground(new Color(255, 255, 0));
        panel3.setBackground(Color.red);
        panel4.setBackground(new Color(128, 255, 0));
        panel5.setBackground(new Color(51, 153, 255));
        panel6.setBackground(new Color(153, 51, 255));

        //change fonts of labels.
        label1.setFont(new Font("Arial", Font.PLAIN, 26));
        label2.setFont(new Font("Arial", Font.PLAIN, 26));
        label3.setFont(new Font("Arial", Font.PLAIN, 26));
        label4.setFont(new Font("Arial", Font.PLAIN, 26));
        label5.setFont(new Font("Arial", Font.PLAIN, 26));
        label6.setFont(new Font("Arial", Font.PLAIN, 26));

        //change color of labels.
        label1.setForeground(new Color(0, 0, 204));
        label2.setForeground(new Color(255, 128, 0));
        label3.setForeground(new Color(255, 255, 255));
        label4.setForeground(new Color(255, 51, 255));
        label5.setForeground(new Color(255, 0, 0));
        label6.setForeground(new Color(0, 0, 0));

        //add labels to panels.
        panel1.add(label1);
        panel2.add(label2);
        panel3.add(label3);
        panel4.add(label4);
        panel5.add(label5);
        panel6.add(label6);

        //set layout manger to p1 panel.
        p1.setLayout(new GridLayout(3, 2));

        //add panels to window.
        p1.add(panel1);
        p1.add(panel2);
        p1.add(panel3);
        p1.add(panel4);
        p1.add(panel5);
        p1.add(panel6);

        //create start button.
        start = new JButton("START");
        start.addActionListener(new bActionListener());
        p2.add(start);

        //add p1 and p2 panels to frame.
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);

        //make the window display in the center of screen.
        setLocationRelativeTo(null);

        //set icon for the window.
        icon = new ImageIcon("m1.png");
        setIconImage(icon.getImage());

        //display the window.
        setVisible(true);

    }

    public void game() {
        //create JFrame.
        JFrame jf1 = new JFrame();

        //set layout manger.
        jf1.setLayout(new GridLayout(1, 3));

        //creat buttons and labels and set these images as background for the buttons.
        RImage = new ImageIcon("r1.png");
        PImage = new ImageIcon("p.png");
        SImage = new ImageIcon("s.png");

        rock = new JButton(RImage);
        paper = new JButton(PImage);
        scissors = new JButton(SImage);

        RLabel = new JLabel(RImage);
        PLabel = new JLabel(PImage);
        SLabel = new JLabel(SImage);

        //add buttons to label.
        RLabel.add(rock);
        PLabel.add(paper);
        SLabel.add(scissors);

        //add action listener to each button.
        rock.addActionListener(new buttonActionListener());
        paper.addActionListener(new buttonActionListener());
        scissors.addActionListener(new buttonActionListener());

        //add buttons.
        jf1.add(rock);
        jf1.add(paper);
        jf1.add(scissors);

        //set the title.
        jf1.setTitle("RockPaperScissors");

        //specify action for the close button.
        jf1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //set size of the window.
        jf1.setSize(300, 300);

        //make the window display in the center of screen.
        jf1.setLocationRelativeTo(null);

        //set icon for the window.
        icon = new ImageIcon("m1.png");
        jf1.setIconImage(icon.getImage());

        //display the window.
        jf1.setVisible(true);

    }

     /**
     * private inner class that handles the event that is generated when the
     * user click one of the three buttons.
     */
    private class buttonActionListener extends JFrame implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == rock) {
                theSelected = 0;
            } else if (e.getSource() == paper) {
                theSelected = 1;
            } else if (e.getSource() == scissors) {
                theSelected = 2;

            }
            theResult();

        }

    }

    public void theResult() {
        // make the program choose at random rock, paper or scissors.
        Random rand = new Random();
        JFrame jf2 = new JFrame();

        //specify action for the close button.
        jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set icon for the window.
        icon = new ImageIcon("m1.png");
        jf2.setIconImage(icon.getImage());

        //create end button.
        end = new JButton("End");

        //compare between the program and the player choose and display reslt
        switch (theSelected) {
            case 0:
                if (rand.nextInt(2) == 0) {

                    points = 1;
                    //set the title.
                    jf2.setTitle("Draw");

                    //set size of the window.
                    jf2.setSize(350, 350);

                    //create label.
                    resultLsbel = new JLabel("DRAW!!", SwingConstants.CENTER);
                    resultLsbel.setFont(new Font("Arial", Font.PLAIN, 24));
                    resultLsbel.setForeground(new Color(102, 0, 51));

                    //set Layout manger.
                    jf2.setLayout(new BorderLayout());

                    //add action listener to end button.
                    end.addActionListener(new bActionListener());

                    //add componemts to the window.
                    jf2.add(RLabel, BorderLayout.EAST);
                    jf2.add(resultLsbel, BorderLayout.CENTER);
                    JLabel RLabel2 = new JLabel(RImage);
                    jf2.add(RLabel2, BorderLayout.WEST);
                    jf2.add(end, BorderLayout.SOUTH);

                    //make the window display in the center of screen.
                    jf2.setLocationRelativeTo(null);

                    //display the window.
                    jf2.setVisible(true);
                } else if (rand.nextInt(2) == 1) {
                    points = 0;
                    //set the title.
                    jf2.setTitle("Lose");

                    //set size of the window.
                    jf2.setSize(350, 350);

                    //create panel.
                    resultPanel = new JPanel(new GridLayout(2, 1));

                    //create label.
                    resultLsbel = new JLabel("You Lose!!", SwingConstants.CENTER);
                    resultLsbel2 = new JLabel("Paper beats Rock", SwingConstants.CENTER);
                    resultLsbel.setFont(new Font("Arial", Font.PLAIN, 24));
                    resultLsbel.setForeground(new Color(102, 0, 51));
                    resultLsbel2.setFont(new Font("Arial", Font.PLAIN, 18));
                    resultLsbel2.setForeground(new Color(0, 0, 255));

                    //add labels to panel.
                    resultPanel.add(resultLsbel);
                    resultPanel.add(resultLsbel2);

                    //set Layout manger.
                    jf2.setLayout(new BorderLayout());

                    //add action listener to end button.
                    end.addActionListener(new bActionListener());

                    //add componemts to the window.
                    jf2.add(PLabel, BorderLayout.EAST);
                    jf2.add(resultPanel, BorderLayout.CENTER);
                    jf2.add(RLabel, BorderLayout.WEST);
                    jf2.add(end, BorderLayout.SOUTH);

                    //make the window display in the center of screen.
                    jf2.setLocationRelativeTo(null);

                    //display the window.
                    jf2.setVisible(true);
                } else {
                    points = 2;

                    //set the title.
                    jf2.setTitle("Win");

                    //set size of the window.
                    jf2.setSize(350, 350);

                    //create panel.
                    resultPanel = new JPanel(new GridLayout(2, 1));

                    //create label.
                    resultLsbel = new JLabel("You WIN (^_^)", SwingConstants.CENTER);
                    resultLsbel2 = new JLabel("Rock beats Scissors", SwingConstants.CENTER);
                    resultLsbel.setFont(new Font("Arial", Font.PLAIN, 24));
                    resultLsbel.setForeground(new Color(102, 0, 51));
                    resultLsbel2.setFont(new Font("Arial", Font.PLAIN, 18));
                    resultLsbel2.setForeground(new Color(0, 0, 255));

                    //add labels to panel.
                    resultPanel.add(resultLsbel);
                    resultPanel.add(resultLsbel2);

                    //set Layout manger.
                    jf2.setLayout(new BorderLayout());

                    //add action listener to end button.
                    end.addActionListener(new bActionListener());

                    //add componemts to the window.
                    jf2.add(SLabel, BorderLayout.EAST);
                    jf2.add(resultPanel, BorderLayout.CENTER);
                    jf2.add(RLabel, BorderLayout.WEST);
                    jf2.add(end, BorderLayout.SOUTH);

                    //make the window display in the center of screen.
                    jf2.setLocationRelativeTo(null);

                    //display the window.
                    jf2.setVisible(true);
                }
                break;
            case 1:
                if (rand.nextInt(2) == 0) {
                    points = 2;
                    //set the title.
                    jf2.setTitle("Win");

                    //set size of the window.
                    jf2.setSize(350, 350);

                    //create panel.
                    resultPanel = new JPanel(new GridLayout(2, 1));

                    //create label.
                    resultLsbel = new JLabel("You WIN (^_^)", SwingConstants.CENTER);
                    resultLsbel2 = new JLabel("Paper beats Rock", SwingConstants.CENTER);
                    resultLsbel.setFont(new Font("Arial", Font.PLAIN, 24));
                    resultLsbel.setForeground(new Color(102, 0, 51));
                    resultLsbel2.setFont(new Font("Arial", Font.PLAIN, 18));
                    resultLsbel2.setForeground(new Color(0, 0, 255));

                    //add labels to panel.
                    resultPanel.add(resultLsbel);
                    resultPanel.add(resultLsbel2);

                    //set Layout manger.
                    jf2.setLayout(new BorderLayout());

                    //add action listener to end button.
                    end.addActionListener(new bActionListener());

                    //add componemts to the window.
                    jf2.add(RLabel, BorderLayout.EAST);
                    jf2.add(resultPanel, BorderLayout.CENTER);
                    jf2.add(PLabel, BorderLayout.WEST);
                    jf2.add(end, BorderLayout.SOUTH);

                    //make the window display in the center of screen.
                    jf2.setLocationRelativeTo(null);

                    //display the window.
                    jf2.setVisible(true);

                } else if (rand.nextInt(2) == 1) {
                    points = 1;
                    //set the title.
                    jf2.setTitle("Draw");

                    //set size of the window.
                    jf2.setSize(350, 350);

                    //create label.
                    resultLsbel = new JLabel("DRAW!!", SwingConstants.CENTER);
                    resultLsbel.setFont(new Font("Arial", Font.PLAIN, 24));
                    resultLsbel.setForeground(new Color(102, 0, 51));

                    //set Layout manger.
                    jf2.setLayout(new BorderLayout());

                    //add action listener to end button.
                    end.addActionListener(new bActionListener());

                    //add componemts to the window.
                    jf2.add(PLabel, BorderLayout.EAST);
                    jf2.add(resultLsbel, BorderLayout.CENTER);
                    JLabel PLabel2 = new JLabel(PImage);
                    jf2.add(PLabel2, BorderLayout.WEST);
                    jf2.add(end, BorderLayout.SOUTH);

                    //make the window display in the center of screen.
                    jf2.setLocationRelativeTo(null);

                    //display the window.
                    jf2.setVisible(true);
                } else {
                    points = 0;
                    //set the title.
                    jf2.setTitle("Lose");

                    //set size of the window.
                    jf2.setSize(350, 350);

                    //create panel.
                    resultPanel = new JPanel(new GridLayout(2, 1));

                    //create label.
                    resultLsbel = new JLabel("You Lose!!", SwingConstants.CENTER);
                    resultLsbel2 = new JLabel("Scissors beats Paper", SwingConstants.CENTER);
                    resultLsbel.setFont(new Font("Arial", Font.PLAIN, 24));
                    resultLsbel.setForeground(new Color(102, 0, 51));
                    resultLsbel2.setFont(new Font("Arial", Font.PLAIN, 18));
                    resultLsbel2.setForeground(new Color(0, 0, 255));

                    //add labels to panel.
                    resultPanel.add(resultLsbel);
                    resultPanel.add(resultLsbel2);

                    //set Layout manger.
                    jf2.setLayout(new BorderLayout());

                    //add action listener to end button.
                    end.addActionListener(new bActionListener());

                    //add componemts to the window.
                    jf2.add(SLabel, BorderLayout.EAST);
                    jf2.add(resultPanel, BorderLayout.CENTER);
                    jf2.add(PLabel, BorderLayout.WEST);
                    jf2.add(end, BorderLayout.SOUTH);

                    //make the window display in the center of screen.
                    jf2.setLocationRelativeTo(null);

                    //display the window.
                    jf2.setVisible(true);
                }
                break;
            case 2:
                if (rand.nextInt(2) == 0) {
                    points = 0;
                    //set the title.
                    jf2.setTitle("Lose");

                    //set size of the window.
                    jf2.setSize(350, 350);

                    //create panel.
                    resultPanel = new JPanel(new GridLayout(2, 1));

                    //create label.
                    resultLsbel = new JLabel("You Lose!!", SwingConstants.CENTER);
                    resultLsbel2 = new JLabel("Rock beats Scissors", SwingConstants.CENTER);
                    resultLsbel.setFont(new Font("Arial", Font.PLAIN, 24));
                    resultLsbel.setForeground(new Color(102, 0, 51));
                    resultLsbel2.setFont(new Font("Arial", Font.PLAIN, 18));
                    resultLsbel2.setForeground(new Color(0, 0, 255));

                    //add labels to panel.
                    resultPanel.add(resultLsbel);
                    resultPanel.add(resultLsbel2);

                    //set Layout manger.
                    jf2.setLayout(new BorderLayout());

                    //add action listener to end button.
                    end.addActionListener(new bActionListener());

                    //add componemts to the window.
                    jf2.add(RLabel, BorderLayout.EAST);
                    jf2.add(resultPanel, BorderLayout.CENTER);
                    jf2.add(SLabel, BorderLayout.WEST);
                    jf2.add(end, BorderLayout.SOUTH);

                    //make the window display in the center of screen.
                    jf2.setLocationRelativeTo(null);

                    //display the window.
                    jf2.setVisible(true);

                } else if (rand.nextInt(2) == 1) {
                    points = 2;
                    //set the title.
                    jf2.setTitle("Win");

                    //set size of the window.
                    jf2.setSize(350, 350);

                    //create panel.
                    resultPanel = new JPanel(new GridLayout(2, 1));

                    //create label.
                    resultLsbel = new JLabel("You WIN (^_^)", SwingConstants.CENTER);
                    resultLsbel2 = new JLabel("Scissors beats Paper", SwingConstants.CENTER);
                    resultLsbel.setFont(new Font("Arial", Font.PLAIN, 24));
                    resultLsbel.setForeground(new Color(102, 0, 51));
                    resultLsbel2.setFont(new Font("Arial", Font.PLAIN, 18));
                    resultLsbel2.setForeground(new Color(0, 0, 255));

                    //add labels to panel.
                    resultPanel.add(resultLsbel);
                    resultPanel.add(resultLsbel2);

                    //set Layout manger.
                    jf2.setLayout(new BorderLayout());

                    //add action listener to end button.
                    end.addActionListener(new bActionListener());

                    //add componemts to the window.
                    jf2.add(PLabel, BorderLayout.EAST);
                    jf2.add(resultPanel, BorderLayout.CENTER);
                    jf2.add(SLabel, BorderLayout.WEST);
                    jf2.add(end, BorderLayout.SOUTH);

                    //make the window display in the center of screen.
                    jf2.setLocationRelativeTo(null);

                    //display the window.
                    jf2.setVisible(true);
                } else {
                    points = 1;
                    //set the title.
                    jf2.setTitle("Draw");

                    //set size of the window.
                    jf2.setSize(350, 350);

                    //create label.
                    resultLsbel = new JLabel("DRAW!!", SwingConstants.CENTER);
                    resultLsbel.setFont(new Font("Arial", Font.PLAIN, 24));
                    resultLsbel.setForeground(new Color(102, 0, 51));

                    //set Layout manger.
                    jf2.setLayout(new BorderLayout());

                    //add action listener to end button.
                    end.addActionListener(new bActionListener());

                    //add componemts to the window.
                    jf2.add(SLabel, BorderLayout.EAST);
                    jf2.add(resultLsbel, BorderLayout.CENTER);
                    JLabel SLabel2 = new JLabel(SImage);
                    jf2.add(SLabel2, BorderLayout.WEST);
                    jf2.add(end, BorderLayout.SOUTH);

                    //make the window display in the center of screen.
                    jf2.setLocationRelativeTo(null);

                    //display the window.
                    jf2.setVisible(true);
                }
                break;
        }

    }

    /**
     * private inner class that handles the event that is generated when the
     * user click end or start button.
     */
    private class bActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == start) {/////
                game();
            }
            if (e.getSource() == end) {
                Playing.theEnd();
            }
        }
    }

    /**
     * This method return the points of player.
     * @return points
     */
    public static int getPoints() {
        return points;
    }
}
