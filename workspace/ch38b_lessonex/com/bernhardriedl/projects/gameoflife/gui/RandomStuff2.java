package com.bernhardriedl.projects.gameoflife.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import com.bernhardriedl.projects.gameoflife.logic.CreaturesMatrix;
import com.bernhardriedl.projects.tools.utils.Utils;

public class CreaturesMatrixCanvas
    extends JPanel
    implements MouseListener {
    
    private static final long serialVersionUID = -983954505399906575L;

    private final int padding=10;
    private final int fontHeight=25;
    
    private Color color1=new Color(98,126, 184);
    private Color color2=new Color(86, 134, 92);
    private Color color3=new Color(227, 115, 34);

    private Color colorbg=new Color(190, 213, 202);

    private CreaturesMatrix creaturesMatrix=null;

    /**
     * Constructor
     * @param x width
     * @param y height
     * @throws Exception
     */

    public CreaturesMatrixCanvas(int x, int y) throws Exception {
        this.addMouseListener(this);

        this.creaturesMatrix=new CreaturesMatrix(x, y);

        this.repaint();
    }

    /**
     * fill matrix with
     * a random number of creatures
     * @param x width
     * @param y height
     * @param lifeFactor int
     * @throws Exception
     */

    public void buildFromRandom(int x, int y, int lifeFactor) throws Exception {
        this.creaturesMatrix.buildFromRandom(x, y, lifeFactor);

        this.repaint();
    }

    /**
     * build empty matrix
     * @param x width
     * @param y height
     * @throws Exception
     */

    public void buildEmpty(int x, int y) throws Exception {
        this.creaturesMatrix.buildEmpty(x, y);

        this.repaint();
    }

    /**
     * load matrix from stream
     * @param name String
     * @throws Exception
     */

    public void buildFromStream(String name) throws Exception {
        this.creaturesMatrix.buildFromStream(name);

        this.repaint();
    }

    /**
     * load matrix from file
     * @param fileName String
     * @throws Exception
     */

    public void buildFromFile(String fileName) throws Exception {
        this.creaturesMatrix.buildFromFile(fileName);

        this.repaint();
    }

    /**
     * save matrix to file
     * @param fileName String
     * @throws Exception
     */

    public void save(String fileName) throws Exception {
        this.creaturesMatrix.save(fileName);
    }

    /**
     * calculate next generation
     * of matrix
     * @throws Exception
     */

    public void nextGeneration() throws Exception {
        this.creaturesMatrix.nextGeneration();

        this.repaint();
    }

    /**
     * getCellX
     * @return screen-width
     */

    private int getCellX() {
        return (this.getWidth()-(this.padding*2))/this.getDimensionX();
    }

    /**
     * getCellY
     * @return screen-height
     */

    private int getCellY() {
        return (this.getHeight()-(this.padding*2+this.fontHeight))/this.getDimensionY();
    }

    /**
     * getDimensionX
     * @return matrix-width
     */

    public int getDimensionX() {
        return this.creaturesMatrix.getDimensionX();
    }

    /**
     * getDimensionY
     * @return matrix-height
     */

    public int getDimensionY() {
        return this.creaturesMatrix.getDimensionY();
    }

    /**
     * paints the matrix
     * @param g Graphics
     */

    public void paintComponent(Graphics g) {
        Image offscreenImg = createImage(this.getWidth(), this.getHeight());
        Graphics offscreenG = offscreenImg.getGraphics();

        offscreenG.setColor(this.colorbg);
        offscreenG.fillRect(0, 0, this.getWidth(), this.getHeight());
        offscreenG.setColor(Color.white);
        offscreenG.fillRoundRect(0, 0, this.getWidth(), this.getHeight()-5,35,35);
        offscreenG.setColor(Color.BLACK);

        int cellX=this.getCellX();
        int cellY=this.getCellY();

        String text="Statistics: "+getAlive()+" of "+getAllCreatures()+" alive ("+Utils.rundeDouble(getPercentage())+" %)";
        offscreenG.drawString(text,10,this.fontHeight);

        /**
         * draw creatures
         */

        for (int i=0; i<this.getDimensionX(); i++) {
            for (int j=0; j<this.getDimensionY(); j++) {
                int neighbours=this.getNeighbours(i, j, 1);

                /**
                 * color according to
                 * neighbours count
                 */

                if (this.creaturesMatrix.getValue(i, j)) {
                    if (neighbours>25)
                        offscreenG.setColor(this.color3);
                    else if (neighbours>10)
                            offscreenG.setColor(this.color2);
                }

                else
                    offscreenG.setColor(this.color1);

                offscreenG.drawRect((i*cellX)+this.padding,(j*cellY)+this.padding+this.fontHeight, cellX, cellY);

                if (creaturesMatrix.getValue(i, j))
                    offscreenG.fillRect((i*cellX)+this.padding,(j*cellY)+this.padding+this.fontHeight, cellX, cellY);
            }
        }

        Graphics2D g2=(Graphics2D) g;
        g2.drawImage(offscreenImg,0,0,this);
    }

    /**
     * get number of creatures
     */

    public int getAlive() {
        return this.creaturesMatrix.getAlive();
    }

    /**
     * get percentage of alive creatures
     * in relation with available space
     */

    public double getPercentage() {
        return (double)((getAlive()*100)/(double)getAllCreatures());
    }

    /**
     * get available space
     */

    public int getAllCreatures() {
        return (int) (this.getDimensionX()*this.getDimensionY());
    }

    /**
     * get neighbour-count
     */

    public int getNeighbours(int x, int y, int level) {
        return this.creaturesMatrix.countNeighbours(x, y, level);
    }

    /**
     * Colors
     */

    public void setColor1(Color color1) {
        this.color1=color1;
        this.repaint();
    }

    public Color getColor1() {
        return this.color1;
    }

    public void setColor2(Color color2) {
        this.color2=color2;
        this.repaint();
    }

    public Color getColor2() {
        return this.color2;
    }

    public void setColor3(Color color3) {
        this.color3=color3;
        this.repaint();
    }

    public Color getColor3() {
        return this.color3;
    }

    public void setBackground(Color bg) {
        this.colorbg=bg;
        this.repaint();
    }

    /**
     * setter for bounds of world
     * @param hasBounds boolean
     */

    public void setBounds(boolean hasBounds) {
        this.creaturesMatrix.setBounds(hasBounds);
    }

    /**
     * handle setting or deleting a
     * creature in the matrix
     * @param e MouseEvent
     */

    public void mousePressed(MouseEvent e) {
        int x=(e.getX()-this.padding)/this.getCellX();
        int y=(e.getY()-this.padding-this.fontHeight)/this.getCellY();

        this.creaturesMatrix.changeValue(x, y);
        this.repaint();
    }

    /**
     * not used
     */

    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}