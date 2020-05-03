import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {


    Circle player;
    Rectangle wall;
    
    float playerX;
    float playerY;             
    float lastPlayerY;
    float lastPlayerX;
    float playerSpeed;

    public Play(int state) {
        
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        wall = new Rectangle(100,100,500,20);
        playerX = 800;
        playerY = 400;
        player = new Circle(playerX, playerY, 20);
        playerSpeed = 0.3f;

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor(Color.yellow);
        g.draw(player);
        g.draw(wall);
        
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        Input input = gc.getInput();
        
        lastPlayerX = playerX;
        lastPlayerY = playerY;
        
        if(input.isKeyDown(input.KEY_W)){
            playerY = playerY - (playerSpeed * delta);
        }
        
        if(input.isKeyDown(input.KEY_S)){
            playerY = playerY + (playerSpeed * delta);
        }
        
        if(input.isKeyDown(input.KEY_A)){
            playerX = playerX - (playerSpeed * delta);
        }
        
        if(input.isKeyDown(input.KEY_D)){
            playerX = playerX + (playerSpeed * delta);
        }
        
        player.setCenterX(playerX);
        player.setCenterY(playerY);
        
        if(player.intersects(wall)){
            playerX = lastPlayerX;
            playerY = lastPlayerY;
            player.setCenterX(playerX);
            player.setCenterY(playerY);
        }
        
    }

    public int getID() {
        return 1;
    }

}
