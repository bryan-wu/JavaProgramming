import javax.swing.*;

import java.awt.*;
import java.awt.geom.*;


/**
 * Draw Cocentric Circles using JApplet.
 * 
 * @author Bryan Wu
 * @version 11/25/14
 * @author Period - 7
 * @author Assignment - Ch37_AppletEx
 * @author Sources - none
 */
public class ConcentricCircles extends JApplet
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
            setBackground( Color.WHITE );

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

            int radius = 20;
            int count = 0;
            int widthIncrease = 0;
            int heightIncrease = 0;

            while ( count < 10 )
            {
                gr.drawOval( ( width / 2 - ( radius + widthIncrease ) ),
                    ( height / 2 - ( radius + heightIncrease ) ),
                    ( radius + heightIncrease ) * 2,
                    ( radius + heightIncrease ) * 2 );
                count++;
                widthIncrease = widthIncrease + 10;
                heightIncrease = heightIncrease + 10;
            }
        }
    }
}
