/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapgen;

import Camera.Camera;

/**
 *
 * @author matsh
 */
public class Map {

    ChunkHandler chunkHandler;

    public Map() {

    }

    public Map(ChunkHandler chunkHandler) {
        this.chunkHandler = chunkHandler;
        
    }

    public void render(Camera camera) {
        chunkHandler.render(camera);
    }

    public void update(int chunkX, int chunkY) {
        chunkHandler.update(chunkX, chunkY);
    }

}
