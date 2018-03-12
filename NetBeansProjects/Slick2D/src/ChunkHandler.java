
import Camera.Camera;
import MapGen.FixedNoise;
import MapGen.MapChunk;
import java.util.ArrayList;
import java.util.HashMap;

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

    HashMap<String, MapChunk> chunks;
    MapChunk m;
    int chunkSize;
    int tileSize;
    FixedNoise fixedNoise;
    int currentX;
    int currentY;

    public ChunkHandler() {
        chunks = new HashMap<String, MapChunk>();
        fixedNoise = new FixedNoise();

        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                m = new MapChunk(x, y, fixedNoise);
                chunks.put(m.getKey(), m);
            }
        }

        chunkSize = 32;
        tileSize = 32;
        currentX = 0;
        currentY = 0;
    }

    public void render(float playerX, float playerY) {
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                chunks.get("" + x + y).render((x * chunkSize * tileSize) + playerX, (y * chunkSize * tileSize) + playerY);
            }
        }

    }

    public void update() {

    }

    void render(Camera camera) {
        try{
        chunks.get("" + (currentX-1) +","+ (currentY-1)).render(((currentX-1) * chunkSize * tileSize) + camera.getX(), ((currentY-1) * chunkSize * tileSize) + camera.getY());
        chunks.get("" + (currentX) +","+ (currentY-1)).render(((currentX) * chunkSize * tileSize) + camera.getX(), ((currentY-1) * chunkSize * tileSize) + camera.getY());
        chunks.get("" + (currentX+1) +","+ (currentY-1)).render(((currentX+1) * chunkSize * tileSize) + camera.getX(), ((currentY-1) * chunkSize * tileSize) + camera.getY());
        
        chunks.get("" + (currentX-1) +","+ (currentY)).render(((currentX-1) * chunkSize * tileSize) + camera.getX(), ((currentY) * chunkSize * tileSize) + camera.getY());
        chunks.get("" + (currentX) +","+ (currentY)).render(((currentX) * chunkSize * tileSize) + camera.getX(), ((currentY) * chunkSize * tileSize) + camera.getY());
        chunks.get("" + (currentX+1) +","+ (currentY)).render(((currentX+1) * chunkSize * tileSize) + camera.getX(), ((currentY) * chunkSize * tileSize) + camera.getY());
        
        chunks.get("" + (currentX-1) +","+ (currentY+1)).render(((currentX-1) * chunkSize * tileSize) + camera.getX(), ((currentY+1) * chunkSize * tileSize) + camera.getY());
        chunks.get("" + (currentX) +","+ (currentY+1)).render(((currentX) * chunkSize * tileSize) + camera.getX(), ((currentY+1) * chunkSize * tileSize) + camera.getY());
        chunks.get("" + (currentX+1) +","+ (currentY+1)).render(((currentX+1) * chunkSize * tileSize) + camera.getX(), ((currentY+1) * chunkSize * tileSize) + camera.getY());
        } catch (Exception e) {
            
        }
    }

    void update(int chunkX, int chunkY) {
        if(currentX!=chunkX || currentY != chunkY){
            addChunks(chunkX, chunkY);
            currentX = chunkX;
            currentY = chunkY;
        }
        currentX = chunkX;
        currentY = chunkY;
    }

    private void addChunks(int chunkX, int chunkY) {
        if(!chunks.containsKey(""+(chunkX-1) + "," + (chunkY-1))){
            MapChunk newChunk = new MapChunk(chunkX-1,chunkY-1, fixedNoise); 
            chunks.put(newChunk.getKey(), newChunk);
        }
        if(!chunks.containsKey(""+(chunkX) + "," + (chunkY-1))){
            MapChunk newChunk = new MapChunk(chunkX,chunkY-1, fixedNoise); 
            chunks.put(newChunk.getKey(), newChunk);
        }
        if(!chunks.containsKey(""+(chunkX+1) + "," + (chunkY-1))){
            MapChunk newChunk = new MapChunk(chunkX+1,chunkY-1, fixedNoise); 
            chunks.put(newChunk.getKey(), newChunk);
        }
        
        if(!chunks.containsKey(""+(chunkX-1) + "," + (chunkY))){
            MapChunk newChunk = new MapChunk(chunkX-1,chunkY, fixedNoise); 
            chunks.put(newChunk.getKey(), newChunk);
        }
        if(!chunks.containsKey(""+(chunkX) + "," + (chunkY))){
            MapChunk newChunk = new MapChunk(chunkX,chunkY, fixedNoise); 
            chunks.put(newChunk.getKey(), newChunk);
        }
        if(!chunks.containsKey(""+(chunkX+1) + "," + (chunkY))){
            MapChunk newChunk = new MapChunk(chunkX+1,chunkY, fixedNoise); 
            chunks.put(newChunk.getKey(), newChunk);
        }
        
        if(!chunks.containsKey(""+(chunkX-1) + "," + (chunkY+1))){
            MapChunk newChunk = new MapChunk(chunkX-1,chunkY+1, fixedNoise); 
            chunks.put(newChunk.getKey(), newChunk);
        }
        if(!chunks.containsKey(""+(chunkX) + "," + (chunkY+1))){
            MapChunk newChunk = new MapChunk(chunkX,chunkY+1, fixedNoise); 
            chunks.put(newChunk.getKey(), newChunk);
        }
        if(!chunks.containsKey(""+(chunkX+1) + "," + (chunkY+1))){
            MapChunk newChunk = new MapChunk(chunkX+1,chunkY+1, fixedNoise); 
            chunks.put(newChunk.getKey(), newChunk);
        }
    }

}
