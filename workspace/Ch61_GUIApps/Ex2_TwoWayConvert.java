import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Add two buttons to the temperature conversion program. Clicking one button
 * converts Fahrenheit to Celsius, clicking the other converts Celsius to
 * Fahrenheit. Set to "noneditable" whichever text field is to contain the
 * result of the conversion. Add a "clear" button that clears the text in both
 * text fields.
 * 
 * @author Bryan Wu
 * @version 3/27/15
 * @author Period - 7
 * @author Assignment - Ex2_TwoWayConvert
 * @author Sources - None
 */
public class Ex2_TwoWayConvert extends JFrame implements ActionListener
{
    private JLabel title = new JLabel( "Convert Fahrenheit to Celsius" );

    private JLabel inLabel = new JLabel( "Fahrenheit    " );

    private JLabel outLabel = new JLabel( "Celsius " );

    private JTextField inFahr = new JTextField( 7 );

    private JTextField outCel = new JTextField( 7 );

    private int fahrTemp;

    private int celsTemp;

    private JButton fToC = new JButton( "F->C" );

    private JButton cToF = new JButton( "C->F" );

    private JButton clear = new JButton( "Clear" );


    public Ex2_TwoWayConvert()
    {
        getContentPane().setLayout( new FlowLayout() );

        getContentPane().add( title );
        getContentPane().add( inLabel );
        getContentPane().add( outLabel );
        getContentPane().add( inFahr );
        getContentPane().add( outCel );
        getContentPane().add( fToC );
        getContentPane().add( cToF );
        getContentPane().add( clear );

        fToC.setActionCommand( "fToC" );
        cToF.setActionCommand( "cToF" );
        clear.setActionCommand( "clear" );
        inFahr.addActionListener( this );
        outCel.addActionListener( this );
        fToC.addActionListener( this );
        cToF.addActionListener( this );
        clear.addActionListener( this );

        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }


    /**
     * Convert Fahrenheit to Celsius.
     */
    public void convertFToC()
    {
        celsTemp = ( ( fahrTemp - 32 ) * 5 ) / 9;
    }


    /**
     * Convert Celsius to Fahrenheit.
     */
    public void convertCToF()
    {
        fahrTemp = ( 9 * celsTemp ) / 5 + 32;
    }


    public void actionPerformed( ActionEvent evt )
    {
        String userIn;
        if ( evt.getActionCommand().equals( "fToC" ) ) // f to c
        {
            userIn = inFahr.getText();
            outCel.setEditable( false );
            fahrTemp = Integer.parseInt( userIn );
            convertFToC();
            outCel.setText( celsTemp + " " );
        }
        if ( evt.getActionCommand().equals( "cToF" ) ) // c to f
        {
            userIn = outCel.getText();
            inFahr.setEditable( false );
            celsTemp = Integer.parseInt( userIn );
            convertCToF();
            inFahr.setText( fahrTemp + " " );
        }
        if ( evt.getActionCommand().equals( "clear" ) ) // clear entries
        {
            outCel.setEditable( true );
            inFahr.setEditable( true );
            outCel.setText( "" );
            inFahr.setText( "" );
        }

        repaint();
    }


    /**
     * Main.
     * 
     * @param args
     *            agrs
     */
    public static void main( String[] args )
    {
        Ex2_TwoWayConvert fahr = new Ex2_TwoWayConvert();

        fahr.setSize( 225, 150 );
        fahr.setVisible( true );
    }
}