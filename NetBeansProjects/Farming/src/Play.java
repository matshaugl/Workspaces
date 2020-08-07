
import Animator.Animator;
import Animator.Plant;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {
    
    Image si;
    Graphics sg;
    Image image;
    
    public Play(int state) {
        
    }
    
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        si = new Image(100, 100);
        image = new Image(100, 100);
        sg = si.getGraphics();
        sg.setColor(Color.yellow);
        sg.draw(new Circle(50, 50, 15));
        sg.copyArea(image, 0, 0);
        sg.flush();
        
    }
    
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        image.draw(0, 0);
    }
    
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        
    }
    
    public int getID() {
        return 1;
    }
    
}
