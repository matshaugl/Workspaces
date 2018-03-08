
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

    public ChunkHandler() {
        chunks = new HashMap<String, MapChunk>();
        fixedNoise = new FixedNoise();

        for (int x = -1; x < 10; x++) {
            for (int y = -1; y < 10; y++) {
                m = new MapChunk(x, y, fixedNoise);
                chunks.put(m.getKey(), m);
            }
        }

        chunkSize = 32;
        tileSize = 32;
    }

    public void render(float playerX, float playerY) {
        for (int x = -1; x < 10; x++) {
            for (int y = -1; y < 10; y++) {
                chunks.get("" + x + y).render((x * chunkSize * tileSize) + playerX, (y * chunkSize * tileSize) + playerY);
            }
        }

    }

    public void update() {

    }

}
