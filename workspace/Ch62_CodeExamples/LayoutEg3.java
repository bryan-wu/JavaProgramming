import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


/**
 * Layout with Panels 6 data sets ORGANIZED WITH BOXLAYOUT.
 *
 * @author Bryan Wu
 * @version Apr 2, 2015
 * @author Period: 7
 * @author Assignment: Ch62_CodeExamples
 *
 * @author Sources: None
 */
public class LayoutEg3 extends JFrame
{
    // create small panels that contain pairs of labels and text fields

    JLabel lData1, lData2, lData3, lData4, lData5, lData6;

    JTextField txData1, txData2, txData3, txData4, txData5, txData6;

    JPanel panel1, panel2, panel3, panel4, panel5, panel6, pnLeft, pnRight;

    JLabel[] labels = { lData1, lData2, lData3, lData4, lData5, lData6 };

    JTextField[] textFields = { txData1, txData2, txData3, txData4, txData5,
        txData6 };

    // create top and bottom panels that will hold the small panels
    JPanel[] panels = { panel1, panel2, panel3, panel4, panel5, panel6, pnLeft,
        pnRight };


    /**
     * Layout method.
     */
    public LayoutEg3()
    {
        setTitle( "LayoutEg3 Box Alignment" );

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

        // set layout manager for left panel, add three small panels to it
        panels[6].setLayout( new BoxLayout( panels[6], BoxLayout.Y_AXIS ) );
        for ( int i = 0; i < 3; i++ )
        {
            panels[6].add( panels[i] );
        }

        // set layout manager for right panel, add three small panels to it
        panels[7].setLayout( new BoxLayout( panels[7], BoxLayout.Y_AXIS ) );
        for ( int i = 3; i < 6; i++ )
        {
            panels[7].add( panels[i] );
        }

        // add left and right panels to the frame
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
        LayoutEg3 leg = new LayoutEg3();
        leg.setSize( 525, 150 );
        leg.setVisible( true );
    }
}