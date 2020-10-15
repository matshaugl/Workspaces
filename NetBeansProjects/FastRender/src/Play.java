
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {
    
    //Image staticImage;
    //Graphics staticG;
    
    public static Image staticImg = null;
    public static Graphics staticImgG = null;
    
    Render render;
    
    
    
    public Play(int state) {
        
    }
    
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        
        
        try {
            
                staticImg = new Image(256,256);
                staticImgG = staticImg.getGraphics();
        } catch (SlickException e) {
                
        }
        render = new Render();
        render.init();
        
        /*
        staticImage = new Image(320,320);
        long start = System.currentTimeMillis();
        
        staticG = staticImage.getGraphics();
        
        System.out.println(System.currentTimeMillis() - start);
        

*/
        
    }
    
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        render.render(g);
  
    }
    
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        
    }
    
    public int getID() {
        return 1;
    }
    
}
