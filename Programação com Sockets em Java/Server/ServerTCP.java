import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * ServerTCP
 */
public class ServerTCP {

    public static void main(String[] args) {
        try {
            // Um objeto ServerSocket é instanciado pelo servidor com um nº de porta para comunicação (bind)
            ServerSocket server = new ServerSocket(5555);
            Scanner scanner = new Scanner(System.in);
            
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
                System.out.println(inputStream.readUTF());
                System.out.println("Responda ao cliente ou digite q para sair: ");
                String msg = scanner.nextLine();
            
                if (msg.equals("q")) {
                    break;
                }

                outputStream.writeUTF("Servidor diz: " + msg);     
            }

            outputStream.flush();
            outputStream.close();
            inputStream.close();
            scanner.close();
            server.close();
           


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}