import java.awt.*;

import javax.swing.JPanel;


public abstract class Shape {
	
	int left, top;      // Position of top left corner of shapes
    int width, height;  // Size of shapes
    Color color = Color.black;  // Color of those shapes.
  
	
	public void getPosition(int left, int top, int width, int height) {
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
    
 /*   public void setLocation (int dx, int dy){
    	Point p = new Point();
    	p.setLocation(dx,dy);
    	return p;
    }*/

    public void setColor(Color newColor) {
           // Set the color of this shape
       this.color = newColor;
    }
    public Color getColor()
	{
    	//get color from shape factory and return the latest color
		return color;
	}

    boolean containsPoint(double d, double e) {
          // Check whether the shape contains the point (x,y).
          // By default, this just checks whether (x,y) is inside the
          // the shape.  This method should be overridden by a subclass 
    	  //if the default behavior is not appropriate for the subclass.
       if (d >= left && d < left+width && e >= top && e < top+height)
          return true;
       else
          return false;
    }
    
    //abstract class of Shape to call the subclasses
    abstract void draw(Graphics g); 
}
