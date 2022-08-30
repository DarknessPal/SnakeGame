package snake;
import javax.swing.*;
import java.awt.*;


public class Screen extends JFrame{
    public static int set = 0;

    public Screen() {
        final int width = 400;
        final int height = 420;
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(null);
        this.setBackground(Color.white);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        add(new MainMenu());
        setTitle("Main Menu");
        this.setVisible(true);
    }
}
