

import Animator.Animator;
import Animator.Animal;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {
    
    Animator animator;
    Animal chicken;


    public Play(int state) {
        
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        animator = new Animator();
        chicken = new Animal(animator.getAnimation(0));
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.scale(4.0f, 4.0f);
               
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        
    }

    public int getID() {
        return 1;
    }

}
