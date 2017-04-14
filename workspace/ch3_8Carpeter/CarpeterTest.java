import kareltherobot.*;


// TODO: complete comments

/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author Bryan Wu
 * @version Sep 4, 2014
 * @author Period: 7
 * @author Assignment: ch3_8Carpeter
 *
 * @author Sources: none
 */
public class CarpeterTest implements Directions
{
    /**
     * Test method - creates and invokes a Gardener.
     * 
     * @param args
     *            command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        CarpetLayer bot = new CarpetLayer( 9, 2, South, infinity );

        bot.layCarpet();
        bot.turnOff();
    }

    static
    {
        World.reset();
        World.readWorld( "carpeter.wld" );
        World.setDelay( 1 );
        World.setVisible( true );
    }
}
