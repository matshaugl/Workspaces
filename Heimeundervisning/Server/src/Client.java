
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

// Organize imports     

public class Client {
    public static void main(String[] args) throws UnknownHostException,
            IOException, ClassNotFoundException {
        System.out.println("welcome client");
        Socket socket = new Socket("localhost", 4444);
        System.out.println("Client connected");
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("Ok");
        String message = "test";
        os.writeObject(message);

        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        String returnMessage = (String) is.readObject();
        System.out.println("return Message is=" + returnMessage);
        socket.close();
    }
}