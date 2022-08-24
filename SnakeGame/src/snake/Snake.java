package snake;

public class Snake {
    private int length;//Длина тела
    private int[] snakeX;// Определяем абсциссу каждой точки, составляющей тело
    private int[] snakeY;// Определяем продольную координату каждой точки тела
    private String headPath;
    public Snake(int[]snakeX, int[] snakeY, String headPath)
    {
        this.snakeX = snakeX;
        this.snakeY = snakeY;
        this.headPath = headPath;
    }
}
