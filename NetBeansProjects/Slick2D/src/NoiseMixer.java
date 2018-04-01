
import mapgen.noise.SimplexNoise;
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
            //freqArray[i] = i*8;
            //System.out.println(freqArray[i]);
            randomArray[i] = r.nextDouble() * 10000;
        }
    }
    
    public double getNoise(double x, double y){
        double noise = 0.0;
        double xin = 128.0;
        double noises[] = new double[numbFreq];
        double totalFreq = 0;
        for(int i=1; i<=numbFreq; i++){
            double freq = a*i + Math.pow(b, i) + c;
            noises[i-1] = SimplexNoise.noise(x / xin + randomArray[i-1], y / xin + randomArray[i-1]);
            xin = xin * 1.5;
            
            //System.out.println(xin);
        }
        for(int i=0; i<numbFreq; i++){
            noise = noise + (noises[i]/ freqArray[i]);
            totalFreq = totalFreq + freqArray[i];
        }
        noise = noise / (totalFreq);
        System.out.println(noise);
        return noise;
    }
}
