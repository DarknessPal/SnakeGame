package snake;

public class Snake {
    int [] x, y;
    int startX, startY;
    String move;
    int length;
    public Snake (int[] x, int[] y, int length, String move, int startX, int startY)
    {
        this.x = x;
        this.y = y;
        this.length = length;
        this.move = move;
        this.x [0] = startX;
        this.y [0] = startY;
    }
}

