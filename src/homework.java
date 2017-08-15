
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class homework extends JButton{
	
	//homework
	
	String name;	
	int X;
	int Y;
	int width = 30;
	int height = 30;

	 public homework()
	 {    
		 super();
		 
		 ImageIcon img = new ImageIcon("image/homework.jpg");
		 setIcon(img);
	 }

	 public void randomplace(){
		 double r1 = Math.random();
		 double r2 = Math.random();
		 X = (int)(r1 * 725f);
		 Y = (int)(r2 * 655f + 50);
		 setBounds(new Rectangle(X,Y,width,height));
	 }
}

