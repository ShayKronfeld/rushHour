import java.awt.Point;


/**
 * @author shay
 * @version 12/06/2019
 */
public class Car
{
	private String color; 
	private int size; 
	private boolean direction; 
	private int xPoint; 
	private int yPoint; 
	private boolean isVisible;
	protected int carNumber; 
	protected String image= new String(); 


	/**
	 * @param carNumber ���� �������
	 * @param size ���� �������
	 * @param color ��� �������
	 */
	public Car(int carNumber, int size, String color) 
	{
		this.color=color;
		this.size=size;
		this.carNumber = carNumber;
		this.image = this.color;
		this.isVisible = false;

	}

	
	/**
	 * @return ����� �� �� ������
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image ���� �� �� ������
	 */
	public void setImage(String image) 
	{
		this.image = image;
	}

	/**
	 * @return ����� �� �� ����
	 */
	public String getColor()
	{
		return this.color; 
	}

	/**
	 * @return ����� �� �����
	 */
	public int getSize()
	{
		return this.size; 
	}

	/**
	 * @return ����� �� ������
	 */
	public boolean getDirection()
	{
		return this.direction; 
	}

	/**
	 * @return ����� �� ���� ������ �������
	 */
	public int getXPoint() 
	{
		return this.xPoint; 
	}
	/**
	 * @return ����� �� �� ������ �������
	 */
	public int getYPoint() 
	{
		return this.yPoint; 
	}
	/**
	 * @return ����� �� ���� �������
	 */
	public int getCarNumber() 
	{
		return this.carNumber;
	}

	/**
	 * @param color ���� �� ��� �������
	 */
	public void setColor(String color)
	{
		this.color=color;
	}

	/**
	 * @param size ���� �� ���� �������
	 */
	public void setSize(int size)
	{
		this.size=size;
	}

	/**
	 * @param direction ���� �� ����� �������
	 */
	public void setDirection(boolean direction)
	{
		this.direction=direction;
	}

	/**
	 * @param xPoint ���� �� ���� ������ �� �������
	 */
	public void setXPoint(int xPoint) 
	{
		this.xPoint= xPoint; 
	}

	/**
	 * @param yPoint ���� �� �� ������ �� �������
	 */
	public void setYPoint(int yPoint) 
	{
		this.yPoint= yPoint; 
	}

	/**
	 * @param carNumber ���� �� ���� �������
	 */
	public void setCarNumber(int carNumber) 
	{
		this.carNumber=carNumber;
	}

	/**
	 * ���� �������� ����� ����� ���� ������
	 */
	public void setVisible(){
		this.isVisible = true;
	}
	/**
	 * ���� �������� �� ����� ����� ���� ������
	 */
	public void setUnvisible(){
		this.isVisible = false;
	}

	/**
	 * @return ���� ��� ������� �����
	 */
	public boolean isVisible(){
		return this.isVisible;
	}
	/**
	 * @return ����� �� ������ �� �������
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return "number "+this.getCarNumber()+" direction "+this.getDirection()+"size:"+this.getSize();

	}
	

}

