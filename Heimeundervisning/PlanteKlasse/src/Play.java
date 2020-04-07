
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {

    Plant plant;
    int tickTid;

    public Play(int state) {
        
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        tickTid = 0;
        plant = new Plant(0,0,5);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        plant.render();
        
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        tickTid = tickTid + delta;
        if(tickTid>5000){
            tickTid = 0;
            System.out.println("5 sekund har pasert");
            plant.update();
        }
     
    }

    public int getID() {
        return 1;
    }

}
