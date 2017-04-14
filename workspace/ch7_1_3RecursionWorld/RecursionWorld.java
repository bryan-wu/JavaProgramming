import kareltherobot.*;
import java.awt.Color;


/**
 * Karel J Robot Chapter 7 Homework, Problems 1-3. Tests three recursive classes
 * Karpeter, WestWallBeeperGetter, and BeeperMover.
 * 
 * @author Bryan Wu
 * @version Sep 26, 2014
 * @author Period - 7
 * @author Assignment - ch7_1_3RecursionWorld
 * @author Sources - none
 */
public class RecursionWorld implements Directions
{
    /**
     * Driver to test the Karpeter, WestWallBeeperGetter, and BeeperMover
     * classes
     * 
     * @param args
     *            command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        Karpeter karel1 = new Karpeter( 2, 2, North, infinity, Color.blue );
        WestWallBeeperGetter karel2 = new WestWallBeeperGetter( 8,
            10,
            East,
            0,
            Color.red );
        BeeperMover karel3 = new BeeperMover( 3, 10, East, 0, Color.black );

        System.out.println( "Placed " + karel1.carpetHallway()
            + " beepers while carpeting" );

        karel2.getBeeper();

        karel3.moveBeepersNorth();
    }

    static
    {
        World.reset();
        World.readWorld( "recursion.wld" );
        World.setDelay( 10 );
        World.setTrace( false );
        World.setVisible( true );
    }
}
