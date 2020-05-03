

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
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
public class Projectile {

    float x;
    float y;
    Vector2f direction;
    float speed;
    public Circle projectile;

    public Projectile(float x, float y, Vector2f direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        speed = 0.3f;
        projectile = new Circle(x,y,1);
    }

    public void render(Graphics g) {
        g.draw(projectile);
    }

    public void update(int delta) {
        x = x + (direction.x * (speed * delta));
        y = y + (direction.y * (speed * delta));
        projectile.setLocation(x, y);

    }
    
    
}
