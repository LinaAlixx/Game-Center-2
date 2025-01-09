package gamescenter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class responsible for displaying application interface
 *
 */
public class Intro extends JFrame {

    private IntroPanel panel;
    private JButton buttonPlay;//to start the game
    private Image icon;// icon for the window

    /**
     * Constructor
     */
    Intro() {
        //creat a welcome panel. 
        panel = new IntroPanel();

        // set the titel and the icone of the window.
        setTitle(" . . . Games Center . . . ");
        icon = new ImageIcon("m1.png").getImage();
        setIconImage(icon);

        //specify an action for the close button.
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        // add panel to the JFrame.
        add(panel);

        //pack.
        pack();

        //display the window at the center of the screen.
        setLocationRelativeTo(null);

        //display the window.
        setVisible(true);
    }

    private class IntroPanel extends JPanel implements ActionListener {

        final int PANEL_WIDTH = 680;
        final int PANEL_HIGHT = 540;
        private JButton button;
        private Image enemy;
        private Image backgroundImage;
        private Timer timer;
        private int xVelocity = 1;
        private int x = 10;
        private int y = 370;

        IntroPanel() {
            //set this image as background.
            ImageIcon backgroundImage = new ImageIcon("gamescenter.png");
            JLabel backgroundLabel = new JLabel(backgroundImage);
            add(backgroundLabel);

            //creat button and set the size and set image as background for the button.
            ImageIcon buttonImage = new ImageIcon("playbutton.png");
            button = new JButton(buttonImage);
            button.setBounds(290, 470, buttonImage.getIconWidth(), buttonImage.getIconHeight());
            backgroundLabel.add(button);

            //add action listener to the button.        
            button.addActionListener(this);

            //the that will move.
            enemy = new ImageIcon("m1.png").getImage();

            timer = new Timer(10, this);
            timer.start();

        }

        @Override
        public void paint(Graphics g) {

            super.paint(g);// paint back ground
            Graphics2D g2D = (Graphics2D) g;
            g2D.drawImage(backgroundImage, 0, 0, null);
            g2D.drawImage(enemy, x, y, null);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            //if the user click play button, the next window will appear
            if (e.getSource() == button) {
                //new Playing(); 
                new Playing();
            }

            //the enmy should not pass the border
            if (x >= PANEL_WIDTH - enemy.getWidth(null) || x < 0) {
                xVelocity = xVelocity * -1;
            }
            x = x + xVelocity;
            repaint();
        }
    }
}
