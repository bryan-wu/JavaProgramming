import kareltherobot.*;


/**
 * This file defines the methods used by the extension of BetterTurner: Gardener
 * We are learning to use public void and private void here.
 * 
 * @author Bryan Wu
 * @version 8/29/14
 * @author Period - 7
 * @author Assignment - ch3_Olympics
 * @author Sources - none
 */
public class Gardener extends BetterTurner
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
    public Gardener( int st, int av, Direction dir, int beeps )
    {
        super( st, av, dir, beeps );
    }

    /**
     * Gardener will plant the Garden and return to its original position.
     */
    public void plantGarden()
    {
        turnLeft();
        move();
        move();
        move(); // Gardener is now at bottom point of cross
        plantlotsofWeed();
        returntoCrib(); // return to home
    }

    /**
     * Method for planting the beepers in an "L" formation
     */
    private void plantlotsofWeed()
    {
        plant4Weeds(); 
        plant3Weeds(); // lower right-hand part of cross planted
        plant4Weeds(); 
        plant3Weeds(); // upper right-hand part of cross planted
        plant4Weeds(); 
        plant3Weeds(); // upper left-hand part
        plant4Weeds(); 
        plant3Weeds(); // lower left-hand part
    }

    /**
     * Method to put 4 beepers down in a straight line
     */
    private void plant4Weeds()
    {
        move(); // move to beginning of next "L" side of cross
        putBeeper(); // plant first Beeper of "L" formation
        turnLeft();
        move();
        putBeeper();
        move();
        putBeeper();
        move();
        putBeeper(); // planted Beeper at corner of "L" formation
    }

    /**
     * Method to complete the "L" formation by turning and putting 3 more
     * beepers
     */
    private void plant3Weeds()
    {

        turnRight();
        move();
        putBeeper();
        move();
        putBeeper();
        move();
        putBeeper(); // final Beeper of "L" formation planted
        turnLeft(); // prepare to plant another "L" formation
    }

    /**
     * Method for returning Gardener to its original position
     */
    private void returntoCrib()
    {
        turnAround();
        move();
        move();
        move();
        turnLeft(); // starting position reached
    }
}