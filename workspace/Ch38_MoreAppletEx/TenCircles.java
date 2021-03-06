import javax.swing.*;

import java.awt.*;
import java.awt.geom.*;
import java.util.Random;


/**
 * Draw 10 complete circles randomly positioned in the applet, with random radii
 * in the range 5 to 25 pixels. Randomly pick each circle's color (use a random
 * int and nested if statements.)
 * 
 * @author Bryan Wu
 * @version 12/1/14
 * @author Period - 7
 * @author Assignment - Ch38_MoreAppletEx
 * 
 * @author Sources - none
 */
public class TenCircles extends JApplet
{
    /**
     * The applet's init() method creates the display panel and adds them to the
     * applet.
     */
    public void init()
    {
        Display displayPanel = new Display();

        JPanel content = new JPanel();
        content.setLayout( new BorderLayout() );
        content.add( displayPanel, BorderLayout.CENTER );
        setContentPane( content );
    }


    // Defines the display panel.
    public class Display extends JPanel
    {
        public void paintComponent( Graphics gr )
        {
            super.paintComponent( gr );

            Container applet = getContentPane();
            int width = applet.getWidth();
            int height = applet.getHeight();

            gr.setColor( Color.BLUE );
            gr.drawRect( 0, 0, width - 1, height - 1 );
            String str = "";

            Font curFont = applet.getFont();
            FontMetrics curFontMetrics = applet.getFontMetrics( curFont );
            Rectangle2D r2d = curFontMetrics.getStringBounds( str, gr );

            int strWidth = (int)( (Rectangle2D.Float)r2d ).width;
            int strHeight = (int)( (Rectangle2D.Float)r2d ).height;
            gr.setColor( Color.BLACK );
            gr.drawString( str,
                ( width - strWidth ) / 2,
                ( height + strHeight ) / 2 );

            Color randomColor;
            int r, g, b;
            Circle circ = new Circle();
            Random rand = new Random();
            int count = 1;
            while ( count <= 10 )
            {
                int radius = rand.nextInt( 20 ) + 5;
                circ.setRadius( radius );
                r = rand.nextInt( 257 );
                g = rand.nextInt( 257 );
                b = rand.nextInt( 257 );
                // random colors!!! 256*256*256
                randomColor = new Color( r, g, b );
                circ.setColor( randomColor );

                int x = rand.nextInt( width - 2 * radius ) + radius;
                int y = rand.nextInt( height - 2 * radius ) + radius;

                circ.setPosition( x, y );
                circ.draw( gr );

                count++;
            }

        }

    }
}
