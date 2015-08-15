import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Oval extends draw
{
	  Random rd = new Random();
		
	  	int maxX = 450;
		int minX = 0;

		int maxY = 250;
		int minY = 80;

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
		int x = rd.nextInt((maxX - minX) + 1) + minX;
		int y = rd.nextInt((maxY - minY) + 1) + minY;
	    
		public Oval(Color shapeColor)
		{
			super(shapeColor);
		}
		
	public void shapes(Graphics g) 
	{
		g.setColor(getColor());
		g.drawOval(x, y, 90, 60);
	}
	 public int getX(){
		 return this.x;
	 }
	 public int getY(){
		 return this.y;
	 }
	 public int getWidth(){
		 return (60);
	 }
	 public int getHeight(){
		 return (60);
	 }
}
