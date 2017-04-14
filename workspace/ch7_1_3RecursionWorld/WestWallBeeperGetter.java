import kareltherobot.*;
import java.awt.Color;


/**
 * WestWallBeeperGetter class that will pick up beeper at end of west wall.
 *
 * @author Bryan Wu
 * @version Sep 26, 2014
 * @author Period: 7
 * @author Assignment: ch7_1_3RecursionWorld
 *
 * @author Sources: none
 */
public class WestWallBeeperGetter extends SmartBot
{
    /**
     * @param st
     *            initial street
     * @param av
     *            initial avenue
     * @param dir
     *            direction this robot is facing
     * @param beeps
     *            number of beepers this robot has in its beeper bag
     * @param badge
     *            color of badge on chest of robot
     */
    public WestWallBeeperGetter(
        int st,
        int av,
        Direction dir,
        int beeps,
        Color badge )
    {
        super( st, av, dir, beeps, badge );
    }


    /**
     * Pick up beeper at west wall and move back.
     */
    public void getBeeper()
    {
        turnAround();
        pickUpBeeperAtWestWall();       
    }
    
    /**
     * Move to beeper at west wall.
     */
    public void pickUpBeeperAtWestWall()
    {
        if (!frontIsClear())
        {
            pickBeeper();
            turnAround();
            return;
        }
        if (frontIsClear())
        {
            move();
        }
        pickUpBeeperAtWestWall();
        move();
    }
}
