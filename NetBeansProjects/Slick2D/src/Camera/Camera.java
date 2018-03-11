package Camera;


import org.newdawn.slick.Input;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matsh
 */
public class Camera {
    
    float cameraX;
    float cameraY;
    
    public Camera(float x, float y){
        cameraX = x;
        cameraY = y;
    }
    
    public float getX(){
        return cameraX;
    }
    
    public float getY(){
        return cameraY;
    }
    
    public void setX(float x){
        cameraX = x;
    }
    
    public void setY(float y){
        cameraY = y;
    }

    public void update(Input input, int delta) {
        //during the game if the user hits the up arrow...
        if (input.isKeyDown(Input.KEY_W)) {
            cameraY += delta * .5f;
        }
        if (input.isKeyDown(Input.KEY_S)) {
            cameraY -= delta * .5f;
        }
        if (input.isKeyDown(Input.KEY_A)) {
            cameraX += delta * .5f;
        }
        if (input.isKeyDown(Input.KEY_D)) {
            cameraX -= delta * .5f;
        }        
    }
}
