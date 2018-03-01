
import Animator.*;
import MapGen.MapGen;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState{
    Circle s;
    Skeleton skeleton;
    int p;
    Image map;
    MapGen mapGen;
    Image worldMap;
    boolean quit = false;
    boolean moving;
    int[] duration = {200, 200}; //duration or length of the frame
    float playerPosX = 0; //bucky will start at coordinates 0,0
    float playerPosY = 0;
    float shiftX; //this will shift the screen so bucky appears in middle
    float shiftY; //half the length and half the width of the screen

    public Play(int state) {
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        s = new Circle(0,0,15);
        skeleton = new Skeleton();
        worldMap = new Image("res/world.png");
        mapGen = new MapGen(100);
        map = mapGen.getMapImage();
        shiftY = gc.getHeight()/2;
        shiftX = gc.getWidth()/2;
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        
        map.draw(playerPosX, playerPosY); //draw the map at 0,0 to start
        skeleton.render(shiftX, shiftY);
        /*
        if(moving){
            bucky.draw(shiftX, shiftY); //draw bucky at 320, 160 (center of the screen)
        }else{
            bucky.getImage(0).draw(shiftX, shiftY);
        }
*/
        g.drawString("Plaer X: " + playerPosX + "\nPlayer Y: " + playerPosY, 400, 20); //indicator to see where bucky is in his world
        g.drawString("Player X: " + (playerPosX-(gc.getWidth()/2)) + "\nPlayer Y: " + (playerPosY-(gc.getHeight())/2), 400, 80); //indicator to see where bucky is in his world
        g.setColor(Color.red);
        g.draw(s);
        
        //when they press escape
        if (quit == true) {
            g.drawString("Resume (R)", 250, 100);
            g.drawString("Main Menu (M)", 250, 150);
            g.drawString("Quit Game (Q)", 250, 200);
            if (quit == false) {
                g.clear();
            }
        }
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        moving = false;
        Input input = gc.getInput();

        //during the game if the user hits the up arrow...
        if (input.isKeyDown(Input.KEY_W)) {
            skeleton.setDirection(0);
            playerPosY += delta * .3f; //increase the Y coordinates of bucky (move him up)

            moving = true;
        }
        if (input.isKeyDown(Input.KEY_S)) {
            skeleton.setDirection(2);
            playerPosY -= delta * .3f;

            moving = true;
        }
        if (input.isKeyDown(Input.KEY_A)) {
            skeleton.setDirection(1);
            playerPosX += delta * .3f;

            moving = true;
        }
        if (input.isKeyDown(Input.KEY_D)) {
            skeleton.setDirection(3);
            playerPosX -= delta * .3f;

            moving = true;
        }

        //escape
        if (input.isKeyDown(Input.KEY_ESCAPE)) {
            quit = true;
        }

        //when they hit escape
        if (quit == true) {
            if (input.isKeyDown(Input.KEY_R)) {
                quit = false;
            }
            if (input.isKeyDown(Input.KEY_M)) {
                sbg.enterState(0);
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (input.isKeyDown(Input.KEY_Q)) {
                System.exit(0);
            }
        }
        if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
            s.setLocation(input.getMouseX(), input.getMouseY());
        }
    }

    public int getID() {
        return 1;
    }
}