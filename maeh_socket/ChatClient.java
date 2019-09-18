import java.net.Socket;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
public class ChatClient{
    private final BufferedReader in;
    private final PrintWriter out;
    private final Scanner scanner;
    //o cliente tem que dizer o ip do servidor e a porta
    private Socket socket;
    public static String IP_SERVER ="localhost";

    public ChatClient() throws IOException{
        socket= new Socket(IP_SERVER,ChatServer.PORT);
        System.out.println("Requisiçao feita: ");
        in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //autoflush
        out=new PrintWriter(socket.getOutputStream(),true);
        //in.readLine();//requisicao bloqueante se o servidor nao aceitar
            //System.out.println("TESTE:"+input.read_string());
            System.out.println("Msg do serv:"+in.readLine());
            System.out.println("Digite mensagem");
            scanner=new Scanner(System.in);
            String msg;
        do{
            System.out.println("'sair' para sair");
            msg=scanner.nextLine();
           
            //enviar pro servidor
            out.println(msg);
        }while(!msg.equalsIgnoreCase("sair"));
        
    }
    //o cliente tem que conectar o o servidor tem que aceitar
    public static void main(String[] args) {
        
        try {
            ChatClient cliente=new ChatClient();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Nao foi possivel iniciar: "+e.getMessage());
        }
    }
 
}