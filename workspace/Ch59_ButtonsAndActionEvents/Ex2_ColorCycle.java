import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


/**
 * Use Buttons and Action Events to create button that cycles through the
 * following colors in listed order: red, green, blue, gray.
 *
 * @author Bryan Wu
 * @version Mar 23, 2015
 * @author Period: 7
 * @author Assignment: Ch59_ButtonsAndActionEvents
 *
 * @author Sources: None
 */
public class Ex2_ColorCycle extends JFrame implements ActionListener
{
    private JButton bChange; // reference to the button object

    private int clickCount;

    private Color[] color = { Color.red, Color.green, Color.blue, Color.gray };


    // constructor for ButtonFrame
    public Ex2_ColorCycle()
    {
        super( "Color Cycle" );
        // construct a Button
        bChange = new JButton( "Color Cycle" );

        // register the ButtonFrame object as the listener for the JButton.
        bChange.addActionListener( this );

        // add the button to the JFrame
        getContentPane().setLayout( new FlowLayout() );
        getContentPane().add( bChange );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }


    public void actionPerformed( ActionEvent evt )
    {
        clickCount += 1;
        if ( clickCount % 4 == 1 )
        {
            getContentPane().setBackground( color[0] );

        }
        else if ( clickCount % 4 == 2 )
        {
            getContentPane().setBackground( color[1] );

        }
        else if ( clickCount % 4 == 3 )
        {
            getContentPane().setBackground( color[2] );

        }
        else
        {
            getContentPane().setBackground( color[3] );

        }

        repaint(); // ask the system to paint the screen.
    }


    public static void main( String[] args )
    {
        Ex2_ColorCycle frm = new Ex2_ColorCycle();

        frm.setSize( 200, 150 );
        frm.setVisible( true );
    }
}
