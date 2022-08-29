package snake;
import javax.swing.*;


public class Screen extends JFrame{

    public Screen(){
        this.add(new MainMenu());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
