package exemplo.ola;

import java.rmi.Naming;

public class Cliente {
    
    private Cliente() {

    }

    public static void main(String[] args) {

        try {
           
            // Procurando pelo objeto distribuído registrado previamente com o Ola
            Ola stub = (Ola) Naming.lookup("rmi://localhost:1099/Ola");

            // Invocando métodos do objeto distribuıdo
            String resposta = stub.digaOla();
            System.out.println("Resposta: " + resposta);
            
        } catch (Exception e) {
            System.err.println("Exceção no cliente: " + e.getMessage());
        }
    }
}