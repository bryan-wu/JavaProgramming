import kareltherobot.*;


/**
 * PinSetter Driver.
 *
 * @author Bryan Wu
 * @version 8/29/14
 * @author Period: 7
 * @author Assignment: ch3_11Gardener
 *
 * @author Sources: Dave Wittry
 */
public class GardenerDriver implements Directions
{
    /**
     * Test method - creates and invokes a Gardener.
     * 
     * @param args
     *            command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        Gardener bot = new Gardener( 2, 2, South, 28 );

        bot.plantGarden();
        bot.turnOff();
    }

    static
    {
        World.reset();
        World.readWorld( "plus.wld" );
        World.setDelay( 10 );
        World.setVisible( true );
    }
}
