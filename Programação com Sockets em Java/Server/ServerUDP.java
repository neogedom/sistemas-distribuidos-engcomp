import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class ServerUDP {
    public static void main(String... args) {
        byte[] buffRequest = new byte[1000];
        

        try (Scanner scanner = new Scanner(System.in);
            DatagramSocket socket = new DatagramSocket(3000);){
            //Conecte usando usando um socket UDP em uma porta específica
            

            //Objetos DatagramPacket (pacotes autocontidos) são usados para se comunicar por meio de DatagramSockets
            // Todo DatagramPacket consiste em um buffer de dados, um host remoto para o qual os dados precisam ser enviados
            // e uma porta em que o agente remoto será ouvido
            System.out.println("Aguardando mensagem...");
               

            while (true) {
                // Prepara o DatagramPacket (datagrama) que encapsulará o datagrama vindo do cliente (request)
                DatagramPacket dgFromClient = new DatagramPacket(buffRequest, buffRequest.length);
            
                // Recebe a mensagem do cliente dentro do datagrama
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