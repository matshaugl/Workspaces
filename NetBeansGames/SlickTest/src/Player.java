
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matsh
 */
public class Player {
    
    Image player;
    int x;
    int y;
    
    public Player(){
        
    }
    
    public void init() throws SlickException{
       player = new Image("res/smil.png");
       x = 150;
       y = 200;
    }
    
    public void render() throws SlickException{
        player.draw(x, y);
    }
    
    public void update(Input input, int delta) throws SlickException{
        if (input.isKeyDown(Input.KEY_W)) {
            y -= 1*delta;
        }
        if (input.isKeyDown(Input.KEY_S)) {
            y += 1*delta;
        }
        if (input.isKeyDown(Input.KEY_A)) {
            x -= 1*delta;
        }
        if (input.isKeyDown(Input.KEY_D)) {
            x += 1*delta;
        }
    }
    
}
