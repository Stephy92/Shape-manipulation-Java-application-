import javax.swing.*;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

public class TestMain extends JPanel implements MouseMotionListener, MouseListener, ActionListener{ 

	TestMain() {
        // Constructor: set background color to white set up listeners to respond to mouse actions
      setBackground(Color.white);
      addMouseListener(this);
      addMouseMotionListener(this);
   }  
	Color currentColor = Color.black;
	//private Graphics g;
	public draw dr1;
	
	ArrayList shp = new ArrayList(); 
	  
	
	//function of button listener and what action its take 
		public void actionPerformed(ActionEvent e) {
			//if (e.getSource() instanceof JButton) {
			String command = e.getActionCommand();
			//String b2 = (String) ((JComboBox)e.getSource()).getSelectedItem();
			
			//when click add button
			if(command.equals("Add"))
			{
				
				//will come out rectangle shape when choose Rectangle from combobox
				if (draw.getSelectedItem() == "Rectangle")
					addShape(new Rectangle());
		        else if (draw.getSelectedItem() == "Oval")
		        	addShape(new Oval());
		        else if (draw.getSelectedItem() == "Circle")
		        	addShape(new Circle());
		        else if(draw.getSelectedItem() == "Triangle")
		        	addShape(new Triangle());
		        else if(draw.getSelectedItem() == "Round Rectangle")
		        	addShape(new RoundRectangle());
		        else if(draw.getSelectedItem() == "Square")
		        	addShape(new Square());
			}
			else if (command.equals("Delete"))
				repaint();
			else if(command.equals("Align"))
				System.out.println("Nothing");
			else if(command.equals("Set Color")){
				colorActionPerformed(e);
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
		shape.setColor(currentColor);
		shape.reshape(x,y,100,50);
		shp.add(shape);
		repaint();
	}
	
	//function of button listener and what action its take
	 
	
	 Shape shapeBeingDragged = null;  // This is null unless a shape is being dragged.
     // A non-null value is used as a signal that dragging
     // is in progress, as well as indicating which shape
     // is being dragged.

	 int prevDragX;  // During dragging, these record the x and y coordinates of the
	 int prevDragY;  //    previous position of the mouse.

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
           prevDragX = x;
           prevDragY = y;
           if (e.isShiftDown()) {  // Bring the shape to the front by moving it to
              shp.remove(s);      //       the end of the list of shapes.
              shp.add(s);
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
		int top = shp.size();
	     for (int i = 0; i < top; i++) {
	     Shape s = (Shape)shp.get(i);
	     if (s.containsPoint(x,y)) {
	    	 s.setColor(Color.RED);
	     }
	     else
	    	 s.setColor(currentColor);
         }
       
       repaint();
		
		for ( int i = shp.size() - 1; i >= 0; i-- ) {  // check shapes from front to back
			Shape s = (Shape)shp.get(i);
			if (s.containsPoint(x,y)) {
				shapeBeingDragged = s;
				prevDragX = x;
				prevDragY = y;
				if (e.isShiftDown()) {  // Bring the shape to the front by moving it to
					shp.remove(s);      //       the end of the list of shapes.
					shp.add(s);
					repaint();  // repaint canvas to show shape in front of other shapes
				}
				return;
			}
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
		int top = shp.size();
	     for (int i = 0; i < top; i++) {
	     Shape s = (Shape)shp.get(i);
	     if (s.containsPoint(x,y)) {
	    	 s.setColor(Color.BLACK);
	     }
	     }
	     if (shapeBeingDragged != null) {
	    	 shapeBeingDragged.moveBy(x - prevDragX, y - prevDragY);
	    	 if ( shapeBeingDragged.left >= getSize().width || shapeBeingDragged.top >= getSize().height ||
               shapeBeingDragged.left + shapeBeingDragged.width < 0 ||
               shapeBeingDragged.top + shapeBeingDragged.height < 0 ) {  // shape is off-screen
	    		 shp.remove(shapeBeingDragged);  // remove shape from list of shapes
	    	 }
	    	 shapeBeingDragged = null;
	    	 repaint();
	     }
 }
	public void mouseDragged(MouseEvent e) {
		 // User has moved the mouse.  Move the dragged shape by the same amount.
        int x = e.getX();
        int y = e.getY();
        if (shapeBeingDragged != null) {
           shapeBeingDragged.moveBy(x - prevDragX, y - prevDragY);
           prevDragX = x;
           prevDragY = y;
           repaint();      // redraw canvas to show shape in new position
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
}

	
