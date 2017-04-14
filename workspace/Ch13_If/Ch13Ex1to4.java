import java.util.*;


/**
 * Chapter 13 - Single-branch if Statements Programming Exercises 1-4
 * 
 * @author Bryan Wu
 * @version 10/16/14
 * 
 * @author Period - 7
 * @author Assignment - Ch13Ex1to4
 * 
 * @author Sources - chuck norris
 */
public class Ch13Ex1to4
{
    /**
     * scan
     */
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch13Ex1to4()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch13Ex1to4( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * Program that calculates price of order.
     */
    public void internetDelicatessen()
    {
        System.out.print( "Enter the item: " );
        String item = scan.nextLine();
        System.out.print( "Enter the price: " );
        int priceInCents = scan.nextInt();
        System.out.print( "Overnight delivery (0==no, 1==yes): " );
        int delivery = scan.nextInt();
        double shipping = 0;
        double price = priceInCents * 0.01;
        if ( delivery == 0 )
        {
            if ( price < 10 )
            {
                shipping = 2.00;
            }
            else
            {
                shipping = 3.00;
            }
            System.out.println( "Invoice:" );
            System.out.println( "\t" + item + "\t" + price );
            System.out.println( "\tShipping\t" + shipping );
            double total = price + shipping;
            System.out.println( "\tTotal\t\t" + total );
        }
        double shipping2 = 0;
        if ( delivery == 1 )
        {
            if ( price < 10 )
            {
                shipping2 = 7.00;

            }
            else
            {
                shipping2 = 8.00;
            }
            System.out.println( "Invoice:" );
            System.out.println( "\t" + item + "\t" + price );
            System.out.println( "\tShipping\t" + shipping2 );
            double total2 = price + shipping2;
            System.out.println( "\tTotal\t\t" + total2 );
        }
    }


    /**
     * Program that calculates maximum possible steam engine efficiency.
     */
    public void steamEngineEfficiency()
    {
        System.out.print( "Enter the air temperature in Kelvin: " );
        double tAir = scan.nextDouble();
        System.out.print( "Enter the steam temperature in Kelvin: " );
        double tSteam = scan.nextDouble();
        double efficiency;
        if ( tSteam < 373 )
        {
            efficiency = 0;
        }
        else
        {
            efficiency = 1 - tAir / tSteam;
        }
        System.out.println( "Maximum possible efficiency of"
            + " a steam engine:\t" + efficiency );
    }


    /**
     * Program that calculates recommended heating time.
     */
    public void microwaveOven()
    {
        System.out.print( "Enter the number of items: " );
        double items = scan.nextDouble();
        System.out.print( "Enter the single-item heating time: " );
        double heatTime = scan.nextDouble();
        if ( items == 2 )
        {
            heatTime = heatTime * 1.5;
        }
        if ( items == 3 )
        {
            heatTime = 2 * heatTime;
        }
        if ( items > 3 )
        {
            heatTime = 0;
            System.out.println( "Heating more than three "
                + "items at once is not recommended." );
        }
        System.out.println( "Recommended heating time:\t" + heatTime );
    }


    /**
     * Fantasy game stats.
     */
    public void fantasyGame()
    {
        System.out.print( "Enter the name of your character: " );
        String dealer = scan.nextLine();
        System.out.print( "Enter strength (1-10): " );
        int strength = scan.nextInt();
        System.out.print( "Enter health (1-10): " );
        int health = scan.nextInt();
        System.out.print( "Enter luck (1-10): " );
        int luck = scan.nextInt();
        int totalPoints = strength + health + luck;
        if ( totalPoints <= 15 )
        {
            System.out.println( dealer + ", Strength: " + strength
                + ", Health: " + health + ", Luck: " + luck );
        }
        if ( totalPoints > 15 )
        {
            strength = 5;
            health = 5;
            luck = 5;
            System.out.println( "You have given your "
                + "character too many points!" );
            System.out.println( "Default values have been assigned:" );
            System.out.println( "" );
            System.out.println( "" );
            System.out.println( dealer + ", Strength: " + strength
                + ", Health: " + health + ", Luck: " + luck );
        }
    }


    /**
     * Testing method: instantiates a Lesson15Exercises object and then invokes
     * each method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch13Ex1to4 exercise = new Ch13Ex1to4();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Internet Delicatessen" );
            System.out.println( "   (2) Steam Engine Efficiency" );
            System.out.println( "   (3) Microwave Oven" );
            System.out.println( "   (4) Fantasy Game" );
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
                        exercise.internetDelicatessen();
                        break;
                    case '2':
                        exercise.steamEngineEfficiency();
                        break;
                    case '3':
                        exercise.microwaveOven();
                        break;
                    case '4':
                        exercise.fantasyGame();
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
