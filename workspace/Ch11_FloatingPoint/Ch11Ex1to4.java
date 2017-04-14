import java.util.Scanner;


/**
 * Float Exercise
 * 
 * @author Bryan Wu
 * @version 10/13/14
 * @author Period - 7
 * @author Assignment - Ch11_FloatingPoint
 * @author Sources - none
 */
public class Ch11Ex1to4
{
    /**
     * scan
     */
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch11Ex1to4()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch11Ex1to4( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * Program that calculates the annual cost of running an appliance
     */
    public void annualCost()
    {
        double cost;
        double hours;
        System.out.print( "Enter cost per kilowatt-hour  in cents: " );
        cost = scan.nextDouble();
        System.out.print( "Enter kilowatt-hours used per year: " );
        hours = scan.nextDouble();
        double total = hours * cost / 100;
        System.out.print( "Annual cost: " + total );
    }


    /**
     * Calculate distance fallen and seconds from free fall formula.
     */
    public void fallingBrick()
    {
        System.out.print( "Enter the number of seconds: " );
        double t = scan.nextDouble();
        double g = 32.174;
        double d = 0.5 * g * t * t;
        System.out.print( "The brick fell " + d + 
            " feet in " + t + " seconds." );

        System.out.print( "Enter the distance: " );
        double d2 = scan.nextDouble();
        double t2 = Math.sqrt( 2 * d2 / g );
        System.out.print( "The brick fell " + d2 + " feet in " + t2
            + " seconds." );
    }


    /**
     * Change to base 2 Log.
     */
    public void base2Log()
    {
        System.out.print( "Enter a double: " );
        double x = scan.nextDouble();
        double log = Math.log( x ) / Math.log( 2 );
        System.out.print( "Base 2 log of " + x + " is " + log );
    }


    /**
     * Find harmonic mean of two numbers
     */
    public void harmonicMean()
    {
        System.out.print( "Enter X: " );
        double x = scan.nextDouble();
        System.out.print( "Enter Y: " );
        double y = scan.nextDouble();
        double mean = ( x + y ) / 2.0;
        System.out.print( "Arithmetic mean: " + mean );
        double hMean = 2.0 / ( 1 / x + 1 / y );
        System.out.print( "Harmonic   mean: " + hMean );
    }


    /**
     * Testing method: instantiates a Ch11Ex1_4 object and then invokes each
     * method
     * 
     * @param args
     *            command-line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch11Ex1to4 exercise = new Ch11Ex1to4();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "    (1) Annual Cost of Running an Appliance" );
            System.out.println( "    (2) Falling Brick" );
            System.out.println( "    (3) Base 2 Logarithm of a Number" );
            System.out.println( "    (4) Harmonic Mean" );
            System.out.println( "    (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                        exercise.annualCost();
                        break;
                    case '2':
                        exercise.fallingBrick();
                        break;
                    case '3':
                        exercise.base2Log();
                        break;
                    case '4':
                        exercise.harmonicMean();
                        break;
                    default:
                        if ( response.toLowerCase().charAt( 0 ) == 'q' )
                        {
                            done = true;
                        }
                        else
                        {
                            System.out.print( "Invalid Choice" );
                        }
                        break;
                }
            }
        } while ( !done );
        System.out.println( "Goodbye!" );
    }
}
