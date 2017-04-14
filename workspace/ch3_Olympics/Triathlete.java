import kareltherobot.*;


/**
 * This the driver for ironman. It includes all the methods required for ironman
 * to complete the obstacle course and to get gold for team USA. To use this,
 * simply call the named methods to execute the intended set of movements.
 * 
 * @author Bryan Wu
 * @version 9/2/14
 * @author Period - 7
 * @author Assignment - ch3_Olympics
 * @author Sources - James Bond
 */
public class Triathlete extends BetterTurner
{
    /**
     * Default constructor for a Gardener. Invokes the constructor of the the
     * UrRobot superclass
     * 
     * @param st    intial street on which this robot is to be located
     * @param av    intial avenue on which this robot is to be located
     * @param dir   initial direction for this robot to face
     * @param beeps number of beepers in this robot's beeper bag
     */
    public Triathlete( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }


    /**
     * Superior method that enables ironman to complete the course
     */
    public void runRace()
    {
        pick7Beepers();
        fly();
        climbStairs();
        put7Beepers();
        goHomeYourDrunk();
    }


    /**
     * ironman will pick up 7 beepers in a straight line
     */
    private void pick7Beepers()
    {
        move();
        pickBeeper(); // Beeper 1 picked up
        move();
        pickBeeper(); // B2
        move();
        pickBeeper(); // B3
        move();
        pickBeeper(); // B4
        move();
        pickBeeper(); // B5
        move();
        pickBeeper(); // B6
        move();
        pickBeeper(); // B7
    }


    /**
     * ironman will jump over the "hurdle" (or navigate around the wall)
     */
    private void fly()
    {
        move();
        turnLeft();
        move();
        turnRight(); // upper-left hand corner of hurdle reached
        move(); // upper-right hand corner of hurdle reached
        turnRight();
        move();
        turnLeft();
        move(); // move to base of stairs
    }


    /**
     * ironman will climb the stairs to the top
     */
    private void climbStairs()
    {
        climbStep();
        climbStep();
        climbStep();
        climbStep();
        move();
    }


    /**
     * ironman will move up 1 step on the stairs
     */
    private void climbStep()
    {
        move();
        turnLeft();
        move();
        turnRight();
    }


    /**
     * ironman will place 7 beepers on the same spot (corner).
     */
    private void put7Beepers()
    {
        putBeeper();
        putBeeper();
        putBeeper();
        putBeeper();
        putBeeper();
        putBeeper();
        putBeeper();
    }


    /**
     * ironman will move in a straight line for 5 blocks
     */
    private void move5Blocks()
    {
        move();
        move();
        move();
        move();
        move();
    }


    /**
     * ironman will return to its starting position
     */
    private void goHomeYourDrunk()
    {
        turnAround();
        move5Blocks();
        move5Blocks();
        move5Blocks();
        turnLeft();
        move();
        move();
        move();
        move();
        turnLeft();
    }
}