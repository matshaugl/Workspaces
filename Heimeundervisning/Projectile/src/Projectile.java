
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mats
 */
public class Projectile {
    
    float x;
    float y;
    float speed;
    Vector2f direction;
    Circle circle;
    
    public Projectile(){
        x = 200;
        y = 200;
        speed = 10f;
        direction = new Vector2f(100, 100);
        direction.normalise();
        circle = new Circle(x,y,5);
    }
    
    public void render(Graphics g){
        g.setColor(Color.yellow);
        g.draw(circle);
    }
    
    public void update(){
        x = x + (direction.x * speed);
        y = y + (direction.y * speed);
        circle.setCenterX(x);
        circle.setCenterY(y);
    }
}
