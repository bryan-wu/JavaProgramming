/**
 * PhoneBook assignment using ArrayLists.
 * 
 * @author Bryan Wu
 * @version 1/26/15
 * @author Period - 7
 * @author Assignment - Ch54 ArrayList Phonebook
 * @author Sources - none
 */
public class PhoneEntry implements Comparable
{
    private String firstName; // first name of a person

    private String lastName; // first name of a person

    private String phoneNum; // their phone number


    /**
     * Constructs PhoneEntry object
     * 
     * @param fName
     *            first name
     * @param lName
     *            last name
     * @param phone
     *            phone number
     */
    public PhoneEntry( String fName, String lName, String phone )
    {
        firstName = fName;
        lastName = lName;
        phoneNum = phone;
    }


    /**
     * Gets the firstName attribute of the PhoneEntry object
     * 
     * @return first name
     */
    public String getFirstName()
    {
        return firstName;
    }


    /**
     * Gets the lastName attribute of the PhoneEntry object
     * 
     * @return last name
     */
    public String getLastName()
    {
        return lastName;
    }


    /**
     * Gets the phoneNum attribute of the PhoneEntry object
     * 
     * @return phone number
     */
    public String getPhoneNum()
    {
        return phoneNum;
    }


    public int compareTo( Object other )
    {
        PhoneEntry pe = (PhoneEntry)other;
        String otherLastFirst = pe.lastName + " " + pe.firstName;

        String lastFirst = lastName + " " + firstName;

        int result = lastFirst.compareTo( otherLastFirst );

        return result;
    }


    public boolean equals( Object other )
    {
        return compareTo( other ) == 0;
        // return firstName.equals(((PhoneEntry)other).firstName) &&
        // lastName.equals(((PhoneEntry)other).lastName);
    }


    public String toString()
    {
        return firstName + " " + lastName + " " + phoneNum;
    }
}
