import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author shay
 * @version 13/06/2019
 */
public class ClientReceive implements Runnable
{
	private Draw g;
	private BufferedReader streamIn;//stream input
	private Socket socket;
	
	
	/**
	 * פעולה בונה
	 * @param s 
	 * @param g
	 */
	public ClientReceive(Socket s, Draw g)
	{
		this.g=g;
		this.socket=s;
	}
	
	/**
	 * מאזין לשרת לקבלת מסר
	 * @see java.lang.Runnable#run()
	 */
	public void run()
	{
		
		try
		{
			streamIn=new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			
			String serverString;
			while((serverString=streamIn.readLine())!=null)
			{
				System.out.println("server says:" + serverString);
				g.showMessage(serverString);
				
			}
			
		}
		catch(IOException e)
		{
			System.out.println("failed receiving");
		}
	}
}