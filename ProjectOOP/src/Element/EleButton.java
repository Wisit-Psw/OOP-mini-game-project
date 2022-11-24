package Element;
import java.awt.Color;
import javax.swing.JButton;
public class EleButton extends JButton{
	public static final long serialVersionUID = 1L;
		public EleButton(String title,int size,int x,int y,int width,int height) {
			super(title);
			this.setBackground(Color.LIGHT_GRAY);
			this.setForeground(Color.white);
			this.setFont(Element.getFont(size));
			this.setBounds(x, y, width, height);
		}
		
}
