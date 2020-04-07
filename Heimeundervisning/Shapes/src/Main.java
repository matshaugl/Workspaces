
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Main extends StateBasedGame {

    public static final String gamename = "Link`s Adventure";
    public static final int play = 0;
    public static final int xSize = 800;
    public static final int ySize = 600;

    public Main(String gamename) {
        super(gamename);
        this.addState(new Play());
    }

    public void initStatesList(GameContainer gc) throws SlickException {
        this.getState(play).init(gc, this);
        this.enterState(play);
    }

    public static void main(String[] args) {
        AppGameContainer appgc;
        try {
            appgc = new AppGameContainer(new Main(gamename));
            appgc.setDisplayMode(xSize, ySize, false);
            //Prøve å holde fps nede
            appgc.setTargetFrameRate(60);
            appgc.setMaximumLogicUpdateInterval(1000 / 60);
            appgc.setMinimumLogicUpdateInterval(1000 / 60);
            appgc.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}