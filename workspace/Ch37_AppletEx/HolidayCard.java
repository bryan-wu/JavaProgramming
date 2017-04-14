import javax.swing.*;

import java.awt.*;
import java.awt.geom.*;


/**
 * Super awesome JApplet holiday card.
 * 
 * @author Bryan Wu
 * @version 11/25/14
 * @author Period - 7
 * @author Assignment - Ch37_AppletEx
 * @author Sources - none
 */
public class HolidayCard extends JApplet
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

            gr.setColor( Color.red );
            gr.drawRect( 0, 0, width - 1, height - 1 );
            String str = "Merry Christmas!";

            Font curFont = applet.getFont();
            FontMetrics curFontMetrics = applet.getFontMetrics( curFont );
            Rectangle2D r2d = curFontMetrics.getStringBounds( str, gr );

            int strWidth = (int)( (Rectangle2D.Float)r2d ).width;
            int strHeight = (int)( (Rectangle2D.Float)r2d ).height;
            gr.setColor( Color.black );
            gr.drawString( str,
                ( width - strWidth ) / 2,
                ( height + strHeight ) / 2 );

            // cap of christmas tree
            gr.setColor( Color.green );
            gr.drawLine( width / 2, height / 10, width / 4, height / 3 );
            gr.drawLine( width / 2, height / 10, 3 * width / 4, height / 3 );
            gr.drawLine( width / 4, height / 3, 3 * width / 4, height / 3 );
            gr.drawLine( 3 * width / 4, height / 3, 2 * width / 3, height / 3 );

            // 2nd christmas tree layer
            gr.drawLine( width / 2, 2 * height / 10, width / 4, height / 2 );
            gr.drawLine( width / 2, 2 * height / 10, 3 * width / 4, height / 2 );
            gr.drawLine( width / 4, height / 2, 3 * width / 4, height / 2 );

            // 3rd christmas tree layer
            gr.drawLine( width / 2, 3 * height / 8, width / 4, 2 * height / 3 );
            gr.drawLine( width / 2,
                3 * height / 8,
                3 * width / 4,
                2 * height / 3 );
            gr.drawLine( width / 4,
                2 * height / 3,
                3 * width / 4,
                2 * height / 3 );

            // tree trunk
            gr.setColor( Color.orange );
            gr.fillRect( width / 2 - width / 20,
                2 * height / 3,
                width / 10,
                height / 3 );

            Color randomColor;
            int R = (int)( Math.random() * 256 );
            int G = (int)( Math.random() * 256 );
            int B = (int)( Math.random() * 256 );
            randomColor = new Color( R, G, B );

            // ornaments
            gr.setColor( randomColor );
            gr.fillOval( width / 2, height / 2, 10, 10 );

            R = (int)( Math.random() * 256 );
            G = (int)( Math.random() * 256 );
            B = (int)( Math.random() * 256 );
            randomColor = new Color( R, G, B );
            gr.setColor( randomColor );
            gr.fillOval( width / 3, 3 * height / 5, 10, 10 );

            R = (int)( Math.random() * 256 );
            G = (int)( Math.random() * 256 );
            B = (int)( Math.random() * 256 );
            randomColor = new Color( R, G, B );
            gr.setColor( randomColor );
            gr.fillOval( 3 * width / 5, 6 * height / 10, 10, 10 );

            R = (int)( Math.random() * 256 );
            G = (int)( Math.random() * 256 );
            B = (int)( Math.random() * 256 );
            randomColor = new Color( R, G, B );
            gr.setColor( randomColor );
            gr.fillOval( 4 * width / 7, 3 * height / 8, 10, 10 );

            R = (int)( Math.random() * 256 );
            G = (int)( Math.random() * 256 );
            B = (int)( Math.random() * 256 );
            randomColor = new Color( R, G, B );
            gr.setColor( randomColor );
            gr.fillOval( width / 2, height / 8, 10, 10 );

            R = (int)( Math.random() * 256 );
            G = (int)( Math.random() * 256 );
            B = (int)( Math.random() * 256 );
            randomColor = new Color( R, G, B );
            gr.setColor( randomColor );
            gr.fillOval( 3 * width / 7, height / 3, 10, 10 );

            R = (int)( Math.random() * 256 );
            G = (int)( Math.random() * 256 );
            B = (int)( Math.random() * 256 );
            randomColor = new Color( R, G, B );
            gr.setColor( randomColor );
            gr.fillOval( 3 * width / 7, height / 6, 10, 10 );

            // star attempt
            Polygon poly = new Polygon(); // construct an empty Polygon

            poly.addPoint( 3 * width / 8, height / 10 ); // add a vertex (the
                                                         // leftmost)
            poly.addPoint( 5 * width / 8, height / 10 ); // add another vertex,
                                                         // in
            poly.addPoint( 3 * width / 8, height / 8 ); // counterclockwise
                                                        // order
            poly.addPoint( 5 * width / 8, height / 8 );
            poly.addPoint( width / 2, height / 12 );

            gr.setColor( Color.orange ); // set the pen color to red
            gr.fillPolygon( poly );
        }
    }
}
