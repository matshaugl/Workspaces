/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animator;

import org.newdawn.slick.Animation;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author matsh
 */
public class Skeleton {
    
    Animation movingUp, movingDown, movingLeft, movingRight;
    Animator animator = new Animator();
    int dir; 
    
    public Skeleton(){
        movingUp = animator.getAnimation(0);
        movingLeft = animator.getAnimation(1);
        movingDown = animator.getAnimation(2);
        movingRight = animator.getAnimation(3);
        dir = 2;
    }
    
    public void render(float x, float y){

        switch(dir){
            case 0: movingUp.draw(x,y);
            break;
            case 1: movingLeft.draw(x,y);
            break;
            case 2: movingDown.draw(x,y);
            break;
            case 3: movingRight.draw(x,y);
            break;
        }
    }
    
    public void setDirection(int dir){
        this.dir = dir;       
    }
    
}
