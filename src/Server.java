import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {

        ArrayList<InetAddress> users = new ArrayList<>();
        BufferedReader buffer_Read = new BufferedReader(new FileReader("file.txt"));
        users.add(InetAddress.getByName(buffer_Read.readLine()));
        users.add(InetAddress.getByName(buffer_Read.readLine()));
        users.add(InetAddress.getByName(buffer_Read.readLine()));
        buffer_Read.close();
        ArrayList<InetAddress> chose_users = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Запишите количество клиентов, до которых должно дойти сообщение: ");
        for(int i=0; i<users.size(); i++)
        {
            System.out.println(i+". "+users.get(i)+"\n");
        }
        String [] list = sc.nextLine().split(" ");
        for(int i=0; i< list.length; i++)
        {
            chose_users.add(users.get(Integer.parseInt(list[i])));
        }

        ServerSocket serverSocket = new ServerSocket(8000);
        for (int i=0;i<3;i++)
        {
            Socket clientSocket = serverSocket.accept();

            if(chose_users.contains(clientSocket.getInetAddress()))
            {
                OutputStreamWriter wr = new OutputStreamWriter(clientSocket.getOutputStream());
                wr.write("Hola! You forgot about me? :/\n");
                wr.flush();
                wr.close();
            }
            clientSocket.close();
        }
        serverSocket.close();

    }
}
