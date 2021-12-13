package mockito;

public class Game {
    GameLevel gameLevel;
    GameNumGen gameNumGen;
    String gameNum;
    public Game(GameNumGen gameNumGen) {
        this.gameNumGen = gameNumGen;
    }

    public void init(GameLevel gameLevel) {
        gameNum = gameNumGen.generate(gameLevel);
    }
}
