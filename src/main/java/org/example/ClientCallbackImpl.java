package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ClientCallbackImpl extends UnicastRemoteObject implements ClientCallback {

    // O construtor deve lançar RemoteException [11]
    public ClientCallbackImpl() throws RemoteException {
        super();
    }

    @Override
    public void receiveMessage(String message) throws RemoteException {
        // Exibe a mensagem recebida do servidor no seu console [6]
        System.out.println("\n[CHAT]: " + message);
        System.out.print("> ");
    }

    @Override
    public void updateUsers(List<String> usuarios) throws RemoteException {
        // Atualiza a lista de quem está online [12]
        System.out.println("\n[SISTEMA]: Usuários online: " + usuarios);
        System.out.print("> ");
    }
}