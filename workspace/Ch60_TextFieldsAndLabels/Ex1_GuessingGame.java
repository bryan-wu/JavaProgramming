import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Modification of the Repeater program, which uses buttons and action events,
 * so that the user must enter a secret word into the top field. After each
 * entry, the bottom field either says "correct" or "wrong!" After three wrong
 * guesses, exit the program.
 * 
 * @author Bryan Wu
 * @version 3/26/15
 * @author Period - 7
 * @author Assignment - Ex1_GuessingGame
 * @author Sources - None
 */
public class Ex1_GuessingGame extends JFrame implements ActionListener
{
    JLabel inLabel = new JLabel( "Enter Your Name:  " );

    JTextField inText = new JTextField( 15 );

    JLabel outLabel = new JLabel( "Here is Your Name :" );

    JTextField outText = new JTextField( 15 );

    int guessCount = 0;


    public Ex1_GuessingGame() // constructor
    {
        getContentPane().setLayout( new FlowLayout() );
        getContentPane().add( inLabel );
        getContentPane().add( inText );
        getContentPane().add( outLabel );
        getContentPane().add( outText );

        inText.addActionListener( this );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }


    // The application code.
    public void copyText()
    {
        guessCount += 1;
        String name = inText.getText();
        if ( name.equalsIgnoreCase( "secret" ) ) // secret word
        {
            outText.setText( "correct" );
        }
        else
        {
            if ( guessCount == 3 ) // exit if third wrong guess
            {
                System.exit( 0 );
            }
            else
            {
                outText.setText( "wrong!" );
            }
        }
    }


    public void actionPerformed( ActionEvent evt )
    {
        copyText(); // copy text
        repaint();
    }


    public static void main( String[] args )
    {
        Ex1_GuessingGame echo = new Ex1_GuessingGame();
        echo.setSize( 300, 100 );
        echo.setVisible( true );
    }
}