/**
 * A Person class used to define a very basic person.
 *
 * @author George Peck
 * @version Feb 4, 2015
 * @author Period: 1-7
 * @author Assignment: Ch50 Inheritance
 *
 * @author Sources:
 */
public class Person
{
    private String myName;   // name of the person
    private int myAge;       // person's age
    private String myGender; // 'M' for male, 'F' for female


    /**
     * Constructs a person
     * 
     * @param name name of the person
     * @param age person's age
     * @param gender person's gender "M" for male, "F" for female
     */
    public Person( String name, int age, String gender )
    {
        myName = name;
        myAge = age;
        myGender = gender;
    }

    /**
     * Returns the name of the person.
     * @return person's name
     */
    public String getName()
    {
        return myName;
    }

    /**
     * Returns the age of the person.
     * @return person's age
     */
    public int getAge()
    {
        return myAge;
    }

    /**
     * Returns the gender of this person.
     * @return person's gender "M" for male, "F" for female
     */
    public String getGender()
    {
        return myGender;
    }

    /**
     * Sets the name of this person.
     * @param name name of person
     */
    public void setName( String name )
    {
        myName = name;
    }

    /**
     * Sets the age of this person.
     * @param age person's age
     */
    public void setAge( int age )
    {
        myAge = age;
    }

    /**
     * Sets a person's gender 'M' for male, 'F' for female.
     * @param gender "M" for male, "F" for female
     */
    public void setGender( String gender )
    {
        myGender = gender;
    }

    /**
     * Returns a string representation of this person
     * @see java.lang.Object#toString()
     * 
     * @return string representation of this person
     */
    public String toString()
    {
        return myName + ", age: " + myAge + ", gender: " + myGender;
    }
}