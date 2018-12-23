

import Animator.Animator;
import Animator.Plant;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {
    
    Animator animator;
    Plant tomato;
    Plant potato;
    Plant carrot;
    Plant kaal;
    Plant chilly;
    Plant agurk;
    Plant korn;

    public Play(int state) {
        
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        animator = new Animator();
        tomato = new Plant(animator.getAnimation(0));
        potato = new Plant(animator.getAnimation(1));
        carrot = new Plant(animator.getAnimation(2));
        kaal = new Plant(animator.getAnimation(3));
        chilly = new Plant(animator.getAnimation(4));
        agurk = new Plant(animator.getAnimation(5));
        korn = new Plant(animator.getAnimation(6));
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.scale(4.0f, 4.0f);
        tomato.render(32,32);
        potato.render(64,32);
        carrot.render(96, 32);
        kaal.render(128, 32);
        chilly.render(160, 32);
        agurk.render(182, 32);
        korn.render(214, 32);        
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        
    }

    public int getID() {
        return 1;
    }

}
