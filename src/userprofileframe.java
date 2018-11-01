
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import twitter4j.IDs;
import twitter4j.MediaEntity;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.User;


public class userprofileframe extends javax.swing.JFrame {

    Twitter twitter;
BufferedImage b;
User u;
ArrayList<Integer>flagal=new ArrayList<>();
ArrayList<Integer>flagal1=new ArrayList<>();
 Icon icn1=new ImageIcon("src\\folder\\n3.png");
 String ic1=icn1.toString();
 Icon icn2=new ImageIcon("src\\folder\\n5.png");
 String ic2=icn2.toString();
 Icon icn3=new ImageIcon("src\\folder\\n6.png");
 String ic3=icn3.toString();
 Color bl=new Color(29,161,242);
 Color gr=new Color(102,102,102);


    public userprofileframe(Twitter twitter) {
        initComponents();
this.twitter=twitter;
getContentPane().setBackground(Color.white);
    Image icon=Toolkit.getDefaultToolkit().getImage("src\\folder\\icn.png");
setIconImage(icon);
        Thread t1=new Thread(new homedatafetch());
t1.start();
        Thread t2=new Thread(new userhome());
        t2.start();
         ln1.setVisible(true); 
        ln2.setVisible(false); 
        ln3.setVisible(false); 
        ln4.setVisible(false); 
         ///  Dimension size=Toolkit.getDefaultToolkit().getScreenSize(); 
setSize(1366,768);
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

    //////////////////////////////////////////////class homefetch//////////////////////////////////
     class homedatafetch implements Runnable
    {


        @Override
        public void run() {
          
          try
          {
           u=  twitter.verifyCredentials();
            lb5.setText(u.getName()+"");
           
           lb6.setText("@"+u.getScreenName());
           lb3.setText(u.getFollowersCount()+"");
            lb2.setText(u.getFriendsCount()+"");
            lb1.setText(u.getStatusesCount()+"");
             lb4.setText(u.getFavouritesCount()+"");
            String s=u.getOriginalProfileImageURL();
            b=ImageIO.read(new URL(s));
            BufferedImage resizepic=resize(b,dplb.getWidth(),dplb.getHeight());
             dplb.setIcon(new ImageIcon(resizepic));
            BufferedImage resizepicc=resize(b,profilepic.getWidth(),profilepic.getHeight());
             profilepic.setIcon(new ImageIcon(resizepicc));
      String s2= u.getProfileBannerURL();
                  if(s2!=null)
                  {
                    
                      BufferedImage bi1 = ImageIO.read(new URL(s2));                      
                      BufferedImage resizepic1=resize(bi1,p2lb.getWidth(),p2lb.getHeight());
                   p2lb.setIcon(new ImageIcon(resizepic1));
                                  }
                  else
                  {
                    p2.setBackground(new Color(29,161,242));
                  }
        p3.repaint();
            repaint();
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }
         }

            }
    ///////////////////////////////////////////home panel/////////////////////////
      class userhome implements Runnable
{
       int flag;
      
        @Override
        public void run() {

String colour;
int size=0;
            homepanel hp=new homepanel();
///hp.setBounds(-200,0,userdisplay.getWidth()+170,userdisplay.getHeight());
hp.setSize(userdisplay.getWidth(),userdisplay.getHeight());
hp.scrolltweet.setBounds(-120,0,hp.getWidth()+100,hp.getHeight());
hp.hometweetpanel.setBackground(Color.white);
hp.scrolltweet.setBackground(Color.white);
userdisplay.add(hp);
userdisplay.repaint();
try
{
            ResponseList<Status> homelist = twitter.getUserTimeline();
            singlesearchtweet sst[]=new singlesearchtweet[homelist.size()];
            singlesearchtweet1 sst1[]=new singlesearchtweet1[homelist.size()];
if(homelist.size()!=0){
         hp.hometweetpanel1.removeAll();;
            for(int i=0;i<homelist.size();i++)
            {


Status st=homelist.get(i);
    MediaEntity[] a = st.getMediaEntities();
                if(a.length==0)
                {
                    sst1[i]=new singlesearchtweet1();
    Date twtdate = st.getCreatedAt();
    sst1[i].setBounds(0,size+10,595,187);
       size=size+sst1[i].getHeight();
   User user = st.getUser();
                String url = user.getOriginalProfileImageURL();
                
                BufferedImage bi = ImageIO.read(new URL(url));
                BufferedImage resize = resize(bi,sst1[i].searchphotolb.getWidth(),sst1[i].searchphotolb.getHeight());
                   sst1[i].searchphotolb.setIcon(new ImageIcon(resize));
                String text = st.getText();
                sst1[i].searchtweet.setText(text);
                             int c=st.getFavoriteCount();
                int c1=st.getRetweetCount();
                sst1[i].favoritecount.setText(c+"");
                sst1[i].retweetcount.setText(c1+"");
    User user1 = st.getUser();
    String nl=user1.getName();
    String sn=user1.getScreenName();
                sst1[i].namelb.setText(nl);
                sst1[i].snlb.setText("@"+sn);
    Date dt = st.getCreatedAt();
    String dt1=dt.toString();
    sst1[i].timelb.setText("."+dt1);

                 hp.hometweetpanel1.add(sst1[i]);

         int j=i;
                   ////////////////////////////////////////////like unlike logic//////////////////////////////
                    boolean favourited=st.isFavorited();
         if(favourited)
         {
             sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n6.png"));
             flag=1;
             flagal.add(flag);
                sst1[j].favoritecount.setForeground(new Color(232,28,79));
         }
         else
         {
             sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
             flag=0;
     flagal.add(flag);
         }

         sst1[j].likelb.addMouseListener(new MouseAdapter() {
                  @Override
                  public void mouseClicked(MouseEvent me) {
             int k=c;


    try{       
                       Icon favicn = sst1[j].likelb.getIcon();
                       String favs=favicn.toString();
             ////////////////////////////////////////////////////if flag==1///////////////////////////////////////////////
                       if(flagal.get(j)==1)
              {
if(favs.equals(ic3))
{

   twitter.destroyFavorite(st.getId());
   k=k-1;
   sst1[j].favoritecount.setText(k+"");
        sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
              sst1[j].favoritecount.setForeground(Color.black);      

        }
else if(favs.equals(ic2))
        {
    twitter.createFavorite(st.getId());
       sst1[j].favoritecount.setText(k+"");
       sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n6.png"));
       sst1[j].favoritecount.setForeground(new Color(232,28,79));      
        }
              }
              ///////////////////this else for flag==0////////////////////////////////////////////////////////
               else
              {
                 
if(favs.equals(ic3))
{
    
   twitter.destroyFavorite(st.getId());

   sst1[j].favoritecount.setText(k+"");
        sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
              sst1[j].favoritecount.setForeground(Color.black);      
    
        }
else if(favs.equals(ic2))
        {
    twitter.createFavorite(st.getId());
   k=k+1;
       sst1[j].favoritecount.setText(k+"");
       sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n6.png"));
       sst1[j].favoritecount.setForeground(new Color(232,28,79));      
  }}
                       
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
             sst1[j].likelb.repaint();
                  }});
        sst1[j].likelb.addMouseListener(new MouseAdapter() {
                  @Override
                  public void mouseEntered(MouseEvent me) {
          
                      Icon icon1= sst1[j].likelb.getIcon();
String ics1=icon1.toString();
        if(ics1.equals(ic1))
        {
            sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n5.png"));
        }    
        
        sst1[j].favoritecount.setForeground(new Color(232,28,79));
            }});
        
        
           sst1[j].likelb.addMouseListener(new MouseAdapter() {
                  @Override
                  public void mouseExited(MouseEvent me) {
          
                   Icon icon2= sst1[j].likelb.getIcon();
String ics2=icon2.toString();
        if(ics2.equals(ic2))
        {
            sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
                 sst1[j].favoritecount.setForeground(Color.black);
        }       
                  
                  
                  
                  
                  
                  }});
      
                   
                   
                   
                   
                   /////////////////////////////////if no medialogic ends here///////////////////////////////////////////////////////////////
                  
             
                 hp.repaint();
   
                }
                
                else
                {
                for(MediaEntity m:a)
                {
                    sst[i]=new singlesearchtweet();
                         String md=m.getMediaURL();
                             BufferedImage read2 = ImageIO.read(new URL(md));
                             BufferedImage resize1 = resize(read2,sst[i].medialb.getWidth(),sst[i].medialb.getHeight());
                             sst[i].medialb.setIcon(new ImageIcon(resize1));
                         
    Date twtdate = st.getCreatedAt();
    sst[i].setBounds(0,size+10,595,630);
       size=size+sst[i].getHeight();
   User user = st.getUser();
                String url = user.getOriginalProfileImageURL();
                try{
                BufferedImage bi = ImageIO.read(new URL(url));
                BufferedImage resize = resize(bi,sst[i].searchphotolb.getWidth(),sst[i].searchphotolb.getHeight());
                   sst[i].searchphotolb.setIcon(new ImageIcon(resize));
              
                }
                catch(Exception e)
                {
                    
                }
               String text = st.getText();
                sst[i].searchtweet.setText(text);
                             int c=st.getFavoriteCount();
                int c1=st.getRetweetCount();
                sst[i].favoritecount.setText(c+"");
                sst[i].retweetcount.setText(c1+"");
    User user1 = st.getUser();
    String nl=user1.getName();
    String sn=user1.getScreenName();
                sst[i].namelb.setText(nl);
                sst[i].snlb.setText("@"+sn);
    Date dt = st.getCreatedAt();
    String dt1=dt.toString();
    sst[i].timelb.setText("."+dt1);
    
                 hp.hometweetpanel1.add(sst[i]);
          
         int j=i;
                   ////////////////////////////////////////////like unlike logic//////////////////////////////
                    boolean favourited=st.isFavorited();
         if(favourited)
         {
             sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n6.png"));
             flag=1;
             flagal.add(flag);
                sst[j].favoritecount.setForeground(new Color(232,28,79));
         }
         else
         {
             sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
             flag=0;
     flagal.add(flag);
         }
  
         sst[j].likelb.addMouseListener(new MouseAdapter() {
                  @Override
                  public void mouseClicked(MouseEvent me) {
             int k=c;
          
  
    try{       
                       Icon favicn = sst[j].likelb.getIcon();
                       String favs=favicn.toString();
             ////////////////////////////////////////////////////if flag==1///////////////////////////////////////////////
                       if(flagal.get(j)==1)
              {
if(favs.equals(ic3))
{
    
   twitter.destroyFavorite(st.getId());
   k=k-1;
   sst[j].favoritecount.setText(k+"");
        sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
              sst[j].favoritecount.setForeground(Color.black);      
    
        }
else if(favs.equals(ic2))
        {
    twitter.createFavorite(st.getId());
       sst[j].favoritecount.setText(k+"");
       sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n6.png"));
       sst[j].favoritecount.setForeground(new Color(232,28,79));      
        }
              }
              ///////////////////this else for flag==0////////////////////////////////////////////////////////
               else
              {
                 
if(favs.equals(ic3))
{
    
   twitter.destroyFavorite(st.getId());

   sst[j].favoritecount.setText(k+"");
        sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
              sst[j].favoritecount.setForeground(Color.black);      
    
        }
else if(favs.equals(ic2))
        {
    twitter.createFavorite(st.getId());
   k=k+1;
       sst[j].favoritecount.setText(k+"");
       sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n6.png"));
       sst[j].favoritecount.setForeground(new Color(232,28,79));      
  }}
                       
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
             sst[j].likelb.repaint();
                  }});
        sst[j].likelb.addMouseListener(new MouseAdapter() {
                  @Override
                  public void mouseEntered(MouseEvent me) {
          
                      Icon icon1= sst[j].likelb.getIcon();
String ics1=icon1.toString();
        if(ics1.equals(ic1))
        {
            sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n5.png"));
        }    
        
        sst[j].favoritecount.setForeground(new Color(232,28,79));
            }});
        
        
           sst[j].likelb.addMouseListener(new MouseAdapter() {
                  @Override
                  public void mouseExited(MouseEvent me) {
          
                   Icon icon2= sst[j].likelb.getIcon();
String ics2=icon2.toString();
        if(ics2.equals(ic2))
        {
            sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
                 sst[j].favoritecount.setForeground(Color.black);
        }       
                  
                  
                  
                  
                  
                  }});
   
                }
                hp.repaint();
                    }
            
                                    }
        
    hp.hometweetpanel1.setPreferredSize(new Dimension(595,size+10));
     hp.hometweetpanel.setPreferredSize(new Dimension(595,size+10)); 
    repaint();
}
else
{
    statusnullnotif stf=new statusnullnotif();
    userdisplay.add(stf);
    stf.setBounds(40,40,stf.getWidth(),stf.getHeight());
}
            }

            catch(Exception e)
                    {
                    e.printStackTrace();
                    }
userdisplay.repaint();
        }}
    
/////////////////////////////////////////////////user home ends here///////////////////////////////////////////////////
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p1 = new javax.swing.JPanel();
        searchfield = new javax.swing.JTextField();
        profilepic = new javax.swing.JLabel();
        searchicon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        refreshlb = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dplb = new javax.swing.JLabel();
        p2 = new javax.swing.JPanel();
        p2lb = new javax.swing.JLabel();
        p3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        ln1 = new javax.swing.JLabel();
        ln2 = new javax.swing.JLabel();
        ln3 = new javax.swing.JLabel();
        ln4 = new javax.swing.JLabel();
        userdisplay = new javax.swing.JPanel();
        lb5 = new javax.swing.JLabel();
        lb6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        p1.setBackground(new java.awt.Color(255, 255, 255));
        p1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        p1.setLayout(null);

        searchfield.setBackground(new java.awt.Color(204, 240, 255));
        searchfield.setFont(new java.awt.Font("Vani", 0, 14)); // NOI18N
        searchfield.setForeground(new java.awt.Color(153, 153, 153));
        searchfield.setText("Enter Username To search");
        searchfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 161, 242), 2));
        searchfield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchfieldMouseClicked(evt);
            }
        });
        searchfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchfieldActionPerformed(evt);
            }
        });
        p1.add(searchfield);
        searchfield.setBounds(850, 20, 230, 30);
        p1.add(profilepic);
        profilepic.setBounds(1140, 0, 80, 80);

        searchicon.setIcon(new javax.swing.ImageIcon("C:\\Users\\PARAM\\Documents\\A\\s2.png")); // NOI18N
        searchicon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchiconMouseClicked(evt);
            }
        });
        p1.add(searchicon);
        searchicon.setBounds(1090, 10, 50, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/twitmain.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        p1.add(jLabel1);
        jLabel1.setBounds(580, 0, 80, 80);

        refreshlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh1.png"))); // NOI18N
        refreshlb.setText("jLabel7");
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
        p1.add(refreshlb);
        refreshlb.setBounds(50, 0, 80, 80);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/close3.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        p1.add(jLabel6);
        jLabel6.setBounds(1260, 0, 90, 80);

        getContentPane().add(p1);
        p1.setBounds(0, 0, 1366, 80);

        dplb.setText("jLabel1");
        dplb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        getContentPane().add(dplb);
        dplb.setBounds(150, 180, 230, 230);

        p2.setBackground(new java.awt.Color(29, 161, 242));
        p2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        p2.setLayout(null);

        p2lb.setBackground(new java.awt.Color(29, 161, 242));
        p2lb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        p2.add(p2lb);
        p2lb.setBounds(0, 0, 1366, 200);

        getContentPane().add(p2);
        p2.setBounds(0, 80, 1366, 200);

        p3.setBackground(new java.awt.Color(255, 255, 255));
        p3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        p3.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Tweets");
        p3.add(jLabel2);
        jLabel2.setBounds(420, 10, 110, 30);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Following");
        p3.add(jLabel3);
        jLabel3.setBounds(560, 10, 140, 30);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Followers ");
        p3.add(jLabel4);
        jLabel4.setBounds(740, 10, 140, 30);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Likes");
        p3.add(jLabel5);
        jLabel5.setBounds(920, 10, 110, 30);

        lb1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lb1.setForeground(new java.awt.Color(102, 102, 102));
        lb1.setText("5");
        lb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb1MouseExited(evt);
            }
        });
        p3.add(lb1);
        lb1.setBounds(460, 40, 50, 40);

        lb2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lb2.setForeground(new java.awt.Color(102, 102, 102));
        lb2.setText("5");
        lb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb2MouseExited(evt);
            }
        });
        p3.add(lb2);
        lb2.setBounds(610, 40, 50, 40);

        lb3.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lb3.setForeground(new java.awt.Color(102, 102, 102));
        lb3.setText("5");
        lb3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb3MouseExited(evt);
            }
        });
        p3.add(lb3);
        lb3.setBounds(790, 40, 50, 40);

        lb4.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lb4.setForeground(new java.awt.Color(102, 102, 102));
        lb4.setText("5");
        lb4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb4MouseExited(evt);
            }
        });
        p3.add(lb4);
        lb4.setBounds(940, 40, 50, 40);

        ln1.setForeground(new java.awt.Color(29, 161, 242));
        ln1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 161, 242), 4, true));
        p3.add(ln1);
        ln1.setBounds(400, 87, 130, 3);

        ln2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 161, 242), 4, true));
        p3.add(ln2);
        ln2.setBounds(530, 87, 170, 3);

        ln3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 161, 242), 4, true));
        p3.add(ln3);
        ln3.setBounds(705, 87, 170, 3);

        ln4.setForeground(new java.awt.Color(29, 161, 242));
        ln4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 161, 242), 3, true));
        p3.add(ln4);
        ln4.setBounds(880, 87, 135, 3);

        getContentPane().add(p3);
        p3.setBounds(0, 280, 1366, 90);

        userdisplay.setBackground(new java.awt.Color(255, 255, 255));
        userdisplay.setLayout(null);
        getContentPane().add(userdisplay);
        userdisplay.setBounds(394, 372, 970, 400);

        lb5.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lb5.setText("fded");
        getContentPane().add(lb5);
        lb5.setBounds(180, 420, 220, 40);

        lb6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lb6.setText("jLabel6");
        getContentPane().add(lb6);
        lb6.setBounds(180, 470, 230, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lb1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb1MouseEntered
lb1.setForeground(bl);
ln1.setVisible(true);
    }//GEN-LAST:event_lb1MouseEntered

    private void lb2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb2MouseEntered
lb2.setForeground(bl);
        ln2.setVisible(true);
    }//GEN-LAST:event_lb2MouseEntered

    private void lb3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb3MouseEntered
     lb3.setForeground(bl);
        ln3.setVisible(true);
        
    }//GEN-LAST:event_lb3MouseEntered

    private void lb4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb4MouseEntered
    lb4.setForeground(bl);
        ln4.setVisible(true);
    }//GEN-LAST:event_lb4MouseEntered

    private void lb2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb2MouseExited
 lb2.setForeground(gr);
        ln2.setVisible(false);
    
    }//GEN-LAST:event_lb2MouseExited

    private void lb3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb3MouseExited
    lb3.setForeground(gr);
        ln3.setVisible(false);
       
    }//GEN-LAST:event_lb3MouseExited

    private void lb4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb4MouseExited
     lb4.setForeground(gr);
        ln4.setVisible(false);
    
  
    }//GEN-LAST:event_lb4MouseExited

    private void lb1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb1MouseExited
lb1.setForeground(gr);
        ln1.setVisible(false);
    
    }//GEN-LAST:event_lb1MouseExited

    private void searchfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchfieldActionPerformed

    private void lb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb2MouseClicked
    Thread fwing=new Thread(new following());
    fwing.start();
            }
    class following implements Runnable
    {
            @Override
            public void run() {
                try{
                    userdisplay.removeAll();
                    userdisplay.repaint();
                    followingpanel fp=new followingpanel();
                   fp.setBounds(-90,0,userdisplay.getWidth()+70,userdisplay.getHeight());
                 
                  fp.jScrollPane1.setSize(fp.getWidth(),fp.getHeight());
                    userdisplay.add(fp);
                    userdisplay.repaint();
fp.repaint();
                    IDs friends=twitter.getFriendsIDs(-1);
                    long[] id=friends.getIDs();

                    int y=20;
                    for(int j=0;j<id.length;j++)
                    {
                        User user=twitter.showUser(id[j]);
                        singleprofilepanel spp=new singleprofilepanel();

                        spp.setBounds(104,276*j+40*j+y,292,276);
                        y=0;
                        spp.prnm.setText(user.getName());
                        fp.friendpanel.add(spp);
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

                    }
fp.repaint();
                    fp.friendpanel.setPreferredSize(new Dimension(fp.friendpanel.getWidth(),300*id.length));
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                ////userdisplay.repaint();

           
            }
    }//GEN-LAST:event_lb2MouseClicked

    private void lb3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb3MouseClicked
    
    Thread fwer=new Thread(new follower());
    fwer.start();
    }
    class follower implements Runnable
    {
            @Override
            public void run() {
                try{
                    userdisplay.removeAll();
                    userdisplay.repaint();
                    followingpanel fp=new followingpanel();
                      fp.setBounds(-90,0,userdisplay.getWidth()+70,userdisplay.getHeight());

                  fp.jScrollPane1.setSize(fp.getWidth(),fp.getHeight());
                    userdisplay.add(fp);
                    userdisplay.repaint();
fp.repaint();
                    IDs friends=twitter.getFollowersIDs(-1);
                    long[] id=friends.getIDs();

                    int y=20;
                    for(int j=0;j<id.length;j++)
                    {
                        User user=twitter.showUser(id[j]);
                        singleprofilepanel spp=new singleprofilepanel();

                        spp.setBounds(104,276*j+40*j+y,292,276);
                        y=0;
                        spp.prnm.setText(user.getName());
                        fp.friendpanel.add(spp);
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

                    }
fp.repaint();
                    fp.friendpanel.setPreferredSize(new Dimension(fp.friendpanel.getWidth(),300*id.length));
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                ////userdisplay.repaint();

            }

    }//GEN-LAST:event_lb3MouseClicked

    private void refreshlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshlbMouseClicked
             dispose();
        new userprofileframe(twitter).setVisible(true);
          
    }//GEN-LAST:event_refreshlbMouseClicked

    private void refreshlbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshlbMouseEntered
             Border br=BorderFactory.createLineBorder(new Color(30,21,90),1);
       refreshlb.setBorder(br);
    }//GEN-LAST:event_refreshlbMouseEntered

    private void refreshlbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshlbMouseExited
          refreshlb.setBorder(null);     // TODO add your handling code here:
    }//GEN-LAST:event_refreshlbMouseExited

    private void searchfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchfieldMouseClicked
       searchfield.setText("");
   
    searchfield.setForeground(new Color(30,21,90));
    }//GEN-LAST:event_searchfieldMouseClicked

    private void searchiconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchiconMouseClicked
 Thread sr=new Thread(new search());
        dispose();
 sr.start();
    }//GEN-LAST:event_searchiconMouseClicked

    private void searchfieldMouseEntered(java.awt.event.MouseEvent evt) {                                         
     Border br=BorderFactory.createLineBorder(new Color(30,21,90),2);
        searchfield.setBorder(br);
    }                                        

    private void searchfieldMouseExited(java.awt.event.MouseEvent evt) {                                        
    Border br1 = BorderFactory.createLineBorder(new Color(29,161,242),3);
        searchfield.setBorder(br1);
    }                                       

    private void searchiconMouseEntered(java.awt.event.MouseEvent evt) {                                        
         searchicon.setSize(80,80);
        try
        {
        BufferedImage read = ImageIO.read(new File("src\\folder\\s3.png"));
           searchicon.setIcon(new ImageIcon(read));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }   
       
    }                                       
////////////////////////////////////search/////////////////////////////////////////////////////////////////
  class search implements Runnable
{
int flag;
home hm=new home(twitter);

        @Override
        public void run() {
  hm.displaypanel.removeAll();
String colour;
int size=0;
User user;
        singlesearchpanel ssp=new singlesearchpanel();
ssp.setSize(hm.displaypanel.getWidth(),hm.displaypanel.getHeight());
ssp.scrolltweet.setSize(hm.displaypanel.getWidth()-20,hm.displaypanel.getHeight());

hm.displaypanel.add(ssp);
hm.displaypanel.repaint();
try
{
    String name=searchfield.getText();
    searchfield.setText("Enter username to search");
            ResponseList<Status> homelist = twitter.getUserTimeline(name);
            singlesearchtweet sst[]=new singlesearchtweet[homelist.size()];
            singlesearchtweet1 sst1[]=new singlesearchtweet1[homelist.size()];

         ssp.searchpanel.removeAll();;
            for(int i=0;i<homelist.size();i++)
            {


Status st=homelist.get(i);
    MediaEntity[] a = st.getMediaEntities();
                if(a.length==0)
                {
                    sst1[i]=new singlesearchtweet1();
    Date twtdate = st.getCreatedAt();
    sst1[i].setBounds(0,size+10,595,187);
       size=size+sst1[i].getHeight();
   user = st.getUser();
                String url = user.getOriginalProfileImageURL();
                BufferedImage bi = ImageIO.read(new URL(url));
                BufferedImage resize = resize(bi,sst1[i].searchphotolb.getWidth(),sst1[i].searchphotolb.getHeight());
                   sst1[i].searchphotolb.setIcon(new ImageIcon(resize));
                String text = st.getText();
                sst1[i].searchtweet.setText(text);
                             int c=st.getFavoriteCount();
                int c1=st.getRetweetCount();
                sst1[i].favoritecount.setText(c+"");
                sst1[i].retweetcount.setText(c1+"");
    User user1 = st.getUser();
    String nl=user1.getName();
    String sn=user1.getScreenName();
                sst1[i].namelb.setText(nl);
                sst1[i].snlb.setText("@"+sn);
    Date dt = st.getCreatedAt();
    String dt1=dt.toString();
    sst1[i].timelb.setText("."+dt1);

                ssp.searchpanel.add(sst1[i]);

         int j=i;
                   ////////////////////////////////////////////like unlike logic//////////////////////////////
                    boolean favourited=st.isFavorited();
         if(favourited)
         {
             sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n6.png"));
             flag=1;
             flagal.add(flag);
                sst1[j].favoritecount.setForeground(new Color(232,28,79));
         }
         else
         {
             sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
             flag=0;
     flagal.add(flag);
         }

         sst1[j].likelb.addMouseListener(new MouseAdapter() {
                  @Override
                  public void mouseClicked(MouseEvent me) {
             int k=c;


    try{       
                       Icon favicn = sst1[j].likelb.getIcon();
                       String favs=favicn.toString();
             ////////////////////////////////////////////////////if flag==1///////////////////////////////////////////////
                       if(flagal.get(j)==1)
              {
if(favs.equals(ic3))
{

   twitter.destroyFavorite(st.getId());
   k=k-1;
   sst1[j].favoritecount.setText(k+"");
        sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
              sst1[j].favoritecount.setForeground(Color.black);      

        }
else if(favs.equals(ic2))
        {
    twitter.createFavorite(st.getId());
       sst1[j].favoritecount.setText(k+"");
       sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n6.png"));
       sst1[j].favoritecount.setForeground(new Color(232,28,79));      
        }
              }
              ///////////////////this else for flag==0////////////////////////////////////////////////////////
               else
              {
                 
if(favs.equals(ic3))
{
    
   twitter.destroyFavorite(st.getId());

   sst1[j].favoritecount.setText(k+"");
        sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
              sst1[j].favoritecount.setForeground(Color.black);      
    
        }
else if(favs.equals(ic2))
        {
    twitter.createFavorite(st.getId());
   k=k+1;
       sst1[j].favoritecount.setText(k+"");
       sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n6.png"));
       sst1[j].favoritecount.setForeground(new Color(232,28,79));      
  }}
                       
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
             sst1[j].likelb.repaint();
                  }});
        sst1[j].likelb.addMouseListener(new MouseAdapter() {
                  @Override
                  public void mouseEntered(MouseEvent me) {
          
                      Icon icon1= sst1[j].likelb.getIcon();
String ics1=icon1.toString();
        if(ics1.equals(ic1))
        {
            sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n5.png"));
        }    
        
        sst1[j].favoritecount.setForeground(new Color(232,28,79));
            }});
        
        
           sst1[j].likelb.addMouseListener(new MouseAdapter() {
                  @Override
                  public void mouseExited(MouseEvent me) {
          
                   Icon icon2= sst1[j].likelb.getIcon();
String ics2=icon2.toString();
        if(ics2.equals(ic2))
        {
            sst1[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
                 sst1[j].favoritecount.setForeground(Color.black);
        }       
                  
                  
                  
                  
                  
                  }});
      
                   
                   
                   
                   
                   /////////////////////////////////if no medialogic ends here///////////////////////////////////////////////////////////////
                  
             
                 ssp.repaint();
   
                }
                
                else
                {
                for(MediaEntity m:a)
                {
                    sst[i]=new singlesearchtweet();
                         String md=m.getMediaURL();
                             BufferedImage read2 = ImageIO.read(new URL(md));
                             BufferedImage resize1 = resize(read2,sst[i].medialb.getWidth(),sst[i].medialb.getHeight());
                             sst[i].medialb.setIcon(new ImageIcon(resize1));
                         
    Date twtdate = st.getCreatedAt();
    sst[i].setBounds(0,size+10,595,630);
       size=size+sst[i].getHeight();
    user = st.getUser();
                String url = user.getOriginalProfileImageURL();
                BufferedImage bi = ImageIO.read(new URL(url));
                BufferedImage resize = resize(bi,sst[i].searchphotolb.getWidth(),sst[i].searchphotolb.getHeight());
                   sst[i].searchphotolb.setIcon(new ImageIcon(resize));
                String text = st.getText();
                sst[i].searchtweet.setText(text);
                             int c=st.getFavoriteCount();
                int c1=st.getRetweetCount();
                sst[i].favoritecount.setText(c+"");
                sst[i].retweetcount.setText(c1+"");
    User user1 = st.getUser();
    String nl=user1.getName();
    String sn=user1.getScreenName();
                sst[i].namelb.setText(nl);
                sst[i].snlb.setText("@"+sn);
    Date dt = st.getCreatedAt();
    String dt1=dt.toString();
    sst[i].timelb.setText("."+dt1);
    
                 ssp.searchpanel.add(sst[i]);
          
         int j=i;
                   ////////////////////////////////////////////like unlike logic//////////////////////////////
                    boolean favourited=st.isFavorited();
         if(favourited)
         {
             sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n6.png"));
             flag=1;
             flagal.add(flag);
                sst[j].favoritecount.setForeground(new Color(232,28,79));
         }
         else
         {
             sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
             flag=0;
     flagal.add(flag);
         }
  
         sst[j].likelb.addMouseListener(new MouseAdapter() {
                  @Override
                  public void mouseClicked(MouseEvent me) {
             int k=c;
          
  
    try{       
                       Icon favicn = sst[j].likelb.getIcon();
                       String favs=favicn.toString();
             ////////////////////////////////////////////////////if flag==1///////////////////////////////////////////////
                       if(flagal.get(j)==1)
              {
if(favs.equals(ic3))
{
    
   twitter.destroyFavorite(st.getId());
   k=k-1;
   sst[j].favoritecount.setText(k+"");
        sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
              sst[j].favoritecount.setForeground(Color.black);      
    
        }
else if(favs.equals(ic2))
        {
    twitter.createFavorite(st.getId());
       sst[j].favoritecount.setText(k+"");
       sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n6.png"));
       sst[j].favoritecount.setForeground(new Color(232,28,79));      
        }
              }
              ///////////////////this else for flag==0////////////////////////////////////////////////////////
               else
              {
                 
if(favs.equals(ic3))
{
    
   twitter.destroyFavorite(st.getId());

   sst[j].favoritecount.setText(k+"");
        sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
              sst[j].favoritecount.setForeground(Color.black);      
    
        }
else if(favs.equals(ic2))
        {
    twitter.createFavorite(st.getId());
   k=k+1;
       sst[j].favoritecount.setText(k+"");
       sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n6.png"));
       sst[j].favoritecount.setForeground(new Color(232,28,79));      
  }}
                       
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
             sst[j].likelb.repaint();
                  }});
        sst[j].likelb.addMouseListener(new MouseAdapter() {
                  @Override
                  public void mouseEntered(MouseEvent me) {
          
                      Icon icon1= sst[j].likelb.getIcon();
String ics1=icon1.toString();
        if(ics1.equals(ic1))
        {
            sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n5.png"));
        }    
        
        sst[j].favoritecount.setForeground(new Color(232,28,79));
            }});
        
        
           sst[j].likelb.addMouseListener(new MouseAdapter() {
                  @Override
                  public void mouseExited(MouseEvent me) {
          
                   Icon icon2= sst[j].likelb.getIcon();
String ics2=icon2.toString();
        if(ics2.equals(ic2))
        {
            sst[j].likelb.setIcon(new ImageIcon("src\\folder\\n3.png"));
                 sst[j].favoritecount.setForeground(Color.black);
        }       
                  
                  
                  
                  
                  
                  }});
   
                }
                ssp.repaint();
                    }
                                    }
    ssp.searchpanel.setPreferredSize(new Dimension(595,size+10));
         ssp.searchpanel1.setPreferredSize(new Dimension(595,size+10));
            }

            catch(Exception e)
                    {
                    e.printStackTrace();
                    }
  hm.displaypanel.repaint();
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
      
     
        }}
    
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
            java.util.logging.Logger.getLogger(userprofileframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userprofileframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userprofileframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userprofileframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                     }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dplb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel ln1;
    private javax.swing.JLabel ln2;
    private javax.swing.JLabel ln3;
    private javax.swing.JLabel ln4;
    private javax.swing.JPanel p1;
    private javax.swing.JPanel p2;
    private javax.swing.JLabel p2lb;
    private javax.swing.JPanel p3;
    private javax.swing.JLabel profilepic;
    private javax.swing.JLabel refreshlb;
    private javax.swing.JTextField searchfield;
    private javax.swing.JLabel searchicon;
    private javax.swing.JPanel userdisplay;
    // End of variables declaration//GEN-END:variables
}
