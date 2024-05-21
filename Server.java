import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;


public class Server
{
	ArrayList<ConnectWithSpecificClient> clients= new ArrayList<ConnectWithSpecificClient>();
	JsonFile jsonConnect=new JsonFile();
	//הסרד הראשי שמנהל את כל התוכנית
	public void runGameServer()
	{
		ServerSocket serverSocket;
		try{
			//מאזין לפורט שנבחר
			serverSocket = new ServerSocket(8001);
			System.out.println("I am online");
			//מחכה להודעת התחברות מהלקוח
			int k=0;
			boolean f=true;
			while (f)
			{
				Socket sock = serverSocket.accept();//נעצר על השורה הזו עד להתחברות
				System.out.println("Server: Connection accepted");
				//כאשר לקוח מתחבר פותח לו עצם חדש
				ConnectWithSpecificClient  serth=new ConnectWithSpecificClient(sock, this);
				clients.add(serth);
				//ואת העצם הזה שם בסרד
				Thread t=new Thread(serth); 
				//מאתחל  אותו
				t.start();				
				
				System.out.println("stop");
				k++;
			}

		} 
		catch (IOException e)
		{
			System.out.println("Server: Could not connect.");
			System.exit(1);        
		}
	}
	
	public void sendToClients(String st)
	{
		for (int i = 0; i < clients.size(); i++)
		{
			clients.get(i).sendMessage(st);
		}
	}
	
	public static void main(String [] args)
	{
		Server server=new Server();
		server.runGameServer();
	}
	
	public void addToJson(String st)//מוסיף עוד שורה בגייסון
	{
		String [] s=st.split(","); //מחלק בין הנתונים
		GameInfo  gi=new GameInfo (s[1],Integer.parseInt(s[2]),Integer.parseInt(s[3]));
		jsonConnect.addToJsonArray(gi);
		
	}
	
	public String readFromJson()
	{
		
		GameInfo[] arrG=jsonConnect.fromJsonToArray();
		if (arrG!=null)
		{
		System.out.println(arrG.length);
		String s="";
		for (int i = 0; i < arrG.length; i++)
		{
			s+=(arrG[i].toString())+"_";
		}
		System.out.println("s="+s);
		return s ;
		}
		else
			return "";
	}

}