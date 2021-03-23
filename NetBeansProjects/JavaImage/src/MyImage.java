
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;


public class MyImage{
  public static void main(String args[])throws IOException{
    SimplexNoise noise = new SimplexNoise();
    
    ImgIO imageIO = new ImgIO();
   
    BufferedImage image = imageIO.getImage();

    for(int x=0; x<12000; x++){

        for(int y=0; y<12000; y++){
            double d = SimplexNoise.noise(x * 0.0001, y * 0.0001);
            d = ((d + 1) * 128) - 1;
            int c = (int) d;
            //System.out.println(c);
            Color color = new Color(c,c,c);
            image.setRGB(x, y, color.getRGB());
        }
    }
    
    imageIO.saveImage();
    
  }

}
