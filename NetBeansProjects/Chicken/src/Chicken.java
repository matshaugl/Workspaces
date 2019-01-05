
import java.util.logging.Level;
import java.util.logging.Logger;
import net.java.games.input.Component;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
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

    public Chicken(int x, int y) {
        this.x = x;
        this.y = y;
        try {
            chicken = new Image("res/chicken2.png");
        } catch (SlickException ex) {
            Logger.getLogger(Chicken.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("new chicken");
        moving = false;
        currentStep = 0;
    }

    public void init() {

    }

    public void render(Graphics g) {
        g.drawImage(chicken, x * 32, y * 32);
    }

    public void moveTo(Path path) {
        this.path = path;
        moving = true;
        System.out.println("moving=true");
    }

    void update(Input input, int delta, Map map) {
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

        //System.out.println(moving);
        if (moving && currentStep < path.getLength()) {
            x = path.getStep(currentStep++).getX();
            y = path.getStep(currentStep++).getY();
            //System.out.println("Walking");
            if (currentStep == path.getLength() - 1) {
                moving = false;
                currentStep = 0;
                System.out.println(path.getLength());
            }
        }
    }

    public Path getPaht() {
        return path;
    }

}
