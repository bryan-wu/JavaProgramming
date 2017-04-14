/**
 * Running this program and observing the stack trace.
 *
 * @author Bryan Wu
 * @version Apr 24, 2015
 * @author Period: 7
 * @author Assignment: Ch81_MoreExceptions
 *
 * @author Sources: None
 */
class Divider
{
    public void methodA()
    {
        System.out.println( "Result: " + 12 / 4 );
    }


    public void methodB()
    {
        System.out.println( "Result: " + 12 / 3 );
    }


    public void methodC()
    {
        System.out.println( "Result: " + 12 / 0 );
    }
}


public class TestTraceEx3
{
    public static void main( String[] args )
    {
        Divider dvdr = new Divider();

        try
        {
            dvdr.methodA();
            dvdr.methodB();
            dvdr.methodC();
        }
        catch ( ArithmeticException oops )
        {
            oops.printStackTrace();
        }
    }
}
