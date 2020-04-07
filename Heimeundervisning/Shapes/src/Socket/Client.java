
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.*;

public class Client {

    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String message = "";
    private String serverIP;
    private Socket connection;
    Scanner tastatur;

    public static void main(String[] args) {
        new Client().run();
    }

    public void run() {
        connectToServer();
        setupStreams();
        sendMessages();

    }

    private void connectToServer() {
        try {
            connection = new Socket(InetAddress.getByName(serverIP), 6789);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setupStreams() {
        try {
            output = new ObjectOutputStream(connection.getOutputStream());
            output.flush();
            input = new ObjectInputStream(connection.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void sendMessages() {
        boolean running = true;
        tastatur = new Scanner(System.in);
        while (running) {
            message = tastatur.nextLine();
            if (message.equals("exit")) {
                running = false;
            }
            try {
                output.writeObject(message);
                output.flush();
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        closeStreams();
    }

    private void closeStreams() {
        try {
            output.close();
            input.close();
            connection.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
