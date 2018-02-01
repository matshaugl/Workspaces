
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState{
    MapGen mapGen;
    Animator animator;
    Animation bucky, movingUp, movingDown, movingLeft, movingRight; //4 animations, bucky will be set to one
    Image worldMap;
    boolean quit = false;
    boolean moving;
    int[] duration = {200, 200}; //duration or length of the frame
    float buckyPositionX = 0; //bucky will start at coordinates 0,0
    float buckyPositionY = 0;
    float shiftX = buckyPositionX + 320; //this will shift the screen so bucky appears in middle
    float shiftY = buckyPositionY + 160; //half the length and half the width of the screen

    public Play(int state) {
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        animator = new Animator();
        worldMap = new Image("res/world.png");
        movingUp = animator.getAnimation(2, 10);
        movingDown = animator.getAnimation(0, 10);
        movingLeft = animator.getAnimation(3, 10);
        movingRight = animator.getAnimation(1, 10);
        bucky = movingDown; //by default as soon as game loads, bucky will be facing down
        mapGen = new MapGen(40);
        
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        mapGen.getMapImage().draw(buckyPositionX, buckyPositionY); //draw the map at 0,0 to start
        if(moving){
            bucky.draw(shiftX, shiftY); //draw bucky at 320, 160 (center of the screen)
        }else{
            bucky.getImage(1).draw(shiftX, shiftY);
        }
        g.drawString("Buckys X: " + buckyPositionX + "\nBuckys Y: " + buckyPositionY, 400, 20); //indicator to see where bucky is in his world

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
            bucky = movingUp; //change bucky to up image
            buckyPositionY += delta * .1f; //increase the Y coordinates of bucky (move him up)

            moving = true;
        }
        if (input.isKeyDown(Input.KEY_S)) {
            bucky = movingDown;
            buckyPositionY -= delta * .1f;

            moving = true;
        }
        if (input.isKeyDown(Input.KEY_A)) {
            bucky = movingLeft;
            buckyPositionX += delta * .1f;

            moving = true;
        }
        if (input.isKeyDown(Input.KEY_D)) {
            bucky = movingRight;
            buckyPositionX -= delta * .1f;

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
    }

    public int getID() {
        return 1;
    }
}