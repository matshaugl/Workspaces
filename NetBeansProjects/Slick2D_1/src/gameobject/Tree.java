package gameobject;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author matsh
 */
public class Tree {

    Image m;
    int tX;
    int tY;
    int treeXoff;
    int treeYoff;

    public Tree(int x, int y) {
        tX = x;
        tY = y;
        //treeXoff = -30;
        //treeYoff = -84;
        treeXoff = -32;
        treeYoff = -96;

        try {
            m = new Image("res/tree.png");
        } catch (SlickException ex) {
            Logger.getLogger(Tree.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void render(float x, float y) {
        m.draw((tX * 32) + x + treeXoff, (tY * 32) + y + treeYoff);
        //m.draw(x,y);
    }

    public void update() {

    }

}
