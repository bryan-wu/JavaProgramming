import java.util.ArrayList;
import java.util.Arrays;


/**
 * Creates a Person, Student, Teacher and CollegeStudent objects for test
 * purposes
 *
 * @author George Peck
 * @version Feb 4, 2015
 * @author Period: 1-7
 * @author Assignment: Ch50 Inheritance
 *
 * @author Sources: None
 */
public class Testing
{
    /**
     * Driver program to test a variety of classes.
     * 
     * @param args
     *            command line arguments (not used)
     */
    public static void main( String[] args )
    {
        ArrayList<Character> colorGrades = new ArrayList<Character>( 23 );
        Character[] colorGradeList = new Character[] { 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z' };
        colorGrades.addAll( Arrays.asList( colorGradeList ) );

        System.out.println( colorGrades );
    }
}