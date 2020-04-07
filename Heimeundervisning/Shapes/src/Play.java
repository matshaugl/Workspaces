
import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {
    Rectangle ground;
    Circle player;
    boolean jump;
    int jumpTime;
    GeoWorld world;
    //SoundPlayer soundPlayer;
    SlickSoundPlayer soundPlayer;
    BulletList bulletList;

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        ground = new Rectangle(0, 600-20, 800, 600);
        player = new Circle(400, -100, 15);
        jumpTime = 0;
        world = new GeoWorld(25);
        soundPlayer = new SlickSoundPlayer();
        bulletList = new BulletList();
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor(Color.red);
        g.draw(ground);
        g.draw(player);
        world.renderWorld(g);
        bulletList.render(g);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        Input input = gc.getInput();
        jump = false;
        
        player.setY(player.getY()+10);
        if(player.intersects(ground) || world.intersects(player)){
            player.setY(player.getY()-10);
            jump = true;
        }
        
        if (input.isKeyDown(Input.KEY_A)) {
            world.moveWorld(+5);
            if(world.intersects(player)){
                world.moveWorld(-5);
            }
        }
        if (input.isKeyDown(Input.KEY_D)) {
            world.moveWorld(-5);
            if(world.intersects(player)){
                world.moveWorld(+5);
            }
        }
        
        if(input.isKeyPressed(Input.KEY_SPACE) && jump){
            jump = true;
            jumpTime = 15;
        }
        if(jumpTime>0){
            player.setY(player.getY()-20);
            if(world.intersects(player)){
                player.setY(player.getY()+20);
            }
            jumpTime--;
        }
        
        if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
            float mx = input.getMouseX();
            float my = input.getMouseY();
            bulletList.addBullet(new Bullet((int)player.getCenterX(), (int)player.getCenterY(), (int)mx, (int)my));
            soundPlayer.playSound();
        }
        bulletList.update();
        
    }

    public int getID() {
        return 0;
    }
    
        public Play() {
        
    }
}