
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;
import org.newdawn.slick.util.pathfinding.AStarPathFinder;
import org.newdawn.slick.util.pathfinding.Path;

public class Play extends BasicGameState {

    Map map;
    Chicken chicken;
    AStarPathFinder pFinder;
    PathRenderer pr;

    public Play(int state) {

    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        map = new Map();
        map.init();
        chicken = new Chicken(map, 1, 1);
        pFinder = new AStarPathFinder(map, 200, false);
        pr = new PathRenderer();

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        //g.scale(1.5f, 1.5f);
        map.render(g);
        chicken.render(g);

        pr.render(g);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

        Input input = gc.getInput();
        if (input.isMousePressed(0)) {
            int xPos = input.getMouseX() / 32;
            int yPos = input.getMouseY() / 32;

            chicken.moveTo(xPos, yPos);

            //chicken.moveTo(pFinder.findPath(chicken, chicken.x, chicken.y, xPos, yPos));
            pr.updatePath(chicken.getPaht());
            //newPath = pFinder.findPath(chicken, chicken.x, chicken.y, xPos, yPos);
            //System.out.println("x: " + input.getMouseX() / 32 + "y: " + input.getMouseY() / 32);
            //newPath = pFinder.findPath(chicken, chicken.x, chicken.y, 10, 2);
        }
        chicken.update(gc.getInput(), delta, map);
    }

    public int getID() {
        return 1;
    }

}
