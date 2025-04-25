import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Set;


public class ClientHandler implements Runnable{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Set<ClientHandler> clients;

    public ClientHandler(Socket socket, Set<ClientHandler> clients) {
        this.socket = socket;
        this.clients = clients;

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.err.println("Lỗi khi tạo I/O cho client: "+e.getMessage());
        }
    }

    @Override
    public void run(){
        try {
            String msg;
            while ((msg = in.readLine()) != null) {
                broadcast("Client "+ socket.getInetAddress().getHostAddress()+ ": "+ msg);
            }
        } catch (IOException e) {
            System.out.println("Client ngắt kết nối: "+ socket.getInetAddress().getHostAddress());
        } finally {
            try {
                clients.remove(this);
                socket.close();
            } catch (IOException e) {
                System.out.println("Lỗi khi đóng kết nối client.");
            }
        }
    }

    private void broadcast(String message) {
        synchronized (clients) {
            for (ClientHandler client : clients) {
                if (client != this){
                    client.out.println(message);
                }
            }
        }
        System.out.println(message);
    }
}
