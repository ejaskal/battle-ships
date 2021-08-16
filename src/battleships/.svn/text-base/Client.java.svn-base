/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package battleships;

import java.io.*;
import java.net.*;

/**
 * Implement networc interface for client
 *
 * @author Евгений
 */
public class Client {
    Socket socket;
    BufferedReader br;
    PrintWriter pw;
    String adress; //will be send from Connection dialog window, represent the IP adress of the server

    Client(String ip){
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


    private void recieveCoordinates () throws IOException{
        br = new BufferedReader (new InputStreamReader (socket.getInputStream()));
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
        pw = new PrintWriter (socket.getOutputStream(),true);
        String s = ""+x+";"+y;
        System.out.println("coordinates"+s);
        pw.println(s);
    }

}
