import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Rectangle extends Shape {

	public void draw(Graphics g) {
        /*g.setColor(color);
        g.fillRect(left,top,width,height);*/
        g.setColor(getColor());
        g.drawRect(left,top,width,height);
        
    }
}