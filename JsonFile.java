import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author shay
 *
 */

public class JsonFile
{
	public  final String key = "game";
	public  File f= new File("RushHour.txt");
	public JSONArray jsona;

	public  File creatfile() throws IOException //בניית קובץ
	{
		f.createNewFile();
		return f;
	}



	public void addToJsonArray(GameInfo gameInfo)
	{
		System.out.println(f.exists());
		if (!f.exists())
		{
			try {
				creatfile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			jsona = new JSONArray();
		}
		else 
		{
			try {
				jsona = readAnArrayFromFile();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			System.out.println(jsona);
			if (jsona.size() > 10)
			{
				System.out.println("size"+jsona.size());
                jsona.remove(0);
			}
		}
		jsona.add(toJsonObj(gameInfo));
		try {
			writeAnArrayToFile(jsona);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}
	}
	/**
	 * @param g עצם של גיים אינפו
	 * @return מחזיק אובייקט גייסון
	 */
	public  JSONObject toJsonObj(GameInfo g)//בניית אובייקט של גייסון מגיים אינפו
	{

		JSONObject obj = new JSONObject();
		obj.put("name", g.getName());
		obj.put("score", g.getScore());
		obj.put("level", g.getLevel());

		return obj;
	}

	/**
	 * @param obj קבלת אובייקט גייסון
	 * @return מחזיר גיים אינפו
	 */
	public GameInfo fromJsonObj(JSONObject obj) //בניית גיים אינפו מאובייקט גייסון
	{
		GameInfo g = new GameInfo();
		g.setName(obj.get("name").toString());
		g.setScore(Integer.parseInt((obj.get("score") + "")));
		g.setLevel(Integer.parseInt((obj.get("level") + "")));
		return g;
	}

	/**
	 * @param jsona קובץ גייסון
	 * @return מערך גיים אינפו
	 */
	public  GameInfo[] fromJsonToArray()//בניית מערך גיים אינפו מקובץ גייסון
	{
		JSONArray jsona=null;
		try {
			jsona=readAnArrayFromFile();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (ParseException e) {
			System.out.println("ParseException");
		} catch (IOException e) {
			System.out.println("IOException");
		}
		if (jsona!=null)
		{
			
			GameInfo[] a = new GameInfo[jsona.size()];
			for (int i = 0; i < a.length; i++)
				a[i] = fromJsonObj((JSONObject) jsona.get(i));

			return a;
		}
		return null;
	}

	/**
	 * @param gameInfo מערך
	 * @return קובץ גייסון
	 */
	public  JSONArray toJsonArray(GameInfo[] gameInfo) //בניית קובץ גייסון ממערך של גיים אינפו
	{
		JSONArray jsonA = new JSONArray();
		for (int i = 0; i < gameInfo.length; i++)
		{
			jsonA.add(toJsonObj(gameInfo[i]));
		}
		try {
			writeAnArrayToFile(jsonA);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonA;
	}

	/**
	 * @param jsona  קובץ גייסון
	 * @throws FileNotFoundException
	 */
	public void writeAnArrayToFile(JSONArray jsona) throws FileNotFoundException //הכנסת מערך נתונים לקובץ גייסון
	{
		JSONObject root = new JSONObject();
		root.put(key, jsona);
		PrintWriter writer = new PrintWriter(f);
		writer.append(root.toJSONString());
		writer.close();
	}
	
	 public  JSONArray readAnArrayFromFile() throws FileNotFoundException, ParseException, IOException {
		
		JSONParser parser = new JSONParser();
		JSONObject readObj = (JSONObject) parser.parse(new FileReader(f));
		JSONArray jsona = (JSONArray) readObj.get(key);
		
        return jsona;
		    
	    }
	
}
