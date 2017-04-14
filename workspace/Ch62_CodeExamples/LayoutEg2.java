import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Layout with Panels 6 data sets.
 *
 * @author Bryan Wu
 * @version Apr 2, 2015
 * @author Period: 7
 * @author Assignment: Ch62_CodeExamples
 *
 * @author Sources: None
 */
public class LayoutEg2 extends JFrame
{

    // create small panels that contain pairs of labels and text fields

    JLabel lData1, lData2, lData3, lData4, lData5, lData6;

    JTextField txData1, txData2, txData3, txData4, txData5, txData6;

    JPanel panel1, panel2, panel3, panel4, panel5, panel6, pnTop, pnBot;

    JLabel[] labels = { lData1, lData2, lData3, lData4, lData5, lData6 };

    JTextField[] textFields = { txData1, txData2, txData3, txData4, txData5,
        txData6 };

    // create top and bottom panels that will hold the small panels
    JPanel[] panels = { panel1, panel2, panel3, panel4, panel5, panel6, pnTop,
        pnBot };


    /**
     * Layout method.
     */
    public LayoutEg2()
    {
        setTitle( "LayoutEg2" );

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
        // add label and text pairs to the small panels
        for ( int i = 0; i < 6; i++ )
        {
            panels[i].add( labels[i] );
            panels[i].add( textFields[i] );
        }

        // add the pair panels to the top and bottom panels
        for ( int i = 0; i < 3; i++ )
        {
            panels[6].add( panels[i] );
        }

        for ( int i = 3; i < 6; i++ )
        {
            panels[7].add( panels[i] );
        }

        // add the top and bottom panels to the frame
        setLayout( new FlowLayout() );

        for ( int i = 6; i < 8; i++ )
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
        LayoutEg2 leg = new LayoutEg2();
        leg.setSize( 525, 150 );
        leg.setVisible( true );
    }
}