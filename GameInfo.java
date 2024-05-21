
public class GameInfo 
{
	private String name; //�� ������
	private int score; //�����
	private int level; //���


	/**
	 * @param name ��
	 * @param score �����
	 * @param level ���
	 */
	public GameInfo(String name,int score,int level)//����� ���� 
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
	 * @return ����� �� ���� ������ ����
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		// TODO Auto-generated method stub
		return name+ ","+score+","+level;
	}

	/**
	 * @return ������ �� �� �����
	 */
	public String getName()//������ �� �� �����
	{
		return name;
	}

	/**
	 * @return ������ �� ������
	 */
	public int getScore() //������ �� ������
	{
		return score;
	}
	/**
	 * @return ������ �� ����
	 */
	public int getLevel() //������ �� ����
	{
		return level;
	}

	/**
	 * @param name ��
	 */
	public void setName(String name) //������ �� ���
	{
		this.name = name;
	}

	/**
	 * @param score �����
	 */
	public void setScore(int score) //������ �� ������
	{
		this.score =score;
	}

	/**
	 * @param level ���
	 */
	public void setLevel(int level)//������ �� ����
	{
		this.level=level;
	}
}
