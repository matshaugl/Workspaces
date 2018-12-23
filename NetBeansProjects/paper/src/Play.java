
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.ShapeRenderer;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {

    Player player;
    //Image player;
    Circle danger;
    float vX;
    float vY;
    float dangerX;
    float dangerY;
    
    ShapeRenderer sr;
    
    public Play(int state) {
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
         //player = new Image("res/player.png");
         player = new Player();
         player.init();
         danger = new Circle(400, 200, 30);
         vX = 0.1f;
         vY = 0.1f;
         dangerX = 100;
         dangerY = 100;
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        //player.draw(playerX,playerY);
        if(player.intersects(danger)){
            g.setColor(Color.yellow);
        } else {
            g.setColor(Color.white);
        }
        sr.fill(player);
        g.setColor(Color.red);
        sr.fill(danger);
        

    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        
        Input input = gc.getInput();
        float oldPlayerX = playerX;
        float oldPlayerY = playerY;
        
        if (input.isKeyDown(Input.KEY_S)) {
            playerY += delta * .5f;
        }
        
        if (input.isKeyDown(Input.KEY_W)) {
            playerY -= delta * .5f;
        }
        
        if (input.isKeyDown(Input.KEY_D)) {
            playerX += delta * .5f;
        }
        
        if (input.isKeyDown(Input.KEY_A)) {
            playerX -= delta * .5f;
        }
        
        player.setCenterX(playerX);
        player.setCenterY(playerY);
        
        if(player.intersects(danger)){
            playerX = oldPlayerX;
            playerY = oldPlayerY;
            player.setCenterX(playerX);
            player.setCenterY(playerY);
        }
        
        dangerX += vX;
        dangerY += vY;
        danger.setCenterX(dangerX);
        danger.setCenterY(dangerY);
        
        //playerX = playerX + (vX/delta);
        //playerY = playerY + (vY/delta);
    }

    public int getID() {
        return 1;
    }

}
