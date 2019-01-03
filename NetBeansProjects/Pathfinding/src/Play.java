
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {
    
    Map map;
    
    public Play(int state) {
        
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        map = new Map();
        map.init();
        
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        map.render(g);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        
    }

    public int getID() {
        return 1;
    }

}
