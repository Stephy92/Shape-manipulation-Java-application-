import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Circle extends draw
{
	 Random rd = new Random();
	 int x = rd.nextInt(360);
	 int y = rd.nextInt(360);
	 public Circle(Color shapeColor)
		{
			super(shapeColor);
		}
		
	public void shapes(Graphics g) 
	{
		g.setColor(getColor());
		g.drawOval(x, y, 60, 60);
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
