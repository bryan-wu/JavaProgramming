import java.util.Scanner;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author Bryan Wu
 * @version 10/9/14
 * @author Period - 7
 * @author Assignment - Ch10_IO
 * @author Sources - none
 */
public class Ch10Ex1thru4
{
    /**
     * scan
     */
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch10Ex1thru4()
    {
        scan = new Scanner( System.in );

    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch10Ex1thru4( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * Find the area of a circle with the certain radius
     */
    public void areaOfACircle()
    {
        int radius;
        System.out.print( "Input the radius: " );
        radius = scan.nextInt();
        double area = Math.PI * radius * radius;
        System.out.println( "The radius is: " + radius + 
            "The area is: " + area );
    }


    /**
     * Find the amount of dollars and cents from the inputted cents value.
     */
    public void centsToDollars()
    {
        int cents;
        System.out.print( "Input the cents: " );
        cents = scan.nextInt();
        int dollars;
        dollars = cents / 100;
        cents = cents % 100;
        System.out.println( "That is " + dollars + " dollars " + cents
            + " cents." );

    }


    /**
     * Find exact change in dollars, quarters, dimes, nickels, and pennies from
     * the inputted cents value.
     */
    public void correctChange()
    {
        int cents;
        System.out.print( "Input the cents: " );
        cents = scan.nextInt();
        int dollars;
        dollars = cents / 100;
        int quarters;
        quarters = ( cents % 100 ) / 25;
        int dimes;
        dimes = ( ( cents % 100 ) % 25 ) / 10;
        int nickels;
        nickels = ( ( ( cents % 100 ) % 25 ) % 10 ) / 5;
        cents = ( ( ( cents % 100 ) % 25 ) % 10 ) % 5;
        System.out.println( "Your change is: " + dollars + " dollars, "
            + quarters + " quarters, " + dimes + " dimes, " + nickels
            + " nickels, " + cents + " cents." );
    }


    /**
     * 
     */
    public void ohmsLaw()
    {
        double i;
        int v;
        System.out.print( "Input the voltage of the device: " );
        v = scan.nextInt();
        int r;
        System.out.print( "Input the resistance of the device: " );
        r = scan.nextInt();
        i = ( v + 0.0 ) / r;
        System.out.println( "The current flowing through the device is: " + i
            + "amps." );
    }


    /**
     * Testing method: instantiates a Lesson10Exercises object and then invokes
     * each method.
     * 
     * @param args
     *            command-line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch10Ex1thru4 exercise = new Ch10Ex1thru4();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "    (1) Area of a Circle" );
            System.out.println( "    (2) Cents to Dollars" );
            System.out.println( "    (3) Correct Change" );
            System.out.println( "    (4) Ohm's Law" );
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
                        exercise.areaOfACircle();
                        break;
                    case '2':
                        exercise.centsToDollars();
                        break;
                    case '3':
                        exercise.correctChange();
                        break;
                    case '4':
                        exercise.ohmsLaw();
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
