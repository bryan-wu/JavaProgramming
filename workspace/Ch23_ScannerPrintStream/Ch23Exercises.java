import java.util.*;
import java.io.*;


/**
 * Chapter 23 - File I/O with Scanner and PrintStream Exercises.
 * 
 * @author Bryan Wu
 * @version 11/17/14
 * 
 * @author Period - 7
 * @author Assignment - Ch23Exercises
 * 
 * @author Sources - none
 */
public class Ch23Exercises
{
    /**
     * scan
     */
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch23Exercises()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch23Exercises( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * Exercise 1 - Sum of a file of Integers
     * 
     * sum of int file
     * 
     * @throws FileNotFoundException
     */
    public int sumOfIntFile() throws FileNotFoundException
    {
        int sum = 0;
        System.out.println( "File name: " );
        String input = scan.nextLine().trim();
        File file = new File( input ); // create a File object

        scan = new Scanner( file );

        int num;
        while ( scan.hasNextInt() )
        {
            num = scan.nextInt();
            sum = sum + num;
        }
        return sum;
    }


    /**
     * Exercise 2 - Average and Standard Deviation of a file of Doubles
     * 
     * average standard deviation of double file
     * 
     * @throws FileNotFoundException
     */
    public double[] avgStdDevOfDoubleFile() throws FileNotFoundException
    {
        double avg = 0;
        double sd = 0;
        double sumSQ = 0;

        System.out.println( "File name: " );
        String input = scan.nextLine().trim();
        File file = new File( input ); // create a File object

        scan = new Scanner( file );

        double num, sum = 0;
        int n = 0;

        while ( scan.hasNextDouble() )
        {
            num = scan.nextDouble();
            n++;
            sum = sum + num;
            sumSQ = sumSQ + num * num;
        }

        avg = sum / n;
        double avgSQ = sumSQ / n;
        double var = avgSQ - ( avg * avg );
        sd = Math.sqrt( var );
        double[] result = { avg, sd };
        return result;
    }


    /**
     * Exercise 4 - Separate Sums
     * 
     * separate sums
     * 
     * @throws FileNotFoundException
     */
    public int[] seperateSums() throws FileNotFoundException
    {
        int xSum = 0;
        int ySum = 0;

        System.out.println( "File name: " );
        String input = scan.nextLine().trim();
        File file = new File( input ); // create a File object

        scan = new Scanner( file );

        String x = ( "x=" );
        String y = ( "y=" );

        int num;
        String phrase;

        while ( scan.hasNext() ) // more data to process?
        {
            if ( scan.hasNextLine() ) // if it is a String, get it
            {
                phrase = scan.next();

                if ( phrase.equals( x ) )
                {
                    if ( scan.hasNextInt() ) // if it is an Int, get it
                    {
                        num = scan.nextInt();
                        xSum = xSum + num;
                    }
                }

                if ( phrase.equals( y ) )
                {
                    if ( scan.hasNextInt() ) // if it is an Int, get it
                    {
                        num = scan.nextInt();
                        ySum = ySum + num;
                    }
                }
            }
        }

        int[] result = { xSum, ySum };
        return result;
    }


    /**
     * Exercise 6 - E-Mail Address Extractor
     * 
     * email address extractor
     * 
     * @throws FileNotFoundException
     */
    public void emailAddressExtractor() throws FileNotFoundException
    {
        System.out.print( "Input File Name: " ); // preparing input file
        String inputFileName = scan.nextLine().trim();
        File input = new File( inputFileName );
        scan = new Scanner( input );

        File output = new File( "emailOut.txt" ); // preparing output file
        PrintStream print = null;
        print = new PrintStream( output );

        while ( scan.hasNext() )
        {
            if ( scan.hasNextLine() )
            {
                String email = scan.next();
                int atIndex = email.indexOf( "@" );
                int dotIndex = email.indexOf( "." );
                if ( atIndex < dotIndex )
                {
                    print.println( email );
                }
                else
                {
                    scan.next();
                }
            }
        }
        print.close();
    }


    /**
     * Testing method: instantiates a Ch23Exercises object and then
     *  invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args ) throws IOException
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch23Exercises exercise = new Ch23Exercises();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Sum of a file of Integers" );
            System.out.println( "   (2) Average and Standard Deviation "
                + "of a file of Doubles" );
            System.out.println( "   (4) Separate Sums" );
            System.out.println( "   (6) E-Mail Address Extractor" );
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
                        System.out.println( "Sum of the file = "
                            + exercise.sumOfIntFile() );
                        break;
                    case '2':
                        double[] avgSD = exercise.avgStdDevOfDoubleFile();
                        System.out.println( "Average = " + avgSD[0] );
                        System.out.println( "Standard " + "Deviation = "
                            + avgSD[1] );
                        break;
                    case '4':
                        int[] sums = exercise.seperateSums();
                        System.out.println( "Sum of x = " + sums[0] );
                        System.out.println( "Sum of y = " + sums[1] );
                        break;
                    case '6':
                        exercise.emailAddressExtractor();
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
