package snake;
import javax.swing.*;


public class Screen extends JFrame{

    public Screen(){
        this.add(new SnakeGame());
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
