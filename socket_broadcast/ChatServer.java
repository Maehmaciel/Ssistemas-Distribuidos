import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ChatServer{
    public static int PORT =7000;
    public ServerSocket serverSocket;
    private List<ClientSocket> clientes;

    public ChatServer() throws IOException{
        serverSocket=new ServerSocket(PORT);
        clientes=new ArrayList<>();
    }
    private void start() throws IOException{
        System.out.println("Servidor iniciado");
        while(true){
           //aceitando conexoes que chegam, enquanto nao aceitar, os clientes ficam na fila, aceita e cria o socket
          Socket socket= this.serverSocket.accept();
          System.out.println(socket.getRemoteSocketAddress());//conectou
          //criou a thread //iniciar a thread
          ClientSocket umCliente=new ClientSocket(socket,this);
           clientes.add(umCliente);
          new Thread(umCliente).start();
        }
          
    }


    public void enviaMsgTodos(String msg){
        for(ClientSocket cl: clientes){
            cl.enviarMsg(msg);
        }

    }
//cli socket means socket
    public static void main(String[] args) {
        try {
            ChatServer server=new ChatServer();
            server.start();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Nao foi possivel iniciar"+e.getMessage());
        }
    }

 
}