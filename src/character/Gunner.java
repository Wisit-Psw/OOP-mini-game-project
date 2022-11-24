package character;


import java.util.LinkedList;

import javax.swing.JPanel;

public class Gunner extends person implements acctac{
	LinkedList<Bullet> B;Gunner me;
	public Gunner(int x,int y,int w,int h,int s,String ac,LinkedList<Bullet> B){
		super(x,y,w,h,s,ac);
		this.B=B;
		me=this;
	}

	@Override
	public void Actac(JPanel game){
		System.out.println(stundstatus);
		if(actaccount==0&&stundstatus==0) {
			System.out.println("Actac");
			Thread gameThread = new Thread() {
		        public void run() {
		        	  B.add(new Bullet(x, y, facing , game, (person)me));
		        	  nowacting= Standard;
		        	  actaccount=1;
						game.repaint();
		            try {
		              sleep(250); // milliseconds
		              actaccount=0;
		            } catch (InterruptedException ex) {}
		          
		        }
		      };
		gameThread.start();}
	}

}
