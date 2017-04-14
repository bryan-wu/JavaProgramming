import kareltherobot.*;


/**
 * Sprinter Bot.
 * 
 * @author Bryan Wu
 * @version 2/23/15
 *
 * @author Period - 7
 * @author Assignment - ch4_2RacerRobot
 *
 * @author Sources - Dave Wittry
 */
public class SprinterBot extends AbstractRacerRobot
{
    public SprinterBot( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }


    public void raceStride()
    {
        while ( !nextToABeeper() )
        {
            move();
        }
    }

}
