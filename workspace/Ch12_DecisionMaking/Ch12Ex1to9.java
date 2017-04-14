import java.util.*;


/**
 * Chapter 12 - Decision Making Programming Exercises 1-9.
 * 
 * @author Bryan Wu
 * @version 10/14/14
 * 
 * @author Period - 7
 * @author Assignment - Ch12Ex1to9
 * 
 * @author Sources - none
 */
public class Ch12Ex1to9
{
    /**
     * scan
     */
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch12Ex1to9()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public Ch12Ex1to9( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * Calculate discounted price of item.
     */
    public void discountPrices()
    {
        System.out.print( "Enter amount of purchases: " );
        int cost = scan.nextInt();
        int discount = cost - cost / 10;
        if ( cost > 1000 )
        {
            System.out.print( "Discounted price: " + discount );
        }
        else
        {
            System.out.print( "Discounted price: " + cost );
        }

    }


    /**
     * Total cost of materials.
     */
    public void orderChecker()
    {
        System.out.print( "Number of bolts: " );
        int bolts = scan.nextInt();
        System.out.print( "Number of nuts: " );
        int nuts = scan.nextInt();
        System.out.print( "Number of washers: " );
        int washers = scan.nextInt();
        if ( nuts >= bolts )
        {
            if ( washers >= 2 * bolts )
            {
                System.out.println( "Check the Order: Order is OK." );
            }
            else
            {
                System.out.println( "Check the Order: Too few washers." );
            }
        }
        else
        {
            System.out.println( "Check the Order: Too few nuts." );
            if ( ( washers < 2 * bolts ) )
            {
                System.out.println( "Check the Order: Too few washers." );
            }
        }

        final int boltPrice = 5;
        final int nutPrice = 3;
        final int washerPrice = 1;
        int cost = boltPrice * bolts + nutPrice * nuts + washerPrice * washers;
        System.out.println( "Total cost: " + cost );
    }


    /**
     * Program that helps decide if driver needs gas or not.
     */
    public void lastChanceGas()
    {
        System.out.print( "Tank capacity: " );
        int capacity = scan.nextInt();
        System.out.print( "Gage reading: " );
        int gage = scan.nextInt();
        System.out.print( "Miles per gallon: " );
        int mpg = scan.nextInt();
        double gasLeft = capacity * ( gage * 0.01 );
        double milesDriveable = gasLeft * mpg;
        if ( milesDriveable >= 200 )
        {
            System.out.println( "Safe to Proceed!" );
        }
        else
        {
            System.out.println( "Get Gas!" );
        }

    }


    /**
     * ground sum b33f
     */
    public void groundBeefValueCalc()
    {
        System.out.print( "Price per pound package A: " );
        double priceA = scan.nextDouble();
        System.out.print( "Percent lean package A: " );
        double leanA = scan.nextDouble();
        System.out.print( "Price per pound package B: " );
        double priceB = scan.nextDouble();
        System.out.print( "Percent lean package B: " );
        double leanB = scan.nextDouble();
        double leanCostA = priceA / ( leanA / 100 );
        System.out.println( "Package A cost per pound of lean: " + leanCostA );
        double leanCostB = priceB / ( leanB / 100 );
        System.out.println( "Package B cost per pound of lean: " + leanCostB );
        if ( leanCostA < leanCostB )
        {
            System.out.println( "Package A is the best value." );
        }
        else
        {
            System.out.println( "Package B is the best value." );
        }
    }


    /**
     * Fix Y2K Error
     */
    public void y2KProblemDetector()
    {
        System.out.print( "Year of Birth: " );
        int birth = scan.nextInt();
        System.out.print( "Current year: " );
        int now = scan.nextInt();
        int age = now - birth;
        if ( age >= 0 )
        {
            System.out.print( "Your age: " + age );
        }
        else
        {
            age = age + 100;
            System.out.print( "Your age: " + age );
        }

    }


    /**
     * Program that calculates the wind chill index (WCI).
     */
    public void windChillIndex()
    {

        System.out.print( "Enter the damn wind speed: " );
        double v = scan.nextDouble();
        System.out.print( "Enter the darn temperature: " );
        double t = scan.nextDouble();
        double wci;
        if ( 0 <= v && v <= 4 )
        {
            wci = t;
            System.out.println( "The wind chill index is: " + wci );
        }
        if ( v >= 45 )
        {
            wci = 1.6 * t - 55;
            System.out.println( "The wind chill index is: " + wci );
        }
        wci = 91.4 + ( 91.4 - t )
            * ( 0.0203 * v - 0.304 * Math.sqrt( (double)v ) - 0.474 );
        System.out.println( "The wind chill index is: " + wci );

    }


    /**
     * Program that calculates your age in seconds.
     */
    public void yourAgeInSeconds()
    {
        System.out.print( "Enter your goddamn age in years: " );
        long years = scan.nextLong();
        long yearDays = 365 * years;
        System.out.print( "Enter month number: " );
        long months = scan.nextLong();
        long monthDays = 0;
        if ( months > 0 ) // 1 month
        {
            monthDays = 31;
            {
                if ( months > 1 ) // 2 months
                {
                    monthDays = monthDays + 28;
                    if ( months > 2 ) // 3 months
                    {
                        monthDays = monthDays + 31;
                        if ( months > 3 )
                        {
                            monthDays = monthDays + 30;
                            if ( months > 4 )
                            {
                                monthDays = monthDays + 31;
                                if ( months > 5 )
                                {
                                    monthDays = monthDays + 30;
                                    if ( months > 6 )
                                    {
                                        monthDays = monthDays + 31;
                                        if ( months > 7 )
                                        {
                                            monthDays = monthDays + 31;
                                            if ( months > 8 )
                                            {
                                                monthDays = monthDays + 30;
                                                if ( months > 9 )
                                                {
                                                    monthDays = monthDays + 31;
                                                    if ( months > 10 )
                                                    {
                                                        monthDays 
                                                            = monthDays + 30;
                                                        if ( months > 11 )
                                                        {
                                                            monthDays 
                                                                = monthDays 
                                                                    + 31;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.print( "Enter the day number: " );
        long days = scan.nextLong();
        long totalDays = yearDays + monthDays + days;
        long seconds = totalDays * 24 * 60 * 60;
        System.out.println( "Your are " + seconds + " seconds old." );
    }


    /**
     * Program that determines the price of a movie ticket
     */
    public void matineeMovieTickets()
    {
        System.out.print( "Enter your age: " );
        double age = scan.nextDouble();
        System.out.print( "Enter the 24-hour clock time: " );
        double time = scan.nextDouble();
        double price;
        if ( age <= 13 )
        {
            price = 4.00;
            if ( time < 1700 )
            {
                price = 2.00;
            }
            System.out.println( "The ticket price is $" + price );
        }
        if ( age > 13 )
        {
            price = 8.00;
            if ( time < 1700 )
            {
                price = 5.00;
            }
            System.out.println( "The ticket price is $" + price );
        }
    }


    /**
     * 
     */
    public void midnightMadness()
    {
        System.out.print( "Enter your age: " );
        double age = scan.nextDouble();
        System.out.print( "Enter the 24-hour clock time: " );
        double time = scan.nextDouble();
        double price;
        if ( age <= 13 )
        {
            price = 4.00;
            if ( time < 1700 )
            {
                price = 2.00;
            }
            if ( time > 2200 )
            {
                System.out.println( "GET OUT YOU'RE TOO YOUNG FOR THIS!" );
            }
            System.out.println( "The ticket price is $" + price );
        }
        if ( age > 13 )
        {
            price = 8.00;
            if ( time < 1700 )
            {
                price = 5.00;
            }
            if ( time > 2200 )
            {
                price = 4.00;
            }
            System.out.println( "The ticket price is $" + price );
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

        Ch12Ex1to9 exercise = new Ch12Ex1to9();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "    (1) Discount Prices" );
            System.out.println( "    (2) Order Checker" );
            System.out.println( "    (3) Last Chance Gas" );
            System.out.println( "    (4) Ground Beef Value Calculator" );
            System.out.println( "    (5) Y2K Problem Detector" );
            System.out.println( "    (6) Wind Chill Index" );
            System.out.println( "    (7) Your Age in Seconds" );
            System.out.println( "    (8) Matinee Movie Tickets" );
            System.out.println( "    (9) Midnight Madness" );
            System.out.println( "    (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                        exercise.discountPrices();
                        break;
                    case '2':
                        exercise.orderChecker();
                        break;
                    case '3':
                        exercise.lastChanceGas();
                        break;
                    case '4':
                        exercise.groundBeefValueCalc();
                        break;
                    case '5':
                        exercise.y2KProblemDetector();
                        break;
                    case '6':
                        exercise.windChillIndex();
                        break;
                    case '7':
                        exercise.yourAgeInSeconds();
                        break;
                    case '8':
                        exercise.matineeMovieTickets();
                        break;
                    case '9':
                        exercise.midnightMadness();
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
