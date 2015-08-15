import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class Shape extends JPanel{
	/*String[] shape = {"Rectangle","Oval","Square","Circle"};
	JComboBox cb1 = new JComboBox(shape);
	*/
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		this.setBackground(Color.WHITE);
		
		g.setColor(Color.BLUE);
		g.drawRect(5, 40, 90, 55);
		g.fillRect(100, 40, 90, 55);
		
		g.setColor(Color.CYAN);
		g.fillRoundRect(195, 40, 90, 55, 50, 50);
		g.drawRoundRect(290, 40, 90, 55, 20, 20);
		
		g.setColor(Color.GREEN);
		g.draw3DRect(5, 100, 90, 55, true);
		g.fill3DRect(100, 100, 90, 50, false);
		
		g.setColor(Color.MAGENTA);
		g.drawOval(195, 100, 90, 55);
		g.fillOval(290, 100, 90, 55);
		
		g.drawPolygon(new int[] {10, 20, 30}, new int[] {100, 20, 100}, 3);
	}
}