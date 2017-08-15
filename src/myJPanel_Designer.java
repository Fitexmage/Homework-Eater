
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class myJPanel_Designer extends JPanel{
	
	JLabel l_designer;
	JTextArea ta_designer;
	
	public myJPanel_Designer()
	{
		super();
		setBackground(Color.white);
		setLayout(null);
		
		ImageIcon i_designer = new ImageIcon("image/designer.jpg");
		l_designer = new JLabel(i_designer);
		
		//designer information here
		
		ta_designer = new JTextArea("Shengguang Bai \n" +
				"IST & Math Undergraduate Student 18' \n" +
				"smb6402@psu.edu \n" +
				"814-321-8681 \n\n" +
				"Junyuan Li \n" +
				"IST Undergraduate Student 18' \n" +
				"jjl5555@psu.edu \n" +
				"814-880-5763 \n\n\n" +
				"Contact us if you have more ideas and advice!");
		
		add(l_designer);
		add(ta_designer);
		ta_designer.setEditable(false);
		
		l_designer.setBounds(new Rectangle(250,70,250,50));
		ta_designer.setBounds(new Rectangle(270,200,500,400));
		}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.setColor(Color.gray);
		g.drawLine(0,650,800,650);
	}
}
