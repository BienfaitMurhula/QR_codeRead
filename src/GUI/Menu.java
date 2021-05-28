/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import traitement.Traitement;

/**
 *
 * @author Soft developpers
 */
public class Menu extends javax.swing.JFrame implements Runnable, ThreadFactory{

   private WebcamPanel panel= null;
   private Webcam webcam= null;
   private static final long serialVersionUID = 6441489157408381878L;
   private Executor exec= Executors.newSingleThreadExecutor(this);
    
   Traitement t= new Traitement();
    public Menu() {
        initComponents();
        initWebcam();
        couleur();
        this.setLocationRelativeTo(null);
        afficher();
        t.savePresece(jTextField1,Liste_Presence.jTable1);
       // jTextField1.setVisible(false);
    }

    private void couleur()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){
                    try {
                        Thread.sleep(1000);
                        jLabel2.setForeground(Color.GRAY);
                        Thread.sleep(1000);
                        jLabel2.setForeground(Color.BLUE);
                        Thread.sleep(1000);
                        jLabel2.setForeground(Color.GREEN);
                        Thread.sleep(1000);
                        jLabel2.setForeground(Color.ORANGE);
                        Thread.sleep(1000);
                        jLabel2.setForeground(Color.YELLOW);
                        Thread.sleep(1000);
                        jLabel2.setForeground(Color.pink);
                        Thread.sleep(1000);
                        jLabel2.setForeground(Color.cyan);
                    } catch (InterruptedException ex) {
                       
                    }
                }
            }
        }).start();
    }
    private void initWebcam(){
        Dimension size =  WebcamResolution.QVGA.getSize();
        webcam=Webcam.getWebcams().get(0);
        webcam.setViewSize(size);
        panel= new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);
        jPanel3.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 300));
        exec.execute(this);
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lab = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Agency FB", 3, 24)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 510, 43));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SCANNER VOTRE CODE ICI SVP !!");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Voir la liste");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 460, 300));

        lab.setFont(new java.awt.Font("Yu Gothic UI", 1, 36)); // NOI18N
        lab.setForeground(new java.awt.Color(0, 255, 0));
        lab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 60, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new Liste_Presence().show();
    }//GEN-LAST:event_jLabel1MouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lab;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        do {            
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Result result =null;
            BufferedImage img=null;
            if (webcam.isOpen()) {
                if ((img=webcam.getImage())==null) {
                    continue;
                }
            }
                LuminanceSource source = new BufferedImageLuminanceSource(img);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                try {
                    result= new MultiFormatReader().decode(bitmap);
                } catch (NotFoundException e) {
                }
            if (result!= null) {
                jTextField1.setText(result.getText());
                lab.setText("ok".toUpperCase());
                
            }else
            {
//                lab.setText("NON");
            }
        } while (true);
        
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My thread");
        t.setDaemon(true);
        return t;
    }
    private void afficher(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){
                    try {
                        Thread.sleep(1000);
                        
                        if (!(jTextField1.getText().isEmpty())) {
                            lab.setText("ok".toUpperCase());
                            Thread.sleep(3000);
                            jTextField1.setText("");
                            lab.setText("");
                        }
                    } catch (InterruptedException ex) {
                        
                    }
                }
            }
        }).start();
    }
}
