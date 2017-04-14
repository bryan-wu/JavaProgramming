import kareltherobot.*;


/**
 * SteepleChaser
 * 
 * @author Bryan Wu
 * @version 2/23/15
 *
 * @author Period - 7
 * @author Assignment - ch4_2RacerRobot
 *
 * @author Sources - Dave Wittry
 */
public class SteepleChaserBot extends AbstractHurdlerRobot
{
    public SteepleChaserBot( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }


    public void over()
    {
        move();
        if ( wallOnRight() )
        {
            while ( wallOnRight() )
            {
                move();
            }

        }
    }
}
