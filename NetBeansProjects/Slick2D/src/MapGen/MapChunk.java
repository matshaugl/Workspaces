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
    

    Image mapImage;
    
    FixedNoise fixedNoise;
    int size;
    TerrainType[][] terrainTypeArray;
    int chunkX;
    int chunkY;
    
    public MapChunk(int x, int y){
        fixedNoise = new FixedNoise();
        size = 32;
        terrainTypeArray = new TerrainType[32][32];
        chunkX = x;
        chunkY = y;
        init();
    }
    
    public void init(){
        double [][] noiseMap = new double[size+2][size+2];
        int x = size * chunkX;
        int y;
        for(int i=0; i<size+2; i++){
            y = size * chunkY;
            for(int j=0; j<size+2; j++){
                noiseMap[i][j] = fixedNoise.getNoise(x + i, y + j);
            }
        }
        
    }
    
    public void render(){
        
    }
    
    public void update(){
        
    }
    
    
    
}
