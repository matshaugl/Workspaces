/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package mapgen;

import gameobject.Tree;
import java.util.ArrayList;
import mapgen.noise.TileNoise;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapgen.noise.TreeNoise;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author matsh
 */
public class GrassChunk {

    ArrayList<Tree> treeList;

    TreeNoise treeNoise;
    TileNoise tileNoise;
    int size;
    int chunkX;
    int chunkY;

    int tileSize = 32;
    double treeLevel = 0.08;

    public GrassChunk(int x, int y, TreeNoise tf, TileNoise mf) {
        treeList = new ArrayList<Tree>();
        treeNoise = tf;
        tileNoise = mf;
        size = 32;
        chunkX = x;
        chunkY = y;
        System.out.println(chunkX + ", " + chunkY);
        try {
            init();
        } catch (SlickException ex) {
            Logger.getLogger(MapChunk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void init() throws SlickException {
        createTrees();

    }

    public void render(float shiftX, float shiftY) {
        for (int i = 0; i < treeList.size(); i++) {
            treeList.get(i).render(shiftX, shiftY);
        }

    }

    public void update() {

    }

    public int getX() {
        return chunkX;
    }

    public int getY() {
        return chunkY;
    }

    public String getKey() {
        return "" + chunkX + "," + chunkY;
    }

    private void createTrees() {
        //treeList.add(new Tree(0, 0));
        //if (chunkX == 1 && chunkY == 1) {
        System.out.println("Tree gen");

        int x = (size * chunkX);
        int y;
        double[][] noiseMap = new double[size][size];
        for (int i = 0; i < size; i++) {
            y = (size * chunkY);
            for (int j = 0; j < size; j++) {
                noiseMap[i][j] = tileNoise.getNoise(x + i, y + j);
            }
        }

        for (int i = 0; i < size; i = i + 2) {
            for (int j = 0; j < size; j = j + 2) {
                int noiseValue = (int) (noiseMap[i][j] * 1000);
                if (noiseMap[i][j] > treeLevel && noiseValue % 5 == 0) {
                    treeList.add(new Tree(i, j));
                }
            }
        }
        //}
    }

}
