
import java.util.ArrayList;
import java.util.Random;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mats
 */
public class GeoWorld {

    ArrayList<Shape> world;
    Random r;

    GeoWorld(int numbShape) {
        world = new ArrayList<Shape>();
        r = new Random();
        for (int i = 0; i < numbShape; i++) {
            this.addRandomShape();
        }
    }

    public void GeoWorld() {
        world = new ArrayList<Shape>();
        r = new Random();
    }

    public void addShape(Shape s) {
        world.add(s);
    }

    public void addRandomShape() {
        int x = r.nextInt(800);
        int y = r.nextInt(550);
        world.add(new Rectangle(x, y, 30, 30));
    }

    public void renderWorld(Graphics g) {
        for (int i = 0; i < world.size(); i++) {
            g.draw(world.get(i));
        }
    }

    public void moveWorld(int xShift) {
        for (int i = 0; i < world.size(); i++) {
            world.get(i).setX(world.get(i).getX() + xShift);
        }
    }

    public boolean intersects(Shape s) {
        for (int i = 0; i < world.size(); i++) {
            if (world.get(i).intersects(s)) {
                return true;
            }
        }
        return false;
    }
}
