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
	 * @param carNumber מספר המכונית
	 * @param size גודל המכונית
	 * @param color צבע המכונית
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
	 * @return מחזיר את שם התמונה
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image משנה את שם התמונה
	 */
	public void setImage(String image) 
	{
		this.image = image;
	}

	/**
	 * @return מחזיר את שם הצבע
	 */
	public String getColor()
	{
		return this.color; 
	}

	/**
	 * @return מחזיר את הגודל
	 */
	public int getSize()
	{
		return this.size; 
	}

	/**
	 * @return מחזיר את הכיוון
	 */
	public boolean getDirection()
	{
		return this.direction; 
	}

	/**
	 * @return מחזיר את איקס המיקום ההתחלתי
	 */
	public int getXPoint() 
	{
		return this.xPoint; 
	}
	/**
	 * @return מחזיר את וי המיקום ההתחלתי
	 */
	public int getYPoint() 
	{
		return this.yPoint; 
	}
	/**
	 * @return מחזיר את מספר המכונית
	 */
	public int getCarNumber() 
	{
		return this.carNumber;
	}

	/**
	 * @param color משנה את צבע המכונית
	 */
	public void setColor(String color)
	{
		this.color=color;
	}

	/**
	 * @param size משנה את גודל המכונית
	 */
	public void setSize(int size)
	{
		this.size=size;
	}

	/**
	 * @param direction משנה את כיוון המכונית
	 */
	public void setDirection(boolean direction)
	{
		this.direction=direction;
	}

	/**
	 * @param xPoint משנה את איקס התחלתי של המכונית
	 */
	public void setXPoint(int xPoint) 
	{
		this.xPoint= xPoint; 
	}

	/**
	 * @param yPoint משנה את וי התחלתי של המכונית
	 */
	public void setYPoint(int yPoint) 
	{
		this.yPoint= yPoint; 
	}

	/**
	 * @param carNumber משנה את מספר המכונית
	 */
	public void setCarNumber(int carNumber) 
	{
		this.carNumber=carNumber;
	}

	/**
	 * אומר שהמכונית צריכה להיות בשלב הנוכחי
	 */
	public void setVisible(){
		this.isVisible = true;
	}
	/**
	 * אומר שהמכונית לא צריכה להיות בשלב הנוכחי
	 */
	public void setUnvisible(){
		this.isVisible = false;
	}

	/**
	 * @return בודק האם המכונית זמינה
	 */
	public boolean isVisible(){
		return this.isVisible;
	}
	/**
	 * @return מדפיס את הערכים של המכונית
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return "number "+this.getCarNumber()+" direction "+this.getDirection()+"size:"+this.getSize();

	}
	

}

