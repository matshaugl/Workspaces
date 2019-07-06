
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mathau25
 */
public class Food {

    Circle s;
    long age;

    
    public Food(){
        s = new Circle(155, 150, 50);
        age = 0;
    }
    
    public void update(int delta){
        age += delta;
        s.setRadius(age / 1000);
    }
    
    public void render(Graphics g){
        
        g.draw(s);
        
    }
    
    public long bliSpist(){
        return age;
    }
    
    
}


