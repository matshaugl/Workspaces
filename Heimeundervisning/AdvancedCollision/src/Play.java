
import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {
    
    Circle player;
    ArrayList<Rectangle> walls;
    
    float playerX;
    float playerY;
    float lastPlayerY;
    float lastPlayerX;
    float playerSpeed;
    
    public Play(int state) {
        
    }
    
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        walls = new ArrayList<Rectangle>();
        walls.add(new Rectangle(100, 100, 500, 20));
        walls.add(new Rectangle(100, 500, 500, 20));
        walls.add(new Rectangle(100, 100, 20, 500));
        playerX = 800;
        playerY = 400;
        player = new Circle(playerX, playerY, 20);
        playerSpeed = 0.3f;
        
    }
    
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor(Color.yellow);
        g.draw(player);
        for (int i = 0; i < walls.size(); i++) {
            g.draw(walls.get(i));
        }
        
    }
    
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        Input input = gc.getInput();
        
        lastPlayerX = playerX;
        lastPlayerY = playerY;
        
        if (input.isKeyDown(input.KEY_W)) {
            playerY = playerY - (playerSpeed * delta);
            player.setCenterY(playerY);
            for (int i = 0; i < walls.size(); i++) {
                if (player.intersects(walls.get(i))) {
                    playerY = lastPlayerY;
                    player.setCenterY(playerY);
                }
            }
            
        }
        
        if (input.isKeyDown(input.KEY_S)) {
            playerY = playerY + (playerSpeed * delta);
            player.setCenterY(playerY);
            for (int i = 0; i < walls.size(); i++) {
                if (player.intersects(walls.get(i))) {
                    playerY = lastPlayerY;
                    player.setCenterY(playerY);
                }
            }
        }
        
        if (input.isKeyDown(input.KEY_A)) {
            playerX = playerX - (playerSpeed * delta);
            player.setCenterX(playerX);
            for (int i = 0; i < walls.size(); i++) {
                if (player.intersects(walls.get(i))) {
                    playerX = lastPlayerX;
                    player.setCenterX(playerX);
                }
            }
        }
        
        if (input.isKeyDown(input.KEY_D)) {
            playerX = playerX + (playerSpeed * delta);
            player.setCenterX(playerX);
            for (int i = 0; i < walls.size(); i++) {
                if (player.intersects(walls.get(i))) {
                    playerX = lastPlayerX;
                    player.setCenterX(playerX);
                }
            }
        }
        
    }
    
    public int getID() {
        return 1;
    }
    
}
