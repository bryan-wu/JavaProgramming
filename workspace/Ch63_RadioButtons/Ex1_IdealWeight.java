import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;


/**
 * Application part of the ideal weight calculator that is described in this
 * chapter (the first version).
 * 
 * @author Bryan Wu
 * @version 4/3/15
 * @author Period - 7
 * @author Assignment - Ex1_IdealWeight
 * @author Sources - None
 */
public class Ex1_IdealWeight extends JFrame implements ActionListener
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


    public Ex1_IdealWeight()
    {
        setTitle( "Your Ideal Weight" );
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
        Ex1_IdealWeight weightApp = new Ex1_IdealWeight();
        weightApp.setSize( 250, 225 );
        weightApp.setResizable( false );
        weightApp.setVisible( true );
    }
}
