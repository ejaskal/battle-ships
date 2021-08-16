/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;

/**
 * Class that realise the set side of battleField (situated on the left panel),
 * provides resourses for lockating the ships on the gamefield. Implements some
 * inherited abstract methods and additional methods for ruling the game.
 * 
 */
public class SetBattleField extends BattleField {

    protected static int[][] setField = new int[12][12];
    private static String name = "Player set battleField";
    protected static MyButton[][] setButton = new MyButton[12][12];
    private int decks;
    private int tabCounter = 0;
    private int x;
    private int y;
    
    SetBattleField() {
        super(name, setField, setButton);
    }

    /**
     * Method that seting the number of decks.
     *
     * @param decks - the number of ship decks, used for calculation of ship's
     * position
     *
     * @return
     */
    int setDecks(int decks) {
        return this.decks = decks;
    }

    /**
     * Realise mouseEvent that response on click, get the coordinate of the pressed
     * button which used in seting ship's on battleField.
     *
     * @param e - MouseEvent;
     */
    public void mouseClicked(MouseEvent e) {
        MyButton button = (MyButton) e.getSource();
        x = button.getXCoordinate();
        y = button.getYCoordinate();
        boolean b = checkIfFree(x, y);

        if (x + decks > 11 && tabCounter % 2 == 0) {
        } else if (y + decks > 11 && tabCounter % 2 == 1) {
        } else if (b == false) {
        } else {
            fillButtonBackground(x, y);
            locateManager(x, y);
            resetDecks();            
            //printField();
        }
    }

    /**
     * Futher two methods not used in this class
     * @param e
     */
    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    /**
     * Seting the coordinates of button on which mouse pointed, and call for
     * setOtherButtonBorder method.
     *
     * @param e - MouseEvent;
     */
    public void mouseEntered(MouseEvent e) {
        MyButton button = (MyButton) e.getSource();

        x = button.getXCoordinate();
        y = button.getYCoordinate();

        setOtherButtonBorder();
    }

    /**
     * Seting the coordinates (x,y) of button on which mouse pointed, and call for
     * cleanOtherButtonBorder method.
     *
     * @param e - MouseEvent;
     */
    public void mouseExited(MouseEvent e) {
        MyButton button = (MyButton) e.getSource();
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        x = button.getXCoordinate();
        y = button.getYCoordinate();

        cleanOtherButtonBorder(x, y);
    }

    /**
     * Method not used in this class
     * @param e
     */
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Response on pressing the Tab button.
     * !!! Tab is used for seleckting horizontal or vertical positioning of the
     * ship
     *
     * @param e KeyEvent
     */
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_TAB) {
            getDirection();
            System.out.println("" + tabCounter);
            cleanOtherButtonBorder(x, y);
            tabCounter++;
        } else {
            System.out.println("do nothing");
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_TAB) {
            getDirection();
            System.out.println("" + tabCounter);
            setOtherButtonBorder();
        } else {
            System.out.println("do nothing");
        }
    }

    /**
     * Paint background of automatikly generated ships.
     */
    void setLocatedShipBackground() {
        for (int i = 0; i < setField.length; i++) {
            for (int j = 0; j < setField.length; j++) {
                if (setField[i][j] == 1) {
                    setButton[i][j].setBackground(Color.GREEN);
                } else if (setField[i][j] == 2) {
                    setButton[i][j].setBackground(Color.RED);
                }
            }
        }
    }

    /**
     * Used for cleaning background of buttons in case of reseting the setField
     */
    void cleanLocatedShipBackground() {
        for (int i = 0; i < setField.length; i++) {
            for (int j = 0; j < setField.length; j++) {
                if (setField[i][j] == 1) {                    
                    setButton[i][j].setBackground(bg);//bg - is inheritee from BattleShip color varialbe
                }
            }
        }
    }

    /**
     * Returne direction: 0 - vertical, 1 - horizontal
     * @return int
     */
    private int getDirection() {
        int counter = tabCounter;
        int direction = 0;
        if (counter % 2 == 0) {
            System.out.println("direction vertical " + direction);
            return direction = 1;
        } else {
            System.out.println("direction horizontal " + direction);
            return direction = 0;
        }
    }

    /**
     * Method used for cleaning borders of button's that mouse pointer left
     *
     * @param x - horizontal button position that mouse pointer left;
     * @param y - vertical button position that mouse pointer left;
     */
    private void cleanOtherButtonBorder(int x, int y) {
        if (tabCounter % 2 == 0) {
            counterX(Color.BLACK, 1);
        } else {
            counterY(Color.BLACK, 1);
        }

    }



    /**
     * Method for setting the border of button on which pointed mouse, analyse
     * position and ship's size.
     *
     * Set border GREEN if user can locate ship here and RED if not.
     */
    private void setOtherButtonBorder() {
        boolean b = checkIfFree(x, y);
        if (tabCounter % 2 == 0) {
            if (x + decks > 11) {
                counterX(Color.RED, 4);
            } else if (b == false) {
                counterX(Color.RED, 4);
            } else {
                counterX(Color.GREEN, 4);
            }
        } else if (tabCounter % 2 == 1) {
            if (y + decks > 11) {
                counterY(Color.RED, 4);
            } else if (b == false) {
                counterY(Color.RED, 4);
            } else {
                counterY(Color.GREEN, 4);
            }
        }
    }

    /**
     * Method fill buttons background in GREEN color, that means setted Ship.
     * @param x - horizontal coordinate of clicked button;
     * @param y - vertical coordinate of clicked button;
     */
    private void fillButtonBackground(int x, int y) {
        if (tabCounter % 2 == 0) {
            for (int i = 0; i < decks; i++) {
                setButton[y][x + i].setBackground(Color.GREEN);
                setButton[y][x + i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            }
        } else {
            for (int i = 0; i < decks; i++) {
                setButton[y + i][x].setBackground(Color.GREEN);
                setButton[y + i][x].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            }
        }

    }

    /**
     * Check if chosen position is availible for setting the Ship (checked if other
     * shiped located on unallowed distance).
     *
     * @param x horizontal coordinate;
     * @param y vertical coordinate;
     * @return boolean (true if setting allowed, and false if not).
     */
    private boolean checkIfFree(int x, int y) {
        int counter = 0;
        if (tabCounter % 2 == 0) {
            for (int i = 0; i < decks; i++) {
                try {
                    if (setField[y][x + i] == 1 || setField[y][x + i] == 4) {
                        counter++;
                    }
                } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
                    System.out.println("Out of setField horizontal" + ex);
                }
            }
        } else {
            for (int i = 0; i < decks; i++) {
                try {
                    if (setField[y + i][x] == 1 || setField[y + i][x] == 4) {
                        counter++;
                    }
                } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
                    System.out.println("Out of setField vertical" + ex);
                }
            }
        }
        if (counter > 0) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * The method is calling from setOtherButtonBorder.
     * Calculating horizontal buttons and setting them border that indicated if user
     * can on the chosen location set Ship.
     *
     * @param c color of the border;
     * @param size size of the border.
     */
    private void counterX(Color c, int size) {
        for (int i = 0; i < decks; i++) {
            try {
                setButton[y][x + i].setBorder(BorderFactory.createLineBorder(c, size));
            } catch (NullPointerException ex) {
                System.out.println("set x horizontal!!!" + ex);
            } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
                System.out.println("set x horizontal!!!" + ex);
            }
        }
    }

    /**
     * The method is calling from setOtherButtonBorder.
     * Calculating vertical buttons and setting them border that indicated if user
     * can on the chosen location set Ship.
     *
     * @param c color of the border;
     * @param size size of the border.
     */
    private void counterY(Color c, int size) {
        for (int i = 0; i < decks; i++) {
            try {
                setButton[y + i][x].setBorder(BorderFactory.createLineBorder(c, size));
            } catch (NullPointerException ex) {
                System.out.println("set y vertical!!!" + ex);
            } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
                System.out.println("set y vertical!!!" + ex);
            }
        }

    }

    /**
     * Realisation of abstract method locateManager inherited from parend class
     * manage the process of location of the ships on the battleField.
     *
     * Call for border methods:
     * when tabCounter%2==0  borderHorizontal, else borderVertical, which called
     * from parent class.
     *
     *
     * The parameter of the border depends on position (x, y) and direction:
     *
     * @param x - horizontal coordinates ship's first point, values should be
     * taken from MouseClicked method;
     * @param y - vertikal coordinates ship's first pointvalues should be
     * taken from MouseClicked method;
     */
    public void locateManager(int x, int y) {
        if (tabCounter % 2 == 0) {
            super.borderHorizontal(x, y, decks, -1, setField, 1);
        } else {
            super.borderVertical(x, y, decks, -1, setField, 1);
        }
    }


    /**
     * Change the number of ships decks in manual ship setting
     */
    private void resetDecks() {
        int counter = shipsCounter ();
        if (counter>=4&counter<10){
            decks=3;
        } else if (counter>=10&counter<16) {
            decks=2;
        }else if (counter>=16&counter<20){
            decks=1;
        }else {
            decks=0;
            System.out.println("Ships setted");
            GUI.startGame.setEnabled(true);
        }
    }


    /**
     * Control the number of setted ships
     * @return int
     */
    private int shipsCounter (){
        int counter =0;
        for (int i = 0; i < setField.length; i++) {
            for (int j = 0; j < setField.length; j++) {
                if (setField[i][j]==1){
                    counter++;
                }
            }
        }
        return counter;
    }

    /**
     * Controls if on x,y, coordinates situated ship or not.
     * @param x horizontal coordinate
     * @param y vertical coordinate
     * @return int (return parameters in accordance with setField matrix)
     */
    int checkCoordinates(int x, int y) {
        if (setField[y][x] == 1) {
            return 1;
        } else if (setField[y][x] == 4) {
            return 4;
        } else {
            return 0;
        }
    }


    /**
     * Method correspondent with opponent player and change the set battle field
     * values.
     *
     * @param x horizontal coordinate which fired opponent
     * @param y vertical coordinate whic fired opponent
     * @param state reflect the state of element (9 - miss, 2 - get the ship)
     */

    void changeField(int x, int y, int state) {
        setField[y][x] = state;
        setLocatedShipBackground();
        System.out.println("setField player after change");
        printField();
    }

    /**
     * Make control if on fired coordinates is situated ship, and if it was destroyed
     * or opponent just partly get it.
     *
     * @param x horizontal coordinate which fired opponent
     * @param y vertical coordinate whic fired opponent
     * @return boolean (true - if ship destroyed, false - if not)
     */
    boolean checkIfKilled(int x, int y) {
        int tempX = x;
        int tempY = y;
        int counter = 0;

        while (setField[tempY][tempX] != 4) {
            if (setField[tempY][tempX] == 1) {
                counter++;
            }
            tempY--;
        }
        tempX = x;
        tempY = y;
        while (setField[tempY][tempX] != 4) {
            if (setField[tempY][tempX] == 1) {
                counter++;
            }
            tempY++;
        }
        tempX = x;
        tempY = y;
        while (setField[tempY][tempX] != 4) {
            if (setField[tempY][tempX] == 1) {
                counter++;
            }
            tempX--;
        }
        tempX = x;
        tempY = y;
        while (setField[tempY][tempX] != 4) {
            if (setField[tempY][tempX] == 1) {
                counter++;
            }
            tempX++;
        }

        if (counter > 0) {
            return false;
        } else {
            return true;
        }
    }
}
