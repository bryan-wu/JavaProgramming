import javax.swing.*;

import java.awt.*;


/**
 * Graphs and animates the sine function in red and the cosine function in blue,
 * both in the same drawing area. Draws the x and y axis. Also, draws "tick"
 * marks along the x axis at PI/4, PI/2, 3*PI/4, and 2*PI. Draw axes and tick
 * marks in black.
 * 
 * The drawing area is 600 by 400. (X=0, Y=0) is the top left corner.
 * 
 * @author Bryan Wu
 * @version 12/12/14
 * @author Period - 7
 * @author Assignment - Ex4_SinCosWaveAnim
 * @author Sources - none
 */
public class Ex4_SinCosWaveAnim extends AnimationBase
{
    public void init()
    {
        setBackground( Color.WHITE );
        this.setMillisecondsPerFrame( 10 );

        // add additional initialization code if necessary
    }


    public void drawFrame( Graphics gr )
    {
        super.drawFrame( gr );
        int width = getWidth();
        int height = getHeight();
        double inc = 1.0 / 32.0;

        int offset = (int)( getFrameNumber() % width );

        gr.drawLine( width / 2, 0, width / 2, height ); // y axis
        gr.drawLine( 0, height / 2, width, height / 2 ); // x axis

        gr.drawLine( 1, 6 * height / 14, 1, 8 * height / 14 );// PI/4

        // PI/2, 3*PI/4,
        // and 2*PI
        gr.drawLine( width / 8, 6 * height / 14, width / 8, 8 * height / 14 );
        gr.drawLine( width / 4, 6 * height / 14, width / 4, 8 * height / 14 );
        gr.drawLine( 3 * width / 8,
            6 * height / 14,
            3 * width / 8,
            8 * height / 14 );
        gr.drawLine( 4 * width / 8,
            6 * height / 14,
            4 * width / 8,
            8 * height / 14 );
        gr.drawLine( 5 * width / 8,
            6 * height / 14,
            5 * width / 8,
            8 * height / 14 );
        gr.drawLine( 6 * width / 8,
            6 * height / 14,
            6 * width / 8,
            8 * height / 14 );
        gr.drawLine( 7 * width / 8,
            6 * height / 14,
            7 * width / 8,
            8 * height / 14 );
        gr.drawLine( width - 1, 6 * height / 14, width - 1, 8 * height / 14 );

        for ( double x = -2 * Math.PI; x <= 2 * Math.PI; x = x + inc )
        {
            double y = Math.sin( x );
            double nextx = x + inc;
            double nexty = Math.sin( nextx );

            int startX = (int)( x * ( width - 1 ) / ( 2 * Math.PI ) );
            int startY = (int)( y * ( height - 1 ) / 2.0 + ( height - 1 ) / 2.0 );
            int endX = (int)( nextx * ( width - 1 ) / ( 2 * Math.PI ) );
            int endY = (int)( nexty * ( height - 1 ) / 2.0 + ( height - 1 ) / 2.0 );
            gr.setColor( Color.RED );
            gr.drawLine( startX + offset, startY, endX + offset, endY );
            offset += inc;
        }
        for ( double x1 = -2 * Math.PI; x1 <= 2 * Math.PI; x1 = x1 + inc )
        {
            double y1 = Math.cos( x1 );
            double nextx1 = x1 + inc;
            double nexty1 = Math.cos( nextx1 );

            int startX1 = (int)( ( x1 ) * ( width - 1 ) / ( 2 * Math.PI ) );
            int startY1 = (int)( ( y1 ) * ( height - 1 ) / 2.0 + ( height - 1 ) / 2.0 );
            int endX1 = (int)( ( nextx1 ) * ( width - 1 ) / ( 2 * Math.PI ) );
            int endY1 = (int)( ( nexty1 ) * ( height - 1 ) / 2.0 + ( height - 1 ) / 2.0 );
            gr.setColor( Color.BLUE );
            gr.drawLine( startX1 + offset, startY1, endX1 + offset, endY1 );
            offset += inc;
        }
    }
}