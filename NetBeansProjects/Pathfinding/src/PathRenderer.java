
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
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
public class PathRenderer{
    
    Image pathImage;
    Path path;
    
    public PathRenderer(Path p){
        path = p;
        try {
            pathImage = new Image("res/path.png");
        } catch (SlickException ex) {
            Logger.getLogger(PathRenderer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void render(Graphics g){
        for(int i=0; i<path.getLength(); i++){
            g.drawImage(pathImage, path.getStep(i).getX() * 32, path.getStep(i).getY() * 32);
        }
    }

    void updatePath(Path path) {
        this.path = path;
    }
    
}
