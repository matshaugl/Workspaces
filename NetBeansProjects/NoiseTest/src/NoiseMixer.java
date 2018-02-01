
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matsh
 */
public class NoiseMixer {
    
    public NoiseMixer(){
        
    }
    
    public Image getNoiseImage(){
        int size = 200;
        Graphics g = null;
        try {
            Image img = new Image(size,size);
            g = img.getGraphics();
        } catch (SlickException ex) {
            Logger.getLogger(NoiseMixer.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int y=0; y<size; y++){
            for(int x=0; x<size; x++){
                
            }
        }
        g.flush();
        return null;
    }
    
}
