
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mats
 */
public class ClientConnection implements Runnable {

    Socket socket;
    ObjectInputStream is;
    ObjectOutputStream os;
    ArrayList<String> messageList;

    ClientConnection(Socket socket) {
        try {
            this.socket = socket;
            is = new ObjectInputStream(socket.getInputStream());
            os = new ObjectOutputStream(socket.getOutputStream());

        } catch (Exception ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    ClientConnection(Socket socket, ArrayList<String> messageList) {
        this.messageList = messageList;
        try {
            this.socket = socket;
            is = new ObjectInputStream(socket.getInputStream());
            os = new ObjectOutputStream(socket.getOutputStream());

        } catch (Exception ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connect() {

    }

    @Override
    public void run() {
        try {
            String message = "";
            while (true) {
                if (!message.equals("exit")) {
                    message = (String) is.readObject();
                    messageList.add(message);
                    System.out.println("Message List: ");
                    for(int i = 0; i<messageList.size(); i ++){
                        System.out.println(messageList.get(i));
                    }

                    os.writeObject("Return");
                } else {
                    break;
                }

            }
            socket.close();

        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
