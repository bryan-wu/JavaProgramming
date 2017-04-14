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
public class RandCircles extends JApplet
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

            int count = 1;

            
            Circle circ = new Circle();
            Random rand = new Random();
            circ.setRadius( 5 );
            while ( count <= 10 )
            {
                int x = rand.nextInt( width - 10 ) + 5;
                int y = rand.nextInt( height - 10 ) + 5;
                // int x = (int)( Math.random() * ( width - 2 * radius ) ) +
                // newR;
                // // limit random x and random y coordinates to create circle
                // // within window
                // int y = (int)( Math.random() * ( height - 2 * radius ) )
                // + radius;

                circ.setPosition( x, y );
                circ.draw( gr );

                count++;
            }
        }
    }
}
