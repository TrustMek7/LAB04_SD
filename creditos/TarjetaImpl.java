package creditos;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.HashMap;

public class TarjetaImpl extends UnicastRemoteObject implements TarjetaInterface {
    private HashMap<String, Double> cuentas;

    public TarjetaImpl() throws RemoteException {
        cuentas = new HashMap<>();
        cuentas.put("1234567890", 100.0);
        cuentas.put("0987654321", 250.0);
    }

    public double consultarSaldo(String numeroTarjeta) throws RemoteException {
        return cuentas.getOrDefault(numeroTarjeta, 0.0);
    }

    public boolean pagar(String numeroTarjeta, double monto) throws RemoteException {
        double saldo = cuentas.getOrDefault(numeroTarjeta, 0.0);
        if (saldo >= monto) {
            cuentas.put(numeroTarjeta, saldo - monto);
            return true;
        }
        return false;
    }

    public void recargar(String numeroTarjeta, double monto) throws RemoteException {
        double saldo = cuentas.getOrDefault(numeroTarjeta, 0.0);
        cuentas.put(numeroTarjeta, saldo + monto);
    }
}