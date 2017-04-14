import kareltherobot.*;

/**
 *  Draws an 'H' on a blank 10 x 10 world by placing beepers.
 *
 *  @author  B, Wu
 *  @version 08/21/14
 *  @author  Period: 7
 *  @author  Assignment: HBotProj
 *
 *  @author  Sources: none
 */
public class HBot extends UrRobot
{
    public HBot( int street, int avenue, Direction direction, int beepers )
    {
       super( street, avenue, direction, beepers );
    }
//Karel will now draw an H
    public void drawH()
    {
        putBeeper();
        move();
        putBeeper();
        move();
        putBeeper();
        //left vertical line of letter H completed
        turnLeft();
        turnLeft();
        turnLeft();
        move();
        move();
        putBeeper();
        turnLeft();
        turnLeft();
        turnLeft();
        move();
        putBeeper();
        move();
        putBeeper();
        //right vertical line of letter H completed
        turnLeft();
        turnLeft();
        turnLeft();
        move();
        turnLeft();
        turnLeft();
        turnLeft();
        move();
        putBeeper();
        //center horizontal line of letter H completed
        turnLeft();
        move();
        turnLeft();
        move();
        //return to origin
        turnLeft();
        turnLeft();
        //face North
    }
}
