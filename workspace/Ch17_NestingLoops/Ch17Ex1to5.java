import java.util.*;


/**
 * Chapter 17 - Nesting Loops and ifs Exercises 1-5
 * 
 * @author Bryan Wu
 * @version 10/28/14
 * 
 * @author Period - 7
 * @author Period Assignment - Ch17Ex1to5
 * 
 * @author Sources - none
 */
public class Ch17Ex1to5
{
    /**
     * scan
     */
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch17Ex1to5()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch17Ex1to5( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * jet lag
     * 
     * @return daysofRecovery
     */
    public double jetLagCalc()
    {
        double daysOfRecovery;

        double departure = 0.0;
        double arrival = 0.0;
        
        System.out.println( "Hours: " );
        int hours = scan.nextInt();
        System.out.println( "Zones: " );
        int zones = scan.nextInt();
        System.out.println( "Depart: " );
        int departureTime = scan.nextInt();
        System.out.println( "Arrive: " );
        int arrivalTime = scan.nextInt();
        if ( departureTime > 8.0 && departureTime < 12.0 )
        {
            departure = 0;
        }
        if ( departureTime > 12.0 && departureTime < 18.0 )
        {
            departure = 1;
        }
        if ( departureTime > 18.0 && departureTime < 22.0 )
        {
            departure = 3;
        }
        if ( departureTime > 22.0 || departureTime < 1.0 )
        {
            departure = 4;
        }
        if ( departureTime > 1.0 && departureTime < 8.0 )
        {
            departure = 5;
        }

        if ( arrivalTime > 8.0 && arrivalTime < 12.0 )
        {
            arrival = 4;
        }
        if ( arrivalTime > 12.0 && arrivalTime < 18.0 )
        {
            arrival = 2;
        }
        if ( arrivalTime > 18.0 && arrivalTime < 22.0 )
        {
            arrival = 0;
        }
        if ( arrivalTime > 22.0 || arrivalTime < 1.0 )
        {
            arrival = 1;
        }
        if ( arrivalTime > 1.0 && arrivalTime < 8.0 )
        {
            arrival = 3;
        }

        daysOfRecovery = ( hours * 0.5 + ( zones - 3 ) + 
                        departure + arrival ) * 0.1;
        System.out.println( "Days of Recovery: " + daysOfRecovery + " days" );
        return daysOfRecovery;
    }


    /**
     * add up squares and cubes
     * 
     * @return addUpSquaresAndCubes
     */
    public long[] addUpSquaresAndCubes()
    {
        long sumSquares = 0;
        long sumCubes = 0;
        System.out.println( "Upper Limit: " );
        long n = scan.nextLong();
        sumSquares = n * ( n + 1 ) * ( 2 * n + 1 ) / 6;

        sumCubes = n * n * ( n + 1 ) * ( n + 1 ) / 4;
        // n(n+1)(2n+1)/6
        // n^2(n+1)^2/4

        System.out.println( "The sum of Squares is  " + sumSquares );
        System.out.println( "The sum of Cubes   is  " + sumCubes );
        return new long[] { sumSquares, sumCubes };
    }


    /**
     * power of a number
     * 
     * @return pow
     */
    public double powerOfANumber()
    {
        double pow = 1.0;

        int multiply = 1;
        System.out.println( "Enter x " );
        double x = scan.nextDouble();
        System.out.println( "Enter y " );
        double y = scan.nextDouble();
        if ( y > 0 )
        {
            while ( multiply <= y )
            {
                pow = pow * x;
                multiply = multiply + 1;
            }
        }
        if ( y < 0 )
        {
            while ( multiply <= Math.abs( y ) )
            {
                pow = pow * ( 1 / x );
                multiply = multiply + 1;
            }
        }

        return pow;
    }


    /**
     * wedge of stars
     * 
     */
    public void wedgeOfStars()
    {
        System.out.println( "Initial number of stars: " );
        int stars = scan.nextInt();

        while ( stars > 0 )
        {
            int count = stars;
            while ( count > 0 )
            {
                System.out.print( "*" );
                count--;
            }
            System.out.println();
            stars--;
        }

    }


    /**
     * pineTree
     * 
     */
    public void pineTree()
    {
        int blank;
        int count = 0;
        int count2;
        int height;
        int height2;

        System.out.println( "Enter the height of the tree: " );
        height = scan.nextInt();
        height2 = height - 2;
        while ( height > 0 )
        {
            blank = height - 1;
            while ( blank > 0 )
            {
                System.out.print( " " );
                blank = blank - 1;
            }
            count2 = count;
            count2 = 2 * count2 + 1;
            while ( count2 > 0 )
            {
                System.out.print( "*" );
                count2 = count2 - 1;
            }
            System.out.println();
            count = count + 1;
            height = height - 1;

        }
        int count3 = 3;
        int count4 = height2;
        while ( count3 > 0 )
        {
            height2 = count4;
            while ( height2 > 0 )
            {
                System.out.print( " " );
                height2 = height2 - 1;

            }
            System.out.print( "***" );
            System.out.println();
            count3 = count3 - 1;

        }
    }


    /**
     * Testing method: instantiates a Ch17Ex1to4 object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch17Ex1to5 ex = new Ch17Ex1to5();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Jet Lag Calculator" );
            System.out.println( "   (2) Adding up Squares and Cubes" );
            System.out.println( "   (3) Power of a number" );
            System.out.println( "   (4) Wedge of Stars" );
            System.out.println( "   (5) Pine Tree" );
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
                        double daysOfRecovery = ex.jetLagCalc();
                        System.out.println( "Days of recovery: "
                            + daysOfRecovery );
                        break;
                    case '2':
                        long[] sums = ex.addUpSquaresAndCubes();
                        System.out.println( "Sum of squares: " + sums[0] );
                        System.out.println( "Sum of cubes : " + sums[1] );
                        break;
                    case '3':
                        double pow = ex.powerOfANumber();
                        System.out.println( "powerOfANumber() = " + pow );
                        break;
                    case '4':
                        ex.wedgeOfStars();
                        break;
                    case '5':
                        ex.pineTree();
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
