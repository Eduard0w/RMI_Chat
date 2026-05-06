package org.example;

import java.rmi.Naming;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Configure o IP do servidor e seu nome de usuário aqui
        String serverIp = "10.8.184.1";
        String userName = "Juninho";

        try {
            // Localiza o objeto remoto do servidor usando o registro de nomes [14, 16]
            // O nome "ChatService" deve ser o mesmo que o servidor usou no rebind
            String url = "rmi://" + serverIp + "/ChatService";
            ChatInterface server = (ChatInterface) Naming.lookup(url);

            // Cria e exporta o seu objeto de callback para o servidor poder te responder [6, 17]
            ClientCallbackImpl myCallback = new ClientCallbackImpl();

            // Registra sua presença no servidor [12, 18]
            server.registerClient(userName, myCallback);

            System.out.println("=== CONECTADO AO CHAT RMI ===");
            System.out.println("Digite sua mensagem ou '/sair' para encerrar.");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("> ");
                String msg = scanner.nextLine();

                if (msg.equalsIgnoreCase("/sair")) {
                    server.removeClient(userName); // Avisa o servidor que saiu [18]
                    break;
                }

                // Envia a mensagem para o servidor (Invocação Remota) [19, 20]
                server.send(userName, msg);
            }

            System.out.println("Encerrando conexão...");
            System.exit(0);

        } catch (Exception e) {
            System.err.println("Erro crítico no cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}