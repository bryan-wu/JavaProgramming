import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;


/**
 * Use Buttons and Action Events to create Three Button Monty game.
 *
 * @author Bryan Wu
 * @version Mar 23, 2015
 * @author Period: 7
 * @author Assignment: Ch59_ButtonsAndActionEvents
 *
 * @author Sources: None
 */
public class Ex3_ThreeButtonMonty extends JFrame implements ActionListener
{
    // instance variables

    private JButton leftButton;

    private JButton middleButton;

    private JButton rightButton;

    private Random randNum;

    private int someInt;


    // constructor for ButtonFrame
    /**
     * Constructor for ButtonFrame
     */
    public Ex3_ThreeButtonMonty()
    {
        super( "Three Button Monty" );

        leftButton = new JButton( "Three" );
        middleButton = new JButton( "Button" );
        rightButton = new JButton( "Monty" );

        // leftButton.setActionCommand( "random" ); // set the command
        // middleButton.setActionCommand( "random" ); // set the command
        // rightButton.setActionCommand( "random" ); // set the command

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

        if ( someInt != 0 )
        {
            System.exit( 0 );
        }

        repaint(); // ask the system to paint the screen.
    }


    public static void main( String[] args )
    {
        Ex3_ThreeButtonMonty frm = new Ex3_ThreeButtonMonty();

        frm.setSize( 200, 150 );
        frm.setVisible( true );
    }
}
