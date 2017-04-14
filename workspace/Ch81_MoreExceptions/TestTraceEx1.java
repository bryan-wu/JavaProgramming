/**
 * Write a testing class TestTrace that contains the static main() method, and
 * another class CallEg that contains three methods. The main() method will
 * create a CallEg object and call its methodA().
 *
 * @author Bryan Wu
 * @version Apr 24, 2015
 * @author Period: 7
 * @author Assignment: Ch81_MoreExceptions
 *
 * @author Sources: None
 */
class CallEg
{
    /**
     * Method that calls Method B
     */
    public void methodA() throws ArithmeticException
    {
        try
        {
            methodB();
        }
        catch ( ArithmeticException ex )
        {
            ex.printStackTrace();
            throw ex;
        }
    }


    /**
     * Method that calls Method C
     */
    public void methodB() throws ArithmeticException
    {
        try
        {
            methodC();
        }
        catch ( ArithmeticException ex )
        {
            ex.printStackTrace();
            throw ex;
        }
    }


    /**
     * Method that utterly destroys the world be dividing by zero.
     */
    public void methodC() throws ArithmeticException
    {
        try
        {
            int numerator = 3, denominator = 0, quotient = 0;
            quotient = numerator / denominator;
        }
        catch ( ArithmeticException ex )
        {
            ex.printStackTrace();
            throw ex;
        }
    }
}


/**
 * Test class.
 */
public class TestTraceEx1
{
    public static void main( String[] args )
    {
        CallEg eg = new CallEg(); // use default constructor
        try
        {
            eg.methodA();
        }
        catch ( ArithmeticException oops )
        {
            oops.printStackTrace();
        }
    }
}
