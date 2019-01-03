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
public abstract class Animal {

    Animation south;
    Animation north;
    Animation west;
    Animation east;
    
    Animator animator;

    Direction direction;

    float x;
    float y;

    public Animal() {
        direction = Direction.SOUTH;
        animator = new Animator();
    }

    public void update() {

    }

    public void render() {
        if (direction == direction.SOUTH) {
            south.draw(x, y);
        }
        if (direction == direction.NORTH) {
            north.draw(x, y);
        }
        if (direction == direction.EAST) {
            east.draw(x, y);
        }
        if (direction == direction.WEST) {
            west.draw(x, y);
        }
    }
}
