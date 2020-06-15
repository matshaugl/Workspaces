
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

// Organize imports     
public class Client {

    public static void main(String[] args) throws UnknownHostException,
            IOException, ClassNotFoundException {

        Socket socket = new Socket("localhost", 4444);
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        String message = "";

        Scanner keyboard = new Scanner(System.in);

        while (!message.equals("exit")) {
            System.out.println("Enter message to server: ");
            message = keyboard.nextLine();

            os.writeObject(message);

            if (!message.equals("exit")) {
                String returnMessage = (String) is.readObject();
                System.out.println("return Message is=" + returnMessage);
            }

        }

        socket.close();
    }
}
