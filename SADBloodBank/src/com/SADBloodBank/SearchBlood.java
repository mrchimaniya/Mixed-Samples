/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SADBloodBank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;
/**
 *
 * @author DELL
 */
public class SearchBlood extends javax.swing.JFrame {
    /**
     * Creates new form SearchBlood
     */
    Timer tm;
    int delay=100;
    SADBloodBank sad;
    public SearchBlood(){
        
    }
    public SearchBlood(SADBloodBank sad) {
        initComponents();
        this.sad=sad;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
         tm=new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               Date d=new Date();
               DateFormat df=new SimpleDateFormat("hh:mm:ss");
               DateFormat af=new SimpleDateFormat("dd-MMMM-yyyy");
               String timeFormatted=df.format(d);
               String dateFormatted=af.format(d);
               lblSearchBloodTime.setText(timeFormatted);
               lblSearchBloodDate.setText(dateFormatted);               
            }
        });
        tm.start();
        
        srlSearchBloodScroller.getVerticalScrollBar().setUnitIncrement(6);
        srlSearchBloodTableScroller.getVerticalScrollBar().setUnitIncrement(6);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("com/SADBloodBank/icon/logo90.jpg"));
        setIconImage(icon.getImage());
        tblSearchBloodTable.setRowHeight(40);
        tblSearchBloodTable.setAutoResizeMode(0);
        tblSearchBloodTable.getColumnModel().getColumn(0).setPreferredWidth(165);
        tblSearchBloodTable.getColumnModel().getColumn(1).setPreferredWidth(65);
        tblSearchBloodTable.getColumnModel().getColumn(2).setPreferredWidth(40);
        tblSearchBloodTable.getColumnModel().getColumn(3).setPreferredWidth(40);
        tblSearchBloodTable.getColumnModel().getColumn(4).setPreferredWidth(255);
        tblSearchBloodTable.getColumnModel().getColumn(5).setPreferredWidth(100);
        tblSearchBloodTable.getColumnModel().getColumn(6).setPreferredWidth(255);
        tblSearchBloodTable.getColumnModel().getColumn(7).setPreferredWidth(188);
        tblSearchBloodTable.getColumnModel().getColumn(8).setPreferredWidth(140);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        srlSearchBloodScroller = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        lblSearchBloodTime = new javax.swing.JLabel();
        lblSearchBloodDate = new javax.swing.JLabel();
        srlSearchBloodTableScroller = new javax.swing.JScrollPane();
        tblSearchBloodTable = new javax.swing.JTable();
        btnSearchBloodGoBack = new javax.swing.JButton();
        btnUpdateExit = new javax.swing.JButton();
        lblSearchBloodTime1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Donors Found");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSearchBloodTime.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lblSearchBloodTime.setForeground(new java.awt.Color(153, 0, 0));
        lblSearchBloodTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSearchBloodTime.setText("00:00:00");
        jPanel2.add(lblSearchBloodTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, 280, 30));

        lblSearchBloodDate.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lblSearchBloodDate.setForeground(new java.awt.Color(153, 0, 0));
        lblSearchBloodDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSearchBloodDate.setText("01-January-2021");
        jPanel2.add(lblSearchBloodDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 70, 280, 30));

        tblSearchBloodTable.setAutoCreateRowSorter(true);
        tblSearchBloodTable.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        tblSearchBloodTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Gender", "Age", "Blood", "Nearest Blood Bank", "Phone", "Email", "Address", "Disease"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSearchBloodTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        srlSearchBloodTableScroller.setViewportView(tblSearchBloodTable);

        jPanel2.add(srlSearchBloodTableScroller, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 1250, 450));

        btnSearchBloodGoBack.setBackground(new java.awt.Color(153, 204, 255));
        btnSearchBloodGoBack.setFont(new java.awt.Font("Cambria", 0, 21)); // NOI18N
        btnSearchBloodGoBack.setText("Go Back");
        btnSearchBloodGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchBloodGoBackActionPerformed(evt);
            }
        });
        jPanel2.add(btnSearchBloodGoBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 600, 170, 40));

        btnUpdateExit.setBackground(new java.awt.Color(255, 153, 153));
        btnUpdateExit.setFont(new java.awt.Font("Cambria", 0, 21)); // NOI18N
        btnUpdateExit.setText("Exit");
        btnUpdateExit.setPreferredSize(new java.awt.Dimension(84, 30));
        btnUpdateExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateExitActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdateExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 600, 170, 40));

        lblSearchBloodTime1.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lblSearchBloodTime1.setForeground(new java.awt.Color(153, 0, 0));
        lblSearchBloodTime1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSearchBloodTime1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/SADBloodBank/icon/logo90.jpg"))); // NOI18N
        jPanel2.add(lblSearchBloodTime1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 90));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/SADBloodBank/icon/bannerblue.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(1150, 465));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 700));

        srlSearchBloodScroller.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(srlSearchBloodScroller, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(srlSearchBloodScroller, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        this.tblSearchBloodTable.clearSelection();  // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        setVisible(false);
        sad.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void btnSearchBloodGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchBloodGoBackActionPerformed
        setVisible(false);
        sad.setVisible(true);
    }//GEN-LAST:event_btnSearchBloodGoBackActionPerformed

    private void btnUpdateExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateExitActionPerformed
        new ExitWindow().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateExitActionPerformed

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
            java.util.logging.Logger.getLogger(SearchBlood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchBlood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchBlood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchBlood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchBlood().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearchBloodGoBack;
    private javax.swing.JButton btnUpdateExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblSearchBloodDate;
    private javax.swing.JLabel lblSearchBloodTime;
    private javax.swing.JLabel lblSearchBloodTime1;
    private javax.swing.JScrollPane srlSearchBloodScroller;
    private javax.swing.JScrollPane srlSearchBloodTableScroller;
    javax.swing.JTable tblSearchBloodTable;
    // End of variables declaration//GEN-END:variables
}