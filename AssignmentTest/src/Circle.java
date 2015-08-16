import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Circle extends Shape
{
	void draw(Graphics g) {
       /* g.setColor(color);
        g.fillOval(left,top,width,height);*/
        g.setColor(getColor());
        g.drawOval(left,top,width,width);
     }
     boolean containsPoint(int x, int y) {
           // Check whether (x,y) is inside this oval, using the
           // mathematical equation of an ellipse.
        double rx = width/2.0;   // horizontal radius of ellipse
        double ry = width/2.0;  // vertical radius of ellipse 
        double cx = left + rx;   // x-coord of center of ellipse
        double cy = top + ry;    // y-coord of center of ellipse
        if ( (ry*(x-cx))*(ry*(x-cx)) + (rx*(y-cy))*(rx*(y-cy)) <= rx*rx*ry*ry )
           return true;
        else
          return false;
     }
  }