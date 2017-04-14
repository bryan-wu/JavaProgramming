import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;


/**
 * Modification of the calories from fat calculator so that it does not crash
 * when the user enters text that cannot be converted to a double.
 * 
 * @author Bryan Wu
 * @version 3/30/15
 * @author TPeriod - 7
 * @author TAssignment - Ex2_TwoWayConvert
 * @author TSources - None
 */
public class Ex3_PercentFat extends JFrame implements ActionListener
{
    private JLabel heading = new JLabel( "Percent of Calories from Fat" );

    private JLabel fatLabel = new JLabel( "Enter grams of fat:   " );

    private JLabel calLabel = new JLabel( "Enter total calories: " );

    private JLabel perLabel = new JLabel( "Percent calories from fat: " );

    private JTextField inFat = new JTextField( 7 );

    private JTextField inCal = new JTextField( 7 );

    private JTextField outPer = new JTextField( 7 );

    private JButton doit = new JButton( "Do It!" );

    private double calories; // input: total calories per serving

    private double fatGrams; // input: grams of fat per serving

    private double percent; // result: percent of calories from fat


    /**
     * Percent Fat.
     */
    public Ex3_PercentFat()
    {
        setTitle( "Calories from Fat" );
        setLayout( new FlowLayout() );

        add( heading );
        add( fatLabel );
        add( inFat );
        add( calLabel );
        add( inCal );
        add( perLabel );
        add( outPer );
        outPer.setEditable( false );

        add( doit );
        doit.addActionListener( this );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }


    // The application
    /**
     * Calculate percentage fat.
     */
    public void calcPercent()
    {
        percent = ( ( fatGrams * 9 ) / calories ) * 100;
    }


    public void actionPerformed( ActionEvent evt )
    {
        String userIn;
        try
        // check if a number is entered into fat textfield
        {
            userIn = inFat.getText();
            fatGrams = Double.parseDouble( userIn );
        }
        catch ( Exception ex )
        {
            inFat.setText( "Please enter a number." );
        }
        try
        // check if a number is entered into calories textfield
        {
            userIn = inCal.getText();
            calories = Double.parseDouble( userIn );
        }
        catch ( Exception ex )
        {
            inCal.setText( "Please enter a number." );
        }
        calcPercent();

        // Convert percent to a nice string and write it to the output field
        outPer.setText( new DecimalFormat( "#0.0##" ).format( percent ) );
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
        Ex3_PercentFat fatApp = new Ex3_PercentFat();
        fatApp.setSize( 280, 200 );
        fatApp.setVisible( true );
    }
}
