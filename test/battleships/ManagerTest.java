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
public class ManagerTest {

    

    public ManagerTest() {
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
     * Test of run method, of class Manager.
     */
    @Test
    public void run() {
        System.out.println("run method in Manager");            

    }


    @Test
    public void checkPlayerFields() {
        System.out.println("CheckPlayerField method in Manager");
        SetBattleField sbf = new SetBattleField();
        ShipsGenerator sg = new ShipsGenerator(SetBattleField.setField);
        FireBattleField fbf = new FireBattleField ();
        VirtualPlayer vp = new VirtualPlayer(sbf);

        Player plr_1 = new Player (sbf, fbf);
        Player plr_2 = new Player (vp);//virtual player

        Manager instance = new Manager (plr_1, plr_2,false);
        assertEquals (false, plr_1.isGameOver(1)==true);
        assertEquals(false, plr_2.isGameOver(2)==true);
        
        assertEquals(true, (plr_1.isGameOver(1)|plr_1.isGameOver(1))==false);
    }

}