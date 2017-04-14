import kareltherobot.*;

/**
 *  Test the room carpeting ability of a RoomCarpeter Robot.
 *
 *  @author  Bryan Wu
 *  @version 9/11/14
 *
 *  @author  Period - 7
 *  @author  Assignment - ch5_11RoomCarpeter
 *
 *  @author  Sources - none
 */
public class CarpetBotTest implements Directions
{
    /**
     * Test method - creates and invokes a CarpetBot.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main( String args[] )
    {
        CarpetBot karel = new CarpetBot( 1, 1, East, 8 );

        karel.carpetRooms();

        karel.turnOff();
    }

    static
    {
        World.reset();
        World.readWorld( "ch5_11.wld" );
        World.setDelay( 10 );
        World.setVisible( true );
    }
}
