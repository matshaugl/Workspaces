
import gameobject.Tree;
import Camera.Camera;
import Animator.*;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {

    Circle s;
    Player skeleton;
    Player mob;

    int p;
    int chunkX;
    int chunkY;

    ChunkHandler chunkHandler;
    Camera camera;
    Image worldMap;
    boolean quit = false;
    boolean moving;
    int[] duration = {200, 200}; //duration or length of the frame

    public Play(int state) {
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        camera = new Camera(150, -120);

        s = new Circle(11, 11, 2);
        s.setCenterX(gc.getWidth() / 2);
        s.setCenterY(gc.getHeight() / 2);
        skeleton = new Player();
        mob = new Player();
        worldMap = new Image("res/world.png");
        chunkHandler = new ChunkHandler();
        chunkX = 0;
        chunkY = 0;
        /*
        Graphics g = gc.getGraphics();
        g.setWorldClip((int) 0, (int) 0, (int) 500, (int) 500);
         */

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

        chunkHandler.render(camera);

        skeleton.render(camera);
        g.drawString("Plaer X: " + (camera.getX()) + "\nPlayer Y: " + camera.getY(), 400, 20); //indicator to see where bucky is in his world
        //g.drawString("Player X: " + ((camera.getX())-(gc.getWidth()/2)) + "\nPlayer Y: " + (camera.getY()-(gc.getHeight())/2), 400, 80); //indicator to see where bucky is in his world
        //g.drawString("CameraX: " + (-camera.getX()) + "   CameraY: " + (-camera.getY()), 400, 80);
        //g.drawString("CameraX: " + (-camera.getX()+gc.getWidth()/2) + "   CameraY: " + (-camera.getY()+gc.getHeight()/2), 400, 80);
        g.drawString("chunkX: " + chunkX + "   chunkY: " + chunkY, 400, 80);
        g.setColor(Color.red);
        g.draw(new Rectangle(0 + (camera.getX()), 0 + camera.getY(), 32, 32));
        g.draw(new Rectangle(0 + (camera.getX()), 0 + camera.getY(), 16, 16));
        g.draw(s);

    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        moving = false;
        Input input = gc.getInput();

        boolean moving = camera.update(input, delta);
        if (moving) {
            chunkX = (int) Math.floor((-camera.getX() + (gc.getWidth() / 2)) / 1024);
            chunkY = (int) Math.floor((-camera.getY() + (gc.getHeight() / 2)) / 1024);
            chunkHandler.update(chunkX, chunkY);
        }

        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            s.setLocation(input.getMouseX(), input.getMouseY());
        }
    }

    public int getID() {
        return 1;
    }

}
