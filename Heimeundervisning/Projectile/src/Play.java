
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {

    Projectile p;
    float mouseX; 
    float mouseY;

    public Play(int state) {

    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        mouseX = 0;
        mouseY = 0;
        Vector2f vector = new Vector2f(1, 1);
        vector.normalise();
        p = new Projectile(100, 100, vector);

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor(Color.yellow);
        p.render(g);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        Input input = gc.getInput();
        if(input.isMousePressed(0)){
            mouseX = input.getMouseX();
            mouseY = input.getMouseY();
            Vector2f vector = new Vector2f(mouseX, mouseY);
            vector.normalise();
            p = new Projectile(0,0,vector);
        }
        p.update(delta);
    }

    public int getID() {
        return 1;
    }

}
