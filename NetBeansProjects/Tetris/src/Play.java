
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {
    
    Rectangle spillbrett;
    Rectangle block;
    Boolean newStep = true;
    int deltaTurn= 0;
    int turnSpeed = 500;

    public Play(int state) {
        
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        spillbrett = new Rectangle (20*32, 5*32, 32*10, 32*20);
        block = new Rectangle (32 * 25, 32*5, 32, 32);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
      g.setColor(Color.yellow);
      g.draw(spillbrett);
      g.setColor(Color.red);
      g.draw(block);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        deltaTurn += delta;
        if(deltaTurn>turnSpeed){
            newStep = true;
            deltaTurn = 0;
            block.setLocation(block.getX(), block.getY()+32);
        }
    }

    public int getID() {
        return 1;
    }

}
