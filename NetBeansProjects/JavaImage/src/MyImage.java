
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.Random;


public class MyImage{
  public static void main(String args[])throws IOException{
    SimplexNoise noise = new SimplexNoise();
    
    ImgIO imageIO = new ImgIO();
   
    BufferedImage image = imageIO.getImage();

    Random r = new Random();
    double offSet = r.nextDouble();

    for(int x=0; x<12000; x++){

        for(int y=0; y<12000; y++){
            double d = SimplexNoise.noise((x * 0.0001) + offSet, (y * 0.0001) + offSet);
            d = ((d + 1) * 128) - 1;
            int c = (int) d;
            
            Color color;
            if(c < 128){
                color = new Color(21,108,153);
            } else {
                color = new Color(47,129,54);
            }
                
            image.setRGB(x, y, color.getRGB());
        }
    }
    
    imageIO.saveImage();
    
  }

}
