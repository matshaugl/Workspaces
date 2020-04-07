
import java.util.ArrayList;
import org.newdawn.slick.Graphics;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mats
 */
public class BulletList {

    ArrayList<Bullet> bullets;
    
    public BulletList(){
        bullets = new ArrayList<Bullet>();
    }

    public void render(Graphics g) {
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            g.fillRect(bullet.getLocation().getX(), bullet.getLocation().getY(), 5, 5);
        }
    }

    public void addBullet(Bullet b) {
        bullets.add(b);
    }

    public void update() {
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            bullet.move();
        }
    }
}
