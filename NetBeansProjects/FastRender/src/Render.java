
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
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
 * @author mathau
 */
public class Render {
    
    Image img;
    
    Image smilImg;
    
    public void init(){
        
        
        
        
        try {
            img = new Image(256, 256);
            smilImg = new Image("res/smil.png");
        } catch (SlickException ex) {
            Logger.getLogger(Render.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Play.staticImgG.setColor(Color.yellow);
        Play.staticImgG.drawImage(smilImg, 0, 0);
        
        Play.staticImgG.copyArea(img, 0, 0);
        
        Play.staticImgG.flush();
        
        //img.rotate(180);
        long start = System.currentTimeMillis();
        img = img.getFlippedCopy(false, true);
        System.out.println(System.currentTimeMillis() - start);
    }
    
    public void render(Graphics g){
        img.draw(0, 0);
    }
}
