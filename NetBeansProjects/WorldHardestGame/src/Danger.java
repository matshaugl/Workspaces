
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mathau25
 */
public class Danger {

    Circle s;
    int turnNumber = 0;
    int xPos; 
    int yPos;
    boolean growing = true;
    

    
    public Danger(){
        s = new Circle(155, 150, 100);
        
    }

    Danger(int dx, int dy, int radius) {
        xPos = dx;
        yPos = dy;
        s = new Circle(dx, dy, radius);
    }
    
    public boolean update(int delta, Shape player, boolean gameOver){
        turnNumber = turnNumber +  delta;
        if(turnNumber>1500){
            turnNumber = 0;
        }
        
        s.setLocation(xPos + (turnNumber/10), yPos + (turnNumber/10));
        if(player.intersects(s)){
            return true;
        }
        return false;
        
        
        
    }
    
    public void render(Graphics g){
        g.setColor(Color.red);
        g.draw(s);
        
    }

    
    
}


