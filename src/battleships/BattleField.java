package battleships;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Abstract Class that used for creating game fields, provaides main battleField components and
 * methods, that may be used for creating virtual battleField (variable field) and GUI field.
 *
 * 
 */

public abstract class BattleField extends JPanel implements MouseListener, KeyListener  {
    private int [][] field;// = new int [12][12];//virtual field
    private int decks;
    protected MyButton[][] btn;
    protected Color bg = new Color(200, 220, 230);
    private String fieldName;

    BattleField(String name, int [][] virtualField, MyButton [][] button) {
        this.fieldName = name;
        this.field = virtualField;
        this.btn = button;
        field = fieldFiller();
        //printField();
    }

    /**
     * Method for creating GUI interface (10x10 field with buttons).
     * be used as for making SetBattleField, as FireBattleField.
     *
     * @return JPanel
     */

    JPanel createField(){

        JPanel setSide = new JPanel ();

        setSide.setPreferredSize(new Dimension(400, 400));
        setSide.setMinimumSize(new Dimension(300, 300));
        setSide.setMaximumSize(new Dimension(400, 400));
        setSide.setSize(new Dimension(400, 400));

        GridLayout grdl = new GridLayout(10, 10, 2, 2);
        Border brd = BorderFactory.createLineBorder(Color.BLACK);
        setSide.setOpaque(true);
        setSide.setLayout(grdl);
        setSide.setFocusable(true);
        setSide.setFocusTraversalKeysEnabled(false);
        setSide.addKeyListener(this);


        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                btn[i][j] = new MyButton(j,i);
                setSide.add(btn[i][j]);
                btn[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                btn[i][j].setBackground(bg);
                btn[i][j].addMouseListener(this);
                btn[i][j].addKeyListener(this);
                btn[i][j].setFocusTraversalKeysEnabled(false);
                btn[i][j].repaint();
            }
        }       
        setSide.repaint();
        setSide.setVisible(true);

        return setSide;
    }


    /**
     * Method used for cleaning virtial field, called from  class GUI when
     * pressing "Reset" button
     *
     * @param field - instance of virtual buttleField
     */
    void resetField() {        
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j]=0;

            }

        }
    }

    /**
     * Method that used for filling virtual field
     *
     * @param field  instance of virtual buttleField
     * @return int [][]
     */
    private int[][] fieldFiller() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = 0;
            }
        }
        return field;
    }

    /**
     * Helping method for debugging
     * @param arr - instanse of virtual field
     */
    public void printField() {
        System.out.println("Field name: "+fieldName);
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(" " + field[i][j]);
            }
            System.out.println(" ");
        }
        System.out.println("");
    }


    /**
     * Block ButtonListeners
     */
    void block() {
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                btn[i][j].removeNotify();
            }
        }
    }


    /**
     * Unblock ButtonListeners
     */
     void unblock() {
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                btn[i][j].addNotify();
            }
        }
    }



    /**
     * Abstract method locateManager manage the process of location of the ships on the battleField.
     *
     * Also calling for border methods (borderVertical, borderHorizontal  while in
     * accordance whith the rules ships can't be closer to each other than one field),
     * which sending border coordinates of the ships to setShip and setBorder
     * methods in SetBattleField class.
     *
     * In acordance with the directions change the ButtleField paramerters from 0
     * (which mean clean field) to 1 which mean "here" is the ship).
     *
     * The parameter of the border depends on position (x, y) and direction:
     *
     * @param x - horizontal coordinates ship's first point, values should be
     * taken from MouseClicked method;
     * @param y - vertikal coordinates ship's first pointvalues should be
     * taken from MouseClicked method;
     */

     public abstract void  locateManager(int x, int y);



     /**
       * Method for determination of ship and border VERTICAL coordinate aand setting
       * them on the virtual field.
       *
       * @param x - horizontal coordinates of the first point of the ship;
       * @param y - vertikal coordinates of the first point of the ship;
       * @param decks - the number of the decks;
       * @param i - additional parameter for setting upper/downer border (-1 if ship positioning up);
       * @param field - the instanse of virtual field;
       *
       */

    void borderVertical(int x, int y, int decks, int i, int [][]field, int state) {
        for (int n = 0; n < decks; n++) {
             if (n==0){
                field[y+n][x]=state;
                field[y+n][x+1]=4;
                field[y+n][x-1]=4;
                field[y+i][x]=4;
                field[y+i][x+1]=4;
                field[y+i][x-1]=4;
                field[y+decks][x]=4;
                field[y+decks][x+1]=4;
                field[y+decks][x-1]=4;

             }else {
                 field[y+n][x]=state;
                 field[y+n][x+1]=4;
                 field[y+n][x-1]=4;

             }
         }
    }




     /**
     * Method for determination ship's and border's HORIZONTAL coordinate and setting
     * them on the virtual field.
     *
     * @param x - horizontal coordinates of the first point of the ship;
     * @param y - vertikal coordinates of the first point of the ship;
     * @param decks - the number of the decks;
     * @param i - additional parameter for setting border (-1 if ship positioning left);
     * @param field - the instanse of virtual field;
     *
     */

    void borderHorizontal(int x, int y, int decks, int i, int [][]field, int state) {
        for (int n = 0; n < decks; n++) {
             if (n==0){
                 field[y][x+n]=state;
                 field[y+1][x+n]=4;
                 field[y-1][x+n]=4;
                 field[y][x+i]=4;
                 field[y+1][x+i]=4;
                 field[y-1][x+i]=4;
                 field[y][x+decks]=4;
                 field[y+1][x+decks]=4;
                 field[y-1][x+decks]=4;

             }else {
                 field[y][x+n]=state;
                 field[y+1][x+n]=4;
                 field[y-1][x+n]=4;

             }
         }
    }



    /**
     * Abstract MouseListener methods which should be implemented in SetBattleField and
     * FireBattleField classes
     *
     * @param e - MouseEvent
     */
    public abstract void mouseClicked(MouseEvent e);

    public abstract void mousePressed(MouseEvent e);

    public abstract void mouseReleased(MouseEvent e);

    public abstract void mouseEntered(MouseEvent e);

    public abstract void mouseExited(MouseEvent e);


    /**
     * Abstract KeyListener methods which should be implemented in SetBattleField and
     * FireBattleField classes
     *
     * @param e - KeyEvent
     */
    public abstract void keyTyped(KeyEvent e);

    public abstract void keyPressed(KeyEvent e);

    public abstract void keyReleased(KeyEvent e);


}
