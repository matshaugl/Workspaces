package mapgen.noise;

import java.util.Random;


public class TileNoise {
    
    double influence[];
    double[] xinArray;
    double noiseArray[];
    double randomArray[];
    OpenSimplexNoise openNoise;
    

    
    public TileNoise() {
        openNoise = new OpenSimplexNoise();
        Random r = new Random();
        noiseArray = new double[10];
        influence = new double[10];
        randomArray = new double[10];
        xinArray = new double[10];
        
        for (int i=0; i<10; i++){
            randomArray[i] = r.nextDouble()*10000;
        }
        
        influence [0] = 8; //4
        influence [1] = 12; //8
        influence [2] = 15; //16
        influence [3] = 80; //16
        influence [4] = 100; //64
        influence [5] = 0; //128
        influence [6] = 0; //256 maks
        influence [7] = 0; //512
        influence [8] = 0; //1024
        influence [9] = 0; //2048
        xinArray[0] = 20; //5
        xinArray[1] = 30; //10
        xinArray[2] = 50; //15
        xinArray[3] = 100; //20
        xinArray[4] = 300;
        xinArray[5] = 60;
        xinArray[6] = 256;
        xinArray[7] = 512;
        xinArray[8] = 1024;
        xinArray[9] = 2048;
        
        
        
        /*
        influence [0] = 100;
        influence [1] = 100;
        influence [2] = 100;
        influence [3] = 100;
        influence [4] = 100;
        influence [5] = 100;
        influence [6] = 100;
        influence [7] = 100;
        influence [8] = 100;
        influence [9] = 100;
        */
    }
    
    public double getNoise(double x, double y){
        double noise = 0.0;
        
        double xin = 4.0;
        for(int i=0; i<10; i++){
            noiseArray[i] = openNoise.eval(x / xinArray[i] + randomArray[i], y / xinArray[i] + randomArray[i]);
            //noiseArray[i] = SimplexNoise.noise(x / xinArray[i] + randomArray[i], y / xinArray[i] + randomArray[i]);
            
            //noiseArray[i] = SimplexNoise.noise(x / xin + randomArray[i], y / xin + randomArray[i]);
            //noiseArray[i] = noise.eval(x / xinArray[i] + randomArray[i], y / xinArray[i] + randomArray[i]);
            
            //noiseArray[i] = OpenSimplexNoise.noise(x / xinArray[i] + randomArray[i], y / xinArray[i] + randomArray[i]);
            xin = xin * 2.0;
        }
        for(int i=0; i<10; i++){
            noise = noise + (noiseArray[i] * influence[i]);
        }
        noise = noise/1000;
        //noise = noise / (influence[0]+influence[1]+influence[2]+influence[3]+influence[4]+influence[5]+influence[6]+influence[7]+influence[8]+influence[9]);
        /*
        noise =
                        (noiseArray[0] * v0
                        + noiseArray[1] * v1
                        + noiseArray[2] * v2
                        + noiseArray[3] * v3
                        + noiseArray[4] * v4
                        + noiseArray[5] * v5
                        + noiseArray[6] * v6
                        + noiseArray[7] * v7
                        + noiseArray[8] * v8
                        + noiseArray[9] * v9) / (v0 + v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9);
        
        */   
        return noise;
    }
}
