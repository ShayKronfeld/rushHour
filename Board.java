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
	 * @param level1 ���� ����
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
	 * @return ����� �� ��� �����
	 */
	public int[][] getBoard() 
	{
		return this.board;
	}

	/**
	 * @param x ����� x
	 * @param y ����� y
	 * @return ����� ��� ����� ������ ����� ���� �����
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
	 * @param x ����� x
	 * @param y ����� y
	 * @param value ���� ��� ����� ������ ����� ���� �����
	 */
	public void setValue(int x,int y,int value)
	{
		if(x<6&&x>-1&&y<6&&y>-1)
		{
			this.board[x][y]=value;
		}
	}

	/**
	 * ���� ���� ����� �� ������ �� �������� ��"� ����� �������� �� ���� ����� ����� �� ����
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
	 * ���� �� ����, ���� 0 ��� ������� ����
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
	 * @return ����� �� ����
	 */
	public GameLevel getLevel() {
		return level;
	}

	/**
	 * @param level ��� ���� ���
	 */
	public void setLevel(GameLevel level) {
		this.level = level;
	}

	/**
	 * @param board ���� �� ��� �����
	 */
	public void setBoard(int[][] board) {
		this.board = board;
	}


	/**
	 * @param xCar   (����� �� �����) x �� ������� ���� ������ ���
	 * @param yCar (����� �� �����) y �� ������� ���� ������ ���
	 * @param xMove (����� �� �����) x �� ������� ���� ������ ���
	 * @param yMove (����� �� �����) y �� ������� ���� ������ ���
	 * @return ���� ��� ������ ���� ����� �� �������, �� �� ��� ���� ����� �� �������- �� ������� ��� ������� ������� �� ����
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


				if(c.getDirection()) //�����
				{
					if(colCar<colMove) //���� �����
					{
						System.out.println("small"+colCar+","+colMove);
						for(int i=colCar+1; i<=colMove &&f; i++) //����� �� ��� ������� ��� ������� ���� ��� ���� �����
						{
							System.out.println("iiiii="+i);
							if(board[rowCar][i]!=0)
								f=false;
						}
						System.out.println("f="+f);
						if(f) // �� ��� ������� ��� ������� ���� ��� ���� �����
						{
							for(int i=0; i<arr1.length; i++)
							{
								board[(int)arr1[i].getX()][(int)arr1[i].getY()]=0; //������ �� ������� �� ������� ������ ������
							}
							System.out.println("colMove"+colMove+"c.getSize"+c.getSize());
							for (int i = colMove; i>colMove-c.getSize(); i--) //����� �� ������� �����
							{
								board[rowCar][i]=c.getCarNumber();
								c.setYPoint(i);
							}

						}
					}
					else
					{
						//���� �����
						for(int i=colMove; i<colCar &&f; i++) //����� �� ��� ������� ��� ������� ���� ��� ���� �����
						{
							if(board[rowCar][i]!=0)
								f=false;
						}
						System.out.println(f);
						if(f) // �� ��� ������� ��� ������� ���� ��� ���� �����
						{
							for(int i=0; i<arr1.length; i++)
							{
								board[(int)arr1[i].getX()][(int)arr1[i].getY()]=0; //������ �� ������� �� ������� ������ ������				
							}
							for (int i = 0; i<c.getSize(); i++)//����� �� ������� �����
							{
								board[rowCar][colMove+i]=c.getCarNumber();
								System.out.println("rowCar"+rowCar);
								System.out.println("colCar"+colCar);
								c.setYPoint(colMove);
							}
						}
					}
				}
				else //�����
				{
						if(rowCar<rowMove) //���� ����
						{
							for(int i=rowCar+1; i<=rowMove &&f; i++) //����� �� ��� ������� ��� ������� ���� ��� ���� �����
							{
								if(board[i][colCar]!=0)
									f=false;
							}
							if(f) // �� ��� ������� ��� ������� ���� ��� ���� �����
							{
								for(int i=0; i<arr1.length; i++)
								{
									board[(int)arr1[i].getX()][(int)arr1[i].getY()]=0; //������ �� ������� �� ������� ������ ������
								}
								for (int i = rowMove; i>rowMove-c.getSize(); i--) //����� �� ������� ����
								{
									board[i][colCar]=c.getCarNumber();
									c.setXPoint(i);
								}

							}
						}
						else
						{
							//���� �����
							for(int i=rowMove; i<rowCar &&f; i++) //����� �� ��� ������� ��� ������� ���� ��� ���� �����
							{
								if(board[i][colCar]!=0)
									f=false;
							}
							if(f) // �� ��� ������� ��� ������� ���� ��� ���� �����
							{
								for(int i=0; i<arr1.length; i++)
								{
									board[(int)arr1[i].getX()][(int)arr1[i].getY()]=0; //������ �� ������� �� ������� ������ ������
								}
								for (int i=0; i<c.getSize();i++)//����� �� ������� �����
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
	 * @param x  x �����
	 * @param y  y �����
	 * @return ����� ��� ��� ������ ���� ����
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
	 * @return ����� true �� ����
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
	 * ����� �� ����
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







