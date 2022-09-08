package snake;
import javax.swing.*;
import java.awt.*;


public class Screen extends JFrame{
    public static int set = 0;

    public Screen() {
        final int width = Settings.screenWidth;
        final int height = Settings.screenHeight;
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(null);
        this.setBackground(Color.white);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        add(new MainMenu());
        setTitle("Main Menu");
        Container content = getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        this.setVisible(true);
    }
}
