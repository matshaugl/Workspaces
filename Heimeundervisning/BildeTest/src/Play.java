
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {

    Image img;
    int x = 200;
    int y = 200;

    public Play(int state) {
        
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        img = new Image("res/smil.jpg");

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        img.draw(x, y);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

     
    }

    public int getID() {
        return 1;
    }

}
