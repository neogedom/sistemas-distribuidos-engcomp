import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class ServerUDP {

    public ServerUDP () {
        try (DatagramSocket socket = new DatagramSocket(3000)) {
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void run () {

    }

    public static void main(String... args) {
        
        
        byte[] buffRequest = new byte[1000];
        
           //Conecte usando usando um socket UDP em uma porta específica
        try (Scanner scanner = new Scanner(System.in);
            DatagramSocket socket = new DatagramSocket(3000);){
            
            //Objetos DatagramPacket (pacotes autocontidos) são usados para se comunicar por meio de DatagramSockets
            // Todo DatagramPacket consiste em um buffer de dados, um host remoto para o qual os dados precisam ser enviados
            // e uma porta em que o agente remoto será ouvido
            System.out.println("Aguardando mensagem...");
               
            while (true) {
            
                InetAddress serverHost = InetAddress.getByName("localhost");
                DatagramPacket dgFromServer = new DatagramPacket(buffRequest, buffRequest.length, serverHost, 3000);

                //Tenta receber a mensagem do cliente dentro do datagrama
                DatagramPacket dgFromClient = new DatagramPacket(buffRequest, buffRequest.length);
                socket.receive(dgFromClient);
                String fromClient = new String(dgFromClient.getData(), dgFromClient.getOffset(), dgFromClient.getLength());
                
                if (fromClient.equals("q")){
                    break;
                } else {
                    System.out.println(fromClient);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}