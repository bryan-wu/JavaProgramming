import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Layout with Panels 3 data sets.
 *
 * @author Bryan Wu
 * @version Apr 2, 2015
 * @author Period: 7
 * @author Assignment: Ch62_CodeExamples
 *
 * @author Sources: None
 */
public class LayoutEg1 extends JFrame
{

    JLabel lData1, lData2, lData3;

    JTextField txData1, txData2, txData3;

    JPanel panel1, panel2, panel3;

    // JLabel lData1 = new JLabel( "Data Item 1" );
    //
    // JTextField txData1 = new JTextField( 7 );
    //
    // JPanel panel1 = new JPanel();
    //
    // JLabel lData2 = new JLabel( "Data Item 2" );
    //
    // JTextField txData2 = new JTextField( 7 );
    //
    // JPanel panel2 = new JPanel();
    //
    // JLabel lData3 = new JLabel( "Data Item 3" );
    //
    // JTextField txData3 = new JTextField( 7 );
    //
    // JPanel panel3 = new JPanel();

    JLabel[] labels = { lData1, lData2, lData3 };

    JTextField[] textFields = { txData1, txData2, txData3 };

    JPanel[] panels = { panel1, panel2, panel3 };


    /**
     * Layout method.
     */
    public LayoutEg1()
    {
        setTitle( "LayoutEg1" );
        for ( int i = 0; i < labels.length; i++ )
        {
            labels[i] = new JLabel( "Data Item " + ( i + 1 ) );
        }

        for ( int i = 0; i < textFields.length; i++ )
        {
            textFields[i] = new JTextField( 7 );
        }

        for ( int i = 0; i < panels.length; i++ )
        {
            panels[i] = new JPanel();
        }

        for ( int i = 0; i < 3; i++ )
        {
            panels[i].add( labels[i] );
            panels[i].add( textFields[i] );
        }

        setLayout( new FlowLayout() );
        for ( int i = 0; i < 3; i++ )
        {
            add( panels[i] );
        }

        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }


    /**
     * Main.
     * 
     * @param args
     *            args
     */
    public static void main( String[] args )
    {
        LayoutEg1 leg = new LayoutEg1();
        leg.setSize( 525, 150 );
        leg.setVisible( true );
    }
}