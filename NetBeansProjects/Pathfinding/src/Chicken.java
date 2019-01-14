
import java.util.logging.Level;
import java.util.logging.Logger;
import net.java.games.input.Component;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.pathfinding.AStarPathFinder;
import org.newdawn.slick.util.pathfinding.Mover;
import org.newdawn.slick.util.pathfinding.Path;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author matsh
 */
public class Chicken implements Mover {

    int x;
    int y;
    Image chicken;
    Path path;
    int currentStep;
    boolean moving;
    Map map;
    boolean ready = true;
    int counter;
    int lastCount;

    AStarPathFinder pFinder;

    public Chicken(Map map, int x, int y) {
        this.map = map;
        this.x = x;
        this.y = y;
        //ready = true;
        try {
            String s = "res/chicken.png";
            System.out.println(s);
            chicken = new Image(s);
        } catch (SlickException ex) {
            Logger.getLogger(Chicken.class.getName()).log(Level.SEVERE, null, ex);
        }

        moving = false;
        lastCount = 0;
        currentStep = 0;
        counter = 0;
        pFinder = new AStarPathFinder(map, 200, false);
    }

    public void init() {

    }

    public void render(Graphics g) {
        g.drawImage(chicken, x * 32, y * 32);
    }

    public void moveTo(int targetX, int targetY) {
        if (!(targetX == x && targetY == y) && !map.blocked(targetX, targetY)) {
            path = null;
            pFinder = null;
            pFinder = new AStarPathFinder(map, 200, false);
            long start = System.currentTimeMillis();
            path = pFinder.findPath(this, x, y, targetX, targetY);
            System.out.println("Path find time: " + (System.currentTimeMillis() - start));
            moving = true;
            currentStep = 0;

            //System.out.println("moving=true");
            //System.out.println("Path length" + path.getLength());
        }
    }

    void update(Input input, int delta, Map map) {
        counter = (counter + delta);
        //System.out.println(counter);
        int counterSeconds = counter / 100;

        if (counterSeconds > lastCount) {
            lastCount = counterSeconds;
            ready = true;
            //System.out.println(lastCount);
        }
        //System.out.println(counter / 1000);
        if (input.isKeyPressed(Input.KEY_A)) {
            x = x - 1;
            if (map.blocked(x, y)) {
                x = x + 1;
            }
        }
        if (input.isKeyPressed(Input.KEY_D)) {
            x = x + 1;
            if (map.blocked(x, y)) {
                x = x - 1;
            }
        }
        if (input.isKeyPressed(Input.KEY_W)) {
            y = y - 1;
            if (map.blocked(x, y)) {
                y = y + 1;
            }
        }
        if (input.isKeyPressed(Input.KEY_S)) {
            y = y + 1;
            if (map.blocked(x, y)) {
                y = y - 1;
            }
        }

        try {
            //System.out.println(moving);
            if (moving && currentStep <= path.getLength() && ready) {
                x = path.getStep(currentStep).getX();
                y = path.getStep(currentStep).getY();
                currentStep++;
                ready = false;
                //System.out.println("Walking");
                if (currentStep == path.getLength()) {
                    moving = false;
                    currentStep = 0;
                    System.out.println(path.getLength());
                }

            }
        } catch (Exception ex) {
            System.out.print("x: " + x);
            System.out.print("y: " + y);
            System.out.println("CurrentStep: " + currentStep);

            Logger.getLogger(Chicken.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Path getPaht() {
        return path;
    }

}
