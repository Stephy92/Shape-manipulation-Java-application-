import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends draw {
	 	public int x;
	    public int y;
	    public Triangle(Color shapeColor)
		{
			super(shapeColor);
		}
		
    public void shapes(Graphics g)
    {
    	g.setColor(getColor());
    	g.drawPolygon(new int[] {10, 20, 30}, new int[] {100, 20, 100}, 3);
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
/*public class Triangle extends draw {
	 Random rd = new Random();
	 int[] x = {rd.nextInt(360),rd.nextInt(360),rd.nextInt(360)};
	 int[] y = {rd.nextInt(360),rd.nextInt(360),rd.nextInt(360)};
	 
   public void shapes(Graphics g)
   {
   	 
   	g.drawPolygon(x,y, 3);
   }
   public int getX(){
		 return this.x;
	 }
	 public int[] getY(){
		 return this.y;
	 }
}*/