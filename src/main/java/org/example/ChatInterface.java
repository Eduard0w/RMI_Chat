package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ChatInterface extends Remote {
    void send(String user, String message) throws RemoteException;
    void registerClient(String name, ClientCallback client) throws RemoteException;
    void removeClient(String name) throws RemoteException;
    List<String> getOnlineUsers() throws RemoteException;
}