import kareltherobot.*;

/**
 *  Client class that is run to escape the maze.
 *
 *  @author  Bryan Wu
 *  @version Sep 15, 2014
 *  @author  Period: 7
 *  @author  Assignment: ch6_17EscapeBot
 *
 *  @author  Sources: none
 */
public class EscapeBot implements Directions
{
    /**
     * Test method - creates and invokes a MazeWalker
     * 
     * @param args command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        MazeWalker bot = new MazeWalker(1, 1, East, 0);
        
        while (!bot.nextToABeeper())
        {
            bot.followWallRight();
        }        
        bot.turnOff();
    }

//    static
//    {
//        World.reset();
//        World.readWorld( "ch6_17.wld" );
//        World.setDelay( 1 );
//        World.setVisible( true );
//    }
}
