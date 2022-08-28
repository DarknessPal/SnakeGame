package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener{
    private boolean isPause = false;  // Pause
    private boolean isFail = false;    // Game over

    Timer timer = new Timer(150, this);
    Random random;
    private String snakeKeyMove = "R";
    private final int width = 500;
    private final int height = 500;
    private final int unitSize = 20;
    final int startX = (int) Math.sqrt(width)*unitSize/2;
    final int startY = (int) Math.sqrt(height)*unitSize/2;
    //snake and apple
    int snakeLength = 1;
    private final Snake snake = new Snake (snakeLength, "R", startX, startY);  //dynamic massive
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
            graphic.drawString("Game over", width/2, height/2);
        }
        repaint();
    }
    public void draw(Graphics graphic) {
        graphic.setColor(Color.GREEN);
        graphic.fillOval(apple.x, apple.y, unitSize, unitSize);
        graphic.setColor(Color.RED);
        for (int i = 0; i < snake.length; i++) {
            graphic.fillRect(snake.x.get(i), snake.y.get(i), unitSize, unitSize);
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
                    for (int i = snake.length-2; i > snake.length-3; i--) {
                        snake.x.add(snake.length-1,snake.x.get(i));
                        snake.y.add(snake.length-1,snake.y.get(i));
                    }
                    apple.x = random.nextInt((width) / unitSize) * unitSize;
                    apple.y = random.nextInt((height) / unitSize) * unitSize;
                    while(Arrays.asList(snake.x).contains(apple.x) && Arrays.asList(snake.y).contains(apple.y)){
                        apple.x = random.nextInt((width) / unitSize) * unitSize;
                        apple.y = random.nextInt((height) / unitSize) * unitSize;
                    }
                }
                for (int i = snake.length-1; i > 0; i--) {  //body move
                    snake.x.set(i, snake.x.get(i-1));
                    snake.y.set(i, snake.y.get(i-1));
                }
                switch(snake.move){
                    case "R": snake.x.set(0, snake.x.get(0) + unitSize);    // move right
                    break;
                    case "U": snake.y.set(0, snake.y.get(0) + unitSize);  // move up
                    break;
                    case "L": snake.x.set(0, snake.x.get(0) - unitSize);   // move left
                    break;
                    case "D": snake.y.set(0, snake.y.get(0)- unitSize);  // move down
                    break;
                }
                if (snake.x.get(0) == width) {
                    snake.x.set(0, 0);
                }else if (snake.x.get(0) == (-unitSize)) {
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