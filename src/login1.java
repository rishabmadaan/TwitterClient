
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import static java.lang.Thread.sleep;
import java.net.URISyntaxException;
import java.net.URL;
import javax.imageio.*;
import javax.swing.BorderFactory;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

public class login1 extends javax.swing.JFrame {

    ArrayList<user> userlist = new ArrayList<>();
    Twitter twitter = TwitterFactory.getSingleton();
    int r, g, b, r1, b1, g1;
    Color c, c1;
    BufferedImage img;

    public login1() {

        initComponents();
        Thread th = new Thread(new slide());
        th.start();
        isResizable();
        r = 29;
        g = 161;
        b = 242;
        c = new Color(r, g, b);
        r1 = 30;
        g1 = 21;
        b1 = 90;
        c1 = new Color(r1, g1, b1);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(size);
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\folder\\icn.png");
        setIconImage(icon);
        lb1.setForeground(c);
        bt1.setBackground(c);
        aclb1.setForeground(c);
        aclb2.setForeground(c);
        aclb3.setForeground(c);
        aclb4.setForeground(c);

        /*getContentPane().setBackground(new Color(135,206,250));*/
        getContentPane().setBackground(Color.white);

        twitter.setOAuthConsumer(keys.consumerKey, keys.consumersecret);
        Thread t1 = new Thread(new fetch());
        t1.start();

    }
    //user class for account management

    class user {

        int id;
        String userid, username, accesstoken, accesstokensecret;

        public user(int id, String username, String accesstoken, String accesstokensecret, String userid) {
            this.id = id;
            this.userid = userid;
            this.username = username;
            this.accesstoken = accesstoken;
            this.accesstokensecret = accesstokensecret;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jp4 = new javax.swing.JPanel();
        aclb4 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        jp1 = new javax.swing.JPanel();
        aclb1 = new javax.swing.JLabel();
        jp2 = new javax.swing.JPanel();
        aclb2 = new javax.swing.JLabel();
        jp3 = new javax.swing.JPanel();
        aclb3 = new javax.swing.JLabel();
        accountpanel = new javax.swing.JPanel();
        accountpanellb = new javax.swing.JLabel();
        pn = new javax.swing.JPanel();
        slb3 = new javax.swing.JLabel();
        slb = new javax.swing.JLabel();
        slb1 = new javax.swing.JLabel();
        slb2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        signlb = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bt1 = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
                jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
                jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
                jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
                jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 255));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jp4.setBackground(new java.awt.Color(255, 255, 255));
        jp4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp4MouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jp4MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jp4MouseExited(evt);
            }
        });

        aclb4.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        aclb4.setText("    Help");

        javax.swing.GroupLayout jp4Layout = new javax.swing.GroupLayout(jp4);
        jp4.setLayout(jp4Layout);
        jp4Layout.setHorizontalGroup(
                jp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jp4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(aclb4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(46, Short.MAX_VALUE))
        );
        jp4Layout.setVerticalGroup(
                jp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp4Layout.createSequentialGroup()
                                .addContainerGap(24, Short.MAX_VALUE)
                                .addComponent(aclb4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))
        );

        jPanel1.add(jp4);
        jp4.setBounds(1100, 10, 170, 80);

        lb1.setFont(new java.awt.Font("Swis721 Hv BT", 3, 55)); // NOI18N
        lb1.setForeground(new java.awt.Color(0, 204, 255));
        lb1.setText("Accounts");
        jPanel1.add(lb1);
        lb1.setBounds(10, 0, 330, 100);

        jp1.setBackground(new java.awt.Color(255, 255, 255));
        jp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp1MouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jp1MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jp1MouseExited(evt);
            }
        });

        aclb1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        aclb1.setText("  About");

        javax.swing.GroupLayout jp1Layout = new javax.swing.GroupLayout(jp1);
        jp1.setLayout(jp1Layout);
        jp1Layout.setHorizontalGroup(
                jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jp1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(aclb1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(28, Short.MAX_VALUE))
        );
        jp1Layout.setVerticalGroup(
                jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(aclb1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jPanel1.add(jp1);
        jp1.setBounds(400, 10, 190, 80);

        jp2.setBackground(new java.awt.Color(255, 255, 255));
        jp2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp2MouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jp2MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jp2MouseExited(evt);
            }
        });

        aclb2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        aclb2.setText("Terms");

        javax.swing.GroupLayout jp2Layout = new javax.swing.GroupLayout(jp2);
        jp2.setLayout(jp2Layout);
        jp2Layout.setHorizontalGroup(
                jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jp2Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(aclb2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(23, Short.MAX_VALUE))
        );
        jp2Layout.setVerticalGroup(
                jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jp2Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(aclb2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel1.add(jp2);
        jp2.setBounds(630, 10, 190, 80);

        jp3.setBackground(new java.awt.Color(255, 255, 255));
        jp3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp3MouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jp3MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jp3MouseExited(evt);
            }
        });

        aclb3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        aclb3.setText("Privacy policy");

        javax.swing.GroupLayout jp3Layout = new javax.swing.GroupLayout(jp3);
        jp3.setLayout(jp3Layout);
        jp3Layout.setHorizontalGroup(
                jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp3Layout.createSequentialGroup()
                                .addComponent(aclb3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jp3Layout.setVerticalGroup(
                jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jp3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(aclb3)
                                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel1.add(jp3);
        jp3.setBounds(850, 10, 200, 80);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 1600, 100);

        accountpanel.setBackground(new java.awt.Color(29, 161, 230));
        accountpanel.setOpaque(false);
        accountpanel.setLayout(null);
        getContentPane().add(accountpanel);
        accountpanel.setBounds(10, 200, 300, 800);

        accountpanellb.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        accountpanellb.setForeground(new java.awt.Color(29, 161, 242));
        accountpanellb.setText("Accounts you login previously....");
        getContentPane().add(accountpanellb);
        accountpanellb.setBounds(10, 120, 380, 36);

        pn.setFocusCycleRoot(true);
        pn.setLayout(null);

        slb3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/twtbg1.png"))); // NOI18N
        slb3.setText("slb1");
        pn.add(slb3);
        slb3.setBounds(210, 190, 90, 90);

        slb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/twtbg4.png"))); // NOI18N
        slb.setText("slb");
        pn.add(slb);
        slb.setBounds(100, 70, 70, 40);

        slb1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/t4.png"))); // NOI18N
        slb1.setText("slb2");
        pn.add(slb1);
        slb1.setBounds(24, 350, 120, 120);

        slb2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/t7.png"))); // NOI18N
        slb2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pn.add(slb2);
        slb2.setBounds(360, 60, 300, 240);

        getContentPane().add(pn);
        pn.setBounds(340, 160, 711, 561);

        jLabel3.setFont(new java.awt.Font("Swis721 BlkCn BT", 2, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(29, 161, 242));
        jLabel3.setText("account already exist?");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(1110, 520, 260, 80);

        signlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/signup.png"))); // NOI18N
        signlb.setText("jLabel2");
        signlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signlbMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signlbMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                signlbMouseExited(evt);
            }
        });
        getContentPane().add(signlb);
        signlb.setBounds(1140, 270, 160, 160);

        jLabel1.setFont(new java.awt.Font("Swis721 BlkCn BT", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(29, 161, 242));
        jLabel1.setText("New User? create account");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(1080, 200, 280, 50);

        jLabel2.setFont(new java.awt.Font("Swis721 BlkCn BT", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(29, 161, 242));
        jLabel2.setText("OR");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(1190, 440, 50, 80);

        bt1.setBackground(new java.awt.Color(30, 50, 150));
        bt1.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        bt1.setForeground(new java.awt.Color(255, 255, 255));
        bt1.setText("Log in");
        bt1.setOpaque(false);
        bt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt1MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt1MouseExited(evt);
            }
        });
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(1150, 620, 170, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents
//designing code

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        Thread t1 = new Thread(new bt1click());
        t1.start();
    }//GEN-LAST:event_bt1ActionPerformed

    private void jp2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp2MouseEntered
        Border br = BorderFactory.createLineBorder(c1, 2);
        jp2.setBorder(br);
        jp2.setBackground(c);
        aclb2.setForeground(Color.white);
        aclb2.setFont(new java.awt.Font("Tahoma", 3, 30));

    }//GEN-LAST:event_jp2MouseEntered

    private void jp2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp2MouseExited
        jp2.setBorder(null);
        jp2.setBackground(null);

        aclb2.setForeground(c);
        aclb2.setFont(new java.awt.Font("Tahoma", 3, 14));
    }//GEN-LAST:event_jp2MouseExited

    private void jp4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp4MouseEntered
        Border br = BorderFactory.createLineBorder(c1, 2);
        jp4.setBorder(br);

        jp4.setBackground(c);
        aclb4.setForeground(Color.white);
        aclb4.setFont(new java.awt.Font("Tahoma", 3, 30));

    }//GEN-LAST:event_jp4MouseEntered

    private void jp4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp4MouseExited
        jp4.setBorder(null);
        jp4.setBackground(null);
        aclb4.setForeground(c);
        aclb4.setFont(new java.awt.Font("Tahoma", 3, 14));
    }//GEN-LAST:event_jp4MouseExited

    private void jp1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp1MouseEntered
        Border br = BorderFactory.createLineBorder(c1, 2);
        jp1.setBorder(br);

        jp1.setBackground(c);
        aclb1.setForeground(Color.white);
        aclb1.setFont(new java.awt.Font("Tahoma", 3, 30));

    }//GEN-LAST:event_jp1MouseEntered

    private void jp1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp1MouseExited
        jp1.setBorder(null);
        jp1.setBackground(null);
        aclb1.setForeground(c);
        aclb1.setFont(new java.awt.Font("Tahoma", 3, 14));
    }//GEN-LAST:event_jp1MouseExited

    private void jp3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp3MouseEntered
        Border br = BorderFactory.createLineBorder(c1, 2);
        jp3.setBorder(br);

        jp3.setBackground(c);
        aclb3.setForeground(Color.white);
        aclb3.setFont(new java.awt.Font("Tahoma", 3, 28));

    }//GEN-LAST:event_jp3MouseEntered

    private void jp3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp3MouseExited
        jp3.setBorder(null);
        jp3.setBackground(null);
        aclb3.setForeground(c);
        aclb3.setFont(new java.awt.Font("Tahoma", 3, 14));
    }//GEN-LAST:event_jp3MouseExited

    private void jp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp1MouseClicked
        String s = "https://about.twitter.com/";
        try {
            Desktop.getDesktop().browse(new URI(s));
        } catch (Exception ex) {
            Logger.getLogger(login1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jp1MouseClicked

    private void jp2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp2MouseClicked
        String s = "https://twitter.com/en/tos";
        try {
            Desktop.getDesktop().browse(new URI(s));
        } catch (Exception ex) {
            Logger.getLogger(login1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jp2MouseClicked

    private void jp3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp3MouseClicked
        String s = "https://twitter.com/en/privacy";
        try {
            Desktop.getDesktop().browse(new URI(s));
        } catch (Exception ex) {
            Logger.getLogger(login1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jp3MouseClicked

    private void jp4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp4MouseClicked
        String s = "https://help.twitter.com/";
        try {
            Desktop.getDesktop().browse(new URI(s));
        } catch (Exception ex) {
            Logger.getLogger(login1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jp4MouseClicked

    private void signlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signlbMouseClicked
        String h = "https://twitter.com/i/flow/signup";
        try {
            Desktop.getDesktop().browse(new URI(h));

        } catch (Exception e) {
        }

    }//GEN-LAST:event_signlbMouseClicked

    private void signlbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signlbMouseEntered
        Border br = BorderFactory.createLineBorder(new Color(30, 21, 90), 6);
        signlb.setBorder(br);
    }//GEN-LAST:event_signlbMouseEntered

    private void signlbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signlbMouseExited
        signlb.setBorder(null);
    }//GEN-LAST:event_signlbMouseExited

    private void bt1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt1MouseEntered

        bt1.setBackground(new Color(30, 21, 90));
    }//GEN-LAST:event_bt1MouseEntered

    private void bt1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt1MouseExited
        bt1.setBackground(c);
    }//GEN-LAST:event_bt1MouseExited

//fetch information on screen logic///////////////////////////
    class fetch implements Runnable {

        @Override
        public void run() {
            userlist.clear();
            accountpanel.removeAll();
            accountpanel.repaint();
            ResultSet rs = dbconn.executeQuery("select * from accounts ");
            try {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String username = rs.getString("username");
                    String accesstoken = rs.getString("accesstoken");
                    String accesstokensecret = rs.getString("accesstokensecret");
                    String userid = rs.getString("userid");
                    user obj = new user(id, username, accesstoken, accesstokensecret, userid);
                    userlist.add(obj);
                }
                int size = userlist.size();
                for (int i = 0; i < size; i++) {
                    loginpanel lp = new loginpanel();
                    lp.setBounds(10, 10 + (70 * i), 270, 55);
                    user obj = userlist.get(i);
                    lp.loginpanelbt.setText("@" + obj.username);
                    accountpanel.repaint();
                    accountpanel.add(lp);
                    lp.loginpanelbt.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            twitter.setOAuthAccessToken(new AccessToken(obj.accesstoken, obj.accesstokensecret));
                            new home(twitter).setVisible(true);

                        }
                    });
                    lp.loginpanelclose.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            ResultSet rs = dbconn.executeQuery("select * from accounts where id=" + obj.id);
                            accountpanel.remove(lp);
                            try {
                                rs.next();

                                rs.deleteRow();
                                accountpanel.repaint();
                                new Thread(new fetch()).start();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            System.out.println("row deleted");
                        }

                    });
                }

            } catch (SQLException e) {
            }

        }

    }
///login screen(pin entering screen) button click logic

    class bt1click implements Runnable {

        @Override
        public void run() {

            RequestToken rt;
            try {

                rt = twitter.getOAuthRequestToken();
                String s = rt.getAuthenticationURL();
                System.out.println(s);

                Desktop.getDesktop().browse(new URI(s));
                logindialog dialog = new logindialog(new java.awt.Frame(), true);
                dialog.setLocationRelativeTo(null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {

                        System.exit(0);
                    }

                });

                dialog.bt.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {

                        String pin = dialog.jt.getText();
                        if (pin.equals("")) {
                            JOptionPane.showMessageDialog(rootPane, "please enter the pin");

                        } else {
                            try {
                                AccessToken at = twitter.getOAuthAccessToken(rt, pin);
                                ///calling dbconn class
                                ResultSet rs = dbconn.executeQuery("select * from accounts where userid='" + at.getUserId() + "'");

                                if (rs.next()) {
                                    JOptionPane.showMessageDialog(dialog, "Already exist");
                                } else {
                                    rs.moveToInsertRow();
                                    rs.updateString("username", at.getScreenName());
                                    rs.updateString("accesstoken", at.getToken());
                                    rs.updateString("accesstokensecret", at.getTokenSecret());
                                    rs.updateString("userid", at.getUserId() + "");
                                    rs.insertRow();
                                    JOptionPane.showMessageDialog(login1.this, "inserted");
                                    dialog.dispose();
                                    new Thread(new fetch()).start();
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                dialog.setVisible(true);

            } catch (Exception e) {
                System.out.println("error occured");
                e.printStackTrace();
            }
        }

    }

    public static void main(String args[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException, UnsupportedLookAndFeelException {
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
            java.util.logging.Logger.getLogger(login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        ///// UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accountpanel;
    private javax.swing.JLabel accountpanellb;
    private javax.swing.JLabel aclb1;
    private javax.swing.JLabel aclb2;
    private javax.swing.JLabel aclb3;
    private javax.swing.JLabel aclb4;
    public javax.swing.JButton bt1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jp1;
    private javax.swing.JPanel jp2;
    private javax.swing.JPanel jp3;
    private javax.swing.JPanel jp4;
    private javax.swing.JLabel lb1;
    private javax.swing.JPanel pn;
    private javax.swing.JLabel signlb;
    private javax.swing.JLabel slb;
    private javax.swing.JLabel slb1;
    private javax.swing.JLabel slb2;
    private javax.swing.JLabel slb3;

    // End of variables declaration//GEN-END:variables
//////////////////////////////////slide show/////////////////////////////////
    class slide implements Runnable {

        @Override
        public void run() {

            slb.setBounds(0, 0, pn.getWidth(), pn.getHeight());
            slb3.setBounds(0 - pn.getWidth(), 0, pn.getWidth(), pn.getHeight());
            slb1.setBounds(0 - pn.getWidth(), 0, pn.getWidth(), pn.getHeight());
            while (true) {
                for (int j = 0; j <= pn.getWidth(); j++) {
                    slb.setBounds(j, 0, pn.getWidth(), pn.getHeight());
                    slb3.setBounds(j - pn.getWidth(), 0, pn.getWidth(), pn.getHeight());
                    try {
                        sleep(1);
                    } catch (Exception ex) {
                    }

                    if (j == 0) {
                        try {
                            sleep(2000);
                        } catch (InterruptedException ex) {
                        }

                    }
                }

                ////////////////////////////slb1///////////////////////
                for (int j = 0; j <= pn.getWidth(); j++) {
                    slb3.setBounds(j, 0, pn.getWidth(), pn.getHeight());
                    slb1.setBounds(j - pn.getWidth(), 0, pn.getWidth(), pn.getHeight());
                    try {
                        sleep(1);
                    } catch (Exception ex) {
                    }

                    if (j == 0) {
                        try {
                            sleep(2000);
                        } catch (InterruptedException ex) {
                        }

                    }

                }

                ////////////////////////////slb2//////////////////////
                for (int j = 0; j <= pn.getWidth(); j++) {
                    slb1.setBounds(j, 0, pn.getWidth(), pn.getHeight());
                    slb2.setBounds(j - pn.getWidth(), 0, pn.getWidth(), pn.getHeight());
                    try {
                        sleep(1);
                    } catch (Exception ex) {
                    }
                    if (j == 0) {
                        try {
                            sleep(2000);
                        } catch (Exception ex) {
                        }
                    }
                }
                //////////////////////////////////////slb3///////////////////////////////////////////
                for (int j = 0; j <= pn.getWidth(); j++) {
                    slb2.setBounds(j, 0, pn.getWidth(), pn.getHeight());
                    slb.setBounds(j - pn.getWidth(), 0, pn.getWidth(), pn.getHeight());
                    try {
                        sleep(1);
                    } catch (Exception ex) {
                    }
                    if (j == 0) {
                        try {
                            sleep(2000);
                        } catch (Exception ex) {
                        }
                    }
                }

            }
        }

    }
}
