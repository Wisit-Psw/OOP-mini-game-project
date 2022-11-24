package display;
import java.awt.BasicStroke;
import character.Bullet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

//import character.Bullet;
import character.person;
import character.Gunner;
//import display.Display;
import character.Sworder;
public class Game extends JPanel implements KeyListener{
	public static Display display;
	private static final long serialVersionUID = 1L;
	private final Set<Integer> pressedKeys = new HashSet<>();
	private final LinkedList<Bullet> Bulletset = new LinkedList<Bullet>();
	public person Person1,Person2;
	public String bg;
    public Game(){
        this.setBounds(0,0,1000,600);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setLayout(null);
        Person1 = new Sworder(50, 375, 80, 100,1,"img\\Red\\Sword\\");
    	Person2 = new Sworder(850, 375, 80, 100,2,"img\\Blue\\Sword\\");
    	bg="img\\bg\\std.jpg";
    }
    public Game(int p1,int p2,String bg){
        this.setBounds(0,0,1000,600);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setLayout(null);
        if(p1==1) {
        	Person1 = new Sworder(50, 375, 80, 100,1,"img\\Red\\Sword\\");
        }else if(p1==2){
        	Person1 = new Gunner(50, 375, 80, 100,1,"img\\Red\\Gun\\",Bulletset);
        } 
        if(p2==1) {
        	Person2 = new Sworder(850, 375, 80, 100,2,"img\\Blue\\Sword\\");
        }else if(p2==2){
        	Person2 = new Gunner(850, 375, 80, 100,2,"img\\Blue\\Gun\\",Bulletset);
        } 
    	
    	this.bg=bg;
    }
    public void paint(Graphics g) {
    	super.paint(g);
    	Graphics2D g2 = (Graphics2D)g;
    	g2.setColor(Color.RED);
    	try {
			g2.drawImage(ImageIO.read(new File(bg)),0,0 ,1000,600,null);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	g2.drawImage(Person1.getImage(),Person1.x, Person1.y , Person1.width, Person1.high,null);
    	g2.setColor(Color.blue);
    	g2.drawImage(Person2.getImage(),Person2.x, Person2.y , Person2.width, Person2.high,null);
//    	g2.drawString( Person1.HP+"%",40, 40);
//    	g2.drawString( Person2.HP+"%",920, 40);
    	drawGame(g2,Person1,Person2);
    	for(int i=0;i<Bulletset.size();i++){
    		Bullet B=Bulletset.get(i);
    		g2.setColor(Color.WHITE);
    		g2.fillOval(B.x, B.y, B.r+4, B.r+4);
    		if(B.Person==Person1){g2.setColor(Color.RED);}
    		else if(B.Person==Person2){g2.setColor(Color.BLUE);}
    		g2.fillOval(B.x+2, B.y+2, B.r+3, B.r+3);
    		if(B.x>=B.Person.opponent.x&&B.x<B.Person.opponent.x+B.Person.opponent.width&&
    				B.y>=B.Person.opponent.y&&B.y<=B.Person.opponent.y+B.Person.opponent.width){
    			B.Person.opponent.HP-=3;
    			B.Person.opponent.stund(this);
    			Bulletset.remove(i);
    				}
    		else if(B.x<0||B.x>1000){
    			Bulletset.remove(i);
    		}
    	}
    	
    	checkHit(Person1,Person2);
    }
    public void drawGame(Graphics2D g2,person p1,person p2) {
//		try {
			
			g2.setStroke(new BasicStroke(18.0f));
			g2.setColor(new Color(241, 98, 69));
			g2.drawLine(60, 30,55+p1.HP,30);	
			g2.setColor(Color.white);
			g2.setStroke(new BasicStroke(6.0f));
			g2.drawRect(50,20, 115,20);
			
			g2.setStroke(new BasicStroke(18.0f));
			g2.setColor(new Color(241, 98, 69));
			g2.drawLine(810, 30,810+p2.HP,30);	
			g2.setColor(Color.white);
			g2.setStroke(new BasicStroke(6.0f));
			g2.drawRect(805,20, 115,20);
			try {
				g2.drawImage(ImageIO.read(new File("img\\heart.png")),50,17, 25,25,null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				g2.drawImage(ImageIO.read(new File("img\\heart.png")),795,17, 25,25,null);
			} catch (IOException e) {
				e.printStackTrace();
			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
    public void checkHit(person p1,person p2){
    	if(p1.HP<=0) {
    		for(int i=0;i<Bulletset.size();i++){
        		Bulletset.remove(i);
        	}
    		display.endGame("Player 2");
		}else if(p2.HP<=0) {
			for(int i=0;i<Bulletset.size();i++){
        		Bulletset.remove(i);
        	}
			display.endGame("Player 1");
		}
}
	@Override
	public synchronized void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		pressedKeys.add(e.getKeyCode());
		if (!pressedKeys.isEmpty()) {
			for (Iterator<Integer> it = pressedKeys.iterator() ;it.hasNext();) {
				switch (it.next()) {
                case KeyEvent.VK_W:
                	Person1.jump(this);
                    break;
                case KeyEvent.VK_A:
                	Person1.walk(this, 2);
                    break;
                case KeyEvent.VK_D:
                	Person1.walk(this, 1);
                    break;
                case KeyEvent.VK_UP:
                	Person2.jump(this);
                    break;
                case KeyEvent.VK_LEFT:
                	Person2.walk(this, 2);
                    break;
                case KeyEvent.VK_RIGHT:
                	Person2.walk(this, 1);
                    break;
                case KeyEvent.VK_SPACE:
                	Person1.Actac(this);
                    break;
                case KeyEvent.VK_CONTROL:
                	Person2.Actac(this);
                    break;
				}
			}
		}
	}
		
	@Override
    public synchronized void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) { /* Not used */ }
	public static void main(String[] arg){
		display = new Display();
		System.out.println(display);
	}
    
}
