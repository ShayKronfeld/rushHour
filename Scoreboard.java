import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author shay
 *
 */

public class Scoreboard  implements ActionListener  {

	JFrame f=new JFrame();
	JLabel [] arr=new JLabel[22];
	JButton nextLevel=new JButton("Continue playing");

	ImageIcon icon = new ImageIcon("panelTree.jpg");//center
	Image img1 = icon.getImage();  
	BackgroundPanel p=new BackgroundPanel(img1);
	Image img  =Toolkit.getDefaultToolkit().createImage("panelTree.jpg");

	ImageIcon icon1 = new ImageIcon("panelTree.jpg");
	Image img2 = icon.getImage();  
	BackgroundPanel p3=new BackgroundPanel(img1);//south
	Image img3  =Toolkit.getDefaultToolkit().createImage("panelTree.jpg");



	/**
	 * @param s
	 */
	Scoreboard(String s)
	{       
		JLabel l=null;
		nextLevel.addActionListener(this);

		nextLevel.setOpaque(false);
		nextLevel.setContentAreaFilled(false);
		nextLevel.setBorderPainted(false);

		p.setLayout(new BorderLayout());
		String[] sarr=s.split("_");
		System.out.println(sarr.length+"sarr.lenght");
		p.setLayout(new GridLayout(sarr.length+1,3));  
		JLabel l1=new JLabel("שם");
		l1.setFont(new Font("TimesRoman", Font.BOLD, 20));
		JLabel l2=new JLabel("שלב");
		l2.setFont(new Font("TimesRoman", Font.BOLD, 20));
		JLabel l3=new JLabel("ניקוד");
		l3.setFont(new Font("TimesRoman", Font.BOLD, 20));
		p.add(l1);
		p.add(l2);
		p.add(l3);


		for (int i = 0; i < sarr.length; i++) {
			String []st=sarr[i].split(",");
			for (int j = 0; j < st.length; j++) {
				l=new JLabel(st[j]);
				p.add(l);
			}

		}

		p3.add(nextLevel);
		f.add(p,BorderLayout.SOUTH);
		f.add(p3,BorderLayout.CENTER);
		f.setSize(528,587);
		f.setVisible(true);  
	}



	/**
	 * @param e אירוע לחיצה על כפתור
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==nextLevel)
		{
			System.out.println("הגעתייייייייי");
			f.dispose();
		}
	}}