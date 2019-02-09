package mapgen;

import Camera.Camera;
import mapgen.noise.TileNoise;
import mapgen.MapChunk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapgen.TreeChunk;
import mapgen.noise.TreeNoise;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author matsh
 */
public class ChunkHandler {

    HashMap<String, MapChunk> mapChunks;
    HashMap<String, TreeChunk> treeChunks;
    MapChunk m;
    TreeChunk t;
    int chunkSize;
    int tileSize;
    TileNoise mapNoise;
    TreeNoise treeNoise;
    int currentX;
    int currentY;
    Image miniMap;
    //Image bufferedImage;
    //Graphics bufferedG;

    public ChunkHandler() {
        /*
        try {
            bufferedImage = new Image(1024,1024);
            bufferedG = bufferedImage.getGraphics();
            System.out.println("Made buffered Image");
        } catch (SlickException ex) {
            Logger.getLogger(ChunkHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
        mapChunks = new HashMap<String, MapChunk>();
        treeChunks = new HashMap<String, TreeChunk>();
        mapNoise = new TileNoise();
        treeNoise = new TreeNoise();
        makeMiniMap();

        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                m = new MapChunk(x, y, mapNoise);
                //m.makeMapImage(bufferedG, bufferedImage);
                m.makeMapImage();
                t = new TreeChunk(x, y, treeNoise, mapNoise);
                mapChunks.put(m.getKey(), m);
                treeChunks.put(t.getKey(), t);
            }
        }
        //t = new TreeChunk(0, 0, treeNoise, mapNoise);
        //treeChunks.put(t.getKey(), t);

        chunkSize = 32;
        tileSize = 32;
        currentX = 0;
        currentY = 0;
    }

    public void makeMiniMap() {
        MapChunk[][] minimapChunks = new MapChunk[10][10];
        Graphics g = null;
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                m = new MapChunk(x - 5, y - 5, mapNoise);
                minimapChunks[x][y] = m;
            }
        }
        try {
            miniMap = new Image(320, 320);
            g = miniMap.getGraphics();
        } catch (SlickException ex) {
            Logger.getLogger(ChunkHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                for (int i = 0; i < 32; i++) {
                    for (int j = 0; j < 32; j++) {
                        g.setColor(minimapChunks[x][y].getMiniMapColor(i, j));
                        g.fillRect((x * 32) + i, (y * 32) + j, 1, 1);
                        //System.out.print("X: " + ((x*32)+i) + "Y: " + ((y*32)+j));
                    }
                    //System.out.println("");
                }
            }
        }
        g.flush();
    }

    public void update() {

    }

    public MapChunk getChunk(int x, int y) {
        return mapChunks.get("" + x + "," + y);
    }

    public void render(Camera camera) {
        try {
            for (int x = -1; x < 2; x++) {
                for (int y = -1; y < 2; y++) {
                    mapChunks.get("" + (currentX + x) + "," + (currentY + y)).render(((currentX + x) * chunkSize * tileSize) + camera.getX(), ((currentY + y) * chunkSize * tileSize) + camera.getY());
                }
            }
            for (int x = -1; x < 2; x++) {
                for (int y = -1; y < 2; y++) {
                    treeChunks.get("" + (currentX + x) + "," + (currentY + y)).render(((currentX + x) * chunkSize * tileSize) + camera.getX(), ((currentY + y) * chunkSize * tileSize) + camera.getY());
                }
            }
            //treeChunks.get("" + (currentX - 1) + "," + (currentY - 1)).render(((currentX - 1) * chunkSize * tileSize) + camera.getX(), ((currentY - 1) * chunkSize * tileSize) + camera.getY());
            //treeChunks.get("" + (currentX - 1) + "," + (currentY)).render(((currentX - 1) * chunkSize * tileSize) + camera.getX(), ((currentY) * chunkSize * tileSize) + camera.getY());
            //treeChunks.get("" + (currentX - 1) + "," + (currentY + 1)).render(((currentX - 1) * chunkSize * tileSize) + camera.getX(), ((currentY + 1) * chunkSize * tileSize) + camera.getY());

        } catch (Exception e) {
            System.out.println("ChunkHandler render error");
        }
    }

    public void update(int chunkX, int chunkY) {
        if (currentX != chunkX || currentY != chunkY) {
            addChunks(chunkX, chunkY);
            currentX = chunkX;
            currentY = chunkY;
        }
        currentX = chunkX;
        currentY = chunkY;
    }

    private void addChunks(int chunkX, int chunkY) {
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                if (!mapChunks.containsKey("" + (chunkX + x) + "," + (chunkY + y))) {
                    MapChunk newChunk = new MapChunk(chunkX + x, chunkY + y, mapNoise);
                    //newChunk.makeMapImage(bufferedG, bufferedImage);
                    newChunk.makeMapImage();
                    mapChunks.put(newChunk.getKey(), newChunk);
                }
                if (!treeChunks.containsKey("" + (chunkX + x) + "," + (chunkY + y))) {
                    TreeChunk newChunk = new TreeChunk(chunkX + x, chunkY + y, treeNoise, mapNoise);
                    treeChunks.put(newChunk.getKey(), newChunk);
                }
            }
        }
    }

    Image getMiniMap() {
        return miniMap;
    }

    void click(int mousePX, int mousePY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
