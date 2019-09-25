import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket implements Runnable {
    //cliente do lado do servidor
    //o servidor que enviar msg
    private Socket cliSock;
    private BufferedReader in;
    private PrintWriter out;
    ChatServer server;
    public ClientSocket(Socket cliSock, ChatServer serv){
        this.cliSock=cliSock;
        this.server=serv;
    }

    public void enviarMsg(String msg) {
        //servidor que esta enviando a msg
        out.println(msg);
    }
   
    @Override
    public void run() {
       
        try {
            this.in = new BufferedReader(new InputStreamReader(cliSock.getInputStream()));
                this.out = new PrintWriter(cliSock.getOutputStream(), true);
                out.println("Bem vindo");

                String m;
                do{
                m=in.readLine();
                System.out.println("Msg do cliente:"+m);
                server.enviaMsgTodos(m,this);
                }while(!m.equals(null));
            
        } catch (IOException e) {
           System.out.println("Erro:"); 
        }
    }


}