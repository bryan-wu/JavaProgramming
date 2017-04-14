import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Modification the program so that when the button is clicked, the Strings in
 * the two JTextFields are swapped; ie. the top field gets what was in the
 * bottom box and the bottom field gets what was in the top.
 * 
 * @author Bryan Wu
 * @version 3/26/15
 * @author Period - 7
 * @author Assignment - Ex4_TextSwap
 * @author Sources - None
 */
public class Ex4_TextSwap extends JFrame implements ActionListener
{
    JLabel inLabel = new JLabel( "Enter Your Name:  " );

    JTextField inText = new JTextField( 15 );

    JLabel outLabel = new JLabel( "Here is Your Name :" );

    JTextField outText = new JTextField( 15 );

    JButton swap = new JButton( "Swap" );


    /**
     * Constructor
     */
    public Ex4_TextSwap() // constructor
    {
        getContentPane().setLayout( new FlowLayout() );
        getContentPane().add( inLabel );
        getContentPane().add( inText );
        getContentPane().add( outLabel );
        getContentPane().add( outText );
        getContentPane().add( swap );

        // inText.setActionCommand( "top" );
        // outText.setActionCommand( "bottom" );
        swap.setActionCommand( "swap" );

        inText.addActionListener( this );
        outText.addActionListener( this );
        swap.addActionListener( this );

        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }


    // The application code.
    public void copyText()
    {
        String name = inText.getText();
        outText.setText( name );
    }


    public void actionPerformed( ActionEvent evt )
    {
        if ( evt.getActionCommand().equals( "swap" ) )
        // check if swap button is clicked
        {
            String name = inText.getText();
            String temp = outText.getText();
            inText.setText( temp );
            outText.setText( name );
        }
        repaint();
    }


    /**
     * Main.
     * 
     * @param args
     *            args
     */
    public static void main( String[] args )
    {
        Ex4_TextSwap echo = new Ex4_TextSwap();
        echo.setSize( 300, 100 );
        echo.setVisible( true );
    }
}