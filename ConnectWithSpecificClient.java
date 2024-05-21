import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;

public class ConnectWithSpecificClient implements Runnable
{
	private Socket socket;
	private BufferedWriter streamOut;//stream output
	private BufferedReader streamIn;//stream input
	private Server server;
	
	public ConnectWithSpecificClient(Socket socket, Server server)
	{
		this.server=server;
		this.socket=socket;
		try 
		{
			this.streamOut=new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
			this.streamIn=new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		}
		catch(IOException e)
		{
		 System.out.println("there was a problem, try to fix it or don't");
		}
		
	}
	
	public void sendMessage(String msg)
	{
		try
		{
			streamOut.write(msg + "\n");//write the message
			streamOut.flush();//send the message to the server
		}
		catch(IOException e)
		{
			System.out.println("failed sending");
		}
	}
	
	public void run()//מחכה להודעות
	{
		System.out.println("run");
		try
		{
			String msg="";
			
			while((msg=streamIn.readLine())!=null)
			{
				System.out.println(msg);
				if(msg.contains("save"))
				{
					server.addToJson(msg);//מוסיפה לגיסון את הנתון שקיבלנו
				}
				sendMessage(server.readFromJson());// שולח את הנתונים לטבלת שיאים כי הוא קורא מהגייסון
				
				//server.sendToAllClients(msg);
			}
		
			//System.out.println("failed receiving");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("faild tun");
		}
	}
	

}
