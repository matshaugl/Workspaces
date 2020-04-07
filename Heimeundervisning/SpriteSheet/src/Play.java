
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {

    Plant plant;

    public Play(int state) {
        
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        plant = new Plant();
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        plant.render();
        
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        
     
    }

    public int getID() {
        return 1;
    }

}
