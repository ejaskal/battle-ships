/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package battleships;

import java.io.*;
import java.net.*;

/**
 *Implement network interface for server
 *
 * @author Евгений
 */
public class Server extends Thread{


    ServerSocket srvSock;
    Socket connection;
    BufferedReader br;
    PrintWriter pw;
    SetBattleField setField;
    FireBattleField fireField;
    Player player_1;

    Server (SetBattleField sbf,  FireBattleField fbf){
        setField = sbf;
        fireField = fbf;
        this.start();
    }

    public void run(){
        createSocket();
    }
    private void createSocket() {
         try {
             while (true){
                 srvSock = new ServerSocket(5555);
                 connection = srvSock.accept();
                 player_1 = new Player (setField, fireField, connection);
                 System.out.println("Connection recieved");
             }
        }catch(IOException e) {
            e.printStackTrace();
        }
    }



     private void recieveCoordinates () throws IOException{
        br = new BufferedReader (new InputStreamReader (connection.getInputStream()));
        char[] stringArray = br.readLine().toCharArray();
        String s1 = "";
        String s2 = "";
        char c;
        int i = 0;
        for (int index = 0; index < stringArray.length; index++) {
            if (stringArray[index] == ';') {
                System.out.println("Catch the ';'");
                i = 2;
            }else {
                if (i==0){
                   c = stringArray[index];
                   s1+= Character.toString(c);
                   System.out.println("S1 = "+s1);
                }else {
                   c = stringArray[index];
                   s2+= Character.toString(c);
                   System.out.println("S2 = "+s2);
                }
            }
        }
        int x = Integer.parseInt(s1);
        int y = Integer.parseInt(s2);
    }

    private void sendCoordinate(int x, int y) throws IOException{
        pw = new PrintWriter (connection.getOutputStream(),true);
        String s = ""+x+";"+y;
        System.out.println("coordinates"+s);
        pw.println(s);
    }




}
