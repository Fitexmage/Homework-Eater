
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class myJPanel extends JPanel implements ActionListener{
	
	myJPanel_Menu p_menu = new myJPanel_Menu();
	myJPanel_Toolbar p_toolbar = new myJPanel_Toolbar();
	myJPanel_Instruction p_instruction = new myJPanel_Instruction();
	myJPanel_Designer p_designer = new myJPanel_Designer();
	myJPanel_Input p_input = new myJPanel_Input();
	myJPanel_Game p_game;
	myJPanel_Gameover p_gameover;
	
	Timer tim_gameover, tim_restart;
	int delay = 0;
	java.applet.AudioClip clip_background;
	
	public myJPanel()
	{
		super();
		setBackground(Color.white);
		setLayout(null);
		
		try{
			clip_background = java.applet.Applet.newAudioClip(new java.net.URL("file:sound/background.wav"));
		}
		catch(Exception e) {e.printStackTrace();}
		
		clip_background.loop();
		
		add(p_menu);
		add(p_toolbar);
		
		delay = 100;
		tim_gameover = new Timer(delay, this);
		tim_restart = new Timer(delay, this);
		
		p_menu.b_play.addActionListener(this);
		p_toolbar.b_menu.addActionListener(this);
		p_toolbar.b_instruction.addActionListener(this);
		p_toolbar.b_designer.addActionListener(this);
		p_input.b_enter.addActionListener(this);
		
		p_menu.setBounds(new Rectangle(0,0,800,660));
		p_instruction.setBounds(new Rectangle(0,0,800,660));
		p_designer.setBounds(new Rectangle(0,0,800,660));
		p_input.setBounds(new Rectangle(0,0,800,800));
		p_toolbar.setBounds(new Rectangle(0,660,800,140));
	}
	
	public void actionPerformed(ActionEvent event) {
	   	 
		// when click play
		
		if(event.getSource() == p_menu.b_play){
			remove(p_menu);
			remove(p_toolbar);
			add(p_input);
			validate();
			repaint();
    	}
	   	
		// when click menu
		
    	if(event.getSource() == p_toolbar.b_menu){
    		remove(p_instruction);
        	remove(p_designer);
        	add(p_menu);
        	validate();
        	repaint();
    	}
		
    	// when click instruction
    	
    	if(event.getSource() == p_toolbar.b_instruction){
    		remove(p_menu);
    		remove(p_designer);
    		add(p_instruction);
    		validate();
    		repaint();
    	}
    	
    	// when click designer
    	
    	if(event.getSource() == p_toolbar.b_designer){
    		remove(p_menu);
        	remove(p_instruction);
        	add(p_designer);
        	validate();
        	repaint();
    	}
    	
    	// when click enter
    	
    	if(event.getSource() == p_input.b_enter){
    		p_game = new myJPanel_Game(p_input.tf_inputname.getText(), p_input.age, p_input.number, p_input.character, p_input.scenario);
    		add(p_game);
        	remove(p_input);
        	p_game.setBounds(new Rectangle(0,0,800,800));
        	validate();
        	tim_gameover.start();			
    	}
	
    	if(event.getSource() == tim_gameover){
    		if(p_game.life == 0){
        		tim_gameover.stop();
    	    	p_gameover = new myJPanel_Gameover(p_game.name, p_game.age, p_game.number, p_game.character, p_game.scenario, p_game.score);
    	    	remove(p_game);
    	    	add(p_gameover);
    	    	p_gameover.setBounds(new Rectangle(0,0,800,800));
    	    	validate();
    	    	tim_restart.start();
    		}
    	}
    	
    	if(event.getSource() == tim_restart){
    		if(p_gameover.restart == true){
    			tim_restart.stop();
    			remove(p_gameover);
    			add(p_menu);
    			add(p_toolbar);
    			validate();
    			repaint();
    		}
    	}
	}
}
