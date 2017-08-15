

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class scenario extends JButton{
	
	//character information here
	
	String name;

	 public scenario(String name)
	 {    
		 super();
		 name = name;
		 setBackground(Color.white);
		 setText(name);
		 
		 if(name == "IST"){
		 ImageIcon img = new ImageIcon("image/IST_icon.jpg");
		 setIcon(img);
		 }
		 if(name == "Pattee"){
			 ImageIcon img = new ImageIcon("image/Pattee_icon.jpg");
			 setIcon(img);
			 }
		 if(name == "Hub"){
			 ImageIcon img = new ImageIcon("image/HUB_icon.jpg");
			 setIcon(img);
			 }
		 
	   	 }
	   	 	   	
}
