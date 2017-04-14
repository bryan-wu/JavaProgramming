import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Use Buttons and Action Events to create Four Buttons that change background
 * according to buttons's listed color.
 *
 * @author Bryan Wu
 * @version Mar 23, 2015
 * @author Period: 7
 * @author Assignment: Ch59_ButtonsAndActionEvents
 *
 * @author Sources: None
 */
public class Ex1_FourButtons extends JFrame implements ActionListener
{
    JButton redButton;

    JButton grnButton;

    JButton bluButton;

    JButton gryButton;


    // constructor for TwoButtons
    /**
     * Constructor for Two Buttons
     */
    public Ex1_FourButtons()
    {
        super( "Four Buttons" );
        redButton = new JButton( "Red" );
        grnButton = new JButton( "Green" );
        bluButton = new JButton( "Blue" );
        gryButton = new JButton( "Gray" );

        redButton.setActionCommand( "red" ); // set the command
        grnButton.setActionCommand( "green" ); // set the command
        bluButton.setActionCommand( "blue" ); // set the command
        gryButton.setActionCommand( "gray" ); // set the command

        getContentPane().setLayout( new FlowLayout() );
        getContentPane().add( redButton );
        getContentPane().add( grnButton );
        getContentPane().add( bluButton );
        getContentPane().add( gryButton );

        // register the buttonDemo frame
        // as the listener for both Buttons.
        redButton.addActionListener( this );
        grnButton.addActionListener( this );
        bluButton.addActionListener( this );
        gryButton.addActionListener( this );

        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }


    public void actionPerformed( ActionEvent evt )
    {
        // check which command has been sent
        if ( evt.getActionCommand().equals( "red" ) )
        {
            getContentPane().setBackground( Color.red );
        }
        else
        {
            if ( evt.getActionCommand().equals( "green" ) )

            {
                getContentPane().setBackground( Color.green );

            }

            else
            {
                if ( evt.getActionCommand().equals( "blue" ) )
                {
                    getContentPane().setBackground( Color.blue );
                }
                else
                {
                    getContentPane().setBackground( Color.gray );

                }
            }

        }

        repaint();
    }


    /**
     * FourButtons Main
     * 
     * @param args
     *            args
     */
    public static void main( String[] args )
    {
        Ex1_FourButtons demo = new Ex1_FourButtons();

        demo.setSize( 275, 200 );
        demo.setVisible( true );
    }

}