import java.awt.*;

import javax.swing.JPanel;


public abstract class Shape extends JPanel{
	
	int left, top;      // Position of top left corner of rectangle that bounds this shape.
    int width, height;  // Size of the bounding rectangle.
    Color color = Color.black;  // Color of this shape.
  
	
	public void reshape(int left, int top, int width, int height) {
        // Set the position and size of this shape.
     this.left = left;
     this.top = top;
     this.width = width;
     this.height = height;
  }

    
    void moveBy(int dx, int dy) {
           // Move the shape by dx pixels horizontally and dy pixels vertically
           // (by changing the position of the top-left corner of the shape).
       left += dx;
       top += dy;
    }

    public void setColor(Color newColor) {
           // Set the color of this shape
       this.color = newColor;
    }
    public Color getColor()
	{
		return color;
	}

    boolean containsPoint(double d, double e) {
          // Check whether the shape contains the point (x,y).
          // By default, this just checks whether (x,y) is inside the
          // rectangle that bounds the shape.  This method should be
          // overridden by a subclass if the default behavior is not
          // appropriate for the subclass.
       if (d >= left && d < left+width && e >= top && e < top+height)
          return true;
       else
          return false;
    }

    abstract void draw(Graphics g); 
}
