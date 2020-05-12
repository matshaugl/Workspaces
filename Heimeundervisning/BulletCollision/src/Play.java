
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.*;

import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {

    ServerSocket ss;
    Socket socket;
    InputStream inputStream;
    ObjectInputStream objectInputStream;
    Message message;

    BulletList bulletList;

    Map map;
    Player player;

    public Play(int state) {

    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

        bulletList = new BulletList();

        map = new Map();
        player = new Player();

        try {
            ss = new ServerSocket(7777);
            socket = ss.accept(); // blocking call, this will wait until a connection is attempted on this port.
            inputStream = socket.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);

            message = (Message) objectInputStream.readObject();

            System.out.println(message.getText());

            ss.close();
            socket.close();

        } catch (IOException ex) {
            Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor(Color.yellow);

        player.render(g);

        map.render(g);

        bulletList.render(g);

    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        Input input = gc.getInput();

        player.update(delta, input, map, bulletList);

        bulletList.update(delta, map);

    }

    public int getID() {
        return 1;
    }

}
