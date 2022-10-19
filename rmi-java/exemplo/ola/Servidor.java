package exemplo.ola;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor extends UnicastRemoteObject implements Ola  {

    private static final long serialVersionUID = 1L;

    public Servidor() throws RemoteException {
        super();
    }

    @Override
    public String digaOla() throws RemoteException {
        
        return "Olá mundo!";
    }

    public static void main(String[] args) {
        
       
        try {
            //Criando uma instância do servidor de registro
            Registry registry = LocateRegistry.createRegistry(1099);
        } catch (RemoteException e1) {
            
            System.err.println("rmiregistry is already launched on this port");
            e1.printStackTrace();
        }
     
        try {
            
            Servidor obj = new Servidor();

            // Definindo o nome do servidor
            // System.setProperty("java.rmi.server.hostname", "127.0.0.1");

            // Ola stub = (Ola) UnicastRemoteObject.exportObject(obj, 0);  
            // LocateRegistry.createRegistry(1099);
    
            // Registrando objeto distribuıdo
            // registry.bind("Ola", stub);

            Naming.rebind("rmi://localhost:1099/Ola", obj);

            System.out.println("Servidor está pronto");
        } catch (Exception e) {

            System.err.println("have you launched rmiregistry?");
            e.printStackTrace();
        }
       

    }
    
}