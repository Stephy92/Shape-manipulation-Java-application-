import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Triangle extends Shape {

	public void draw(Graphics g) {
        /*g.setColor(color);
        g.fillRect(left,top,width,height);*/
        g.setColor(getColor());
        //g.drawPolygon(new int[] {10, 20, 30}, new int[] {100, 20, 100}, 3);
        Point point2 = new Point(left+width,top);
        Point point3 = new Point(left+(width/2),top - height);
        g.drawLine(left,top,point2.x,point2.y);
        g.drawLine(left,top,point3.x,point3.y);
        g.drawLine(point2.x,point2.y,point3.x,point3.y);

    }
}