import kareltherobot.*;


/**
 * Racer Robot Test.
 * 
 * @author Bryan Wu
 * @version 2/24/15
 *
 * @author Period - 7
 * @author Assignment - ch4_2RacerRobot
 *
 * @author Sources - Dave Wittry
 */
public class RacerRobotTest implements Directions
{
    public static void main( String args[] )
    {
        AbstractRacerRobot sprinterBot = new SprinterBot( 1, 1, East, 0 );
        AbstractRacerRobot hurdlerBot = new HurdlerBot( 3, 1, East, 0 );
        AbstractRacerRobot highHurdlerBot = new HighHurdlerBot( 6, 1, East, 0 );
        AbstractRacerRobot steepleBot = new SteepleChaserBot( 12, 1, East, 0 );

        sprinterBot.runRace();
        hurdlerBot.runRace();
        highHurdlerBot.runRace();
        steepleBot.runRace();
    }

    static
    {
        World.reset();
        World.readWorld( "ch4_2.wld" );
        World.setTrace( false );
        World.setDelay( 5 );
        World.setVisible( true );
    }
}
