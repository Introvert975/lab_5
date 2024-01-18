import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class User {
    public static void main(String[] args) throws IOException {

        Socket user_socket0 = new Socket(InetAddress.getLocalHost(), 8000);
        Socket user_socket1 = new Socket(InetAddress.getByName("92.124.162.225"),8000);
        Socket user_socket2 = new Socket(InetAddress.getByName("127.0.0.1"),8000);

        BufferedReader reader = new BufferedReader( new InputStreamReader(user_socket0.getInputStream()));//requires to server
        BufferedReader reader2 = new BufferedReader( new InputStreamReader(user_socket1.getInputStream()));
        BufferedReader reader3 = new BufferedReader( new InputStreamReader(user_socket2.getInputStream()));

        String msg = reader.readLine();
        System.out.println(msg);

        msg = reader2.readLine();
        System.out.println(msg);

        msg = reader3.readLine();
        System.out.println(msg);

        user_socket0.close();
        user_socket1.close();
        user_socket2.close();
    }
}