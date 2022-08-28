package snake;

import java.util.ArrayList;

public class Snake {
    ArrayList<Integer> x, y;
    String move;
    int length;
    public Snake (int length, String move, int startX, int startY)
    {
        this.x = new ArrayList<>();
        this.y = new ArrayList<>();
        this.length = length;
        this.move = move;
        x.add(0, startX);
        y.add(0, startY);
    }
}