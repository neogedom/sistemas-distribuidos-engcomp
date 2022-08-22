import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * ClientTCP
 */
public class ClientTCP {

    public static void main(String[] args) {
        try {
            //O cliente instancia o objeto Socket com o endereço de IP do servidor 
            // e o número da porta
            // Então, o construtor de Socket() tenta conectar no servidor
            Socket client = new Socket("localhost", 5555);
            Scanner scanner = new Scanner(System.in);

            //Uma vez conectados servidor e cliente, a comunicação acontece por meio de I/O streams
            // OutputStream do servidor <---------> InputStream do cliente
            DataInputStream inputStream = new DataInputStream(client.getInputStream());
            String msg = inputStream.readUTF();
            System.out.println(msg); // Mensagem: Servidor conectado

            DataOutputStream outputStream = null;
            outputStream = new DataOutputStream(client.getOutputStream());
            System.out.println("Digite mensagens ao servidor ou q para sair: ");

            while (true) {
                msg = scanner.nextLine();
                if (msg.equals("q")) {
                    outputStream.writeUTF(msg);
                    break;
                }
                outputStream.writeUTF("Cliente diz: " + msg);
            }
            
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            scanner.close();
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}