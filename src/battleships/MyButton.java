/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package battleships;

import javax.swing.JButton;

/**
 * Creatin the buton wich has coordinates as a parameters
 * @author Евгений
 */
public class MyButton extends JButton{
    private int x;
    private int y;

    MyButton(int x, int y){
        this.x=x;
        this.y=y;
    }

    /**
     * Return horizontal koordinates
     * @return
     */
    int getXCoordinate (){
        return x;
    }

    /**
     * Return vertical koordinates
     * @return
     */
    int getYCoordinate (){
        return y;
    }

}
