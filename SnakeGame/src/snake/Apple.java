package snake;
import java.util.Random;
public class Apple{
 Random random = new Random();
    int x,y, unitSize;
    public Apple (int x, int y, int unitSize){
        this.x = random.nextInt(x)*unitSize;
        this.y = random.nextInt(y)*unitSize;
    }
}
