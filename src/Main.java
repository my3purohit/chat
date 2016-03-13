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
                    PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
                    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            
                System.out.println("You are now connected");
                String input;
                String message=null;
                while ((input = stdIn.readLine()) != null) {
                		if(input!="\n")
                		{
                			out.println(input);
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