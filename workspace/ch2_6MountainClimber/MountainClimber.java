import kareltherobot.*;

/**
 *  A MountainClimber robot climbs a mountain and then plant a flag,
 *  represented by a beeper, on the summit; The robot then descends the
 *  other side of the mountain. The MountainClimber starts with the
 *  flag-beeper in the beeper-bag
 *
 *  @author  Bryan Wu
 *  @version 8/22/14
 *  @author  Period: 7
 *  @author  Assignment: KJR Chapter 2, Problem 6 - MountainClimber
 *
 *  @author  Sources: none
 */
public class MountainClimber extends UrRobot
{
    public MountainClimber( int st, int ave, Direction dir, int beeps )
    {
       super( st, ave, dir, beeps );
    }

    public void wheeeee()
    {
        turnLeft();
        while (true)
        {
            move();
        }
    }
}
