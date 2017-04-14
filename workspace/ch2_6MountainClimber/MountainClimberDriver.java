import kareltherobot.*;

/**
 *  A MountainClimber Driver (test).
 *
 *  @author  Bryan Wu
 *  @version 8/22/14
 *  @author  Period: 7
 *  @author  Assignment: KJR Ch2_6MountainClimber
 *
 *  @author  Sources: none
 */
public class MountainClimberDriver implements Directions
{
   /**
    * Instantiate a MountainClimber and invoke its climbMountain method.
    * @param args command-line arguments not used
    */
   public static void main( String args[] )
   {
      MountainClimber drugdealer = new MountainClimber( 1, 3, East, 1 );
      
      drugdealer.wheeeee();
      drugdealer.turnOff();
   }

   static
   {
      World.reset();
      World.readWorld( "ch2_6.wld" );
      World.setDelay( 10 );
      World.setVisible( true );
   }
}