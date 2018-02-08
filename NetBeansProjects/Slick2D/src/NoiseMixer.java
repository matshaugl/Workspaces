
import java.util.Random;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mats
 */
public class NoiseMixer {
    
    //0.5x + 1.58^x + 5 
    double a = 0.5;
    double b = 1.562;
    double c = 5;
    
    double[] freqArray;
    double[] randomArray;
    Random r;
    int numbFreq;
    
    public NoiseMixer(int numbFreq) {
        this.numbFreq = numbFreq;
        //initMap();
        r = new Random();
        freqArray = new double [numbFreq];
        randomArray = new double [numbFreq];
        for(int i=0; i<numbFreq; i++){
            freqArray[i] = a*i + Math.pow(b,i) + c;
            randomArray[i] = r.nextDouble() * 10000;
        }
    }
    
    public double getNoise(double x, double y){
        double noise;
        for(int i=1; i<=numbFreq; i++){
            double freq = a*i + Math.pow(b, i) + c;
            noise = SimplexNoise.noise(i / freqArray[i-1] + randomArray[i-1], y / freqArray[i-1] + randomArray[i-1]);
        }
        
        return 0;
    }
}
