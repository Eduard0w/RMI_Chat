package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ClientCallback extends Remote {
    void receiveMessage(String message) throws RemoteException;
    void updateUsers(List<String> usuarios) throws RemoteException;
}