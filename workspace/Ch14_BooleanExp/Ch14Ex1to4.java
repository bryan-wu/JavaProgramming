import java.util.*;


/**
 * Chapter 14 - Boolean Expressions Programming Exercises 1-4.
 * 
 * @author Bryan Wu
 * @version 10/21/14
 * 
 * @author Period - 7
 * @author Assignment - Ch14Ex1to4
 * 
 * @author Sources - none
 */
public class Ch14Ex1to4
{
    /**
     * scan
     */
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch14Ex1to4()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch14Ex1to4( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * Calculate service charge.
     */
    public void checkCharge()
    {
        System.out.println( "Enter checking account balance: " );
        double checking = scan.nextDouble();
        System.out.println( "Enter savings account balance: " );
        double savings = scan.nextDouble();
        double charge;
        if ( checking > 1000 || savings > 1500 )
        {
            charge = 0;
        }
        else
        {
            charge = 0.15;
        }
        System.out.println( "Service Charge Per Check: " + charge );
    }


    /**
     * tires
     */
    public void tirePressure()
    {
        System.out.println( "Input right front pressure: " );
        int rightFront = scan.nextInt();
        System.out.println( "Input left front pressure: " );
        int leftFront = scan.nextInt();
        System.out.println( "Input right rear pressure: " );
        int rightRear = scan.nextInt();
        System.out.println( "Input left rear pressure: " );
        int leftRear = scan.nextInt();
        if ( rightFront == leftFront && rightRear == leftRear )
        {
            System.out.println( "Inflation is OK" );
        }
        else
        {
            System.out.println( "Inflation is BAD" );
        }
    }


    /**
     * more tires man
     */
    public void moreTirePressure()
    {
        System.out.println( "Input right front pressure: " );
        int rightFront = scan.nextInt();
        if ( !( rightFront >= 35 && rightFront <= 45 ) )
        {
            System.out.println( "Warning: pressure is out of range" );
        }
        System.out.println( "Input left front pressure: " );
        int leftFront = scan.nextInt();
        if ( !( leftFront >= 35 && leftFront <= 45 ) )
        {
            System.out.println( "Warning: pressure is out of range" );
        }
        System.out.println( "Input right rear pressure: " );
        int rightRear = scan.nextInt();
        if ( !( rightRear >= 35 && rightRear <= 45 ) )
        {
            System.out.println( "Warning: pressure is out of range" );
        }
        System.out.println( "Input left rear pressure: " );
        int leftRear = scan.nextInt();
        if ( !( leftRear >= 35 && leftRear <= 45 ) )
        {
            System.out.println( "Warning: pressure is out of range" );
        }
        if ( rightFront == leftFront && rightRear == leftRear
            && rightFront >= 35 && rightFront <= 45 && leftFront >= 35
            && leftFront <= 45 && rightRear >= 35 && rightRear <= 45
            && leftRear >= 35 && leftRear <= 45 )
        {
            System.out.println( "Inflation is OK" );
        }
        else
        {
            System.out.println( "Inflation is BAD" );
        }
    }


    /**
     * more more tire
     */
    public void pressureIsBuilding()
    {
        System.out.println( "Input right front pressure: " );
        int rightFront = scan.nextInt();
        if ( !( rightFront >= 35 && rightFront <= 45 ) )
        {
            System.out.println( "Warning: pressure is out of range" );
        }
        System.out.println( "Input left front pressure: " );
        int leftFront = scan.nextInt();
        if ( !( leftFront >= 35 && leftFront <= 45 ) )
        {
            System.out.println( "Warning: pressure is out of range" );
        }
        System.out.println( "Input right rear pressure: " );
        int rightRear = scan.nextInt();
        if ( !( rightRear >= 35 && rightRear <= 45 ) )
        {
            System.out.println( "Warning: pressure is out of range" );
        }
        System.out.println( "Input left rear pressure: " );
        int leftRear = scan.nextInt();
        if ( !( leftRear >= 35 && leftRear <= 45 ) )
        {
            System.out.println( "Warning: pressure is out of range" );
        }
        if ( ( Math.abs( rightFront - leftFront ) <= 3 )
            && ( Math.abs( rightRear - leftRear ) <= 3 ) && rightFront >= 35
            && rightFront <= 45 && leftFront >= 35 && leftFront <= 45
            && rightRear >= 35 && rightRear <= 45 && leftRear >= 35
            && leftRear <= 45 )
        {
            System.out.println( "Inflation is OK" );
        }
        else
        {
            System.out.println( "Inflation is BAD" );
        }
    }


    /**
     * Testing method: instantiates a Ch14Ex1to4 object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch14Ex1to4 exercise = new Ch14Ex1to4();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Check Charge" );
            System.out.println( "   (2) Tire Pressure" );
            System.out.println( "   (3) More Tire Pressure" );
            System.out.println( "   (4) The Pressure is Building" );
            System.out.println( "   (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                        exercise.checkCharge();
                        break;
                    case '2':
                        exercise.tirePressure();
                        break;
                    case '3':
                        exercise.moreTirePressure();
                        break;
                    case '4':
                        exercise.pressureIsBuilding();
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
