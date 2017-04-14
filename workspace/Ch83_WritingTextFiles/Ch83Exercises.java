import java.util.*;
import java.io.*;


/**
 * Chapter 83 - Writing Text Files.
 * 
 * @author Bryan Wu
 * @version 4/27/15
 * 
 * @author Period - 7
 * @author Assignment - Ch83Exercises
 * 
 * @author Sources - None
 */
public class Ch83Exercises
{
    Scanner scan;

    Random rand = new Random( 0 );


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch83Exercises()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch83Exercises( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     * @param seed
     *            seed to use for random number generator
     */
    public Ch83Exercises( String str, long seed )
    {
        scan = new Scanner( str );
        rand.setSeed( seed );
    }


    /**
     * Exercise 1 - Random Integer Data.
     * 
     * Print out Random Data Set.
     */
    public void randomIntData()
    {
        PrintWriter out = null;

        // initializing variables for data items, count for accumulated number
        // of data items, and count for "column" number, respectively
        int data = 0, numberCount = 0, col = 0;

        System.out.print( "Enter HighValue-->" );
        int highValue = scan.nextInt();

        System.out.print( "Enter how many per line-->" );
        int perLine = scan.nextInt();

        System.out.print( "Enter how many integers-->" );
        int totalCount = scan.nextInt();
        scan.nextLine();

        System.out.print( "Enter Filename-->" );
        String fileName = scan.nextLine();
        if ( fileName.length() <= 0 )
        {
            fileName = "rdata.dat";
        }
        try
        {
            out = new PrintWriter( new BufferedWriter( new FileWriter( fileName ) ) );
        }
        catch ( IOException e )
        {
            System.out.println( "Problem writing " + fileName );
        }

        while ( numberCount < totalCount )
        {
            while ( col < perLine && numberCount < totalCount )
            {
                data = rand.nextInt( highValue );
                out.write( data + " " );
                numberCount++;
                col++;
            }
            col = 0;
            out.write( "\n" );
        }

        out.close();
    }


    /**
     * Exercise 3 - HTML Power of 2 Table.
     * 
     * Program that creates a text file that contains a power of two table in
     * HTML format.
     */
    public void powerOf2Table()
    {
        PrintWriter out = null;

        String fileName = "";

        // Get filename
        System.out.print( "Enter Filename-->" );
        fileName = scan.nextLine();
        if ( fileName.length() <= 0 )
        {
            fileName = "twoPowerTable.html";
        }
        try
        {
            out = new PrintWriter( new BufferedWriter( new FileWriter( fileName ) ) );
        }
        catch ( IOException e )
        {
            System.out.println( "Problem writing " + fileName );
        }

        // Write out the table.
        int value = 1;
        out.println( "<html>" );
        out.println( "<head>" );
        out.println( "<title>Powers of Two</title>" );
        out.println( "</head>" );
        out.println( "<body>" );
        out.println( "<table border cellpadding=5>" );
        out.println( "<tr><th>Power of 2</th><th>Value</th></tr>" );

        for ( int pow = 0; pow <= 10; pow++ )
        {
            out.println( "<tr><td>" + pow + "</td><td>" + value + "</td></tr>" );
            value = value * 2;
        }
        out.println( "</table>" );
        out.println( "</body>" );
        out.println( "</html>" );

        out.close();
    }


    /**
     * Testing method: instantiates a Ch23Exercises object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args ) throws IOException
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch83Exercises exercise = new Ch83Exercises();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Random Integer Data" );
            System.out.println( "   (3) HTML Power of 2 Table" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                        exercise.randomIntData();
                        break;
                    case '3':
                        exercise.powerOf2Table();
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
