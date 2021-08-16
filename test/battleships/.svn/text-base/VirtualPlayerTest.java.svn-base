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
public class VirtualPlayerTest {

    public VirtualPlayerTest() {
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
     * Test of fireManager method, of class VirtualPlayer.
     */
    @Test
    public void testFireManager() {
        System.out.println("fireManager");
        SetBattleField sbf = new SetBattleField();
        VirtualPlayer vp = new VirtualPlayer(sbf);
        vp.fireManager();

    }

    

    /**
     * Test of borderVertical method, of class VirtualPlayer.
     */
    @Test
    public void testBorderVertical() {
        System.out.println("borderVertical");
        int x = 0;
        int y = 0;
        int decks = 0;
        int i = 0;
        int[][] field = null;
        int state = 0;
        VirtualPlayer vp = new VirtualPlayer();
        vp.borderVertical(x, y, decks, i, field, state);
    }

    /**
     * Test of borderHorizontal method, of class VirtualPlayer.
     */
    @Test
    public void testBorderHorizontal() {
        System.out.println("borderHorizontal");
        int x = 0;
        int y = 0;
        int decks = 0;
        int i = 0;
        int[][] field = null;
        int state = 0;
        VirtualPlayer vp = new VirtualPlayer();
        vp.borderHorizontal(x, y, decks, i, field, state);
    }

    /**
     * Test of checkCoordinates method, of class VirtualPlayer.
     */
    @Test
    public void testCheckCoordinates() {
        System.out.println("checkCoordinates");
        int x = 0;
        int y = 0;
        int expResult = 0;
        int result = 0;//VirtualPlayer.checkCoordinates(x, y);
        assertEquals(expResult, result);       
    }

    /**
     * Test of changeField method, of class VirtualPlayer.
     */
    @Test
    public void testChangeField() {
        System.out.println("changeField");
        int[][] arr = new int[12][12];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = 1;
            }
        }
        int x = 3;
        int y = 3;
        int state = 2;
        VirtualPlayer.setField = arr;
        VirtualPlayer.changeField(x, y, state);
        int result = VirtualPlayer.setField[3][3];        
        int expected = 2;
        assertEquals(expected, result);
    }

    /**
     * Test of checkIfKilled method, of class VirtualPlayer.
     */

    @Test
    public void testCheckIfKilled() {
        System.out.println("checkIfKilled");
        int[][] arr = new int[12][12];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == 3 | j == 3 | i == 6 | j == 5) {
                    arr[i][j] = 4;
                } else {
                    arr[i][j] = 1;
                }
            }
        }
        System.out.println("Test Matrix");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(" " + arr[i][j]);
            }
            System.out.println(" ");
        }
        int x = 4;
        int y = 4;
        VirtualPlayer.setField = arr;
        boolean expResult = false;
        boolean result = VirtualPlayer.checkIfKilled(x, y);
        assertEquals(expResult, result);
    }

    
    /**
     * Test of resetField method, of class VirtualPlayer.
     */
    @Test
    public void testResetField() {
        System.out.println("resetField");
        VirtualPlayer vp = new VirtualPlayer();
        vp.resetField();
        int [][] expecteds = new int [12][12];
        for (int  i = 0;  i < expecteds.length;  i++) {
            for (int j = 0; j < expecteds.length; j++) {
                expecteds[i][j]=0;
            }
        }
        assertArrayEquals(expecteds, VirtualPlayer.setField);
    }

    /**
     * Test of resetFireField method, of class VirtualPlayer.
     */
    @Test
    public void testResetFireField() {
        SetBattleField sbf = new SetBattleField();
        VirtualPlayer vp = new VirtualPlayer(sbf);
        vp.resetField();
        int [][] expecteds = new int [12][12];
        for (int  i = 0;  i < expecteds.length;  i++) {
            for (int j = 0; j < expecteds.length; j++) {
                expecteds[i][j]=0;
            }
        }
        assertArrayEquals(expecteds, vp.fireField);        
    }
     
}