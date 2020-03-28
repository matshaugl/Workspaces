
import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {

    ArrayList<Plant> plants = new ArrayList<Plant>();
    
    int tickTid;
    int type;
    int mouseX;
    int mouseY;

    public Play(int state) {
        
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        type = 0;
        
        tickTid = 0;
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        for(int i=0; i<plants.size(); i++){
            plants.get(i).render();
        }
        
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        Input input = gc.getInput();
        tickTid = tickTid + delta;
        if(tickTid>5000){
            tickTid = 0;
            for(int i=0; i<plants.size(); i++){
                plants.get(i).update();
            }
        }
        
        if(input.isKeyPressed(Input.KEY_1)){
            type = 0;
        }
        
        if(input.isKeyPressed(Input.KEY_2)){
            type = 1;
        }
        
        if(input.isKeyPressed(Input.KEY_3)){
            type = 2;
        }
        
        if(input.isKeyPressed(Input.KEY_4)){
            type = 3;
        }
        if(input.isKeyPressed(Input.KEY_5)){
            type = 4;
        }
        
        if(input.isKeyPressed(Input.KEY_6)){
            type = 5;
        }
        
        if(input.isKeyPressed(Input.KEY_7)){
            type = 6;
        }
        
        if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
            mouseX = input.getMouseX();
            mouseY = input.getMouseY();
            plants.add(new Plant(mouseX, mouseY, type));
        }
     
    }

    public int getID() {
        return 1;
    }

}
