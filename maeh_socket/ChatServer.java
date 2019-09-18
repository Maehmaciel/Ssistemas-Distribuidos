import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer{
    public static int PORT =7000;
    public ServerSocket socket;

    public ChatServer() throws IOException{
        socket=new ServerSocket(PORT);
    }
    public static void receberMsgs(Socket cliSock) {
      
    }
//cli socket means socket
    public static void main(String[] args) {
        try {
            ChatServer server=new ChatServer();
            System.out.println("Servidor iniciado");
            while(true){
               //aceitando conexoes que chegam, enquanto nao aceitar, os clientes ficam na fila, aceita e cria o socket
              Socket cliSock= server.socket.accept();
              System.out.println(cliSock.getRemoteSocketAddress());//conectou
              //criou a thread //iniciar a thread
              new Thread(new ClientSocket(cliSock)).start();
             
              
            }
       
    
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Nao foi possivel iniciar"+e.getMessage());
        }
    }

 
}