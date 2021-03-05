package network.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class WorldClockService implements WorldClock {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        // 将此服务转换为远程服务接口
        WorldClock worldClock = new WorldClockService();
        WorldClock skeleton = (WorldClock) UnicastRemoteObject.exportObject(worldClock, 0);

        //将RMI服务注册到1099端口
        System.out.println("start remote service...");
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("WorldClock", skeleton);
    }

    @Override
    public LocalDateTime getLocalDateTime(String zoneId) throws RemoteException {
        return LocalDateTime.now(ZoneId.of(zoneId)).withNano(0);
    }
}
