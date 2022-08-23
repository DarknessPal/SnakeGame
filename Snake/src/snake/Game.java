package snake;
public abstract class Game {

    public abstract void initialize();

    public class SnakeGame extends Game {


    @Override
    public void initialize() {
        createGame();
    }
    private void createGame(){
        Apple apple = new Apple (7, 7);
        apple.draw(this);
    }
/*        private void drawScene(){
            for (int x = 0; x < Snake; x++) {
                for (int y = 0; y < HEIGHT; y++) {
                    setCellColor(x, y, Color.DARKSEAGREEN);
                }
            }
        }*/
}
    }
