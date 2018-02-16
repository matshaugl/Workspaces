/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapGen;

import org.newdawn.slick.Image;

/**
 *
 * @author matsh
 */
public class MapChunk {
    
    int size;
    TerrainType terrainTypeArray[];
    Image mapImage;
    
    public MapChunk(int x, int y){
        size = 32;
        terrainTypeArray = new TerrainType[size];
    }
    
    public void render(){
        
    }
    
    
    
}
