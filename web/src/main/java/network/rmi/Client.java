package network.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        WorldClock skeleton = (WorldClock) registry.lookup("WorldClock");

        System.out.println(skeleton.getLocalDateTime("Asia/Shanghai"));
    }
}
