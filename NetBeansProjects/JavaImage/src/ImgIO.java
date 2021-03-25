
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ImgIO {
  BufferedImage image = null;
  File f = null;
  
  public ImgIO(){

    
    f = new File("D:\\Workspaces\\NetBeansProjects\\JavaImage\\src\\img.jpg");
      try {
          image = ImageIO.read(f);
      } catch (IOException ex) {
          Logger.getLogger(ImgIO.class.getName()).log(Level.SEVERE, null, ex);
      }
    
  }
  
  public void saveImage(){
      //write image
    try{

      javax.imageio.ImageIO.write(image, "jpg", f);
    }catch(IOException e){
      System.out.println("Error: "+e);
    }
  }
  
  public BufferedImage getImage(){
      return image;
  }
}
