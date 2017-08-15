
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class myJPanel_Gameover extends JPanel implements ActionListener{

	//panel after game
	
	String name;
	int age;
	String character;
	String scenario;
	int number;
	int score;
	boolean restart = false;
	java.applet.AudioClip clip_gameover;
	
	String h_name_2, h_character_2, h_scenario_2;
	int h_age_2, h_number_2, h_score_2;
	String h_name_3, h_character_3, h_scenario_3;
	int h_age_3, h_number_3, h_score_3;
	String h_name_4, h_character_4, h_scenario_4;
	int h_age_4, h_number_4, h_score_4;
	player pl, pl_highest_2, pl_highest_3, pl_highest_4;
	
	String name_last1_2, name_last2_2, name_last3_2, name_last4_2, name_last5_2, name_last1_3, name_last2_3, name_last3_3, name_last4_3, name_last5_3, name_last1_4, name_last2_4, name_last3_4, name_last4_4, name_last5_4;
	int score_last1_2, score_last2_2, score_last3_2, score_last4_2, score_last5_2, score_last1_3, score_last2_3, score_last3_3, score_last4_3, score_last5_3, score_last1_4, score_last2_4, score_last3_4, score_last4_4, score_last5_4;
	
	XML_240 x_highest, x_lastfive;
	JLabel l_gameover, l_yourscore, l_students, l_highestscore, l_lastfivescore;
	JTextArea ta_yourscore, ta_highestscore, ta_lastfivescore;
	JButton b_2students, b_3students, b_4students, b_restart;
		
	public myJPanel_Gameover(String name, int age, int number, String character, String scenario, int score){
		
		super();
		setBackground(Color.white);
		setLayout(null);

	   	this.name = name;
	    this.age = age;
	   	this.number = number;
	   	this.character = character;
	   	this.scenario = scenario;
	   	this.score = score;
	   	
		try{
			clip_gameover = java.applet.Applet.newAudioClip(new java.net.URL("file:sound/gameover.wav"));
		}
		catch(Exception e) {e.printStackTrace();}
		
		clip_gameover.play();
		
	   	x_highest = new XML_240();
	   	x_lastfive = new XML_240();
	   	pl = new player(name, age, number, character, scenario, score);
	   	
	   	/*for highest score initializing
	   	 * 
	   	pl_highest_2 = new player("New Name", 0, 2, "Bill", "IST", 0);
        pl_highest_3 = new player("New Name", 0, 3, "Bill", "IST", 0);
        pl_highest_4 = new player("New Name", 0, 4, "Bill", "IST", 0);
	   	*/
	   	
	   	/*for last five score initializing
	   	 * 
	   	name_last1_2 = "New Name";
	   	name_last2_2 = "New Name";
	   	name_last3_2 = "New Name";
	   	name_last4_2 = "New Name";
	   	name_last5_2 = "New Name";
	   	name_last1_3 = "New Name";
	   	name_last2_3 = "New Name";
	   	name_last3_3 = "New Name";
	   	name_last4_3 = "New Name";
	   	name_last5_3 = "New Name";
	   	name_last1_4 = "New Name";
	   	name_last2_4 = "New Name";
	   	name_last3_4 = "New Name";
	   	name_last4_4 = "New Name";
	   	name_last5_4 = "New Name";
	   	
	   	score_last1_2 = 0;
	   	score_last2_2 = 0;
	   	score_last3_2 = 0;
	   	score_last4_2 = 0;
	   	score_last5_2 = 0;
	   	score_last1_3 = 0;
	   	score_last2_3 = 0;
	   	score_last3_3 = 0;
	   	score_last4_3 = 0;
	   	score_last5_3 = 0;
	   	score_last1_4 = 0;
	   	score_last2_4 = 0;
	   	score_last3_4 = 0;
	   	score_last4_4 = 0;
	   	score_last5_4 = 0;
	   	*/
	   	
	   	//read highest score from XML
	   	
	   	x_highest.openReaderXML("highest_2.xml");
        h_name_2 = (String)x_highest.ReadObject();
        h_age_2 = (Integer)x_highest.ReadObject();
        h_number_2 = (Integer)x_highest.ReadObject();
        h_character_2 = (String)x_highest.ReadObject();
        h_scenario_2 = (String)x_highest.ReadObject();
        h_score_2 = (Integer)x_highest.ReadObject();
        x_highest.closeReaderXML();
        
        x_highest.openReaderXML("highest_3.xml");
        h_name_3 = (String)x_highest.ReadObject();
        h_age_3 = (Integer)x_highest.ReadObject();
        h_number_3 = (Integer)x_highest.ReadObject();
        h_character_3 = (String)x_highest.ReadObject();
        h_scenario_3 = (String)x_highest.ReadObject();
        h_score_3 = (Integer)x_highest.ReadObject();
        x_highest.closeReaderXML();
        
        x_highest.openReaderXML("highest_4.xml");
        h_name_4 = (String)x_highest.ReadObject();
        h_age_4 = (Integer)x_highest.ReadObject();
        h_number_4 = (Integer)x_highest.ReadObject();
        h_character_4 = (String)x_highest.ReadObject();
        h_scenario_4 = (String)x_highest.ReadObject();
        h_score_4 = (Integer)x_highest.ReadObject();
        x_highest.closeReaderXML();
        
        pl_highest_2 = new player(h_name_2, h_age_2, h_number_2, h_character_2, h_scenario_2, h_score_2);
        pl_highest_3 = new player(h_name_3, h_age_3, h_number_3, h_character_3, h_scenario_3, h_score_3);
        pl_highest_4 = new player(h_name_4, h_age_4, h_number_4, h_character_4, h_scenario_4, h_score_4);
        
        //write highest score to XML
        
        if(number == 2){
        	pl_highest_2 = getHighest(pl, pl_highest_2);
        	x_highest.openWriterXML("highest_2.xml");
    	    x_highest.writeObject(pl_highest_2.name);
    	    x_highest.writeObject(pl_highest_2.age);
    	    x_highest.writeObject(pl_highest_2.number);
    	    x_highest.writeObject(pl_highest_2.character);
    	    x_highest.writeObject(pl_highest_2.scenario);
    	    x_highest.writeObject(pl_highest_2.score);
            x_highest.closeWriterXML();
        }
        
        if(number == 3){
            pl_highest_3 = getHighest(pl, pl_highest_3);   
            x_highest.openWriterXML("highest_3.xml");
    	    x_highest.writeObject(pl_highest_3.name);
    	    x_highest.writeObject(pl_highest_3.age);
    	    x_highest.writeObject(pl_highest_3.number);
    	    x_highest.writeObject(pl_highest_3.character);
    	    x_highest.writeObject(pl_highest_3.scenario);
    	    x_highest.writeObject(pl_highest_3.score);
            x_highest.closeWriterXML();
        }
        
        if(number == 4){
            pl_highest_4 = getHighest(pl, pl_highest_4);     
            x_highest.openWriterXML("highest_4.xml");
    	    x_highest.writeObject(pl_highest_4.name);
    	    x_highest.writeObject(pl_highest_4.age);
    	    x_highest.writeObject(pl_highest_4.number);
    	    x_highest.writeObject(pl_highest_4.character);
    	    x_highest.writeObject(pl_highest_4.scenario);
    	    x_highest.writeObject(pl_highest_4.score);
            x_highest.closeWriterXML();
        }

        //read last five score from XML
        
        x_lastfive.openReaderXML("lastfive_2.xml");
        name_last1_2 = (String)x_lastfive.ReadObject();
        name_last2_2 = (String)x_lastfive.ReadObject();
        name_last3_2 = (String)x_lastfive.ReadObject();
        name_last4_2 = (String)x_lastfive.ReadObject();
        name_last5_2 = (String)x_lastfive.ReadObject();
        score_last1_2 = (Integer)x_lastfive.ReadObject();
        score_last2_2 = (Integer)x_lastfive.ReadObject();
        score_last3_2 = (Integer)x_lastfive.ReadObject();
        score_last4_2 = (Integer)x_lastfive.ReadObject();
        score_last5_2 = (Integer)x_lastfive.ReadObject();
        x_lastfive.closeReaderXML();
        
        x_lastfive.openReaderXML("lastfive_3.xml");
        name_last1_3 = (String)x_lastfive.ReadObject();
        name_last2_3 = (String)x_lastfive.ReadObject();
        name_last3_3 = (String)x_lastfive.ReadObject();
        name_last4_3 = (String)x_lastfive.ReadObject();
        name_last5_3 = (String)x_lastfive.ReadObject();
        score_last1_3 = (Integer)x_lastfive.ReadObject();
        score_last2_3 = (Integer)x_lastfive.ReadObject();
        score_last3_3 = (Integer)x_lastfive.ReadObject();
        score_last4_3 = (Integer)x_lastfive.ReadObject();
        score_last5_3 = (Integer)x_lastfive.ReadObject();
        x_lastfive.closeReaderXML();
        
        x_lastfive.openReaderXML("lastfive_4.xml");
        name_last1_4 = (String)x_lastfive.ReadObject();
        name_last2_4 = (String)x_lastfive.ReadObject();
        name_last3_4 = (String)x_lastfive.ReadObject();
        name_last4_4 = (String)x_lastfive.ReadObject();
        name_last5_4 = (String)x_lastfive.ReadObject();
        score_last1_4 = (Integer)x_lastfive.ReadObject();
        score_last2_4 = (Integer)x_lastfive.ReadObject();
        score_last3_4 = (Integer)x_lastfive.ReadObject();
        score_last4_4 = (Integer)x_lastfive.ReadObject();
        score_last5_4 = (Integer)x_lastfive.ReadObject();
        x_lastfive.closeReaderXML();
        
        //write last five score to XML

        if(number == 2){
        x_lastfive.openWriterXML("lastfive_2.xml");
        x_lastfive.writeObject(name);
        x_lastfive.writeObject(name_last1_2);
        x_lastfive.writeObject(name_last2_2);
        x_lastfive.writeObject(name_last3_2);
        x_lastfive.writeObject(name_last4_2);
        x_lastfive.writeObject(score);
        x_lastfive.writeObject(score_last1_2);
        x_lastfive.writeObject(score_last2_2);
        x_lastfive.writeObject(score_last3_2);
        x_lastfive.writeObject(score_last4_2);
        x_lastfive.closeWriterXML();
        }
        
        if(number == 3){
        x_lastfive.openWriterXML("lastfive_3.xml");
        x_lastfive.writeObject(name);
        x_lastfive.writeObject(name_last1_3);
        x_lastfive.writeObject(name_last2_3);
        x_lastfive.writeObject(name_last3_3);
        x_lastfive.writeObject(name_last4_3);
        x_lastfive.writeObject(score);
        x_lastfive.writeObject(score_last1_3);
        x_lastfive.writeObject(score_last2_3);
        x_lastfive.writeObject(score_last3_3);
        x_lastfive.writeObject(score_last4_3);
        x_lastfive.closeWriterXML();
        }
        
        if(number == 4){
        x_lastfive.openWriterXML("lastfive_4.xml");
        x_lastfive.writeObject(name);
        x_lastfive.writeObject(name_last1_4);
        x_lastfive.writeObject(name_last2_4);
        x_lastfive.writeObject(name_last3_4);
        x_lastfive.writeObject(name_last4_4);
        x_lastfive.writeObject(score);
        x_lastfive.writeObject(score_last1_4);
        x_lastfive.writeObject(score_last2_4);
        x_lastfive.writeObject(score_last3_4);
        x_lastfive.writeObject(score_last4_4);
        x_lastfive.closeWriterXML();
        }
        
	   	ImageIcon i_gameover = new ImageIcon("image/gameover.jpg");
	   	l_gameover = new JLabel(i_gameover);
	   	ImageIcon i_yourscore = new ImageIcon("image/yourscore.jpg");
	   	l_yourscore = new JLabel(i_yourscore);
	   	ImageIcon i_2students = new ImageIcon("image/2students.jpg");
	   	l_students = new JLabel(i_2students);
	   	ImageIcon i_highestscore = new ImageIcon("image/highestscore.jpg");
	   	l_highestscore = new JLabel(i_highestscore);
	   	ImageIcon i_lastfivescore = new ImageIcon("image/lastfivescore.jpg");
	   	l_lastfivescore = new JLabel(i_lastfivescore);
	   	
	   	ta_yourscore = new JTextArea(" Name: " + name + 
	   			"\n Age: " + age +
	   			"\n Character: " + character +
	   			"\n Scenario: " + scenario +
	   			"\n Number of students: " + number +
	   			"\n Score: " + score);
	   	
	   	ta_highestscore = new JTextArea(" Name: " + pl_highest_2.name + 
	   			"\n Age: " + pl_highest_2.age +
	   			"\n Character: " + pl_highest_2.character +
	   			"\n Scenario: " + pl_highest_2.scenario +
	   			"\n Score: " + pl_highest_2.score);
	   	
	   	ta_lastfivescore = new JTextArea(" 1.   Name: " + name_last1_2 + "     Score: " + score_last1_2 + 
	   			"\n 2.   Name: " + name_last2_2 + "     Score: " + score_last2_2 +
	   			"\n 3.   Name: " + name_last3_2 + "     Score: " + score_last3_2 +
	   			"\n 4.   Name: " + name_last4_2 + "     Score: " + score_last4_2 +
	   			"\n 5.   Name: " + name_last5_2 + "     Score: " + score_last5_2);
	   	
	   	b_2students = new JButton("2 students");
	   	b_3students = new JButton("3 students");
	   	b_4students = new JButton("4 students");
	   	b_restart = new JButton("Restart!");
	   	
	   	b_2students.addActionListener(this);
	   	b_3students.addActionListener(this);
	   	b_4students.addActionListener(this);
	   	b_restart.addActionListener(this);
		
	   	add(l_gameover);
	   	add(l_yourscore);
	   	add(ta_yourscore);
	   	add(b_2students);
	   	add(b_3students);
	   	add(b_4students);
	   	add(l_students);
	   	add(l_highestscore);
	   	add(ta_highestscore);
	   	add(l_lastfivescore);
	   	add(ta_lastfivescore);
	   	add(b_restart);

	   	l_gameover.setBounds(new Rectangle(250,20,300,100));
	   	l_yourscore.setBounds(new Rectangle(80,130,350,100));
	   	ta_yourscore.setBounds(new Rectangle(450,130,250,110));
	   	b_2students.setBounds(new Rectangle(150,350,100,30));
	   	b_3students.setBounds(new Rectangle(350,350,100,30));
	   	b_4students.setBounds(new Rectangle(550,350,100,30));
	   	l_students.setBounds(new Rectangle(250,250,300,100));
	   	l_highestscore.setBounds(new Rectangle(80,420,350,100));
	   	ta_highestscore.setBounds(new Rectangle(450,430,250,100));
	   	l_lastfivescore.setBounds(new Rectangle(80,560,350,100));
	   	ta_lastfivescore.setBounds(new Rectangle(450,570,250,100));
	   	b_restart.setBounds(new Rectangle(350,700,100,30));
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.setColor(Color.gray);
		g.drawLine(0,250,800,250);
		g.drawLine(0,410,800,410);
		g.drawLine(0,540,800,540);
		g.drawLine(0,680,800,680);
	}
	
	public void actionPerformed(ActionEvent event){
		
		//when click 2 students
		
		if(event.getSource() == b_2students){
			
			ImageIcon i_2students = new ImageIcon("image/2students.jpg");
		   	l_students.setIcon(i_2students);
		   	
			ta_highestscore.setText(" Name: " + pl_highest_2.name + 
		   			"\n Age: " + pl_highest_2.age +
		   			"\n Character: " + pl_highest_2.character +
		   			"\n Scenario: " + pl_highest_2.scenario +
		   			"\n Score: " + pl_highest_2.score);
		   	
			ta_lastfivescore.setText(" 1.   Name: " + name_last1_2 + "     Score: " + score_last1_2 + 
		   			"\n 2.   Name: " + name_last2_2 + "     Score: " + score_last2_2 +
		   			"\n 3.   Name: " + name_last3_2 + "     Score: " + score_last3_2 +
		   			"\n 4.   Name: " + name_last4_2 + "     Score: " + score_last4_2 +
		   			"\n 5.   Name: " + name_last5_2 + "     Score: " + score_last5_2);
		}
		
		//when click 3 students
		
		if(event.getSource() == b_3students){
			
			ImageIcon i_3students = new ImageIcon("image/3students.jpg");
		   	l_students.setIcon(i_3students);
		   	
			ta_highestscore.setText(" Name: " + pl_highest_3.name + 
		   			"\n Age: " + pl_highest_3.age +
		   			"\n Character: " + pl_highest_3.character +
		   			"\n Scenario: " + pl_highest_3.scenario +
		   			"\n Score: " + pl_highest_3.score);

		   	ta_lastfivescore.setText(" 1.   Name: " + name_last1_3 + "     Score: " + score_last1_3 + 
		   			"\n 2.   Name: " + name_last2_3 + "     Score: " + score_last2_3 +
		   			"\n 3.   Name: " + name_last3_3 + "     Score: " + score_last3_3 +
		   			"\n 4.   Name: " + name_last4_3 + "     Score: " + score_last4_3 +
		   			"\n 5.   Name: " + name_last5_3 + "     Score: " + score_last5_3);
		}
		
		//when click 4 students
		
		if(event.getSource() == b_4students){
			
			ImageIcon i_4students = new ImageIcon("image/4students.jpg");
		   	l_students.setIcon(i_4students);
		   	
			ta_highestscore.setText(" Name: " + pl_highest_4.name + 
		   			"\n Age: " + pl_highest_4.age +
		   			"\n Character: " + pl_highest_4.character +
		   			"\n Scenario: " + pl_highest_4.scenario +
		   			"\n Score: " + pl_highest_4.score);
			
			ta_lastfivescore.setText(" 1.   Name: " + name_last1_4 + "     Score: " + score_last1_4 + 
		   			"\n 2.   Name: " + name_last2_4 + "     Score: " + score_last2_4 +
		   			"\n 3.   Name: " + name_last3_4 + "     Score: " + score_last3_4 +
		   			"\n 4.   Name: " + name_last4_4 + "     Score: " + score_last4_4 +
		   			"\n 5.   Name: " + name_last5_4 + "     Score: " + score_last5_4);
		}
		
		//when click restart
		
		if(event.getSource() == b_restart){
			restart = true;
		}
	}
	
	public player getHighest(player pl, player pl_highest){
		
		// get highest score between current score and historical highest score
		
		if(pl.score<=pl_highest.score){
			
		}
		if(pl.score>pl_highest.score){
			pl_highest = pl;
		}
		return pl_highest;
	}
}
