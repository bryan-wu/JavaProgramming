import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Modification of the temperature conversion program so that it converts
 * Celsius to Fahrenheit
 * 
 * @author Bryan Wu
 * @version 3/27/15
 * @author Period - 7
 * @author Assignment - Ex1_TempConvert
 * @author Sources - None
 */
public class Ex1_TempConvert extends JFrame implements ActionListener
{
    private JLabel title = new JLabel( "Convert Fahrenheit to Celsius" );

    private JLabel inLabel = new JLabel( "Fahrenheit    " );

    private JLabel outLabel = new JLabel( "Celsius " );

    private JTextField outFahr = new JTextField( 7 );

    private JTextField inCel = new JTextField( 7 );

    private int fahrTemp;

    private int celsTemp;


    /**
     * Set-up
     */
    public Ex1_TempConvert()
    {
        getContentPane().setLayout( new FlowLayout() );

        inCel.addActionListener( this );
        getContentPane().add( title );
        getContentPane().add( inLabel );
        getContentPane().add( outLabel );
        getContentPane().add( outFahr );
        getContentPane().add( inCel );

        outFahr.setEditable( false );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }


    /**
     * Convert Celsuis to Fahrenheit.
     */
    public void convert()
    {
        fahrTemp = ( 9 * celsTemp ) / 5 + 32;
        // celsTemp = ( ( fahrTemp - 32 ) * 5 ) / 9;
    }


    public void actionPerformed( ActionEvent evt )
    {
        String userIn = inCel.getText();
        celsTemp = Integer.parseInt( userIn );

        convert();

        outFahr.setText( fahrTemp + " " );
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
        Ex1_TempConvert fahr = new Ex1_TempConvert();

        fahr.setSize( 225, 150 );
        fahr.setVisible( true );
    }
}