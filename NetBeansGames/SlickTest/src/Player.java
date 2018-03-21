
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

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
    float x;
    float y;
    float speed = .5f;
    Circle s;
    Rectangle r; 
    
    public Player(){
        
    }
    
    public void init() throws SlickException{
       player = new Image("res/smil.png");
       x = 150;
       y = 200;
       s = new Circle(100,100,50);
       r = new Rectangle(x,y,player.getWidth(), player.getHeight());
    }
    
    public void render(Graphics g) {
        player.draw(x, y);
        g.draw(s);
    }
    
    public void update(GameContainer gc, Input input, int delta) {
        float oldX = x;
        float oldY = y;
        
        if (input.isKeyDown(Input.KEY_W)) {
            y -= speed*delta;
            if(y<0){
                y = 0;
            }
        }
        if (input.isKeyDown(Input.KEY_S)) {
            y += speed*delta;
            if(y>(gc.getHeight()-player.getHeight())){
                y = gc.getHeight()-player.getHeight();
            }
        }
        if (input.isKeyDown(Input.KEY_A)) {
            x -= speed*delta;
            if(x<0){
                x = 0;
            }
        }
        if (input.isKeyDown(Input.KEY_D)) {
            x += speed*delta;
            if(x>(gc.getWidth()-player.getWidth())){
                x = gc.getWidth()-player.getWidth();
            }
        }
        r.setX(x);
        r.setY(y);
        
        if(r.intersects(s)){
            x = oldX;
            y = oldY;
        }
    }
    
}
