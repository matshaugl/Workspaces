
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mats
 */
public class Animator {
    
    private SpriteSheet sheet;
    
    public Animator(){
        try {
            sheet = new SpriteSheet("res/link_red_30x26.png", 30, 26);
        } catch (SlickException ex) {
            Logger.getLogger(Animator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Image[] loadImages(int x, int numb){
        Image[] images = new Image[10];
        for(int i=0; i<numb; i++){
            Image image = sheet.getSprite(x, i+1).getScaledCopy(2.0f);
            images[i] = image;
        }
        return images;
        
    }

    Animation getAnimation(int x, int numb) {
        Image[] imageArray = loadImages(x, numb);
        return new Animation(imageArray, 50);
    }
}
