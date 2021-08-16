/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package battleships;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
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
public class FireBattleFieldTest {

    public FireBattleFieldTest() {
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
     * Test of locateManager method, of class FireBattleField.
     */
    @Test
    public void testLocateManager() {
        System.out.println("locateManager");
        int x = 2;
        int y = 2;
        FireBattleField instance = new FireBattleField();
        
        //instance.locateManager(x, y);
       
    }

    /**
     * Test of mouseClicked method, of class FireBattleField.
     */
    @Test
    public void testMouseClicked() {
        System.out.println("mouseClicked");
        MouseEvent e = null;
        FireBattleField instance = new FireBattleField();
        //instance.mouseClicked(e);
        
    }

    /**
     * Test of getFire method, of class FireBattleField.
     */
    @Test
    public void testGetFire() {
        System.out.println("getFire");
        Object fire = null;
        FireBattleField instance = new FireBattleField();
        instance.getFire(fire);
        
    }

    /**
     * Test of mousePressed method, of class FireBattleField.
     */
    @Test
    public void testMousePressed() {
        System.out.println("mousePressed");
        MouseEvent e = null;
        FireBattleField instance = new FireBattleField();
        instance.mousePressed(e);
       
    }

    /**
     * Test of mouseReleased method, of class FireBattleField.
     */
    @Test
    public void testMouseReleased() {
        System.out.println("mouseReleased");
        MouseEvent e = null;
        FireBattleField instance = new FireBattleField();
        instance.mouseReleased(e);
       
    }

    /**
     * Test of mouseEntered method, of class FireBattleField.
     */
    @Test
    public void testMouseEntered() {
        System.out.println("mouseEntered");
        MouseEvent e = null;
        FireBattleField instance = new FireBattleField();
        //instance.mouseEntered(e);
        
    }

    /**
     * Test of mouseExited method, of class FireBattleField.
     */
    @Test
    public void testMouseExited() {
        System.out.println("mouseExited");
        MouseEvent e = null;
        FireBattleField instance = new FireBattleField();
        //instance.mouseExited(e);
       
    }

    /**
     * Test of keyTyped method, of class FireBattleField.
     */
    @Test
    public void testKeyTyped() {
        System.out.println("keyTyped");
        KeyEvent e = null;
        FireBattleField instance = new FireBattleField();
        instance.keyTyped(e);
       
    }

    /**
     * Test of keyPressed method, of class FireBattleField.
     */
    @Test
    public void testKeyPressed() {
        System.out.println("keyPressed");
        KeyEvent e = null;
        FireBattleField instance = new FireBattleField();
        instance.keyPressed(e);
        
    }

    /**
     * Test of keyReleased method, of class FireBattleField.
     */
    @Test
    public void testKeyReleased() {
        System.out.println("keyReleased");
        KeyEvent e = null;
        FireBattleField instance = new FireBattleField();
        instance.keyReleased(e);
        
    }

  

}