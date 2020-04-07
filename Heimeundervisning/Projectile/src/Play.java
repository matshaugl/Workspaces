
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {

    Projectile bullet;

    public Play(int state) {
        
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        bullet = new Projectile();

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        bullet.render(g);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        bullet.update();
    }

    public int getID() {
        return 1;
    }

}
