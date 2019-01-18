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
            sheet = new SpriteSheet("res/BODY_skeleton.png", 64, 64);
        } catch (SlickException ex) {
            Logger.getLogger(Animator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Animation getAnimation(int row) {
        Image[] images = new Image[8];
        for(int i=0; i<8; i++){
            Image image = sheet.getSprite(i+1, row);
            images[i] = image;
        }
        System.out.println(images);
        return new Animation(images, 50);
    }
}
