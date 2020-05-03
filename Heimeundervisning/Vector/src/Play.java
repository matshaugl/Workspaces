
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {

    int x;
    int y;
    Circle mousePos;
    Vector2f direction;

    public Play(int state) {
        
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        x = 100;
        y = 100;
        mousePos = new Circle(x,y,1);
        direction = new Vector2f (0,0);

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor(Color.yellow);
        g.draw(mousePos);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        Input input = gc.getInput();
        
        if(input.isMouseButtonDown(0)){
            x = input.getMouseX();
            y = input.getMouseY();
            direction = new Vector2f(x,y);
            direction.normalise();
        }
        
        mousePos.setLocation(x, y);
        
     
    }

    public int getID() {
        return 1;
    }

}
