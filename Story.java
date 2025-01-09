/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamescenter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * Story Game.
 * Tom Sawyer Story will display then 3 questions each right 
 * answer give the player one point. 
 */
public class Story {

    private ImageIcon image1, image2, image3, image4, image5, image6, icon;
    private JPanel panel;
    private JLabel welcome, imageLabel1, imageLabel2, imageLabel3, imageLabel4, imageLabel5;
    private JTextArea part1, part2, part3, part4, part5;
    private JButton start, next1, next2, next3, next4, next5;
    private static int totalPoints = 0;

    /**
     * constructor
     */
    public Story() {
        //cahnge the background color of JOpationpane.
        UIManager.put("OptionPane.background", new Color(0, 51, 102));
        UIManager.put("Panel.background", new Color(102, 178, 255));
        UIManager.put("Button.background", new Color(255, 255, 255));
        
        // call motheds that will display explaintion of the 
        //game and display the beging of the game.
        explainTheGame();
        gameName();

    }

    /**
     * This method give simple explanation of the game
     */
    public void explainTheGame() {
        JOptionPane.showMessageDialog(null,
                "in this game you will read the story "
                + "and anwser the questions\n"
                + "and you will get one point for each correct answer",
                "Story", 2);
    }

    /**
     * This method display the name of the game.
     */
    public void gameName() {

        //create JFrame.
        JFrame jf1 = new JFrame();

        //create panel.
        JPanel panel = new JPanel();

        //set the title.
        jf1.setTitle("Story");

        //specify action for the close button.
        jf1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //set the size of the window.
        jf1.setSize(300, 300);

        //make the window display in the center of screen.
        jf1.setLocationRelativeTo(null);

        //add panel to window.
        panel.setBackground(Color.white);

        //create label and set the font.
        welcome = new JLabel("<html><font color='red'>T</font><font color='yellow'>o</font>"
                + "<font color='green'>m </font><font color='blue'>S</font><font color='black'>a</font>"
                + "<font color='red'>w</font><font color='yellow'>y</font><font color='green'>e</font>"
                + "<font color='blue'>r </font><font color='black'>S</font>"
                + "<font color='red'>t</font><font color='yellow'>o</font>"
                + "<font color='green'>r</font><font color='blue'>y</font></html>"
                , SwingConstants.CENTER);
        welcome.setFont(new Font("INK Free", Font.BOLD, 30));
        
       

        //create start button and add action Listiner and change the color of button.
        UIManager.put("Button.background", new Color(0, 255, 0));
        start = new JButton("START");
        start.addActionListener(new buttonActionListener());

        //add manger layout.
        panel.setLayout(new BorderLayout());

        //add button and label to panel.
        panel.add(welcome, BorderLayout.CENTER);
        panel.add(start, BorderLayout.SOUTH);

        //add panel to window.
        jf1.add(panel);

        //set icon for the window.
        icon = new ImageIcon("m1.png");
        jf1.setIconImage(icon.getImage());

        //display the window.
        jf1.setVisible(true);

    }


    /**
     * part 1 of Tom Sawyer Story.
     */
    public void tomSawyerP1() {
        //create JFrame.
        JFrame jf1 = new JFrame();

        //create panel.
        JPanel panel = new JPanel();

        //set the title.
        jf1.setTitle("Story");

        //specify action for the close button.
        jf1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //set the size of the window.
        jf1.setSize(550, 400);

        //make the window display in the center of screen.
        jf1.setLocationRelativeTo(null);

        //add panel to window.
        panel.setBackground(new Color(255, 255, 102));

        //create text area and set the font.
        part1 = new JTextArea("\n\n\n\n\n  I know you didn't go to school tody\n"
                + "  said Aunt Polly, and that's not Okay.\n"
                + "  Tomorrow you are going to paint the\n  fence."
                + " But tomorrow is Saturday. It's\n  my time to play!"
                + " said Tom."
                + " Anut Polly\n  was determind."
                + " She wanted to teach \n  Tom a lesson.");
        part1.setFont(new Font("Arial", Font.BOLD, 16));
        part1.setForeground(Color.red);
        part1.setBackground(new Color(255, 255, 102));
        part1.setEditable(false);

        //create image and Lebal for the image.
        image1 = new ImageIcon("Story1.png");
        imageLabel1 = new JLabel(image1);

        //create start button and add action Listiner and change the color of button.
        UIManager.put("Button.background", new Color(255, 178, 102));
        next1 = new JButton("NEXT");
        next1.addActionListener(new buttonActionListener());

        //add manger layout.
        panel.setLayout(new BorderLayout());

        //add button and label to panel.
        panel.add(part1, BorderLayout.CENTER);
        panel.add(next1, BorderLayout.SOUTH);
        panel.add(imageLabel1, BorderLayout.WEST);

        //add panel to window.
        jf1.add(panel);

        //set icon for the window.
        icon = new ImageIcon("m1.png");
        jf1.setIconImage(icon.getImage());

        //display the window.
        jf1.setVisible(true);
    }


    /**
     * part 2 of Tom Sawyer Story.
     */
    public void tomSawyerP2() {
        //create JFrame.
        JFrame jf2 = new JFrame();

        //create panel.
        JPanel panel2 = new JPanel();

        //set the title.
        jf2.setTitle("Story");

        //specify action for the close button.
        jf2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //set the size of the window.
        jf2.setSize(550, 400);

        //make the window display in the center of screen.
        jf2.setLocationRelativeTo(null);

        //add panel to window.
        panel2.setBackground(new Color(178, 255, 102));

        //create label and set the font.
        part2 = new JTextArea("\n\n\n\n\n\n\n  Saturday come, and it was beautiful sunny day.\n"
                + "  He look at the fence thoughtfully."
                + " Thirty yards of\n  fence nine feet high!! "
                + "It seem to him that life\n  wasn't worth living");
        part2.setFont(new Font("Arial", Font.BOLD, 16));
        part2.setForeground(new Color(51, 102, 0));
        part2.setBackground(new Color(178, 255, 102));
        part2.setEditable(false);

        //create image and Lebal for the image.
        image2 = new ImageIcon("Story22.jpg");
        imageLabel2 = new JLabel(image2);

        //create start button and add action Listiner and change the color of button.
        UIManager.put("Button.background", new Color(255, 178, 102));
        next2 = new JButton("NEXT");
        next2.addActionListener(new buttonActionListener());

        //add manger layout.
        panel2.setLayout(new BorderLayout());

        //add button and label to panel.
        panel2.add(part2, BorderLayout.CENTER);
        panel2.add(next2, BorderLayout.SOUTH);
        panel2.add(imageLabel2, BorderLayout.WEST);

        //add panel to window.
        jf2.add(panel2);

        //set icon for the window.
        icon = new ImageIcon("m1.png");
        jf2.setIconImage(icon.getImage());

        //display the window.
        jf2.setVisible(true);
    }


    /**
     * part 3 of Tom Sawyer Story.
     */
    public void tomSawyerP3() {
        //create JFrame.
        JFrame jf3 = new JFrame();

        //create panel.
        JPanel panel3 = new JPanel();

        //set the title.
        jf3.setTitle("Story");

        //specify action for the close button.
        jf3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //set the size of the window.
        jf3.setSize(550, 400);

        //make the window display in the center of screen.
        jf3.setLocationRelativeTo(null);

        //add panel to window.
        panel3.setBackground(new Color(102, 255, 102));

        //create label and set the font.
        part3 = new JTextArea("\n\n\n\n\n   Ben came dancing out of the gate with red apple.\n"
                + "  Tom had an idea. He took the brush and went \n"
                + "  calmly to work. \" What? Do you like it? \"asked Ben.\n"
                + "  Tom answered,\" Like it? I love it! It's not every day\n"
                + "  that a boy gets to paint a fence \". \"I say, Tom,\n "
                + "  let me paint a little\" Ben said.\"No, no, I cann't.\n"
                + "  My anut said only I could do that. \" said Tom.\n"
                + "  \" Come on, Tom. I'll give you my apple!\" Ben Said.");
        part3.setFont(new Font("Arial", Font.BOLD, 16));
        part3.setForeground(new Color(0, 102, 51));
        part3.setBackground(new Color(102, 255, 102));
        part3.setEditable(false);

        //create image and Lebal for the image.
        image3 = new ImageIcon("Story33.jpg");
        imageLabel3 = new JLabel(image3);

        //create start button and add action Listiner and change the color of button.
        UIManager.put("Button.background", new Color(255, 178, 102));
        next3 = new JButton("NEXT");
        next3.addActionListener(new buttonActionListener());

        //add manger layout.
        panel3.setLayout(new BorderLayout());

        //add button and label to panel.
        panel3.add(part3, BorderLayout.CENTER);
        panel3.add(next3, BorderLayout.SOUTH);
        panel3.add(imageLabel3, BorderLayout.WEST);

        //add panel to window.
        jf3.add(panel3);

        //set icon for the window.
        icon = new ImageIcon("m1.png");
        jf3.setIconImage(icon.getImage());

        //display the window.
        jf3.setVisible(true);
    }


    /**
     * part 4 of Tom Sawyer Story.
     */
    public void tomSawyerP4() {
        //create JFrame.
        JFrame jf4 = new JFrame();

        //create panel.
        JPanel panel4 = new JPanel();

        //set the title.
        jf4.setTitle("Story");

        //specify action for the close button.
        jf4.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //set the size of the window.
        jf4.setSize(550, 400);

        //make the window display in the center of screen.
        jf4.setLocationRelativeTo(null);

        //add panel to window.
        panel4.setBackground(new Color(102, 255, 178));

        //create label and set the font.
        part4 = new JTextArea("\n\n\n\n\n  A little later, Jon walked by. \" Hello Tom.\n"
                + "  What are you doing?\" Tom said, \" Hi Jon.\n"
                + "  I am having a great time painting the fance. Can I paint? \" asked Jon.\n"
                + "  \"My anut said only I could paint the fence.\n"
                + "  I was nice enough to let Ben try, But now I\n"
                + "  want to paint again \" \" Please, Tom. jast\n"
                + "  a little. I'll give you my marbles\"\n ");
        part4.setFont(new Font("Arial", Font.BOLD, 16));
        part4.setForeground(new Color(0, 102, 51));
        part4.setBackground(new Color(102, 255, 178));
        part4.setEditable(false);

        //create image and Lebal for the image.
        image4 = new ImageIcon("Story44.jpg");
        imageLabel4 = new JLabel(image4);

        //create start button and add action Listiner and change the color of button.
        UIManager.put("Button.background", new Color(255, 178, 102));
        next4 = new JButton("NEXT");
        next4.addActionListener(new buttonActionListener());

        //add manger layout.
        panel4.setLayout(new BorderLayout());

        //add button and label to panel.
        panel4.add(part4, BorderLayout.CENTER);
        panel4.add(next4, BorderLayout.SOUTH);
        panel4.add(imageLabel4, BorderLayout.WEST);

        //add panel to window.
        jf4.add(panel4);

        //set icon for the window.
        icon = new ImageIcon("m1.png");
        jf4.setIconImage(icon.getImage());

        //display the window.
        jf4.setVisible(true);
    }

    /**
     * part 5 of Tom Sawyer Story.
     */
    public void tomSawyerP5() {
        //create JFrame.
        JFrame jf5 = new JFrame();

        //create panel.
        JPanel panel5 = new JPanel();

        //set the title.
        jf5.setTitle("Story");

        //specify action for the close button.
        jf5.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //set the size of the window.
        jf5.setSize(550, 400);

        //make the window display in the center of screen.
        jf5.setLocationRelativeTo(null);

        //add panel to window.
        panel5.setBackground(new Color(102, 178, 255));

        //create label and set the font.
        part5 = new JTextArea("\n\n\n\n\n  By the end of the day, many of Tom's \n"
                + "  friends had helped paint the fence. Tom\n"
                + "  tricked them all into thinking it was fun.\n"
                + "  Tom said to himself that life was worth\n"
                + "  living after all. He had discover great law\n"
                + "  of human behaviour: in order to make a \n"
                + "  man or boy desire a thing, it is only\n"
                + "  necessary to make the thing difficult\n"
                + "  to obtain");
        part5.setFont(new Font("Arial", Font.BOLD, 16));
        part5.setForeground(new Color(0, 0, 51));
        part5.setBackground(new Color(102, 168, 255));
        part5.setEditable(false);

        //create image and Lebal for the image.
        image5 = new ImageIcon("Story55.jpg");
        imageLabel5 = new JLabel(image5);

        //create start button and add action Listiner and change the color of button.
        UIManager.put("Button.background", new Color(255, 178, 102));
        next5 = new JButton("NEXT");
        next5.addActionListener(new buttonActionListener());

        //add manger layout.
        panel5.setLayout(new BorderLayout());

        //add button and label to panel.
        panel5.add(part5, BorderLayout.CENTER);
        panel5.add(next5, BorderLayout.SOUTH);
        panel5.add(imageLabel5, BorderLayout.WEST);

        //add panel to window.
        jf5.add(panel5);

        //set icon for the window.
        icon = new ImageIcon("m1.png");
        jf5.setIconImage(icon.getImage());

        //display the window.
        jf5.setVisible(true);
    }


    /**
     * simple quiz and points for the quiz and return the points
     * @return The points.
     */
    public int quizAndPoints(){
        int points = 0;//one point for each right anwser
        int input;//the player answer
        //options for each question
        String[] options1 = {"Apple", "Marbles", "Bull"};
        String[] options2 = {"Yes", "No"};
        String[] options3 = {"He wanted to that", "He didn't go to school",
                             "He did bad in exam"};
        
        UIManager.put("Button.background", new Color(255, 255, 255));
        
        //the question num1
        input = JOptionPane.showOptionDialog(null, 
                "What does Ben give Tom to "
                + "let him paint the fence?", "Story",
                0, 3, null,
                options1, options1[0]);
        //check the answer        
        if(input == 0){
            ++points;
            JOptionPane.showMessageDialog(null, " Correct  .|^__^|.\n One point");
        }else{
            JOptionPane.showMessageDialog(null, " Not Correct (-__-)");
        }
        //the question num2
        input = JOptionPane.showOptionDialog(null, 
                "Does Tom paint the fence? ", "Story",
                0, 3, null,
                options2, options2[0]);  
        //check the answer
        if(input == 1){
            ++points;
            JOptionPane.showMessageDialog(null, " Correct  .|^__^|.\n One point");
        }else{
            JOptionPane.showMessageDialog(null, " Not Correct (-__-)");
        }
        //the question num3
        input = JOptionPane.showOptionDialog(null, 
                "Why does Tom have to paint the fence?"
                        + "\nbecause...", "Story",
                0, 3, null, 
                options3, options3[0]);
        //check the answer        
        if(input == 1){
            ++points;
            JOptionPane.showMessageDialog(null, " Correct  .|^__^|.\n One point");
        }else{
            JOptionPane.showMessageDialog(null, " Not Correct (-__-)");
            
        }

        return points;
    }
    
    /**
     * private inner class that handles the event that is generated when the
     * user click any button.
     */
    private class buttonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == start) {
                tomSawyerP1();
            }
            if (e.getSource() == next1) {
                tomSawyerP2();
            }
            if (e.getSource() == next2) {
                tomSawyerP3();
            }
            if (e.getSource() == next3) {
                tomSawyerP4();
            }
            if (e.getSource() == next4) {
                tomSawyerP5();
            }
            if (e.getSource() == next5) {
                totalPoints = quizAndPoints();
                Playing.theEnd();
            } 
        }
    }
    /**
     * This method return the points of player.
     * @return points
     */
    public static int getPoints(){
        return totalPoints;
    }

}
