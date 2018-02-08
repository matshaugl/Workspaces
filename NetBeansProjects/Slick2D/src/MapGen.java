import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/

/**
 *
 * @author Mats
 */
public class MapGen {
    
    SpriteSheet sheet;
    double noiseMap[][];
    Image map;
    int tileSize = 32;
    int size;
    double waterLevel = 0.0;
    NoiseMixer noiseMixer;
    
    
    public MapGen(int size) {
        noiseMixer = new NoiseMixer(1);
        this.size = size;
        noiseMap = new double[size+2][size+2];
        for(int y=0; y<size; y++){
            for(int x=0; x<size; x++){
               noiseMap[x][y] = 0;
            }
        }
        try {
            sheet = new SpriteSheet("res/sandwaterbinary2.png", 32, 32);
            map = new Image(size*tileSize, size*tileSize);
        } catch (Exception ex) {
            System.out.println("MapInit fail");
        }
        
    }
    
    public Image getMapImage(){
        Graphics g = null;
        try {
            g = map.getGraphics();
        } catch (SlickException ex) {
            Logger.getLogger(MapGen.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("MapDraw fail");
        }
        //Make Noise map
        for(int y=0; y<size; y++){
            for(int x=0; x<size; x++){
                double noise = 0;
                /*
                int numbFreq = 3;
                double freq = 0.02;
                for(int z = 1; z<=numbFreq; z++){
                    noise = noise + (SimplexNoise.noise(x*freq, y*freq + 1) /2);
                    freq = freq *2;
                }
                noise = noise /numbFreq;
                //freq = 0.32;
                //noise = SimplexNoise.noise(x*freq, y*freq);
                */
                noise = noiseMixer.getNoise(x, y);
                noiseMap[x][y] = noise;
            }
        }
        //Draw map
        for(int y=1; y<size-1; y++){
            for(int x=1; x<size-1; x++){
                
                
                if(noiseMap[x][y]<waterLevel){
                    g.drawImage(sheet.getSprite(0, 16), x*tileSize, y*tileSize);
                } else {
                    int spriteNumber = 0;
                if(noiseMap[x][y-1]>waterLevel){
                    spriteNumber = spriteNumber + 1;
                }
                if(noiseMap[x][y+1]>waterLevel){
                    spriteNumber = spriteNumber + 2;
                }
                if(noiseMap[x-1][y]>waterLevel){
                    spriteNumber = spriteNumber + 4;
                }
                if(noiseMap[x+1][y]>waterLevel){
                    spriteNumber = spriteNumber + 8;
                }
                    g.drawImage(sheet.getSprite(0, spriteNumber), x*tileSize, y*tileSize);
                }
                
            }
        }
        
        g.flush();
        return map;
    }
    
    
}
