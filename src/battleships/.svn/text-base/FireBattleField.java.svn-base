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
 *FireBattleField class extends BattleField class and provide funkctions for right
 * side of game fireField that responsible for connections between rivals battlefield.
 * This class responsible for checking position of opponents Ships and kontroling
 * if player hit the Ship, kill it or missed.
 * Used futher marking:
 *  0 - empty fireField;
 *  1 - Ship;
 *  2 - hit the ship;
 *  4 - Ships border;
 *  9 - missed.
 *
 */

public class FireBattleField extends BattleField{
    
    protected static int [][] fireField = new int [12][12];
    private static String name = "Plyer fire battlefield";
    protected static MyButton [][] fireButton = new MyButton[12][12];
    private int x;
    private int y;
    boolean getTarget;
    Object fire;

    FireBattleField (){
        super(name, fireField, fireButton);
    }
  

    /**
     * Realization of parent class locateManager. In this class used as manager
     * in case that opponent ship was destroyed, than called method that detect
     * ship's location and it's coordinates.
     *
     * @param x horizontal fired position;
     * @param y vertical fired position;
     */
    public void locateManager(int x, int y) {
        int position = definitePosition(x,y);
        System.out.println("position "+position);
        int firstX;
        int firstY;
        if (position==1){            
            firstY=y;
            firstX = firstX(x,y);            
        }else if (position==2){            
            firstX = x; 
            firstY=firstY(x,y);
        }else {            
            firstY = y;
            firstX = x;
        }        

        int decks = countDecks(firstX, firstY, position);        
        if (position==1||position==3){
            super.borderHorizontal(firstX,firstY, decks,-1,fireField,2);
            fillButtonBackground(firstX,firstY,position,decks);
        }else if (position==2){
            super.borderVertical(firstX,firstY,decks, -1, fireField, 2);
            fillButtonBackground(firstX,firstY,position,decks);            
        }
        

    }

    /**
     * Set destroyed ship's background.
     *
     * @param x horizontal extrem left coordinates of the destroyed ship;
     * @param y vertical extrem upper coordinates of the destroyed ship;
     * @param position vertical or horizontal;
     * @param decks number of ships deck's
     */
    private void fillButtonBackground(int x, int y, int position, int decks) {
        if (position == 1 || position == 3) {
            for (int i = 0; i < decks; i++) {
                fireButton[y][x + i].setBackground(Color.RED);
            }
        } else {
            for (int i = 0; i < decks; i++) {
                fireButton[y + i][x].setBackground(Color.RED);
            }
        }
    }




    /**
     * Method checks if oppenent's destroyed ship was horizontal or vertical
     * located.
     *
     * @param x - horizontal coordinates on the fireField;
     * @param y - vertikal coordinates on the fireField;
     */
    
    private int definitePosition(int x, int y) {
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

    private int firstX(int x, int y) {
        int tempX =x;        
        try{
            while(fireField[y][tempX]==2){
             tempX--;
        }
        }catch (java.lang.ArrayIndexOutOfBoundsException ex){
            System.out.println("find x out"+ex);

        }finally{            
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

    private int firstY(int x, int y) {
         int tempY =y;         
         try{
            while(fireField[tempY][x]==2){
                tempY--;
            }
         }catch (java.lang.ArrayIndexOutOfBoundsException ex){
             System.out.println("find y out"+ex);
         }finally{             
             return ++tempY;
         }
    }

    /**
     * The method counts the number of decks on the killed Ship
     *
     * @param x - first left x coordinate;
     * @param y - first upper y coordinate;
     * @param i - parameter that defenite posotion of the Ship (1 -> horizontal or 2 -> vertikal)
     * @return - number of decks
     */

    private int countDecks (int x, int y, int i){
        int decks = 0;
        int tempX = x;
        int tempY = y;
        if (i==1){
            try {
                while (fireField[y][tempX] == 2 ) {
                    tempX++;
                    decks++;
                }                
            }catch (java.lang.ArrayIndexOutOfBoundsException ex){
                System.out.println("decks count"+ex);
            }
        }else if (i==2){
            try{
                while (fireField[tempY][x] == 2) {
                    tempY++;
                    decks++;
                }                
            } catch (java.lang.ArrayIndexOutOfBoundsException ex){
                System.out.println("decks count"+ex);
            }

        }else{
            decks=1;
        }
        return decks++;
    }

    /**
     * Get coordinates of clicked button.
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        MyButton button = (MyButton) e.getSource();
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        x = button.getXCoordinate();
        y = button.getYCoordinate();

        analyzePosition(button);
        printField();        
    }

    protected void getFire (Object fire ){
        this.fire = fire;
    }
    
    /**
     * Analyze pressed coordinates with the opponent SetBattleField. If the player 
     * hit the ship indicate it on the GUI interfase with ORANGE color, if destroy - RED color, 
     * if missed GREY color.
     *  
     * @param button
     */
    private void analyzePosition(MyButton button){
        int rivalShip = VirtualPlayer.checkCoordinates(x,y);
        if(rivalShip==1){
            VirtualPlayer.changeField(x,y,2);
            boolean killed = VirtualPlayer.checkIfKilled(x,y);
            getTarget=true;
            if (killed==true){
                button.setBackground(Color.RED);
                fireField[y][x]=2;
                VirtualPlayer.changeField(x,y,2);
                locateManager(x, y);
                System.out.println("Player fire fireField");
                printField();

            }else {
                button.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                button.setBackground(Color.ORANGE);
                VirtualPlayer.changeField(x,y,2);                
            }
            fireField[y][x]=2;
                synchronized (fire) {
                fire.notify();
            }

        }else if (fireField[y][x]==2||fireField[y][x]==3||fireField[y][x]==4||fireField[y][x]==9){
            System.out.println("Aready been shoot");

        }else {
            button.setBackground(Color.gray);
            button.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
            fireField[y][x]=9;
            getTarget=false;

            synchronized (fire) {
                fire.notify();
            }
        }
        

    }
    


    /**
     * Futher two methods are not used in this class
     * @param e
     */

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    /**
     * Coordinates on which player has already shoot or the position is too close
     * for destroyed ship indicates with RED border, in other case GREEN border.
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        MyButton button = (MyButton) e.getSource();        
        x = button.getXCoordinate();
        y = button.getYCoordinate();
        if (fireField[y][x]==0){
            button.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
        }else {
            button.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        }
        
    }

    /**
     * Set default border after mouse left the button.
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {
        MyButton button = (MyButton) e.getSource();
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        x = button.getXCoordinate();
        y = button.getYCoordinate();
        
    }
    

    /**
     * KeyListener's are not uset at this class at all.
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {        
    }

    @Override
    public void keyPressed(KeyEvent e) {        
    }

    @Override
    public void keyReleased(KeyEvent e) {        
    }



}
