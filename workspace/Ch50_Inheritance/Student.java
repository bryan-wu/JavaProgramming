/**
 * A student, is a Person with an id number and a grade point average
 *
 *  @author  George Peck
 *  @version Feb 4, 2015
 *  @author  Period: 1-7
 *  @author  Assignment: Ch50 Inheritance
 *
 *  @author  Sources:
 */
public class Student extends Person
{
    private String myIdNum; // Student Id Number
    private double myGPA;   // grade point average

    /**
     * Constructs a student
     * 
     * @param name student's name
     * @param age students age
     * @param gender students gender "M" for male, "F" for female
     * @param idNum students identification code
     * @param gpa student's grade point average
     */
    public Student( String name, int age, String gender, String idNum,
        double gpa )
    {
        // use the super class' constructor
        super( name, age, gender );

        // initialize what's new to Student
        myIdNum = idNum;
        myGPA = gpa;
    }

    /**
     * Get this students identification code.
     * @return ID code
     */
    public String getIdNum()
    {
        return myIdNum;
    }

    /**
     * Get this student's grade point average.
     * @return grade point average
     */
    public double getGPA()
    {
        return myGPA;
    }

    /**
     * Sets this students identification code.
     * @param idNum identification code
     */
    public void setIdNum( String idNum )
    {
        myIdNum = idNum;
    }

    /**
     * Sets the student's grade point average.
     * @param gpa grade point average
     */
    public void setGPA( double gpa )
    {
        myGPA = gpa;
    }

    /**
     * Returns a string representation of this student
     * @see Person#toString()
     * @return string representation of this student
     */
    public String toString()
    {
        return super.toString() + ", student id: " + myIdNum + ", gpa: "
            + myGPA;
    }
}
