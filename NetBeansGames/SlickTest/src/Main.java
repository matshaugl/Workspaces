import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Main extends StateBasedGame{
   
   public static final String gamename = "Game";
   public static final int play = 0;
   
   public Main(String gamename){
      super(gamename);
      this.addState(new Play(play));
   }
   
   public void initStatesList(GameContainer gc) throws SlickException{
      this.enterState(play);
   }
   
   public static void main(String[] args) {
      AppGameContainer appgc;
      try{
         appgc = new AppGameContainer(new Main(gamename));
         appgc.setDisplayMode(1600, 900, false);
         appgc.start();
      }catch(SlickException e){
         e.printStackTrace();
      }
   }

}