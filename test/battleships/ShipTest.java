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
public class ShipTest {

    public ShipTest() {
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
     * Test of getDecks method, of class Ship.
     */
    @Test
    public void testGetDecks() {
        System.out.println("Method getDecks");
        Ship instance = new Ship (2);
        int expResult = 2;
        int result = instance.getDecks();
        assertEquals(expResult, result);        
    }

    

}