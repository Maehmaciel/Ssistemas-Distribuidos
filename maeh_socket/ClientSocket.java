import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket implements Runnable {
    private Socket cliSock;

    public ClientSocket(Socket cliSock){
        this.cliSock=cliSock;
    }
    @Override
    public void run() {
        BufferedReader in;
        try {
            in = new BufferedReader(new InputStreamReader(cliSock.getInputStream()));
            PrintWriter out;
            
                out = new PrintWriter(cliSock.getOutputStream(), true);
                out.println("Bem vindo");
                out.println("iai viadaj");
                String m;
                do{
                    m=in.readLine();
                System.out.println("Msg do cliente:"+m);
                }while(!m.equals(null));
            
        } catch (IOException e) {
           System.out.println("Erro:"); 
        }
    }


}