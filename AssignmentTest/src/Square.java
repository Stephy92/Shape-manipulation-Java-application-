import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Square extends Shape {
	
	// this class represent Square
	public void draw(Graphics g) {
		//get the color of square
        g.setColor(getColor());
        //draw a rectangle
        g.drawRect(left,top,height,height);
    }
}
