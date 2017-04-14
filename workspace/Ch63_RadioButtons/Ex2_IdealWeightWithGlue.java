import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;


/**
 * Uses glue to separate the two button panels. Adding more glue, perhaps to the
 * left and right of the button panels, between the buttons, and between the
 * button box and the result panel. Resize the display of the frame to see the
 * effect of glue. Add the application code from exercise 1.
 * 
 * @author Bryan Wu
 * @version 4/6/15
 * @author Period - 7
 * @author Assignment - Ex2_IdealWeightWithGlue
 * @author Sources - None
 */
public class Ex2_IdealWeightWithGlue extends JFrame implements ActionListener
{
    private JRadioButton genderM, genderF;

    private ButtonGroup genderGroup;

    private Box genderBox;

    private JRadioButton heightA, heightB, heightC, heightD, heightE;

    private ButtonGroup heightGroup;

    private Box heightBox;

    private Box buttonBox;

    private JTextField resultText;

    private JLabel resultLabl;

    private JPanel resultPanel;


    /**
     * Ideal Weight With Glue Method.
     */
    public Ex2_IdealWeightWithGlue()
    {
        setTitle( "Your Ideal Weight" );
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        // gender group
        genderM = new JRadioButton( "Male", true );
        genderF = new JRadioButton( "Female", false );
        genderGroup = new ButtonGroup();
        genderGroup.add( genderM );
        genderGroup.add( genderF );

        genderBox = new Box( BoxLayout.Y_AXIS );
        genderBox.add( new JLabel( "Your Gender" ) );
        genderBox.add( Box.createRigidArea( new Dimension( 1, 8 ) ) );
        genderBox.add( genderM );
        genderBox.add( genderF );
        genderBox.add( Box.createRigidArea( new Dimension( 1, 73 ) ) );

        // height group
        heightA = new JRadioButton( "60 to 64 inches", true );
        heightB = new JRadioButton( "64 to 68 inches", false );
        heightC = new JRadioButton( "68 to 72 inches", false );
        heightD = new JRadioButton( "72 to 76 inches", false );
        heightE = new JRadioButton( "76 to 80 inches", false );
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

        heightBox = new Box( BoxLayout.Y_AXIS );
        heightBox.add( new JLabel( "Your Height" ) );

        // heightBox.add( Box.createRigidArea( new Dimension( 1, 8 ) ) );
        heightBox.add( Box.createVerticalGlue() );
        heightBox.add( heightA );
        heightBox.add( Box.createVerticalGlue() );
        heightBox.add( heightB );
        heightBox.add( Box.createVerticalGlue() );
        heightBox.add( heightC );
        heightBox.add( Box.createVerticalGlue() );
        heightBox.add( heightD );
        heightBox.add( Box.createVerticalGlue() );
        heightBox.add( heightE );
        heightBox.add( Box.createVerticalGlue() );

        // button Box
        buttonBox = new Box( BoxLayout.X_AXIS );
        buttonBox.add( Box.createHorizontalGlue() );
        buttonBox.add( genderBox );
        buttonBox.add( Box.createHorizontalGlue() );
        buttonBox.add( heightBox );
        buttonBox.add( Box.createHorizontalGlue() );

        // result panel
        resultText = new JTextField( 7 );
        resultText.setEditable( false );
        resultLabl = new JLabel( "Ideal Weight" );
        resultPanel = new JPanel();
        resultPanel.add( Box.createVerticalGlue() ); // glue result panel
        resultPanel.add( resultLabl );
        resultPanel.add( Box.createVerticalGlue() );
        resultPanel.add( resultText );
        resultPanel.add( Box.createVerticalGlue() );

        // Frame
        setLayout( new BoxLayout( getContentPane(), BoxLayout.Y_AXIS ) );
        buttonBox.add( Box.createVerticalGlue() );
        add( buttonBox );
        buttonBox.add( Box.createVerticalGlue() );
        add( resultPanel );
        buttonBox.add( Box.createVerticalGlue() ); // glue here

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
        resultText.setText( new DecimalFormat( "#0.0##" ).format( weight ) );

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
        Ex2_IdealWeightWithGlue weightApp = new Ex2_IdealWeightWithGlue();
        weightApp.setSize( 250, 225 );
        weightApp.setResizable( true );
        weightApp.setVisible( true );
    }
}
