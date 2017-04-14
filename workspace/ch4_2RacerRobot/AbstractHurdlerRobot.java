import kareltherobot.*;


/**
 * Abstract Hurdler Robot.
 * 
 * @author Bryan Wu
 * @version 2/23/15
 *
 * @author Period - 7
 * @author Assignment - ch4_2RacerRobot
 *
 * @author Sources - Dave Wittry
 */
public abstract class AbstractHurdlerRobot extends AbstractRacerRobot
{
    public AbstractHurdlerRobot( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }


    public abstract void over(); // implement over() method (may be abstract)


    public void up() // implement up() method (may be abstract)
    {
        turnLeft();
        while ( wallOnRight() )
        {
            move();
        }
        turnRight();
    }


    public void down()
    {
        turnRight();
        move();
        while ( wallOnRight() && frontIsClear() )
        {
            move();
        }
        turnLeft();
    }


    public void raceStride()
    {
        moveToHurdleOrBeeper();
        if ( !nextToABeeper() )
        {
            up();
            over();
            down();
        }
    }


    public boolean wallOnRight()
    {
        turnRight();
        if ( !frontIsClear() )
        {
            turnLeft();
            return true;
        }
        turnLeft();
        return false;
    }


    public void moveToHurdleOrBeeper()
    {
        while ( frontIsClear() && !nextToABeeper() )
        {
            move();
        }
    }

}
