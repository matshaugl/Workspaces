import java.util.Random;


public class FixedNoise {
    
    double influence[];
    double noiseArray[];
    double randomArray[];
    

    
    public FixedNoise() {
        Random r = new Random();
        noiseArray = new double[10];
        influence = new double[10];
        randomArray = new double[10];
        
        for (int i=0; i<10; i++){
            randomArray[i] = r.nextDouble();
        }
        
        influence [0] = 0; //4
        influence [1] = 5; //8
        influence [2] = 7; //16
        influence [3] = 10; //32
        influence [4] = 20; //64
        influence [5] = 50; //128
        influence [6] = 75; //256
        influence [7] = 100; //512
        influence [8] = 0; //1024
        influence [9] = 0; //2048
        
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
            noiseArray[i] = SimplexNoise.noise(x / xin + randomArray[i], y / xin + randomArray[i]);
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
