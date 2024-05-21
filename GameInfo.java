
public class GameInfo 
{
	private String name; //שם המשחקן
	private int score; //ניקוד
	private int level; //שלב


	/**
	 * @param name שם
	 * @param score ניקוד
	 * @param level שלב
	 */
	public GameInfo(String name,int score,int level)//פעולה בונה 
	{
		this.name= name;
		this.score = score;
		this.level=level;
	}

	public GameInfo()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return מחזיר את ערכי תכונות העצם
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		// TODO Auto-generated method stub
		return name+ ","+score+","+level;
	}

	/**
	 * @return מחזירה את שם השחקן
	 */
	public String getName()//מחזירה את שם השחקן
	{
		return name;
	}

	/**
	 * @return מחזירה את הניקוד
	 */
	public int getScore() //מחזירה את הניקוד
	{
		return score;
	}
	/**
	 * @return מחזירה את השלב
	 */
	public int getLevel() //מחזירה את השלב
	{
		return level;
	}

	/**
	 * @param name שם
	 */
	public void setName(String name) //מעדכנת את השם
	{
		this.name = name;
	}

	/**
	 * @param score ניקוד
	 */
	public void setScore(int score) //מעדכנת את הניקוד
	{
		this.score =score;
	}

	/**
	 * @param level שלב
	 */
	public void setLevel(int level)//מעדכנת את השלב
	{
		this.level=level;
	}
}
