import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Path2DExample extends draw {
	    
	Rectangle rec1 = new Rectangle();
	Random rd = new Random();
			
	int maxX = 450;
	int minX = 0;
	int maxY = 250;
	int minY = 80;

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	int x = rd.nextInt((maxX - minX) + 1) + minX;
	int y = rd.nextInt((maxY - minY) + 1) + minY;
	
		 
	public Path2DExample(Color shapeColor)
	{
		super(shapeColor);
	}
		
	public void shapes(Graphics g)
    {
    	rec1.setLocation(x, y);
    	g.setColor(getColor());
		//g.drawRect(x,y,100,50);
		g.drawRect(rec1.x, rec1.y, 100, 50);

    }
	 public int getX(){
		 return this.x;
	 }
	 public int getY(){
		 return this.y;
	 }
	 public int getWidth(){
		 return (100);
	 }
	 public int getHeight(){
			 return (50);
	 }
	}