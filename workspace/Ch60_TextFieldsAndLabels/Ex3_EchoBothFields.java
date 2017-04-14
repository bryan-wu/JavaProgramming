import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Modification the Repeater program so that the user can enter text into either
 * field. The text will be repeated in the other field, replacing whatever was
 * there. To do this you will need to use getActionCommand(), as in Exercise 2.
 * 
 * @author Bryan Wu
 * @version 3/26/15
 * @author Period - 7
 * @author Assignment - Ex3_EchoBothFields
 * @author Sources - None
 */
public class Ex3_EchoBothFields extends JFrame implements ActionListener
{
    JLabel inLabel = new JLabel( "Enter Your Name:  " );

    JTextField inText = new JTextField( 15 );

    JLabel outLabel = new JLabel( "Here is Your Name :" );

    JTextField outText = new JTextField( 15 );


    public Ex3_EchoBothFields() // constructor
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
     * Application code
     */
    public void copyText()
    {
        String name = inText.getText();
        outText.setText( name );
    }


    public void actionPerformed( ActionEvent evt )
    {
        if ( evt.getActionCommand().equals( "top" ) )
        {
            copyText();
        }
        else if ( evt.getActionCommand().equals( "bottom" ) )
        {
            inText.setText( outText.getText() );
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
        Ex3_EchoBothFields echo = new Ex3_EchoBothFields();
        echo.setSize( 300, 100 );
        echo.setVisible( true );
    }
}