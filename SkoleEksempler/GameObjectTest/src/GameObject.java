/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matsh
 */
public  abstract class GameObject implements Comparable{

    int x;
    int y;
    
    int getX(){
        return x;
    }
    
    int getY(){
        return y;
    }
    
    
    @Override
    public int compareTo(Object t) {
        GameObject go = (GameObject) t;
        if(this.getY() >  go.getY()){
            return 1;
        }
        if(this.getY() <  go.getY()){
            return -1;
        }
        
        return 0;
    }    
}
