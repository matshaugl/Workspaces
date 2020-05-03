
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {

    Circle c;
    Circle c2;
    float x = 0;
    

    public Play(int state) {
        
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        c = new Circle(100, 100, 50);
        c2 = new Circle(140, 100, 50);

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor(Color.yellow);
        g.draw(c);
        g.draw(c2);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        System.out.println(c.intersects(c2));
        x = x + 0.2f;
        c.setCenterX(x);
        
     
    }

    public int getID() {
        return 1;
    }

}
