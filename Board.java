import java.awt.Point;

/**
 * @author shay
 *
 */
public class Board 
{
	private int [][] board;  
	private GameLevel level; 


	/**
	 * @param level1 מספר השלב
	 */
	public Board(int level1) 
	{

		board= new int [6][6];
		level=new GameLevel(level1);
		for(int i=0; i<board.length; i++)
		{
			for(int j=0; j<board.length; j++) 
			{
				this.board[i][j]=0;
			}
		}
	}



	/**
	 * @return מחזיר את לוח המשחק
	 */
	public int[][] getBoard() 
	{
		return this.board;
	}

	/**
	 * @param x מיקום x
	 * @param y מיקום y
	 * @return מחזיר ערך שנמצא במיקום מסוים בלוח המשחק
	 */
	public int getValue(int x,int y)
	{
		if(x<6&&x>-1&&y<6&&y>-1)
		{
			return this.board[x][y];
		}
		return 0;
	}

	/**
	 * @param x מיקום x
	 * @param y מיקום y
	 * @param value משנה ערך שנמצא במיקום מסוים בלוח המשחק
	 */
	public void setValue(int x,int y,int value)
	{
		if(x<6&&x>-1&&y<6&&y>-1)
		{
			this.board[x][y]=value;
		}
	}

	/**
	 * מציב בלוח המשחק את הערכים של המכוניות עפ"י ההצבה ההתחלתית של השלב ובעצם מצייר את השלב
	 */
	public void Boarding() 
	{
		clearBoard();
		for (int i = 1; i < level.getArrCar().length; i++) 
		{
			if (level.getArrCar()[i].isVisible())
			{
				Point [] arr= this.level.allCar(this.level.getArrCar()[i]);
				for (int j = 0; j < arr.length; j++) 
				{

					board[ (int)(arr[j].getX())][(int)(arr[j].getY())]=this.level.getArrCar()[i].getCarNumber();
				}
			}
		}


	}

	/**
	 * מנקה את הלוח, מציב 0 בכל המשבצות בלוח
	 */
	public void clearBoard(){
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board.length; j++)
			{
				board[i][j] = 0;
			}
		}

	}

	/**
	 * @return מחזיר את השלב
	 */
	public GameLevel getLevel() {
		return level;
	}

	/**
	 * @param level עצם מסוג שלב
	 */
	public void setLevel(GameLevel level) {
		this.level = level;
	}

	/**
	 * @param board טבלה של לוח המשחק
	 */
	public void setBoard(int[][] board) {
		this.board = board;
	}


	/**
	 * @param xCar   (לחיצה על העכבר) x של המכונית עליה המשתמש לחץ
	 * @param yCar (לחיצה על העכבר) y של המכונית עליה המשתמש לחץ
	 * @param xMove (עזיבה של העכבר) x של המכונית עליה המשתמש לחץ
	 * @param yMove (עזיבה של העכבר) y של המכונית עליה המשתמש לחץ
	 * @return בודק האם המשתמש יכול להזיז את המכונית, אם כן הוא מבצע תזוזה של המכונית- גם בגרפיקה וגם במספרים שמוצבים על הלוח
	 */
	public boolean direction (int xCar, int yCar, int xMove, int yMove) 
	{
		System.out.println("directionnnnnnnnnnnnnnnnnnnnnnn");
		printboard();
		int rowCar=yCar, colCar=xCar,rowMove=yMove,colMove=xMove;
		boolean f=true;
		try
		{
			System.out.println(board[rowMove][colMove]);
			System.out.println(rowCar+","+colCar+"rmove="+rowMove+"colMove="+colMove);
			int x=board[rowCar][colCar];//car number
			Car c= level.getCar(x);
			System.out.println(c);
			if (c!=null)
			{
				Point [] arr1= new Point[c.getSize()];


				arr1=level.allCar(c);
				for (int i = 0; i < arr1.length; i++) {
					System.out.println(arr1[i]);
				}


				if(c.getDirection()) //לרוחב
				{
					if(colCar<colMove) //הזזה ימינה
					{
						System.out.println("small"+colCar+","+colMove);
						for(int i=colCar+1; i<=colMove &&f; i++) //בודקת אם אין מכוניות בין המקומות אותם אני רוצה להזיז
						{
							System.out.println("iiiii="+i);
							if(board[rowCar][i]!=0)
								f=false;
						}
						System.out.println("f="+f);
						if(f) // אם אין מכוניות בין המקומות אותם אני רוצה להזיז
						{
							for(int i=0; i<arr1.length; i++)
							{
								board[(int)arr1[i].getX()][(int)arr1[i].getY()]=0; //איפסתי את המקומות של המכונית במיקום הנוכחי
							}
							System.out.println("colMove"+colMove+"c.getSize"+c.getSize());
							for (int i = colMove; i>colMove-c.getSize(); i--) //מזיזה את המכונית ימינה
							{
								board[rowCar][i]=c.getCarNumber();
								c.setYPoint(i);
							}

						}
					}
					else
					{
						//הזזה שמאלה
						for(int i=colMove; i<colCar &&f; i++) //בודקת אם אין מכוניות בין המקומות אותם אני רוצה להזיז
						{
							if(board[rowCar][i]!=0)
								f=false;
						}
						System.out.println(f);
						if(f) // אם אין מכוניות בין המקומות אותם אני רוצה להזיז
						{
							for(int i=0; i<arr1.length; i++)
							{
								board[(int)arr1[i].getX()][(int)arr1[i].getY()]=0; //איפסתי את המקומות של המכונית במיקום הנוכחי				
							}
							for (int i = 0; i<c.getSize(); i++)//מזיזה את המכונית שמאלה
							{
								board[rowCar][colMove+i]=c.getCarNumber();
								System.out.println("rowCar"+rowCar);
								System.out.println("colCar"+colCar);
								c.setYPoint(colMove);
							}
						}
					}
				}
				else //לאורך
				{
						if(rowCar<rowMove) //הזזה למטה
						{
							for(int i=rowCar+1; i<=rowMove &&f; i++) //בודקת אם אין מכוניות בין המקומות אותם אני רוצה להזיז
							{
								if(board[i][colCar]!=0)
									f=false;
							}
							if(f) // אם אין מכוניות בין המקומות אותם אני רוצה להזיז
							{
								for(int i=0; i<arr1.length; i++)
								{
									board[(int)arr1[i].getX()][(int)arr1[i].getY()]=0; //איפסתי את המקומות של המכונית במיקום הנוכחי
								}
								for (int i = rowMove; i>rowMove-c.getSize(); i--) //מזיזה את המכונית למטה
								{
									board[i][colCar]=c.getCarNumber();
									c.setXPoint(i);
								}

							}
						}
						else
						{
							//הזזה למעלה
							for(int i=rowMove; i<rowCar &&f; i++) //בודקת אם אין מכוניות בין המקומות אותם אני רוצה להזיז
							{
								if(board[i][colCar]!=0)
									f=false;
							}
							if(f) // אם אין מכוניות בין המקומות אותם אני רוצה להזיז
							{
								for(int i=0; i<arr1.length; i++)
								{
									board[(int)arr1[i].getX()][(int)arr1[i].getY()]=0; //איפסתי את המקומות של המכונית במיקום הנוכחי
								}
								for (int i=0; i<c.getSize();i++)//מזיזה את המכונית למעלה
								{
									board[rowMove+i][colCar]=c.getCarNumber();
									c.setXPoint(rowMove);
								}
							}
						}
					}
				}
		}
		catch (java.lang.ArrayIndexOutOfBoundsException e)
		{
		}


		return true;
	}


	/**
	 * @param x  x מיקום
	 * @param y  y מיקום
	 * @return מחזיר האם התא במיקום שלחץ פנוי
	 */
	public boolean isEmpty (int x, int y)
	{
		if(board[x][y]==0)
		{
			return true;
		}
		return false;
	}

	/**
	 * @return מחזיר true אם ניצח
	 */
	public boolean win ()
	{
		if(board[2][5]==1)
		{
			return true;
		}
		return false;
	}

	/**
	 * מדפיס את הלוח
	 */
	public void printboard()
	{
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}







