import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;


/**
 * Use Buttons and Action Events to create Three Button Monty game with Winning
 * Streak add-on.
 *
 * @author Bryan Wu
 * @version Mar 23, 2015
 * @author Period: 7
 * @author Assignment: Ch59_ButtonsAndActionEvents
 *
 * @author Sources: None
 */
public class Ex4_WinningStreak extends JFrame implements ActionListener
{
    // instance variables
    private JButton leftButton;

    private JButton middleButton;

    private JButton rightButton;

    private Random randNum;

    private int someInt;


    // constructor for ButtonFrame
    public Ex4_WinningStreak()
    {
        super( "Winning Streak" );

        leftButton = new JButton( "Three" );
        middleButton = new JButton( "Button" );
        rightButton = new JButton( "Monty" );

        getContentPane().setLayout( new FlowLayout() );
        getContentPane().add( leftButton );
        getContentPane().add( middleButton );
        getContentPane().add( rightButton );

        leftButton.addActionListener( this );
        middleButton.addActionListener( this );
        rightButton.addActionListener( this );

        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

    }


    public void actionPerformed( ActionEvent evt )
    {
        randNum = new Random(); // create a Random number object

        // someInt gets a number from 0 to 2
        someInt = Math.abs( randNum.nextInt() ) % 3;

        if ( someInt == 2 )
        {
            System.exit( 0 );
        }
        else
        {
            getContentPane().setBackground( new Color( randNum.nextInt( 256 ),
                randNum.nextInt( 256 ),
                randNum.nextInt( 256 ) ) );
        }

        repaint(); // ask the system to paint the screen.
    }


    public static void main( String[] args )
    {
        Ex4_WinningStreak frm = new Ex4_WinningStreak();

        frm.setSize( 200, 150 );
        frm.setVisible( true );
    }
}
