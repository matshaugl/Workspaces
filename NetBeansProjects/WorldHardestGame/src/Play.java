
import java.util.ArrayList;
import java.util.Random;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {
    
    Rectangle spillbrett;
    Circle player;
    Boolean newStep = true;
    int deltaTurn= 0;
    int turnSpeed = 500;
    
    float playerX = 100;
    float playerY = 100;
    
    ArrayList<Danger> dangerList = new ArrayList<Danger>();
    int dangerNumb = 20;
    boolean gameOver = false;
    Random r;

    public Play(int state) {
        
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        //spillbrett = new Rectangle (20*32, 5*32, 32*10, 32*20);
        r = new Random();
        player = new Circle (100,100,10);
        for(int i=0; i<dangerNumb; i++){
            int dx = (int) (r.nextDouble() * 1200);
            int dy = (int) (r.nextDouble() * 900);
            int radius = (int) (r.nextDouble() * 100);
            dangerList.add(new Danger(dx, dy, radius));
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
      //g.setColor(Color.yellow);
      //g.draw(spillbrett);
      g.setColor(Color.yellow);
      g.draw(player);
      for(int i=0; i<dangerNumb; i++){
          dangerList.get(i).render(g);
      }
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        Input input = gc.getInput();
        deltaTurn += delta;
        if(deltaTurn>turnSpeed){
            newStep = true;
            deltaTurn = 0;
            
        }
        for(int i=0; i<dangerNumb; i++){
          if(dangerList.get(i).update(delta, player, gameOver)){
              gameOver = true;
          }
      }
        //System.out.println(delta);
        
        //during the game if the user hits the up arrow...
        boolean moving = false;
        if (input.isKeyDown(Input.KEY_W)) {
            playerY -= delta * .5f;
            moving = true;
        }
        if (input.isKeyDown(Input.KEY_S)) {
            playerY += delta * .5f;
            moving = true;
        }
        if (input.isKeyDown(Input.KEY_A)) {
            playerX -= delta * .5f;
            moving = true;
        }
        if (input.isKeyDown(Input.KEY_D)) {
            playerX += delta * .5f;
            moving = true;
        }
        if(gameOver){
            playerX = 100;
            playerY = 100;
            gameOver = !gameOver;
        }
        player.setLocation(playerX, playerY);
        
    }

    public int getID() {
        return 1;
    }

}
