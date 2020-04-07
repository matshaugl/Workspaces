
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MultiServer {

    ServerSocket serverSocket;

    public static void main(String[] args) {
        new MultiServer().startServer();
    }

    public void startServer() {
        try {
            serverSocket = new ServerSocket(6789);
            while (true) {
                Socket socket = serverSocket.accept();
                new ServerThread(socket).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(MultiServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
