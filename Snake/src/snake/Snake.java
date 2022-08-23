package snake;
import javax.swing.*;
public class Snake extends JFrame {
    private int x = 15;
    private int y = 15;
    private int width = 0;
    private int height = 0;
    private int state;
    private char body;

    public Snake(){
        super("My First Window"); //Заголовок окна
        setBounds(x, y, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Snake app = new Snake();
        app.setVisible(true);
    }


}


