/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamescenter;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author Lenovo
 */
public class Snake extends JFrame {

    private ImageIcon icon; //icon for the window.
    private JButton start, END;
    private JLabel welcome;
    

    /**
     * Constructor
     */
    public Snake() {

        //expline the game.
        explainTheGame();

        //call game name method.
        gameName();

    }

    private class SnakePanel extends JPanel implements ActionListener {

        private JPanel panel;
        static final int WIDTH = 450;
        static final int HEIGHT = 450;
        static final int UNIT_SIZE = 25;
        static final int GAME_UNITS = (WIDTH * HEIGHT) / UNIT_SIZE;
        static final int DELAY = 90;//75
        final int x[] = new int[GAME_UNITS];
        final int y[] = new int[GAME_UNITS];
        int bodyParts = 6;
        static int applesEaten = 0;
        int appleX, appleY;
        char direction = 'R';
        boolean running = false;
        Timer timer;
        Random random;
        
        
        public SnakePanel() {
            random = new Random();
            this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
            this.setBackground(Color.black);
            this.setFocusable(true);
            this.addKeyListener(new keyAdaptaer());
            startGame();
            
        }

        public void startGame() {
            applesEaten =0;
            //call newApple method.
            newApple();

            //set runing to true.
            running = true;

            timer = new Timer(DELAY, this);

            timer.start();
            

        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g);
        }

        public void draw(Graphics g) {

            if (running) {
                for (int i = 0; i < HEIGHT / UNIT_SIZE; i++) {
                    //draw lines for x axies.
                    g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, HEIGHT);
                    //draw lines for y axies.
                    g.drawLine(0, i * UNIT_SIZE, WIDTH, i * UNIT_SIZE);
                }
                g.setColor(Color.red);
                g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

                //draw the snake.
                for (int i = 0; i < bodyParts; i++) {
                    if (i == 0) {
                        g.setColor(Color.green);
                        g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    } else {
                        g.setColor(new Color(45, 180, 0));
                        g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    }
                }
                g.setColor(Color.red);
                g.setFont(new Font("INK Free", Font.BOLD, 35));
                FontMetrics metrics = getFontMetrics(g.getFont());
                g.drawString("points: " + applesEaten, (WIDTH - metrics.stringWidth("points: " + applesEaten)) / 2, g.getFont().getSize());
            } else {
                
                gameOver();
            }

        }

        public void newApple() {
            appleX = random.nextInt((int) (WIDTH / UNIT_SIZE)) * UNIT_SIZE;
            appleY = random.nextInt((int) (WIDTH / UNIT_SIZE)) * UNIT_SIZE;

        }

        public void move() {
            for (int i = bodyParts; i > 0; i--) {
                x[i] = x[i - 1];
                y[i] = y[i - 1];
            }
            switch (direction) {
                case 'U':
                    y[0] = y[0] - UNIT_SIZE;
                    break;
                case 'D':
                    y[0] = y[0] + UNIT_SIZE;
                    break;
                case 'L':
                    x[0] = x[0] - UNIT_SIZE;
                    break;
                case 'R':
                    x[0] = x[0] + UNIT_SIZE;
                    break;
            }
        }

        public void checkApple() {
            if ((x[0] == appleX) && (y[0] == appleY)) {
                bodyParts++;
                applesEaten++;
                newApple();
            }
        }

        public void checkCollisions() {
            //checks if head collides with body.
            for (int i = bodyParts; i > 0; i--) {
                if ((x[0] == x[i]) && (y[0] == y[i])) {
                    running = false;
                }
            }
            //check if head touches left boreder.
            if (x[0] < 0) {
                running = false;
            }
            //check if head touches right boreder.
            if (x[0] > WIDTH) {
                running = false;
            }
            //check if head touches top boreder.
            if (y[0] < 0) {
                running = false;
            }
            //check if head touches bottom boreder.
            if (y[0] > HEIGHT) {
                running = false;
            }
            if (!running) {
                timer.stop();
            }
        }
        
        
        public void gameOver(){
        //create JFrame.
        JFrame jf = new JFrame();

        //create panel and label and button.
        JPanel panel = new JPanel();
        JLabel label1 = new JLabel("points: "+ applesEaten, SwingConstants.CENTER);
        JLabel label2 = new JLabel("GAME OVER", SwingConstants.CENTER);
        END = new JButton("END");
        END.addActionListener(new buttonListener());
        
        label1.setFont(new Font("INK Free", Font.BOLD, 35));
        label1.setForeground(Color.red);
        label1.setBackground(Color.black);
        label1.setOpaque(true);
        label2.setFont(new Font("INK Free", Font.BOLD, 75));
        label2.setForeground(Color.red);
        label2.setBackground(Color.black);
        label2.setOpaque(true);

        //set the title.
        jf.setTitle("Snake");

        //specify action for the close button.
        jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //set the size of the window.
        jf.setSize(450, 450);

        //make the window display in the center of screen.
        jf.setLocationRelativeTo(null);

        //set background color.
        jf.setBackground(Color.BLACK);
        
        //set layout manger.
        jf.setLayout(new BorderLayout());
        
        jf.add(label1, BorderLayout.NORTH);
        jf.add(label2, BorderLayout.CENTER);
        jf.add(END, BorderLayout.SOUTH);

        //set icon for the window.
        icon = new ImageIcon("m1.png");
        jf.setIconImage(icon.getImage());

        //display the window.        
        jf.setVisible(true);
            
        } 

        @Override
        public void actionPerformed(ActionEvent e) {
            if (running) {
                move();
                checkApple();
                checkCollisions();
            }
            repaint();
        }

        public class keyAdaptaer extends KeyAdapter {

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        if (direction != 'R') {
                            direction = 'L';
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (direction != 'L') {
                            direction = 'R';
                        }
                        break;
                    case KeyEvent.VK_UP:
                        if (direction != 'D') {
                            direction = 'U';
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (direction != 'U') {
                            direction = 'D';
                        }
                        break;
                }
            }
        }
        
        public static int getPoints() {
            return applesEaten;
       }
    }

    /**
     * This method give simple explanation of the game
     */
    public void explainTheGame() {
        //cahnge the background color of JOpationpane.
        UIManager.put("OptionPane.background", new Color(255, 102, 178));
        UIManager.put("Panel.background", new Color(255, 255, 255));
        UIManager.put("Button.background", new Color(153, 205, 255));

        JOptionPane.showMessageDialog(null,
                "you are the sanke in this game "
                + " You should eat apples and each apple give you one point .\n"
                + "Be careful, don't hit the border",
                "Snake", 2);
    }

    /**
     * This method show the name of the game
     */
    public void gameName() {
        //create JFrame.
        JFrame jf1 = new JFrame();

        //create panel.
        JPanel panel = new JPanel();

        //set the title.
        jf1.setTitle("Snake");

        //specify action for the close button.
        jf1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //set the size of the window.
        jf1.setSize(300, 300);

        //make the window display in the center of screen.
        jf1.setLocationRelativeTo(null);

        //add panel to window.
        panel.setBackground(Color.black);

        //create label and set the font.
        welcome = new JLabel("Welcome to Snake Game", SwingConstants.CENTER);
        welcome.setFont(new Font("INK Free", Font.BOLD, 24));
        welcome.setForeground(Color.red);

        //create start button and add action Listiner and change the color of button.
        UIManager.put("Button.background", new Color(0, 255, 0));
        start = new JButton("START");
        start.addActionListener(new buttonListener());

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

    private class buttonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == start) {

                //set the title.
                setTitle("Snake Game");

                //specify action for the close button.
                setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

                //add panel to window.
                add(new SnakePanel());

                //set icon for the window.
                ImageIcon icon = new ImageIcon("m1.png");
                setIconImage(icon.getImage());

                setResizable(false);

                pack();
                
                //make the window display in the center of screen.
                setLocationRelativeTo(null);

                //display the window.
                setVisible(true);


            }if(e.getSource() == END){
                Playing.theEnd();
            }
        }

    }
    public static int getPoints(){
        return SnakePanel.getPoints();
    }
    //public static void setPoints(int points){
    //    points = 0;
    //}
    

}
