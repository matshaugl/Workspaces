/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapgen;

import Camera.Camera;
import org.newdawn.slick.Image;

/**
 *
 * @author matsh
 */
public class Map {

    ChunkHandler chunkHandler;

    public Map() {

    }

    public Image makeMiniMap() {
        //System.out.println(System.currentTimeMillis() - t);
        return chunkHandler.getMiniMap();
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

    public void click(int mousePX, int mousePY) {
        chunkHandler.click(mousePX, mousePY);
    }

}
