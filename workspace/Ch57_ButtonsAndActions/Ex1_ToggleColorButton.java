import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class ToggleColorButtonFrame extends JFrame implements ActionListener
{
    private JButton bChange; // reference to the button object

    private int clickCount = 0;


    // constructor for ButtonFrame
    public ToggleColorButtonFrame()
    {
        getContentPane().setBackground( Color.blue );
        // construct a Button
        bChange = new JButton( "Click Me!" );

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


public class Ex1_ToggleColorButton
{
    public static void main( String[] args )
    {
        ToggleColorButtonFrame frm = new ToggleColorButtonFrame();

        frm.setSize( 200, 150 );
        frm.setVisible( true );
    }
}
