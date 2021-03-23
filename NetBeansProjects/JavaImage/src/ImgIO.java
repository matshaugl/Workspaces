
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImgIO {
  BufferedImage image = null;
  File f = null;
  
  public ImgIO(){

    
    f = new File("D:\\Workspaces\\NetBeansProjects\\JavaImage\\src\\img.jpg");
    
  }
  
  public void saveImage(){
      //write image
    try{

      javax.imageio.ImageIO.write(image, "png", f);
    }catch(IOException e){
      System.out.println("Error: "+e);
    }
  }
  
  public BufferedImage getImage(){
      return image;
  }
}
