
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

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
    Circle player;
    float playerX;
    float playerY;
    
    public Player(){
        
    }
    
    public void init(){
        player = new Circle(0, 0, 20);
        playerX = 0;
        playerY =  0;
    }
    
    public void render(){
        
    }
    
    public void update(){
        
    }
    
    public boolean intersects (Shape s){
        return player.intersects(s);
    }
    
}
