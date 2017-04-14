import kareltherobot.*;


/**
 * Client class for SorterBot.
 *
 * @author Bryan Wu
 * @version Sep 18, 2014
 * @author Period: 7
 * @author Assignment: ch6_25SorterBot
 *
 * @author Sources: none
 */
public class SorterBotTester implements Directions
{
    /**
     * Instantiate a SorterBot and invoke its climbMountain method.
     * 
     * @param args
     *            command-line arguments not used
     */
    public static void main( String args[] )
    {
        SorterBot bot = new SorterBot( 1, 1, East, 0 );

        bot.sortThemAll();
        bot.turnOff();
    }

    static
    {
        World.reset();
        World.readWorld( "ch6_25.wld" );
        World.setDelay( 10 );
        World.setVisible( true );
    }
}
