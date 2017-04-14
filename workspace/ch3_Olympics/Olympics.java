import kareltherobot.*;

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  Bryan Wu
   @version 9/2/14

   @author  Period - 7
   @author  Assignment - ch3_Olympics

   @author  Sources - none
 */
public class Olympics implements Directions
{
    /**
     * Test method - creates and invokes a Triathlete.
     * 
     * @param args
     *            command-line arguments (not used)
     */
    public static void main( String args[] )
    {
        Triathlete ironman = new Triathlete( 4, 3, East, 0 );

        ironman.runRace();

        ironman.turnOff();
    }

    static
    {
        World.reset();
        World.readWorld( "triathlon.wld" );
        World.setDelay( 10 );
        World.setVisible( true );
    }
}
