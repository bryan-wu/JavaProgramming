import javax.swing.JApplet;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.geom.Rectangle2D;


/**
 * Draw 3 cocentric circles with JApplet
 * 
 * @author Bryan Wu
 * @version 11/24/14
 * @author Period - 7
 * @author Assignment - Ch36_Applets
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

            gr.drawString( str,
                ( width - strWidth ) / 2,
                ( height + strHeight ) / 2 );

            final int radius1 = 20;
            final int radius2 = 30;
            final int radius3 = 40;

            gr.setColor( Color.red );
            gr.drawOval( ( width / 2 - radius1 ),
                ( height / 2 - radius1 ),
                radius1 * 2,
                radius1 * 2 );
            gr.setColor( Color.green );
            gr.drawOval( ( ( width / 2 - radius2 ) ),
                ( ( height / 2 - radius2 ) ),
                radius2 * 2,
                radius2 * 2 );
            gr.setColor( Color.blue );
            gr.drawOval( ( ( width / 2 - radius3 ) ),
                ( ( height / 2 - radius3 ) ),
                radius3 * 2,
                radius3 * 2 );
        }
    }
}
