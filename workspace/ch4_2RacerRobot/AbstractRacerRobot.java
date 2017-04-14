import kareltherobot.*;


/**
 * Abstract class for racer robot.
 * 
 * @author Bryan Wu
 * @version 2/23/15
 *
 * @author Period - 7
 * @author Assignment - ch4_2RacerRobot
 *
 * @author Sources - Dave Wittry
 */
public abstract class AbstractRacerRobot extends BetterTurner
{
    public AbstractRacerRobot( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }


    public void runRace()
    {
        while ( !nextToABeeper() )
        {
            raceStride();
        }
        // in which each robot races to the finish line (a beeper)
    }


    public abstract void raceStride();
    // in which each robot encounters obstacles along the way
}
