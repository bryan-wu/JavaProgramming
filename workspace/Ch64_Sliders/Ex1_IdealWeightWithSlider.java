import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author Bryan Wu
 * @version 4/9/15
 * @author Period - 7
 * @author Assignment - Ex1_IdealWeightWithSlider
 * @author Sources - None
 */
public class Ex1_IdealWeightWithSlider extends JFrame
                implements
                ChangeListener,
                ActionListener
{
    private JRadioButton genderM, genderF;

    private ButtonGroup genderGroup;

    private JPanel genderPanel;

    private JPanel heightPanel;

    private JTextField resultText;

    private JLabel resultLabl;

    private JPanel resultPanel;

    private JSlider heightSlider;

    private int height, weight;


    public Ex1_IdealWeightWithSlider()
    {
        setTitle( "Your Ideal Weight" );
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        // slider
        heightSlider = new JSlider( JSlider.VERTICAL, 40, 80, 58 );
        heightSlider.setMajorTickSpacing( 10 );
        heightSlider.setMinorTickSpacing( 1 );
        heightSlider.setPaintTicks( true );
        heightSlider.setPaintLabels( true );
        heightSlider.setPreferredSize( new Dimension( 50, 300 ) );
        heightSlider.addChangeListener( this );
        heightSlider.setName( "heightSlider" );

        // gender group
        genderM = new JRadioButton( "Male", true );
        genderF = new JRadioButton( "Female", false );
        genderGroup = new ButtonGroup();
        genderGroup.add( genderM );
        genderGroup.add( genderF );
        genderPanel = new JPanel();
        genderPanel.setLayout( new BoxLayout( genderPanel, BoxLayout.Y_AXIS ) );
        genderPanel.add( new JLabel( "Your Gender" ) );

        genderM.setActionCommand( "m" );
        genderF.setActionCommand( "f" );
        genderM.addActionListener( this );
        genderF.addActionListener( this );
        genderPanel.add( genderM );
        genderPanel.add( genderF );

        // height group
        heightPanel = new JPanel();
        heightPanel.setLayout( new BoxLayout( heightPanel, BoxLayout.Y_AXIS ) );
        heightPanel.add( new JLabel( "Your Height in Inches" ) );
        heightPanel.add( heightSlider );

        // result panel
        resultText = new JTextField( 7 );
        resultText.setEditable( false );
        resultLabl = new JLabel( "Ideal Weight" );
        resultPanel = new JPanel();
        resultPanel.add( resultLabl );
        resultPanel.add( resultText );

        // content pane
        getContentPane().setLayout( new BorderLayout() );
        getContentPane().add( genderPanel, BorderLayout.WEST );
        getContentPane().add( heightPanel, BorderLayout.EAST );
        getContentPane().add( resultPanel, BorderLayout.SOUTH );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }


    public void stateChanged( ChangeEvent evt )
    {
        int height = 0;
        int weight = 0;
        height = heightSlider.getValue();

        if ( genderF.isSelected() )
        {
            weight = ( height * height ) / 30; // female
        }
        if ( genderM.isSelected() )
        {
            weight = ( height * height ) / 28; // male
        }
        resultText.setText( "" + weight );

        repaint();
    }


    public void actionPerformed( ActionEvent e )
    {
        int height = 0;
        int weight = 0;
        height = heightSlider.getValue();

        if ( genderF.isSelected() )
        {
            weight = ( height * height ) / 30; // female
        }
        if ( genderM.isSelected() )
        {
            weight = ( height * height ) / 28; // male
        }
        resultText.setText( "" + weight );

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
        Ex1_IdealWeightWithSlider weightApp = new Ex1_IdealWeightWithSlider();
        weightApp.setSize( 250, 400 );
        weightApp.setVisible( true );
    }

}
