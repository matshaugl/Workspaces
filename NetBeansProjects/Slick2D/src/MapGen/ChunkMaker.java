/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapGen;

/**
 *
 * @author matsh
 */
public class ChunkMaker {
    FixedNoise noise;
    int size;
    TerrainType[][] terrainTypeArray;
    
    public ChunkMaker(){
        noise = new FixedNoise();
        size = 32;
        terrainTypeArray = new TerrainType[32][32];
    }
    
    public void generateChunk(){
        
    }
}
