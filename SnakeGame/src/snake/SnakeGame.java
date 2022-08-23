package snake;

public class SnakeGame extends Game {


    @Override
    public void initialize() {
        createGame();
    }
    private void createGame(){
        Apple apple = new Apple (7, 7);
        apple.draw(this);
    }
}