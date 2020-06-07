
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        int port = 4444;
        ServerSocket ss = new ServerSocket(port);
        ArrayList<ClientConnection> clientList = new ArrayList<ClientConnection>();
        
        while (true){
            Socket socket = ss.accept();
            clientList.add(new ClientConnection(socket));
        }

    }
}
