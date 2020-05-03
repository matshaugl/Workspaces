
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Vector2f;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mats
 */
public class Player {
    
    Circle player;
    float playerX;
    float playerY;
    float lastPlayerY;
    float lastPlayerX;
    float playerSpeed;
    
    public Player(){
        playerX = 800;
        playerY = 400;
        player = new Circle(playerX, playerY, 20);
        playerSpeed = 0.3f;
    }

    void render(Graphics g) {
        g.draw(player);
    }

    void update(int delta, Input input, Map map, BulletList bulletList) {
        float mouseX;
        float mouseY;
        
        
        lastPlayerX = playerX;
        lastPlayerY = playerY;

        if (input.isKeyDown(input.KEY_W)) {
            playerY = playerY - (playerSpeed * delta);
            player.setCenterY(playerY);
            for (int i = 0; i < map.getWalls().size(); i++) {
                if (player.intersects(map.getWalls().get(i))) {
                    playerY = lastPlayerY;
                    player.setCenterY(playerY);
                }
            }

        }

        if (input.isKeyDown(input.KEY_S)) {
            playerY = playerY + (playerSpeed * delta);
            player.setCenterY(playerY);
            for (int i = 0; i < map.getWalls().size(); i++) {
                if (player.intersects(map.getWalls().get(i))) {
                    playerY = lastPlayerY;
                    player.setCenterY(playerY);
                }
            }
        }

        if (input.isKeyDown(input.KEY_A)) {
            playerX = playerX - (playerSpeed * delta);
            player.setCenterX(playerX);
            for (int i = 0; i < map.getWalls().size(); i++) {
                if (player.intersects(map.getWalls().get(i))) {
                    playerX = lastPlayerX;
                    player.setCenterX(playerX);
                }
            }
        }

        if (input.isKeyDown(input.KEY_D)) {
            playerX = playerX + (playerSpeed * delta);
            player.setCenterX(playerX);
            for (int i = 0; i < map.getWalls().size(); i++) {
                if (player.intersects(map.getWalls().get(i))) {
                    playerX = lastPlayerX;
                    player.setCenterX(playerX);
                }
            }
        }

        if (input.isMousePressed(0)) {
            mouseX = input.getMouseX();
            mouseY = input.getMouseY();
            Vector2f vector = new Vector2f(mouseX - playerX, mouseY - playerY);
            vector.normalise();
            bulletList.add(new SplintBomb(playerX, playerY, input.getMouseX(), input.getMouseY(), vector));
        }
    }
    
}
