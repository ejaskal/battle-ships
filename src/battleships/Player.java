/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package battleships;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that create player
 *
 * @author Евгений
 */
public class Player extends Thread{

    Socket socket;
    BufferedReader br;
    PrintWriter pw;
    String adress;

    VirtualPlayer virtualPlayer;
    Socket s;

    int [][]setSide;
    int [][]fireSide;

    SetBattleField setBF;
    FireBattleField fireBF;

    boolean getTarget;


    Player() {
    }

    /*Player (Socket s){
    this.s = s;
    this.start();
    }*/

    Player(VirtualPlayer vp) {
        virtualPlayer = vp;
        setSide = vp.setField;
        fireSide = vp.setField;
    }

    Player(SetBattleField sbf, FireBattleField fbf) {
        setBF = sbf;
        fireBF = fbf;
    }

    Player(SetBattleField sbf, FireBattleField fbf, Socket connection) {
        setBF = sbf;
        fireBF = fbf;
        s = connection;
        this.start();
    }


    Player (SetBattleField sbf, FireBattleField fbf, String ip){
        adress = ip;
        createSocket();
    }


    private void createSocket() {
        try{
            socket = new Socket(adress, 5555);
        }catch (UnknownHostException e){
            System.out.println("Unknown host: localhost");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("No I/O");
            System.exit(1);
        }
    }


    /**
     *
     * @param param - the number of player (1 usually human if game against PC, if net game, than
     * 1st is player that is server).
     *
     * @return boolean (true - if game is over, false if not).
     */
    protected boolean isGameOver(int param) {
        int counter = 0;
        if (param == 1) {
            for (int i = 0; i < setBF.setField.length; i++) {
                for (int j = 0; j < setBF.setField.length; j++) {
                    if (setBF.setField[i][j] == 1) {
                        counter++;
                    }
                }
            }

            if (counter == 0) {
                return true;
            } else {
                return false;
            }

        } else {
            for (int i = 0; i < setSide.length; i++) {
                for (int j = 0; j < setSide.length; j++) {
                    if (setSide[i][j] == 1) {
                        counter++;
                    }
                }
            }
            if (counter == 0) {
                return true;
            } else {
                return false;
            }
        }
    }


    /*public void run() {
    System.out.println("firing");
    }*/

    /**
     *  Unblock fireField panel if human, or call fireManager in VirtualPlayer class.
     *
     * @param i - number of player (1 usually human if game against PC, if net game, than
     * 1st is player that is server).
     *
     * @param fire - object that used like lock for synchronize access to thread
     */
    void shoot(int i, Object fire)  {
        synchronized(fire){
            try{
                 if (i==1){
                    fireBF.unblock();
                    fireBF.getFire(fire);
                    fire.wait();//add condition for Mouse Listener Action, might wait till player click
                    GUI.jfrm.repaint();
                    fireBF.block();
                    if (fireBF.getTarget==true){
                        getTarget=true;
                    }else getTarget = false;

                } else {
                     virtualPlayer.fireManager();                     
                     GUI.jfrm.repaint();
                     if (virtualPlayer.getTarget==true){
                         getTarget = true;
                     }else getTarget = false;
                }
            }catch (InterruptedException ex){
                System.out.println("Player_"+i+" "+ex+" exception");
            }
            fire.notify();
            //System.out.println("Notifyed fire from player_"+i);
        }
    }


}
