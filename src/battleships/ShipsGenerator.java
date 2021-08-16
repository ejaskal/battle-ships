/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package battleships;

import java.util.Scanner;

/**
 * Class that introduce logic for automatic generating and setting ships, according
 * to the game rules. The class mainly used by Virtual player, but humanPlayer can
 * also use it by choosing "Generate Ships" mode.
 *
 * @author Евгений
 */
public class ShipsGenerator {
    int [][] virtualField;
    int x;
    int y;
    int[] directions = {0,0,0,0};
    int directionExact;
    Ship fourDeck;
    Ship threeDeck;
    Ship twoDeck;
    Ship oneDeck;



    ShipsGenerator(int [][]field){
        this.virtualField=field;
        //System.out.println("sbfField");
        //printArr(virtualField);

        createShips();
    }

    /**
     * Creates the ships according to the rules there shoul be:
     * 1 four decks ships, 2 three decks ships, 3 two decks ships and 4 one decks
     * ship
     *
     * @return int [][] (virtual batlefield)
     */
    private int[][] createShips() {
        fourDeck = new Ship(4);
        threeDeck = new Ship(3);
        twoDeck = new Ship(2);
        oneDeck = new Ship (1);
        setShip(fourDeck.getDecks(),1);
        setShip(threeDeck.getDecks(),2);
        setShip(twoDeck.getDecks(),3);
        setShip(oneDeck.getDecks(),4);
        //System.out.println("Automaticly generated ships");
        //printArr(virtualField);
        return virtualField;
    }

    
    
    /**
     * Quantify the number of created ships, and manage their location
     *
     * @param deck number of ship's decks
     * @param amount quantity of ships
     */
    private void setShip (int deck, int amount ){
        for (int i = 0; i < amount; i++) {

            setCoordinates(deck);
            analysePosition(deck);
            analyseDirections(deck);
            boolean validate = validateDirections();
            while (validate==false){
                setCoordinates(deck);
                analysePosition(deck);
                analyseDirections(deck);
                validate = validateDirections();
            }
            directionExact = chooseDirection();            
            locateShip(deck);            
            nullifyDirections();

        }
    }


    /**
     * Generetes random x,y coordinates
     * @param deck number of ship's decks
     */
    private void setCoordinates (int deck){
        x = generatePoint()+1;
        y = generatePoint()+1;

        while (virtualField[y][x]==4||virtualField[y][x]==1){
            x = generatePoint()+1;
            y = generatePoint()+1;
        }        
    }


    /**
     * Control if ship will be located inside the playing field
     * Directions matrix has next meanings:
     * [0] - up;
     * [1] - right;
     * [2] - down;
     * [3] - left.
     *
     * @param deck number ship's decks;
     */
   private void analysePosition (int deck){
       if (y-(deck-1)>=1){
           directions[0]=1;
       }if (y+(deck-1)<=10){
           directions[1]=1;
       }if (x+(deck-1)<=10){
           directions[2]=1;
       }if (x-(deck-1)>=1){
           directions[3]=1;
       }
   }


   /**
     * Control if chosen direction possible to use for ship's locating.
     *
     * @param x beginning horizontal coordinates;
     * @param y beginning vertical coordinates;
     * @param deck number ship's decks;
     * @param virtualField vertical set field;
     * @param direction matrix of possible ships location directions.
     * @return
     */
    private void analyseDirections(int deck){
        if (directions[0]==1){
            for (int i = 1; i < deck; i++) {
                if (virtualField[y-i][x]==1||virtualField[y-i][x]==4){
                    directions[0]=0;
                }
            }
        } if (directions[1]==1){
            for (int i = 1; i < deck; i++) {
                if (virtualField[y+i][x]==1||virtualField[y+i][x]==4){
                    directions[1]=0;
                }
            }
        }if (directions[2]==1){
            for (int i = 1; i < deck; i++) {
                if (virtualField[y][x+i]==1||virtualField[y][x+i]==4){
                    directions[2]=0;
                }
            }
        }if (directions[3]==1){
            for (int i = 1; i < deck; i++) {
                if (virtualField[y][x-i]==1||virtualField[y][x-i]==4){
                    directions[3]=0;
                }
            }
        }
    }


    /**
     * Call for random generator for choosing the direction of next shooot:
     * [0] shooting up;
     * [1] shooting right;
     * [2] shooting down;
     * [3] shooting left.
     *
     * @return int
     */
    private int chooseDirection(){
        int chooseDirection=generatePoint();        
        while (chooseDirection>3 ){
            chooseDirection = generatePoint();            
        }
        if (directions[chooseDirection]==1){
            return chooseDirection;
        }else return chooseDirection ();

    }


    /**
     * Navigate the process of ship's location on vitual field
     *
     * @param x beginning horizontal coordinates;
     * @param y beginning vertical coordinates;
     * @param virtualField vertical set field;
     * @param generateDestination
     * @param deck number ship's decks;
     * @return int[][] (virtualField)
     */
    private int[][]locateShip (int deck){

        if (directionExact==0){
            for (int i = 0; i < deck; i++) {
                virtualField[y-i][x]=1;

                virtualField[y-i][x-1]=4;
                virtualField[y-i][x+1]=4;
                if (i==0){
                    setBorderY(-deck, 1);
                }
            }
        }if (directionExact==1){
            for (int i = 0; i < deck; i++) {
                virtualField[y+i][x]=1;

                virtualField[y+i][x-1]=4;
                virtualField[y+i][x+1]=4;
                if (i==0){
                    setBorderY(deck, -1);
                }
            }
        }if (directionExact==2){
            for (int i = 0; i < deck; i++) {
                virtualField[y][x+i]=1;

                virtualField[y-1][x+i]=4;
                virtualField[y+1][x+i]=4;
                if (i==0){
                    setBorderX(deck, -1);
                }
            }
        }if (directionExact==3){
            for (int i = 0; i < deck; i++) {
                virtualField[y][x-i]=1;

                virtualField[y-1][x-i]=4;
                virtualField[y+1][x-i]=4;
                if (i==0){
                    setBorderX(-deck, 1);
                }
            }
        }
        return virtualField;
    }


    /**
     * Generating vertical border around setted ship.
     *
     * @param x beginning horizontal coordinates;
     * @param y beginning vertical coordinates;
     * @param virtualField vertical set field;
     * @param deck number ship's decks;
     * @param i additional parameter;
     * @return  int [][](virtualField)
     */
    private int[][] setBorderY(int deck, int i){
        virtualField[y+i][x]=4;
        virtualField[y+i][x-1]=4;
        virtualField[y+i][x+1]=4;
        virtualField[y+deck][x]=4;
        virtualField[y+deck][x-1]=4;
        virtualField[y+deck][x+1]=4;
        return virtualField;
    }


    /**
     * Generating horizontal border around setted ship.
     *
     * @param x beginning horizontal coordinates
     * @param y beginning vertical coordinates
     * @param virtualField vertical set field;
     * @param deck number ship's decks;
     * @param i additional parameter;
     * @return int [][](virtualField)
     */
    private int[][] setBorderX(int deck, int i){
        virtualField[y][x+i]=4;
        virtualField[y-1][x+i]=4;
        virtualField[y+1][x+i]=4;
        virtualField[y][x+deck]=4;
        virtualField[y-1][x+deck]=4;
        virtualField[y+1][x+deck]=4;
        return virtualField;
    }



    /**
    * Random coordinate generatior
    * @return
    */
    private int generatePoint(){
        double i = Math.random()*10;
        int rnd = (int)i;
        return rnd;
    }


    /**
     * Manual console coordinate setting (for debuging)
     * @return
     */
    private int generatePointMan(){
        return new Scanner (System.in).nextInt();
    }



    /**
     * Virtual virtualField console printing (for debuging)
     * @param arr
     */
    private static void printArr (int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                 System.out.print(" "+arr[i][j]);
            }
            System.out.println(" ");
       }
        System.out.println("");
    }

    /**
     * Nullify the directions matrix at the end of ships generating cycle
     */

    private void nullifyDirections() {
        for (int i = 0; i < 4; i++) {
            directions[i] = 0;
        }
    }


    /**
     * Help to avoid the possibilyty of situation when chosen are suitible, but
     * direction matrix = {0,0,0,0} which mean that ship will lbe located outside
     * the field.
     *
     * @return boolean, false - when matrix = {0,0,0,0}, and true in other case.
     */
    private boolean validateDirections() {
        int counter=0;
        for (int i = 0; i < 4; i++) {
            if (directions[i]!=0){
                counter ++;
            }
        }
        if (counter==0){
            return  false;
        }else return true;
    }


}
