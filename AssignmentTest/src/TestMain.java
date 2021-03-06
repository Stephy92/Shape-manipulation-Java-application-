import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class TestMain extends JPanel implements MouseMotionListener, MouseListener, ActionListener{ 

	TestMain() {
        // Constructor: set background color to white set up listeners to respond to mouse actions
      setBackground(Color.white);
      addMouseListener(this);
      addMouseMotionListener(this);
   } 
	
	//set the default shape color as black
	Color currentColor = Color.black;
	//declaration for get back the current color
	Color prevColor = Color.black;
	//temporary variable to store point x and point y 
	int currentX, currentY;
	
	// holds a list of the shapes that are displayed on the Frame	
	ArrayList shp = new ArrayList();
	
	// holds a list of the shapes that have been selected on the Frame
	ArrayList multiShape = new ArrayList();
	
	// holds a list of the coordinate of shapes that have been selected on the Frame
	ArrayList<Point> coordinate = new ArrayList();
	
	// holds a list of the shapes that have been sort
	ArrayList newShp = new ArrayList();
	
	//function of button listener and what action its take 
		public void actionPerformed(ActionEvent e) {
			// Called to respond to action events.  
            // There have four buttons which is add button, delete button, align button and set color button 
			// have been set up to send action events to this TestMain.
            // Respond by respond the appropriate shape to the TestMain.
			String command = e.getActionCommand();
			
			//when click add button
			if(command.equals("Add"))
			{
				
				//decided by combo box which type of shape had been select and which should
				//display in the interface
				if (draw.getSelectedItem() == "Rectangle")
					//draw Rectangle when combo box choose "Rectangle"
					addShape(new Rectangle());
		        else if (draw.getSelectedItem() == "Oval")
		        	//draw Oval when combo box choose "Oval"
		        	addShape(new Oval());
		        else if (draw.getSelectedItem() == "Circle")
		        	//draw Circle when combo box choose "Circle"
		        	addShape(new Circle());
		        else if(draw.getSelectedItem() == "Round Rectangle")
		        	//draw Round Rectangle when combo box choose "Round Rectangle"
		        	addShape(new RoundRectangle());
		        else if(draw.getSelectedItem() == "Square")
		        	//draw Square when combo box choose "Square"
		        	addShape(new Square());
			}
			// when click on the delete button
			else if (command.equals("Delete")){
				if (multiShape.size()>1) { //Check whether have selected shape or not
					for (int i = multiShape.size() - 1; i >= 0; i--) {
				    Shape s = (Shape)multiShape.get(i);
				    multiShape.remove(s);
				    shp.remove(s);
						
				    }repaint();
				 }
				else{
				for ( int i = shp.size() - 1; i >= 0; i-- ) {  // check shapes from front to back
					Shape s = (Shape)shp.get(i);
					if (s.containsPoint(currentX,currentY)) { // if the coordinate of shape is same with mouse click
							shp.remove(s);
							repaint();  //remove the shape that been select
					}
				}
				}
			}
			else if(command.equals("Align")){
				Collections.sort(shp, new PointCompare());
				int distance = 0;
				for(int j=0; j<coordinate.size();j++){
					for(int i=0; i<shp.size();i++){
				
						Shape s = (Shape)shp.get(i);
						Point p = (Point)coordinate.get(j);
						if(s.containsPoint(p.getX(), p.getY())){
							//System.out.println(s.getX());
							//System.out.println(s.getY());
							
							newShp.add(s);
						}
						}
				}
				for(int i = 0; i<newShp.size();i++){
					Shape nS = (Shape)newShp.get(i);
					for(int j = 0; j<shp.size();j++){
						Shape s = (Shape)shp.get(j);
						if(nS == s){
							shp.remove(nS);
							shp.add(nS);
						}
					}
				}
				repaint();
				distance = 800 / shp.size();
				int newX = 0;
				for (int i = 0; i < coordinate.size(); i++) {
					Point p = (Point)coordinate.get(i);
					Shape s = (Shape)shp.get(i);
					int newY = (int)p.getY();
					s.getPosition(newX,newY,100,50);
						//y = s.getY();
						s.draw(getGraphics());
						newX += distance;
						//System.out.println(p.getX());
						//System.out.println(p.getY());
					}
				
			}
			
			else if(command.equals("Set Color")){
				colorActionPerformed(e);
				for ( int i = shp.size() - 1; i >= 0; i-- ) {  // check shapes from front to back
					Shape s = (Shape)shp.get(i);
					if (s.containsPoint(currentX,currentY)) {
						s.setColor(currentColor);
						repaint();  // repaint canvas to show shape in front of other shapes
						
					}	
				}
			}	
		}
		

	void addShape(Shape shape) {
        // Add the shape to the canvas, and set its size/position and color.
        // The shape is added at the top-left corner, with size 80-by-50.
        // Then redraw the canvas to show the newly added shape.
		
		Random rd = new Random();
		
		int maxX = 650;
		int minX = 0;

		int maxY = 350;
		int minY = 0;

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
		int x = rd.nextInt((maxX - minX) + 1) + minX;
		int y = rd.nextInt((maxY - minY) + 1) + minY;
		Point pnt = new Point(0,0);
		shape.setColor(currentColor);
		shape.getPosition(x,y,100,50);
		shp.add(shape);
		
		pnt.setLocation(x, y);
		coordinate.add(pnt.getLocation()); // put in
		repaint();
		//coordinate.add(y);
	}
	
	//function of button listener and what action its take
	 
	 // This is null unless a shape is being dragged.
     // A non-null value is used as a signal that dragging
     // is in progress, as well as indicating which shape
     // is being dragged.
	 Shape shapeBeingDragged = null;  
	 // During dragging, these record the x and y coordinates of the
	 //previous position of the mouse.
	 int prevDragX1;  
	 int prevDragY1;  
	 int prevDragX2;
	 int prevDragY2;

	public void mousePressed(MouseEvent e) {
		int x = e.getX();  // x-coordinate of point where mouse was clicked
		int y = e.getY();  // y-coordinate of point 
		int top = shp.size();
	     for (int i = 0; i < top; i++) {
	     Shape s = (Shape)shp.get(i);
	     if (s.containsPoint(x,y)) {
	    	 s.setColor(Color.RED);
	     }
	     }
       
       repaint();
		// User has pressed the mouse.  Find the shape that the user has clicked on, if
        // any.  If there is a shape at the position when the mouse was clicked, then
        // start dragging it.  If the user was holding down the shift key, then bring
        // the dragged shape to the front, in front of all the other shapes.
   
     for ( int i = shp.size() - 1; i >= 0; i-- ) {  // check shapes from front to back
        Shape s = (Shape)shp.get(i);
        if (s.containsPoint(x,y)) {
           shapeBeingDragged = s;
           prevDragX1 = x;
           prevDragY1 = y;
           prevDragX2 = currentX;
           prevDragY2 = currentX;
           
           if (e.isShiftDown()) {  // Bring the shape to the front by moving it to
              shp.remove(s);      //       the end of the list of shapes.
              shp.add(s);
              multiShape.remove(s);
              multiShape.add(s);
              repaint();  // repaint canvas to show shape in front of other shapes
           }
           return;
        }
     }
	}
	
	public void mouseClicked(MouseEvent e) {
		
		// User has pressed the mouse.  Find the shape that the user has clicked on, if
        // any.  If there is a shape at the position when the mouse was clicked, then
        // start dragging it.  If the user was holding down the shift key, then bring
        // the dragged shape to the front, in front of all the other shapes.
		
			
		int x = e.getX();  // x-coordinate of point where mouse was clicked
		int y = e.getY();  // y-coordinate of point 
		currentX = e.getX();  
		currentY = e.getY();
		if (e.isShiftDown()) {
			int top = shp.size();
		     for (int i = 0; i < top; i++) {
		     Shape s = (Shape)shp.get(i);
		     if (s.containsPoint(currentX,currentY)) {
		    	 s.setColor(Color.RED);
		    	 multiShape.add(s);
		    	 
		     }
		     
	         }
	       
	       repaint();
		}
		else{
		int top = shp.size();
	     for (int i = 0; i < top; i++) {
	     Shape s = (Shape)shp.get(i);
	     if (s.containsPoint(currentX,currentY)) {
	    	 s.setColor(Color.RED);
	    	 //System.out.println(s.left); 
	     }
	     else{
	    	 prevColor = s.getColor();
	    	 s.setColor(currentColor);
	    	System.out.println(s);
	    	 }
         }
       
       repaint();

	}
	}
	
	

	public void mouseEntered(MouseEvent arg0) {	}

	public void mouseExited(MouseEvent arg0) {	}

	public void mouseMoved(MouseEvent arg0) {	}
	
	public void mouseReleased(MouseEvent e) {
		  // User has released the mouse.  Move the dragged shape, then set
        // shapeBeingDragged to null to indicate that dragging is over.
        // If the shape lies completely outside the canvas, remove it
        // from the list of shapes (since there is no way to ever move
        // it back onscreen).

		int x = e.getX();  // x-coordinate of point where mouse was clicked
		int y = e.getY();  // y-coordinate of point 
		
		if (e.isShiftDown()) {
			int top = multiShape.size();
			for (int i = 0; i < top; i++) {
			     Shape s = (Shape)multiShape.get(i);
			     if (s.containsPoint(x,y)) {
			    	 s.setColor(currentColor);
			     }
			     }
			     for (int i = 0; i < top; i++) {
				     Shape mS = (Shape)multiShape.get(i);
				     Shape s = (Shape)shp.get(i);
			     if (shapeBeingDragged != null) {
			    	 shapeBeingDragged.moveBy(x - prevDragX1, y - prevDragY1);
			    	 multiShape.equals(shapeBeingDragged);
			    	 shp.equals(shapeBeingDragged);
			    	 //shapeBeingDragged.moveBy(currentX - prevDragX2, currentY - prevDragY2);
			    	 if ( shapeBeingDragged.left >= getSize().width || shapeBeingDragged.top >= getSize().height ||
		               shapeBeingDragged.left + shapeBeingDragged.width < 0 ||
		               shapeBeingDragged.top + shapeBeingDragged.height < 0 ) {// shape is off-screen
			    		 multiShape.remove(shapeBeingDragged);  // remove shape from list of shapes
			    	 }
			    	 shapeBeingDragged = null;
			    	 
			    	 repaint();
			     }
			     }
		}
		else{
			int top = shp.size();
			for (int i = 0; i < top; i++) {
				Shape s = (Shape)shp.get(i);
				if (s.containsPoint(x,y)) {
					s.setColor(currentColor);
				}
			}
			for (int i = 0; i < top; i++) {
				Shape s = (Shape)shp.get(i);
				
				if (shapeBeingDragged != null) {
					shapeBeingDragged.moveBy(x - prevDragX1, y - prevDragY1);
					multiShape.equals(shapeBeingDragged);
			    	shp.equals(shapeBeingDragged);
			    	System.out.println(shp); 
					if ( shapeBeingDragged.left >= getSize().width || shapeBeingDragged.top >= getSize().height ||
							shapeBeingDragged.left + shapeBeingDragged.width < 0 ||
							shapeBeingDragged.top + shapeBeingDragged.height < 0 ) {  // shape is off-screen
						shp.remove(shapeBeingDragged);  // remove shape from list of shapes
					}
					shapeBeingDragged = null;
					repaint();
				}
			}
			}
	}
	public void mouseDragged(MouseEvent e) {
		 // User has moved the mouse.  Move the dragged shape by the same amount.
        int x = e.getX();
        int y = e.getY();
        if (e.isShiftDown()) {
        	int top = multiShape.size();
        	for (int i = 0; i < top; i++) {
        		Shape s = (Shape)multiShape.get(i);
        		if (shapeBeingDragged != null) {
        			shapeBeingDragged.moveBy(x - prevDragX1, y - prevDragY1);
        			//shapeBeingDragged.moveBy(currentX - prevDragX2, currentY - prevDragY2);
        			prevDragX1 = x;
        			prevDragY1 = y;
        			//prevDragX2 = x;
        			//prevDragY2 = y;
        			repaint();      // redraw canvas to show shape in new position
        			         
        		}
        	}
        }
        else{
        	int top = shp.size();
        	for (int i = 0; i < top; i++) {
        		Shape s = (Shape)shp.get(i);
        		if (shapeBeingDragged != null) {
        			shapeBeingDragged.moveBy(x - prevDragX1, y - prevDragY1);
        			prevDragX1 = x;
        			prevDragY1 = y;
        			repaint();      // redraw canvas to show shape in new position
        		}
        	}
        }
	}

	
		
	public void paintComponent(Graphics g) {
        // In the paint method, all the shapes in ArrayList are
        // copied onto the canvas.
      g.setColor(getBackground());
      g.fillRect(0,0,getSize().width,getSize().height);
      int top = shp.size();
      for (int i = 0; i < top; i++) {
    	 Shape s = (Shape)shp.get(i);
         s.draw(g);
      }
   } 

	 public void colorActionPerformed(ActionEvent event)
		{
			Color selection = JColorChooser.showDialog(null, "Choose a color" , 
					Color.BLACK);
			if (selection != null)
			{
				//clr.setForeground(selection);
				setCurrentColor(selection);
			}
			else
				setCurrentColor(Color.BLACK);
		}
		
		public void setCurrentColor(Color shapeColor)
		{
			currentColor = shapeColor;
			
		}
		/*public void setHorizontalAlignment(int x, int y,Graphics g){
			int top = newShp.size();
			for (int i = 0; i < top; i++) {
				Shape s = (Shape)newShp.get(i);
				//oint p = (Point)coordinate.get(i);
				//s.reshape(x,y,100,50);
				//y = s.getY();
				//s.draw(g);
				//x += 100;
				System.out.println(x);
				System.out.println(y);
			}
		}*/
		      
		public class PointCompare
        implements Comparator<Point> {

        public int compare(final Point a, final Point b) {
            if (a.y < b.y) {
                return -1;
            }
            else if (a.y > b.y) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }

		
}

	
