/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animator;


import Camera.Camera;
import org.newdawn.slick.Animation;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author matsh
 */
public class Player {
    
    Animation movingUp, movingDown, movingLeft, movingRight;
    Animator animator = new Animator();
    int dir; 
    
    float xPos; 
    float yPos;
    int spriteShiftX;
    int spriteShiftY;
    
    public Player(){
        movingUp = animator.getAnimation(0);
        movingLeft = animator.getAnimation(1);
        movingDown = animator.getAnimation(2);
        movingRight = animator.getAnimation(3);
        dir = 2;
        xPos = 500;
        yPos = 0;
        spriteShiftX = -16;
        spriteShiftY = -42;
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

    public void render(Camera camera) {
        float x = xPos + camera.getX() + spriteShiftX;
        float y = yPos + camera.getY() + spriteShiftY;
        
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
    
    public void move(int delta){
        yPos = yPos + (0.05f * delta);
    }
    
}
