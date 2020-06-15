
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        int port = 4444;
        ArrayList<String> messageList = new ArrayList<String>();
        ServerSocket ss = new ServerSocket(port);
        ArrayList<ClientConnection> clientList = new ArrayList<ClientConnection>();
        
        while (true){
            Socket socket = ss.accept();
            ClientConnection cc = new ClientConnection(socket, messageList);
            clientList.add(cc);
            new Thread(cc, "Thread :" + clientList.size()).start();
            
        }

    }
}
