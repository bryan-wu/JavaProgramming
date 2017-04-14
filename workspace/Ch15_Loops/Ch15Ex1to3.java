import java.util.*;


/**
 * Chapter 15 - Loops Exercises 1-3.
 * 
 * @author Bryan Wu
 * @version 10/23/14
 * @author Period - 7
 * @author Assignment - Ch15Ex1to3
 * @author Sources - none
 */
public class Ch15Ex1to3
{
    /**
     * scan
     */
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch15Ex1to3()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch15Ex1to3( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * inclusive integers
     */
    public void inclusiveIntegers()
    {
        System.out.println( "Enter Start: " );
        int start = scan.nextInt();
        System.out.println( "Enter End: " );
        int end = scan.nextInt();
        while ( start <= end )
        {
            System.out.println( start );
            start = start + 1;
        }
    }


    /**
     * repeat word
     */
    public void repeatWord()
    {
        System.out.println( "Enter a word: " );
        String word = scan.nextLine();
        int length = word.length();
        int times = 0;
        while ( times < length )
        {
            System.out.println( word );
            times = times + 1;
        }
    }


    /**
     * two words
     */
    public void twoWords()
    {
        System.out.println( "Enter first word: " );
        String firstWord = scan.nextLine();
        System.out.println( "Enter second word: " );
        String secondWord = scan.nextLine();
        int length = firstWord.length() + secondWord.length();
        int dots = 0;
        System.out.print( firstWord );
        while ( dots + length < 30 )
        {
            System.out.print( "." );
            dots = dots + 1;
        }
        System.out.print( secondWord );
    }


    /**
     * Testing method: instantiates a Ch15Ex1to3 object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch15Ex1to3 exercise = new Ch15Ex1to3();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Inclusive Integers" );
            System.out.println( "   (2) Repeat Word" );
            System.out.println( "   (3) Two Words" );
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
                        exercise.inclusiveIntegers();
                        break;
                    case '2':
                        exercise.repeatWord();
                        break;
                    case '3':
                        exercise.twoWords();
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
