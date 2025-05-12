package creditos;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TarjetaInterface extends Remote {
    public double consultarSaldo(String numeroTarjeta) throws RemoteException;
    public boolean pagar(String numeroTarjeta, double monto) throws RemoteException;
    public void recargar(String numeroTarjeta, double monto) throws RemoteException;
}