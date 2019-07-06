
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
 * @author mathau25
 */
public class Tree {
    
    int hitpoints;
    Image aliveImage;
    
    int yPos;
    int xPos;
    int xShift = -32;
    int yShift = -96;
    
    public Tree(int xPos, int yPos){
        hitpoints = 3000;
        this.xPos = xPos;
        this.yPos = yPos;
        try {
            aliveImage = new Image("res/tree.png");
        } catch (SlickException ex) {
            Logger.getLogger(Tree.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void chop(int damage){
        hitpoints =- damage;
    }
    
    public void update(){
        
    }
    
    public void render(Graphics g){
        boolean alive = true;
        if(alive){
            aliveImage.draw((xPos * 32) + xShift, (yPos * 32) + yShift);
        }
    }
    
}
