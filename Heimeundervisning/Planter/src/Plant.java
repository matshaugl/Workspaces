
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
    
    int type;
    int x;
    int y;
    int xShift = -14;
    int yShift = -59;
    SpriteSheet spriteSheet;
    Image plantImage;
    int age;
    
    public Plant(int x, int y, int type){
        
        this.type = type;
        age = 0;
        this.x = x;
        this.y = y;
        try {
            spriteSheet = new SpriteSheet("res/plants.png",32, 64);
            plantImage = spriteSheet.getSprite(type, age);
        } catch (SlickException ex) {
            Logger.getLogger(Plant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(){
        if(age<5){
            age = age + 1;
        }
        plantImage = spriteSheet.getSprite(type, age);
        
    }
    
    public void render(){
        plantImage.draw(x + xShift, y + yShift);
    }
    
    
}
