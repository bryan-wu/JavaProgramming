import kareltherobot.*;

/**
 *  Driver for the Figure8 class
 *
 *  @author  Bryan Wu
 *  @version 08/25/14
 *  @author Period: 7
 *  @author Assignment: Figure8
 *
 *  @author Sources: Dave Wittry
 */
public class Figure8Driver implements Directions
{
    /**
     * Driver to make Karel walk a figure-8 pattern.
     * 
     * @param args command-line arguments not used
     */
    public static void main( String args[] )
    {
       Figure8 eight = new Figure8( 3, 5, North, 2 ); // TODO: declare a Figure8 named eight
        eight.doFigure8();  // TODO: invoke eights's doFigure8 method
        eight.turnOff();    // eight.turnOff();         
    }

    static
    {
        World.reset();
        World.readWorld( "ch2_9.wld" );
        World.setDelay( 10 );
        World.setVisible( true );
    }
}
