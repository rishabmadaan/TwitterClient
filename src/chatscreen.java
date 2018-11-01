
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import twitter4j.DirectMessage;
import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.api.DirectMessagesResources;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PARAM
 */
public class chatscreen extends javax.swing.JFrame {
    
    
    
    Twitter twitter;
    long id;
    ArrayList<DirectMessage> al;

    
    
    public chatscreen(Twitter twitter, long id) throws TwitterException {
        initComponents();
        
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
getContentPane().setBackground(Color.white);
        this.twitter = twitter;
        this.id = id;
      
            Image icon=Toolkit.getDefaultToolkit().getImage("src\\folder\\icn.png");
setIconImage(icon);
        User u = twitter.showUser(id);
             new Thread (new fetchmessages()).start();
                    
        
    }
//////////////////////////////////////////////////////////fetch meessages////////////////////////////////////
      class fetchmessages implements Runnable {
        
        @Override
        public void run() {
        
                
                     al = new ArrayList<>();
            DirectMessagesResources dmr = twitter.directMessages();
           /*Hashset<Long> hset = new HashSet<Long>();*/
            try {
                ResponseList<DirectMessage> recievelist = dmr.getDirectMessages();
                for (DirectMessage d : recievelist) {
                    if (d.getSenderId() == id) {
                        al.add(d);
              
                    }
                }
                ResponseList<DirectMessage> sentlist = dmr.getSentDirectMessages();
                for (DirectMessage d : sentlist) {
                    if (d.getRecipientId() == id) {
                        al.add(d);
                    }
                }
                         int size = al.size();
                       
               
              Collections.sort(al, new Comparator<DirectMessage>() {
                    @Override
                    public int compare(DirectMessage t, DirectMessage t1) {
                        return t.getCreatedAt().compareTo(t1.getCreatedAt());
                   
                    }

                });
                String s = "";
                for (DirectMessage d : al) {
                    if (d.getSenderId() == twitter.getId()) {
                        s += "<h2 color=white bgcolor=rgb(29,161,242)>" + d.getText() + "</h2>";

                    } else {
                        s += "<h2 align=right color=black bgcolor=rgb(230,236,240)>" + d.getText() + "</h2>";
                    }
                  
                   chatsc.setContentType("text/html");
                  chatsc.setText(s);
                }
          
           
                /*  int size = al.size();
                    DirectMessage lastms = al.get(size-1);
                    Date lastdt = lastms.getCreatedAt();
                    System.out.println(lastdt);*/
                 
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
        }
    }
      
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        line = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatsc = new javax.swing.JEditorPane();
        cslb = new javax.swing.JLabel();
        csname = new javax.swing.JLabel();
        csscreennm = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        chattype = new javax.swing.JTextArea();
        sendbt = new javax.swing.JButton();
        reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(null);

        line.setBackground(new java.awt.Color(204, 204, 204));
        line.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(line);
        line.setBounds(0, 120, 1920, 1);

        chatsc.setEditable(false);
        jScrollPane1.setViewportView(chatsc);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(300, 120, 750, 560);
        getContentPane().add(cslb);
        cslb.setBounds(510, 10, 100, 100);

        csname.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        getContentPane().add(csname);
        csname.setBounds(620, 20, 200, 30);

        csscreennm.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        csscreennm.setForeground(new java.awt.Color(102, 102, 102));
        getContentPane().add(csscreennm);
        csscreennm.setBounds(620, 50, 200, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/close3.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(1240, 20, 90, 80);

        jPanel1.setBackground(new java.awt.Color(204, 240, 255));
        jPanel1.setLayout(null);

        chattype.setColumns(20);
        chattype.setRows(5);
        jScrollPane2.setViewportView(chattype);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(310, 10, 730, 50);

        sendbt.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        sendbt.setText("Send");
        sendbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendbtActionPerformed(evt);
            }
        });
        jPanel1.add(sendbt);
        sendbt.setBounds(1080, 20, 130, 50);

        reset.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        reset.setText("Refresh");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel1.add(reset);
        reset.setBounds(1240, 20, 110, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 680, 1366, 90);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
    new Thread(new fetchmessages()).start();
    }//GEN-LAST:event_resetActionPerformed

    private void sendbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendbtActionPerformed
     String msg = chattype.getText();
        if (msg.equals("")) {
            System.out.println("enter message");
        } else {
            try {
                twitter.sendDirectMessage(id, msg);
                new Thread(new fetchmessages()).start();
              chattype.setText("");
            } catch (TwitterException ex) {
                Logger.getLogger(chatscreen.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_sendbtActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
     dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(chatscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chatscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chatscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chatscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
        
    }});
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JEditorPane chatsc;
    public javax.swing.JTextArea chattype;
    public javax.swing.JLabel cslb;
    public javax.swing.JLabel csname;
    public javax.swing.JLabel csscreennm;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel line;
    public javax.swing.JButton reset;
    public javax.swing.JButton sendbt;
    // End of variables declaration//GEN-END:variables
        
                }