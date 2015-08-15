import java.awt.Color;
import javax.swing.JFrame;

public class Interface{
	public static void main(String[] args){
		JFrame frame = new JFrame("Drawing rectangle and ovals");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Shape shape = new Shape();
		shape.setBackground(Color.white);
		frame.add(shape);
		frame.setSize(400,210);
		frame.setVisible(true);
		
	}	
}
