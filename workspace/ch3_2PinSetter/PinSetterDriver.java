import kareltherobot.*;


/**
 * This is the driver for the robot.
 * 
 * @author Bryan Wu
 * @version Aug 28, 2014
 * @author Period: 7
 * @author Assignment: ch3_2PinSetter
 *
 * @author Sources: none
 */
public class PinSetterDriver implements Directions
{
    public static void main( String args[] )
    {
        PinSetter bot = new PinSetter( 1, 5, North, 10 );
        bot.setPins();
        bot.turnOff();
    }

    static
    {
        World.reset();
        World.readWorld( "10x10.wld" );
        World.setDelay( 15 );
        World.setVisible( true );
    }
}
