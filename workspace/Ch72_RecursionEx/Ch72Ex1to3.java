import java.util.Scanner;


/**
 * Chapter 72 - Recursion Examples Exercises 1-3
 * 
 * @author Bryan Wu
 * @version 3/3/15
 * @author Period - 7
 * @author Assignment - Ch72Ex1to3
 * @author Sources - none
 */
public class Ch72Ex1to3
{
    /**
     * Scanner
     */
    Scanner scan;


    /**
     * Constructor
     */
    public Ch72Ex1to3()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Test if number
     * 
     * @param n
     *            number
     * @param d
     *            divisor
     * @return prime
     */
    private boolean prime( int n, int d )
    {
        if ( d == 1 )
        {
            return true;
        }
        else
        {
            if ( n % d == 0 )
            {
                return false;
            }
            else
            {
                return prime( n, d - 1 );
            }
        }

    }


    /**
     * Call prime method.
     * 
     * @param n
     *            integer
     * @return n
     */
    public boolean prime( int n )
    {
        return prime( n, n - 1 );
    }


    /**
     * Modify the math-like definition of the Fibonacci series to account for
     * dying rabbits. Implement the new series as a Java method.
     * 
     * @param n
     *            integer
     * @return fibDieEvery4
     */
    public int fibDieEvery4( int n )
    {
        if ( n <= 0 )
        {
            return 0;
        }
        if ( n == 1 || n == 2 )
        {
            return 1;
        }

        return fibDieEvery4( n - 1 ) + fibDieEvery4( n - 2 )
            - fibDieEvery4( n - 4 ); // subtract number of bunnies from 4 months ago

    }


    /**
     * The greatest common divisor GCD of two integers a and b is the largest
     * integer k that divides both a and b evenly. (That is, k divides both a
     * and b without leaving a remainder.)
     * 
     * @param a
     *            integer
     * @param b
     *            integer
     * @return gcd
     */
    public int gcd( int a, int b )
    {
        if ( a == 0 )
        {
            return b;
        }

        else
        {
            return gcd( b % a, a );
        }
    }


    /**
     * Testing method: instantiates a Lesson15Exercises object and then invokes
     * each method
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch72Ex1to3 exercise = new Ch72Ex1to3();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Prime Numer" );
            System.out.println( "   (2) Fibonacci- 4 Month Life Span" );
            System.out.println( "   (3) Greatest Common Denominator" );
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
                        System.out.print( "Enter an integer: " );
                        int num = kbd.nextInt();
                        kbd.nextLine();
                        System.out.println( "prime( " + num + " ) = "
                            + exercise.prime( num ) );
                        break;
                    case '2':
                        System.out.print( "Enter the number of months: " );
                        int months = kbd.nextInt();
                        kbd.nextLine();
                        System.out.println( "fibDieEvery4( " + months + " ) = "
                            + exercise.fibDieEvery4( months ) );
                        break;
                    case '3':
                        System.out.print( "Enter the first integer: " );
                        int int1 = kbd.nextInt();
                        System.out.print( "Enter the second integer: " );
                        int int2 = kbd.nextInt();
                        kbd.nextLine();
                        System.out.println( "GCD( " + int1 + ", " + int2
                            + " ) = " + exercise.gcd( int1, int2 ) );
                        break;
                    default:
                        if ( response.toLowerCase().charAt( 0 ) == 'q' )
                            done = true;
                        else
                            System.out.print( "Invalid Choice" );
                        break;
                }
            }
        } while ( !done );
        System.out.println( "Goodbye!" );
    }
}
