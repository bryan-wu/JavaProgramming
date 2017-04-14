import java.util.*;


/**
 * Compare diamonds by carot, clarity, color, and cut. it represents, and how to
 * use it.
 *
 * @author Bryan Wu
 * @version 2/26/15
 * @author Period: 7
 * @author Assignment: Ch53B_ComparableInterface
 *
 * @author Sources: none
 */
public class Diamond implements Comparable<Diamond>
{
    private String stockNumber;

    private double carot; /* size of the diamond */

    private String clarity; /* clarity grade of the diamond */

    private char color; /* color grade D-Z */

    private String cut; /* name of the cut */


    /**
     * Diamond constructor.
     * 
     * @param s
     *            Stock
     * @param car
     *            carot
     * @param clar
     *            clarity
     * @param col
     *            color
     * @param ct
     *            cut
     */
    public Diamond( String s, double car, String clar, char col, String ct )
    {
        stockNumber = s;
        carot = car;
        clarity = clar;
        color = col;
        cut = ct;
    }


    /**
     * Get stock.
     * 
     * @return getStock
     */
    public String getStock()
    {
        return stockNumber;
    }


    /**
     * Get carot.
     * 
     * @return getCarot()
     */
    public double getCarot()
    {
        return carot;
    }


    /**
     * Get clarity.
     * 
     * @return getClarity
     */
    public String getClarity()
    {
        return clarity;
    }


    /**
     * Get COlor
     * 
     * @return getColor
     */
    public char getColor()
    {
        return color;
    }


    /**
     * Get cut.
     * 
     * @return getCut
     */
    public String getCut()
    {
        return cut;
    }


    // Write compareTo() so that diamonds are ordered first by carot, then by
    // clarity OR color, whichever is better for the particular diamond. Since
    // there are 23 grades of color, but only 11 grades of clarity, regard the
    // first two color grades as equal in grade to the first grade of clarity,
    // the next two color grades equal in grade to the second grade of clarity,
    // and so on. Write compareTo() so that better diamonds appear before poor
    // diamonds. This means that
    //
    // goodDiamond.compareTo( poorDiamond )
    //
    // returns a negative value. Notice that large carot diamonds will appear
    // first on the list, the reverse of the usual order for numbers.

    /**
     * Employee constructor.
     * 
     * @param other
     *            other diamond
     * @return compareTo
     */
    public int compareTo( Diamond other )
    {
        String otherClarity = other.getClarity();
        Character otherColor = other.getColor();
        int indexOfClarity = 0;
        int indexOfClarityOther = 0;
        int indexOfColor = 0;
        int indexOfColorOther = 0;
        int colorRank = 0;
        int colorRankOther = 0;
        int test;
        double otherCarot = other.getCarot();

        // BELOW: Preparing ArrayList of clarity grades
        ArrayList<String> clarityGrades = new ArrayList<String>();

        String[] clarityGradeList = new String[] { "FL", "IF", "VVS1", "VVS2",
            "VS1", "VS2", "SI1", "SI2", "I1", "I2", "I3" };
        clarityGrades.addAll( Arrays.asList( clarityGradeList ) );

        // BELOW: Preparing ArrayList of color grades
        ArrayList<Character> colorGrades = new ArrayList<Character>( 11 );

        Character[] colorGradeList = new Character[] { 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z' };
        colorGrades.addAll( Arrays.asList( colorGradeList ) );
        indexOfColor = colorGrades.indexOf( color );
        indexOfColorOther = colorGrades.indexOf( otherColor );

        // BELOW: preparing values for comparison of clarity grades
        indexOfClarity = clarityGrades.indexOf( clarity );
        indexOfClarityOther = clarityGrades.indexOf( otherClarity );

        // BELOW: preparing values for comparison of color grades
        if ( indexOfColor == 22 )
        {
            colorRank = 10;
        }
        else
        {
            colorRank = colorGrades.indexOf( color ) / 2;
        }
        if ( indexOfColorOther == 22 )
        {
            colorRankOther = 10;
        }
        else
        {
            colorRankOther = colorGrades.indexOf( otherColor ) / 2;
        }

        // BELOW: checking if clarity grade or color grade is
        // better for the diamond (want the smaller index)
        test = Math.min( indexOfClarity, colorRank );
        if ( colorRank == colorRankOther )
        {
            test = indexOfClarity;
        }
        if ( indexOfClarity == indexOfClarityOther )
        {
            test = colorRank;
        }

        if ( carot == otherCarot )
        {
            if ( test == indexOfClarity ) // clarity grade comparison
            {
                Integer iC1 = new Integer( indexOfClarity );
                Integer iC2 = new Integer( indexOfClarityOther );
                int result = iC1.compareTo( iC2 );
                return result;
            }
            else
            // color grade comparison
            {
                Integer iC1 = new Integer( indexOfColor );
                Integer iC2 = new Integer( indexOfColorOther );
                int result = iC1.compareTo( iC2 );
                return result;
            }
        }
        else
        {
            if ( carot > otherCarot )
            {
                return -1;
            }
            else
            {
                return 1;
            }
        }
    }


    /**
     * <p>
     * A generic toString implementation to display the values of all fields
     * <em>declared in this class</em>. Output should be of the form:
     * 
     * <pre>
     * stockNumber carot clarity color cut
     * </pre>
     * 
     * for example
     * 
     * <pre>
     * C5619 2.8 VVS1 E pear
     * </pre>
     * 
     * All values should be accessed using the getter methods of the class.
     * </p>
     * 
     * @return a string representation of this Diamond.
     */
    public String toString()
    {
        return stockNumber + " " + carot + " " + clarity + " " + color + " "
            + cut;
    }
}