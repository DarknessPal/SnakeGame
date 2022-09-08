package snake;

import java.awt.*;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainMenu extends JPanel implements ActionListener {

//    private static final long serialVersionUID = 1L;
    public MainMenu() {
        setLayout(null);
        Insets insets = getInsets();
        // set flow layout for the frame
        JButton startGameButton = new JButton("Star the new game");
        JButton settingGameButton = new JButton("Settings");
        JButton exitButton = new JButton("Exit");
        //add Button
        add(startGameButton);
        add(settingGameButton);
        add(exitButton);
        //set action listeners for buttons
        Dimension size = startGameButton.getPreferredSize();
        startGameButton.setBounds(150 + insets.left, 50 + insets.top,
                size.width, size.height);
        settingGameButton.setBounds(150 + insets.left, 150 + insets.top,
                size.width, size.height);
        exitButton.setBounds(150 + insets.left, 250 + insets.top,
                size.width, size.height);
//        settingGameButton.addActionListener(this);
 //      exitButton.addActionListener(this);
        // define a custom short action command for the button
        startGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SnakeGame snakeGame = new SnakeGame();
                add(snakeGame);
                snakeGame.requestFocus();
            }
        });
        settingGameButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Settings settings = new Settings();
                add(settings);
                settings.requestFocus();
            }
        });
        exitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
   //     setLayout(new GridLayout(3,1));
        setSize(400, 400);
        setVisible(true);
    }
       @Override
      public void actionPerformed(ActionEvent ae) {
            String action = ae.getActionCommand();

        }
    private static void createAndShowGUI() {

    }

}