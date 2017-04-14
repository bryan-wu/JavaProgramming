import java.awt.*;

/**
 * This applet is an animation showing a set of moving, nested
 * rectangles that seem to move perpetually towards the center
 * of the applet. The rectangles are drawn in black on a red background.
 * This applet depends on SimpleAnimationApplet.java.
 *
 * @author     George Peck
 * @created    February 1, 2002
 */
public class MovingRects extends SimpleAnimationApplet2
{

    /**
     * Draw one frame in the animation by filling in the background
     * with a solid red and then drawing a set of nested black
     * rectangles.  The frame number tells how much the first
     * rectangle is to be inset from the borders of the applet.
     *
     * @param  g  graphics context
     */
    public void drawFrame( Graphics g )
    {
        int width;     // Width of the applet, in pixels.
        int height;    // Height of the applet, in pixels.

        // Gap between borders of applet and a rectangle.
        //   The inset for the outermost rectangle goes from 0 to
        //   14 then back to 0, and so on, as the frameNumber varies.    
        int inset;

        // Gap between borders of applet and a rectangle.
        //   The inset for the outermost rectangle goes from 0 to
        //   14 then back to 0, and so on, as the frameNumber varies.
        int rectWidth;

        int rectHeight; // The size of one of the rectangles that are drawn.

        width = getWidth();   // find out the size of the drawing area
        height = getHeight();

        g.setColor( Color.red );    // fill the frame with red
        g.fillRect( 0, 0, width, height );

        g.setColor( Color.black );// switch color to black

        inset = getFrameNumber() % 15;      // get the inset for the outermost rect

        rectWidth = width - 2 * inset - 1;  // set size of the outermost rect
        rectHeight = height - 2 * inset - 1;

        while ( rectWidth >= 0 && rectHeight >= 0 )
        {
            g.drawRect( inset, inset, rectWidth, rectHeight );
            inset += 15;             // rects are 15 pixels apart
            rectWidth -= 30;         // width decreases by 15 pixels on left and 15 on right
            rectHeight -= 30;        // height decreases by 15 pixels on top and 15 on bottom
        }
    }// end drawFrame()
}

