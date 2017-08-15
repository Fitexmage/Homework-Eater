import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.event.*;

public class myJPanel_Game extends JPanel implements ActionListener, KeyListener{
	
    //main panel of game
    
	//player information
	
    String name;
	int age;
	int number;
	String character;
	String scenario;
	
	//eater position
	
	int X = 350;
	int Y = 350;
	
	//eater size
	
	int width;
	int height;
	
	int score = 0;
	int life = 1;
    JButton eater = new JButton();
    student st1, st2, st3, st4;
    homework hw1;
    JLabel l_score;
   	Timer tim;
   	int delay = 0;
   	java.applet.AudioClip clip_eat;
    
    public myJPanel_Game(String name, int age, int number, String character, String scenario){
   	 
   	 super();
   	 
   	 this.name = name;
   	 this.age = age;
   	 this.number = number;
   	 this.character = character;
   	 this.scenario = scenario;
	
   	 setLayout(null);
   	 
   	 try{
		clip_eat = java.applet.Applet.newAudioClip(new java.net.URL("file:sound/eat.wav"));
   	 }
   	 catch(Exception e) {e.printStackTrace();}
   	 
   	 l_score = new JLabel("   Name: " + name + "      Age: " + age + "      Score: 0");
   	 
   	 st1 = new student(0,50);
   	 st2 = new student(735,715);
   	 st3 = new student(735,50);
   	 st4 = new student(0,715);
   	 hw1 = new homework();
   	 
  	 add(l_score);
   	 add(eater);
   	 add(hw1);

   	 setFocusable(true);
   	 addKeyListener(this);
   	 requestFocusInWindow();

   	 delay = 100;
   	 tim = new Timer(delay, this);
   	 tim.start();
	
	//set number of students
	
	if(number == 2){
		
		add(st1);
		add(st2);
		
		st1.setBounds(new Rectangle(st1.X,st1.Y,50,50));
		st2.setBounds(new Rectangle(st2.X,st2.Y,50,50));
	}
	
	if(number == 3){

		add(st1);
		add(st2);
		add(st3);
		
		st1.setBounds(new Rectangle(st1.X,st1.Y,50,50));
		st2.setBounds(new Rectangle(st2.X,st2.Y,50,50));
		st3.setBounds(new Rectangle(st3.X,st3.Y,50,50));
	}
	
	if(number == 4){

		add(st1);
		add(st2);
		add(st3);
		add(st4);
		
		st1.setBounds(new Rectangle(st1.X,st1.Y,50,50));
		st2.setBounds(new Rectangle(st2.X,st2.Y,50,50));
		st3.setBounds(new Rectangle(st3.X,st3.Y,50,50));
		st4.setBounds(new Rectangle(st4.X,st4.Y,50,50));
	}
	
	//set character
	
	if(character == "Bill"){
		width = 30;
		height = 30;
		ImageIcon image = new ImageIcon("image/bill/Bill.jpg");
		eater.setIcon(image);
	}
	if(character == "Cindy"){
		width = 40;
		height = 20;
    	ImageIcon image = new ImageIcon("image/cindy/Cindy.jpg");
    	eater.setIcon(image);
    }
	if(character == "Jason"){
		width = 20;
		height = 40;
    	ImageIcon image = new ImageIcon("image/jason/Jason.jpg");
    	eater.setIcon(image);
    }
	
	 l_score.setBounds(new Rectangle(0,0,800,50));
   	 eater.setBounds(new Rectangle(X,Y,width,height));
   	 hw1.randomplace();
	}

	public void paintComponent(Graphics g) {
		
    	super.paintComponent(g);
    	
    	//set background
    	
    	if(scenario == "IST"){
        Image image = Toolkit.getDefaultToolkit().getImage("image/IST_scenario.jpg");
        g.drawImage(image, 0, 0, this);
    	}
   	 
    	if(scenario == "Pattee"){
        Image image = Toolkit.getDefaultToolkit().getImage("image/Pattee_scenario.jpg");
        g.drawImage(image, 0, 0, this);
    	}
   	 
    	if(scenario == "HUB"){
        Image image = Toolkit.getDefaultToolkit().getImage("image/HUB_scenario.jpg");
        g.drawImage(image, 0, 0, this);
    	}
    
    	g.setColor(Color.yellow);
    	g.fillRect(0,0,800,50); 
    	
	}
    	
	public void actionPerformed(ActionEvent event){
		
		if(event.getSource() == tim){
			
			if(number == 2){
				studentmove(st1);
				studentmove(st2);
			}
				
			if(number == 3){
				studentmove(st1);
				studentmove(st2);
				studentmove(st3);
			}
				
			if(number == 4){
				studentmove(st1);
				studentmove(st2);
				studentmove(st3);
				studentmove(st4);
			}
		}
		
	}
	
	public void keyPressed(KeyEvent e){
		
		//when press key
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			eatermove("left");
			eater.setBounds(new Rectangle(X,Y,width,height));
			eat(hw1);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			eatermove("right");
			eater.setBounds(new Rectangle(X,Y,width,height));
			eat(hw1);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP){
			eatermove("up");
			eater.setBounds(new Rectangle(X,Y,width,height));
			eat(hw1);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			eatermove("down");
			eater.setBounds(new Rectangle(X,Y,width,height));
			eat(hw1);
		}

		if(e.getKeyCode() == KeyEvent.VK_D){
			
			//Easter Egg
			
			hw1.X = 1000;
			hw1.Y = 1000;
			remove(hw1);
			ImageIcon img = null;
			eater.setIcon(img);
			name = "Diablo";
			age = 10000;
			score = 10000;
			life = -1;
			l_score.setText("   Name: " + name + "      Age: " + age + "      Score: " + score + "                                Now, Diablo has come. Homework will never exist in PSU...");
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}

	public void keyReleased(KeyEvent e) {
		
	}
	
    public void eatermove(String a){
    	
    	//define movement of eater
    	
    	if(a == "left"){X = X-10;}
    	if(a == "right"){X = X+10;}
    	if(a == "up"){Y = Y-10;}
    	if(a == "down"){Y = Y+10;}
    	
    	eaterlimit();
    }
    
    public void studentmove(student st){
    	
    	//define movement of student
    	
		double r1 = Math.random();
		double r2 = Math.random();
		int rd1 = (int)(r1 * 4f);
		int rd2 = (int)(r2 * 50f);
 
		if(rd1 == 0){
			for(int i = 0; i<rd2; i++){
				st.X = st.X+1;
				st.studentlimit();
				st.setBounds(new Rectangle(st.X,st.Y,st.width,st.height));
			}	
		}
		if(rd1 == 1){
			for(int i = 0; i<rd2; i++){
				st.X = st.X-1;
				st.studentlimit();
				st.setBounds(new Rectangle(st.X,st.Y,st.width,st.height));
			}	
		}
		if(rd1 == 2){
			for(int i = 0; i<rd2; i++){
				st.Y = st.Y-1;
				st.studentlimit();
				st.setBounds(new Rectangle(st.X,st.Y,st.width,st.height));
			}	
		}
		if(rd1 == 3){
			for(int i = 0; i<rd2; i++){
				st.Y = st.Y+1;
				st.studentlimit();
				st.setBounds(new Rectangle(st.X,st.Y,st.width,st.height));
			}
		}	
			capture(st);
	 }
    
    public void eaterlimit(){
    	
    	//set limit for eater
    	
    	if(X<0){
			X = 0;
		}
		if(X>785-width){
			X = 785-width;
		}
		if(Y<50){
			Y = 50;
		}
		if(Y>762-height){
			Y = 762-height;
		}
    }

    public void eat(homework hw){
    	
    	//when homework is eaten
    	
    	if((X+width)>=hw.X && X<= (hw.X+hw.width) && (Y+height)>=hw.Y && Y<= (hw.Y+hw.height)){
    		clip_eat.play();
    		hw.randomplace();
    		score = score + 1;
    		grow();
    		l_score.setText("   Name: " + name + "      Age: " + age + "      Score: " + score);
    	}
    }
    
    public void capture(student st){
    	
    	//when homework eater is captured
    	
    	if((X+width)>=st.X && X<= (st.X+st.width) && (Y+height)>=st.Y && Y<= (st.Y+st.height)){
    		life = life - 1;
    		/*X = 350;
    		Y = 350;
    		eater.setBounds(new Rectangle(X,Y,width,height));*/
    	}
    }
    
    public void grow(){
    	
    	//not available, need more picture
    	
    	ImageIcon img = null;
    	
    	if(character == "Bill"){
    		
    		width = width+6;
    		height = height+6;
    		
    		if(score == 1){
    			img = new ImageIcon("image/bill/Bill1.jpg");
    		}
    		if(score == 2){
    			img = new ImageIcon("image/bill/Bill2.jpg");
    		}
    		if(score == 3){
    			img = new ImageIcon("image/bill/Bill3.jpg");
    		}
    		if(score == 4){
    			img = new ImageIcon("image/bill/Bill4.jpg");
    		}
    		if(score == 5){
    			img = new ImageIcon("image/bill/Bill5.jpg");
    		}
    		if(score == 6){
    			img = new ImageIcon("image/bill/Bill6.jpg");
    		}
    		if(score == 7){
    			img = new ImageIcon("image/bill/Bill7.jpg");
    		}
    		if(score == 8){
    			img = new ImageIcon("image/bill/Bill8.jpg");
    		}
    		if(score == 9){
    			img = new ImageIcon("image/bill/Bill9.jpg");
    		}
    		if(score == 10){
    			img = new ImageIcon("image/bill/Bill10.jpg");
    		}
    		if(score == 11){
    			img = new ImageIcon("image/bill/Bill11.jpg");
    		}
    		if(score == 12){
    			img = new ImageIcon("image/bill/Bill12.jpg");
    		}
    		if(score == 13){
    			img = new ImageIcon("image/bill/Bill13.jpg");
    		}
    		if(score == 14){
    			img = new ImageIcon("image/bill/Bill14.jpg");
    		}
    		if(score == 15){
    			img = new ImageIcon("image/bill/Bill15.jpg");
    		}
    		if(score == 16){
    			img = new ImageIcon("image/bill/Bill16.jpg");
    		}
    		if(score == 17){
    			img = new ImageIcon("image/bill/Bill17.jpg");
    		}
    		if(score == 18){
    			img = new ImageIcon("image/bill/Bill18.jpg");
    		}
    		if(score == 19){
    			img = new ImageIcon("image/bill/Bill19.jpg");
    		}
    		if(score == 20){
    			img = new ImageIcon("image/bill/Bill20.jpg");
    		}
    		if(score == 21){
    			img = new ImageIcon("image/bill/Bill21.jpg");
    		}
    		if(score == 22){
    			img = new ImageIcon("image/bill/Bill22.jpg");
    		}
    		if(score == 23){
    			img = new ImageIcon("image/bill/Bill23.jpg");
    		}
    		if(score == 24){
    			img = new ImageIcon("image/bill/Bill24.jpg");
    		}
    		if(score == 25){
    			img = new ImageIcon("image/bill/Bill25.jpg");
    		}
    		if(score == 26){
    			img = new ImageIcon("image/bill/Bill26.jpg");
    		}
    		if(score == 27){
    			img = new ImageIcon("image/bill/Bill27.jpg");
    		}
    		if(score == 28){
    			img = new ImageIcon("image/bill/Bill28.jpg");
    		}
    		if(score == 29){
    			img = new ImageIcon("image/bill/Bill29.jpg");
    		}
    		if(score == 30){
    			img = new ImageIcon("image/bill/Bill30.jpg");
    		}
    		if(score == 31){
    			img = new ImageIcon("image/bill/Bill31.jpg");
    		}
    		if(score == 32){
    			img = new ImageIcon("image/bill/Bill32.jpg");
    		}
    		if(score == 33){
    			img = new ImageIcon("image/bill/Bill33.jpg");
    		}
    		if(score == 34){
    			img = new ImageIcon("image/bill/Bill34.jpg");
    		}
    		if(score == 35){
    			img = new ImageIcon("image/bill/Bill35.jpg");
    		}
    		if(score == 36){
    			img = new ImageIcon("image/bill/Bill36.jpg");
    		}
    		if(score == 37){
    			img = new ImageIcon("image/bill/Bill37.jpg");
    		}
    		if(score == 38){
    			img = new ImageIcon("image/bill/Bill38.jpg");
    		}
    		if(score == 39){
    			img = new ImageIcon("image/bill/Bill39.jpg");
    		}
    		if(score >= 40){
    			img = new ImageIcon("image/bill/Bill40.jpg");
    		}
    	}
    	
    	if(character == "Cindy"){
    		
    		width = width+8;
    		height = height+4;
    		
    		if(score == 1){
    			img = new ImageIcon("image/cindy/Cindy1.jpg");
    		}
    		if(score == 2){
    			img = new ImageIcon("image/cindy/Cindy2.jpg");
    		}
    		if(score == 3){
    			img = new ImageIcon("image/cindy/Cindy3.jpg");
    		}
    		if(score == 4){
    			img = new ImageIcon("image/cindy/Cindy4.jpg");
    		}
    		if(score == 5){
    			img = new ImageIcon("image/cindy/Cindy5.jpg");
    		}
    		if(score == 6){
    			img = new ImageIcon("image/cindy/Cindy6.jpg");
    		}
    		if(score == 7){
    			img = new ImageIcon("image/cindy/Cindy7.jpg");
    		}
    		if(score == 8){
    			img = new ImageIcon("image/cindy/Cindy8.jpg");
    		}
    		if(score == 9){
    			img = new ImageIcon("image/cindy/Cindy9.jpg");
    		}
    		if(score == 10){
    			img = new ImageIcon("image/cindy/Cindy10.jpg");
    		}
    		if(score == 11){
    			img = new ImageIcon("image/cindy/Cindy11.jpg");
    		}
    		if(score == 12){
    			img = new ImageIcon("image/cindy/Cindy12.jpg");
    		}
    		if(score == 13){
    			img = new ImageIcon("image/cindy/Cindy13.jpg");
    		}
    		if(score == 14){
    			img = new ImageIcon("image/cindy/Cindy14.jpg");
    		}
    		if(score == 15){
    			img = new ImageIcon("image/cindy/Cindy15.jpg");
    		}
    		if(score == 16){
    			img = new ImageIcon("image/cindy/Cindy16.jpg");
    		}
    		if(score == 17){
    			img = new ImageIcon("image/cindy/Cindy17.jpg");
    		}
    		if(score == 18){
    			img = new ImageIcon("image/cindy/Cindy18.jpg");
    		}
    		if(score == 19){
    			img = new ImageIcon("image/cindy/Cindy19.jpg");
    		}
    		if(score == 20){
    			img = new ImageIcon("image/cindy/Cindy20.jpg");
    		}
    		if(score == 21){
    			img = new ImageIcon("image/cindy/Cindy21.jpg");
    		}
    		if(score == 22){
    			img = new ImageIcon("image/cindy/Cindy22.jpg");
    		}
    		if(score == 23){
    			img = new ImageIcon("image/cindy/Cindy23.jpg");
    		}
    		if(score == 24){
    			img = new ImageIcon("image/cindy/Cindy24.jpg");
    		}
    		if(score == 25){
    			img = new ImageIcon("image/cindy/Cindy25.jpg");
    		}
    		if(score == 26){
    			img = new ImageIcon("image/cindy/Cindy26.jpg");
    		}
    		if(score == 27){
    			img = new ImageIcon("image/cindy/Cindy27.jpg");
    		}
    		if(score == 28){
    			img = new ImageIcon("image/cindy/Cindy28.jpg");
    		}
    		if(score == 29){
    			img = new ImageIcon("image/cindy/Cindy29.jpg");
    		}
    		if(score == 30){
    			img = new ImageIcon("image/cindy/Cindy30.jpg");
    		}
    		if(score == 31){
    			img = new ImageIcon("image/cindy/Cindy31.jpg");
    		}
    		if(score == 32){
    			img = new ImageIcon("image/cindy/Cindy32.jpg");
    		}
    		if(score == 33){
    			img = new ImageIcon("image/cindy/Cindy33.jpg");
    		}
    		if(score == 34){
    			img = new ImageIcon("image/cindy/Cindy34.jpg");
    		}
    		if(score == 35){
    			img = new ImageIcon("image/cindy/Cindy35.jpg");
    		}
    		if(score == 36){
    			img = new ImageIcon("image/cindy/Cindy36.jpg");
    		}
    		if(score == 37){
    			img = new ImageIcon("image/cindy/Cindy37.jpg");
    		}
    		if(score == 38){
    			img = new ImageIcon("image/cindy/Cindy38.jpg");
    		}
    		if(score == 39){
    			img = new ImageIcon("image/cindy/Cindy39.jpg");
    		}
    		if(score >= 40){
    			img = new ImageIcon("image/cindy/Cindy40.jpg");
    		}
    	}

    	if(character == "Jason"){
    		
    		width = width+4;
    		height = height+8;
    		
    		if(score == 1){
    			img = new ImageIcon("image/jason/Jason1.jpg");
    		}
    		if(score == 2){
    			img = new ImageIcon("image/jason/Jason2.jpg");
    		}
    		if(score == 3){
    			img = new ImageIcon("image/jason/Jason3.jpg");
    		}
    		if(score == 4){
    			img = new ImageIcon("image/jason/Jason4.jpg");
    		}
    		if(score == 5){
    			img = new ImageIcon("image/jason/Jason5.jpg");
    		}
    		if(score == 6){
    			img = new ImageIcon("image/jason/Jason6.jpg");
    		}
    		if(score == 7){
    			img = new ImageIcon("image/jason/Jason7.jpg");
    		}
    		if(score == 8){
    			img = new ImageIcon("image/jason/Jason8.jpg");
    		}
    		if(score == 9){
    			img = new ImageIcon("image/jason/Jason9.jpg");
    		}
    		if(score == 10){
    			img = new ImageIcon("image/jason/Jason10.jpg");
    		}
    		if(score == 11){
    			img = new ImageIcon("image/jason/Jason11.jpg");
    		}
    		if(score == 12){
    			img = new ImageIcon("image/jason/Jason12.jpg");
    		}
    		if(score == 13){
    			img = new ImageIcon("image/jason/Jason13.jpg");
    		}
    		if(score == 14){
    			img = new ImageIcon("image/jason/Jason14.jpg");
    		}
    		if(score == 15){
    			img = new ImageIcon("image/jason/Jason15.jpg");
    		}
    		if(score == 16){
    			img = new ImageIcon("image/jason/Jason16.jpg");
    		}
    		if(score == 17){
    			img = new ImageIcon("image/jason/Jason17.jpg");
    		}
    		if(score == 18){
    			img = new ImageIcon("image/jason/Jason18.jpg");
    		}
    		if(score == 19){
    			img = new ImageIcon("image/jason/Jason19.jpg");
    		}
    		if(score == 20){
    			img = new ImageIcon("image/jason/Jason20.jpg");
    		}
    		if(score == 21){
    			img = new ImageIcon("image/jason/Jason21.jpg");
    		}
    		if(score == 22){
    			img = new ImageIcon("image/jason/Jason22.jpg");
    		}
    		if(score == 23){
    			img = new ImageIcon("image/jason/Jason23.jpg");
    		}
    		if(score == 24){
    			img = new ImageIcon("image/jason/Jason24.jpg");
    		}
    		if(score == 25){
    			img = new ImageIcon("image/jason/Jason25.jpg");
    		}
    		if(score == 26){
    			img = new ImageIcon("image/jason/Jason26.jpg");
    		}
    		if(score == 27){
    			img = new ImageIcon("image/jason/Jason27.jpg");
    		}
    		if(score == 28){
    			img = new ImageIcon("image/jason/Jason28.jpg");
    		}
    		if(score == 29){
    			img = new ImageIcon("image/jason/Jason29.jpg");
    		}
    		if(score == 30){
    			img = new ImageIcon("image/jason/Jason30.jpg");
    		}
    		if(score == 31){
    			img = new ImageIcon("image/jason/Jason31.jpg");
    		}
    		if(score == 32){
    			img = new ImageIcon("image/jason/Jason32.jpg");
    		}
    		if(score == 33){
    			img = new ImageIcon("image/jason/Jason33.jpg");
    		}
    		if(score == 34){
    			img = new ImageIcon("image/jason/Jason34.jpg");
    		}
    		if(score == 35){
    			img = new ImageIcon("image/jason/Jason35.jpg");
    		}
    		if(score == 36){
    			img = new ImageIcon("image/jason/Jason36.jpg");
    		}
    		if(score == 37){
    			img = new ImageIcon("image/jason/Jason37.jpg");
    		}
    		if(score == 38){
    			img = new ImageIcon("image/jason/Jason38.jpg");
    		}
    		if(score == 39){
    			img = new ImageIcon("image/jason/Jason39.jpg");
    		}
    		if(score >= 40){
    			img = new ImageIcon("image/jason/Jason40.jpg");
    		}
    	}
    	
    	eater.setIcon(img);
    	eater.setBounds(new Rectangle(X,Y,width,height));	
    }
}