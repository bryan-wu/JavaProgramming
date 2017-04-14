/**
 * Program that sorts employees by name and year of birth.
 *
 * @author Bryan Wu
 * @version 2/26/15
 * @author Period: 7
 * @author Assignment: Ch53B_ComparableInterface
 *
 * @author Sources: None
 */
public class Employee implements Comparable<Employee>
{
    private String firstName;

    private String lastName;

    private int birthYear;


    /**
     * Employee constructor.
     * 
     * @param f
     *            first name
     * @param l
     *            last name
     * @param year
     *            year of birth
     */
    public Employee( String f, String l, int year )
    {
        firstName = f;
        lastName = l;
        birthYear = year;
    }


    /**
     * Return first name.
     *
     * @return firstName
     */
    String getFirstName()
    {
        return firstName;
    }


    /**
     * Return last name.
     * 
     * @return lastName
     */
    String getLastName()
    {
        return lastName;
    }


    /**
     * Return year of birth.
     * 
     * @return birth year
     */
    int getBirthYear()
    {
        return birthYear;
    }


    /**
     * Compare employee name and/or year of birth.
     * @return compareTo
     * @param other other diamond
     */
    public int compareTo( Employee other )
    {
        String otherLastName = other.getLastName();
        String otherFirstName = other.getFirstName();
        int otherBirthYear = other.getBirthYear();

        int lastNameTest = lastName.compareTo( otherLastName );
        if ( lastNameTest != 0 )
        {
            return lastNameTest;
        }
        else
        {
            int firstNameTest = firstName.compareTo( otherFirstName );
            if ( firstNameTest != 0 )
            {
                return firstNameTest;
            }
            else
            {
                int birthYearDifference = birthYear - otherBirthYear;
                return birthYearDifference;
            }
        }
    }


    /**
     * <p>
     * A generic toString implementation to display the values of all fields
     * <em>declared in this class</em>. Output should be of the form:
     * 
     * <pre>
     * firstName lastName birthYear
     * </pre>
     * 
     * for example
     * 
     * <pre>
     * Elmer Adams 1976
     * </pre>
     * 
     * All values should be accessed using the getter methods of the class.
     * </p>
     * 
     * @return a string representation of this Employee.
     */
    public String toString()
    {
        return firstName + " " + lastName + " " + birthYear;
    }

}