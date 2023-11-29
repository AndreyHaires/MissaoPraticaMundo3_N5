package cadastroclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;
import model.Produto;

public class CadastroClienteV2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket clientSocket = null;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            clientSocket = new Socket(InetAddress.getByName("localhost"), 4321);
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());

            // Realizar login
            System.out.println("Digite o Usuário: ");
            out.writeObject(reader.readLine());

            System.out.println("Digite a Senha: ");
            out.writeObject(reader.readLine());

            String result = (String) in.readObject();
            if (!"ok".equals(result)) {
                System.out.println("Erro de login");
                return;
            }
            System.out.println("Login com sucesso");

            String comando;
            do {
                // Solicitar comando ao usuário
                System.out.println("Digite o Comando (L – Listar, E – Entrada, S – Saída, X – Finalizar): ");
                comando = reader.readLine();
                out.writeObject(comando);

                // Executar comandos
                switch (comando.toLowerCase()) {
                    case "l":
                        List<Produto> produtos = (List<Produto>) in.readObject();
                        for (Produto produto : produtos) {
                            System.out.println(produto.getNome());
                        }
                        break;
                    case "e":
                    case "s":
                        realizarEntradaOuSaida(reader, out);
                        break;
                }

            } while (!"x".equalsIgnoreCase(comando));

        } finally {
            closeResources(out, in, clientSocket);
        }
    }

    private static void realizarEntradaOuSaida(BufferedReader reader, ObjectOutputStream out) throws IOException {
        System.out.println("Digite o id da Pessoa");
        out.writeObject(reader.readLine());

        System.out.println("Digite o id do Produto");
        out.writeObject(reader.readLine());

        System.out.println("Digite a quantidade do Produto");
        out.writeObject(reader.readLine());

        System.out.println("Digite o valor do Produto");
        out.writeObject(reader.readLine());
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
