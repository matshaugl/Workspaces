
import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;
import org.newdawn.slick.util.pathfinding.AStarPathFinder;
import org.newdawn.slick.util.pathfinding.Path;

public class Play extends BasicGameState {

    Image map;
    int xSize = 3840;
    int ySize = 2160;

    public Play(int state) {

    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        map = new Image(xSize,ySize);
        Graphics g = map.getGraphics();
        for(int x = 0; x<xSize; x++){
            for(int y = 0; y<ySize; y++){
                if(x%(xSize/20)==0 || y%(xSize/20)==0){
                    g.setColor(Color.red);
                } else {
                    g.setColor(Color.black);
                }
                
                g.drawRect(x, y, x, y);
            }
        }
        g.flush();
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        map.draw(0, 0);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

        Input input = gc.getInput();
        
        if(input.isKeyPressed(Input.KEY_ESCAPE)){
            System.exit(0);
        }

    }

    public int getID() {
        return 1;
    }

}
