import java.awt.*;


/**
 * This applet draws a red-and-black checkerboard. It is assumed that the size
 * of the applet is 160 by 160 pixels.
 * 
 * @author Bryan Wu
 * @version 12/9/14
 * @author Period - 7
 * @author Assignment - Ch41_forGraphics
 * @author Sources - none
 */
public class Checkerboard extends AnimationBase
{
    public void drawFrame( Graphics g )
    {
        super.drawFrame( g );
        resize( 160, 160 );

        int row, col;
        int x, y;
        y = 0;

        for ( row = 0; row < 8; row++ )
        {
            x = 0;

            for ( col = 0; col < 8; col++ )
            {
                if ( row % 2 == col % 2 )
                {
                    g.setColor( Color.red );
                }
                else
                {
                    g.setColor( Color.black );
                }
                g.fillRect( x, y, 20, 20 );
                x = x + 20;
            }
            y = y + 20;
        }
        // for each row on the checkerboard:
        // for each of the eight columns:
        // Compute x,y for the top-left corner of the square
        // if its a red square:
        // g.setColor(Color.red)
        // else
        // g.setColor(Color.black)
        // g.fillRect(x,y,20,20)
    }
}
