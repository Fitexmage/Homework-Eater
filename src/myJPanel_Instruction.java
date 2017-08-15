
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class myJPanel_Instruction extends JPanel{

	JLabel l_instruction;
	JTextArea ta_instruction;
	
	public myJPanel_Instruction()
	{
		super();
		setBackground(Color.white);
		setLayout(null);
		
		ImageIcon i_instruction = new ImageIcon("image/instruction.jpg");
		l_instruction = new JLabel(i_instruction);
		
		//game instruction here
		
		ta_instruction = new JTextArea("Long long time ago, there was a story of the brute and bloody fighting between \n" +
		"the legendary monster 'HOMEWORK EATER' and PSU Students!!! \n\n" +
		"HOMEWORK EATER is usually appear in libraries and buildings quietly and\n" +
		"sneakly at night. It eats students' homework for living. Its hobby is watching\n" +
		"those poor PSU students who CAN NOT protect their homework and crying in\n" +
		"class since they cannot turn in their homework and will FAIL the classes!\n\n" +
		"HOMEWORK EATER laughs and eats homework as snacks to watch that\n" +
		"scenario happens everyday [Just like how we enjoy PSU football games :)]\n\n" +
		"NOW, YOU GOT THE CHANCE TO BE THE LEGENDARY MONSTER!\n\n" +
		"YOUR JOB is to avoid those student in order to eat as much homework as\n" +
		"POSSIBLE!\n\n" +
		"NOTICE After YOU(homework eater) ate homework greedily, YOU will become\n" +
		"larger and larger. It made you easier to be KILLED by students! Once you are\n" +
		"touched by students, you're dead and GAME OVER.\n\n" +
		"Click 'play', enter your name & age, and choose the option. Then click 'enter' to begin the game! \n" +
		"Use ¡ü¡ý¡û¡ú to play the game.");
		
		add(l_instruction);
		add(ta_instruction);
		ta_instruction.setEditable(false);
		
		l_instruction.setBounds(new Rectangle(250,70,250,50));
		ta_instruction.setBounds(new Rectangle(170,170,600,450));
		}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.setColor(Color.gray);
		g.drawLine(0,650,800,650);
	}
}