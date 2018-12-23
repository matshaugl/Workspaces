/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animator;

import org.newdawn.slick.Animation;

/**
 *
 * @author matsh
 */
public class Plant {
    
    Animation tomato;
    float x;
    float y;
    
    public Plant(Animation a){
        tomato = a;
        x = 50;
        y = 50;
    }
    
    public void update(){
        
    }
    
    public void render(){
        tomato.draw(x, y);
    }
    
    public void render(int x, int y){
        tomato.draw(x, y);
    }
    
    
    
    
}
