package Element;

import java.awt.Color;

import javax.swing.JLabel;

public class EleLabel extends JLabel {
	public static final long serialVersionUID = 1L;
		public EleLabel(String title,int size,int x,int y,int w,int h) {
			 super(title);
			 this.setBackground(Color.LIGHT_GRAY);
			 this.setForeground(Color.white);
			 setFont(Element.getFont(size));
			 setBounds(x,y,w,h);
		}
}
