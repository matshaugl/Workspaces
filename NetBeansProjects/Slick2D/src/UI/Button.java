/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;


import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


/**
 *
 * @author Mats
 */
public class Button {
    
    Image button;
    
    int x;
    int y;
    
    public Button(){
        
        x = 100;
        y = 100;

        try {
            button = new Image("res/designetSelected.png");
        } catch (SlickException ex) {
            Logger.getLogger(Button.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void render(Graphics g){
        button.draw(x, y);
    }
    
    public void update(){
        
    }
    
}
