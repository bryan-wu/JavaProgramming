import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;


/**
 * Improved ideal weight calculator takes into account the type of (human)
 * frame. Add another panel of radio buttons that allow the user to choose a
 * small, medium, or large frame. Multiplies the result of the above ideal
 * weight calculation by 0.95 for small frame, 1.0 for medium frame, and 1.05
 * for large frame.
 * 
 * @author Bryan Wu
 * @version 6/7/15
 * @author Period - 7
 * @author Assignment - Ex3_SmallMedLargeFrame
 * @author Sources - None
 */
public class Ex3_SmallMedLargeFrame extends JFrame implements ActionListener
{
    private JRadioButton genderM, genderF;

    private ButtonGroup genderGroup;

    private JPanel genderPanel;

    private JRadioButton heightA, heightB, heightC, heightD, heightE;

    private ButtonGroup heightGroup;

    private JPanel heightPanel;

    private JTextField resultText;

    private JLabel resultLabl;

    private JPanel resultPanel;

    private JPanel framePanel;

    // new variables declared here

    private JRadioButton small, medium, large;

    private ButtonGroup frameGroup;


    // no more new variables after this line

    public Ex3_SmallMedLargeFrame()
    {
        setTitle( "SmallMedLargeFrame" );
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        // gender group
        genderM = new JRadioButton( "Male", true );
        genderF = new JRadioButton( "Female", false );
        genderGroup = new ButtonGroup();
        genderGroup.add( genderM );
        genderGroup.add( genderF );
        genderPanel = new JPanel();
        genderPanel.setLayout( new BoxLayout( genderPanel, BoxLayout.Y_AXIS ) );
        genderPanel.add( new JLabel( "Your Gender" ) );
        genderPanel.add( genderM );
        genderPanel.add( genderF );

        // height group
        heightA = new JRadioButton( "60 to 64 inches", true );
        heightB = new JRadioButton( "64 to 68 inches", false );
        heightC = new JRadioButton( "68 to 72 inches", false );
        heightD = new JRadioButton( "72 to 76 inches", false );
        heightE = new JRadioButton( "76 to 80 inches", false );

        // create action commands and add action listeners to height buttons
        heightA.setActionCommand( "62" );
        heightB.setActionCommand( "66" );
        heightC.setActionCommand( "70" );
        heightD.setActionCommand( "74" );
        heightE.setActionCommand( "78" );
        heightA.addActionListener( this );
        heightB.addActionListener( this );
        heightC.addActionListener( this );
        heightD.addActionListener( this );
        heightE.addActionListener( this );

        heightGroup = new ButtonGroup();
        heightGroup.add( heightA );
        heightGroup.add( heightB );
        heightGroup.add( heightC );
        heightGroup.add( heightD );
        heightGroup.add( heightE );

        heightPanel = new JPanel();
        heightPanel.setLayout( new BoxLayout( heightPanel, BoxLayout.Y_AXIS ) );
        heightPanel.add( new JLabel( "Your Height" ) );
        heightPanel.add( heightA );
        heightPanel.add( heightB );
        heightPanel.add( heightC );
        heightPanel.add( heightD );
        heightPanel.add( heightE );

        // frame group
        small = new JRadioButton( "Small", true );
        medium = new JRadioButton( "Medium", false );
        large = new JRadioButton( "Large", false );

        frameGroup = new ButtonGroup();
        frameGroup.add( small );
        frameGroup.add( medium );
        frameGroup.add( large );

        framePanel = new JPanel();
        framePanel.setLayout( new BoxLayout( framePanel, BoxLayout.Y_AXIS ) );
        framePanel.add( new JLabel( "Your Body Frame" ) );
        framePanel.add( small );
        framePanel.add( medium );
        framePanel.add( large );

        // result panel
        resultText = new JTextField( 7 );
        resultText.setEditable( false );
        resultLabl = new JLabel( "Ideal Weight" );
        resultPanel = new JPanel();
        resultPanel.add( resultLabl );
        resultPanel.add( resultText );

        // frame
        setLayout( new BorderLayout() );
        add( genderPanel, BorderLayout.WEST );
        add( heightPanel, BorderLayout.EAST );
        add( framePanel, BorderLayout.CENTER );
        add( resultPanel, BorderLayout.SOUTH );

    }


    public void actionPerformed( ActionEvent evt )
    {
        double height = 0;
        double weight = 0;

        height = Integer.parseInt( evt.getActionCommand() );

        if ( genderF.isSelected() )
        {
            weight = height * height / 30; // female
        }
        if ( genderM.isSelected() )
        {

            weight = height * height / 28; // male
        }
        if ( small.isSelected() )
        {
            weight = weight * .95; // male
        }
        if ( medium.isSelected() )
        {
            weight = weight * 1; // male
        }
        if ( large.isSelected() )
        {
            weight = weight * 1.05; // male
        }
        resultText.setText( new DecimalFormat( "#0.0##" ).format( weight ) );

        repaint();
    }


    public static void main( String[] args )
    {
        Ex3_SmallMedLargeFrame weightApp = new Ex3_SmallMedLargeFrame();
        weightApp.setSize( 300, 225 );
        weightApp.setVisible( true );
    }
}
