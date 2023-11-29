package cadastroclient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;
import model.Produto;

public class CadastroClient {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket clientSocket = null;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;

        try {
            // Conectar ao servidor
            clientSocket = new Socket(InetAddress.getByName("localhost"), 4321);
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());

            // Realizar operação de login
            out.writeObject("op1");
            out.writeObject("op1");
            String result = (String) in.readObject();

            if (!"ok".equals(result)) {
                System.out.println("Erro de login");
                return;
            }

            System.out.println("Usuário conectado com sucesso!!");

            // Obter e imprimir a lista de produtos
            out.writeObject("L");
            List<Produto> produtos = (List<Produto>) in.readObject();
            for (Produto produto : produtos) {
                System.out.println(produto.getNome());
            }

            // Encerrar a conexão
            out.writeObject("X");

        } finally {
            // Fechar recursos
            closeResources(out, in, clientSocket);
        }
    }

    private static void closeResources(ObjectOutputStream out, ObjectInputStream in, Socket socket) {
        try {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
