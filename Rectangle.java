import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.*;

public class Rectangle extends draw {
    Random rd = new Random();
		
	int x = rd.nextInt(400);
	int y = rd.nextInt(200);
	 
	public Rectangle(Color shapeColor)
	{
		super(shapeColor);
	}
	
	public void shapes(Graphics g)
    {
    	g.setColor(getColor());
		g.drawRect(x,y,100,50);
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
