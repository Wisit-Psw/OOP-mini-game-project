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

public class menu extends JPanel {

		public static final long serialVersionUID = 1L;
		public long point;ActionListener main;
		public Sworder Person1 = new Sworder(50, 375, 80, 100,1,"img\\Red\\Sword\\");
		public Sworder Person2 = new Sworder(850, 375, 80, 100,2,"img\\Blue\\Sword\\");
		public void paint(Graphics g) {
	    	super.paintComponents(g);
	    	Graphics2D g2 = (Graphics2D)g;
	    	try {
				g2.drawImage(ImageIO.read(new File("img\\bg\\std.jpg")),0,0 ,1000,600,null);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	
			g2.drawImage(Person1.getImage(),Person1.x, Person1.y , Person1.width, Person1.high,null);
	    	g2.drawImage(Person2.getImage(),Person2.x, Person2.y , Person2.width, Person2.high,null);
	    }
		public menu() {
			//----
		}
		
		public menu(ActionListener main) {
			try {
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
