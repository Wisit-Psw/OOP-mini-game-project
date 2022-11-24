package display;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import character.person;

public class endmenu extends JPanel {
	public static final long serialVersionUID = 1L;
		public long point;ActionListener main;String str;
		public person p1,p2;
		public String Bg;
		public endmenu() {
			//----
		}
		public void paint(Graphics g) {
	    	super.paint(g);
	    	Graphics2D g2 = (Graphics2D)g;
	    	
	    	g2.setColor(Color.RED);
	    	try {
				g2.drawImage(ImageIO.read(new File(Bg)),0,0 ,1000,600,null);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	g2.drawImage(p1.getImage(),p1.x, p1.y , p1.width, p1.high,null);
	    	g2.setColor(Color.blue);
	    	g2.drawImage(p2.getImage(),p2.x, p2.y , p2.width, p2.high,null);
//	    	g2.drawString( Person1.HP+"%",40, 40);
//	    	g2.drawString( Person2.HP+"%",920, 40);
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
	    	
	    }
		public endmenu(person P1,person P2,String bg) {
			try {
					this.p1=P1;
					this.p2=P2;
					this.Bg=bg;
					this.setBounds(0,0,1000,600);
					this.setFocusable(true);
					this.setLayout(null);
					setVisible(true);
//					repaint();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
}
