import kareltherobot.*;


/**
 * We are setting beepers in the formation of pins at bowling alleys. We are
 * focusing on learning on how to modularize the entire process.
 * 
 * @author Bryan Wu
 * @version Aug 28, 2014
 * @author Period: 7
 * @author Assignment: ch3_2PinSetter
 *
 * @author Sources: none
 */
public class PinSetter extends BetterTurner
{
    /**
     * Default constructor for an UrRobot
     * 
     * @param st    street
     * @param av   avenue
     * @param dir   direction robot is facing
     * @param beeps number of beepers
     */
    public PinSetter( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }


    /**
     * TODO Write your method description here.
     */
    public void setPins()
    {
        move(); // moves to pin 1
        setTriangle();
        moveToPin6From3();
        setTriangle();
        moveToPin4From10();
        setTriangle();
        moveToPin5From8();
        putBeeper();
        moveBackHome();
    }


    /**
     * PinSetter will now put beepers in the formation of a triangle
     */
    private void setTriangle()
    {
        putBeeper(); // bottom corner of triangle
        turnLeft();
        move();
        turnRight();
        move();
        putBeeper(); // left-hand corner of triangle
        turnRight();
        move();
        move();
        putBeeper(); // right-hand corner of triangle
    }


    /**
     * PinSetter will move from Pin 3 to Pin 6
     */
    private void moveToPin6From3()
    {
        move();
        turnLeft();
        move();
    }


    /**
     * PinSetter will move to from Pin 10 to Pin 4
     */
    private void moveToPin4From10()
    {
        turnAround();
        move();
        move();
        move();
        move();
        move();
        turnLeft();
        move();
        turnAround();
    }


    /**
     * PinSetter will move to from Pin 8 to Pin 5
     */
    private void moveToPin5From8()
    {
        move();
        turnRight();
        move();
    }


    /**
     * PinSetter will return to its starting position of Street 1 Avenue 5
     * facing North
     */
    private void moveBackHome()
    {
        move();
        move();
        move();
        turnAround();
    }
}