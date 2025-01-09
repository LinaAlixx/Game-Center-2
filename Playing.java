/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamescenter;

import static gamescenter.Playing.welcome;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * control must of the game
 */
public class Playing extends JFrame {

    private static int numPlayers;
    private static String inputStr, selection, output;
    private static JPanel panel1, panel2, panel3, gamesListPanel, welcomePanel, panel4, panel5, panel6;
    private static JButton okbutton, playButton, readyToPlay, button, button2, detailsButton, ok2button;
    private static JLabel label1, label2, label3, label4, labelNames, PlayerNolabel, chooselabel, hiLabel, imageLabel, byeLabel, winnerLabel1, winnerLabel2, detailLabel, detailLabel2, detailLabel3;
    private static ImageIcon icon, hiImage, byeImage;
    private JTextField textF, textF2;
    private static String[] names, games = {"TicTacToe", "RockPaperScissors", "Snake", "Story"};
    private static JList gamesList;
    private static JScrollPane scrollPane; 
    private static int points, again = 1;
    private static String[] options = {"Yes", "No"};
    private static int[] playerPoints;
    private static int j = 0, i = 0;
    private JTextArea detailsArea;

    
    /**
     * Constructor
     */
    public Playing() {

        //this method for asking the user about the number of players. 
        getNumOfPlayers();

    }

    /**
     * This method ask the user to enter the number of player and return it
     * @return The number of players.
     */
    public void getNumOfPlayers() {

        //create panels.
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();

        //create oe button.
        okbutton = new JButton("OK");

        //display the window.
        setVisible(true);

        //set the title.
        setTitle("Number of Players");

        //set the size.
        setSize(300, 300);

        //specify action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //display the window at the center of the screen.
        setLocationRelativeTo(null);

        //create icone for the window.
        icon = new ImageIcon("m1.png");
        setIconImage(icon.getImage());

        //create text fields.
        textF = new JTextField(7);

        //set manger layout.
        setLayout(new GridLayout(3, 1));

        //create label and change the font.
        PlayerNolabel = new JLabel("How many Players will play in Game Center?");
        PlayerNolabel.setFont(new Font("Arial", Font.PLAIN, 14));

        //add label and text filed to panel 2 and change the color background.
        panel2.add(PlayerNolabel);
        panel2.add(textF);
        panel2.setBackground(Color.PINK);

        //change color background to panel 1 and 3.
        panel1.setBackground(Color.CYAN);
        panel3.setBackground(Color.YELLOW);

        //set layout manger to panel 2 and3.
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));

        //add action listener to the button.
        okbutton.addActionListener(new okbuttonListener());

        //add the button to panel 3.
        panel3.add(okbutton);

        // add all panels.
        add(panel1);
        add(panel2);
        add(panel3);

    }

    /**
     * private inner class that handles the event that is generated when the
     * user click Okay button.
     */
    private class okbuttonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            inputStr = textF.getText();

            if (e.getSource() == okbutton) {
                try {
                    numPlayers = Integer.parseInt(inputStr);

                    if (numPlayers <= 0) {
                        JOptionPane.showMessageDialog(null,
                                "Invalid input; re-enter again",
                                "Warning", 0);
                    } else {
                        playersNamesPoints();
                    }
                } catch (NumberFormatException j) {
                    JOptionPane.showMessageDialog(null,
                            "Invalid input; re-enter again",
                            "Warning", 0);
                }
            }
        }
    }

    /**
     * this method create two list for players names and their points
     */
    public void playersNamesPoints() {

        //two lists for names and points
        names = new String[numPlayers];
        playerPoints = new int[numPlayers];

        //create color objects.
        Color c1 = new Color(204, 153, 255);
        Color c2 = new Color(153, 204, 255);
        Color c3 = new Color(255, 255, 255);

        //ask each player to enter his/her name.
        for (int k = 0; k < numPlayers; ++k) {
            if (k % 2 == 0) {
                UIManager.put("OptionPane.background", c1);
                UIManager.put("Panel.background", c1);
                UIManager.put("Button.background", c3);
            } else {
                UIManager.put("OptionPane.background", c2);
                UIManager.put("Panel.background", c2);
                UIManager.put("Button.background", c3);
            }
            names[k] = JOptionPane.showInputDialog(
                    "Enter the name for player" + (k + 1) + ":");
            playerPoints[k] = 0;

        }

        //welcoming each player.
        welcome();

    }

    public static void welcome() {
        //cahnge the background color of JOpationpane.
        UIManager.put("OptionPane.background", new Color(51, 51, 255));
        UIManager.put("Panel.background", new Color(204, 153, 255));
        UIManager.put("Button.background", new Color(255, 255, 255));

        //welcoming each palyer.
        for (; j < numPlayers;) {
            //create JFrame.
            JFrame jf1 = new JFrame();

            //create Panel.
            welcomePanel = new JPanel();

            //create image to show to each user.
            hiImage = new ImageIcon("hi1.png");

            //create label and change its color and size.
            hiLabel = new JLabel("Hi, " + names[j], hiImage, SwingConstants.LEFT);
            hiLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            hiLabel.setForeground(new Color(102, 0, 51));

            //create button and add action listener.
            readyToPlay = new JButton("Ready To PLAY");
            readyToPlay.addActionListener(new ReadyToPlayListener());

            //add image, lebel and button to panels. 
            welcomePanel.add(hiLabel);
            welcomePanel.add(readyToPlay);

            //set the title.
            jf1.setTitle("Hello");

            //specify action for the close button.
            jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //set the size of the window.
            jf1.setSize(300, 300);

            //make the window display in the center of screen.
            jf1.setLocationRelativeTo(null);

            //add panel to window.
            jf1.add(welcomePanel);

            //set icon for the window.
            icon = new ImageIcon("m1.png");
            jf1.setIconImage(icon.getImage());

            //display the window.
            jf1.setVisible(true);

            break;

        }

    }
    /**
     * private inner class that handles the event that is generated when the
     * user click any button.
     */
    private static class ReadyToPlayListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == readyToPlay) {
                GamesList();
            }
        }
    }
    /**
     * this method display main menu game.
     */
    public static void GamesList() {

        //create JFrame.
        JFrame jf1 = new JFrame();

        //create panel to hold the list.
        gamesListPanel = new JPanel();

        //chage color of background.
        gamesListPanel.setBackground(new Color(255, 255, 51));

        //create a list.
        gamesList = new JList(games);

        //set the selection mode to single selection.
        gamesList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        //set the number of vistable rows to 3.
        gamesList.setVisibleRowCount(3);

        //add the list to scroll pane.
        scrollPane = new JScrollPane(gamesList);

        //create label.
        chooselabel = new JLabel("Choose game to paly: ");

        //create empty broder.
        chooselabel.setBorder(BorderFactory.createEmptyBorder(70, 50, 10, 10));

        //cange background of label and the color and font of lebel.
        chooselabel.setBackground(new Color(255, 255, 51));
        chooselabel.setOpaque(true);
        chooselabel.setForeground(new Color(255, 128, 0));
        chooselabel.setFont(new Font("Arial", Font.PLAIN, 20));

        //create button.
        playButton = new JButton("PLAY");

        //change the color of play button.
        playButton.setBackground(new Color(255, 153, 51));

        //add action listener to button.
        playButton.addActionListener(new playActionListener());

        //add the scroll pane to the panel.
        gamesListPanel.add(scrollPane);

        //set the title.
        jf1.setTitle("Let's play");

        //specify action for the close button.
        jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set the size of the window.
        jf1.setSize(300, 300);

        //make the window display in the center of screen.
        jf1.setLocationRelativeTo(null);

        //set icon for the window.
        icon = new ImageIcon("m1.png");
        jf1.setIconImage(icon.getImage());

        //set border layout manger.
        jf1.setLayout(new BorderLayout());

        //add panel to the frame.
        jf1.add(gamesListPanel, BorderLayout.CENTER);

        //add label to panel.
        jf1.add(chooselabel, BorderLayout.NORTH);

        //add play button to the frame.
        jf1.add(playButton, BorderLayout.SOUTH);

        //display the window.
        jf1.setVisible(true);

    }
    /**
     * private inner class that handles the event that is generated when the
     * user click play button.
     */

    private static class playActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == playButton) {
                //get the selected game.
                selection = (String) gamesList.getSelectedValue();

                //open the game that the player is choose.
                if (selection.equals("TicTacToe")) {
                    if (numPlayers != 1) {
                        //at tic tac toe game you choose other player that you play against.
                        String name2 = (String) JOptionPane.showInputDialog(
                                null, "choose player:", "Players",
                                JOptionPane.QUESTION_MESSAGE, null, names,
                                names[0]);
                        // you cant play against yourself.
                        if (name2.equals(names[j])) {
                            JOptionPane.showMessageDialog(null,
                                    "You cann't play against yourself ",
                                    "Error", 0);
                            name2 = (String) JOptionPane.showInputDialog(
                                    null, "choose player:", "Players",
                                    JOptionPane.QUESTION_MESSAGE, null, names,
                                    names[0]);
                        }
                        new TicTacToe(names[j], name2);
                    } else {
                        JOptionPane.showMessageDialog(null, "This game need two players.", "Error", 0);
                    }

                } else if (selection.equals("RockPaperScissors")) {
                    new RockPaperScissors();

                } else if (selection.equals("Snake")) {
                    new Snake();

                } else if (selection.equals("Story")) {
                    new Story();
                    
                }

            }
        }
    }

    
    public static void GoodBye() throws IOException {
        //create frame, image icon and label.
        JFrame jf = new JFrame();
        byeImage = new ImageIcon("bye.png");
        byeLabel = new JLabel(byeImage);

        //set the title.
        jf.setTitle("Good Bye");

        //set the size.
        jf.setSize(500, 400);

        //specify action for the close button.
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //display the window at the center of the screen.
        jf.setLocationRelativeTo(null);

        //create icone for the window.
        icon = new ImageIcon("m1.png");
        jf.setIconImage(icon.getImage());

        //add label tp window.
        jf.add(byeLabel);

        //display the window.
        jf.setVisible(true);
        
        //call file method.
        file();

    }
    /**
     * This method determine the winner
     */
    
    public static void theWinner() {
        //change button color.
        UIManager.put("Button.background", new Color(255, 255, 255));

        //create frame.
        JFrame jf3 = new JFrame();

        //set the title.
        jf3.setTitle("The Winner");

        //set the size.
        jf3.setSize(300, 300);

        //specify action for the close button.
        jf3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //display the window at the center of the screen.
        jf3.setLocationRelativeTo(null);

        //set manger layout.
        jf3.setLayout(new GridLayout(3, 1));;

        //create panels.
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();

        //create label.
        winnerLabel1 = new JLabel("The winner is: ", SwingConstants.CENTER);
        winnerLabel1.setForeground(Color.black);
        winnerLabel1.setFont(new Font("Arial", Font.PLAIN, 30));

        //call a method to determind the Winner.
        selectionSort();

        //create a label for winner name and points.
        winnerLabel2 = new JLabel(names[0] + "   " + playerPoints[0], SwingConstants.CENTER);
        winnerLabel2.setForeground(Color.blue);
        winnerLabel2.setFont(new Font("INK Free", Font.BOLD, 40));

        //create buttons.
        button2 = new JButton("OK");
        button2.addActionListener(new button2Listener());
        detailsButton = new JButton("Show Details");
        detailsButton.addActionListener(new button2Listener());

        //create icone for the window.
        icon = new ImageIcon("m1.png");
        jf3.setIconImage(icon.getImage());

        panel5.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel6.setLayout(new FlowLayout(FlowLayout.CENTER));

        panel5.add(winnerLabel1);
        panel5.add(winnerLabel2);

        panel5.setBackground(Color.white);
        panel4.setBackground(Color.blue);
        panel6.setBackground(Color.blue);
        panel6.add(button2);
        panel6.add(detailsButton);

        jf3.add(panel4);
        jf3.add(panel5);
        jf3.add(panel6);

        //display the window.
        jf3.setVisible(true);
    }

    /**
     * private inner class that handles the event that is generated when the
     * user click end button.
     */
    private static class button2Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button2) {
                whoWeAre();
            } else if (e.getSource() == detailsButton) {
                details();
            }
            if (e.getSource() == ok2button) {
                whoWeAre();
            }

        }
    }
    /**
     * This method show who made this application
     */
    public static void whoWeAre() {
        UIManager.put("Button.background", new Color(153, 204, 255));
        JFrame jf2 = new JFrame();

        jf2.setLayout(new BorderLayout());
        panel1 = new JPanel();
        panel2 = new JPanel();
        button = new JButton("OK");
        panel2.add(button);
        button.addActionListener(new buttonListener());

        panel1.setLayout(new GridLayout(2, 2));
        label1 = new JLabel(new ImageIcon("icon.jpg"));
        label4 = new JLabel(new ImageIcon("icon.jpg"));
        label2 = new JLabel("<html>Student Name: <font color='red'>Lina Ali</font> Email: <font color='red'>2216609@uj.edu.sa</font></html>");
        label3 = new JLabel("<html>Student Name: <font color='red'>Lama Ibrahim</font> Email: <font color='red'>2113383@uj.edu.sa</font></html>");
        panel1.add(label1);
        panel1.add(label2);
        panel1.add(label4);
        panel1.add(label3);

        jf2.setTitle("Who We Are?");
        jf2.setSize(300, 300);
        jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf2.add(panel1, BorderLayout.CENTER);
        jf2.add(panel2, BorderLayout.SOUTH);
        panel1.setBackground(Color.PINK);
        panel2.setBackground(Color.WHITE);

        //set icone of the window.
        jf2.setIconImage(icon.getImage());

        //dispaly window at the center of the screen.
        jf2.setLocationRelativeTo(null);
        jf2.setVisible(true);
    }

    /**
     * private inner class that handles the event that is generated when the
     * user click end button.
     */
    private static class buttonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button) {
                try {
                    GoodBye();
                } catch (IOException ex) {
                    System.out.println("There is a problem with the file");
                }
            }

        }
    }

    /**
     * This method return the results of each players
     *
     */
    public static void details() {
        //change button background color.
        UIManager.put("Button.background", new Color(255, 255, 255));
        
        //create JFrame.
        JFrame jf4 = new JFrame();

        //create panel.
        JPanel Dpanel = new JPanel();
        JPanel Dpanel2 = new JPanel();
        JPanel Dpanel3 = new JPanel();

        //set the title.
        jf4.setTitle("Details");

        //specify action for the close button.
        jf4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set the size of the window.
        jf4.setSize(300, 300);

        //make the window display in the center of screen.
        jf4.setLocationRelativeTo(null);

        //set layout manger.
        jf4.setLayout(new BorderLayout());

        //change background color.
        jf4.setBackground(new Color(0, 204, 102));

        //set layout to panels.
        Dpanel2.setLayout(new GridLayout(2, 1));

        //change background color.
        Dpanel.setBackground(new Color(0, 204, 102));
        Dpanel2.setBackground(new Color(0, 204, 102));
        Dpanel3.setBackground(new Color(0, 204, 102));

        //create label.
        detailLabel = new JLabel("<html>The result of all players</br></html>", SwingConstants.CENTER);
        detailLabel2 = new JLabel("Names      Points", SwingConstants.CENTER);
        detailLabel.setFont(new Font("Arial", Font.BOLD, 16));
        detailLabel.setForeground(Color.blue);
        detailLabel2.setFont(new Font("Arial", Font.BOLD, 16));
        detailLabel2.setForeground(Color.red);
        detailLabel.setBackground(new Color(0, 204, 102));
        detailLabel2.setBackground(new Color(0, 204, 102));

        //create button.
        ok2button = new JButton("OK");
        ok2button.addActionListener(new button2Listener());

        // string that will add to text area.
        output = "";
        for (int i = 0; i < numPlayers; i++) {
            output += names[i] + "     " + playerPoints[i] + "\n";
        }

        //create label and set the font.
        JTextArea detailsArea = new JTextArea(output);
        detailsArea.setFont(new Font("Arial", Font.BOLD, 16));
        detailsArea.setForeground(Color.BLACK);
        detailsArea.setBackground(new Color(0, 204, 102));
        detailsArea.setEditable(false);

        //add text area to panele.
        Dpanel.add(detailsArea);
        Dpanel2.add(detailLabel);
        Dpanel2.add(detailLabel2);
        Dpanel3.add(ok2button);

        //add panel to window.
        jf4.add(Dpanel, BorderLayout.CENTER);
        jf4.add(Dpanel2, BorderLayout.NORTH);
        jf4.add(Dpanel3, BorderLayout.SOUTH);

        //set icon for the window.
        icon = new ImageIcon("m1.png");
        jf4.setIconImage(icon.getImage());

        //display the window.
        jf4.setVisible(true);
    }

    /**
     * This method count the points for each player
     */
    public static void theEnd() {
        //change button color.
        UIManager.put("Button.background", new Color(153, 204, 255));
        //ask the user to continue playing or not.
        again = JOptionPane.showOptionDialog(null,
                "You want to play in game center again? ", "Again",
                0, 3, null,
                options, options[0]);
        //count points from each game. 
        if (selection.equals("RockPaperScissors")) {
            points += RockPaperScissors.getPoints();
        }
        if (selection.equals("Story")) {
            points += Story.getPoints();
        }
        if (selection.equals("Snake")) {
            points += Snake.getPoints();
        }
        if (selection.equals("TicTacToe")) {
            
            points = 0;
            // if x wins.
            if (TicTacToe.checkWinner().equals(names[j])) {
                points += 6;
            }else{
                i = 0;
                for (i = 0; i < numPlayers; i++) {
                     //if o wins.
                    if (TicTacToe.checkWinner().equals(names[i])) {
                        playerPoints[i] += 6;
                        break;
                     //if draw.
                    }if(TicTacToe.checkWinner().equals("draw")){
                        points += 0;
                        break;
                    }
                }
            }
        }
        if (again == 0) {
            playerPoints[j] += points;
            points = 0;
            //display game list again.
            Playing.GamesList();

        } else {
            //set point to current palyer and welcoming the next player.
            playerPoints[j] += points;
            //System.out.println(playerPoints[j]);
            j++;
            if (j == (i - 1)) {
                points = 6;
            } else {
                points = 0;
            }
            
            if (numPlayers == j ) {
                theWinner();                
            }
            welcome();
        }
    }

    /**
     * This method rank the player according to their points
     */
    public static void selectionSort() {
        int maxIndex;
        int maxValue;
        String maxName;

        for (int startScan = 0; startScan < numPlayers - 1; startScan++) {
            maxIndex = startScan;
            maxValue = playerPoints[startScan];
            maxName = names[startScan];

            for (int index = startScan + 1; index < numPlayers; index++) {
                if (playerPoints[index] > maxValue) {
                    maxValue = playerPoints[index];
                    maxIndex = index;
                    maxName = names[index];
                }
            }
            playerPoints[maxIndex] = playerPoints[startScan];
            playerPoints[startScan] = maxValue;
            names[maxIndex] = names[startScan];
            names[startScan] = maxName;
        }
    }

    /**
     * This method make a file of the results
     *
     * @param date The date of playing
     * @throws IOException
     */
    public static void file() throws IOException {
        //writing text to file
        //open file
        FileWriter fw = new FileWriter("Results.txt", true);
        PrintWriter outputFile = new PrintWriter(fw);
        //edit file
        for (int i = 0; i < numPlayers; i++) {
            outputFile.println(names[i] + "     " + playerPoints[i]);
        }
        outputFile.println(new Date());
        outputFile.println("------------------------------- ");
        //close the file
        outputFile.close();

        //Reading file
        //open file for reading
        File file = new File("Results.txt");
        Scanner inputFile = new Scanner(file);
        //reading the file
        while (inputFile.hasNext()) {
            String result = inputFile.nextLine();
        }
        //close the file
        inputFile.close();
    }

}
