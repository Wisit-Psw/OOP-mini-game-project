package character;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import javax.swing.JPanel;
//import javax.swing.Timer;

public class Bullet{
//	private static final long serialVersionUID = 1L;
	public int x,y,r=5,s;
	public person Person;
	public void move(JPanel game){
		if(s==1){
			Thread gameThread1 = new Thread() {
		        public void run() {
		          while (true) {
		        	  x+=1;
					  game.repaint();
		            try {
		              sleep(1); // milliseconds
		            } catch (InterruptedException ex) {}
		          }
		        }
		      };
		      gameThread1.start();}
		else if(s==2){
			Thread gameThread2 = new Thread() {
		        public void run() {
		          while (true) {
		        	  x-=1;
					  game.repaint();
		            try {
		              sleep(1); // milliseconds
		            } catch (InterruptedException ex) {}
		          }
		        }
		      };
		      gameThread2.start();}
		
	}

	public Bullet(int x,int y,int s,JPanel game,person p){
		this.x=x;
		this.y=y+(p.high/2);
		this.s=s;
		this.Person=p;
		this.move(game);
	}
}
