import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @author shay
 *
 */
public class Client
	{
		private Socket socket;
		private BufferedWriter streamOut;//stream
		private ClientReceive clientreceive;
		private Draw g;
		
		/**
		 * @param g פעולה בונה יוצרת לקוח
		 */
		public Client(Draw g)
		{
			try
			{
				socket = new Socket("127.0.0.1",8001);//socket gets ip and port
				streamOut=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				clientreceive=new ClientReceive(socket,g);
				Thread t = new Thread(clientreceive);
				t.start();
				
			}
			catch(IOException e)
			{
				System.err.println("client: could not get I/O for the connection to server");
			}
			
			
		}
		
		/**
		 * פעולה השולחת הודעה
		 * @param msg 
		 */
		public void sendMessage(String msg)//send the message
		{
			System.out.println("client");
			try
			{
				streamOut.write(msg+"\n");//write the message
				streamOut.flush();//send the message to the server
			}
			catch(IOException e)
			{
				System.out.println("failed sending");
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
}