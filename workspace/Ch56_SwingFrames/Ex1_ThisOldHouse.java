import javax.swing.*;

import java.awt.*;
import java.awt.geom.*;


/**
 * Puts house in frame.
 * 
 * @author Bryan Wu
 * @version 3/20/15
 * 
 * @author Period - 7
 * @author Assignment - Ch56 Ex1_ThisOldHouse
 * @author Sources - None
 */
public class Ex1_ThisOldHouse extends JFrame
{
    /**
     * Creates the display panel and adds it to the JFrame.
     */
    public Ex1_ThisOldHouse()
    {
        Display displayPanel = new Display();

        JPanel content = new JPanel();
        content.setLayout( new BorderLayout() );
        content.add( displayPanel, BorderLayout.CENTER );
        setContentPane( content );
        setTitle( "JFrame House" );
    }


    /**
     * Defines the display panel.
     */
    private class Display extends JPanel
    {
        public void paintComponent( Graphics gr )
        {
            super.paintComponent( gr );

            int width = getContentPane().getWidth();
            int height = getContentPane().getHeight();
            setBackground( Color.WHITE );

            gr.setColor( Color.BLUE );
            gr.drawRect( 0, 0, width - 1, height - 1 );
            String str = "";

            Font curFont = gr.getFont();
            FontMetrics curFontMetrics = gr.getFontMetrics( curFont );
            Rectangle2D r2d = curFontMetrics.getStringBounds( str, gr );

            int strWidth = (int)( (Rectangle2D.Float)r2d ).width;
            int strHeight = (int)( (Rectangle2D.Float)r2d ).height;
            gr.setColor( Color.BLACK );
            gr.drawString( str,
                ( width - strWidth ) / 2,
                ( height + strHeight ) / 2 );

            final int houseX = 65, houseY = 100, houseW = 110, houseH = 110;
            final int doorY = 165, doorW = 25, doorH = 40;
            final int lWindX = 90, lWindY = 115, lWindW = 30, lWindH = 30;
            final int rWindX = 130, rWindY = 115, rWindW = 30, rWindH = 30;
            final int trunkX = 255, trunkY = 100, trunkW = 10, trunkH = 100;

            // tree leaves
            final int treeX = 200, treeY = 45, treeW = 125, treeH = 55;

            final int L1X1 = 0, L1Y1 = 140, L1X2 = 40, L1Y2 = 115;
            final int L2X1 = L1X2, L2Y1 = L1Y2, L2X2 = houseX, L2Y2 = 130;
            final int L3X1 = houseX + houseW, L3Y1 = 135, L3X2 = trunkX, L3Y2 = 140;
            final int L4X1 = trunkX + trunkW, L4Y1 = L3Y2, L4X2 = width, L4Y2 = 110;

            final int roof1X1 = houseX, roof1Y1 = houseY;
            final int roof1X2 = houseX + houseW / 2, roof1Y2 = 50;
            final int roof2X1 = roof1X2, roof2Y1 = roof1Y2;
            final int roof2X2 = houseX + houseW, roof2Y2 = houseY;
            final int doorX = houseX + houseW / 2 - doorW / 2;

            gr.setColor( new Color( 102, 51, 0 ) ); // there is no color brown
            gr.drawRect( houseX, houseY, houseW, houseH ); // house
            gr.fillRect( doorX, doorY, doorW, doorH ); // door
            gr.drawRect( lWindX, lWindY, lWindW, lWindH ); // lwind
            gr.drawRect( rWindX, rWindY, rWindW, rWindH ); // rwind
            gr.fillRect( trunkX, trunkY, trunkW, trunkH ); // trunk

            gr.setColor( Color.green );
            gr.fillOval( treeX, treeY, treeW, treeH );

            gr.drawLine( L1X1, L1Y1, L1X2, L1Y2 ); // line 1
            gr.drawLine( L2X1, L2Y1, L2X2, L2Y2 ); // line 2
            gr.drawLine( L3X1, L3Y1, L3X2, L3Y2 ); // line 3
            gr.drawLine( L4X1, L4Y1, L4X2, L4Y2 ); // line 4

            gr.setColor( Color.green );
            gr.drawLine( roof1X1, roof1Y1, roof1X2, roof1Y2 );
            gr.drawLine( roof2X1, roof2Y1, roof2X2, roof2Y2 );

        }
    }


    /**
     * Creates, sizes and enables the display of this JFrame.
     * 
     * @param args
     *            command-line parameters (not used)
     */
    public static void main( String[] args )
    {
        Ex1_ThisOldHouse frm = new Ex1_ThisOldHouse();

        frm.setSize( 400, 300 );
        frm.setLocation( 100, 100 );
        frm.setVisible( true );
    }
}
