package snake;

import javax.swing.*;

public class Screen extends JFrame {
    private int x = 500;
    private int y = 500;
    private int width = 500;
    private int height = 500;
    private int state;
    private char body;

    public Screen(){
        super("My First Window");
        setBounds(x, y, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.print("Hui");
    }
    public void drawScene(){
         for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
//                setCellColor(x, y, Color.DARKSEAGREEN);
            }
        }
    }
}
