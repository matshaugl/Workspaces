
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mats
 */
public class Tree {
    
    Image tree;
    int x;
    int y;
    
    
    public Tree(int x, int y){
        try {
            tree = new Image("res/tree.png");
        } catch (SlickException ex) {
            System.out.println("Fant ikke bilde!");
        }
        this.x = x;
        this.y = y;
    }
    
    public void update(){
        
    }
    
    public void render(){
        tree.draw(x, y);
    }
    
}
