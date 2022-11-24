package character;
import javax.imageio.ImageIO;


import javax.swing.JPanel;

//import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
public class person implements acctac{
	public int x,y,line,width,widtht,high,facing,jumph=70,jumpcount=0,HP=100,actaccount=0,stundstatus=0;
	public person opponent; 
	public String Standard,Actacing,stunding,nowacting;
	public void walk(JPanel game,int key) {
		Thread gameThread = new Thread() {
	        public void run() {
	        	if(key==1&&x<920) {
	    			x+=15;
	    			facing=1;
	    			game.repaint();
	    		}
	    		if(key==2&&x>20) {
	    			x-=15;
	    			facing=2;
	    			game.repaint();
	    		}
	        }
	      };
		gameThread.start();
	}
	public void stund(JPanel game) {
		
		Thread gameThread = new Thread() {
	        public void run() {
	        	nowacting=stunding;width=widtht;stundstatus=1;
	    		game.repaint();
	            try {
	              sleep(200); // milliseconds
	              nowacting= Standard;
					stundstatus=0;
					if(stundstatus==0) {game.repaint();}
	            } catch (InterruptedException ex) {}
	        }
	      };
		gameThread.start();
		
	}
	public void Actac(JPanel game) {}
	public void jump(JPanel game) {
		if(jumpcount<2) {
			for(int i=0;i<jumph;i++) {
				y --;
				game.repaint();
			}
			Thread gameThread = new Thread() {

		        public void run() {
		        	for(int i=0;i<jumph;i++) {
						y --;
						game.repaint();
						try {
				              sleep(1); // milliseconds
				            } catch (InterruptedException ex) {}
					}
		        	jumpcount++;
		        	try {
			              sleep(350); // milliseconds
			              while(y<line) {
								y ++;
								game.repaint();
								try {
						              sleep(1); // milliseconds
						            } catch (InterruptedException ex) {}
							}
							if(y==line){jumpcount=0;}
			            } catch (InterruptedException ex) {}
		        }
		      };
		      gameThread.start();

		}
		if(y==line){jumpcount=0;}
		
	}
	
	public BufferedImage getImage() {
		BufferedImage image = null;
		String acting = null;
		if(facing==1){acting=nowacting+"R.png";}
		else if(facing==2){acting=nowacting+"L.png";}
		try {
			image = ImageIO.read(new File(acting));
			return image;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
	public person(int x,int y,int w,int h,int s,String ac){
		this.x=x;
		this.y=y;
		this.line=y;
		this.width=w;
		this.widtht=w;
		this.high=h;
		this.facing=s;
		this.Standard=ac+"std";
		this.Actacing= ac+"Actac";
		this.stunding=ac+"stund";
		this.nowacting=ac+"std";
	}
}
