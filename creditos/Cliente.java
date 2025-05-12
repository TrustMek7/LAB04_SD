package creditos;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost",1100);
            TarjetaInterface tarjeta = (TarjetaInterface) registry.lookup("TarjetaService");

            String numero = "1234567890";
            System.out.println("Saldo inicial: " + tarjeta.consultarSaldo(numero));
            tarjeta.recargar(numero, 50.0);
            System.out.println("Saldo después de recarga: " + tarjeta.consultarSaldo(numero));
            boolean pago = tarjeta.pagar(numero, 120.0);
            System.out.println("¿Pago exitoso? " + pago);
            System.out.println("Saldo final: " + tarjeta.consultarSaldo(numero));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}