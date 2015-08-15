import javax.swing.*;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
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

public class TestMain extends JFrame implements MouseMotionListener, MouseListener{ 

	Color currentColor = new Color(0,0,0);
	//private Graphics g;
	public draw dr1;
	int tempX;
	int tempY;
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JButton add = new JButton("Add");
	JButton delete = new JButton("Delete");
	JButton align = new JButton("Align");
	JButton clr = new JButton("Set Color");
	String [] Shape = {"Rectangle","Oval","Cirlce","Round Rectangle", "Triangle"};
	JComboBox ShapeTitle = new JComboBox(Shape);
	//int[] area;
	Graphics g;
	/*Rectangle currentObject;
	Oval currentOval;
	*/
	ArrayList<Integer> rect = new ArrayList<Integer>();
	ArrayList<Integer> cir = new ArrayList<Integer>();
	ArrayList<Integer> current = new ArrayList<Integer>();
	
	Rectangle rect1 = new Rectangle(0,0,100,50);
	int preX, preY;
	boolean isFirstTime = true;
	Rectangle area;
	boolean pressOut = false;
	  
	public TestMain (){
		super ("Simple Shape");
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		
		//Add buttons into panel
		p1.add(add);
		p1.add(delete);
		p1.add(align);
		p1.add(ShapeTitle);
		p1.add(clr);
		//p1.setLayout();
				
		p2.setBackground(Color.WHITE);
		//add panel into container
		c.add(p1, BorderLayout.NORTH);
		c.add(p2, BorderLayout.CENTER);
		
		//add button listener and action for add, delete, and also align button
		ButtonListener b1 = new ButtonListener();
		add.addActionListener(b1);
		delete.addActionListener(b1);
		align.addActionListener(b1);
	   
		//add button listener and action for color button
		colorButtonListerner btnColorFunction = new colorButtonListerner();
		clr.addActionListener(btnColorFunction);
	   
		//add mouse listener and motion
		addMouseMotionListener(this);
		addMouseListener(this);
		
		//set frame settings
		setBackground(Color.white);
		this.pack();
	    this.setSize(600,300);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);
	    this.setResizable(false);
	    
	    
	}
	
	//function of button listener and what action its take 
	private class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String b2 = (String) ShapeTitle.getSelectedItem();
			
		  
			//when click add button
			if(e.getSource()==add)
			{
				//will come out rectangle shape when choose Rectangle from combobox
				if(b2 == "Rectangle")
				{
					dr1 = new Path2DExample(currentColor);
					rect1.setLocation(dr1.getX(),dr1.getY());
					dr1.shapes(getGraphics());
					rect.add(dr1.getX());
					rect.add(dr1.getY());
					rect.add(dr1.getWidth());
					rect.add(dr1.getHeight());
					
				}
				//will come out oval shape when choose Oval from combobox
				else if(b2 == "Oval")
				{
					/*dr1 = new Circle(currentColor);
					dr1.shapes(getGraphics());
					cir.add(dr1.getX());
					cir.add(dr1.getY());
					cir.add(dr1.getWidth());
					cir.add(dr1.getHeight());
*/					
					
					dr1 = new Oval(currentColor);
					dr1.shapes(getGraphics());
					cir.add(dr1.getX());
					cir.add(dr1.getY());
					cir.add(dr1.getWidth());
					cir.add(dr1.getHeight());
				}
				
				else if(b2 == "Cirlce")
				{
					dr1 = new Circle(currentColor);
					dr1.shapes(getGraphics());
					cir.add(dr1.getX());
					cir.add(dr1.getY());
					cir.add(dr1.getWidth());
					cir.add(dr1.getHeight());

				}
				//will come out triangle shape when choose Triangle from combobox
				else if(b2 == "Triangle")
				{
					dr1 = new Triangle(currentColor);
					dr1.shapes(getGraphics());
					
				}
				else
					System.out.println("Nothing");
			}
			else if (e.getSource()==delete)
				repaint();
			else if(e.getSource()== align)
				System.out.println("Nothing");
							
		}
		
		
	}	
	
	//function of button listener and what action its take
	public class colorButtonListerner implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			colorActionPerformed(e);
		}
	}
	

	public void mousePressed(MouseEvent e) {
		preX = rect1.x - e.getX();
	    preY = rect1.y - e.getY();

	    if (dr1.getX() < e.getX() && dr1.getY() < e.getY() &&
	    		dr1.getX() + dr1.getWidth() > e.getX()  &&
	    		dr1.getY() + dr1.getHeight() > e.getY())
	    	{
	    	updateLocation(e);
	    	System.out.println("Clicked");
	    	}
	    else {
	      ShapeMover.label.setText("Drag it.");
	      pressOut = true;
	    }
	    System.out.println("Clicked");
		  }
	void updateSize(MouseEvent e) {
        /*int x = e.getX();
        int y = e.getY();
        currentRect.setSize(x - currentRect.x,
                            y - currentRect.y);
        updateDrawableRect(getWidth(), getHeight());
        Rectangle totalRepaint = rectToDraw.union(previouseRectDrawn); 
        repaint(totalRepaint.x, totalRepaint.y,
                totalRepaint.width, totalRepaint.height);*/
    }

	
	public static void main(String[] args){
		new TestMain();
	}

	public void mouseClicked(MouseEvent e) {
		
		// TODO Auto-generated method stub
		//x = dr1.getX() - e.getX();
		//y = dr1.getY() - e.getY();
		current.add(dr1.getX());
		current.add(dr1.getY());
		current.add(dr1.getWidth());
		current.add(dr1.getHeight());
		
		    if (dr1.getX() < e.getX() && dr1.getY() < e.getY() &&
		    		dr1.getX() + dr1.getWidth() > e.getX()  &&
		    		dr1.getY() + dr1.getHeight() > e.getY()){
		    	System.out.println("Clicked");
		    	for(Integer s: rect){
		    	if(current.contains(s)){
		    		/*g.setColor(Color.RED);
		    		g.fillRect(dr1.getX(), dr1.getY(), dr1.getWidth(), dr1.getHeight());
                    repaint();*/
		    		//g.fillRect(dr1.getX(), dr1.getY(), dr1.getWidth(), dr1.getHeight());
                    // repaint();
	                System.out.println("Clicked a Rectangle");
		    	}
		    	}
		    	for(Integer s: cir){
		    	if(current.contains(s)){
		    		
		    		currentColor = Color.RED;
		    		
		    		/*dr1 = new Circle(currentColor);
	                dr1.shapes(getGraphics());
		    		System.out.println("Clicked a Circle");*/
		    	}
		    	}repaint(dr1.getX(),dr1.getY(),dr1.getWidth(),dr1.getHeight());
	        }
		    else {
		        System.out.println("Clicked Nothing");
		       }
		  }
	
	

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		 if (dr1.getX() < e.getX() && dr1.getY() < e.getY() &&
		    		dr1.getX() + dr1.getWidth() > e.getX()  &&
		    		dr1.getY() + dr1.getHeight() > e.getY())
			 {System.out.println("Clicked"); 
			 updateLocation(e);}
		    else {
		    	System.out.println("Drag it.");
		      pressOut = false;
		    }System.out.println("Clicked");
	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if (!pressOut){
		      updateLocation(e);
		      System.out.println("Clicked");
		}
		    else
		     System.out.println("Drag it.");
		//System.out.println("Clicked");
	}

	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void colorActionPerformed(ActionEvent event)
	{
		Color selection = JColorChooser.showDialog(null, "Choose a color" , 
				Color.BLACK);
		if (selection != null)
		{
			clr.setForeground(selection);
			setCurrentColor(selection);
		}
	}
	
	public void setCurrentColor(Color shapeColor)
	{
		currentColor = shapeColor;
		
	}
/*	public void paintComponent(Graphics g) {
		
        int width = dr1.getWidth();
        int height = dr1.getHeight();
        int x = dr1.getX();
        int y = dr1.getY();
        g.setColor(currentColor);
        g.drawRect(x,y,width,height);
       
    }*/
	 public void paint(Graphics g) {
		    update(g);
		  }

	 public void update(Graphics g) {
		    Graphics2D g2 = (Graphics2D) g;
		    Dimension dim = getSize();
		    int w = (int) dr1.getWidth();
		    int h = (int) dr1.getHeight();
		    //g2.setStroke(new BasicStroke(8.0f));

		    if (isFirstTime) {
		      area = new Rectangle(dim);
		      rect1.setLocation(dr1.getX(),dr1.getY());
		      isFirstTime = false;
		    }

		    // Clears the rectangle that was previously drawn.
		    g2.setPaint(Color.white);
		    g2.fillRect(0, 0, w, h);

		    g2.setColor(Color.red);
		    g2.draw(rect1);
		    g2.setColor(Color.black);
		    g2.fill(rect1);
		  }

		  boolean checkRect() {
		    if (area == null) {
		      return false;
		    }

		    if (area.contains(rect1.x, rect1.y, 100, 50)) {
		      return true;
		    }
		    int new_x = rect1.x;
		    int new_y = rect1.y;

		    if ((rect1.x + 100) > area.getWidth()) {
		      new_x = (int) area.getWidth() - 99;
		    }
		    if (rect1.x < 0) {
		      new_x = -1;
		    }
		    if ((rect1.y + 50) > area.getHeight()) {
		      new_y = (int) area.getHeight() - 49;
		    }
		    if (rect1.y < 0) {
		      new_y = -1;
		    }
		    rect1.setLocation(new_x, new_y);
		    return false;
		  }
		  public void updateLocation(MouseEvent e) {
			    rect1.setLocation(preX + e.getX(), preY + e.getY());

			    if (checkRect()) {
			    	System.out.println(rect1.getX() + ", " + rect1.getY());
			    } else {
			    	System.out.println("drag inside the area.");
			    }

			    repaint();
			  }
}

