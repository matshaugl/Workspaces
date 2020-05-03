
import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
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
public class SplintBomb {

    float x;
    float y;
    float targetX;
    float targetY;
    Vector2f direction;
    float speed;
    Circle projectile;
    int age;

    public SplintBomb(float x, float y, float targetX, float targetY, Vector2f direction) {
        age = 0;
        this.x = x;
        this.y = y;
        this.targetX = targetX;
        this.targetY = targetY;
        this.direction = direction;
        speed = 0.3f;
        projectile = new Circle(x, y, 1);
    }

    public void render(Graphics g) {
        g.draw(projectile);
    }

    /**
     *
     * Returns true if bullet collision
     */
    public boolean update(int delta, Map map) {
        x = x + (direction.x * (speed * delta));
        y = y + (direction.y * (speed * delta));
        projectile.setLocation(x, y);
        age = age + delta;
        ArrayList<Rectangle> walls = map.getWalls();
        for (int i = 0; i < walls.size(); i++) {
            if (walls.get(i).contains(x, y)) {
                return true;
            }
        }
        if(((targetX-x) < 2) && ((targetY-y) < 2))
            return true;
        return false;
    }

    public int getAge() {
        return age;
    }

}
