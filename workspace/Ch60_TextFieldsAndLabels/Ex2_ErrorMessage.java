import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


/**
 * Modification of the Repeater program so that when the user enters text into
 * the bottom TextField and hits enter, the text is replaced with an error
 * message such as "Enter text in the top field."
 * 
 * @author Bryan Wu
 * @version 3/26/15
 * @author Period - 7
 * @author Assignment - Ex2_ErrorMessage
 * @author Sources - None
 */
public class Ex2_ErrorMessage extends JFrame implements ActionListener
{
    JLabel inLabel = new JLabel( "Enter Your Name:  " );

    JTextField inText = new JTextField( 15 );

    JLabel outLabel = new JLabel( "Here is Your Name :" );

    JTextField outText = new JTextField( 15 );


    public Ex2_ErrorMessage() // constructor
    {
        getContentPane().setLayout( new FlowLayout() );
        getContentPane().add( inLabel );
        getContentPane().add( inText );
        getContentPane().add( outLabel );
        getContentPane().add( outText );

        inText.setActionCommand( "top" );
        outText.setActionCommand( "bottom" );

        inText.addActionListener( this );
        outText.addActionListener( this );

        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }


    // The application code.
    /**
     * Copy text
     */
    public void copyText()
    {
        String name = inText.getText();
        outText.setText( name );
    }


    public void actionPerformed( ActionEvent evt )
    {
        // check if entered into first text field
        if ( evt.getActionCommand().equals( "top" ) )
        {
            copyText();
        }
        // check if entered into second text field
        else if ( evt.getActionCommand().equals( "bottom" ) )
        {
            outText.setText( "Enter text in the top field." );
        }
        repaint();
    }


    /**
     * Main
     * 
     * @param args
     *            args
     */
    public static void main( String[] args )
    {
        Ex2_ErrorMessage echo = new Ex2_ErrorMessage();
        echo.setSize( 300, 100 );
        echo.setVisible( true );
    }
}