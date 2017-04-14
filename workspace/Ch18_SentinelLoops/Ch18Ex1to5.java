import java.util.*;


/**
 * Chapter 18 - Sentinel Controlled Loops Exercises 1-5.
 * 
 * @author Bryan Wu
 * @version 10/31/14
 * 
 * @author Period - 7
 * @author Assignment - Ch18Ex1to5
 * 
 * @author Sources - none
 */
public class Ch18Ex1to5
{
    /**
     * scan
     */
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch18Ex1to5()
    {
        scan = new Scanner( System.in );

    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch18Ex1to5( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * miles per gallon
     */
    public void milesPerGallon()
    {

        System.out.println( "Miles Per Gallon Program" );
        System.out.println( "Initial miles: " );
        int initialMiles = scan.nextInt();
        if ( initialMiles < 0 )
        {
            System.out.println( "bye scrub" );
            return;
        }
        System.out.println( "Final miles: " );
        int finalMiles = scan.nextInt();
        System.out.println( "Gallons: " );
        int gallons = scan.nextInt();
        double mpg = ( finalMiles - initialMiles ) / gallons;
        while ( initialMiles >= 0 )
        {
            System.out.println( "Miles per Gallon: " + mpg );
            System.out.println( "" );
            System.out.println( "Initial miles: " );
            initialMiles = scan.nextInt();
            if ( initialMiles < 0 )
            {
                System.out.println( "bye scrub" );
                return;
            }
            System.out.println( "Final miles: " );
            finalMiles = scan.nextInt();
            System.out.println( "Gallons: " );
            gallons = scan.nextInt();
            mpg = ( finalMiles - initialMiles ) / gallons;
        }
    }


    /**
     * in range adder
     */
    public void inRangeAdder()
    {
        System.out.println( "In-range Adder" );
        System.out.println( "" );
        System.out.println( "Low end of range: " );
        int minRange = scan.nextInt();
        System.out.println( "High end of range: " );
        int maxRange = scan.nextInt();
        System.out.println( "Enter data: " );
        int value = scan.nextInt();
        int inRangeSum = 0;
        int outRangeSum = 0;
        while ( value != 0 )
        {
            if ( value >= minRange && value <= maxRange )
            {
                inRangeSum = inRangeSum + value;
            }
            if ( value < minRange || value > maxRange )
            {
                outRangeSum = outRangeSum + value;
            }
            System.out.println( "Enter data: " );
            value = scan.nextInt();
        }
        System.out.println( "Sum of in range values: " + inRangeSum );
        System.out.println( "Sum of out of range values: " + outRangeSum );
        // In-range Adder
        //
        // Low end of range: 20
        // High end of range: 50
        // Enter data:
    }


    /**
     * shipping cost calc
     */
    public void shippingCostCalc()
    {
        System.out.println( "Weight of Order: " );
        int weight = scan.nextInt();
        double shipping;
        while ( weight > 0 )
        {
            shipping = 0;
            if ( weight <= 10 )
            {
                shipping = shipping + 3.00;
                System.out.println( "Shipping Cost: $" + shipping );
            }
            if ( weight > 10 )
            {
                shipping = ( weight - 10 ) * 0.25 + 3.00;
                System.out.println( "Shipping Cost: $" + shipping );
            }
            System.out.println( "" );
            System.out.println( "Weight of Order: " );
            weight = scan.nextInt();
        }
        System.out.println( "bye" );
    }


    /**
     * area of rectangle
     */
    public void areaOfRectangle()
    {
        System.out.println( "First corner X coordinate: " );
        int x1 = scan.nextInt();
        System.out.println( "First corner Y coordinate: " );
        int y1 = scan.nextInt();
        System.out.println( "Second corner X coordinate: " );
        int x2 = scan.nextInt();
        System.out.println( "Second corner Y coordinate: " );
        int y2 = scan.nextInt();
        int width = Math.abs( x2 - x1 );
        int height = Math.abs( y2 - y1 );
        int area = width * height;
        while ( height != 0 && width != 0 )
        {
            System.out.println( "Width: " + width + " Height: " + height
                + " Area: " + area );
            System.out.println( "" );
            System.out.println( "First corner X coordinate: " );
            x1 = scan.nextInt();
            System.out.println( "First corner Y coordinate: " );
            y1 = scan.nextInt();
            System.out.println( "Second corner X coordinate: " );
            x2 = scan.nextInt();
            System.out.println( "Second corner Y coordinate: " );
            y2 = scan.nextInt();
            width = Math.abs( x2 - x1 );
            height = Math.abs( y2 - y1 );
            area = width * height;
        }
        System.out.println( "Width: " + width + " Height: " + height
            + " Area: " + area );
        // Computer Aided Design Program
        //
        // First corner X coordinate: 100
        // First corner Y coordinate: 100
        // Second corner X coordinate: 250
        // Second corner Y coordinate: 200
        // Width: 150 Height: 100 Area: 15000
    }


    /**
     * login simulator
     */
    public void loginSimulator()
    {
        System.out.print( "User Name: " );
        String username = scan.nextLine();
        System.out.print( "Password : " );
        String password = scan.nextLine();

        while ( !username.equals( "quit" ) && !password.equals( "exit" ) )
        {
            if ( username.equals( "joy" ) && password.equals( "sun" ) )
            {
                System.out.println( "You have logged on with priority 4" );
            }
            else if ( username.equals( "gates" )
                && password.equals( "monopoly" ) )
            {
                System.out.println( "You have logged on with priority 1" );
            }
            else if ( username.equals( "jobs" ) && password.equals( "apple" ) )
            {
                System.out.println( "You have logged on with priority 3" );
            }
            else if ( username.equals( "root" ) && password.equals( "secret" ) )
            {
                System.out.println( "You have logged on with priority 5" );
            }
            else
            {
                System.out.println( "Logon failed" );
            }
            System.out.print( "User Name: " );
            username = scan.nextLine();
            System.out.print( "Password : " );
            password = scan.nextLine();
        }
        System.out.println( "System shutting down." );
        System.out.println( "Bye." );
        
        // user name; password; priority
        // joy; sun; 4
        // gates; monopoly; 1
        // jobs; apple; 3
        // root; secret; 5

        // User Name: hacker
        // Password : crack
        // Logon failed
        // User Name: jobs
        // Password : apple
        // You have logged on with priority 3
        // User Name: quit
        // Password : exit
        // System shutting down.
        // Bye.
    }


    /**
     * Testing method: instantiates a Ch18Ex1to5 object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch18Ex1to5 exercise = new Ch18Ex1to5();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Miles per Gallon" );
            System.out.println( "   (2) In-range Adder" );
            System.out.println( "   (3) Shipping Cost Calculator" );
            System.out.println( "   (4) Area of Rectangles" );
            System.out.println( "   (5) Login simulator" );
            System.out.println( "   (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                        exercise.milesPerGallon();
                        break;
                    case '2':
                        exercise.inRangeAdder();
                        break;
                    case '3':
                        exercise.shippingCostCalc();
                        break;
                    case '4':
                        exercise.areaOfRectangle();
                        break;
                    case '5':
                        exercise.loginSimulator();
                        break;
                    default:
                        if ( response.toLowerCase().charAt( 0 ) == 'q' )
                        {
                            done = true;
                        }
                        else
                        {
                            System.out.print( "Invalid Choice" );
                        }
                        break;
                }
            }
        } while ( !done );
        System.out.println( "Goodbye!" );
    }
}
