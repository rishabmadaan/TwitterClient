
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import twitter4j.Twitter;
import twitter4j.User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import twitter4j.GeoLocation;
import twitter4j.IDs;
import twitter4j.Relationship;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.TwitterException;
import javax.swing.undo.UndoManager;
import twitter4j.DirectMessage;
import twitter4j.Location;
import twitter4j.MediaEntity;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.api.DirectMessagesResources;
import twitter4j.api.TrendsResources;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PARAM
 */
public class home extends javax.swing.JFrame {

    Twitter twitter;
    BufferedImage b;
    File f, f1;
    User u;
    int usernm;
    int scrnm;

    ArrayList<Integer> flagal = new ArrayList<>();
    ArrayList<Integer> flagal1 = new ArrayList<>();
    ArrayList<locationadapter> al = new ArrayList<>();
    ArrayList<Followers> alf = new ArrayList<>();
    ArrayList<DirectMessage> al1;
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

    Icon icn1 = new ImageIcon("src\\folder\\n3.png");
    String ic1 = icn1.toString();
    Icon icn2 = new ImageIcon("src\\folder\\n5.png");
    String ic2 = icn2.toString();
    Icon icn3 = new ImageIcon("src\\folder\\n6.png");
    String ic3 = icn3.toString();
    ImageIcon twtr = new ImageIcon("src\\folder\\twitmain.png");
    ImageIcon loader = new ImageIcon("src\\folder\\l3.gif");
    ImageIcon upld = new ImageIcon("src\\folder\\l6.gif");

    public home(Twitter twitter) {
        this.twitter = twitter;
        initComponents();
        //////////////////changed///////////////////////////////////////////
        home1lb.setVisible(false);
        home2lb.setVisible(false);
        setSize(1366, 768);
        sidepanel.setEnabled(false);

        getContentPane().setBackground(new Color(255, 255, 255));
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\folder\\icn.png");
        setIconImage(icon);
///displaypanel.setSize(size.width-310,size.height-120);
        displaypanel.setSize(1056, 650);
        getContentPane().setBackground(new Color(230, 236, 240));
        uploadbt.setBackground(new Color(29, 161, 242));
        sidepanel.setSize(300, size.height);
        highpanel.setSize(size.width, 100);
        Thread t1 = new Thread(new homedatafetch());
        t1.start();
        Thread al = new Thread(new alerts());
        al.start();
        Thread t5 = new Thread(new userhome());
        t5.start();

    }

    BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height,
                BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

    class homedatafetch implements Runnable {

        @Override
        public void run() {

            try {
                u = twitter.verifyCredentials();
                homelb1.setText(" " + u.getName());
                homelb2.setText(" @" + u.getScreenName());
                followercount.setText(u.getFollowersCount() + "");
                followingcount.setText(u.getFriendsCount() + "");
                tweetcount.setText(u.getStatusesCount() + "");

                String s = u.getOriginalProfileImageURL();
                b = ImageIO.read(new URL(s));
                BufferedImage resizepic = resize(b, profilelb.getWidth(), profilelb.getHeight());
                profilelb.setIcon(new ImageIcon(resizepic));
                BufferedImage resizepicc = resize(b, searchlb.getWidth(), searchlb.getHeight());
                searchlb.setIcon(new ImageIcon(resizepicc));
                String s2 = u.getProfileBannerURL();
                if (s2 != null) {

                    BufferedImage bi1 = ImageIO.read(new URL(s2));
                    BufferedImage resizepic1 = resize(bi1, headerlb.getWidth(), headerlb.getHeight());
                    headerlb.setIcon(new ImageIcon(resizepic1));
                } else {
                    headerpanel.setBackground(new Color(29, 161, 242));
                }
                toppanel.repaint();
                String usrnm1 = u.getName();
                usernm = usrnm1.length();
                String scrnm1 = u.getScreenName();
                scrnm = scrnm1.length();
                home1lb.setSize(usernm * 11, 2);
                home2lb.setSize(scrnm * 9, 2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toppanel = new javax.swing.JPanel();
        homelb1 = new javax.swing.JLabel();
        homelb2 = new javax.swing.JLabel();
        profilelb = new javax.swing.JLabel();
        uploadbt = new javax.swing.JButton();
        tweetlb = new javax.swing.JLabel();
        followerlb = new javax.swing.JLabel();
        folllowinglb = new javax.swing.JLabel();
        tweetcount = new javax.swing.JLabel();
        followercount = new javax.swing.JLabel();
        followingcount = new javax.swing.JLabel();
        headerpanel = new javax.swing.JPanel();
        headerlb = new javax.swing.JLabel();
        home1lb = new javax.swing.JLabel();
        home2lb = new javax.swing.JLabel();
        sidepanel = new javax.swing.JPanel();
        dmbt = new javax.swing.JButton();
        homebtmain = new javax.swing.JButton();
        profilebtmain = new javax.swing.JButton();
        postbtmain = new javax.swing.JButton();
        schedulebtmain = new javax.swing.JButton();
        alertbtmain = new javax.swing.JButton();
        displaypanel = new javax.swing.JPanel();
        highpanel = new javax.swing.JPanel();
        searchfield = new javax.swing.JTextField();
        searchicon = new javax.swing.JLabel();
        sendtweet = new javax.swing.JButton();
        searchlb = new javax.swing.JLabel();
        refreshlb = new javax.swing.JLabel();
        loadlb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(null);

        toppanel.setBackground(new java.awt.Color(255, 255, 255));
        toppanel.setEnabled(false);
        toppanel.setLayout(null);

        homelb1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        homelb1.setText("loading...");
        homelb1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homelb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homelb1MouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homelb1MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                homelb1MouseExited(evt);
            }
        });
        toppanel.add(homelb1);
        homelb1.setBounds(130, 110, 150, 40);

        homelb2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        homelb2.setForeground(new java.awt.Color(102, 102, 102));
        homelb2.setText("loading....");
        homelb2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homelb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homelb2MouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homelb2MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                homelb2MouseExited(evt);
            }
        });
        toppanel.add(homelb2);
        homelb2.setBounds(130, 140, 160, 40);

        profilelb.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        profilelb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profilelb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilelbMouseClicked(evt);
            }
        });
        toppanel.add(profilelb);
        profilelb.setBounds(20, 50, 100, 100);

        uploadbt.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        uploadbt.setForeground(new java.awt.Color(255, 255, 255));
        uploadbt.setText("upload");
        uploadbt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uploadbt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                uploadbtMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                uploadbtMouseExited(evt);
            }
        });
        uploadbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadbtActionPerformed(evt);
            }
        });
        toppanel.add(uploadbt);
        uploadbt.setBounds(10, 160, 90, 30);

        tweetlb.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tweetlb.setForeground(new java.awt.Color(102, 102, 102));
        tweetlb.setText("Tweets");
        tweetlb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tweetlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tweetlbMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tweetlbMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                tweetlbMouseExited(evt);
            }
        });
        toppanel.add(tweetlb);
        tweetlb.setBounds(20, 190, 70, 30);

        followerlb.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        followerlb.setForeground(new java.awt.Color(102, 102, 102));
        followerlb.setText("Followers");
        followerlb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        followerlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                followerlbMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                followerlbMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                followerlbMouseExited(evt);
            }
        });
        toppanel.add(followerlb);
        followerlb.setBounds(95, 190, 90, 30);

        folllowinglb.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        folllowinglb.setForeground(new java.awt.Color(102, 102, 102));
        folllowinglb.setText("Following");
        folllowinglb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        folllowinglb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                folllowinglbMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                folllowinglbMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                folllowinglbMouseExited(evt);
            }
        });
        toppanel.add(folllowinglb);
        folllowinglb.setBounds(190, 190, 90, 30);

        tweetcount.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        tweetcount.setForeground(new java.awt.Color(29, 161, 242));
        tweetcount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tweetcount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tweetcountMouseClicked(evt);
            }
        });
        toppanel.add(tweetcount);
        tweetcount.setBounds(20, 220, 60, 30);

        followercount.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        followercount.setForeground(new java.awt.Color(29, 161, 242));
        followercount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        followercount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                followercountMouseClicked(evt);
            }
        });
        toppanel.add(followercount);
        followercount.setBounds(100, 220, 70, 30);

        followingcount.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        followingcount.setForeground(new java.awt.Color(29, 161, 242));
        followingcount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        followingcount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                followingcountMouseClicked(evt);
            }
        });
        toppanel.add(followingcount);
        followingcount.setBounds(190, 220, 80, 30);

        headerpanel.setBackground(new java.awt.Color(29, 161, 242));
        headerpanel.setLayout(null);

        headerlb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        headerlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                headerlbMouseClicked(evt);
            }
        });
        headerpanel.add(headerlb);
        headerlb.setBounds(0, 0, 300, 110);

        toppanel.add(headerpanel);
        headerpanel.setBounds(0, 0, 300, 110);

        home1lb.setText("jLabel1");
        home1lb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        toppanel.add(home1lb);
        home1lb.setBounds(130, 140, 170, 2);

        home2lb.setText("jLabel2");
        home2lb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        toppanel.add(home2lb);
        home2lb.setBounds(130, 170, 170, 2);

        getContentPane().add(toppanel);
        toppanel.setBounds(0, 10, 300, 260);

        sidepanel.setBackground(new java.awt.Color(255, 255, 255));
        sidepanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        sidepanel.setEnabled(false);
        sidepanel.setLayout(null);

        dmbt.setBackground(new java.awt.Color(29, 161, 242));
        dmbt.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        dmbt.setForeground(new java.awt.Color(255, 255, 255));
        dmbt.setText("dm");
        dmbt.setEnabled(false);
        dmbt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dmbtMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                dmbtMouseExited(evt);
            }
        });
        dmbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dmbtActionPerformed(evt);
            }
        });
        sidepanel.add(dmbt);
        dmbt.setBounds(14, 140, 270, 45);

        homebtmain.setBackground(new java.awt.Color(29, 161, 242));
        homebtmain.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        homebtmain.setForeground(new java.awt.Color(255, 255, 255));
        homebtmain.setText("home");
        homebtmain.setEnabled(false);
        homebtmain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homebtmainMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                homebtmainMouseExited(evt);
            }
        });
        homebtmain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebtmainActionPerformed(evt);
            }
        });
        sidepanel.add(homebtmain);
        homebtmain.setBounds(14, 70, 270, 45);

        profilebtmain.setBackground(new java.awt.Color(29, 161, 242));
        profilebtmain.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        profilebtmain.setForeground(new java.awt.Color(255, 255, 255));
        profilebtmain.setText("profile");
        profilebtmain.setEnabled(false);
        profilebtmain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profilebtmainMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                profilebtmainMouseExited(evt);
            }
        });
        profilebtmain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profilebtmainActionPerformed(evt);
            }
        });
        sidepanel.add(profilebtmain);
        profilebtmain.setBounds(14, 210, 270, 45);

        postbtmain.setBackground(new java.awt.Color(29, 161, 242));
        postbtmain.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        postbtmain.setForeground(new java.awt.Color(255, 255, 255));
        postbtmain.setText("post a tweet");
        postbtmain.setEnabled(false);
        postbtmain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                postbtmainMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                postbtmainMouseExited(evt);
            }
        });
        postbtmain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postbtmainActionPerformed(evt);
            }
        });
        sidepanel.add(postbtmain);
        postbtmain.setBounds(14, 10, 270, 45);

        schedulebtmain.setBackground(new java.awt.Color(29, 161, 242));
        schedulebtmain.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        schedulebtmain.setForeground(new java.awt.Color(255, 255, 255));
        schedulebtmain.setText("schedule");
        schedulebtmain.setEnabled(false);
        schedulebtmain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                schedulebtmainMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                schedulebtmainMouseExited(evt);
            }
        });
        schedulebtmain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schedulebtmainActionPerformed(evt);
            }
        });
        sidepanel.add(schedulebtmain);
        schedulebtmain.setBounds(14, 270, 270, 45);

        alertbtmain.setBackground(new java.awt.Color(29, 161, 242));
        alertbtmain.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        alertbtmain.setForeground(new java.awt.Color(255, 255, 255));
        alertbtmain.setText("alerts");
        alertbtmain.setEnabled(false);
        alertbtmain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                alertbtmainMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                alertbtmainMouseExited(evt);
            }
        });
        alertbtmain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alertbtmainActionPerformed(evt);
            }
        });
        sidepanel.add(alertbtmain);
        alertbtmain.setBounds(14, 340, 270, 45);

        getContentPane().add(sidepanel);
        sidepanel.setBounds(0, 280, 300, 490);

        displaypanel.setBackground(new java.awt.Color(255, 255, 255));
        displaypanel.setLayout(null);
        getContentPane().add(displaypanel);
        displaypanel.setBounds(310, 120, 1056, 650);

        highpanel.setBackground(new java.awt.Color(255, 255, 255));
        highpanel.setEnabled(false);
        highpanel.setLayout(null);

        searchfield.setBackground(new java.awt.Color(204, 240, 255));
        searchfield.setFont(new java.awt.Font("Vrinda", 0, 14)); // NOI18N
        searchfield.setForeground(new java.awt.Color(153, 153, 153));
        searchfield.setText("Enter username to search");
        searchfield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 161, 242), 2, true));
        searchfield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchfieldMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchfieldMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchfieldMouseExited(evt);
            }
        });
        searchfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchfieldActionPerformed(evt);
            }
        });
        searchfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchfieldKeyPressed(evt);
            }
        });
        highpanel.add(searchfield);
        searchfield.setBounds(590, 30, 180, 40);

        searchicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/s2.png"))); // NOI18N
        searchicon.setText("jLabel4");
        searchicon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchiconMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchiconMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchiconMouseExited(evt);
            }
        });
        highpanel.add(searchicon);
        searchicon.setBounds(780, 30, 40, 40);

        sendtweet.setBackground(new java.awt.Color(29, 161, 242));
        sendtweet.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        sendtweet.setForeground(new java.awt.Color(255, 255, 255));
        sendtweet.setText("TWEET");
        sendtweet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendtweetMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sendtweetMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                sendtweetMouseExited(evt);
            }
        });
        sendtweet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendtweetActionPerformed(evt);
            }
        });
        highpanel.add(sendtweet);
        sendtweet.setBounds(920, 40, 110, 35);

        searchlb.setText("loading...");
        highpanel.add(searchlb);
        searchlb.setBounds(845, 20, 70, 70);

        refreshlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh1.png"))); // NOI18N
        refreshlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshlbMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                refreshlbMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                refreshlbMouseExited(evt);
            }
        });
        highpanel.add(refreshlb);
        refreshlb.setBounds(30, 10, 90, 90);

        loadlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/l3.gif"))); // NOI18N
        highpanel.add(loadlb);
        loadlb.setBounds(380, 0, 100, 100);

        getContentPane().add(highpanel);
        highpanel.setBounds(310, 10, 1060, 100);

        pack();
    }// </editor-fold>//GEN-END:initComponents
////////////////tweet button logic starts///////////////////////////////////////////////////////////////////////

    private void postbtmainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postbtmainActionPerformed
        displaypanel.removeAll();
        displaypanel.repaint();
        singletweetpanel stp = new singletweetpanel();

        stp.setSize(displaypanel.getWidth(), displaypanel.getHeight());
        ///text tweet pane/////////////////////////////////////////////////////////////////
        stp.texttweetarea.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent ce) {
                int l = stp.texttweetarea.getText().length();
                stp.textcount.setText(280 - l + "");
                if (280 - l < 0) {
                    stp.tweetbt.setEnabled(false);
                } else {
                    stp.tweetbt.setEnabled(true);
                }
            }
        });
        stp.tweetbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (stp.texttweetarea.getText().equals("")) {
                    JOptionPane.showMessageDialog(home.this, "please enter your tweet");
                } else {
                    Thread t1 = new Thread(new tweet(stp.texttweetarea.getText()));
                    t1.start();
                    stp.texttweetarea.setText("");
                }
            }
        });

        BufferedImage bi = resize(b, stp.textphotolb.getWidth(), stp.textphotolb.getHeight());
        stp.textphotolb.setIcon(new ImageIcon(bi));
        displaypanel.add(stp);
        displaypanel.repaint();
///photo tweet pane//////////////////////////////////////////////////////////
        stp.photoarea.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent ce) {
                int l1 = stp.photoarea.getText().length();
                stp.photocount.setText(280 - l1 + "");
                if (280 - l1 < 0) {
                    stp.photobt.setEnabled(false);
                } else {
                    stp.photobt.setEnabled(true);
                }

            }
        });
        stp.browsebt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser fc = new JFileChooser();
                int a = fc.showOpenDialog(home.this);
                if (a == fc.APPROVE_OPTION) {
                    f = fc.getSelectedFile();
                    stp.photobrowse.setText(f.getPath());
                }
            }
        });
        BufferedImage bi1 = resize(b, stp.photolb.getWidth(), stp.photolb.getHeight());
        stp.photolb.setIcon(new ImageIcon(bi1));
        stp.photobt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (f == null) {
                    JOptionPane.showMessageDialog(home.this, "please select appropriate photo");
                } else {
                    StatusUpdate su1 = new StatusUpdate(stp.photoarea.getText());
                    su1.setMedia(f);
                    Thread t2 = new Thread(new phototweet(su1));
                    t2.start();
                }
                stp.photoarea.setText("What's Happening?");
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            loadlb.setIcon(upld);
                            Thread.sleep(5000);
                            loadlb.setIcon(twtr);
                            JOptionPane.showMessageDialog(home.this, "Tweet successful");

                        } catch (InterruptedException ex) {
                            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }).start();

                stp.photobrowse.setText("");

            }
        });
/////////////photo tweet ends///////////////////////////////////////////////
////////////////////////locationtweet pane//////////////////////////////////////////////
        stp.locationarea.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent ce) {
                int l2 = stp.locationarea.getText().length();
                stp.locationcount.setText(280 - l2 + "");
                if (280 - l2 < 0) {
                    stp.locationbt.setEnabled(false);
                } else {
                    stp.locationbt.setEnabled(true);
                }
            }
        });

        GeoLocation g = new GeoLocation(43, 65);
        locationadapter l = new locationadapter("Amritsar", g);
        al.add(l);
        g = new GeoLocation(31.1048, 77.1734);
        l = new locationadapter("shimla", g);
        al.add(l);
        g = new GeoLocation(22.5726, 88.3639);
        l = new locationadapter("kolkata", g);
        al.add(l);
        g = new GeoLocation(19.0760, 72.8777);
        l = new locationadapter("jalandhar", g);
        al.add(l);
        g = new GeoLocation(28.7041, 77.1025);
        l = new locationadapter("delhi", g);
        al.add(l);
        g = new GeoLocation(30.9010, 75.8573);
        l = new locationadapter("ludhiana", g);
        al.add(l);
        stp.combobx.removeAllItems();
        for (int i = 0; i < al.size(); i++) {
            locationadapter obj = al.get(i);
            stp.combobx.addItem(obj.s);
        }
        BufferedImage bi2 = resize(b, stp.locationphotolb.getWidth(), stp.locationphotolb.getHeight());
        stp.locationphotolb.setIcon(new ImageIcon(bi2));
        stp.locationbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int index = stp.combobx.getSelectedIndex();
                locationadapter ob = al.get(index);

                if (f1 == null) {
                    JOptionPane.showMessageDialog(home.this, "please enter the text or picture");
                } else {
                    StatusUpdate su1 = new StatusUpdate(stp.locationarea.getText());
                    su1.setMedia(f1);
                    su1.setLocation(ob.g);
                    Thread t1 = new Thread(new locphototweet(su1));
                    t1.start();
                }
                stp.locationarea.setText("What's Happening?");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        loadlb.setIcon(upld);
                        try {
                            Thread.sleep(5000);
                            loadlb.setIcon(twtr);
                            JOptionPane.showMessageDialog(home.this, "Tweet successful");

                        } catch (InterruptedException ex) {
                            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }).start();

                stp.locbrowse.setText("");

            }
        });
        stp.lcbrowse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser fc = new JFileChooser();
                int a = fc.showOpenDialog(home.this);
                if (a == fc.APPROVE_OPTION) {
                    f1 = fc.getSelectedFile();
                    stp.locbrowse.setText(f1.getPath());
                }
            }
        });

        stp.locationarea.setText("");
        displaypanel.repaint();

    }//GEN-LAST:event_postbtmainActionPerformed
///////////////////////////////////////tweet button logic ends here///////////////////////////////////

    //////////////////////profile button logic starts//////////////////////////////////////////////////////////////
    private void profilebtmainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profilebtmainActionPerformed
        displaypanel.removeAll();
        displaypanel.repaint();
        profilepanel pp = new profilepanel();
        pp.setSize(displaypanel.getWidth(), displaypanel.getHeight());

        displaypanel.add(pp);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    IDs followers = twitter.getFollowersIDs(-1);
                    long[] id = followers.getIDs();
                    pp.followerpanel.setPreferredSize(new Dimension(pp.followerpanel.getWidth(), 300 * id.length));
                    for (int j = 0; j < id.length; j++) {
                        User user = twitter.showUser(id[j]);
                        singleprofilepanel spp = new singleprofilepanel();
                        spp.setBounds(104, 276 * j + 20 * j, 292, 276);
                        pp.followerpanel.add(spp);
                        spp.prnm.setText(user.getName());
                        spp.prscrnm.setText("@" + user.getScreenName());
                        String s1 = user.getOriginalProfileImageURL();
                        BufferedImage bi = ImageIO.read(new URL(s1));
                        BufferedImage resizepic = resize(bi, spp.singlephoto.getWidth(), spp.singlephoto.getHeight());
                        spp.singlephoto.setIcon(new ImageIcon(resizepic));
                        String s2 = user.getProfileBannerURL();
                        if (s2 != null) {

                            BufferedImage bi1 = ImageIO.read(new URL(s2));
                            BufferedImage resizepic1 = resize(bi1, spp.pblb.getWidth(), spp.pblb.getHeight());
                            spp.pblb.setIcon(new ImageIcon(resizepic1));
                        } else {
                            spp.pbp.setBackground(new Color(29, 191, 242));
                        }
                        pp.followerpanel.repaint();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    IDs friends = twitter.getFriendsIDs(-1);
                    long[] id = friends.getIDs();
                    pp.friendpanel.setPreferredSize(new Dimension(pp.friendpanel.getWidth(), 300 * id.length));
                    int y = 0;
                    for (int j = 0; j < id.length; j++) {
                        User user = twitter.showUser(id[j]);
                        singleprofilepanel spp = new singleprofilepanel();

                        spp.setBounds(104, 276 * j + 20 * j, 292, 276);

                        spp.prnm.setText(user.getName());
                        pp.friendpanel.add(spp);
                        spp.prscrnm.setText("@" + user.getScreenName());
                        String s1 = user.getOriginalProfileImageURL();
                        BufferedImage bi = ImageIO.read(new URL(s1));
                        BufferedImage resizepic = resize(bi, spp.singlephoto.getWidth(), spp.singlephoto.getHeight());
                        spp.singlephoto.setIcon(new ImageIcon(resizepic));
                        String s2 = user.getProfileBannerURL();
                        if (s2 != null) {

                            BufferedImage bi1 = ImageIO.read(new URL(s2));
                            BufferedImage resizepic1 = resize(bi1, spp.pblb.getWidth(), spp.pblb.getHeight());
                            spp.pblb.setIcon(new ImageIcon(resizepic1));

                        } else {
                            spp.pbp.setBackground(new Color(29, 191, 242));
                        }
                        pp.friendpanel.repaint();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }//GEN-LAST:event_profilebtmainActionPerformed

    private void uploadbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadbtActionPerformed
        JFileChooser jfc = new JFileChooser();
        int a = jfc.showOpenDialog(home.this);
        if (a == JFileChooser.APPROVE_OPTION) {
            f = jfc.getSelectedFile();
            Thread t1 = new Thread(new upload(f));
            t1.start();
        }
    }//GEN-LAST:event_uploadbtActionPerformed

    private void homebtmainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebtmainActionPerformed

        Thread t1 = new Thread(new userhome());
        t1.start();

    }//GEN-LAST:event_homebtmainActionPerformed

    private void schedulebtmainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schedulebtmainActionPerformed
        Thread tm1 = new Thread(new schedule());
        tm1.start();

    }//GEN-LAST:event_schedulebtmainActionPerformed

    private void alertbtmainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alertbtmainActionPerformed

        Thread t2 = new Thread(new alertscompare());
        t2.start();
    }//GEN-LAST:event_alertbtmainActionPerformed

    private void uploadbtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadbtMouseEntered
        uploadbt.setBackground(new Color(30, 21, 90));
    }//GEN-LAST:event_uploadbtMouseEntered

    private void uploadbtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadbtMouseExited
        uploadbt.setBackground(new Color(29, 161, 242));
    }//GEN-LAST:event_uploadbtMouseExited

    private void searchfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchfieldActionPerformed

    }//GEN-LAST:event_searchfieldActionPerformed

    private void searchfieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchfieldMouseEntered
        Border br = BorderFactory.createLineBorder(new Color(30, 21, 90), 2);
        searchfield.setBorder(br);
    }//GEN-LAST:event_searchfieldMouseEntered

    private void searchfieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchfieldMouseExited
        Border br1 = BorderFactory.createLineBorder(new Color(29, 161, 242), 3);
        searchfield.setBorder(br1);
    }//GEN-LAST:event_searchfieldMouseExited

    private void searchiconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchiconMouseEntered
        searchicon.setSize(80, 80);
        try {
            BufferedImage read = ImageIO.read(new File("src\\folder\\s3.png"));
            searchicon.setIcon(new ImageIcon(read));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_searchiconMouseEntered

    private void searchiconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchiconMouseClicked
        Thread sr = new Thread(new search());
        loadlb.setIcon(loader);
        sr.start();

    }//GEN-LAST:event_searchiconMouseClicked

    private void searchiconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchiconMouseExited
        searchicon.setSize(40, 40);
        try {
            BufferedImage read = ImageIO.read(new File("src\\folder\\s2.png"));
            searchicon.setIcon(new ImageIcon(read));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_searchiconMouseExited

    private void searchfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchfieldKeyPressed

    }//GEN-LAST:event_searchfieldKeyPressed

    private void searchfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchfieldMouseClicked
        searchfield.setText("");
        searchfield.setForeground(new Color(30, 21, 90));
    }//GEN-LAST:event_searchfieldMouseClicked

    private void dmbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dmbtActionPerformed
        Thread drm = new Thread(new dm());
        drm.start();

    }//GEN-LAST:event_dmbtActionPerformed

    private void headerlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerlbMouseClicked
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        userprofileframe upf = new userprofileframe(twitter);
        upf.setVisible(true);
        upf.setSize(size);
        ////   upf.setSize(1366,768);
    }//GEN-LAST:event_headerlbMouseClicked

    private void profilelbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilelbMouseClicked
        userprofileframe upf = new userprofileframe(twitter);
        upf.setVisible(true);
        upf.setSize(size);
////   upf.setSize(1366,768);                      
    }//GEN-LAST:event_profilelbMouseClicked

    private void folllowinglbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_folllowinglbMouseClicked
        displaypanel.removeAll();
        displaypanel.repaint();
        followingpanel fp = new followingpanel();
        fp.setSize(displaypanel.getWidth(), displaypanel.getHeight());
        displaypanel.add(fp);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    IDs friends = twitter.getFriendsIDs(-1);
                    long[] id = friends.getIDs();
                    fp.jScrollPane1.setSize(displaypanel.getWidth() - 20, displaypanel.getHeight());
                    fp.friendpanel.setPreferredSize(new Dimension(fp.friendpanel.getWidth(), 300 * id.length));
                    int y = 20;
                    for (int j = 0; j < id.length; j++) {
                        User user = twitter.showUser(id[j]);
                        singleprofilepanel spp = new singleprofilepanel();

                        spp.setBounds(104, 276 * j + 40 * j + y, 292, 276);
                        y = 0;
                        spp.prnm.setText(user.getName());
                        fp.friendpanel.add(spp);
                        spp.prscrnm.setText("@" + user.getScreenName());
                        String s1 = user.getOriginalProfileImageURL();
                        BufferedImage bi = ImageIO.read(new URL(s1));
                        BufferedImage resizepic = resize(bi, spp.singlephoto.getWidth(), spp.singlephoto.getHeight());
                        spp.singlephoto.setIcon(new ImageIcon(resizepic));
                        String s2 = user.getProfileBannerURL();
                        if (s2 != null) {

                            BufferedImage bi1 = ImageIO.read(new URL(s2));
                            BufferedImage resizepic1 = resize(bi1, spp.pblb.getWidth(), spp.pblb.getHeight());
                            spp.pblb.setIcon(new ImageIcon(resizepic1));

                        } else {
                            spp.pbp.setBackground(new Color(29, 191, 242));
                        }
                        fp.friendpanel.repaint();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }//GEN-LAST:event_folllowinglbMouseClicked

    private void followerlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_followerlbMouseClicked
        displaypanel.removeAll();
        displaypanel.repaint();
        followingpanel fp = new followingpanel();
        fp.setSize(displaypanel.getWidth(), displaypanel.getHeight());
        displaypanel.add(fp);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    IDs friends = twitter.getFollowersIDs(-1);
                    long[] id = friends.getIDs();
                    fp.jScrollPane1.setSize(displaypanel.getWidth() - 20, displaypanel.getHeight());
                    fp.friendpanel.setPreferredSize(new Dimension(fp.friendpanel.getWidth(), 300 * id.length));
                    int y = 20;
                    for (int j = 0; j < id.length; j++) {
                        User user = twitter.showUser(id[j]);
                        singleprofilepanel spp = new singleprofilepanel();

                        spp.setBounds(104, 276 * j + 40 * j + y, 292, 276);
                        y = 0;
                        spp.prnm.setText(user.getName());
                        fp.friendpanel.add(spp);
                        spp.prscrnm.setText("@" + user.getScreenName());
                        String s1 = user.getOriginalProfileImageURL();
                        BufferedImage bi = ImageIO.read(new URL(s1));
                        BufferedImage resizepic = resize(bi, spp.singlephoto.getWidth(), spp.singlephoto.getHeight());
                        spp.singlephoto.setIcon(new ImageIcon(resizepic));
                        String s2 = user.getProfileBannerURL();
                        if (s2 != null) {

                            BufferedImage bi1 = ImageIO.read(new URL(s2));
                            BufferedImage resizepic1 = resize(bi1, spp.pblb.getWidth(), spp.pblb.getHeight());
                            spp.pblb.setIcon(new ImageIcon(resizepic1));

                        } else {
                            spp.pbp.setBackground(new Color(29, 191, 242));
                        }
                        fp.friendpanel.repaint();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }//GEN-LAST:event_followerlbMouseClicked

    private void folllowinglbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_folllowinglbMouseEntered
        folllowinglb.setForeground(new Color(29, 161, 242));
    }//GEN-LAST:event_folllowinglbMouseEntered

    private void folllowinglbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_folllowinglbMouseExited
        folllowinglb.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_folllowinglbMouseExited

    private void followerlbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_followerlbMouseEntered
        followerlb.setForeground(new Color(29, 161, 242));
    }//GEN-LAST:event_followerlbMouseEntered

    private void followerlbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_followerlbMouseExited
        followerlb.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_followerlbMouseExited

    private void followercountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_followercountMouseClicked
        displaypanel.removeAll();
        displaypanel.repaint();
        followingpanel fp = new followingpanel();
        fp.setSize(displaypanel.getWidth(), displaypanel.getHeight());
        displaypanel.add(fp);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    IDs friends = twitter.getFollowersIDs(-1);
                    long[] id = friends.getIDs();
                    fp.jScrollPane1.setSize(displaypanel.getWidth() - 20, displaypanel.getHeight());
                    fp.friendpanel.setPreferredSize(new Dimension(fp.friendpanel.getWidth(), 300 * id.length));
                    int y = 20;
                    for (int j = 0; j < id.length; j++) {
                        User user = twitter.showUser(id[j]);
                        singleprofilepanel spp = new singleprofilepanel();

                        spp.setBounds(104, 276 * j + 40 * j + y, 292, 276);
                        y = 0;
                        spp.prnm.setText(user.getName());
                        fp.friendpanel.add(spp);
                        spp.prscrnm.setText("@" + user.getScreenName());
                        String s1 = user.getOriginalProfileImageURL();
                        BufferedImage bi = ImageIO.read(new URL(s1));
                        BufferedImage resizepic = resize(bi, spp.singlephoto.getWidth(), spp.singlephoto.getHeight());
                        spp.singlephoto.setIcon(new ImageIcon(resizepic));
                        String s2 = user.getProfileBannerURL();
                        if (s2 != null) {

                            BufferedImage bi1 = ImageIO.read(new URL(s2));
                            BufferedImage resizepic1 = resize(bi1, spp.pblb.getWidth(), spp.pblb.getHeight());
                            spp.pblb.setIcon(new ImageIcon(resizepic1));

                        } else {
                            spp.pbp.setBackground(new Color(29, 191, 242));
                        }
                        fp.friendpanel.repaint();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }//GEN-LAST:event_followercountMouseClicked

    private void followingcountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_followingcountMouseClicked
        displaypanel.removeAll();
        displaypanel.repaint();
        followingpanel fp = new followingpanel();
        fp.setSize(displaypanel.getWidth(), displaypanel.getHeight());
        displaypanel.add(fp);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    IDs friends = twitter.getFriendsIDs(-1);
                    long[] id = friends.getIDs();
                    fp.jScrollPane1.setSize(displaypanel.getWidth() - 20, displaypanel.getHeight());
                    fp.friendpanel.setPreferredSize(new Dimension(fp.friendpanel.getWidth(), 300 * id.length));
                    int y = 20;
                    for (int j = 0; j < id.length; j++) {
                        User user = twitter.showUser(id[j]);
                        singleprofilepanel spp = new singleprofilepanel();

                        spp.setBounds(104, 276 * j + 40 * j + y, 292, 276);
                        y = 0;
                        spp.prnm.setText(user.getName());
                        fp.friendpanel.add(spp);
                        spp.prscrnm.setText("@" + user.getScreenName());
                        String s1 = user.getOriginalProfileImageURL();
                        BufferedImage bi = ImageIO.read(new URL(s1));
                        BufferedImage resizepic = resize(bi, spp.singlephoto.getWidth(), spp.singlephoto.getHeight());
                        spp.singlephoto.setIcon(new ImageIcon(resizepic));
                        String s2 = user.getProfileBannerURL();
                        if (s2 != null) {

                            BufferedImage bi1 = ImageIO.read(new URL(s2));
                            BufferedImage resizepic1 = resize(bi1, spp.pblb.getWidth(), spp.pblb.getHeight());
                            spp.pblb.setIcon(new ImageIcon(resizepic1));

                        } else {
                            spp.pbp.setBackground(new Color(29, 191, 242));
                        }
                        fp.friendpanel.repaint();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }//GEN-LAST:event_followingcountMouseClicked

    private void tweetlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tweetlbMouseClicked
        userprofileframe upf = new userprofileframe(twitter);
        upf.setVisible(true);
        upf.setSize(size);

    }//GEN-LAST:event_tweetlbMouseClicked

    private void tweetlbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tweetlbMouseEntered
        tweetlb.setForeground(new Color(29, 161, 242));
    }//GEN-LAST:event_tweetlbMouseEntered

    private void tweetlbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tweetlbMouseExited
        tweetlb.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_tweetlbMouseExited

    private void tweetcountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tweetcountMouseClicked
        userprofileframe upf = new userprofileframe(twitter);
        upf.setVisible(true);
        upf.setSize(size);

    }//GEN-LAST:event_tweetcountMouseClicked

    private void homelb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homelb1MouseClicked
        userprofileframe upf = new userprofileframe(twitter);
        upf.setVisible(true);
        upf.setSize(size);
        ////   upf.setSize(1366,768);
    }//GEN-LAST:event_homelb1MouseClicked

    private void homelb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homelb2MouseClicked
        userprofileframe upf = new userprofileframe(twitter);
        upf.setVisible(true);
        upf.setSize(size);
        ////   upf.setSize(1366,768);
    }//GEN-LAST:event_homelb2MouseClicked

    private void homelb1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homelb1MouseEntered
        home1lb.setVisible(true);
    }//GEN-LAST:event_homelb1MouseEntered

    private void homelb2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homelb2MouseEntered
        home2lb.setVisible(true);
    }//GEN-LAST:event_homelb2MouseEntered

    private void homelb1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homelb1MouseExited
        home1lb.setVisible(false);
    }//GEN-LAST:event_homelb1MouseExited

    private void homelb2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homelb2MouseExited
        home2lb.setVisible(false);
    }//GEN-LAST:event_homelb2MouseExited

    private void sendtweetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendtweetMouseClicked

    }//GEN-LAST:event_sendtweetMouseClicked

    private void sendtweetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendtweetActionPerformed
        tweetframe stp = new tweetframe();
        tweetframe2 stp2 = new tweetframe2();
        stp.setVisible(true);
        stp.setSize(835, 354);
        stp.setLocationRelativeTo(null);
        String s1 = u.getOriginalProfileImageURL();
        try {
            BufferedImage bi = ImageIO.read(new URL(s1));
            BufferedImage resizepic = resize(bi, stp.textphotolb.getWidth(), stp.textphotolb.getHeight());
            stp.textphotolb.setIcon(new ImageIcon(resizepic));
            stp2.textphotolb.setIcon(new ImageIcon(resizepic));
        } catch (Exception e) {

        }

        ///text tweet pane/////////////////////////////////////////////////////////////////
        stp.texttweetarea.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent ce) {
                int l = stp.texttweetarea.getText().length();
                stp.textcount.setText(280 - l + "");
                if (280 - l < 0) {
                    stp.tweetbt.setEnabled(false);
                } else {
                    stp.tweetbt.setEnabled(true);
                }
            }
        });
        stp.tweetbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (stp.texttweetarea.getText().equals("")) {
                    JOptionPane.showMessageDialog(home.this, "please enter your tweet");
                } else {
                    Thread t1 = new Thread(new tweet(stp.texttweetarea.getText()));
                    t1.start();
                    stp.texttweetarea.setText("");
                }
            }
        });

        BufferedImage bi = resize(b, stp.textphotolb.getWidth(), stp.textphotolb.getHeight());
        stp.textphotolb.setIcon(new ImageIcon(bi));

        displaypanel.repaint();
///photo tweet pane//////////////////////////////////////////////////////////
/*stp.photoarea.addCaretListener(new CaretListener() {
     @Override
     public void caretUpdate(CaretEvent ce) {
   int l1=stp.photoarea.getText().length();
stp.photocount.setText(280-l1+"");
if(280-l1<0)
{
    stp.photobt.setEnabled(false);
}
else
{
    stp.photobt.setEnabled(true);
}

     }
 });*/
        stp.browsebt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                JFileChooser fc = new JFileChooser();
                int a = fc.showOpenDialog(home.this);
                if (a == fc.APPROVE_OPTION) {
                    f = fc.getSelectedFile();
                    String transfer = stp.texttweetarea.getText();
                    stp.dispose();
                    stp2.setVisible(true);
                    stp2.setSize(835, 563);
                    stp2.texttweetarea.setText(transfer);
                    stp2.setLocationRelativeTo(null);
                    String s = f.getPath();
                    try {
                        b = ImageIO.read(new File(s));
                    } catch (IOException ex) {
                        Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    BufferedImage resizepic = resize(b, stp2.sendphoto.getWidth(), stp2.sendphoto.getHeight());
                    stp2.sendphoto.setIcon(new ImageIcon(resizepic));

                }
            }
        });
        /*BufferedImage bi1=resize(b,stp.photolb.getWidth(),stp.photolb.getHeight());
             stp.photolb.setIcon(new ImageIcon(bi1));*/
        stp2.tweetbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (f == null) {
                    JOptionPane.showMessageDialog(home.this, "please select appropriate photo");
                } else {
                    StatusUpdate su1 = new StatusUpdate(stp.texttweetarea.getText());
                    su1.setMedia(f);
                    Thread t2 = new Thread(new phototweet(su1));
                    t2.start();
                    stp2.dispose();

                    JOptionPane.showMessageDialog(home.this, "photo uploaded");
                    dispose();
                    new home(twitter).setVisible(true);
                }

            }
        });
/////////////photo tweet ends///////////////////////////////////////////////
////////////////////////locationtweet pane//////////////////////////////////////////////
/*stp.locationarea.addCaretListener(new CaretListener() {
     @Override
     public void caretUpdate(CaretEvent ce) {
   int l2=stp.locationarea.getText().length();
stp.locationcount.setText(280-l2+"");
if(280-l2<0)
{
    stp.locationbt.setEnabled(false);
}
else
{
    stp.locationbt.setEnabled(true);
}}});

         GeoLocation g=new GeoLocation(43,65);
     locationadapter l=new locationadapter("Amritsar",g);
         al.add(l);
       g=new GeoLocation(31.1048,77.1734);
       l=new locationadapter("shimla",g);
        al.add(l);
       g=new GeoLocation(22.5726,88.3639);
       l=new locationadapter("kolkata",g);
        al.add(l);
       g=new GeoLocation(19.0760,72.8777);
       l=new locationadapter("jalandhar",g);
        al.add(l);
       g=new GeoLocation(28.7041,77.1025);
       l=new locationadapter("delhi",g);
        al.add(l);
       g=new GeoLocation(30.9010,75.8573);
       l=new locationadapter("ludhiana",g);
        al.add(l);
        stp.combobx.removeAllItems();
        for(int i=0;i<al.size();i++)
        {
            locationadapter obj=al.get(i);
            stp.combobx.addItem(obj.s);
        }
          BufferedImage bi2=resize(b,stp.locationphotolb.getWidth(),stp.locationphotolb.getHeight());
             stp.locationphotolb.setIcon(new ImageIcon(bi2));
        stp.locationbt.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent ae) {
int index=stp.combobx.getSelectedIndex();
locationadapter ob=al.get(index);

   if(f==null)
   {
       JOptionPane.showMessageDialog(home.this, "please enter the text or picture");
   }
   else{
          StatusUpdate su=new StatusUpdate(stp.locationarea.getText());
          su.setMedia(f);
   su.setLocation(ob.g);
   Thread t1=new Thread(new phototweet(su));
   t1.start();

   }

     }});

       stp.locationarea.setText("");
       displaypanel.repaint();*/

    }//GEN-LAST:event_sendtweetActionPerformed

    private void sendtweetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendtweetMouseEntered
        sendtweet.setBackground(new Color(30, 21, 90));
    }//GEN-LAST:event_sendtweetMouseEntered

    private void sendtweetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendtweetMouseExited
        sendtweet.setBackground(new Color(29, 161, 242));
    }//GEN-LAST:event_sendtweetMouseExited

    private void postbtmainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postbtmainMouseEntered
        postbtmain.setBackground(new Color(30, 21, 90));
    }//GEN-LAST:event_postbtmainMouseEntered

    private void homebtmainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homebtmainMouseEntered
        homebtmain.setBackground(new Color(30, 21, 90));      // TODO add your handling code here:
    }//GEN-LAST:event_homebtmainMouseEntered

    private void dmbtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dmbtMouseEntered
        dmbt.setBackground(new Color(30, 21, 90));      // TODO add your handling code here:
    }//GEN-LAST:event_dmbtMouseEntered

    private void profilebtmainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilebtmainMouseEntered
        profilebtmain.setBackground(new Color(30, 21, 90));      // TODO add your handling code here:
    }//GEN-LAST:event_profilebtmainMouseEntered

    private void schedulebtmainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_schedulebtmainMouseEntered
        schedulebtmain.setBackground(new Color(30, 21, 90));      // TODO add your handling code here:
    }//GEN-LAST:event_schedulebtmainMouseEntered

    private void alertbtmainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alertbtmainMouseEntered
        alertbtmain.setBackground(new Color(30, 21, 90));      // TODO add your handling code here:
    }//GEN-LAST:event_alertbtmainMouseEntered

    private void postbtmainMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postbtmainMouseExited
        postbtmain.setBackground(new Color(29, 161, 242));   // TODO add your handling code here:
    }//GEN-LAST:event_postbtmainMouseExited

    private void homebtmainMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homebtmainMouseExited
        homebtmain.setBackground(new Color(29, 161, 242));
    }//GEN-LAST:event_homebtmainMouseExited

    private void dmbtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dmbtMouseExited
        dmbt.setBackground(new Color(29, 161, 242));   // TODO add your handling code here:
    }//GEN-LAST:event_dmbtMouseExited

    private void profilebtmainMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilebtmainMouseExited
        profilebtmain.setBackground(new Color(29, 161, 242));   // TODO add your handling code here:
    }//GEN-LAST:event_profilebtmainMouseExited

    private void schedulebtmainMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_schedulebtmainMouseExited
        schedulebtmain.setBackground(new Color(29, 161, 242));   // TODO add your handling code here:
    }//GEN-LAST:event_schedulebtmainMouseExited

    private void alertbtmainMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alertbtmainMouseExited
        alertbtmain.setBackground(new Color(29, 161, 242));   // TODO add your handling code here:
    }//GEN-LAST:event_alertbtmainMouseExited

    private void refreshlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshlbMouseClicked
        dispose();
        new home(twitter).setVisible(true);

    }//GEN-LAST:event_refreshlbMouseClicked

    private void refreshlbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshlbMouseEntered
        Border br = BorderFactory.createLineBorder(new Color(30, 21, 90), 1);
        refreshlb.setBorder(br);
    }//GEN-LAST:event_refreshlbMouseEntered

    private void refreshlbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshlbMouseExited
        refreshlb.setBorder(null);
    }//GEN-LAST:event_refreshlbMouseExited
    ////////////////////////////////////////////////////direct message////////////////////////////

    class dm implements Runnable {

        @Override
        public void run() {
            displaypanel.removeAll();
            displaypanel.repaint();
            dmpanel dmp = new dmpanel();
            dmp.setSize(displaypanel.getWidth(), displaypanel.getHeight());
            DirectMessagesResources dmr = twitter.directMessages();
            HashSet<Long> hset = new HashSet<Long>();
            try {
//                ResponseList<DirectMessage> recievelist = twitter.getDirectMessages();
               
                ResponseList<DirectMessage> recievelist = dmr.getDirectMessages();

                for (DirectMessage d : recievelist) {
                    hset.add(d.getSenderId());

                }
                ResponseList<DirectMessage> sentlist = dmr.getSentDirectMessages();

                for (DirectMessage d : sentlist) {
                    hset.add(d.getRecipientId());

                }
                dmp.dmscroll.setSize(displaypanel.getWidth() - 20, displaypanel.getHeight());
                dmp.dmshow.setPreferredSize(new Dimension(displaypanel.getWidth(), hset.size() * 136));
                int y = 0;
                for (long l : hset) {
                    User dmuser = twitter.showUser(l);
                    singledmpanel sdp = new singledmpanel();
                    sdp.setBounds(0, y, displaypanel.getWidth(), 125);
                    y = y + 125;
                    //////////////////////////////////////////////////class fetch for 1 msg........////////////////////////////////////////////////
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            al1 = new ArrayList<>();
                            DirectMessagesResources dmr = twitter.directMessages();
                            /*Hashset<Long> hset = new HashSet<Long>();*/
                            try {
                                ResponseList<DirectMessage> recievelist = dmr.getDirectMessages();
                                for (DirectMessage d : recievelist) {
                                    if (d.getSenderId() == l) {
                                        al1.add(d);

                                    }
                                }
                                ResponseList<DirectMessage> sentlist = dmr.getSentDirectMessages();
                                for (DirectMessage d : sentlist) {
                                    if (d.getRecipientId() == l) {
                                        al1.add(d);
                                    }
                                }

                                Collections.sort(al1, new Comparator<DirectMessage>() {
                                    @Override
                                    public int compare(DirectMessage t, DirectMessage t1) {
                                        return t.getCreatedAt().compareTo(t1.getCreatedAt());

                                    }

                                });

                                int size = al1.size();
                                DirectMessage get1 = al1.get(size - 1);
                                Date get1crt = get1.getCreatedAt();

                                boolean contains = sentlist.contains(get1);
                                if (contains == true) {
                                    sdp.singlemsg.setText("you:" + get1.getText());
                                    sdp.msgdt.setText(get1crt + "");
                                } else {
                                    sdp.singlemsg.setText(get1.getText());
                                    sdp.msgdt.setText(get1crt + "");
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                    /////////////////////////////////////////////////////single msg get ends////////////////////////////////////////
                    String url = dmuser.getProfileImageURL();
                    BufferedImage bi = ImageIO.read(new URL(url));
                    BufferedImage resize = resize(bi, sdp.dmlb.getWidth(), sdp.dmlb.getHeight());
                    sdp.dmlb.setIcon(new ImageIcon(resize));
                    sdp.dmname.setText(dmuser.getName());
                    sdp.dmscr.setText("@" + dmuser.getScreenName());
                    sdp.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent me) {
                            new Thread(new Runnable() {
                                @Override
                                public void run() {

                                    try {
                                        chatscreen cs = new chatscreen(twitter, l);
                                        cs.setVisible(true);
                                        cs.setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
                                        try {
                                            String pic = u.getOriginalProfileImageURL();
                                            BufferedImage read = ImageIO.read(new URL(pic));
                                            BufferedImage resize1 = resize(read, cs.cslb.getWidth(), cs.cslb.getHeight());
                                            cs.cslb.setIcon(new ImageIcon(resize1));
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        cs.csname.setText(u.getName());
                                        cs.csscreennm.setText("@" + u.getScreenName());

                                    } catch (TwitterException ex) {
                                        Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }).start();
                        }

                    });
                    dmp.dmshow.add(sdp);
                    dmp.dmshow.repaint();

                }

            } catch (Exception ex) {
                Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            }
            displaypanel.add(dmp);
            displaypanel.repaint();

        }

    }

    //////////////////////////////////////////////////////////////////////direct mssage completed////////////////////////////////////////////////
    class alertscompare implements Runnable {

        @Override
        public void run() {

            displaypanel.removeAll();
            displaypanel.repaint();
            alertspanel alp = new alertspanel();
            alp.setSize(displaypanel.getWidth(), displaypanel.getHeight());
            displaypanel.add(alp);

            ArrayList<Followers> al2 = new ArrayList<>();
            IDs followers;
            try {
                followers = twitter.getFollowersIDs(-1);
                long[] ID = followers.getIDs();
                for (int i = 0; i < ID.length; i++) {
                    User user = twitter.showUser(ID[i]);
                    al2.add(new Followers(String.valueOf(user.getId()), user.getScreenName()));

                }
            } catch (TwitterException ex) {
                Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            }

            int i = 0;
            int k = 0;
            ArrayList al3 = new ArrayList();
            System.out.println(alf.size() + "arraylistsize");
            if (al2.size() < alf.size()) {

                for (Followers f : alf) {

                    int flag = 0;

                    for (Followers f1 : al2) {
                        if (f.userid.equals(f1.userid)) {
                            flag = 1;
                            break;

                        }
                    }
                    if (flag == 0) {
                        System.out.println(f.userid + "leaves u");

                        ///////////   
                        singlealert sa = new singlealert();
                        alp.add(sa);

                        sa.setBounds(0, 121 * i + 10 * i + 165, displaypanel.getWidth() - 5, 121);
                        i = i + 1;
                        sa.notif.setText("    " + f.username + "  unfollows  you");

                        /*try{                              
                        User user=twitter.showUser(f.userid);
                        System.out.println("user id is"+f.username);
                        sa.notif.setText(getName()+"unfollows you");
                        singleprofilepanel spp=new singleprofilepanel();
                         sa.profile.add(spp);
                        spp.prnm.setText(user.getName());
                        spp.prscrnm.setText("@"+user.getScreenName());

                        String s1=user.getOriginalProfileImageURL();
                        BufferedImage bi = ImageIO.read(new URL(s1));
                        BufferedImage resizepic=resize(bi,spp.singlephoto.getWidth(),spp.singlephoto.getHeight());
                        spp.singlephoto.setIcon(new ImageIcon(resizepic));
                        String s2= user.getProfileBannerURL();
                        if(s2!=null)
                        {
                            
                            BufferedImage bi1 = ImageIO.read(new URL(s2));
                            BufferedImage resizepic1=resize(bi1,spp.pblb.getWidth(),spp.pblb.getHeight());
                            spp.pblb.setIcon(new ImageIcon(resizepic1));
                            
                            
                        }
                        
                        else
                        {
                            spp.pbp.setBackground(new Color(29,191,242));
                        }
                       
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }*/
                    }

                }
            } else {

                statusnullnotif stf = new statusnullnotif();
                alp.add(stf);
                stf.notiflb.setText("No Alerts Yet!!!");
                stf.setBounds(250, 250, stf.getWidth(), stf.getHeight());
                alp.repaint();
            }
        }
    }
///////////////////////////////////////unfollow alertsss/////////////////////////////////////////////////////

    class alerts implements Runnable {

        @Override
        public void run() {

            IDs followers;
            try {
                followers = twitter.getFollowersIDs(-1);
                long[] ID = followers.getIDs();

                for (int i = 0; i < ID.length; i++) {
                    try {
                        User user = twitter.showUser(ID[i]);

                        alf.add(new Followers(String.valueOf(user.getId()), user.getScreenName()));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                /*   ResultSet result = dbconn.executeQuery("select * from alertstb");
                for (Followers f : alf) {
                   
                    if(!result.next())
                    {
                    String userid = f.userid;
                    String username = f.username;

                    result.moveToInsertRow();
                    result.updateString("userid", userid);
                    result.updateString("username", username);
                    result.insertRow();
                    System.out.println("added");

                }}*/
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    class Followers {

        String userid;
        String username;

        public Followers(String userid, String username) {
            this.userid = userid;
            this.username = username;
        }
    }

////////////////////////////////////////schedule threads and void generate task////////////////////////////////////
    class schedule implements Runnable {

        @Override
        public void run() {
            displaypanel.removeAll();
            schedulepanel sp = new schedulepanel();
            sp.setSize(new Dimension(displaypanel.getWidth(), displaypanel.getHeight()));
            displaypanel.add(sp);
            displaypanel.repaint();
            try {
                String url = u.getOriginalProfileImageURL();
                b = ImageIO.read(new URL(url));
                BufferedImage resize = resize(b, sp.schedulephotolb.getWidth(), sp.schedulephotolb.getHeight());
                sp.schedulephotolb.setIcon(new ImageIcon(resize));
            } catch (Exception e) {
                e.printStackTrace();

            }
            sp.schedulebt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    String text = sp.schedulearea.getText();
                    if (!text.equals("")) {
                        Calendar c = Calendar.getInstance();
                        int hr = Integer.parseInt((String) sp.hourcb.getSelectedItem());
                        int min = Integer.parseInt((String) sp.minutecb.getSelectedItem());
                        c.set(Calendar.HOUR_OF_DAY, hr);
                        c.set(Calendar.MINUTE, min);
                        Calendar present = Calendar.getInstance();
                        int res = present.compareTo(c);
                        if (res < 0) {
                            ResultSet rs = dbconn.executeQuery("select * from schedule");
                            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            String time = df.format(c.getTime());
                            String sid = String.valueOf(u.getId());
                            try {
                                rs.moveToInsertRow();
                                rs.updateString("senderid", sid);
                                rs.updateString("text", text);
                                rs.updateString("time", time);
                                rs.insertRow();
                                generatetask();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }
            });
        }

    }

    public void generatetask() {

        Calendar presenttime = Calendar.getInstance();
        ResultSet rsdata = dbconn.executeQuery("select * from schedule where senderid='" + u.getId() + "'");
        System.out.println(rsdata);

        try {
            while (rsdata.next()) {
                String strtime = rsdata.getString("time");
                DateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date d = dtf.parse(strtime);
                if (d.after(presenttime.getTime())) {
                    String text = rsdata.getString("text");
                    StatusUpdate su = new StatusUpdate(text);
                    Timer t = new Timer();
                    t.schedule(new scheduletime(su), d);
                    JOptionPane.showMessageDialog(home.this, "tweet scheduled");
                } else {
                    System.out.println("time passed");
                }
            }
        } catch (Exception e) {

        }
    }

    class scheduletime extends TimerTask {

        StatusUpdate s;

        scheduletime(StatusUpdate s) {
            this.s = s;
        }

        @Override
        public void run() {
            try {
                twitter.updateStatus(s);
                JOptionPane.showMessageDialog(home.this, "tweet successfullyposted");
            } catch (Exception e) {

                e.printStackTrace();
            }

        }

    }

    //////////////////////////////////////homebt action performed//////////////////////////////////////
    class userhome implements Runnable {

        int flag;

        @Override
        public void run() {
            displaypanel.removeAll();
            loadlb.setIcon(loader);
            String colour;
            int size = 0;
            homepanel hp = new homepanel();
            hp.setSize(displaypanel.getWidth(), displaypanel.getHeight());
            hp.scrolltweet.setSize(displaypanel.getWidth() - 20, displaypanel.getHeight());
            displaypanel.add(hp);

            try {
                ResponseList<Status> homelist = twitter.getHomeTimeline();
                singlesearchtweet sst[] = new singlesearchtweet[homelist.size()];
                singlesearchtweet1 sst1[] = new singlesearchtweet1[homelist.size()];

                hp.hometweetpanel1.removeAll();;
                for (int i = 0; i < homelist.size(); i++) {

                    Status st = homelist.get(i);
                    MediaEntity[] a = st.getMediaEntities();
                    if (a.length == 0) {
                        sst1[i] = new singlesearchtweet1();
                        Date twtdate = st.getCreatedAt();
                        sst1[i].setBounds(0, size + 10, 595, 187);
                        size = size + sst1[i].getHeight();
                        User user = st.getUser();
                        String url = user.getOriginalProfileImageURL();
                        BufferedImage bi = ImageIO.read(new URL(url));
                        BufferedImage resize = resize(bi, sst1[i].searchphotolb.getWidth(), sst1[i].searchphotolb.getHeight());
                        sst1[i].searchphotolb.setIcon(new ImageIcon(resize));
                        String text = st.getText();
                        sst1[i].searchtweet.setText(text);
                        int c = st.getFavoriteCount();
                        int c1 = st.getRetweetCount();
                        sst1[i].favoritecount.setText(c + "");
                        sst1[i].retweetcount.setText(c1 + "");
                        User user1 = st.getUser();
                        String nl = user1.getName();
                        String sn = user1.getScreenName();
                        sst1[i].namelb.setText(nl);
                        sst1[i].snlb.setText("@" + sn);
                        Date dt = st.getCreatedAt();

                        String dt1 = dt.toString();
                        sst1[i].timelb.setText("." + dt1);

                        hp.hometweetpanel1.add(sst1[i]);

                        int j = i;
                        ////////////////////////////////////////////like unlike logic//////////////////////////////
                        boolean favourited = st.isFavorited();
                        if (favourited) {
                            sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n6.png"));
                            flag = 1;
                            flagal.add(flag);
                            sst1[j].favoritecount.setForeground(new Color(232, 28, 79));
                        } else {
                            sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
                            flag = 0;
                            flagal.add(flag);
                        }

                        sst1[j].likelb.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent me) {
                                int k = c;

                                try {
                                    Icon favicn = sst1[j].likelb.getIcon();
                                    String favs = favicn.toString();
                                    ////////////////////////////////////////////////////if flag==1///////////////////////////////////////////////
                                    if (flagal.get(j) == 1) {
                                        if (favs.equals(ic3)) {

                                            twitter.destroyFavorite(st.getId());
                                            k = k - 1;
                                            sst1[j].favoritecount.setText(k + "");
                                            sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
                                            sst1[j].favoritecount.setForeground(Color.black);

                                        } else if (favs.equals(ic2)) {
                                            twitter.createFavorite(st.getId());
                                            sst1[j].favoritecount.setText(k + "");
                                            sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n6.png"));
                                            sst1[j].favoritecount.setForeground(new Color(232, 28, 79));
                                        }
                                    } ///////////////////this else for flag==0////////////////////////////////////////////////////////
                                    else {

                                        if (favs.equals(ic3)) {

                                            twitter.destroyFavorite(st.getId());

                                            sst1[j].favoritecount.setText(k + "");
                                            sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
                                            sst1[j].favoritecount.setForeground(Color.black);

                                        } else if (favs.equals(ic2)) {
                                            twitter.createFavorite(st.getId());
                                            k = k + 1;
                                            sst1[j].favoritecount.setText(k + "");
                                            sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n6.png"));
                                            sst1[j].favoritecount.setForeground(new Color(232, 28, 79));
                                        }
                                    }

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                sst1[j].likelb.repaint();
                            }
                        });
                        sst1[j].likelb.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseEntered(MouseEvent me) {

                                Icon icon1 = sst1[j].likelb.getIcon();
                                String ics1 = icon1.toString();
                                if (ics1.equals(ic1)) {
                                    sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n5.png"));
                                }

                                sst1[j].favoritecount.setForeground(new Color(232, 28, 79));
                            }
                        });

                        sst1[j].likelb.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseExited(MouseEvent me) {

                                Icon icon2 = sst1[j].likelb.getIcon();
                                String ics2 = icon2.toString();
                                if (ics2.equals(ic2)) {
                                    sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
                                    sst1[j].favoritecount.setForeground(Color.black);
                                }

                            }
                        });

                        /////////////////////////////////if no medialogic ends here///////////////////////////////////////////////////////////////
                        hp.repaint();

                    } else {
                        for (MediaEntity m : a) {
                            sst[i] = new singlesearchtweet();
                            String md = m.getMediaURL();
                            BufferedImage read2 = ImageIO.read(new URL(md));
                            BufferedImage resize1 = resize(read2, sst[i].medialb.getWidth(), sst[i].medialb.getHeight());
                            sst[i].medialb.setIcon(new ImageIcon(resize1));

                            Date twtdate = st.getCreatedAt();
                            sst[i].setBounds(0, size + 10, 595, 630);
                            size = size + sst[i].getHeight();
                            User user = st.getUser();
                            String url = user.getOriginalProfileImageURL();
                            BufferedImage bi = ImageIO.read(new URL(url));
                            BufferedImage resize = resize(bi, sst[i].searchphotolb.getWidth(), sst[i].searchphotolb.getHeight());
                            sst[i].searchphotolb.setIcon(new ImageIcon(resize));
                            String text = st.getText();
                            sst[i].searchtweet.setText(text);
                            int c = st.getFavoriteCount();
                            int c1 = st.getRetweetCount();
                            sst[i].favoritecount.setText(c + "");
                            sst[i].retweetcount.setText(c1 + "");
                            User user1 = st.getUser();
                            String nl = user1.getName();
                            String sn = user1.getScreenName();
                            sst[i].namelb.setText(nl);
                            sst[i].snlb.setText("@" + sn);
                            Date dt = st.getCreatedAt();
                            String dt1 = dt.toString();
                            sst[i].timelb.setText("." + dt1);

                            hp.hometweetpanel1.add(sst[i]);

                            int j = i;
                            ////////////////////////////////////////////like unlike logic//////////////////////////////
                            boolean favourited = st.isFavorited();
                            if (favourited) {
                                sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n6.png"));
                                flag = 1;
                                flagal.add(flag);
                                sst[j].favoritecount.setForeground(new Color(232, 28, 79));
                            } else {
                                sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
                                flag = 0;
                                flagal.add(flag);
                            }

                            sst[j].likelb.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent me) {
                                    int k = c;

                                    try {
                                        Icon favicn = sst[j].likelb.getIcon();
                                        String favs = favicn.toString();
                                        ////////////////////////////////////////////////////if flag==1///////////////////////////////////////////////
                                        if (flagal.get(j) == 1) {
                                            if (favs.equals(ic3)) {

                                                twitter.destroyFavorite(st.getId());
                                                k = k - 1;
                                                sst[j].favoritecount.setText(k + "");
                                                sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
                                                sst[j].favoritecount.setForeground(Color.black);

                                            } else if (favs.equals(ic2)) {
                                                twitter.createFavorite(st.getId());
                                                sst[j].favoritecount.setText(k + "");
                                                sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n6.png"));
                                                sst[j].favoritecount.setForeground(new Color(232, 28, 79));
                                            }
                                        } ///////////////////this else for flag==0////////////////////////////////////////////////////////
                                        else {

                                            if (favs.equals(ic3)) {

                                                twitter.destroyFavorite(st.getId());

                                                sst[j].favoritecount.setText(k + "");
                                                sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
                                                sst[j].favoritecount.setForeground(Color.black);

                                            } else if (favs.equals(ic2)) {
                                                twitter.createFavorite(st.getId());
                                                k = k + 1;
                                                sst[j].favoritecount.setText(k + "");
                                                sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n6.png"));
                                                sst[j].favoritecount.setForeground(new Color(232, 28, 79));
                                            }
                                        }

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    sst[j].likelb.repaint();
                                }
                            });
                            sst[j].likelb.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseEntered(MouseEvent me) {

                                    Icon icon1 = sst[j].likelb.getIcon();
                                    String ics1 = icon1.toString();
                                    if (ics1.equals(ic1)) {
                                        sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n5.png"));
                                    }

                                    sst[j].favoritecount.setForeground(new Color(232, 28, 79));
                                }
                            });

                            sst[j].likelb.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseExited(MouseEvent me) {

                                    Icon icon2 = sst[j].likelb.getIcon();
                                    String ics2 = icon2.toString();
                                    if (ics2.equals(ic2)) {
                                        sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
                                        sst[j].favoritecount.setForeground(Color.black);
                                    }

                                }
                            });

                        }
                        hp.repaint();
                    }

                }
                hp.hometweetpanel.setPreferredSize(new Dimension(595, size + 10));
                hp.hometweetpanel1.setPreferredSize(new Dimension(595, size + 10));

                highpanel.setEnabled(true);
                toppanel.setEnabled(true);
                sidepanel.setEnabled(true);

                loadlb.setIcon(twtr);
                postbtmain.setEnabled(true);
                homebtmain.setEnabled(true);
                dmbt.setEnabled(true);
                profilebtmain.setEnabled(true);
                schedulebtmain.setEnabled(true);
                alertbtmain.setEnabled(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
            displaypanel.repaint();
        }
    }

/////////////////////////////////////////////////user home ends here///////////////////////////////////////////////////
////////////////uploadbtactionperformed thread/////////////////////////////////////////
    class upload implements Runnable {

        File f;

        upload(File f) {
            this.f = f;
        }

        @Override
        public void run() {
            try {
                User pic = twitter.updateProfileImage(f);
                String pic1 = pic.getOriginalProfileImageURL();
                BufferedImage read = ImageIO.read(new URL(pic1));
                BufferedImage resize = resize(read, profilelb.getWidth(), profilelb.getHeight());
                profilelb.setIcon(new ImageIcon(resize));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
////////////////////////////////////////////////////////////search listener started//////////////////////////////////////

    class search implements Runnable {

        int flag;

        @Override
        public void run() {
            displaypanel.removeAll();
            String colour;
            int size = 0;
            User user;
            singlesearchpanel ssp = new singlesearchpanel();
            ssp.setSize(displaypanel.getWidth(), displaypanel.getHeight());
            ssp.scrolltweet.setSize(displaypanel.getWidth() - 20, displaypanel.getHeight());

            displaypanel.add(ssp);
            displaypanel.repaint();
            try {
                String name = searchfield.getText();
                searchfield.setText("Enter username to search");
                ResponseList<Status> homelist = twitter.getUserTimeline(name);
                singlesearchtweet sst[] = new singlesearchtweet[homelist.size()];
                singlesearchtweet1 sst1[] = new singlesearchtweet1[homelist.size()];

                ssp.searchpanel.removeAll();;
                for (int i = 0; i < homelist.size(); i++) {

                    Status st = homelist.get(i);
                    MediaEntity[] a = st.getMediaEntities();
                    if (a.length == 0) {
                        sst1[i] = new singlesearchtweet1();
                        Date twtdate = st.getCreatedAt();
                        sst1[i].setBounds(0, size + 10, 595, 187);
                        size = size + sst1[i].getHeight();
                        user = st.getUser();
                        String url = user.getOriginalProfileImageURL();
                        BufferedImage bi = ImageIO.read(new URL(url));
                        BufferedImage resize = resize(bi, sst1[i].searchphotolb.getWidth(), sst1[i].searchphotolb.getHeight());
                        sst1[i].searchphotolb.setIcon(new ImageIcon(resize));
                        String text = st.getText();
                        sst1[i].searchtweet.setText(text);
                        int c = st.getFavoriteCount();
                        int c1 = st.getRetweetCount();
                        sst1[i].favoritecount.setText(c + "");
                        sst1[i].retweetcount.setText(c1 + "");
                        User user1 = st.getUser();
                        String nl = user1.getName();
                        String sn = user1.getScreenName();
                        sst1[i].namelb.setText(nl);
                        sst1[i].snlb.setText("@" + sn);
                        Date dt = st.getCreatedAt();
                        String dt1 = dt.toString();
                        sst1[i].timelb.setText("." + dt1);

                        ssp.searchpanel.add(sst1[i]);

                        int j = i;
                        ////////////////////////////////////////////like unlike logic//////////////////////////////
                        boolean favourited = st.isFavorited();
                        if (favourited) {
                            sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n6.png"));
                            flag = 1;
                            flagal.add(flag);
                            sst1[j].favoritecount.setForeground(new Color(232, 28, 79));
                        } else {
                            sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
                            flag = 0;
                            flagal.add(flag);
                        }

                        sst1[j].likelb.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent me) {
                                int k = c;

                                try {
                                    Icon favicn = sst1[j].likelb.getIcon();
                                    String favs = favicn.toString();
                                    ////////////////////////////////////////////////////if flag==1///////////////////////////////////////////////
                                    if (flagal.get(j) == 1) {
                                        if (favs.equals(ic3)) {

                                            twitter.destroyFavorite(st.getId());
                                            k = k - 1;
                                            sst1[j].favoritecount.setText(k + "");
                                            sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
                                            sst1[j].favoritecount.setForeground(Color.black);

                                        } else if (favs.equals(ic2)) {
                                            twitter.createFavorite(st.getId());
                                            sst1[j].favoritecount.setText(k + "");
                                            sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n6.png"));
                                            sst1[j].favoritecount.setForeground(new Color(232, 28, 79));
                                        }
                                    } ///////////////////this else for flag==0////////////////////////////////////////////////////////
                                    else {

                                        if (favs.equals(ic3)) {

                                            twitter.destroyFavorite(st.getId());

                                            sst1[j].favoritecount.setText(k + "");
                                            sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
                                            sst1[j].favoritecount.setForeground(Color.black);

                                        } else if (favs.equals(ic2)) {
                                            twitter.createFavorite(st.getId());
                                            k = k + 1;
                                            sst1[j].favoritecount.setText(k + "");
                                            sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n6.png"));
                                            sst1[j].favoritecount.setForeground(new Color(232, 28, 79));
                                        }
                                    }

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                sst1[j].likelb.repaint();
                            }
                        });
                        sst1[j].likelb.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseEntered(MouseEvent me) {

                                Icon icon1 = sst1[j].likelb.getIcon();
                                String ics1 = icon1.toString();
                                if (ics1.equals(ic1)) {
                                    sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n5.png"));
                                }

                                sst1[j].favoritecount.setForeground(new Color(232, 28, 79));
                            }
                        });

                        sst1[j].likelb.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseExited(MouseEvent me) {

                                Icon icon2 = sst1[j].likelb.getIcon();
                                String ics2 = icon2.toString();
                                if (ics2.equals(ic2)) {
                                    sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
                                    sst1[j].favoritecount.setForeground(Color.black);
                                }

                            }
                        });

                        /////////////////////////////////if no medialogic ends here///////////////////////////////////////////////////////////////
                        ssp.repaint();

                    } else {
                        for (MediaEntity m : a) {
                            sst[i] = new singlesearchtweet();
                            String md = m.getMediaURL();
                            BufferedImage read2 = ImageIO.read(new URL(md));
                            BufferedImage resize1 = resize(read2, sst[i].medialb.getWidth(), sst[i].medialb.getHeight());
                            sst[i].medialb.setIcon(new ImageIcon(resize1));

                            Date twtdate = st.getCreatedAt();
                            sst[i].setBounds(0, size + 10, 595, 630);
                            size = size + sst[i].getHeight();
                            user = st.getUser();
                            String url = user.getOriginalProfileImageURL();
                            BufferedImage bi = ImageIO.read(new URL(url));
                            BufferedImage resize = resize(bi, sst[i].searchphotolb.getWidth(), sst[i].searchphotolb.getHeight());
                            sst[i].searchphotolb.setIcon(new ImageIcon(resize));
                            String text = st.getText();
                            sst[i].searchtweet.setText(text);
                            int c = st.getFavoriteCount();
                            int c1 = st.getRetweetCount();
                            sst[i].favoritecount.setText(c + "");
                            sst[i].retweetcount.setText(c1 + "");
                            User user1 = st.getUser();
                            String nl = user1.getName();
                            String sn = user1.getScreenName();
                            sst[i].namelb.setText(nl);
                            sst[i].snlb.setText("@" + sn);
                            Date dt = st.getCreatedAt();
                            String dt1 = dt.toString();
                            sst[i].timelb.setText("." + dt1);

                            ssp.searchpanel.add(sst[i]);

                            int j = i;
                            ////////////////////////////////////////////like unlike logic//////////////////////////////
                            boolean favourited = st.isFavorited();
                            if (favourited) {
                                sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n6.png"));
                                flag = 1;
                                flagal.add(flag);
                                sst[j].favoritecount.setForeground(new Color(232, 28, 79));
                            } else {
                                sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
                                flag = 0;
                                flagal.add(flag);
                            }

                            sst[j].likelb.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent me) {
                                    int k = c;

                                    try {
                                        Icon favicn = sst[j].likelb.getIcon();
                                        String favs = favicn.toString();
                                        ////////////////////////////////////////////////////if flag==1///////////////////////////////////////////////
                                        if (flagal.get(j) == 1) {
                                            if (favs.equals(ic3)) {

                                                twitter.destroyFavorite(st.getId());
                                                k = k - 1;
                                                sst[j].favoritecount.setText(k + "");
                                                sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
                                                sst[j].favoritecount.setForeground(Color.black);

                                            } else if (favs.equals(ic2)) {
                                                twitter.createFavorite(st.getId());
                                                sst[j].favoritecount.setText(k + "");
                                                sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n6.png"));
                                                sst[j].favoritecount.setForeground(new Color(232, 28, 79));
                                            }
                                        } ///////////////////this else for flag==0////////////////////////////////////////////////////////
                                        else {

                                            if (favs.equals(ic3)) {

                                                twitter.destroyFavorite(st.getId());

                                                sst[j].favoritecount.setText(k + "");
                                                sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
                                                sst[j].favoritecount.setForeground(Color.black);

                                            } else if (favs.equals(ic2)) {
                                                twitter.createFavorite(st.getId());
                                                k = k + 1;
                                                sst[j].favoritecount.setText(k + "");
                                                sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n6.png"));
                                                sst[j].favoritecount.setForeground(new Color(232, 28, 79));
                                            }
                                        }

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    sst[j].likelb.repaint();
                                }
                            });
                            sst[j].likelb.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseEntered(MouseEvent me) {

                                    Icon icon1 = sst[j].likelb.getIcon();
                                    String ics1 = icon1.toString();
                                    if (ics1.equals(ic1)) {
                                        sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n5.png"));
                                    }

                                    sst[j].favoritecount.setForeground(new Color(232, 28, 79));
                                }
                            });

                            sst[j].likelb.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseExited(MouseEvent me) {

                                    Icon icon2 = sst[j].likelb.getIcon();
                                    String ics2 = icon2.toString();
                                    if (ics2.equals(ic2)) {
                                        sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
                                        sst[j].favoritecount.setForeground(Color.black);
                                    }

                                }
                            });

                        }
                        ssp.repaint();
                    }
                }
                ssp.searchpanel.setPreferredSize(new Dimension(595, size + 10));
                ssp.searchpanel1.setPreferredSize(new Dimension(595, size + 10));
            } catch (Exception e) {
                e.printStackTrace();
            }
            displaypanel.repaint();
/////////////////////////////////////////dm./////////////////////////////////////////

            /*ssp.dmbt.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent ae) {
String msg=JOptionPane.showInputDialog(home.this,"enter your message");
                  if(msg!=null)
                  {
    try {
      twitter.sendDirectMessage(user.getId(),msg);
    
    } catch(Exception ex) {
     ex.printStackTrace();
    }
                  }
                  
                  
                  
                  
              }
          });

Relationship relation=twitter.showFriendship(u.getId(),user.getId());
boolean result=relation.isSourceFollowingTarget();
if(result)
{
    ssp.followbt.setText("unfollow");
    ssp.dmbt.setEnabled(true);
}
else
{
    ssp.followbt.setText("follow");
      ssp.dmbt.setEnabled(false);
}
     /* ssp.followbt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
new Thread(new Runnable(){
    @Override
    public void run() {
    try{
        if(result)
{
    twitter.destroyFriendship(searchuser.getId());
    ssp.followbt.setText("follow");
      ssp.dmbt.setEnabled(false);
}
else
{
    twitter.createFriendship(searchuser.getId());
    ssp.followbt.setText("unfollow");
      ssp.dmbt.setEnabled(true);
}

    
  }
  catch(Exception e)
  {
      e.printStackTrace();
  }



                }
               
            }).start();
                }
                });*/
            loadlb.setIcon(twtr);
        }
    }

/////tweet text thread////////////////////// /////////////////////////////////////////////////////////////////////
    class tweet implements Runnable {

        String tweet;

        tweet(String tweet) {
            this.tweet = tweet;
        }

        @Override
        public void run() {
            StatusUpdate su = new StatusUpdate(tweet);
            try {
                twitter.updateStatus(su);
            } catch (TwitterException ex) {
                Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    ////////////// tweet photo thread///////////////////////

    class phototweet implements Runnable {

        StatusUpdate su1;

        phototweet(StatusUpdate su1) {
            this.su1 = su1;
        }

        @Override
        public void run() {
            try {
                twitter.updateStatus(su1);
                f.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    ///////////////////post tweet threads ends heree///////////////////////////////////////
//////////////////////loc phototweet////////////////////

    class locphototweet implements Runnable {

        StatusUpdate su1;

        locphototweet(StatusUpdate su1) {
            this.su1 = su1;
        }

        @Override
        public void run() {
            try {
                twitter.updateStatus(su1);
                f1.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alertbtmain;
    public javax.swing.JPanel displaypanel;
    private javax.swing.JButton dmbt;
    private javax.swing.JLabel folllowinglb;
    private javax.swing.JLabel followercount;
    private javax.swing.JLabel followerlb;
    private javax.swing.JLabel followingcount;
    private javax.swing.JLabel headerlb;
    private javax.swing.JPanel headerpanel;
    private javax.swing.JPanel highpanel;
    private javax.swing.JLabel home1lb;
    private javax.swing.JLabel home2lb;
    public javax.swing.JButton homebtmain;
    private javax.swing.JLabel homelb1;
    private javax.swing.JLabel homelb2;
    private javax.swing.JLabel loadlb;
    private javax.swing.JButton postbtmain;
    private javax.swing.JButton profilebtmain;
    private javax.swing.JLabel profilelb;
    private javax.swing.JLabel refreshlb;
    private javax.swing.JButton schedulebtmain;
    private javax.swing.JTextField searchfield;
    private javax.swing.JLabel searchicon;
    private javax.swing.JLabel searchlb;
    private javax.swing.JButton sendtweet;
    private javax.swing.JPanel sidepanel;
    private javax.swing.JPanel toppanel;
    private javax.swing.JLabel tweetcount;
    private javax.swing.JLabel tweetlb;
    public javax.swing.JButton uploadbt;
    // End of variables declaration//GEN-END:variables

}
