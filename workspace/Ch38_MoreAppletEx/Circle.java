import javax.swing.*;

import java.awt.*;
import java.awt.geom.*;
import java.util.Random;


/**
 * Draw 10 complete big circles randomly positioned in the applet. To draw
 * complete circles, test that each randomly generated center is further from
 * the edge than the radius of a circle.
 * 
 * @author Bryan Wu
 * @version 12/1/14
 * @author Period - 7
 * @author Assignment - Ch38_MoreAppletEx
 * 
 * @author Sources - none
 */
public class Circle extends JApplet
{

    // variables
    private int x, y, radius;

    private Color color;


    // constructors
    public Circle()
    {
        x = 0;
        y = 0;
        radius = 0;
        color = Color.black;
    }


    public Circle( int x, int y, int radius )
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
        color = Color.black;
    }


    // methods
    void draw( Graphics gr )
    {
        int ulX = x - radius; // X of upper left corner of rectangle
        int ulY = y - radius; // Y of upper left corner of rectangle
        gr.setColor( color );
        gr.drawOval( ulX, ulY, 2 * radius, 2 * radius );
    }


    // change the center of the circle to a new X and Y
    void setPosition( int newX, int newY )
    {
        x = newX;
        y = newY;
    }


    // chage the radius of the circle
    void setRadius( int newR )
    {
        radius = newR;
    }


    // chage the color of the circle
    void setColor( Color newC )
    {
        color = newC;
    }
}
