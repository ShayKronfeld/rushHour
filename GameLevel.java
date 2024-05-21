import java.awt.Point;

public class GameLevel
{
	protected Car [] arrCar;  
	
	private int levelNumber=1; 



	public GameLevel(int level) 
	{
		this.levelNumber = level;
		buildArr();
	}


	private void buildArr()
	{
		this.arrCar=new Car[11];
		arrCar[1]=new Car(1,2,"red");
		arrCar[2]=new Car(2,2,"pink");
		arrCar[3]=new Car(3,2,"light green");
		arrCar[4]=new Car(4,2,"light blue");
		arrCar[5]=new Car(5,2,"orange");
		arrCar[6]=new Car(6,2,"purple");
		arrCar[7]=new Car(7,3,"green");
		arrCar[8]=new Car(8,3,"blue");
		arrCar[9]=new Car(9,3,"Purple Lilac");
		arrCar[10]=new Car(10,3,"yellow");

		buildCars();


	}

	public void resetVisibility(){
		for (int i = 1; i < arrCar.length;i++)
			arrCar[i].setUnvisible();
	}

	public void buildCars()
	{
		System.out.println("buildCars");
		resetVisibility();
		
		if (levelNumber==1)
		{	
			this.arrCar[1].setDirection(true);
			this.arrCar[1].setXPoint(2);
			this.arrCar[1].setYPoint(1);
			this.arrCar[1].setVisible();

			this.arrCar[3].setDirection(true);
			this.arrCar[3].setXPoint(3);
			this.arrCar[3].setYPoint(1);
			this.arrCar[3].setVisible();

			this.arrCar[9].setDirection(false);
			this.arrCar[9].setXPoint(3);
			this.arrCar[9].setYPoint(5);
			this.arrCar[9].setVisible();

			this.arrCar[5].setDirection(false);
			this.arrCar[5].setXPoint(4);
			this.arrCar[5].setYPoint(1);
			this.arrCar[5].setVisible();

			this.arrCar[4].setDirection(true);
			this.arrCar[4].setXPoint(5);
			this.arrCar[4].setYPoint(2);
			this.arrCar[4].setVisible();

			this.arrCar[10].setDirection(false);
			this.arrCar[10].setXPoint(2);
			this.arrCar[10].setYPoint(3);
			this.arrCar[10].setVisible();


		}
		else
		{
			if (levelNumber==2)
			{
				this.arrCar[1].setDirection(true);
				this.arrCar[1].setXPoint(2);
				this.arrCar[1].setYPoint(1);
				this.arrCar[1].setVisible();
				
				this.arrCar[3].setDirection(false);
				this.arrCar[3].setXPoint(3);
				this.arrCar[3].setYPoint(2);
				this.arrCar[3].setVisible();

				this.arrCar[5].setDirection(false);
				this.arrCar[5].setXPoint(4);
				this.arrCar[5].setYPoint(5);
				this.arrCar[5].setVisible();

				this.arrCar[7].setDirection(true);
				this.arrCar[7].setXPoint(5);
				this.arrCar[7].setYPoint(2);
				this.arrCar[7].setVisible();

				this.arrCar[10].setDirection(false);
				this.arrCar[10].setXPoint(0);
				this.arrCar[10].setYPoint(0);
				this.arrCar[10].setVisible();

				this.arrCar[9].setDirection(false);
				this.arrCar[9].setXPoint(0);
				this.arrCar[9].setYPoint(3);
				this.arrCar[9].setVisible();

				this.arrCar[8].setDirection(true);
				this.arrCar[8].setXPoint(3);
				this.arrCar[8].setYPoint(3);
				this.arrCar[8].setVisible();

			}

			else
			{
				if (levelNumber==3)
				{
					this.arrCar[1].setDirection(true);
					this.arrCar[1].setXPoint(2);
					this.arrCar[1].setYPoint(1);
					this.arrCar[1].setVisible();
					
					this.arrCar[10].setDirection(false);
					this.arrCar[10].setXPoint(0);
					this.arrCar[10].setYPoint(0);
					this.arrCar[10].setVisible();
					
					this.arrCar[9].setDirection(false);
					this.arrCar[9].setXPoint(0);
					this.arrCar[9].setYPoint(3);
					this.arrCar[9].setVisible();
					
					this.arrCar[3].setDirection(false);
					this.arrCar[3].setXPoint(0);
					this.arrCar[3].setYPoint(1);
					this.arrCar[3].setVisible();
					
					this.arrCar[7].setDirection(true);
					this.arrCar[7].setXPoint(5);
					this.arrCar[7].setYPoint(2);
					this.arrCar[7].setVisible();
					
					this.arrCar[8].setDirection(true);
					this.arrCar[8].setXPoint(3);
					this.arrCar[8].setYPoint(3);
					this.arrCar[8].setVisible();
					
					this.arrCar[5].setDirection(false);
					this.arrCar[5].setXPoint(4);
					this.arrCar[5].setYPoint(5);
					this.arrCar[5].setVisible();
				}
				
				

				else
				{
					if(levelNumber==4)
					{
						this.arrCar[1].setDirection(true);
						this.arrCar[1].setXPoint(2);
						this.arrCar[1].setYPoint(0);
						this.arrCar[1].setVisible();

						this.arrCar[10].setDirection(false);
						this.arrCar[10].setXPoint(0);
						this.arrCar[10].setYPoint(5);
						this.arrCar[10].setVisible();
						
						this.arrCar[3].setDirection(false);
						this.arrCar[3].setXPoint(0);
						this.arrCar[3].setYPoint(0);
						this.arrCar[3].setVisible();
						
						this.arrCar[9].setDirection(false);
						this.arrCar[9].setXPoint(1);
						this.arrCar[9].setYPoint(2);
						this.arrCar[9].setVisible();
						
						this.arrCar[5].setDirection(true);
						this.arrCar[5].setXPoint(0);
						this.arrCar[5].setYPoint(1);
						this.arrCar[5].setVisible();
						
						this.arrCar[8].setDirection(true);
						this.arrCar[8].setXPoint(3);
						this.arrCar[8].setYPoint(3);
						this.arrCar[8].setVisible();
						
						this.arrCar[7].setDirection(true);
						this.arrCar[7].setXPoint(5);
						this.arrCar[7].setYPoint(0);
						this.arrCar[7].setVisible();
						
						this.arrCar[6].setDirection(false);
						this.arrCar[6].setXPoint(4);
						this.arrCar[6].setYPoint(4);
						this.arrCar[6].setVisible();
						}
					else
					{
						if(levelNumber==5)
						{
							this.arrCar[1].setDirection(true);
							this.arrCar[1].setXPoint(2);
							this.arrCar[1].setYPoint(1);
							this.arrCar[1].setVisible();

							this.arrCar[10].setDirection(false);
							this.arrCar[10].setXPoint(0);
							this.arrCar[10].setYPoint(3);
							this.arrCar[10].setVisible();
							
							this.arrCar[3].setDirection(true);
							this.arrCar[3].setXPoint(0);
							this.arrCar[3].setYPoint(0);
							this.arrCar[3].setVisible();
							
							this.arrCar[5].setDirection(false);
							this.arrCar[5].setXPoint(0);
							this.arrCar[5].setYPoint(2);
							this.arrCar[5].setVisible();
							
							this.arrCar[9].setDirection(false);
							this.arrCar[9].setXPoint(2);
							this.arrCar[9].setYPoint(0);
							this.arrCar[9].setVisible();
							
							this.arrCar[2].setDirection(true);
							this.arrCar[2].setXPoint(4);
							this.arrCar[2].setYPoint(1);
							this.arrCar[2].setVisible();
							
							this.arrCar[6].setDirection(true);
							this.arrCar[6].setXPoint(5);
							this.arrCar[6].setYPoint(0);
							this.arrCar[6].setVisible();
							

							this.arrCar[8].setDirection(true);
							this.arrCar[8].setXPoint(3);
							this.arrCar[8].setYPoint(1);
							this.arrCar[8].setVisible();
							

							this.arrCar[4].setDirection(true);
							this.arrCar[4].setXPoint(1);
							this.arrCar[4].setYPoint(0);
							this.arrCar[4].setVisible();
						}
						else
						{
							if(levelNumber==6)
							{

								this.arrCar[1].setDirection(true);
								this.arrCar[1].setXPoint(2);
								this.arrCar[1].setYPoint(1);
								this.arrCar[1].setVisible();

								this.arrCar[10].setDirection(false);
								this.arrCar[10].setXPoint(0);
								this.arrCar[10].setYPoint(3);
								this.arrCar[10].setVisible();

								this.arrCar[3].setDirection(true);
								this.arrCar[3].setXPoint(0);
								this.arrCar[3].setYPoint(0);
								this.arrCar[3].setVisible();

								this.arrCar[9].setDirection(false);
								this.arrCar[9].setXPoint(1);
								this.arrCar[9].setYPoint(0);
								this.arrCar[9].setVisible();

								this.arrCar[5].setDirection(false);
								this.arrCar[5].setXPoint(0);
								this.arrCar[5].setYPoint(2);
								this.arrCar[5].setVisible();

								this.arrCar[8].setDirection(true);
								this.arrCar[8].setXPoint(5);
								this.arrCar[8].setYPoint(3);
								this.arrCar[8].setVisible();
								
								this.arrCar[7].setDirection(true);
								this.arrCar[7].setXPoint(3);
								this.arrCar[7].setYPoint(1);
								this.arrCar[7].setVisible();
							}
						}
					}
				}
			}
		}

	}
	


	public Car getCar(int x)
	{
		return this.arrCar[x];
	}


	public Car[] getArrCar()
	{
		return this.arrCar;
	}

	public void setLevelNumber() 
	{
		this.levelNumber++;
	}

	public void resetLevelNumber() 
	{
		this.levelNumber=1;
	}
	
	public Point []allCar(Car c) 
	{
		int x=c.getXPoint() ,y=c.getYPoint();
		Point [] arr= new Point[c.getSize()];
		arr[0]=new Point(x,y);
		for(int i=1; i<arr.length; i++)
		{
			if(c.getDirection())
			{
				y++;
				x=c.getXPoint();
				arr[i]=new Point(x,y);
			}
			else 
			{
				y=c.getYPoint();
				x++;
				arr[i]=new Point(x,y);
			}	
		}


		return arr; 
	}


	public void setArrCar(Car[] arrCar)
	{
		System.out.println("setarr");
		this.arrCar = arrCar;
	}

	public int getLevel()
	{
		return this.levelNumber;
	}

	public void setLevel(int level)
	{
		this.levelNumber = level;
	}


	public int getLevelNumber()
	{
		return this.levelNumber;
	}


}
