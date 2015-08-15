import java.awt.*;

import javax.swing.JPanel;


public abstract class draw extends JPanel{
     public Color color;
    public draw(Color shapeColor) 
    {
    	setColor(shapeColor);
	}
	
	//public Shape()
	//{	
	//}
	
	public void setColor (Color c)
	{
		color = c;
	}
	
	public Color getColor()
	{
		return color;
	}
    
    
    public abstract void shapes(Graphics g);
    public abstract int getX();
    public abstract int getY();
    public abstract int getWidth();
    public abstract int getHeight();
    //public abstract int[] getArea();
}
