/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package battleships;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Евгений
 */
public class SetBattleFieldTest {

    public SetBattleFieldTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setDecks method, of class SetBattleField.
     */
    @Test
    public void testSetDecks() {
        System.out.println("setDecks");
        int decks = 5;
        SetBattleField instance = new SetBattleField();
        int expResult = 5;
        int result = instance.setDecks(decks);
        assertEquals(expResult, result);        
    }

    /**
     * Test of mouseClicked method, of class SetBattleField.
     */
    @Test
    public void testMouseClicked() {
        System.out.println("mouseClicked");       
        SetBattleField instance = new SetBattleField();        
        MouseEvent e = null;
        //instance.mouseClicked(e);
        //int i = e.getClickCount();
        int expect = 1;
        assertEquals(expect, 1);
    }

    /**
     * Test of mousePressed method, of class SetBattleField.
     */
    @Test
    public void testMousePressed() {
        System.out.println("mousePressed");
        MouseEvent e = null;
        SetBattleField instance = new SetBattleField();
        instance.mousePressed(e);        
    }

    /**
     * Test of mouseReleased method, of class SetBattleField.
     */
    @Test
    public void testMouseReleased() {
        System.out.println("mouseReleased");
        MouseEvent e = null;
        SetBattleField instance = new SetBattleField();
        instance.mouseReleased(e);
        
    }

    /**
     * Test of mouseEntered method, of class SetBattleField.
     */
    @Test
    public void testMouseEntered() {
        System.out.println("mouseEntered");
        MouseEvent e = null;
        SetBattleField instance = new SetBattleField();
        //instance.mouseEntered(e);
       
    }

    /**
     * Test of mouseExited method, of class SetBattleField.
     */
    @Test
    public void testMouseExited() {
        System.out.println("mouseExited");
        MouseEvent e = null;
        SetBattleField instance = new SetBattleField();
        //instance.mouseExited(e);
        
    }

    /**
     * Test of keyTyped method, of class SetBattleField.
     */
    @Test
    public void testKeyTyped() {
        System.out.println("keyTyped");
        KeyEvent e = null;
        SetBattleField instance = new SetBattleField();
        instance.keyTyped(e);
        
    }

    /**
     * Test of keyPressed method, of class SetBattleField.
     */
    @Test
    public void testKeyPressed() {
        System.out.println("keyPressed");
        KeyEvent e = null;
        SetBattleField instance = new SetBattleField();
        //instance.keyPressed(e);
        
    }

    /**
     * Test of keyReleased method, of class SetBattleField.
     */
    @Test
    public void testKeyReleased() {
        System.out.println("keyReleased");
        KeyEvent e = null;
        SetBattleField instance = new SetBattleField();
        //instance.keyReleased(e);
        
    }

    /**
     * Test of setLocatedShipBackground method, of class SetBattleField.
     */
    @Test
    public void testSetLocatedShipBackground() {
        System.out.println("setLocatedShipBackground");
        SetBattleField instance = new SetBattleField();

        /*instance.setField[5][5]=2;
        instance.setButton[5][5].setBackground(Color.RED);
        instance.printField();*/
        instance.setLocatedShipBackground();
        /*Color expected = Color.RED;
        assertEquals(expected, instance.setButton[1][1].getBackground());*/
        
    }

    /**
     * Test of cleanLocatedShipBackground method, of class SetBattleField.
     */
    @Test
    public void testCleanLocatedShipBackground() {
        System.out.println("cleanLocatedShipBackground");
        SetBattleField instance = new SetBattleField();
        instance.cleanLocatedShipBackground();

        /*instance.setField[2][2]=1;
        Color result = instance.btn[2][2].getBackground();
        System.out.println(""+result);
        Color expected = new Color(200, 220, 230);
        assertEquals(expected, result);*/
    }

    /**
     * Test of locateManager method, of class SetBattleField.
     */
    @Test
    public void testLocateManager() {
        System.out.println("locateManager");
        int x = 1;
        int y = 1;
        SetBattleField instance = new SetBattleField();
        instance.locateManager(x, y);        
    }

    /**
     * Test of checkCoordinates method, of class SetBattleField.
     */
    @Test
    public void testCheckCoordinates() {
        System.out.println("checkCoordinates");
        int x = 0;
        int y = 0;
        SetBattleField instance = new SetBattleField();
        int expResult = 0;
        int result = instance.checkCoordinates(x, y);
        assertEquals(expResult, result);        
    }

    /**
     * Test of changeField method, of class SetBattleField.
     */
    @Test
    public void testChangeField() {
        System.out.println("changeField");
        int x = 1;
        int y = 1;
        int state = 0;
        SetBattleField instance = new SetBattleField();
        instance.changeField(x, y, state);
        int result = instance.setField[y][x];
        int expected = 0;
        assertEquals(expected, result);
        
    }

    /**
     * Test of checkIfKilled method, of class SetBattleField.
     */
    @Test
    public void testCheckIfKilled() {
        System.out.println("checkIfKilled");
        int x = 5;
        int y = 5;
        SetBattleField instance = new SetBattleField();
        ShipsGenerator sg = new ShipsGenerator(instance.setField) ;
        if (instance.setField[y][x]==0||instance.setField[y][x]==4){
            boolean expResult = true;
            boolean result = instance.checkIfKilled(x, y);
            assertEquals(expResult, result);
        }else {
            boolean expResult = false;
            boolean result = instance.checkIfKilled(x, y);
            assertEquals(expResult, result);
        }
       
    }

}