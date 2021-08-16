/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package battleships;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

    /**
     * Method that build dialog frame, use only in case of net game. Provide possibility
     * of connecting to host or creating a host.
     *
     * @return JDialog
     */


public class Connect extends JDialog{

    JTextField jtxtf;
    JLabel lbl_1;
    JDialog dialog;

    JRadioButton crHost;
    JRadioButton joinHost;
    JButton ok;

    boolean server = true;
    Server host;
    Client client;


    Connect(){
        buildDialog();
    }

    /**
     * Build JDialog window
     *
     * @return JDialog
     */
    private JDialog buildDialog() {
        dialog = new JDialog(GUI.jfrm, true);
        final GridBagLayout gbl = new GridBagLayout();
        final GridBagConstraints gbc = new GridBagConstraints();
        dialog.setLayout(gbl);
        ButtonGroup group = new ButtonGroup();

        crHost = new JRadioButton("Create server");
        crHost.setSelected(true);
        GUI.buildConstraints(gbc, 1, 0, 2, 1, 1, 1, GridBagConstraints.NONE, GridBagConstraints.CENTER);
        gbl.setConstraints(crHost, gbc);
        dialog.add(crHost);

        joinHost = new JRadioButton("Join server");
        GUI.buildConstraints(gbc, 3, 0, 2, 1, 1, 1, GridBagConstraints.NONE, GridBagConstraints.CENTER);
        gbl.setConstraints(joinHost, gbc);
        dialog.add(joinHost);

        group.add(crHost);
        group.add(joinHost);

        lbl_1 = new JLabel("Enter host IP adress");
        GUI.buildConstraints(gbc, 1, 1, 2, 1, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER);
        gbl.setConstraints(lbl_1, gbc);
        lbl_1.setVisible(false);
        dialog.add(lbl_1);

        jtxtf = new JTextField();
        GUI.buildConstraints(gbc, 3, 1, 2, 1, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER);
        gbl.setConstraints(jtxtf, gbc);
        jtxtf.setVisible(false);
        dialog.add(jtxtf);

        ok = new JButton("Ok");
        GUI.buildConstraints(gbc, 2, 2, 1, 1, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER);
        gbl.setConstraints(ok, gbc);
        dialog.add(ok);

        addcrHostListener ();
        addJoinHostListener();
        addjtxtfListener();
        addOkListener();

        dialog.setBounds(150, 150, 250, 150);
        dialog.setVisible(true);

        return dialog;
    }


     /**
     * Add actionLisetner to joinHOst radio button, in this case text label for
     * inputting IP is showed
     *
     */
    private void addJoinHostListener() {
        joinHost.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jtxtf.setVisible(true);
                lbl_1.setVisible(true);
                ok.setEnabled(false);
                server = false;
                dialog.repaint();
            }
        });
    }

     /**
     * Add actionLisetner to ok button
     *      
     */
    private void addOkListener() {
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {                
                dialog.dispose();
            }
        });
    }

    /**
     * Add action listener to create host radio button
     */
    private void addcrHostListener() {
        crHost.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jtxtf.setVisible(false);
                lbl_1.setVisible(false);
                server = true;
                dialog.repaint();
            }
        });
    }


    private void addjtxtfListener() {
        jtxtf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ok.setEnabled(true);
            }
        });
    }


    /**
     *  Setting connection between two player
     *
     * @param p_1 (Player class) local PC player;
     * @param p_2 (Player class) remote player.
     */
    /*void setNetConnection(Player p_1, Player p_2) {
    if (server == true) {
    System.out.println("server");
    host = new Server();
    } else {
    System.out.println("client");
    String ipAdress = jtxtf.getText();
    client = new Client(ipAdress);
    System.out.println("" + ipAdress);
    }
    }*/


}
