
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class myJPanel_Menu extends JPanel{

	JButton b_play;
	JLabel l_logo = new JLabel();
	
	public myJPanel_Menu()
	{
		super();
		setBackground(Color.white);
		setLayout(null);
		
		//2 image, a logo and a play button
		
		ImageIcon i_logo = new ImageIcon("image/logo.jpg");
		ImageIcon i_play = new ImageIcon("image/play.jpg");
		
		b_play = new JButton(i_play);
		l_logo.setIcon(i_logo);
		
		add(l_logo);
		add(b_play);
		
		l_logo.setBounds(new Rectangle(100,50,600,300));
		b_play.setBounds(new Rectangle(165,380,450,200));
		
		}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.setColor(Color.gray);
		g.drawLine(0,650,800,650);
	}

}
