import java.util.*;


/**
 * Chapter 20 - Random Class Exercises 3, 5, 7 & 8.
 * 
 * @author Bryan Wu
 * @version 11/10/14
 * 
 * @author Period - 7
 * @author Assignment - Ch20Exercises
 * 
 * @author Sources - none
 */
public class Ch20Exercises
{
    /**
     * scan
     */
    Scanner scan;

    Random rand = new Random();


    /**
     * Constructs a Scanner for input from the console.
     */
    public Ch20Exercises()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     * @param seed
     *            seed to use for random number generator
     */
    public Ch20Exercises( String str, long seed )
    {
        scan = new Scanner( str );
        rand.setSeed( seed );
    }


    /**
     * guessing game
     */
    public void furtherImprovedGuessingGame()
    {
        int tries = 1;
        int round = 1;
        int wins = 0;
        int secretNumber = rand.nextInt( 6 ) + 1;

        System.out.println( "Round " + round + ": " );
        System.out.println( "" );
        System.out.println( "I am thinking of a number from 1 to 10." );
        System.out.println( "You must guess what it is in three tries" );

        System.out.println( "Enter a guess: " );
        int guess = scan.nextInt();
        while ( tries < 3 && guess != secretNumber )
        {
            guess = 0;
            tries++;

            if ( Math.abs( secretNumber - guess ) >= 3 )
            {
                System.out.println( "cold" );
            }
            else if ( Math.abs( secretNumber - guess ) == 2 )
            {
                System.out.println( "warm" );
            }
            else if ( Math.abs( secretNumber - guess ) == 1 )
            {
                System.out.println( "hot" );
            }

            System.out.println( "" );
            System.out.println( "I am thinking of a number from 1 to 10." );
            System.out.println( "You must guess what it is in three tries" );
            System.out.println( "Enter a guess: " );
            guess = scan.nextInt();
        }

        if ( guess == secretNumber )
        {
            wins++;
            System.out.println( "RIGHT!" );
            System.out.println( "You have won " + wins + " out of " + round
                + " rounds." );
        }

        else
        {
            System.out.println( "wrong" );
            System.out.println( "The correct number was " + secretNumber + "." );
            System.out.println( "You have won " + wins + " out of " + round
                + " rounds." );
        }

        while ( round < 10 )
        {
            tries = 0;
            round++;
            guess = 0;
            secretNumber = rand.nextInt( 6 ) + 1;
            System.out.println( "" );
            System.out.println( "Round " + round + ": " );
            System.out.println( "" );
            while ( tries < 3 && guess != secretNumber )
            {
                tries++;
                System.out.println( "" );
                System.out.println( "I am thinking of a number from 1 to 10." );
                System.out.println( "You must guess what it is in three tries" );
                System.out.println( "Enter a guess: " );
                guess = scan.nextInt();

                if ( Math.abs( secretNumber - guess ) >= 3 )
                {
                    System.out.println( "cold" );
                }
                else if ( Math.abs( secretNumber - guess ) == 2 )
                {
                    System.out.println( "warm" );
                }
                else if ( Math.abs( secretNumber - guess ) == 1 )
                {
                    System.out.println( "hot" );
                }

            }

            if ( guess == secretNumber )
            {
                wins++;
                System.out.println( "RIGHT!" );
                System.out.println( "You have won " + wins + " out of " + round
                    + " rounds." );
            }

            else
            {
                System.out.println( "wrong" );
                System.out.println( "The correct number was " + secretNumber
                    + "." );
                System.out.println( "You have won " + wins + " out of " + round
                    + " rounds." );
            }
        }
        String rating = null;

        if ( wins <= 7 )
        {
            rating = "amateurs";
        }

        else if ( wins == 8 )
        {
            rating = "advanced";
        }
        else if ( wins == 9 )
        {
            rating = "professionals";
        }
        else if ( wins == 10 )
        {
            rating = "hackers";
        }
        System.out.println( "Your rating: " + rating );
    }


    /**
     * crack password
     */
    public void passwordCracker()
    {
        System.out.println( "Enter a secret password-->" );
        String password = scan.nextLine();
        int tries = 0;
        int characters = password.length();

        String choices = "abcdefghijklmnopqrstuvwxyz";
        choices = choices + choices.toUpperCase();
        choices = choices + "1234567890";

        
        String guess = "";
        while ( !( guess.equals( password ) ) )
        {
            int j = 0;
            guess = "";
            while ( j < characters )
            {
                guess = guess
                    + choices.charAt( rand.nextInt( choices.length() ) );
                j = j + 1;
            }
            tries++;
        }

        System.out.println( "Here is your password: " + guess );
        System.out.println( "It took " + tries + " tries to guess it" );

    }


    /**
     * randomwalk2d
     */
    public void randomWalk2D()
    {
        int steps = 0;
        double x = 0;
        double y = 0;
        double incrementx = rand.nextDouble() * ( 1 - ( -1 ) ) + ( -1 );
        double incrementy = rand.nextDouble() * ( 1 - ( -1 ) ) + ( -1 );

        while ( steps < 1000 )
        {
            x = x + incrementx;
            y = y + incrementy;

            steps++;
        }

        double distance = Math.sqrt( x * x + y * y );
        System.out.println( "Coordinates: (" + x + ", " + y
            + ")\tDistance from Origin: " + distance );

    }


    /**
     * square root game
     */
    public void squareRootGame()
    {
        System.out.println( "How many rounds? " );
        int totalRounds = scan.nextInt();
        if ( totalRounds == 0 )
        {
            return;
        }
        System.out.print( "First Player, sign in--> " );
        String player1 = scan.nextLine();
        player1 = scan.nextLine();
        System.out.print( "Second Player, sign in--> " );
        String player2 = scan.nextLine();

        int rounds = 0;
        int player1Wins = 0;
        int player2Wins = 0;

        while ( rounds < totalRounds )
        {
            double sqr = rand.nextDouble() * 100;
            double sqrt = Math.sqrt( sqr );
            double player1Error = 0;
            double player2Error = 0;

            if ( rounds == 0 || rounds % 2 == 0 )
            {
                System.out.println( "" );
                System.out.println( "What is the square root of " + sqr + "\t?" );
                System.out.println( player1 + ", your guess: " );
                double player1Guess = scan.nextDouble();
                System.out.println( player2 + ", your guess: " );
                double player2Guess = scan.nextDouble();

                player1Error = Math.abs( sqrt - player1Guess );
                player2Error = Math.abs( sqrt - player2Guess );

                System.out.println( "The correct square root: " + sqrt );
                System.out.println( player1 + " is " + player1Error + " away" );
                System.out.println( player2 + " is " + player2Error + " away" );

            }
            else
            {
                System.out.println( "" );
                System.out.println( "What is the square root of " + sqr + "\t?" );
                System.out.println( player2 + ", your guess: " );
                double player2Guess = scan.nextDouble();
                System.out.println( player1 + ", your guess: " );
                double player1Guess = scan.nextDouble();

                player1Error = Math.abs( sqrt - player1Guess );
                player2Error = Math.abs( sqrt - player2Guess );

                System.out.println( "The correct square root: " + sqrt );
                System.out.println( player2 + " is " + player2Error + " away" );
                System.out.println( player1 + " is " + player1Error + " away" );
            }
            if ( player1Error > player2Error )
            {
                System.out.println( player2 + " wins!" );
                player2Wins++;
            }
            else
            {
                System.out.println( player1 + " wins!" );
                player1Wins++;
            }

            rounds++;
        }

        System.out.println( "---- Final Score ----" );
        System.out.println( player1 + ":  " + player1Wins + "  " + player2
            + ":  " + player2Wins );
        // How many rounds? 4
        // First Player, sign in--> Dweezle
        // Secnd Player, sign in--> Moon Unit
        //
        // What is the square root of 83.29097831183603 ?
        // Dweezle, your guess: 9.1
        // Moon Unit, your guess: 9.2
        // The correct square root: 9.126389116832353
        // Dweezle is 0.026389116832353565 away
        // Moon Unit is 0.07361088316764608 away
        // Dweezle wins!
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

        Ch20Exercises exercise = new Ch20Exercises();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (3) Further Improved Guessing Game" );
            System.out.println( "   (5) Password Cracker" );
            System.out.println( "   (7) 2D Random Walk" );
            System.out.println( "   (8) Square Root Game" );
            System.out.println( "   (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '3':
                        exercise.furtherImprovedGuessingGame();
                        break;
                    case '5':
                        exercise.passwordCracker();
                        break;
                    case '7':
                        exercise.randomWalk2D();
                        break;
                    case '8':
                        exercise.squareRootGame();
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