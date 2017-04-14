import java.util.*;
import java.io.*;


/**
 * Modification of the the Insurance Program so that it uses only normal
 * programming logic to check the age and to calculate the insurance.
 *
 * @author Bryan Wu
 * @version Apr 24, 2015
 * @author Period: 7
 * @author Assignment: Ch81_MoreExceptions
 *
 * @author Sources: None
 */
public class RateCalc
{
    /**
     * Insurance calculator method.
     * 
     * @param birthYear
     *            birthYear
     * @return calcInsurance
     */
    public static int calcInsurance( int birthYear ) throws Exception
    {
        final int currentYear = 2010;
        int age = currentYear - birthYear;

        if ( age < 16 )
        {
            throw new Exception( "Age is: " + age );
        }
        else
        {
            int drivenYears = age - 16;
            if ( drivenYears < 4 )
            {
                return 1000;
            }
            else
            {
                return 600;
            }
        }
    }


    /**
     * Main method.
     * 
     * @param a
     *            a
     */
    public static void main( String[] a )
    {
        Scanner scan = new Scanner( System.in );
        System.out.println( "Enter birth year:" );
        int inData = 0;

        try
        {
            inData = scan.nextInt();
            try
            {
                System.out.println( "Your insurance is: "
                    + calcInsurance( inData ) );
            }

            catch ( Exception oops )
            {
                System.out.println( oops.getMessage()
                    + " Too young for insurance!" );
                oops.printStackTrace();
            }
        }
        catch ( InputMismatchException ex )
        {
            ex.printStackTrace();
        }

    }
}
