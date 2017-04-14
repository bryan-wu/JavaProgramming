import kareltherobot.*;
import java.awt.Color;


/**
 * Karpeter class that will do Carpeting task.
 *
 * @author bwu623
 * @version Sep 26, 2014
 * @author Period: TODO
 * @author Assignment: ch7_1_3RecursionWorld
 *
 * @author Sources: TODO
 */
public class Karpeter extends SmartBot
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
    public Karpeter( int st, int av, Direction dir, int beeps, Color badge )
    {
        super( st, av, dir, beeps, badge );
    }


    /**
     * Carpet the hallway.
     * 
     * @return
     */
    public int carpetHallway()
    {
        if ( nextToABeeper() )
        {
            return 0;
        }
        {
            if ( !frontIsClear() )
            {
                turnRight();
            }
            putBeeper();
            move();
        }
        return carpetHallway() + 1;
    }
}
