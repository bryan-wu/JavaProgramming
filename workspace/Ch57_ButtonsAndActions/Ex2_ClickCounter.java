import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


class ClickCounterFrame extends JFrame implements ActionListener
{
    private JButton bChange; // reference to the button object

    private JLabel clickCounter;

    private int clickCount = 0;


    // constructor for ButtonFrame
    public ClickCounterFrame()
    {
        getContentPane().setBackground( Color.blue );
        // construct a Button
        bChange = new JButton( "Click Me!" );

        // register the ButtonFrame object as the listener for the JButton.
        bChange.addActionListener( this );

        clickCounter = new JLabel( "0" );

        // add the button to the JFrame
        getContentPane().setLayout( new FlowLayout() );
        getContentPane().add( bChange );
        getContentPane().add( clickCounter );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }


    public void actionPerformed( ActionEvent evt )
    {
        clickCount += 1;
        bChange.setText( "" + clickCount );
        clickCounter.setText( "" + clickCount );

        if ( clickCount % 2 == 1 )
        {
            getContentPane().setBackground( Color.red );

        }
        if ( clickCount % 2 == 0 )
        {
            getContentPane().setBackground( Color.blue );

        }
        repaint(); // ask the system to paint the screen.
    }
}


public class Ex2_ClickCounter
{
    public static void main( String[] args )
    {
        ClickCounterFrame frm = new ClickCounterFrame();

        frm.setSize( 200, 150 );
        frm.setVisible( true );
    }
}
