
import java.awt.Color;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PARAM
 */
public class schedulepanel extends javax.swing.JPanel {

    /**
     * Creates new form schedulepanel
     */
    public schedulepanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        schedulearea = new javax.swing.JTextArea();
        schedulephotolb = new javax.swing.JLabel();
        hourcb = new javax.swing.JComboBox<>();
        minutecb = new javax.swing.JComboBox<>();
        schedulebt = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 240, 255));
        setLayout(null);

        schedulearea.setColumns(20);
        schedulearea.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        schedulearea.setRows(5);
        schedulearea.setText(" \nEnter your tweet!!!");
        schedulearea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 161, 242), 3));
        schedulearea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scheduleareaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(schedulearea);

        add(jScrollPane1);
        jScrollPane1.setBounds(230, 160, 570, 250);
        add(schedulephotolb);
        schedulephotolb.setBounds(50, 200, 130, 130);

        hourcb.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        hourcb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        add(hourcb);
        hourcb.setBounds(240, 480, 80, 40);

        minutecb.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        minutecb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", " ", " ", " ", " ", " ", " ", " ", " " }));
        minutecb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minutecbActionPerformed(evt);
            }
        });
        add(minutecb);
        minutecb.setBounds(480, 480, 80, 40);

        schedulebt.setBackground(new java.awt.Color(29, 161, 242));
        schedulebt.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        schedulebt.setForeground(new java.awt.Color(255, 255, 255));
        schedulebt.setText("schedule");
        schedulebt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                schedulebtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                schedulebtMouseExited(evt);
            }
        });
        schedulebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schedulebtActionPerformed(evt);
            }
        });
        add(schedulebt);
        schedulebt.setBounds(690, 480, 140, 50);

        jPanel1.setBackground(new java.awt.Color(29, 161, 242));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        jLabel1.setText("Schedule Your Tweet");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(240, 20, 590, 50);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 1060, 90);
    }// </editor-fold>//GEN-END:initComponents

    private void minutecbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minutecbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minutecbActionPerformed

    private void schedulebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schedulebtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_schedulebtActionPerformed

    private void schedulebtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_schedulebtMouseEntered
     schedulebt.setBackground(new Color(30,21,90));
             
    }//GEN-LAST:event_schedulebtMouseEntered

    private void schedulebtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_schedulebtMouseExited
       schedulebt.setBackground(new Color(29,161,242));
    }//GEN-LAST:event_schedulebtMouseExited

    private void scheduleareaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scheduleareaMouseClicked
     schedulearea.setText("");
    }//GEN-LAST:event_scheduleareaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> hourcb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JComboBox<String> minutecb;
    public javax.swing.JTextArea schedulearea;
    public javax.swing.JButton schedulebt;
    public javax.swing.JLabel schedulephotolb;
    // End of variables declaration//GEN-END:variables
}