
import java.awt.Color;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PARAM
 */
public class loginpanel extends javax.swing.JPanel {

    /**
     * Creates new form loginpanel
     */
    int r,g,b;
    public loginpanel() {
        initComponents();
        r=29;g=161;
        b=242;
        Color cl=new Color(r,g,b);
        loginpanelbt.setBackground(cl);
          loginpanelclose.setBackground(cl);
        
     
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginpanelbt = new javax.swing.JButton();
        loginpanelclose = new javax.swing.JButton();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(200, 60));
        setLayout(null);

        loginpanelbt.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 18)); // NOI18N
        loginpanelbt.setForeground(new java.awt.Color(255, 255, 255));
        loginpanelbt.setPreferredSize(new java.awt.Dimension(300, 100));
        loginpanelbt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginpanelbtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginpanelbtMouseExited(evt);
            }
        });
        loginpanelbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginpanelbtActionPerformed(evt);
            }
        });
        add(loginpanelbt);
        loginpanelbt.setBounds(0, 0, 200, 50);

        loginpanelclose.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        loginpanelclose.setForeground(new java.awt.Color(255, 255, 255));
        loginpanelclose.setText("X");
        loginpanelclose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginpanelcloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginpanelcloseMouseExited(evt);
            }
        });
        add(loginpanelclose);
        loginpanelclose.setBounds(210, 0, 50, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void loginpanelbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginpanelbtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginpanelbtActionPerformed

    private void loginpanelbtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginpanelbtMouseEntered
     loginpanelbt.setBackground(new Color(30,21,90));
    }//GEN-LAST:event_loginpanelbtMouseEntered

    private void loginpanelbtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginpanelbtMouseExited
      loginpanelbt.setBackground(new Color(29,161,242));
    }//GEN-LAST:event_loginpanelbtMouseExited

    private void loginpanelcloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginpanelcloseMouseEntered
         loginpanelclose.setBackground(new Color(30,21,90));
    }//GEN-LAST:event_loginpanelcloseMouseEntered

    private void loginpanelcloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginpanelcloseMouseExited
          loginpanelclose.setBackground(new Color(29,161,242));
    }//GEN-LAST:event_loginpanelcloseMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton loginpanelbt;
    public javax.swing.JButton loginpanelclose;
    // End of variables declaration//GEN-END:variables
}