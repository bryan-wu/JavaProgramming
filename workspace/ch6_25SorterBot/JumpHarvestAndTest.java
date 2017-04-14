import kareltherobot.*;


public class JumpHarvestAndTest extends SmartBot
{
    /**
     * Default SmartBot constructor.
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
    public JumpHarvestAndTest( int st, int av, Direction dir, int numBeepers )
    {
        super( st, av, dir, numBeepers );
    }


    /**
     * Sort columns for lowest to highest.
     */
    public void sortThemAll()
    {
        // goToEndOfRow();
        moveToNextUnfinishedRow();
        clearRow();
        while ( anyBeepersInBeeperBag() )
        {
            goToOrigin();
            returnToClearedRow();
            sortRow();
            turnAround();
            goBackToSortedBeepers();
            moveToNextUnfinishedRow();
            clearRow();
        }
    }


    /**
     * Return to Origin.
     */
    public void goToOrigin()
    {
        while ( frontIsClear() ) // check
        {
            move();
        }
        faceSouth();
        while ( frontIsClear() )
        {
            move();
        }
        faceEast();
    }


    /**
     * Pick up all the beepers in the row.
     */
    public void clearRow()
    {
        while ( frontIsClear() )
        {
            while ( nextToABeeper() )
            {
                pickBeeper();
            }
            move();
        }
        while ( nextToABeeper() )
        {
            pickBeeper();
        }
    }


    /**
     * Go back to row that was just cleared.
     */
    public void returnToClearedRow()
    {
        goToEndOfRow();
        while ( nextToABeeper() )
        {
            move();
        }
        turnLeft();
    }


    /**
     * Put beepers in order.
     */
    public void sortRow()
    {
        while ( anyBeepersInBeeperBag() )
        {
            putBeeper();
            if ( frontIsClear() )
            {
                move();
            }
        }

        while ( anyBeepersInBeeperBag() )
        {
            putBeeper();
        }

    }


    /**
     * Move to the end of the row.
     */
    public void goToEndOfRow()
    {
        while ( nextToABeeper() )
        {
            move();
        }
        turnAround();
        move();
        turnRight();
    }


    /**
     * Move to the next unfinished row and face West.
     */
    public void moveToNextUnfinishedRow()
    {
        while ( nextToABeeper() )
        {
            move();
        }
        turnAround();
        move();
        turnRight();
        move();
        turnLeft();
    }


    /**
     * Return to beginning of sorted row.
     */
    public void goBackToSortedBeepers()
    {
        while ( !nextToABeeper() )
        {
            move();
        }
    }


    /**
     * Finish task.
     */
    public void moveToEnd()
    {
        while ( frontIsClear() )
        {
            move();
        }
    }
}