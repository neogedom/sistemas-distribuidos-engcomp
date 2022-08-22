import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ServerTCP
 */
public class ServerTCP {

    public static void main(String[] args) {
        try {
            // Um objeto ServerSocket é instanciado pelo servidor com um nº de porta para comunicação (bind)
            ServerSocket server = new ServerSocket(5555);
            
            System.out.println("Aguardando mensagem...");
            // O servidor chama o método accept() e espera 
            // até que o cliente se conecte na porta dada (listen)
            Socket serverSocket = server.accept();

            // Uma vez conectados servidor e cliente, 
            // a comunicação acontece por meio de I/O streams
            // OutputStream do servidor <---------> InputStream do cliente
            DataOutputStream outputStream = new DataOutputStream(serverSocket.getOutputStream());
            outputStream.writeUTF("Servidor conectado!");
            DataInputStream inputStream = null;
            
            while(true) {       
                inputStream = new DataInputStream(serverSocket.getInputStream());
                String msg = inputStream.readUTF();
                if (msg.equals("q")){
                    break;
                }
                System.out.println(msg);
            }

            outputStream.close();
            inputStream.close();
            server.close();
           


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}