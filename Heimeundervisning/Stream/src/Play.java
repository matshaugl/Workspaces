import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {

    ArrayList<Tree> treeList = new ArrayList();
    Image player;
    int mouseX;
    int mouseY;
    float playerX;
    float playerY;
    float playerSpeed;

    public Play(int state) {
        
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        player = new Image("res/skelleton.png");
        mouseX = 0;
        mouseY = 0;
        playerX = 800;
        playerY = 400;
        playerSpeed = 0.3f;

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        
        for(int i=0; i<treeList.size(); i++){
            treeList.get(i).render();
        }
        player.draw(playerX, playerY);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        Input input = gc.getInput();
        if(input.isMouseButtonDown(0)){
            mouseX = input.getMouseX();
            mouseY = input.getMouseY();
            treeList.add(new Tree(mouseX, mouseY));
            //System.out.println("x:" + mouseX + ", y: " + mouseY);
            System.out.println(treeList.size());
        }
        
        if(input.isKeyDown(input.KEY_W)){
            playerY = playerY - (playerSpeed * delta);
        }
        
        if(input.isKeyDown(input.KEY_S)){
            playerY = playerY + (playerSpeed * delta);
        }
        
        if(input.isKeyDown(input.KEY_A)){
            playerX = playerX - (playerSpeed * delta);
        }
        
        if(input.isKeyDown(input.KEY_D)){
            playerX = playerX + (playerSpeed * delta);
        }
        
    }

    public int getID() {
        return 1;
    }

}
