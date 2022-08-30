package snake;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainMenu extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

    public MainMenu() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        //    this.addKeyListener(new MainMenu.MyKey());
        // set flow layout for the frame
        JButton startGameButton = new JButton("Star the new game");
        JButton settingGameButton = new JButton("Settings");
        JButton exit = new JButton("Exit");
        //add Button
        add(startGameButton);
        add(settingGameButton);
        add(exit);
        //set action listeners for buttons
        startGameButton.addActionListener(this);
        settingGameButton.addActionListener(this);
        exit.addActionListener(this);
        // define a custom short action command for the button
        startGameButton.setActionCommand("Start the new game");
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals("Start the new game")) {
            Screen.set = 1;

        }
        if (action.equals("Settings")) {
            Screen.set = 2;
        }
        if (action.equals("Exit")) {
            System.exit(0);
        }

    }
    private static void createAndShowGUI() {

    }
}