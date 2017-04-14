import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Chapter 80 - Exceptions and Errors Exercises 1-2.
 * 
 * @author Bryan Wu
 * @version 4/20/15
 * @author Period - 7
 * @author Assignment - Ch80Exercises
 * @author Sources - None
 */
public class Ch80Exercises
{
    Scanner scan;

    Scanner inFile;


    /**
     * Constructs a Scanner for input from the console and from a default file
     */
    public Ch80Exercises()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param kbd
     *            console input for the various methods
     * @param file
     *            simulated file input
     */
    public Ch80Exercises( String kbd, String file )
    {
        scan = new Scanner( kbd );
        inFile = new Scanner( file );
    }


    /**
     * Enhanced DivisionPractice program from the chapter.
     */
    public void divisionPractice()
    {
        int num = 0, div = 0;
        String data = "";

        while ( true )
        {
            try
            {
                System.out.print( "Enter the numerator: " );
                data = scan.next();
                // num = scan.nextInt();
                num = Integer.parseInt( data );
                System.out.print( "Enter the divisor  : " );
                div = scan.nextInt();
                System.out.println( num + " / " + div + " is " + ( num / div )
                    + " rem " + ( num % div ) );
            }

            catch ( NumberFormatException ex )
            {

                if ( data.charAt( 0 ) == 'q' || data.charAt( 0 ) == 'Q' )
                {
                    break;
                }
                else
                {
                    System.out.println( "You entered bad data." );
                    System.out.println( "Run the program again." );
                }
            }

            catch ( InputMismatchException ex )
            {
                System.out.println( "You entered bad data." );
                System.out.println( "Run the program again." );
            }
            catch ( ArithmeticException ex )
            {
                System.out.println( "You can't divide " + num + " by " + div );
            }
            scan.nextLine();
        }

    }


    /**
     * The program outputs the sum of the numbers in each group. Each group
     * starts with a one-line descriptive phrase. The phrase can be anything
     * that is not a number. The numbers can be integers or floating point
     * values. Some groups may have no numbers in them. Prompt the user for the
     * name of the input data file.
     */
    public void multiGroupAddition() throws IOException
    {
        // Prompt for and open the input file
        int num = 0;
        int sum = 0;
        String group = "";

        // Prompt for and open the input file
        System.out.print( "Please enter the file name: " );
        String fileName = scan.nextLine().trim();
        System.out.println( "" );
        if ( fileName.length() <= 0 )
        {
            fileName = "Ex2DataSet1.txt";
        }

        inFile = new Scanner( new File( fileName ) );

        while ( inFile.hasNext() )
        {

            try
            {
                num = inFile.nextInt();
                sum = sum + num;
                while ( inFile.hasNextInt() )
                {
                    num = inFile.nextInt();
                    sum = sum + num;
                }
                System.out.println( "Sum = " + sum );
                System.out.println( "" );

                sum = 0;
            }

            catch ( InputMismatchException ex )
            {
                group = inFile.nextLine();
                System.out.println( group );

                // here we check for empty groups
                if ( !inFile.hasNextInt() )
                {
                    System.out.println( "Sum = " + sum );
                    System.out.println( "" );
                }

            }

        }
        inFile.close();

    }


    /**
     * Testing method: instantiates a Ch24Exercises object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args ) throws IOException
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch80Exercises exercise = new Ch80Exercises();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) User-Friendly Division Practice" );
            System.out.println( "   (2) Addition of Multiple Groups" );
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
                        exercise.divisionPractice();
                        break;
                    case '2':
                        exercise.multiGroupAddition();
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
