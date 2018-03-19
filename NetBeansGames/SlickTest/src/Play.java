
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class Play extends BasicGameState{
    
    Image smil;

    public Play(int state) {
        
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       smil = new Image("res/smil.png");
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        smil.draw(0, 0);
    
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
       
    }

    public int getID() {
        return 0;
    }
}