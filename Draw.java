import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;



public class Draw extends JPanel implements ActionListener,MouseMotionListener, MouseListener
{
	Client client;

	JButton[][] bArr=new JButton[6][6];
	boolean flag= false; 
	int count=0;// מספר הזזות
	String name1;
	int levels=1;
	Board board=new Board(levels);
	JFrame f=new JFrame();

	JPanel p1=new JPanel();// panel 3 button
	JPanel p2=new JPanel();//panel all button

	Image img;
	JLabel l2=new JLabel();
	JButton bReset=new JButton();
	JButton bNewGame=new JButton();
	JButton bHighScores=new JButton();
	JLabel l1=new JLabel();


	int xCar=0, yCar=0, xMove=0, yMove=0;


	public Draw()
	{
		name1 = JOptionPane.showInputDialog("Enter your name: "); 
		System.out.println(name1);

		p2.setLayout(new GridLayout(6,6,20,20)); 
		p2.addMouseMotionListener(this);
		p2.addMouseListener(this);

		this.setLayout(null);

		p2.setBounds(55,70, 415, 420);
		p2.setOpaque(false);

		bReset.addActionListener(this);
		bNewGame.addActionListener(this);
		bHighScores.addActionListener(this);

		this.add(p2);
		this.add(bReset);
		this.add(bNewGame);
		this.add(bHighScores);

		bReset.setBounds(165,510, 40, 40);
		bNewGame.setBounds(215,510, 90, 40);
		bHighScores.setBounds(320,510, 40, 40);

		Image img3=f.getToolkit().getImage("newGame.PNG");
		img3=img3.getScaledInstance(90,60,Image.SCALE_DEFAULT);
		Icon icon3=new ImageIcon(img3);
		bNewGame.setIcon(icon3);

		Image img1=f.getToolkit().getImage("reset.png");
		img1=img1.getScaledInstance(40,40,Image.SCALE_DEFAULT);
		Icon icon1=new ImageIcon(img1);
		bReset.setIcon(icon1);


		Image img2=f.getToolkit().getImage("highScores.png");
		img2=img2.getScaledInstance(40,40,Image.SCALE_DEFAULT);
		Icon icon2=new ImageIcon(img2);
		bHighScores.setIcon(icon2);

		bReset.setFocusable(false);
		bNewGame.setFocusable(false);
		bHighScores.setFocusable(false);


		f.setResizable(false);
		f.add(this);

		f.setSize(528,587);

		f.setVisible(true);
		f.add(this);
		board.Boarding();

		client = new Client(this);
		//}
	}



	public void rotate(Graphics g,int drawLocationX,int drawLocationY,BufferedImage img, int size)
	{

		double rotationRequired = Math.toRadians (90);
		int locationX =70;
		int locationY =70;
		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

		if(size==3)
		{
			g.drawImage(op.filter((BufferedImage) img, null), drawLocationX, drawLocationY, 210,62,null);
		}
		else 
			g.drawImage(op.filter((BufferedImage) img, null), drawLocationX, drawLocationY, 140,62,null);


	}


	public void paintComponent(Graphics gr)
	{
		super.paintComponent(gr);

		boolean flag= false;
		int x=55;
		int y=75;
		ImageIcon icon;
		Image img=new ImageIcon("board with logo.png").getImage();
		gr.drawImage(img, 0,0,f.getWidth(),f.getHeight(), null);

		for (int i = 0; i < board.getLevel().getArrCar().length; i++) 
		{
			if(board.getLevel().getArrCar()[i]!=null)
			{
				if(board.getLevel().getArrCar()[i].isVisible())
				{
					if(!board.getLevel().getArrCar()[i].getDirection())
					{

						y=77+board.getLevel().getArrCar()[i].getXPoint()*(71);
						x=53+board.getLevel().getArrCar()[i].getYPoint()*(71);

						icon = new ImageIcon(board.getLevel().getArrCar()[i].getImage()+".PNG");

						Image imge = icon.getImage();
						putImage(board.getLevel().getArrCar()[i].getImage());
						gr.drawImage(imge, x,y, null);

					}
					else  
					{
						y=75+board.getLevel().getArrCar()[i].getXPoint()*(71);
						x=41+board.getLevel().getArrCar()[i].getYPoint()*(71);
						int size=board.getLevel().getArrCar()[i].getSize();
						BufferedImage img1;
						try {
							img1 = ImageIO.read(new File(board.getLevel().getArrCar()[i].getImage()+".PNG"));
							rotate(gr,x,y,img1,size);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			}
		}		
	}



	private Icon putImage(String img)
	{
		Image img1=f.getToolkit().getImage(img);
		img1=img1.getScaledInstance(60,60,Image.SCALE_DEFAULT);
		Icon icon1=new ImageIcon(img1);
		return icon1;

	}

	public void actionPerformed(ActionEvent e) 
	{
		String color;
		int x,y;
		int numLevel;
		ImageIcon icon;
		JButton b1=(JButton)e.getSource();
		if(b1==bReset)
		{
			count=0;
			board.getLevel().buildCars();
			board.Boarding();
			repaint();

		}
		else
		{
			if(b1==bNewGame)
			{
				count=0;
				board.getLevel().resetLevelNumber();
				board.getLevel().buildCars();
				board.Boarding();
				repaint();
			}
			else
			{
				if(b1==bHighScores)//הצגת טבלת שיאים
				{
					System.out.println("giv");
					client.sendMessage("giv");

				}
				else
				{

					for (int i = 0;  i< bArr.length; i++)

					{
						for (int j = 0; j < bArr.length; j++) 
						{
							if(b1==bArr[i][j]) 
							{
								count++;
								if(count%2==1) 
								{
									xCar=i;
									yCar=j;

								}
								else 
								{
									xMove=i;
									yMove=j;
									board.direction(yCar,xCar,yMove,xMove);
									board.printboard();
									repaint();

									if(board.win()) 
									{
										client.sendMessage(name1+","+board.getLevel().getLevel()+","+count+","+"save"+";");

										board.getLevel().setLevelNumber();
										board.getLevel().buildCars();
										board.Boarding();
										repaint();
									}
								}
							}
						}

					}
				}

			}
		}
	}



	//TODO check if this works




	public static void main(String[] args)
	{
		Draw m=new Draw();
	}


	private void move()
	{

		// TODO Auto-generated method stub
		board.direction(yCar,xCar,yMove,xMove);
		board.printboard();
		repaint();

		if(board.win()&& board.getLevel().getLevelNumber()==6) 
		{
			JOptionPane.showMessageDialog(null, "!סיימת את כל השלבים בהצלחה, כל הכבוד");
		}
		else
			if(board.win())
			{
				client.sendMessage("save,"+name1+","+board.getLevel().getLevel()+","+count);

				board.getLevel().setLevelNumber();
				board.getLevel().buildCars();
				board.Boarding();
				repaint();
			}

	}

	public void mouseDragged(MouseEvent e) {



	}

	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseClicked(MouseEvent e) {

		// TODO Auto-generated method stub

	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		count++;
		yCar=e.getX()/71;
		xCar=e.getY()/71;
		System.out.println(yCar+"yCar" +xCar+"xCar" );
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		yMove=e.getX()/71;
		xMove=e.getY()/71;
		System.out.println(yMove+"yMove" +xMove+"xMove" );
		move();

	}
	public void showMessage (String message)
	{

		System.out.println("msg"+message);
		Scoreboard highScore= new Scoreboard(message);

	}

}
