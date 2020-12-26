
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
    
    public SlickSoundPlayer(String path){
        try {
            fx = new Sound(path);
        } catch (SlickException ex) {
            Logger.getLogger(SlickSoundPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void play(float volume){
        fx.play(1.0f, volume);
    }
    
    public void loop(float volume) {
    	fx.loop(1.0f, volume);
    }
    
    public void stop() {
    	fx.stop();
    }
}
