/**
 * A Teacher is a Person with a subject and a salary
 *
 * @author Bryan Wu
 * @version 2/12/15
 * @author Period: 7
 * @author Assignment: Ch50 Inheritance
 *
 * @author Sources: none
 */
public class Teacher extends Person
{
    private String subject;

    private double salary;


    /**
     * @param name
     *            name
     * @param age
     *            age
     * @param gender
     *            gender
     * @param sbjt
     *            subject
     * @param sal
     *            salary
     */
    public Teacher( String name, int age, String gender, String sbjt
        , double sal )
    {
        super( name, age, gender );
        subject = sbjt;
        salary = sal;

    }


    /**
     * Get subject.
     * 
     * @return subject
     */
    public String getSubject()
    {
        return subject;
    }


    /**
     * Get salary.
     * 
     * @return salary
     */
    public double getSalary()
    {
        return salary;
    }


    /**
     * Set subject.
     * 
     * @param sbjt
     *            subject
     */
    public void setSubject( String sbjt )
    {
        subject = sbjt;
    }


    /**
     * Set salary.
     * 
     * @param sal
     *            salary
     */
    public void setSalary( double sal )
    {
        salary = sal;
    }


    /**
     * Returns a string representation of this teacher
     * 
     * @see Teacher#toString()
     * @return string representation of this student
     */

    public String toString()
    {
        return super.toString() + ", subject: " + subject + ", salary: "
            + salary;
    }
}
