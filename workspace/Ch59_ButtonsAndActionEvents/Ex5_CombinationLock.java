import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


/**
 * Use Buttons and Action Events to create combination lock
 *
 * @author Bryan Wu
 * @version Mar 23, 2015
 * @author Period: 7
 * @author Assignment: Ch59_ButtonsAndActionEvents
 *
 * @author Sources: None
 */
public class Ex5_CombinationLock extends JFrame implements ActionListener
{
    // instance variables
    private JButton b0;

    private JButton b1;

    private JButton b2;

    private JButton b3;

    private JButton b4;

    private JButton b5;

    private JButton b6;

    private JButton b7;

    private JButton b8;

    private JButton b9;

    private String combination = "";


    // constructor for ButtonFrame
    /**
     * Constructor for ButtonFrame
     */
    public Ex5_CombinationLock()
    {
        super( "Combination Lock" );

        b0 = new JButton( "0" );
        b1 = new JButton( "1" );
        b2 = new JButton( "2" );
        b3 = new JButton( "3" );
        b4 = new JButton( "4" );
        b5 = new JButton( "5" );
        b6 = new JButton( "6" );
        b7 = new JButton( "7" );
        b8 = new JButton( "8" );
        b9 = new JButton( "9" );

        b0.setActionCommand( "0" ); // set the command
        b1.setActionCommand( "1" ); // set the command
        b2.setActionCommand( "2" ); // set the command
        b3.setActionCommand( "3" ); // set the command
        b4.setActionCommand( "4" ); // set the command
        b5.setActionCommand( "5" ); // set the command
        b6.setActionCommand( "6" ); // set the command
        b7.setActionCommand( "7" ); // set the command
        b8.setActionCommand( "8" ); // set the command
        b9.setActionCommand( "9" ); // set the command

        getContentPane().setLayout( new FlowLayout() );
        getContentPane().add( b0 );
        getContentPane().add( b1 );
        getContentPane().add( b2 );
        getContentPane().add( b3 );
        getContentPane().add( b4 );
        getContentPane().add( b5 );
        getContentPane().add( b6 );
        getContentPane().add( b7 );
        getContentPane().add( b8 );
        getContentPane().add( b9 );

        // register the buttonDemo frame
        // as the listener for both Buttons.
        b0.addActionListener( this );
        b1.addActionListener( this );
        b2.addActionListener( this );
        b3.addActionListener( this );
        b4.addActionListener( this );
        b5.addActionListener( this );
        b6.addActionListener( this );
        b7.addActionListener( this );
        b8.addActionListener( this );
        b9.addActionListener( this );

        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }


    public void actionPerformed( ActionEvent evt )
    {
        combination = combination + evt.getActionCommand();

        if ( combination.length() == 3 )
        {
            if ( combination.equals( "735" ) )
            {
                System.exit( 0 );
            }
            else
            {
                getContentPane().setBackground( Color.red );
                combination = "";
            }
        }

        repaint(); // ask the system to paint the screen.
    }


    /**
     * CombinationLock main
     * 
     * @param args
     *            args
     */
    public static void main( String[] args )
    {
        Ex5_CombinationLock frm = new Ex5_CombinationLock();

        frm.setSize( 200, 150 );
        frm.setVisible( true );
    }
}
