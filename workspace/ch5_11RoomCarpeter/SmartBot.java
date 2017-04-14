import kareltherobot.*;

/**
 *  Parent class of CarpetBot.
 *
 *  @author  Bryan Wu
 *  @version Sep 11, 2014
 *  @author  Period: 7
 *  @author  Assignment: ch5_11RoomCarpeter
 *
 *  @author  Sources: none
 */
public class SmartBot extends Robot
{
    /**
     * Default Robot constructor.
     * 
     * @param st         initial street
     * @param av         initial avenue
     * @param dir        direction this robot is facing
     * @param numBeepers number of beepers this robot has in its beeper bag
     */
    public SmartBot( int st, int av, Direction dir, int numBeepers )
    {
        super( st, av, dir, numBeepers );
    }

    /**
     * Change this robot's position 90 degrees to the right.
     */
    public void turnAround()
    {
        turnLeft();
        turnLeft();
    }

    /**
     * Change this robot's position 90 degrees to the right.
     */
    public void turnRight()
    {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    /**
     * Move this robot back one corner.
     */
    public void backUp()
    {
        turnAround();
        move();
        turnAround();
    }

    /**
     * @return leftIsClear
     */
    public boolean leftIsClear()
    {
        turnLeft();
        if (frontIsClear())
        {
            turnRight();
            return true;
        }
        turnRight();
        return false;
    }

    /**
     * @return rightIsClear
     */
    public boolean rightIsClear()
    {
        turnRight();
        if ( frontIsClear() ) 
        {
            turnLeft();
            return true;
        }
        turnLeft();
        return false;
    }
}