/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import javax.swing.JOptionPane;

/**
 *  Class that regulate the order of firing between players. Realize several constructor
 *  which allow to play human vs. virtual player, human vs. human by net.
 *
 * @author Евгений
 */
public class Manager implements Runnable {

    Player player_1;
    Player player_2;
    final Object fire = new Object();
    boolean netGame = false;

    Manager(Player plr_1, Player plr_2, boolean netGame) {
        player_1 = plr_1;
        player_2 = plr_2;
        this.netGame = netGame;
    }


    /**
     * Method that run the instance of Manager class in it's own thread. This mothod
     * provide swiching parameters between player.
     */
    public void run() {
        if (netGame == true){
            playByNet();
        }else {
            playWithPC();
        }

       
    }


    /**
     * Check if the game should continue.
     *
     * @return boolean (true - continue game, false - game over).
     */
    private boolean checkPlayerFields() {
        if (player_1.isGameOver(1) == true | player_2.isGameOver(2) == true) {
            //System.out.println("Game over");
            return false;
        } else {
            return true;
        }
    }

    private void playByNet() {

    }

    private void playWithPC() {
         synchronized (fire) {
            try {
                boolean isPlaying = checkPlayerFields();
                fire.wait(500);
                the_end:
                while (isPlaying) {
                    boolean isShooting = true;
                    while (isShooting) {
                        //System.out.println("Player_1 started fire");
                        player_1.shoot(1, fire);
                        //System.out.println("Player_1 finished fire");
                        isShooting = player_1.getTarget;

                        isPlaying = checkPlayerFields();
                        if (isPlaying==false){
                            String s = "Congratulations you win!!!";
                            //GUI.showDialog(s);
                            System.out.println("Game over you win");
                            showDialog(s);
                            Thread.yield();
                            break the_end;
                        }
                    }

                    boolean isShooting_2 = true;
                    while (isShooting_2) {
                        //System.out.println("Player_2 started fire");
                        player_2.shoot(2, fire);
                        //System.out.println("Player_2 finished fire");
                        isShooting_2 = player_2.getTarget;
                         isPlaying = checkPlayerFields();
                        if (isPlaying==false){
                            String s = "You failed to achive the victory :(";
                            //GUI.showDialog(s);
                            System.out.println("Game over comp win");
                            showDialog(s);
                            Thread.yield();
                            break the_end;
                        }
                    }

                    //isPlaying = checkPlayerFields();
                }

            } catch (InterruptedException ex) {
                System.out.println("Interrupt exception in Manager run method " + ex);
            }
        }
    }


    private void showDialog(String s) {
        JOptionPane jop = new JOptionPane();
        jop.showMessageDialog(GUI.jfrm, s);
        jop.setValue(true);
        GUI.jfrm.repaint();
        GUI.playAgain.setEnabled(true);
    }
   
}
