import java.util.*;


/**
 * Chapter 16 - More About Counting Loops Exercises 1-3.
 * 
 * @author Bryan Wu
 * @version 10/23/14
 * 
 * @author Period - 7
 * @author Assignment - Ch16Ex1_3
 * 
 * @author Sources - none
 */
public class Ch16Ex1to3
{
    /**
     * scan
     */
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch16Ex1to3()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch16Ex1to3( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * add up integers
     *  @return sum
     */
    public int addingUpInts()
    {
        int sum = 0;
        System.out.println( "How many integers will be added: " );
        int integers = scan.nextInt();
        int integerInputTimes = 0;
        while ( integerInputTimes < integers )
        {
            System.out.println( "Enter an integer: " );
            int input = scan.nextInt();
            sum = sum + input;
            integerInputTimes = integerInputTimes + 1;
        }
        System.out.println( "The sum is " + sum );
        return sum;
    }


    /**
     * inverse sum
     * @return invSum
     */
    public double inverseSum()
    {
        double invSum = 0.0;

        System.out.println( "Enter N: " );
        int n = scan.nextInt();
        double divisor = 0;
        while ( divisor < n )
        {
            divisor = divisor + 1;
            invSum = invSum + 1 / divisor;
        }

        System.out.println( "Sum is: " + invSum );
        return invSum;
    }


    /**
     * standard deviation
     *  @return stdDev
     */
    public double stdDeviation()
    {
        double stdDev = 0.0;
        double sum = 0.0;
        double times = 0.0;
        System.out.println( "How many integers will be added: " );
        int n = scan.nextInt();
        double totalSquare = 0.0;
        while ( times < n )
        {
            System.out.println( "Enter a floating point number: " );
            double input = scan.nextDouble();
            sum = sum + input;
            totalSquare = totalSquare + input * input;
            times = times + 1;
        }
        double avg = sum / n;
        double avgSquare = totalSquare / n;
        stdDev = Math.sqrt( avgSquare - avg * avg );
        System.out.println( "The standard deviation of a set of numbers Xi is: "
            + stdDev );

        // SD = Math.sqrt( avgSquare - avg2 )
        // Here, avg is the average of the N numbers, and avg2 is its square.
        //
        // avgSquare is the average of Xi * Xi. In other words, this is the
        // average of the squared value of each floating point number.

        return stdDev;
    }


    /**
     * Testing method: instantiates a Ch16Ex1to3 object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch16Ex1to3 exercise = new Ch16Ex1to3();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Adding up Integers" );
            System.out.println( "   (2) Inverse Sum" );
            System.out.println( "   (3) Standard Deviation" );
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
                        int sumOfInts = exercise.addingUpInts();
                        System.out.println( "addingUpInts() = " + sumOfInts );
                        break;
                    case '2':
                        double invSum = exercise.inverseSum();
                        System.out.println( "inverseSum() = " + invSum );
                        break;
                    case '3':
                        double stdDev = exercise.stdDeviation();
                        System.out.println( "stdDeviation() = " + stdDev );
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
