package snake;
import javax.swing.*;
import java.awt.*;


public class Screen extends JFrame{
    public static int set = 0;

    public Screen(){
        final int width = 400;
        final int height = 400;
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(null);
        this.setBackground(Color.white);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        if (set == 0){
            add(new MainMenu());
            setTitle("Main Menu");
        }
        if (set == 1){
            this.add(new SnakeGame());
            this.setTitle("Snake");
        }
        if (set == 2){
            this.setTitle("Settings");
        }
        this.setVisible(true);
    }
}
