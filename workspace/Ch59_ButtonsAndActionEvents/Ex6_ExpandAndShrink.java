import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


/**
 * Use Buttons and Action Events to create expandable and shrinkable window.
 *
 * @author Bryan Wu
 * @version Mar 26, 2015
 * @author Period: 7
 * @author Assignment: Ex6_ExpandAndShrink
 *
 * @author Sources: None
 */
public class Ex6_ExpandAndShrink extends JFrame implements ActionListener
{
    private JButton bigger;

    private JButton smaller;

    private static double SIZE_FACTOR = 0.1;

    private Dimension frameSize;

    private int width;

    private int height;


    // constructor for TwoButtons
    /**
     * Constructor for TwoButtons
     */
    public Ex6_ExpandAndShrink()
    {
        super( "Expand and Shrink Buttons" );

        width = 200;

        height = 150;

        bigger = new JButton( "Expand" );
        smaller = new JButton( "Shrink" );

        bigger.setActionCommand( "expand" ); // set the command
        smaller.setActionCommand( "shrink" );

        getContentPane().setLayout( new FlowLayout() );
        getContentPane().add( bigger );
        getContentPane().add( smaller );

        // register the buttonDemo frame
        // as the listener for both Buttons.
        bigger.addActionListener( this );
        smaller.addActionListener( this );

        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }


    public void actionPerformed( ActionEvent evt )
    {
        if ( evt.getActionCommand().equals( "expand" ) )
        {
            width = (int)( width + width * SIZE_FACTOR );
            height = (int)( height + height * SIZE_FACTOR );
            setSize( width, height );
        }

        if ( evt.getActionCommand().equals( "shrink" ) )
        {
            width = (int)( width - width * SIZE_FACTOR );
            height = (int)( height - height * SIZE_FACTOR );
            setSize( width, height );
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
        Ex6_ExpandAndShrink frm = new Ex6_ExpandAndShrink();

        frm.setSize( 200, 150 );
        frm.setVisible( true );
    }
}
