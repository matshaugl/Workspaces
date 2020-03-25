
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mats
 */
public class Plante {
    
    int type;
    SpriteSheet spriteSheet;
    int age;
    
    public Plante(){
        try {
            spriteSheet = new SpriteSheet("res/plants.png",64, 32);
        } catch (SlickException ex) {
            Logger.getLogger(Plante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
