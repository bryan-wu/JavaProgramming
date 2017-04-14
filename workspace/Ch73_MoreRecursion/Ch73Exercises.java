import java.util.Scanner;


/**
 * Chapter 73 - More Recursion Exercises 1, 3, 4, 6, 7, 8
 * 
 * @author Bryan Wu
 * @version 3/6/15
 * @author Period - 7
 * @author Assignment - Ch72Ex1to3
 * @author Sources - none
 */
public class Ch73Exercises
{
    Scanner scan;


    /**
     * Constructor
     */
    public Ch73Exercises()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Method to find square of number.
     * 
     * @param n
     *            number
     * @return n
     */
    public int square( int n )
    {
        if ( n == 1 ) // check if just square of 1
        {
            return 1;
        }
        else
        {
            return square( ( n - 1 ) ) + 2 * n - 1;
        }
    }


    /**
     * Find the cube
     * 
     * @param n
     *            integer
     * @return cube
     */
    public int cube( int n )
    {
        if ( n == 1 )
        {
            return 1;
        }
        else
        {
            return cube( n - 1 ) + 3 * square( n ) - 3 * n + 1;
        }
    }


    /**
     * Sum of elements in array.
     * 
     * @param array
     *            array
     * @param index
     *            index
     * @return sum
     */
    private int sum( int[] array, int index )
    {
        if ( index == array.length )
        {

            return 0;
        }
        else
        {
            if ( index < array.length )
            {
                return array[index] + sum( array, index + 1 );
            }
            else
            {
                return 0;
            }
        }
    }


    /**
     * Sum of elements in array.
     * 
     * @param array
     *            array
     * @return sum
     */
    public int sum( int[] array )
    {
        return sum( array, 0 );
    }


    /**
     * Recursive definition of the maximum element in an array of integersTODO
     * Write your method description here.
     * 
     * @param array
     *            array
     * @param index
     *            index
     * @return max
     */
    private int max( int[] array, int index, int max )
    {
        if ( index == array.length )
        {
            return max;
        }
        else
        {
            if ( index < array.length && array[index] > max )
            {
                return max( array, index + 1, array[index] ); // new max
            }
            else
            {
                return max( array, index + 1, max );
            }
        }
    }


    /**
     * Recursive definition of the maximum element in an array of integers.
     * 
     * @param array
     *            array
     * @return max
     */
    public int max( int[] array )
    {
        return max( array, 0, array[0] );
    }


    /**
     * Equals ignore case.
     * 
     * @param strA
     *            stringA
     * @param strB
     *            stringB
     * @return equalsIgnoreCase
     */
    public boolean equalsIgnoreCase( String strA, String strB )
    {
        if ( strA.length() == 0 && strB.length() == 0 ) // check if just empty
                                                        // strings
        {
            return true;
        }

        else if ( strA.length() == 0 && strB.length() != 0
            || strA.length() != 0 && strB.length() == 0 )
        {
            return false;
        }

        else if ( strA.toLowerCase().charAt( 0 ) != strB.toLowerCase()
            .charAt( 0 ) )
        {
            return false;
        }

        else
        {
            return equalsIgnoreCase( strA.substring( 1 ), strB.substring( 1 ) );
        }
    }


    /**
     * Removes all vowels from a string.
     * 
     * @param str
     *            string
     * @return removeVowels
     */
    public String removeVowels( String str )
    {
        str = str.replaceAll( "a", "" );
        str = str.replaceAll( "A", "" );
        str = str.replaceAll( "e", "" );
        str = str.replaceAll( "E", "" );
        str = str.replaceAll( "i", "" );
        str = str.replaceAll( "I", "" );
        str = str.replaceAll( "o", "" );
        str = str.replaceAll( "O", "" );
        str = str.replaceAll( "u", "" );
        str = str.replaceAll( "U", "" );
        return str;
    }


    /**
     * Equals ignore vowels
     * 
     * @param strA
     *            stringA
     * @param strB
     *            stringB
     * @return equalsIgnoreVowels
     */
    public boolean equalsIgnoreVowels( String strA, String strB )
    {
        strA = removeVowels( strA ); // remove vowels from both strings
        strB = removeVowels( strB );

        if ( strA.length() == 0 && strB.length() == 0 )
        {
            return true;
        }

        else if ( strA.length() == 0 && strB.length() != 0
            || strA.length() != 0 && strB.length() == 0 )
        {
            return false;
        }

        else if ( strA.toLowerCase().charAt( 0 ) != strB.toLowerCase()
            .charAt( 0 ) )
        {
            return false;
        }

        else
        {
            return equalsIgnoreVowels( strA.substring( 1 ), strB.substring( 1 ) );
        }
    }


    /**
     * Tests if given string is a palindrome.
     * 
     * @param str
     *            string
     * @return palindrome
     */
    public boolean palindrome( String str )
    {
        if ( str.length() == 0 )
        {
            return true;
        }
        if ( str.length() == 1 )
        {
            return true;
        }

        if ( str.toLowerCase().charAt( 0 ) != ( str.toLowerCase().charAt( str.length() - 1 ) ) )
        {
            return false;
        }
        else
        {
            return palindrome( str.substring( 1, str.length() - 1 ) );
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
        int[] testArray = { 3, 2, 5, 1, 4, 4, 8, 13, 9, 1, 0, 2, 0, 2, 6, 3,
            -1, -8 };
        boolean done = false;
        String word1 = "";
        String word2 = "";

        Ch73Exercises ex = new Ch73Exercises();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Cube Numbers" );
            System.out.println( "   (3) Sum of Elements in an Integer Array" );
            System.out.println( "   (4) Maximum Element in an Integer Array" );
            System.out.println( "   (6) equalsIgnoreCase" );
            System.out.println( "   (7) equalsIgnoreVowels" );
            System.out.println( "   (8) palindrome" );
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
                        System.out.println( "cube( " + num + " ) = "
                            + ex.cube( num ) );
                        break;
                    case '3':
                        int arraySum = ex.sum( testArray );
                        System.out.println( "sum = " + arraySum );
                        break;
                    case '4':
                        int maxVal = ex.max( testArray );
                        System.out.println( "max = " + maxVal );
                        break;
                    case '6':
                        System.out.print( "Please enter the first word: " );
                        word1 = kbd.nextLine();
                        System.out.print( "Please enter the second word: " );
                        word2 = kbd.nextLine();
                        System.out.println( "equalsIgnoreCase( " + word1 + ", "
                            + word2 + " ) = "
                            + ex.equalsIgnoreCase( word1, word2 ) );
                        break;
                    case '7':
                        System.out.print( "Please enter the first word: " );
                        word1 = kbd.nextLine();
                        System.out.print( "Please enter the second word: " );
                        word2 = kbd.nextLine();
                        System.out.println( "equalsIgnoreVowels( " + word1
                            + ", " + word2 + " ) = "
                            + ex.equalsIgnoreVowels( word1, word2 ) );
                        break;
                    case '8':
                        System.out.print( "Please enter a word: " );
                        word1 = kbd.nextLine().toLowerCase().trim();
                        System.out.println( "palindrome( " + word1 + " ) = "
                            + ex.palindrome( word1 ) );
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
