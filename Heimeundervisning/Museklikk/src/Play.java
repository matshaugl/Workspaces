
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {

    Image tree;
    int x;
    int y;

    public Play(int state) {
        
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        tree = new Image("res/tree.png");
        x = 0;
        y = 0;

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        tree.draw(x, y);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        Input input = gc.getInput();
        
        if(input.isMouseButtonDown(0)){
            x = input.getMouseX();
            y = input.getMouseY();
        }
     
    }

    public int getID() {
        return 1;
    }

}
