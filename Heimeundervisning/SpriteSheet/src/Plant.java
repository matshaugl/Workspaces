
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
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
public class Plant {
    
    SpriteSheet plantSheet;
    Image plantImage;
    
    public Plant(){
        try {
            plantSheet = new SpriteSheet("res/plants.png",32,64);
            plantImage = plantSheet.getSprite(6, 4);
        } catch (SlickException ex) {
            System.out.println("Feil ved innlasting av spritesheeet.");
            Logger.getLogger(Plant.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void update(){
   
        
    }
    
    public void render(){
        plantImage.draw(0, 0);
    }
    
    
}
