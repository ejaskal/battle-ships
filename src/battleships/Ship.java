package battleships;

/**
 * Class Ship is using for creating ships objects. The class will be using in two
 * stage:
 * 1. creating Objects on the GUI interface by implementing the class;
 * 2. setting the ship on the battlefield, by using ActionListener on the proper batleField class.
 *
 * The main parameters are:
 *
 * decks - the number of decks (In the game are using the following ships:
 * -> 4 decks x 1;
 * -> 3 decks x 2;
 * -> 2 decks x 3;
 * -> 1 decks x 4;)
 
 * direction - the matrix of directions in which the ship should be lockated, important
 * parameter for positioning ships on the battlefield. The meaninigs are following:
 * {1,0,0,0} - up;
 * {0,1,0,0} - right;
 * {0,0,1,0} - down;
 * {1,0,0,1} - left;
 *
 *
 * Has following mathods:
 * locateShip(int x, int y, int[]direction);
 * setBorder(int x, int y, int[] direction);
 * private int[][] borderVertical(int x, int y, int decks, int i, int[][] setBattleField)
 * private int[][] borderHorizontal(int x, int y, int decks, int i, int[][] setBattleField)
 */

public class Ship {
    private int decks;

    Ship(int decks){
       this.decks = decks;
       int [] ship = createShip(decks);
    }


    private int[] createShip(int decks) {
        int ship [] = new int [decks];
        for (int i = 0; i < decks; i++) {
            ship[i]=1;
        }
        return ship;
    }

    
    int getDecks(){
        return decks;
    }    

}
