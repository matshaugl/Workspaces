
import Camera.Camera;
import mapgen.noise.TileNoise;
import mapgen.MapChunk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapgen.TreeChunk;
import mapgen.noise.TreeNoise;
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
    int chunkRenderRadius = 2;

    Image procedurallImage;
    Graphics procedurallG;

    public ChunkHandler() {
        try {
            procedurallImage = new Image(chunkSize * tileSize, chunkSize * tileSize);
            procedurallG = procedurallImage.getGraphics();
        } catch (SlickException ex) {
            Logger.getLogger(ChunkHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        mapChunks = new HashMap<String, MapChunk>();
        treeChunks = new HashMap<String, TreeChunk>();
        mapNoise = new TileNoise();
        treeNoise = new TreeNoise();

        for (int x = 0 - chunkRenderRadius; x < 1 + chunkRenderRadius; x++) {
            for (int y = 0 - chunkRenderRadius; y < 1 + chunkRenderRadius; y++) {
                //m = new MapChunk(x, y, mapNoise);
                m = new MapChunk(x, y, mapNoise, procedurallImage, procedurallG);
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

    public void update() {

    }

    void render(Camera camera) {
        try {
            for (int x = 0 - chunkRenderRadius; x < 1 + chunkRenderRadius; x++) {
                for (int y = 0 - chunkRenderRadius; y < 1 + chunkRenderRadius; y++) {
                    mapChunks.get("" + (currentX + x) + "," + (currentY + y)).render(((currentX + x) * chunkSize * tileSize) + camera.getX(), ((currentY + y) * chunkSize * tileSize) + camera.getY());
                }
            }
            for (int x = 0 - chunkRenderRadius; x < 1 + chunkRenderRadius; x++) {
                for (int y = 0 - chunkRenderRadius; y < 1 + chunkRenderRadius; y++) {
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

    void update(int chunkX, int chunkY) {
        if (currentX != chunkX || currentY != chunkY) {
            addChunks(chunkX, chunkY);
            currentX = chunkX;
            currentY = chunkY;
        }
        currentX = chunkX;
        currentY = chunkY;
    }

    private void addChunks(int chunkX, int chunkY) {
        for (int x = 0 - chunkRenderRadius; x < 1 + chunkRenderRadius; x++) {
            for (int y = 0 - chunkRenderRadius; y < 1 + chunkRenderRadius; y++) {
                if (!mapChunks.containsKey("" + (chunkX + x) + "," + (chunkY + y))) {
                    MapChunk newChunk = new MapChunk(chunkX + x, chunkY + y, mapNoise, procedurallImage, procedurallG);
                    mapChunks.put(newChunk.getKey(), newChunk);
                }
                if (!treeChunks.containsKey("" + (chunkX + x) + "," + (chunkY + y))) {
                    TreeChunk newChunk = new TreeChunk(chunkX + x, chunkY + y, treeNoise, mapNoise);
                    treeChunks.put(newChunk.getKey(), newChunk);
                }
            }
        }
    }

}
