package snake;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Screen extends JFrame implements KeyListener, ActionListener {
    private int x = 500;
    private int y = 500;
    private int width = 500;
    private int height = 500;
    private int state;
    private char body;

    public Screen(){
        super("My First Window");
        setBounds(x, y, width, height);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        add(new Screen());
        setVisible(true);
    }
//    private boolean isStart = false;// ???? ?? ????????? ?? ???????????
//    private boolean isFail = false;// ???? ?? ????????? ?? ????????
    public void GamePanel() {
        init();// ????????????? ????
        this.setFocusable(true);// ???????? ????? ???????
        this.addKeyListener(this);// ???????? ??????? ???????? ??????????
    }
    public void init() {
        Snake snake = new Snake(new int[]{500}, new int[]{600}, "U");
        int snakeLength = 1;
        Random random = new Random();
        Apple apple = new Apple(random.nextInt(34),random.nextInt(24));
    }

//    @Override
    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);// ??????? ??????? ??????


        // ?????????? ??????????? ? ??????? ???? ?? ??????? ????????
/*        if (!isStart) {// ????????????? ??? ?? ????????? ????
            g.setColor(Color.WHITE);// ????????????? ???? ?????
            g.setFont(new Font("Microsoft Yahei", Font.BOLD, 40));// ????????? ??????, Microsoft Yahei, Bold, No. 40
            g.drawString(???????? ??????, ????? ?????? ?????, 300, 300);// ????????????? ?????????? ? ?????????????? ?????????
        }
        if (isFail) {// ???????
            g.setColor(Color.RED);// ????????????? ???? ?????
            g.setFont(new Font("Microsoft Yahei", Font.BOLD, 40));// ????????? ??????, Microsoft Yahei, Bold, No. 40
            g.drawString("???? ?????????", 300, 300);// ????????????? ?????????? ? ?????????????? ?????????
        }*/
        apple.Color.RED.getRGB();
        repaint();// ???????? ?????????
    }
    @Override
    public void actionPerformed(ActionEvent e) {

 //           repaint();// ???????? ?????????
 //       }
    }


    // ??????? ??????????, ??????????????? ????? ??????? ??????? ??????????
    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();// ???????? ???????? ?????, ????????? ? ??????????


    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
