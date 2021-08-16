/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package battleships;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
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
public class BattleFieldTest {

    public BattleFieldTest() {
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


        int[][] matrix = new int[12][12];
        MyButton mbtn[][] = new MyButton[12][12];
        BattleField instance = new BattleField("BF", matrix, mbtn) {

        @Override
        public void locateManager(int x, int y) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mousePressed(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void keyTyped(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void keyPressed(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    };
    /**
     * Test of createField method, of class BattleField.
     */
    @Test
    public void testCreateField() {
        System.out.println("createField");       
        JPanel result = instance.createField();
        assertNotNull(result);        
    }

    /**
     * Test of resetField method, of class BattleField.
     */
    @Test
    public void testResetField() {
        System.out.println("resetField");        
        instance.resetField();
        
    }

    /**
     * Test of printField method, of class BattleField.
     */
    @Test
    public void testPrintField() {
        System.out.println("printField");        
        instance.printField();
        
    }

    /**
     * Test of block method, of class BattleField.
     */
    @Test
    public void testBlock() {
        System.out.println("block");
        //instance.block();
    }

    /**
     * Test of unblock method, of class BattleField.
     */
    @Test
    public void testUnblock() {
        System.out.println("unblock");        
        //instance.unblock();
       
    }

    /**
     * Test of locateManager method, of class BattleField.
     */
    @Test
    public void testLocateManager() {
        System.out.println("locateManager");
        int x = 0;
        int y = 0;       
        //instance.locateManager(x, y);
        
    }

    /**
     * Test of borderVertical method, of class BattleField.
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
        instance.borderVertical(x, y, decks, i, field, state);
        
    }

    /**
     * Test of borderHorizontal method, of class BattleField.
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
        instance.borderHorizontal(x, y, decks, i, field, state);
       
    }

    /**
     * Test of mouseClicked method, of class BattleField.
     */
    @Test
    public void testMouseClicked() {
        System.out.println("mouseClicked");
        MouseEvent e = null;       
        //instance.mouseClicked(e);
        
    }

    /**
     * Test of mousePressed method, of class BattleField.
     */
    @Test
    public void testMousePressed() {
        System.out.println("mousePressed");
        MouseEvent e = null;        
        //instance.mousePressed(e);
       
    }

    /**
     * Test of mouseReleased method, of class BattleField.
     */
    @Test
    public void testMouseReleased() {
        System.out.println("mouseReleased");
        MouseEvent e = null;        
        //instance.mouseReleased(e);
        
    }

    /**
     * Test of mouseEntered method, of class BattleField.
     */
    @Test
    public void testMouseEntered() {
        System.out.println("mouseEntered");
        MouseEvent e = null;        
        //instance.mouseEntered(e);
        
    }

    /**
     * Test of mouseExited method, of class BattleField.
     */
    @Test
    public void testMouseExited() {
        System.out.println("mouseExited");
        MouseEvent e = null;        
        //instance.mouseExited(e);
    }

    /**
     * Test of keyTyped method, of class BattleField.
     */
    @Test
    public void testKeyTyped() {
        System.out.println("keyTyped");
        KeyEvent e = null;        
        //instance.keyTyped(e);
    }

    /**
     * Test of keyPressed method, of class BattleField.
     */
    @Test
    public void testKeyPressed() {
        System.out.println("keyPressed");
        KeyEvent e = null;        
        //instance.keyPressed(e);
    }

    /**
     * Test of keyReleased method, of class BattleField.
     */
    @Test
    public void testKeyReleased() {
        System.out.println("keyReleased");
        KeyEvent e = null;        
        //instance.keyReleased(e);
    }

}