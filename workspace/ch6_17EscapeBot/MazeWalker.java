import kareltherobot.*;


/**
 * Provides followWallRight() instruction
 *
 * @author Bryan Wu
 * @version Sep 15, 2014
 * @author Period: 7
 * @author Assignment: ch5_9MazeWalker
 *
 * @author Sources: none
 */
public class MazeWalker extends SmartBot
{
    /**
     * Default Robot constructor.
     * 
     * @param st
     *            initial street
     * @param av
     *            initial avenue
     * @param dir
     *            direction this robot is facing
     * @param numBeepers
     *            number of beepers this robot has in its beeper bag
     */
    public MazeWalker( int st, int av, Direction dir, int numBeepers )
    {
        super( st, av, dir, numBeepers );
    }


    /**
     * precondition: there is a wall directly to the right of this robot
     * postcondition: moves along the wall one step keeping its position so that
     * the wall remains on its right
     */
    public void followWallRight()
    {
        // if (!frontIsClear())
        // {
        // turnLeft();
        // }
        // else
        // {
        // move();
        // if (rightIsClear())
        // {
        // turnRight();
        // move();
        // if (rightIsClear())
        // {
        // turnRight();
        // move();
        // }
        // }
        // }
        //
        while ( frontIsClear() )
        {
            while ( nextToABeeper() )
            {
                pickBeeper();
            }
            move();
        }

    }
}