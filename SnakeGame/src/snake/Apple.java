package snake;
import java.util.Random;
public class Apple{
 Random random = new Random();
    int x,y;
    public Apple (int x, int y){
        this.x = random.nextInt(x)*20;
        this.y = random.nextInt(y)*20;
    }
}
