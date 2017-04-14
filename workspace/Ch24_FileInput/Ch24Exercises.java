import java.io.*;
import java.util.Scanner;


/**
 * Chapter 24 - File Input Techniques Exercises 1-2.
 * 
 * @author Bryan Wu
 * @version 11/20/14
 * @author Period - 7
 * @author Assignment - Ch24Exercises
 * @author Sources - none
 */
public class Ch24Exercises
{
    /**
     * scan
     */
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch24Exercises()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch24Exercises( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * nextGroupSum
     * 
     * @throws FileNotFoundException
     */
    public void nextGroupSum() throws FileNotFoundException
    {
        int sum = 0;
        int num = 0;
        int group = 0;
        String next = "next";

        System.out.println( "Please enter the person's name: " );
        System.out.println( "Please enter the file name: " ); // preparing input file
        String inputFileName = scan.nextLine().trim();
        File input = new File( inputFileName );
        scan = new Scanner( input );

        PrintStream print = null;
        print = new PrintStream( System.out );

        while ( scan.hasNext() )
        {

            if ( scan.hasNextLine() )
            {
                String word = scan.next();

                if ( word.equals( next ) )
                {
                    group++;

                    sum = 0;
                    if ( scan.hasNextInt() ) // check if there isn't a second
                                             // next
                    {
                        num = scan.nextInt();
                        sum = sum + num;
                        while ( scan.hasNextInt() )
                        {
                            num = scan.nextInt();
                            sum = sum + num;
                        }
                        print.println( "Sum of group " + group + " is " + sum );
                    }
                    else
                    // otherwise move on
                    {
                        print.println( "Group " + group + " contains no data" );
                    }
                }

            }
        }
        print.close();
    }


    /**
     * avgGroupChange
     * 
     * @throws FileNotFoundException
     */
    public void avgGroupChange() throws FileNotFoundException
    {

        System.out.println( "File name: " );
        String inputFileName = scan.nextLine().trim();
        File input = new File( inputFileName );
        scan = new Scanner( input );

        int group = 1;

        int totalGroups = scan.nextInt();

        while ( scan.hasNext() )
        {
            int subjects = scan.nextInt();
            if ( group <= totalGroups ) 
            {
                int startingCholestrolSum = 0;
                int finalCholestrolSum = 0;
                double avgStartingCholestrol = 0;
                double avgFinalCholestrol = 0;
                double change = 0;
                if ( scan.hasNextInt() )
                {
                    int pairPart1 = 0; 
                                     
                    int pairPart2 = 0; 
                    int pairCount = 0; 
                    if ( subjects == 0 )
                    {
                        System.out.println( "Group " + group + "\t" + subjects
                            + " subjects" );
                    }

                    else
                    {
                        while ( pairCount < subjects ) 
                        {
                            pairPart1 = scan.nextInt();
                            startingCholestrolSum = startingCholestrolSum
                                + pairPart1;
                            pairPart2 = scan.nextInt();
                            finalCholestrolSum = finalCholestrolSum + pairPart2;
                            pairCount++;
                        }
                        avgStartingCholestrol = startingCholestrolSum
                            / subjects;
                        avgFinalCholestrol = finalCholestrolSum / subjects;
                        change = avgFinalCholestrol - avgStartingCholestrol;

                        System.out.println( "Group " + group + "\t" + subjects
                            + " subjects" );
                        System.out.println( "\taverage starting cholesterol:\t"
                            + avgStartingCholestrol );
                        System.out.println( "\taverage final    cholesterol:\t"
                            + avgFinalCholestrol );
                        System.out.println( "\tchange in        cholesterol:\t"
                            + change );

                    }
                    group++;
                }

            }
        }
        System.out.println( "Done with processing. " );
    }


    /**
     * Testing method: instantiates a Ch24Exercises object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     * @throws FileNotFoundException
     */
    public static void main( String[] args ) throws FileNotFoundException
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch24Exercises exercise = new Ch24Exercises();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Sum of Integer Groups" );
            System.out.println( "   (2) Average Group Change" );
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
                        try
                        {
                            exercise.nextGroupSum();
                        }
                        catch ( FileNotFoundException e )
                        {
                            e.printStackTrace();
                        }
                        break;
                    case '2':
                        exercise.avgGroupChange();
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
