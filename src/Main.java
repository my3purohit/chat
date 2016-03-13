import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

public class Main {

	
    public static void main(String[] args) throws Exception{
        if(args.length == 0) {
            //String hostName = args[0];
            //int portNumber = Integer.parseInt(args[1]);
        	int portNumber = 4444;
            try {
                    Socket serverSocket = new Socket("localhost", portNumber);
                    PrintWriter out1 = new PrintWriter(serverSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
                    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            
                System.out.println("You are now connected");
                String input;
                String message=null;
                while(true) {
                    if (stdIn.ready()) {
                        out1.println(stdIn.readLine());
                        System.out.println(in.readLine());
                    }
                    if(in.ready()){
                        System.out.println(in.readLine());
                    }
                }
            }
            finally{
            	
            }
        }
        //catch(Exception e)
        //{
        //	
        //}
        else{
            System.out.println("Usage: Main <hostServer> <portNumber>");
        }

    }
}