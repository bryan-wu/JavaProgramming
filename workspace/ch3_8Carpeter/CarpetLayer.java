import kareltherobot.*;


/**
 * This class will put Beepers down in the shape of a square. The purpose of
 * this class is for us to learn how to modularize a process and break
 *
 * @author Bryan Wu
 * @version Sep 4, 2014
 * @author Period: 7
 * @author Assignment: ch3_8Carpeter
 *
 * @author Sources: none
 */
public class CarpetLayer extends BetterTurner
{
    /**
     * Default UrRobot constructor.
     * 
     * @param st     initial street
     * @param av     initial avenue
     * @param dir    direction this robot is facing
     * @param beeps  number of beepers this robot has in its beeper bag
     */
    public CarpetLayer( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }


    /**
     * CarpetLayer will complete the task of laying the carpet.
     */
    public void layCarpet()
    {
        carpetBurn();
        turnLeft();
        smallCarpetBurn();
        turnLeft();
        carpetBurn();
        turnLeft();
        smallCarpetBurn();
        turnLeft();
    }


    /**
     * This method makes CarpetLayer put 8 Beepers in a straight line. This
     * method is used for the vertical hallways of the building.
     */
    private void carpetBurn()
    {
        putBeeper();
        move();
        putBeeper();
        move();
        putBeeper();
        move();
        putBeeper();
        move();
        putBeeper();
        move();
        putBeeper();
        move();
        putBeeper();
        move();
        putBeeper();
    }


    /**
     * This method makes CarpetLayer put 6 Beepers in a straight line. This
     * method is used for the horiztonal hallways of the building.
     */
    private void smallCarpetBurn()
    {
        move();
        putBeeper();
        move();
        putBeeper();
        move();
        putBeeper();
        move();
        putBeeper();
        move();
        putBeeper();
        move();
        putBeeper();
        move();
    }
}
