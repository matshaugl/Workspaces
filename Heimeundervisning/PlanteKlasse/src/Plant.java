
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
    int x;
    int y;
    int type;
    int age;
    
    public Plant(int x, int y, int type){
        this.x = x;
        this.y = y;
        this.type = type;
        age = 0;
        try {
            plantSheet = new SpriteSheet("res/plants.png",32,64);
            plantImage = plantSheet.getSprite(type, age);
        } catch (SlickException ex) {
            System.out.println("Feil ved innlasting av spritesheeet.");
            Logger.getLogger(Plant.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void update(){
        if(age<3){
            age++;
            plantImage = plantSheet.getSprite(type, age);
        } 
    }
    
    public void render(){
        plantImage.draw(x, y);
    }
    
    
}
