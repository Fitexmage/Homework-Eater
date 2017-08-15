
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class student extends JButton{
	
	//student
	
	String name;
	int X;
	int Y;
	int width = 50;
	int height = 50;

	 public student(int X, int Y)
	 {    
		 super();
		 this.X = X;
		 this.Y = Y;
		 
		 ImageIcon i_student = new ImageIcon("image/student.jpg");
		 setIcon(i_student);
	 }
	 
	 public void studentlimit(){
	    	
	    	//set limit for student
	    	
	    	if(X<0){
				X = 0;
			}
			if(X>735){
				X = 735;
			}
			if(Y<50){
				Y = 50;
			}
			if(Y>715){
				Y = 715;
			}
	    }
}
