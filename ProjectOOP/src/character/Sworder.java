package character;

import javax.swing.JPanel;

public class Sworder extends person implements acctac{
	
	public Sworder(int x,int y,int w,int h,int s,String ac){
		super(x,y,w,h,s,ac);
	}

	@Override
	public void Actac(JPanel game){
		System.out.println(stundstatus);
		if(actaccount==0&&stundstatus==0) {
			
		Thread gameThread = new Thread() {
	        public void run() {
	        	System.out.println("Actac");
	    		nowacting=Actacing;width+=70;high+=20;y-=20;actaccount=1;
	    		if(facing==2) {x-=70;}
	    		if(facing==1&&x+width>=opponent.x&&x+width <=opponent.x+opponent.widtht) {
	    			if(opponent.x+70<920) {opponent.x=x+140;opponent.HP-=5;opponent.stund(game);}
	    			else {opponent.x=920;opponent.HP-=5;opponent.stund(game);}
	    		}
	    		if(facing==2&&x>=opponent.x&&x<=opponent.x+opponent.widtht-10) {
	    			if(opponent.x-70>0) {opponent.x=x-140;opponent.HP-=5;opponent.stund(game);}
	    			else {opponent.x=20;opponent.HP-=5;opponent.stund(game);}
	    		}
	    		game.repaint();
	            try {
	              sleep(200); // milliseconds
	              nowacting= Standard;width=widtht;high-=20;y+=20;
					actaccount=0;
					if(facing==2) {x+=70;}
					game.repaint();
	            } catch (InterruptedException ex) {}
	          
	        }
	      };
		gameThread.start();}
	}
}
