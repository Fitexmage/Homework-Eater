
import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class myJPanel_Input extends JPanel implements ActionListener, ChangeListener{

	//information needed to input
	
	character ca, cb, cc;
	scenario s_ist, s_pattee, s_hub;

	JLabel l_name,l_age,l_number, l_character, l_scenario, l_info, l_option;
	JTextField tf_inputname = new JTextField("New Name");
	JButton b_enter;
	JSlider js_age, js_number;
	String name = "New Name";
	int age = 0;
	String character = "Bill";
	String scenario = "IST";
	int number = 2;
	
	public myJPanel_Input()
	{
		super();
		setBackground(Color.white);
		setLayout(null);

		l_name = new JLabel("Your name:");
		l_age = new JLabel("Your age: 0");
		
		l_number = new JLabel("Number of student: 2");
		l_character = new JLabel("Homework Eater: Bill");
		l_scenario = new JLabel("Scenario: IST");
		b_enter = new JButton("Enter");
		
		ImageIcon i_info = new ImageIcon("image/info.jpg");
		ImageIcon i_option = new ImageIcon("image/option.jpg");
		l_info = new JLabel(i_info);
		l_option = new JLabel(i_option);
		
		js_age = new JSlider(JSlider.HORIZONTAL, 0, 200, 0);
		js_age.setMajorTickSpacing(40);
		js_age.setMinorTickSpacing(10);
		js_age.setPaintTicks(true);
		js_age.setPaintLabels(true);
		
		js_number = new JSlider(JSlider.HORIZONTAL, 2, 4, 2);
		js_number.setMajorTickSpacing(1);
		js_number.setMinorTickSpacing(1);
		js_number.setPaintTicks(true);
		js_number.setPaintLabels(true);
		
		ca = new character("Bill");
		cb = new character("Cindy");
		cc = new character("Jason");
		s_ist = new scenario("IST");
		s_pattee = new scenario("Pattee");
		s_hub = new scenario("Hub");
		
		js_age.addChangeListener(this);
		ca.addActionListener(this);
		cb.addActionListener(this);
		cc.addActionListener(this);
		s_ist.addActionListener(this);
		s_pattee.addActionListener(this);
		s_hub.addActionListener(this);
		js_number.addChangeListener(this);
		
		add(l_info);
		add(l_name);
		add(tf_inputname);
		add(l_age);
		add(js_age);

		add(l_option);
		add(l_number);
		add(js_number);
		add(l_character);
		add(ca);
		add(cb);
		add(cc);
		add(l_scenario);
		add(s_ist);
		add(s_pattee);
		add(s_hub);
		add(b_enter);
		
		//info
		
		l_info.setBounds(new Rectangle(200,30,400,60));
		
		//name
		
		l_name.setBounds(new Rectangle(110,130,200,20));
		tf_inputname.setBounds(new Rectangle(260,130,150,20));
		
		//age
		
		l_age.setBounds(new Rectangle(110,200,200,20));
		js_age.setBounds(new Rectangle(260,190,200,50));
		
		//option
		
		l_option.setBounds(new Rectangle(200,290,400,60));
		
		//number
		
		l_number.setBounds(new Rectangle(110,380,200,20));
		js_number.setBounds(new Rectangle(260,370,200,50));
		
		//character
		
		l_character.setBounds(new Rectangle(110,490,200,20));
		ca.setBounds(new Rectangle(260,450,150,90));
		cb.setBounds(new Rectangle(420,450,150,90));
		cc.setBounds(new Rectangle(580,450,150,90));
		
		//scenario
		
		l_scenario.setBounds(new Rectangle(110,600,100,30));
		s_ist.setBounds(new Rectangle(210,580,180,80));
		s_pattee.setBounds(new Rectangle(390,580,200,80));
		s_hub.setBounds(new Rectangle(590,580,180,80));
		
		//enter
		
		b_enter.setBounds(new Rectangle(340,715,100,30));
		
		}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.setColor(Color.gray);
		g.drawLine(0,270,800,270);
		g.drawLine(0,700,800,700);
	}

	public void stateChanged(ChangeEvent event){
	   	 
		//show and get the age players input
		
    	if(event.getSource() == js_age){
         	l_age.setText("Your age: " + js_age.getValue());
         	age = js_age.getValue();
    	}
    	
    	//show and get the number of students
    	
    	if(event.getSource() == js_number){
			l_number.setText("Number of student: " + js_number.getValue());
			number = js_number.getValue();
		}
	}
	
	public void actionPerformed(ActionEvent event) {
	   	 
		//when click Bill
		
		if(event.getSource() == ca){
			l_character.setText("Homework Eater: Bill");
			character = "Bill";
		}
		
		//when click Cindy
		
		if(event.getSource() == cb){
			l_character.setText("Homework Eater: Cindy");
			character = "Cindy";
		}

		//when click Jason
		
		if(event.getSource() == cc){
			l_character.setText("Homework Eater: Jason");
			character = "Jason";
		}
		
		//when click IST
		
		if(event.getSource() == s_ist){
			l_scenario.setText("Scenario: IST");
			scenario = "IST";
		}
		
		//when click Pattee
		
		if(event.getSource() == s_pattee){
			l_scenario.setText("Scenario: Pattee");
			scenario = "Pattee";
		}

		//when click HUB
		
		if(event.getSource() == s_hub){
			l_scenario.setText("Scenario: HUB");
			scenario = "HUB";
		}
	}
}
