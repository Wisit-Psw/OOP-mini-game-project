package display;

//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import character.Sworder;

public class select extends JPanel {

		private static final long serialVersionUID = 1L;
		public long point;ActionListener main;
		String bg;
		Sworder Person1; 
		Sworder Person2; 
		public void p1_img(String s) {
			Person1.Standard=s;
			repaint();
	    }
		public void p2_img(String s) {
			Person2.Standard=s;
			repaint();
	    }
		public void bg_img(String s) {
			bg=s;
			repaint();
	    }
		public void paint(Graphics g) {
	    	super.paintComponents(g);
	    	Graphics2D g2 = (Graphics2D)g;
	    	try {
				g2.drawImage(ImageIO.read(new File(bg)),0,0 ,1000,600,null);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	
			g2.drawImage(Person1.getImage(),Person1.x, Person1.y , Person1.width, Person1.high,null);
	    	g2.drawImage(Person2.getImage(),Person2.x, Person2.y , Person2.width, Person2.high,null);
	    }
		public select() {
			//----
		}
		
		public select(ActionListener main) {
			try {
				 Person1 = new Sworder(50, 375, 80, 100,1,"img\\Red\\Sword\\");
				 Person2 = new Sworder(850, 375, 80, 100,2,"img\\Blue\\Sword\\");
				 bg="img\\bg\\std.jpg";
					this.main=main;
					this.setBounds(0,0,1000,600);
					this.setFocusable(true);
					this.setLayout(null);
					setVisible(true);
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		public select(ActionListener main,String p1_img,String p2_img,String BG) {
			try {
					Person1 = new Sworder(50, 375, 80, 100,1,p1_img);
				 Person2 = new Sworder(850, 375, 80, 100,2,p2_img);
				 bg=BG;
					this.main=main;
					this.setBounds(0,0,1000,600);
					this.setFocusable(true);
					this.setLayout(null);
					setVisible(true);
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
}
