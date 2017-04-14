import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


/**
 * Code for the example user interface. There is no application code.
 *
 * @author Bryan Wu
 * @version Apr 2, 2015
 * @author Period: 7
 * @author Assignment: Ch62_CodeExamples
 *
 * @author Sources: None
 */
public class MorningNoonNight extends JFrame implements ActionListener
{
    JLabel lData1, lData2, lData3, lData4, lData5, lData6, lData7;

    JTextField txData1, txData2, txData3, txData4, txData5, txData6, txData7;

    JButton butMorn, butNoon, butNite;

    JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, mtwPanel,
                    rfsPanel, sunPanel, butPanel, dataPanel;

    JLabel[] labels = { lData1, lData2, lData3, lData4, lData5, lData6, lData7 };

    JTextField[] textFields = { txData1, txData2, txData3, txData4, txData5,
        txData6, txData7 };

    JButton[] buttons = { butMorn, butNoon, butNite };

    JPanel[] panels = { panel1, panel2, panel3, panel4, panel5, panel6, panel7 };

    // string array of days of the week to cycle through in for loop
    String[] days = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
        "Saturday", "Sunday" };

    String times[] = { "Morning", "Noon", "Night" };

    JPanel[] panelsMain = { mtwPanel, rfsPanel, sunPanel, butPanel, dataPanel };


    /**
     * MorningNoonNight Method.
     */
    public MorningNoonNight()
    {
        setTitle( "Morning Noon Night" );

        for ( int i = 0; i < labels.length; i++ )
        {
            labels[i] = new JLabel( days[i] );
        }

        for ( int i = 0; i < panelsMain.length; i++ )
        {
            panelsMain[i] = new JPanel();
        }
        for ( int i = 0; i < textFields.length; i++ )
        {
            textFields[i] = new JTextField( 7 );
        }
        for ( int i = 0; i < buttons.length; i++ )
        {
            buttons[i] = new JButton( times[i] );
        }

        for ( int i = 0; i < panels.length; i++ )
        {
            panels[i] = new JPanel();
        }
        // add label and text pairs to the small panels
        for ( int i = 0; i < 7; i++ )
        {
            panels[i].add( labels[i] );
            panels[i].add( textFields[i] );
        }
        for ( int i = 0; i < 3; i++ )
        {
            panelsMain[0].add( panels[i] );
        }
        for ( int i = 3; i < 6; i++ )
        {
            panelsMain[1].add( panels[i] );
        }

        panelsMain[2].add( panels[6] );

        for ( int i = 0; i < 3; i++ )
        {
            panelsMain[3].add( buttons[i] );
        }

        panelsMain[4].setLayout( new BoxLayout( panelsMain[4], BoxLayout.Y_AXIS ) );
        panelsMain[4].add( panelsMain[0] );
        panelsMain[4].add( panelsMain[1] );
        panelsMain[4].add( panelsMain[2]);

        setLayout( new FlowLayout() );
        add( panelsMain[4] );
        add( panelsMain[3] );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    }


    public void actionPerformed( ActionEvent evt )
    {
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
        MorningNoonNight mnn = new MorningNoonNight();

        mnn.setSize( 500, 225 );
        mnn.setResizable( false );
        mnn.setVisible( true );
    }
}