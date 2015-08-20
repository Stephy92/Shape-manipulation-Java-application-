import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Circle extends Shape
{
	
	// this class represent for circle
	void draw(Graphics g) {
		// get the color of circle
        g.setColor(getColor());
        // to draw a circle
        g.drawOval(left,top,height,height);
     }
     boolean containsPoint(int x, int y) {
           // Check whether (x,y) is inside this oval, using the
           // mathematical equation of an circle.
        double rx = height/2.0;   // horizontal radius of circle
        double ry = height/2.0;  // vertical radius of circle 
        double cx = left + rx;   // x-coord of center of circle
        double cy = top + ry;    // y-coord of center of circle
        if ( (ry*(x-cx))*(ry*(x-cx)) + (rx*(y-cy))*(rx*(y-cy)) <= rx*rx*ry*ry )
           return true;
        else
          return false;
     }
  }