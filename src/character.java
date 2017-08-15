
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class character extends JButton{
	
	//character information here
	
	String name;

	 public character(String name)
	 {    
		 super();
		 name = name;
		 setBackground(Color.white);
		 setText(name);
		 
		 if(name == "Bill"){
		 ImageIcon img = new ImageIcon("image/bill/Bill_icon.jpg");
		 setIcon(img);
		 }
		 if(name == "Cindy"){
			 ImageIcon img = new ImageIcon("image/cindy/Cindy_icon.jpg");
			 setIcon(img);
		}
		 if(name == "Jason"){
			 ImageIcon img = new ImageIcon("image/jason/Jason_icon.jpg");
			 setIcon(img);
		}
		 
	   	 }
	   	 
	   	
}
