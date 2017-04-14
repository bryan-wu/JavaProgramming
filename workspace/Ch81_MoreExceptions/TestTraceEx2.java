/**
 * Modified code of the previous exercise so that you have a testing class
 * TestTrace and three classes CallEgA, CallEgB, and CallEgC. Class CallEgA has
 * a method which constructs a CallEgB object and calls its method. Class
 * CallEgB has a method which constructs a CallEgC object and calls its method.
 * The method of CallEgC divides by zero.
 *
 * @author Bryan Wu
 * @version Apr 24, 2015
 * @author Period: 7
 * @author Assignment: Ch81_MoreExceptions
 *
 * @author Sources: None
 */

/**
 * CallEgA Class.
 */
class CallEgA
{

    public void method()
    {
        CallEgB eg = new CallEgB();
        eg.method();
    }
}


/**
 * CallEgB Class
 */
class CallEgB
{
    public void method()
    {
        CallEgC eg = new CallEgC();
        eg.method();
    }
}


/**
 * CallEgC Class.
 */
class CallEgC
{
    void method()
    {
        int a = 4 / 0;
    }
}


/**
 * Test Class.
 */
public class TestTraceEx2
{

    public static void main( String[] args )
    {
        CallEgA eg = new CallEgA(); // use default constructor
        try
        {
            eg.method();
        }
        catch ( ArithmeticException oops )
        {
            oops.printStackTrace();
        }
    }
}
