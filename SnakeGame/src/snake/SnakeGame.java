package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener{
    private boolean isPause = false;  // Pause
    private boolean isFail = false;    // Gameover

    Timer timer = new Timer(150, this);
    Random random;
    private String snakeKeyMove = "R";
    private final int width = 500;
    private final int height = 500;
    private final int unitSize = 20;
    final int startX = (int) Math.sqrt(width)*unitSize/2;
    final int startY = (int) Math.sqrt(height)*unitSize/2;
    int snakeArrayXSize = width/unitSize*height/unitSize;
    int snakeArrayYSize = width/unitSize*height/unitSize;
    //snake and apple
/*    private int[] snakeArrayX = new int[]{50};
    private int[] snakeArrayY = new int[]{60};
    private int snakeLenght = 6;*/
    private final Snake snake = new Snake (new int[snakeArrayXSize], new int[snakeArrayYSize], 1, "R", startX, startY);
    private final Apple apple = new Apple (unitSize,unitSize);

    public SnakeGame() {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.white);
        this.setFocusable(true);
        this.addKeyListener(new MyKey());
        random = new Random();
        timer.start();
    }

    public void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);
        draw(graphic);
        if (isPause) {
            graphic.setColor(Color.BLACK);
            graphic.setFont(new Font("Microsoft Yahei", Font.BOLD, unitSize));
            graphic.drawString("Press space to continue the game", width/unitSize, height/2);
        }
        if (isFail) {
            graphic.setColor(Color.RED);
            graphic.setFont(new Font("Microsoft Yahei", Font.BOLD, unitSize));
            graphic.drawString("Gameover", width/2, height/2);
        }
        repaint();
    }
    public void draw(Graphics graphic) {
        graphic.setColor(Color.GREEN);
        graphic.fillOval(apple.x, apple.y, unitSize, unitSize);
        graphic.setColor(Color.RED);
        for (int i = 0; i < snake.length; i++) {
            graphic.fillRect(snake.x[i], snake.y[i], unitSize, unitSize);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (!isFail) {
            if (!isPause) {
                if (snake.length >4) {
                    for (int i = 1; i < snake.length - 1; i++) {
                        if (snake.x[0] == snake.x[i] && snake.y[0] == snake.y[i]) {
                            isFail = !isFail;
                        }
                    }
                }
                if (snake.x[0] == apple.x && snake.y[0] == apple.y) {  //eat Apple
                    snake.length++;
                    apple.x = random.nextInt((width) / unitSize) * unitSize;
                    apple.y = random.nextInt((height) / unitSize) * unitSize;
                    START: for (int i = 0; i < snake.length; i++) {
                        if(apple.x == snake.x[i] && apple.y == snake.y[i]){
                            apple.x = random.nextInt((width) / unitSize) * unitSize;
                            apple.y = random.nextInt((height) / unitSize) * unitSize;
                            continue START;
                        }
                    }
                }
                for (int i = snake.length - 1; i > 0; i--) {  //body move
                    snake.x[i] = snake.x[i - 1];
                    snake.y[i] = snake.y[i - 1];
                }
                if (snake.move.equals("R")) {  // move right
                    snake.x[0] += unitSize;
                }
                if (snake.move.equals("U")) {  // move up
                    snake.y[0] += unitSize;
                }
                if (snake.move.equals("L")) {  // move left
                    snake.x[0] -= unitSize;
                }
                if (snake.move.equals("D")) {  // move down
                    snake.y[0] -= unitSize;
                }
                if (snake.x[0] == width) {
                    snake.x[0] = 0;
                }
                if (snake.x[0] == (-unitSize)) {
                    snake.x[0] = (width - unitSize);
                }
                if (snake.y[0] == height) {
                    snake.y[0] = 0;
                }
                if (snake.y[0] == (-unitSize)) {
                    snake.y[0] = (height - unitSize);
                }
//        System.out.println("snake.x[0] in position "  + " = " + snake.x[0]);
//        System.out.println("snake.y[0] in position "  + " = " + snake.y[0]);
                repaint();
                snake.move = snakeKeyMove;
            }
        }
    }
    public class MyKey extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            //key logic
            int keyCode = e.getKeyCode();
            if (keyCode == 32){  // space
                isPause = !isPause;
            }
            if (keyCode == 39 ||keyCode == 68){   // key right
                if(!Objects.equals(snake.move, "L")) {
                    snakeKeyMove = "R";
                }
            }
            if (keyCode == 40 ||keyCode == 83){   // key up
                if(!Objects.equals(snake.move, "D")) {
                    snakeKeyMove = "U";
                }
            }
            if (keyCode == 37 ||keyCode == 65){   // key left
                if(!Objects.equals(snake.move,"R")) {
                    snakeKeyMove = "L";
                }
            }
            if (keyCode == 38 ||keyCode == 87){    //  key down
                if(!Objects.equals(snake.move,"U")) {
                    snakeKeyMove = "D";
                }
            }
        }
    }
}