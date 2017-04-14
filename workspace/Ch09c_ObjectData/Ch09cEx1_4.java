/**
 * Chapter 9c - Object Data Programming Exercises 1-4
 * 
 * @author Bryan Wu
 * @version 10/7/2014
 * 
 *          Period - 7 Assignment - Ch09bEx1_3
 * 
 *          Sources - none
 */
public class Ch09cEx1_4
{

    /**
     * Object Created at Run Time
     */
    public void objAtRuntime()
    {
        String str;
        str = new String( "$Gimmie the dough$" );
        String secondVariable = ( "Justin Time" );
        System.out.println( str );
        System.out.println( secondVariable );
    }


    /**
     * String Length
     */
    public void stringLength()
    {
        String str;
        int len;

        str = new String( "ramirez" );

        len = str.length();

        System.out.println( "The length is: " + len );
    }


    /**
     * A String Method that creates a new String
     */
    public void createNewString()
   {
       String first = new String("    In a Hole    in the ground there lived a Hobbit.   ");
       System.out.println(first);
       String second;
       second = first.trim();
       System.out.println(second);
   }


    /**
     * Play with substring() exercise
     */
    public void playWithSubstring()
    {
        String str = new String( "Golf is a good walk spoiled." ); // create the
                                                                   // original
                                                                   // object

        String sub = str.substring( 16,8 ); // create a new object from the
                                         // original

        System.out.println( sub );
    }


    /**
     * Testing method: instantiates a Ch09cEx1_4 object and then invokes each
     * method
     * 
     * @param args
     *            command-line parameters (not used)
     */
    public static void main( String[] args )
    {
        Ch09cEx1_4 exercise = new Ch09cEx1_4();

        exercise.objAtRuntime();
        System.out.println();

        exercise.stringLength();
        System.out.println();

        exercise.createNewString();
        System.out.println();

        exercise.playWithSubstring();
        System.out.println();
    }
}
