

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.*;

import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {


    Message message;

    BulletList bulletList;

    Map map;
    Player player;

    public Play(int state) {

    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

        bulletList = new BulletList();

        map = new Map();
        player = new Player();

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor(Color.yellow);

        player.render(g);

        map.render(g);

        bulletList.render(g);

    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        Input input = gc.getInput();

        player.update(delta, input, map, bulletList);

        bulletList.update(delta, map);

    }

    public int getID() {
        return 1;
    }

}
