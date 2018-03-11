
import Camera.Camera;
import Animator.*;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState{
    Circle s;
    Player skeleton;
    Player mob;
    Tree tree;
    int p;

    ChunkHandler chunkHandler;
    Camera camera;
    Image worldMap;
    boolean quit = false;
    boolean moving;
    int[] duration = {200, 200}; //duration or length of the frame
 
    public Play(int state) {
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        camera = new Camera(816,493);
        tree = new Tree(1,0);
        s = new Circle(gc.getWidth()/2,gc.getScreenHeight()/2,15);
        skeleton = new Player();
        mob = new Player();
        worldMap = new Image("res/world.png");
        //mapGen = new MapGen(100);
        //map = mapGen.getMapImage();
        chunkHandler = new ChunkHandler();
        //shiftY = gc.getHeight()/2;
        //shiftX = gc.getWidth()/2;
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        
        chunkHandler.render(camera);

        skeleton.render(camera);

        g.drawString("Plaer X: " + (camera.getX()) + "\nPlayer Y: " + camera.getY(), 400, 20); //indicator to see where bucky is in his world
        g.drawString("Player X: " + ((camera.getX())-(gc.getWidth()/2)) + "\nPlayer Y: " + (camera.getY()-(gc.getHeight())/2), 400, 80); //indicator to see where bucky is in his world
        g.setColor(Color.red);
        g.draw(new Rectangle(0+(camera.getX()),0+camera.getY(),32,32));
        g.draw(new Rectangle(0+(camera.getX()),0+camera.getY(),16,16));
        g.draw(s);
        
        tree.render((camera.getX()), camera.getY());
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        moving = false;
        Input input = gc.getInput();
        
        camera.update(input, delta);

        if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
            s.setLocation(input.getMouseX(), input.getMouseY());
        }
    }

    public int getID() {
        return 1;
    }
}