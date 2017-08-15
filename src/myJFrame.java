
import java.awt.*;
import javax.swing.*;

public class myJFrame extends JFrame
{
	public myJFrame ()
	{
		super ("Homework Eater");
		
  	 	myJPanel mjp = new myJPanel();
    
		getContentPane().add(mjp,"Center");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize (800, 800);
		setVisible(true);
	}
}