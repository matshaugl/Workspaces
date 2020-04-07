
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerThread extends Thread {

    private Socket connection;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    ServerThread(Socket socket) {
        this.connection = socket;
    }

    public void run() {
        setupStreams();
        waitForMessage();
    }

    private void setupStreams() {
        try {
            output = new ObjectOutputStream(connection.getOutputStream());
            output.flush();
            input = new ObjectInputStream(connection.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void closeStreams() {
        try {
            output.close();
            input.close();
            connection.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void waitForMessage() {
        String message;
        boolean running = true;
        while (running) {
            try {
                message = (String) input.readObject();
                System.out.println(message);
                if (message.equals("exit")) {
                    running = false;
                }
            } catch (IOException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        closeStreams();
    }
    
    //Lar server sende melding til client. Ikke i bruk
    private void sendMessage(String message) {
        try {
            output.writeObject(message);
            output.flush();
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
