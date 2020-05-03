
import java.util.ArrayList;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mats
 */
public class Map {
    
    ArrayList<Rectangle> walls;
    
    public Map(){
        walls = new ArrayList<Rectangle>();
        walls.add(new Rectangle(100, 100, 500, 20));
        walls.add(new Rectangle(100, 500, 500, 20));
        walls.add(new Rectangle(100, 100, 20, 500));
    }

    void render(Graphics g) {
        for (int i = 0; i < walls.size(); i++) {
            g.draw(walls.get(i));
        }
    }
    
    public ArrayList<Rectangle> getWalls(){
        return walls;
    }
    
}
