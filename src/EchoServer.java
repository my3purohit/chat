import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.lang.Thread;

public class EchoServer 
{
	public static Vector<ConnHandler> clientList = new Vector<ConnHandler>();
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		
		//check args length > 1
		if(args.length != 1)
			System.out.println("Enter  a port number\n");
		
		//create a new serversocket with args[0]
		int portNo = Integer.parseInt(args[0]);
		int count = 0;
		ServerSocket server_socket = new ServerSocket(portNo);
		Socket client_socket;
		while(true){
			try
			{
				
					client_socket = server_socket.accept();
					
					count++;
					System.out.println("Thread count"+ count);
					ConnHandler connhandler = new ConnHandler(client_socket);
					
					clientList.add(connhandler);
					new Thread(connhandler).start();
				
			}
			
			catch (IOException e) 
			{
	            System.out.println("Exception caught when trying to listen on port "
	                + portNo + " or listening for a connection");
	            System.out.println(e.getMessage());
	        }
		}
	}

}
