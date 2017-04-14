import java.io.*;
import java.util.*;


/**
 * Chapter 49D - StringBuffer Exercises 1-3
 * 
 * @author Bryan Wu
 * @version 2/3/15
 * @author Period - 7
 * @author Assignment - Ch49DEx1to3
 * @author Sources - none
 */
public class Ch49DEx1to3
{
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch49DEx1to3()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch49DEx1to3( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * A program that creates a "personalized" letter, given a form letter and a
     * person's name
     *
     * @throws IOException
     */
    public void junkMailGenerator() throws IOException
    {
        System.out.println( "Please enter the person's name: " );
        String name = scan.nextLine().trim();
        System.out.println( "Please enter the file name: " ); // enter input
                                                              // file
        String inputFileName = scan.nextLine().trim();
        File input = new File( inputFileName );
        Scanner scan = new Scanner( input );

        String line;
        char character;

        while ( scan.hasNextLine() )
        {
            line = scan.nextLine();
            StringBuffer temp = new StringBuffer();
            temp.insert( 0, line );
            for ( int i = 0; i < temp.length(); i++ )
            {
                character = temp.charAt( i );
                if ( character == '*' )
                {
                    temp.deleteCharAt( i );
                    temp.insert( i, name );
                }
            }
            System.out.println( temp );
        }
    }


    /**
     * Program that reads in a sentence from the user and prints it out with
     * each word reversed, but with the words and punctuation in the original
     * order
     * 
     * @param line
     *            line
     */
    public void wordReverser( StringBuffer line )
    {
        char letter, check;

        StringBuffer temp = new StringBuffer(); // sentence fragments storage
        StringBuffer transfer;

        int numberOfLetters = 0;
        int inputLength = line.length();

        for ( int i = 0; i < inputLength; i++ ) // check if it's just one word
        {
            check = line.charAt( i );
            if ( Character.isLetter( check ) )
            {
                numberOfLetters++;
            }
            if ( numberOfLetters == inputLength ) // check if all are characters
            {
                for ( int j = 0; j < inputLength; j++ )
                {
                    letter = line.charAt( j );
                    temp.append( letter );
                }
                temp.reverse();
                transfer = new StringBuffer();
                transfer.append( temp );
                line.setLength( 0 );
                line.append( transfer );

                return;
            }
        }
        for ( int i = 0; i < inputLength; i++ )
        {
            letter = line.charAt( i );
            if ( Character.isLetter( letter ) )
            {
                temp.append( letter );
            }
            else
            {
                temp.reverse();
                line.append( temp );
                line.append( letter );
                temp = new StringBuffer();// clear out temp
            }
        }

        transfer = new StringBuffer();
        line.delete( 0, inputLength );
        transfer.insert( 0, line );
        line.setLength( 0 );
        line.append( transfer );

        return;
    }


    /**
     * a program that prompts the user for an ISBN and then checks if the ISBN
     * is correct. Calculate a check character from the first nine digits and
     * compare it to the last character of the ISBN. If the two do not agree,
     * the ISBN is incorrect.
     * 
     * @param isbn
     *            isbn
     * @return isbn
     */
    public boolean verifyISBN( StringBuffer isbn )
    {
        int[] digitStorage = new int[9]; // array to store first 9 digits of
                                         // isbn
        int inputLength = isbn.length();
        int digitStorageIndex = 0;
        int multiplier = 10;
        int sum = 0;
        int remainder;
        int checkDigit;

        char character;
        char lastCharacter = isbn.charAt( inputLength - 1 );

        for ( int i = 0; i < inputLength - 1; i++ ) // assemble an array of
                                                    // first 9
                                                    // digits in the isbn
        {
            character = isbn.charAt( i );
            if ( Character.isDigit( character ) )
            {
                digitStorage[digitStorageIndex] = Character.getNumericValue( character );
                digitStorageIndex++;
            }
        }

        for ( int i = 0; i < digitStorage.length; i++ ) // REMOVE
        {
            System.out.print( digitStorage[i] + " " );
        }

        for ( int i = 0; i < digitStorage.length; i++ )
        {
            sum = sum + ( digitStorage[i] * multiplier );
            System.out.println( "sum: " + sum ); // REMOVE
            multiplier--;
        }
        remainder = sum % 11;
        checkDigit = 11 - remainder;
        System.out.println( "remainder: " + remainder ); // REMOVE
        if ( checkDigit == 10 )
        {
            if ( lastCharacter == 'X' )
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        if ( checkDigit == Character.getNumericValue( lastCharacter ) )
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    /**
     * Testing method: instantiates a Lesson15Exercises object and then invokes
     * each method
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args ) throws IOException
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;
        String lineIn = "";

        Ch49DEx1to3 exercise = new Ch49DEx1to3();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Junk Mail Generator" );
            System.out.println( "   (2) Word Reverser" );
            System.out.println( "   (3) ISBN Verifier" );
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
                        exercise.junkMailGenerator();
                        break;
                    case '2':
                        System.out.print( "Input: " );
                        StringBuffer revLine = new StringBuffer( kbd.nextLine() );
                        exercise.wordReverser( revLine );
                        System.out.println( revLine );
                        break;
                    case '3':
                        System.out.print( "Enter ISBN: " );
                        lineIn = kbd.nextLine();
                        StringBuffer isbn = new StringBuffer( lineIn );
                        boolean isValid = exercise.verifyISBN( isbn );
                        System.out.print( lineIn + " is " );
                        if ( isValid )
                        {
                            System.out.print( "a" );
                        }
                        else
                        {
                            System.out.print( "not a" );
                        }
                        System.out.print( " valid ISBN number." );
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
