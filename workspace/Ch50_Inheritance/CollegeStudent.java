/**
 * A CollegeStudent, is a Student with a class standing and a major
 *
 * @author Bryan Wu
 * @version 2/13/15
 * @author Period: 7
 * @author Assignment: Ch50 Inheritance
 *
 * @author Sources: none
 */
public class CollegeStudent extends Student
{
    private String major;

    private int year;


    /**
     * @param name
     *            name
     * @param age
     *            age
     * @param gender
     *            gender
     * @param idNum
     *            idNumber
     * @param gpa
     *            GPA
     * @param yr
     *            year
     * @param maj
     *            major
     */
    public CollegeStudent(
        String name,
        int age,
        String gender,
        String idNum,
        double gpa,
        int yr,
        String maj )
    {
        super( name, age, gender, idNum, gpa );
        year = yr;
        major = maj;
    }


    // myName, myAge, myGender, myIdNum, myGPA, year, and major.

    /**
     * Get year.
     * 
     * @return year
     */
    public int getYear()
    {
        return year;
    }


    /**
     * Get major.
     * 
     * @return major
     */
    public String getMajor()
    {
        return major;
    }


    /**
     * Set year.
     * 
     * @param yr
     *            year
     */
    public void setYear( int yr )
    {
        year = yr;
    }


    /**
     * Set major.
     * 
     * @param maj
     *            major
     */
    public void setMajor( String maj )
    {
        major = maj;
    }


    /**
     * Returns a string representation of this college student
     * 
     * @see CollegeStudent#toString()
     * @return string representation of this student
     */
    public String toString()
    {
        return super.toString() + ", year: " + year + ", major: " + major;
    }
}
