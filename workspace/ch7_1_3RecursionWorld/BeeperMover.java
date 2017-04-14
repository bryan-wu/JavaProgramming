import kareltherobot.*;
import java.awt.Color;


/**
 * BeeperMover class that will recursively do beeper-moving task.
 *
 * @author bwu623
 * @version Sep 26, 2014
 * @author Period: TODO
 * @author Assignment: ch7_1_3RecursionWorld
 *
 * @author Sources: TODO
 */
public class BeeperMover extends SmartBot
{
    /**
     * @param st
     * @param av
     * @param dir
     * @param beeps
     * @param badge
     */
    public BeeperMover( int st, int av, Direction dir, int beeps, Color badge )
    {
        super( st, av, dir, 0, badge );
    }


    /**
     * Complete beeper moving task by picking up all beepers and transfer the
     * beepers north the number of streets corresponding to the number of
     * beepers picked up
     */
    public void moveBeepersNorth()
    {
        findStart();
        pickAndTranslateSelfToTheNorth();
        turnLeft();
        move();
        dropRow();
    }


    /**
     * Move to first beeper
     */
    private void findStart()
    {
        if (!nextToABeeper())
        {
            move();
            findStart();
        }
    }


    /**
     * Pick up beepers and move corresponding number
     */
    private void pickAndTranslateSelfToTheNorth()
    {
        if (!nextToABeeper())
        {
            turnLeft();
            return;
        }
        pickBeeper();
        move();
        pickAndTranslateSelfToTheNorth();
        move();
    }


    /**
     * Put down beepers.
     */
    private void dropRow()
    {
        if (!anyBeepersInBeeperBag())
        {
            return;
        }
        putBeeper();
        move();
        dropRow();
    }
}
