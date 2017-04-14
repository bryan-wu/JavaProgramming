import kareltherobot.*;
import java.util.Random;
import java.awt.geom.Point2D;


/**
 * A robot that randomly moves East and West around its starting point. Each
 * time the robot is to move it generates a random number to simulate a "flip"
 * of a coin. The class maintains the number of steps it has taken and its
 * distance from the origin (1, 1).
 * 
 * Class invariants - bot is either facing East or West; bot will not have back
 * to a wall; no walls other than West wall in the World
 * 
 * @author Bryan Wu
 * @version 11/15/14
 * @author Period - 7
 * @author Assignment - ch4_1RandomWalker
 * @author Sources - Dave Wittry
 */
public class RandomWalker extends SmartBot
{
    private Random rand;

    private int currentAv;

    private int currentSt;

    private int numMoves;


    /**
     * @param st
     *            initial street
     * @param av
     *            initial avenue
     * @param dir
     *            direction this robot is facing
     * @param numBeepers
     *            number of beepers this robot has in its beeper bag
     */
    public RandomWalker( int st, int av, Direction dir, int numBeeps )
    {
        super( st, av, dir, numBeeps );
        rand = new Random(); // change to Random() to get random #'s

        currentAv = av;
        currentSt = st;
        numMoves = 0;
        // initialize other 3 instance variables to appropriate values
    }


    /*
     * (non-Javadoc)
     * 
     * @see kareltherobot.UrRobot#move()
     */
    public void move()
    {
        numMoves++; // must always move

        if ( !frontIsClear() )
        {
            currentAv++;
            turnAround();
            super.move();
        }

        else
        {
            boolean east = rand.nextBoolean();
            if ( east )
            {
                currentAv++;
                if ( !facingEast() ) // face East
                {
                    turnLeft();
                    if ( !facingEast() )
                    {
                        turnLeft();
                        if ( !facingEast() )
                        {
                            turnLeft();
                        }
                    }

                }
                super.move();
            }

            else
            {
                currentAv--;
                if ( !facingWest() ) // face West
                {
                    turnLeft();
                    if ( !facingWest() )
                    {
                        turnLeft();
                        if ( !facingWest() )
                        {
                            turnLeft();
                        }
                    }
                }
                super.move();
            }

        }

        // if the front is not clear,
        // turn around
        // move(using Robot's move!)
        // adjust your avenue appropriately
        // leave the method

        // generate a random integer (or a random boolean)
        // make sure that 50% of the time you move one direction and the
        // other 50% of the time you move the other direction

        // adjust your current avenue depending on whether you're facing East
        // or West (hint: there is a method in the Robot class to help you)
    }


    public int getNumMoves()
    {
        return numMoves;
        /* this is just an accessor */
    }


    public double distFromOrigin()
    {

        return Point2D.distance( 1.0, 1.0, currentAv, currentSt );

        // use the static (class) method in the Point2D class called distance;
        // there are several overloaded distance methods - pick the one with
        // four parameters
    }


    public Location location()
    {
        return new Location( currentSt, currentAv );
        // return a new Location object
    }
}
