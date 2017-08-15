
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class myJPanel_Toolbar extends JPanel{
	
	JButton b_menu;
	JButton b_instruction;
	JButton b_designer;
	
	public myJPanel_Toolbar()
	{
		super();
		setBackground(Color.white);
		setLayout(null);
		
		//3 button in toolbar for menu, instruction, and designer
		
		b_menu = new JButton("Menu");
		b_instruction = new JButton("Instruction");
		b_designer = new JButton("Designer");
		
		add(b_menu);
		add(b_instruction);
		add(b_designer);
		
		b_menu.setBounds(new Rectangle(190,30,100,30));
		b_instruction.setBounds(new Rectangle(340,30,100,30));
		b_designer.setBounds(new Rectangle(490,30,100,30));
		}
}
