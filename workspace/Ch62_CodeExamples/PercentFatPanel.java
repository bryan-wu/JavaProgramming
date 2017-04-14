import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author Bryan Wu
 * @version Apr 2, 2015
 * @author Period: 7
 * @author Assignment: Ch62_CodeExamples
 *
 * @author Sources: None
 */
public class PercentFatPanel extends JFrame implements ActionListener
{
    JLabel heading, fatLabel, calLabel, perLabel;

    JTextField inFat, inCal, outPer;

    JButton doIt = new JButton( "Do It!" );

    JPanel hedPanel, fatPanel, calPanel, perPanel, butPanel;

    JPanel[] panels = { hedPanel, fatPanel, calPanel, perPanel, butPanel };

    JLabel[] labels = { heading, fatLabel, calLabel, perLabel };

    String[] prompts = { "Percent of Calories from Fat",
        "Enter grams of fat:   ", "Enter total calories: ",
        "Percent calories from fat: " };

    JTextField[] textFields = { inFat, inCal, outPer };

    JButton doit = new JButton( "Do It!" );

    int calories; // input: total calories per serving

    int fatGrams; // input: grams of fat per serving

    double percent; // result: percent of calories from fat


    /**
     * PercentFatPanel method.
     */
    public PercentFatPanel()
    {
        setTitle( "Calories from Fat" );

        for ( int i = 0; i < labels.length; i++ ) // initialize JLabels
        {
            labels[i] = new JLabel( prompts[i] );
        }

        for ( int i = 0; i < textFields.length; i++ ) // initialize textFields
        {
            textFields[i] = new JTextField( 7 );
        }

        for ( int i = 0; i < panels.length; i++ ) // initialize panels
        {
            panels[i] = new JPanel();
        }

        textFields[2].setEditable( false );
        setLayout( new FlowLayout() );

        // Add components to Panels
        panels[0].add( labels[0] );
        // for ( int i = 0; i < 3; i++ )
        // {
        // panels[1].add( panels[i] );
        // }
        panels[1].add( labels[1] );
        panels[1].add( textFields[0] );
        panels[2].add( labels[2] );
        panels[2].add( textFields[1] );
        panels[3].add( labels[3] );
        panels[3].add( textFields[2] );
        panels[4].add( doit );

        // Add Panels to Frame
        add( panels[0] );
        add( labels[0] );
        add( panels[1] );
        add( panels[2] );
        add( panels[3] );
        add( doit );
        add( panels[4] );

        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        doit.addActionListener( this );
    }


    // The application
    /**
     * Calculate percentage.
     */
    public void calcPercent()
    {
        percent = ( ( fatGrams * 9.0 ) / calories ) * 100.0;
    }


    public void actionPerformed( ActionEvent evt )
    {
        String userIn;
        userIn = textFields[0].getText();
        fatGrams = Integer.parseInt( userIn );

        userIn = textFields[1].getText();
        calories = Integer.parseInt( userIn );
        calcPercent();

        textFields[2].setText( ( percent + "      " ).substring( 0, 6 ) );
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
        PercentFatPanel fatApp = new PercentFatPanel();
        fatApp.setSize( 300, 225 );
        fatApp.setResizable( false );
        fatApp.setVisible( true );
    }
}