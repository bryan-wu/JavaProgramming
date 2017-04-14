import kareltherobot.*;

/**
 * Utility class to extend the movement capabilities of the Robot base class.
 * 
 * @author G. Peck
 * @version 8/1/2003
 * 
 * @author Period - 1-7
 * @author Assignment - all
 * 
 * @author Sources - Joseph Bergin
 */
public class BetterTurner extends Robot
{
    public BetterTurner( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }

    /**
     * Turn right
     */
    public void turnRight()
    {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    /**
     * Turn around
     */
    public void turnAround()
    {
        turnLeft();
        turnLeft();
    }

}