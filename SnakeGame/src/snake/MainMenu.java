package snake;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainMenu extends JFrame implements ActionListener {

//    private static final long serialVersionUID = 1L;
    public MainMenu() {
        JFrame frame = new JFrame("Game menu");
        final int width = 400;
        final int height = 400;
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.white);
        this.setFocusable(true);
        //    this.addKeyListener(new MainMenu.MyKey());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);

        // set flow layout for the frame
        this.getContentPane().setLayout(new FlowLayout());

        JButton startGameButton = new JButton("Star the new game");

        //add Button
        add(startGameButton);

        //set action listeners for buttons
        startGameButton.addActionListener(this);

        // define a custom short action command for the button
        startGameButton.setActionCommand("Start the new game");

        // add button to frame
        add(startGameButton);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals("Start the new game")) {
            this.add(new SnakeGame());
            this.setTitle("Snake");
        }
    }

    private static void createAndShowGUI() {

        //Create and set up the window.

        JFrame frame = new MainMenu();

        //Display the window.

        frame.pack();

        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

  /*  public static void main(String[] args) {

        //Schedule a job for the event-dispatching thread:

        //creating and showing this application's GUI.

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }*/
}