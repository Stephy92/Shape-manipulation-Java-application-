import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class RoundRectangle extends Shape {

	//this class represent a round rectangle
	public void draw(Graphics g) {
		//get the color of round rectangle
        g.setColor(getColor());
        //draw a round rectangle
        g.drawRoundRect(left, top, width, height, 30, 30);
    }
}