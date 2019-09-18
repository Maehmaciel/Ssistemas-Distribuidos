import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer{
    public static int PORT =7000;
    public ServerSocket socket;

    public ChatServer() throws IOException{
        socket=new ServerSocket(PORT);
    }
    public static void receberMsgs(Socket cliSock) throws IOException{
        BufferedReader in=new BufferedReader(new InputStreamReader(cliSock.getInputStream()));
              //autoflush
              PrintWriter out=new PrintWriter(cliSock.getOutputStream(),true);
              out.println("Bem vindo");
              out.println("iai viadaj");
              String m;
              do{
                  m=in.readLine();
              System.out.println("Msg do cliente:"+m);
              }while(!m.equals(null));
    }
    public static void main(String[] args) {
        try {
            ChatServer server=new ChatServer();
            System.out.println("Servidor iniciado");
            while(true){
               //aceitando conexoes que chegam, enquanto nao aceitar, os clientes ficam na fila, aceita e cria o socket
              Socket cliSock= server.socket.accept();
              System.out.println(cliSock.getRemoteSocketAddress());//conectou
              receberMsgs(cliSock);
              
            }
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Nao foi possivel iniciar"+e.getMessage());
        }
    }
 
}