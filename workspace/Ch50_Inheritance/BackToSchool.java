/**
 *  Creates a Person, Student, Teacher and CollegeStudent objects for 
 *  test purposes
 *
 *  @author  George Peck
 *  @version Feb 4, 2015
 *  @author  Period: 1-7
 *  @author  Assignment: Ch50 Inheritance
 *
 *  @author  Sources: None
 */
public class BackToSchool
{
    /**
     * Driver program to test a variety of classes.
     * 
     * @param args command line arguments (not used)
     */
    public static void main( String[] args )
    {
        Person bob = new Person( "Coach Bob", 27, "M" );
        System.out.println( bob );

        Student lynne = new Student( "Lynne Brooke", 16, "F", "HS95129", 3.5 );
        System.out.println( lynne );

        Teacher mrJava = new Teacher( "Duke Java", 34, "M",
                               "Computer Science", 50000 );
        System.out.println( mrJava );

        CollegeStudent ima = new CollegeStudent( "Ima Frosh", 18, "F",
                                   "UCB123", 4.0, 1, "English" );
        System.out.println( ima );
    }
}
