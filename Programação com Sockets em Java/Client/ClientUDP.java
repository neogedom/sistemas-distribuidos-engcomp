import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * ClientUDP
 */
public class ClientUDP {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatagramSocket socket = null;
        byte [] buffRequest = null;


        try {
            socket = new DatagramSocket();

            // O DatagramPacket a ser enviado espera um buffer, um tamanaho, 
            // um host do tipo InetAddress e uma porta
            System.out.println("Digite mensagens ao servidor ou q para sair: ");

            while (true) {  
            
                //Pega o endereço localhost e encapsula em um objeto do tipo InetAddress
                InetAddress serverHost = InetAddress.getByName("localhost");
                DatagramPacket dgFromClient;
                String msg =  scanner.nextLine();

                if (msg.equals("q")){
                    buffRequest = msg.getBytes();
                    dgFromClient = new DatagramPacket(buffRequest, buffRequest.length, serverHost, 3000);
                    socket.send(dgFromClient);
                    break;
                }

                msg = "Cliente diz: " + msg;
                buffRequest = msg.getBytes();
                
            
                //Cria um DatagramPacket (datagrama) e coloca a mensagem, 
                // o endereço do servidor e a porta (request)   
                dgFromClient = new DatagramPacket(buffRequest, buffRequest.length, serverHost, 3000);
                
                // Envia o datagrama para o servidor
                socket.send(dgFromClient);
            }
           
            scanner.close();
            socket.close();
            
            
        } catch (IOException e) {
           e.printStackTrace();
        }
        
    }

    // Método de conversão da mensagem que vem em bytes para o formato String
    public static StringBuilder bytesToString (byte [] msgInBytes) {

        if (msgInBytes == null) {
            return null;
        }

        StringBuilder string = new StringBuilder();
        for (byte b : msgInBytes) {
            if (b != 0) {
                string.append((char) b);
            }
        }

        return string;
    }
}