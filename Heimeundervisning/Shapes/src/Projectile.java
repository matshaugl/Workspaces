
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mats
 */
public class Projectile {
    float xv;
    float yv;
    float x;
    float y;
    Circle s;
    /*
    public Projectile(int x, int y, int xv, int yv){
        this.x = x;
        this.y = y;
        this.xv = xv;
        this.yv = yv;
    } 
    */
    
    public Projectile(float x, float y, float x2, float y2){
        float v;
        this.x = x;
        this.y = y;
        this.xv = xv-x;
        this.yv = yv-y;
        v = (float) Math.cbrt((xv*xv)+ (xv*xv));
        xv = xv*v;
        yv = yv*v;
        s = new Circle(x, y, 5);
        
    }
    
    public void update(){
        //x = x + xv;
        //y = y + yv;
        //s.setX(x);
        //s.setY(y);
    }
    
    public void render(Graphics g){
        g.draw(s);
    }
}
