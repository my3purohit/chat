import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;

public class ConnHandler extends EchoServer implements Runnable{
	
	
	public Socket client_socket;
	Thread t;
	PrintWriter out;
	BufferedReader in;
	public ConnHandler(Socket client_socket)
	{
		System.out.println("Inside conn handler constructor\n");
		this.client_socket=client_socket;
//		this.t = new Thread(this);
//		this.t.start();
	}

	@Override
	public void run()
	{
		System.out.println("Creating a new client");
		try{
				//write to clients output stream
				out =
		                new PrintWriter(client_socket.getOutputStream(), true);
				
				//read from clients input stream3.0
				in = new BufferedReader(
		                new InputStreamReader(client_socket.getInputStream()));	
				
					//System.out.println("Server listening on "+portNo);

			System.out.println("Server listening......");
			String inputLine;
			String outputLine;
			
			while ((inputLine = in.readLine()) != null)
			{
				Iterator<ConnHandler> itr = clientList.listIterator();
				outputLine = inputLine;
				//out.println(outputLine);
				while(itr.hasNext())
				{
					itr.next().out.println(outputLine);
				}
				if(outputLine.equals("Bye.")){
                    out.println("Come back soon!!");
                }
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	

