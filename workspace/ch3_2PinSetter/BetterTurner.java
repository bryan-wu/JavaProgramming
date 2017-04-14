import kareltherobot.*;


/**
 * BetterTurner lets me use extremely advanced methods: turnRight() and
 * turnAround(). The extension streamlines the process by eliminating the need
 * to remake the methods.
 * 
 * 
 * @author Bryan Wu
 * @version Aug 28, 2014
 * @author Period: 7
 * @author Assignment: ch3_2PinSetter
 *
 * @author Sources: none
 */
public class BetterTurner extends UrRobot
{
    /**
     * Default constructor for an UrRobot
     * 
     * @param st    street
     * @param av   avenue
     * @param dir   direction robot is facing
     * @param beeps number of beepers
     */
    public BetterTurner( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }


    /**
     * Method for turning right or 270 degrees.
     */
    public void turnRight()
    {
        turnLeft();
        turnLeft();
        turnLeft();
    }


    /**
     * Method for turning around or 180 degrees.
     */
    public void turnAround()
    {
        turnLeft();
        turnLeft();
    }
}