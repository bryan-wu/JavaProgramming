import javax.swing.*;

import java.awt.*;


/**
 * Magic Lines 2
 * 
 * @author Bryan Wu
 * @version 12/5/14
 * 
 * @author Period - 7
 * @author Assignment - Ch38BEx1_MarchingLines1
 * 
 * @author Sources - none
 */
public class Ch38BEx2_MarchingLines2 extends AnimationBase
{
    /**
     * This routine is called by the system when the applet is first created.
     */
    public void init()
    {
        // add initialization code if necessary
    }


    /**
     * This routine is called by the animation framework every time a new frame
     * needs to be drawn.
     * 
     * For this animation, lines move to the end of the screen from the left to
     * right and move from top to bottom in a filled rectangle at the center of
     * the screen
     */
    public void drawFrame( Graphics g )
    {
        super.drawFrame( g );
        /**
         * Draw one frame in the animation by filling in the background with a
         * solid red and then drawing a set of nested black rectangles. The
         * frame number tells how much the first rectangle is to be inset from
         * the borders of the applet.
         *
         * @param g
         *            graphics context
         */
        int width; // Width of the applet, in pixels.
        int height; // Height of the applet, in pixels.

        width = getWidth(); // Find out the size of the drawing area.
        height = getHeight();

        int inset;

        int red = 245;
        int green = 147;
        int blue = 214;
        Color pink = new Color( red, green, blue );

        g.setColor( pink );
        g.fillRect( 0, 0, width, height );

        inset = getFrameNumber() % 10; // Get the inset for the outermost line.

        g.setColor( Color.white );

        while ( inset <= width )
        {
            g.drawLine( inset, 0, inset, height );
            inset += 10;// Lines are 10 pixels apart.
        }

        // inner rectangle begins here
        int width2 = width / 2; // Find out the size of the drawing area.
        int height2 = height / 2;

        int inset2;

        g.setColor( Color.white );
        g.fillRect( width / 4, height / 4, width2, height2 );

        inset2 = getFrameNumber() % 10 + height / 4; // Get the inset for the
                                                     // outermost line.
        g.setColor( pink );
        while ( inset2 <= 3 * height / 4 )
        {
            g.drawLine( width / 4, inset2, 3 * width / 4, inset2 );
            inset2 += 10;// Lines are 10 pixels apart.
        }
    }
}