
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mats
 */
public class NoiseMixer {
    
    double v0 = 1, v1 = 1, v2 = 1, v3 = 1, v4 = 1, v5 = 1, v6 = 1, v7 = 1, v8 = 1, v9 = 1;
    int size = 900;
    Image img;
    double waterLevel;
    BufferedImage bi;
    double dirtMap[][];
    int[] color;
    double dirtMapArray[][][];
    
    public NoiseMixer() {
        initMap();
    }

    /**
     * Creates new form GenFrame
     */
    
    
    public void initMap() {
        waterLevel = 0.0;
        dirtMapArray = new double[size][size][10];
        color = new int[size * size];

        Random r = new Random();
        double random = r.nextDouble();
        double xin = 2.0;

        dirtMap = new double[size][size];
        for (int z = 0; z < 10; z++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    //dirtMap[i][j] = SimplexNoise.noise(i / xin + random, j / xin + random);
                    dirtMapArray[i][j][z] = SimplexNoise.noise(i / xin + random, j / xin + random);

                }
            }
            xin = xin * 2.0;
            
        }



        updateMap();
    }
    
    private void updateMap() {
        for (int y = 0; y < size; y++) {
            for (int j = 0; j < size; j++) {
                dirtMap[y][j] =
                        (dirtMapArray[y][j][0] * v0
                        + dirtMapArray[y][j][1] * v1
                        + dirtMapArray[y][j][2] * v2
                        + dirtMapArray[y][j][3] * v3
                        + dirtMapArray[y][j][4] * v4
                        + dirtMapArray[y][j][5] * v5
                        + dirtMapArray[y][j][6] * v6
                        + dirtMapArray[y][j][7] * v7
                        + dirtMapArray[y][j][8] * v8
                        + dirtMapArray[y][j][9] * v9) / (v0 + v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9);
            }
        }
    }
}