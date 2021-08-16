package battleships;

import java.awt.Color;
import java.util.Scanner;

/**
 * Class Rival provides method for automatic generation of ships on setBattleField.
 * Also sed for creating virtual player that can locate ships and fire on opponent field.
 *
 * @author Евгений
 */
public class VirtualPlayer {

    int x;
    int y;
    private int[] directions = {1, 1, 1, 1};
    protected static int setField[][] = new int[12][12];
    protected static int fireField[][] = new int[12][12];
    ShipsGenerator shipGen;
    SetBattleField opponentPlayer;//the instance of SetBattleField
    int nextShooting;
    int exactDirection;
    int cell;
    boolean getTarget;

    /**
     * Constructor of VirtualPlayer class. At the moment of creating the instance of
     * this class virtualPlayer call for ShipsGenerator that located ships on VP setField
     *
     * @param sbf the instance of player.
     */
    public VirtualPlayer(SetBattleField sbf) {
        this.opponentPlayer = sbf;

        setField = gameArray(12, 12);
        fireField = gameArray(12, 12);
        
        shipGen = new ShipsGenerator(setField);
        //System.out.println("AI rival ships");
        //printArr(setField);
    }

    VirtualPlayer() {
        setField = gameArray(12, 12);
        fireField = gameArray(12, 12);

        shipGen = new ShipsGenerator(setField);
        //System.out.println("AI rival ships");
        //printArr(setField);
    }

    /**
     * Method that responceble for management of virtualPlayer shooting. Mainly decide
     * if VP will shoot on a new position or will contunue to search for already woonded ship.
     */
    public void fireManager() {
        if (nextShooting == 2) {
            if (cell <= 1) {
                chooseExactDirection();
                setCoordinates(x, y);
                analyseCoordinates();
            } else {
                setCoordinates(x, y);
                analyseCoordinates();
            }
        } else {
            setCoordinates();
            analyseCoordinates();
            //System.out.println("Virtual player fire Field");
            //printArr(fireField);
        }
        //System.out.println("direction Exact " + exactDirection);
        //System.out.println("Cell " + cell);
    }

    /**
     * If VP (virtual player) has some variants of shooting directions this method
     * generate one that suites.
     */
    private void chooseExactDirection() {
        int random = generatePoint();
        while (random > 3 || (random < 4 & directions[random] == 0)) {
            random = generatePoint();
        }
        exactDirection = random;
    }

    /**
     * In case that on chosen position wasn't found opponent vessel, but it's still alive
     * VP goes back to firs points and continue to shoot from that point, in this case it
     * alse remmember all already shooted directions.
     */
    private void resetPosition() {
        if (exactDirection == 0) {
            y = y + cell;
        } else if (exactDirection == 1) {
            x = x - cell;
        } else if (exactDirection == 2) {
            y = y - cell;
        } else {
            x = x + cell;
        }
    }

    /**
     * Calling for coordinare randome generator and checking recieved results
     */
    private void setCoordinates() {
        x = generatePoint() + 1;
        y = generatePoint() + 1;
        //System.out.println("generated x" + x);
        //System.out.println("gtntrated y" + y);
        while (fireField[y][x] == 4 || fireField[y][x] == 9 || fireField[y][x] == 2) {
            x = generatePoint() + 1;
            y = generatePoint() + 1;
        }
    }

    /**
     * Set the next fire coordinated based on the chosen direction
     *
     * @param x horizontal coordinate
     * @param y vertical coordinate
     */
    private void setCoordinates(int x, int y) {
        if (exactDirection == 0) {
            this.x = x;
            this.y = y - 1;
        } else if (exactDirection == 1) {
            this.x = x + 1;
            this.y = y;
        } else if (exactDirection == 2) {
            this.x = x;
            this.y = y + 1;
        } else {
            this.x = x - 1;
            this.y = y;
        }
    }

    /**
     * Method serve for communication whith player set field. Send to it coordinations
     * and analyse recieved answer.
     *      nextShooting - indicate that used for shoot cycling. If nextShooting = 1 - opponent
     *      vessel was killed so need to start shooting cycle from beginning; if = 2 - contitue
     *      search the rest of the ship.
     *
     */
    private void analyseCoordinates() {
        int rivalShip = opponentPlayer.checkCoordinates(x, y);
        if (rivalShip == 1) {
            opponentPlayer.changeField(x, y, 2);
            getTarget = true;
            boolean killed = opponentPlayer.checkIfKilled(x, y);
            if (killed == true) {
                fireField[y][x] = 2;
                opponentPlayer.changeField(x, y, 2);
                locateManager();
                resetDirections();
                nextShooting = 1; //
                cell = 0;
            } else {
                opponentPlayer.changeField(x, y, 2);
                fireField[y][x] = 2;
                nextShooting = 2;
                analyseDirections();
                cell++;
            }
        } else {
            getTarget = false;
            fireField[y][x] = 9;
            try {
                opponentPlayer.btn[y][x].setBackground(Color.GRAY);
            } catch (java.lang.NullPointerException ex) {
                System.out.println("Error" + ex);
                System.out.println("coordinates X " + x);
                System.out.println("coordinates Y " + y);
            }
            if (nextShooting == 2) {
                changeDirections();
                resetPosition();
                                    //probably will need to reset cell
            } else {
                nextShooting = 0;
                resetDirections();
                cell = 0;
            }
        }
    }

    /**
     * Setting on the VP fireField killed ship and it security zone.
     */
    private void locateManager() {
        int position = definitePosition();

        int firstX;
        int firstY;
        if (position == 1) {
            firstY = y;
            firstX = firstX();
        } else if (position == 2) {
            firstX = x;
            firstY = firstY();
        } else {
            firstY = y;
            firstX = x;
        }

        int decks = countDecks(firstX, firstY, position);
        if (position == 1 || position == 3) {
            borderHorizontal(firstX, firstY, decks, -1, fireField, 2);
        } else if (position == 2) {
            borderVertical(firstX, firstY, decks, -1, fireField, 2);
        }
    }

    /**
     * Method definite if ship situated vertically or horizontally, that used when
     * the setting security zone arround killed vessel.
     * @return int: 1. horizontal position;
     * 2. vertical position;
     * 3. no metter whot position, while we have 1 deck ship.
     */
    private int definitePosition() {
        int tempX = x;
        int tempY = y;
        if (fireField[tempY][tempX + 1] == 2 || fireField[tempY][tempX - 1] == 2) {
            return 1;//horizontal position
        } else if (fireField[tempY + 1][tempX] == 2 || fireField[tempY - 1][tempX] == 2) {
            return 2; //vertikal position
        } else {
            return 3; //1 deck ship, so we have no problem with Pozitioning
        }
    }

    /**
     * Searching the extreme left coordinate of the Ship
     *
     * @param x - horizontal coordinate of the last shoot;
     * @param y - vertical coordinate of the last shoor;
     * @return - first left X coordinate.
     */
    private int firstX() {
        int tempX = x;
        try {
            while (fireField[y][tempX] == 2) {
                tempX--;
            }
        } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
            System.out.println("find x out" + ex);

        } finally {
            return ++tempX;
        }
    }

    /**
     * Searching the extreme upper coordinate of the Ship
     *
     * @param x - horizontal coordinate of the last shoot;
     * @param y - vertical coordinate of the last shoor;
     * @return - first upper Y coordinate.
     */
    private int firstY() {
        int tempY = y;
        try {
            while (fireField[tempY][x] == 2) {
                tempY--;
            }
        } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
            System.out.println("find y out" + ex);
        } finally {
            return ++tempY;
        }
    }

    /**
     * Analyse the size of ship.
     *
     * @param x first left coordinate;
     * @param y first upper coordinate.
     * @param i direction of the ship (1 - horizontal,2 - vertical)
     * @return int (number of decks).
     */
    private int countDecks(int x, int y, int i) {
        int decks = 0;
        int tempX = x;
        int tempY = y;
        if (i == 1) {
            try {
                while (fireField[y][tempX] == 2) {
                    tempX++;
                    decks++;
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
                System.out.println("decks count" + ex);
            }
        } else if (i == 2) {
            try {
                while (fireField[tempY][x] == 2) {
                    tempY++;
                    decks++;
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
                System.out.println("decks count" + ex);
            }

        } else {
            decks = 1;
        }
        return decks++;
    }

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
    void borderVertical(int x, int y, int decks, int i, int[][] field, int state) {
        for (int n = 0; n < decks; n++) {
            if (n == 0) {
                field[y + n][x] = state;
                field[y + n][x + 1] = 4;
                field[y + n][x - 1] = 4;
                field[y + i][x] = 4;
                field[y + i][x + 1] = 4;
                field[y + i][x - 1] = 4;
                field[y + decks][x] = 4;
                field[y + decks][x + 1] = 4;
                field[y + decks][x - 1] = 4;

            } else {
                field[y + n][x] = state;
                field[y + n][x + 1] = 4;
                field[y + n][x - 1] = 4;
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
    void borderHorizontal(int x, int y, int decks, int i, int[][] field, int state) {
        for (int n = 0; n < decks; n++) {
            if (n == 0) {
                field[y][x + n] = state;
                field[y + 1][x + n] = 4;
                field[y - 1][x + n] = 4;
                field[y][x + i] = 4;
                field[y + 1][x + i] = 4;
                field[y - 1][x + i] = 4;
                field[y][x + decks] = 4;
                field[y + 1][x + decks] = 4;
                field[y - 1][x + decks] = 4;

            } else {
                field[y][x + n] = state;
                field[y + 1][x + n] = 4;
                field[y - 1][x + n] = 4;
            }
        }
    }

    /**
     * Get clicked coordinates from FireBattleField, and check virtual buttleField of
     * virtual player.
     *
     * @param x opponent fired horizontal coordinates;
     * @param y opponent fired vertical coordinates;
     * @return
     */
    static int checkCoordinates(int x, int y) {
        if (setField[y][x] == 1) {
            return 1;
        } else if (setField[y][x] == 4) {
            return 4;
        } else {
            return 0;
        }
    }

    /**
     *Change the virtual setField of the virtual player
     *
     * @param x opponent fired horizontal coordinates;
     * @param y opponent fired vertical coordinates;
     * @param state change ship's state (1 - alive, 2 - voonded).
     */
    static void changeField(int x, int y, int state) {
        setField[y][x] = state;
        //printArr(setField);
    }

    /**
     * Method checked if virtual player ship destroyed
     *
     * @param x opponent fired horizontal coordinates;
     * @param y opponent fired vertical coordinates;
     * @return boolean (true if destroyed, false if not).
     */
    static boolean checkIfKilled(int x, int y) {
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
        System.out.println("Finished");
        if (counter > 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Reset direction matrix to beginning state, that happens when the opponent
     * vessel was destroyed.
     */
    private void resetDirections() {
        for (int i = 0; i < directions.length; i++) {
            directions[i] = 1;
        }
    }

    /**
     * On the basis of chosen coordinates analyse the possible directions for next
     * shooting, method indicates if on the next points is located other ship that
     * was by VP found, or VP olready shoot on that point
     */
    private void analyseDirections() {
        if (y - 1 < 1 || fireField[y - 1][x] == 9 || fireField[y - 1][x] == 4) {
            directions[0] = 0;
        }
        if (x + 1 > 10 || fireField[y][x + 1] == 9 || fireField[y][x + 1] == 4) {
            directions[1] = 0;
        }
        if (y + 1 > 10 || fireField[y + 1][x] == 9 || fireField[y + 1][x] == 4) {
            directions[2] = 0;
        }
        if (x - 1 < 1 || fireField[y][x - 1] == 9 || fireField[y][x - 1] == 4) {
            directions[3] = 0;
        }
    }

    /**
     * Set 0 to direction matrix if chosen exactDirection was incorrect.
     */
    private void changeDirections() {
        directions[exactDirection] = 0;
    }

    /**
     * Random coordinate generatior
     * @return
     */
    private int generatePoint() {
        double i = Math.random() * 10;
        int rnd = (int) i;
        return rnd;
    }

    /**
     * Manual console coordinate setting (for debuging)
     * @return
     */
    private int generatePointMan() {
        return new Scanner(System.in).nextInt();
    }

    /**
     * Creates virtual set field.
     *
     * @param x max horizontal size;
     * @param y max vertical size;
     * @return int [][] (setField)
     */
    private static int[][] gameArray(int x, int y) {
        int arr[][] = new int[x][y];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = 0;
            }
        }
        return arr;
    }

    /**
     * Virtual setField console printing (for debuging)
     * @param arr
     */
    public static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(" " + arr[i][j]);
            }
            System.out.println(" ");
        }
        System.out.println("");
    }

    /**
     * Nullify the setField, probably will not be used
     */
    void resetField() {
        for (int i = 0; i < setField.length; i++) {
            for (int j = 0; j < setField.length; j++) {
                setField[i][j] = 0;
            }
        }
        //System.out.println("Ai ships");
        //printArr(setField);
    }

    /**
     * Nullify the VP set field, used mainly when new game is chosen.
     */
    void resetFireField() {
        for (int i = 0; i < fireField.length; i++) {
            for (int j = 0; j < fireField.length; j++) {
                fireField[i][j] = 0;
            }
        }
        //System.out.println("Ai ships");
        //printArr(fireField);
    }
}
