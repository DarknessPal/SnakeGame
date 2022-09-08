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
    Random random;
    // Pause and game over
    private boolean isPause = false;  // Pause
    private boolean isFail = false;    // Game over
    String pause = "Press space to continue the game";
    String fail = "Game over";
    // Game parameter
    Timer timer = new Timer(Settings.snakeSpeed, this);
    // screen parameters
    private final int unitSize = 20;
    private final int width = Settings.screenHeight - unitSize*2;
    private final int height = Settings.screenHeight - (unitSize*2);
    // Object start parameters
    private String snakeKeyMove = "R";
    final int startX = width/2-((width/2)%unitSize);
    final int startY = height/2-((height/2)%unitSize);
    //snake and apple
    private final Snake snake = new Snake (Settings.snakeLength, "R", startX, startY);  //dynamic massive
    private final Apple apple = new Apple (width/unitSize,height/unitSize, unitSize);

    public SnakeGame() {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.white);
        this.setFocusable(true);
        this.addKeyListener(new MyKey());
        this.setSize(width, height);
        this.setLayout(new FlowLayout());;
        this.setVisible(true);
        random = new Random();
        timer.start();
    }

    public void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);
        draw(graphic);
        repaint();
    }
    public void pause (Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("Ink Free", Font.BOLD, unitSize));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString(pause, (width - metrics.stringWidth(pause))/2,height/2);
    }
    public void gameOver (Graphics g){
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, unitSize));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString(fail,(width - metrics.stringWidth(fail))/2,height/2);
        }
    public void draw(Graphics g) {
        if (!isFail && !isPause) {
            for (int i = 0; i < height/unitSize; i++){
                g.setColor(Color.BLACK);
                g.drawLine(i*unitSize,0,i*unitSize,height);
                g.drawLine(0,i*unitSize, width, i*unitSize);
            }
            Color appleColor = Settings.appleColor;
            g.setColor((Settings.appleColor));
            g.fillOval(apple.x, apple.y, unitSize, unitSize);
            Color snakeColor = Settings.snakeColor;
            g.setColor((Settings.snakeColor));
            for (int i = 0; i < snake.length; i++) {
                g.fillRect(snake.x.get(i), snake.y.get(i), unitSize, unitSize);
            }
        } else if (isFail == true) {
            gameOver(g);
        }else if (isPause == true) {
            pause(g);
        }
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (!isFail && !isPause) {
            for (int i = 1; i < snake.length - 1; i++) {
                if (snake.x.get(0).equals(snake.x.get(i)) && snake.y.get(0).equals(snake.y.get(i))) {
                    isFail = true;
                }
            }
            if (snake.x.get(0) == apple.x && snake.y.get(0) == apple.y) {  //eat Apple
                snake.length++;
                snake.x.add(snake.length - 1, snake.x.get(snake.length - 2));
                snake.y.add(snake.length - 1, snake.y.get(snake.length - 2));
                apple.x = random.nextInt((width) / unitSize) * unitSize;
                apple.y = random.nextInt((height) / unitSize) * unitSize;
                while (snake.x.contains(apple.x) && snake.y.contains(apple.y)) {
                    apple.x = random.nextInt(width / unitSize) * unitSize;
                    apple.y = random.nextInt(height / unitSize) * unitSize;
                }
            }
            for (int i = snake.length - 1; i > 0; i--) {  //body move
                snake.x.set(i, snake.x.get(i - 1));
                snake.y.set(i, snake.y.get(i - 1));
            }
            switch (snake.move) {
                case "R":
                    snake.x.set(0, snake.x.get(0) + unitSize);    // move right
                    break;
                case "U":
                    snake.y.set(0, snake.y.get(0) + unitSize);  // move up
                    break;
                case "L":
                    snake.x.set(0, snake.x.get(0) - unitSize);   // move left
                    break;
                case "D":
                    snake.y.set(0, snake.y.get(0) - unitSize);  // move down
                    break;
            }
            if (snake.x.get(0) == width) {
                snake.x.set(0, 0);
            } else if (snake.x.get(0) == (-unitSize)) {
                snake.x.set(0, width - unitSize);
            } else if (snake.y.get(0) == height) {
                snake.y.set(0, 0);
            } else if (snake.y.get(0) == (-unitSize)) {
                snake.y.set(0, height - unitSize);
            }
            repaint();
            snake.move = snakeKeyMove;
        }
    }
    public class MyKey extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            //key logic
            int keyCode = e.getKeyCode();
            switch(keyCode){
                case 32: isPause = !isPause;  // space
                    break;
                case 39:
                case 68:
                    if(!Objects.equals(snake.move, "L")) {    // key right
                        snakeKeyMove = "R";
                }
                    break;
                case 40:
                case 83:
                    if(!Objects.equals(snake.move, "D")) {    // key up
                        snakeKeyMove = "U";
                    }
                    break;
                case 37:
                case 65:
                    if(!Objects.equals(snake.move,"R")) {  // key left
                        snakeKeyMove = "L";
                    }
                    break;
                case 38:
                case 87:
                    if(!Objects.equals(snake.move,"U")) {
                        snakeKeyMove = "D";
                    }
                    break;
            }
        }
    }
}