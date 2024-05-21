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
	//���� ����� ����� �� �� �������
	public void runGameServer()
	{
		ServerSocket serverSocket;
		try{
			//����� ����� �����
			serverSocket = new ServerSocket(8001);
			System.out.println("I am online");
			//���� ������ ������� ������
			int k=0;
			boolean f=true;
			while (f)
			{
				Socket sock = serverSocket.accept();//���� �� ����� ��� �� ��������
				System.out.println("Server: Connection accepted");
				//���� ���� ����� ���� �� ��� ���
				ConnectWithSpecificClient  serth=new ConnectWithSpecificClient(sock, this);
				clients.add(serth);
				//��� ���� ��� �� ����
				Thread t=new Thread(serth); 
				//�����  ����
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
	
	public void addToJson(String st)//����� ��� ���� �������
	{
		String [] s=st.split(","); //���� ��� �������
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