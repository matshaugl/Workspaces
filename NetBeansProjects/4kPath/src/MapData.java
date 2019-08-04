
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mathau25
 */
public class MapData {
    
    int xSize;
    int ySize;
    
    byte[][] mapData;
    byte[][] oldMapData;
    Random r;
    
    public MapData(int xSize, int ySize){
        this.xSize = xSize;
        this.ySize = ySize;
        mapData = new byte[xSize][ySize];
        
        
        
        r = new Random();
        
        for(int x = 0; x<xSize; x++){
            for(int y = 0; y<ySize; y++){
                if(r.nextDouble()<0.0001){
                    mapData[x][y] = 1;
                } else {
                    mapData[x][y] = 0;
                }
            }
        }
        
        for(int i=0; i<15; i++){
            grow();
        }
    }
    
    public byte getCell(int x, int y){
        return mapData[x][y];
    }
    
    public void grow(){
        oldMapData = mapData;
        for(int x = 1; x<xSize-1; x++){
            for(int y = 1; y<ySize-1; y++){
                if(oldMapData[x][y]==1 && r.nextDouble()>0.50){
                    mapData[x+1][y] = 1;
                    mapData[x-1][y] = 1;
                    mapData[x][y+1] = 1;
                    mapData[x][y-1] = 1;
                }
            }
        }
    }
}
