import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame{
   
   public static final String gamename = "Game";
   public static final int menu = 0;
   public static final int play = 1;
   
   public Game(String gamename){
      super(gamename);
      this.addState(new Play(play));
   }
   
   public void initStatesList(GameContainer gc) throws SlickException{
      //this.getState(menu).init(gc, this);
      //this.getState(play).init(gc, this);
      this.enterState(play);
   }
   
   public static void main(String[] args) {
      AppGameContainer appgc;
      try{
         appgc = new AppGameContainer(new Game(gamename));
         appgc.setTargetFrameRate(120);
         //appgc.setDisplayMode(1360, 780, false);
         appgc.setDisplayMode(1600, 900, false);
         //appgc.setDisplayMode(1920, 1080, true);
         appgc.start();
      }catch(SlickException e){
         e.printStackTrace();
      }
   }

}