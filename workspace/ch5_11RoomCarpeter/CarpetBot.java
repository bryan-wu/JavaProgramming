import kareltherobot.*;


/**
 * Go carpeting.
 *
 * @author Bryan Wu
 * @version Sep 11, 2014
 * @author Period: TODO
 * @author Assignment: ch5_11RoomCarpeter
 *
 * @author Sources: TODO
 */
public class CarpetBot extends SmartBot
{
    /**
     * CarpetBot constructor.
     * 
     * @param i
     *            initial street
     * @param j
     *            initial avenue
     * @param east
     *            direction this robot is facing
     * @param k
     *            number of beepers this robot has in its beeper bag
     */
    public CarpetBot( int i, int j, Direction east, int k )
    {
        super( i, j, east, k );
    }


    /**
     * Complete carpeting task.
     */
    public void carpetRooms()
    {
        move();
        isTheFuzzNearby();
        dodgeBullets();
        isTheFuzzNearby();
        dodgeBullets();
        isTheFuzzNearby();
        dodgeBullets();
        isTheFuzzNearby();
        dodgeBullets();
        isTheFuzzNearby();
        dodgeBullets();
        isTheFuzzNearby();
        dodgeBullets();
        isTheFuzzNearby();
        dodgeBullets();
        isTheFuzzNearby();
        dodgeBullets();
    }


    /**
     * Check if inside a room.
     */
    public void isTheFuzzNearby()
    {
        if ( leftIsClear() ) // checking first area
        {
            turnLeft();
            move();
            if ( !leftIsClear() && !frontIsClear() && !rightIsClear() )
            {
                putBeeper();
                backUp();
            }
            else
            {
                backUp();
            }
        }
    }


    /**
     * Move to the entrance of the next area.
     */
    public void dodgeBullets()
    {
        turnRight();
        move();
    }

}