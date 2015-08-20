import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Oval extends Shape
{
	//this class represent to oval
	void draw(Graphics g) {
		// get the color of oval
        g.setColor(getColor());
        // draw a oval
        g.drawOval(left,top,width,height);
     }
     boolean containsPoint(int x, int y) {
           // Check whether (x,y) is inside this oval, using the
           // mathematical equation of an Oval.
        double rx = width/2.0;   // horizontal radius of Oval
        double ry = height/2.0;  // vertical radius of Oval 
        double cx = left + rx;   // x-coord of center of Oval
        double cy = top + ry;    // y-coord of center of Oval
        if ( (ry*(x-cx))*(ry*(x-cx)) + (rx*(y-cy))*(rx*(y-cy)) <= rx*rx*ry*ry )
           return true;
        else
          return false;
     }
  }