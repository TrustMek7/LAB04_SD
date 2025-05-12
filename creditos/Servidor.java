package creditos;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            TarjetaImpl obj = new TarjetaImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("TarjetaService", obj);
            System.out.println("Servidor listo.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}