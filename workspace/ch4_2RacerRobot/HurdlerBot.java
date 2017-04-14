import kareltherobot.*;


/**
 * Hurdler Bot
 * 
 * @author Bryan Wu
 * @version 2/23/15
 *
 * @author Period - 7
 * @author Assignment - ch4_2RacerRobot
 *
 * @author Sources - Dave Wittry
 */
public class HurdlerBot extends AbstractHurdlerRobot
{
    public HurdlerBot( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }


    public void up()
    {
        super.up();
    }


    public void down()
    {
        super.down();
    }


    public void over()
    {
        move();
    }

}