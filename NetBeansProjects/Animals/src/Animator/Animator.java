package Animator;


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
            
            sheet = new SpriteSheet("res/plants.png", 32, 64);
        } catch (SlickException ex) {
            Logger.getLogger(Animator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Animation getAnimation(int row) {
        Image[] images = new Image[6];
        for(int i=0; i<6; i++){
            Image image = sheet.getSprite(row, i);
            images[i] = image;
        }
        System.out.println(images);
        return new Animation(images, 2000);
    }
}
