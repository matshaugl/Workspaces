
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mats
 */
public class SlickSoundPlayer {
    Sound fx;
    
    public SlickSoundPlayer(){
        try {
            fx = new Sound("res/pewpew.wav");
        } catch (SlickException ex) {
            Logger.getLogger(SlickSoundPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void playSound(){
        fx.play();
    }
}
