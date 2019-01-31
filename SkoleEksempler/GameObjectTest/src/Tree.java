/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matsh
 */
public class Tree extends GameObject{
    
    public Tree(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public String toString(){
        return "Tree: x: " + x + " y: " + y;
    }
    
}
