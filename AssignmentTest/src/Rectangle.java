import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Rectangle extends Shape {

	//this class represent rectangle
	public void draw(Graphics g) {
		// get the color of rectangle
		
        g.setColor(getColor());
        // draw a rectangle
        g.drawRect(left,top,width,height);
        
        
    }
}