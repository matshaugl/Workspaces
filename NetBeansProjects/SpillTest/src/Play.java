
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {
    
    Circle stein;
    Circle museklikk;


    public Play(int state) {
        
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        stein = new Circle(100, 100, 50);
        museklikk = new Circle(100,100, 10);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
      g.setColor(Color.yellow);
      g.draw(stein);
      g.setColor(Color.red);
      g.draw(museklikk);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        Input input = gc.getInput();
        if(input.isMouseButtonDown(0)){
            museklikk.setLocation(input.getMouseX(), input.getMouseY());
        }
        
        if(stein.contains(museklikk)){
            System.out.println("Nå fikk du kjempemasse stein i inventory!!!");
        }
    }

    public int getID() {
        return 1;
    }

}
