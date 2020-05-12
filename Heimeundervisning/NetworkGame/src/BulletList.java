
import java.util.ArrayList;
import org.newdawn.slick.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mats
 */
public class BulletList {

    ArrayList<Projectile> bulletList;
    int maxAge;

    public BulletList() {
        bulletList = new ArrayList<Projectile>();
        maxAge = 5000;
    }

    void render(Graphics g) {
        for (int i = 0; i < bulletList.size(); i++) {
            bulletList.get(i).render(g);
        }
    }

    void update(int delta, Map map) {

        for (int i = 0; i < bulletList.size(); i++) {
            if (bulletList.get(i).update(delta, map)) {
                bulletList.remove(i);
            } else if (bulletList.get(i).getAge() > maxAge) {
                bulletList.remove(i);
            }

        }

    }

    void add(Projectile projectile) {
        bulletList.add(projectile);
    }

}
