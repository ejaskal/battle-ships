/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package battleships;

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
public class PlayerTest {

    public PlayerTest() {
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
     * Test of isGameOver method, of class Player.
     */
    @Test
    public void testIsGameOver() {
        System.out.println("isGameOver");
        int param = 1;
        SetBattleField sbf = new SetBattleField();
        FireBattleField fbf = new FireBattleField();
        Player human = new Player (sbf, fbf);
        boolean expResult = true;
        boolean result = human.isGameOver(param);
        assertEquals(expResult, result);
        
        param = 2;
        VirtualPlayer vp = new VirtualPlayer ();
        Player pcPlayer = new Player (vp);
        expResult = false;
        result = pcPlayer.isGameOver(param);
        assertEquals(expResult, result);

    }

     
    /**
     * Test of shoot method, of class Player.
     */
    
    @Test
    public void testShoot() {
        System.out.println("shoot");
        int i = 0;
        Object fire = new Object();
        VirtualPlayer vp = new VirtualPlayer ();
        Player pcPlayer = new Player (vp);
        //pcPlayer.shoot(i, fire);
        assertNotNull(fire);        
    }

}