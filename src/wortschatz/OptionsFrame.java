/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * OptionsFrame.java
 *
 * Created on 27.Tem.2012, 00:42:24
 */
package wortschatz;

import java.awt.Toolkit;
import java.io.*;
import java.util.*;
import javax.swing.JFrame;
/**
 *
 * @author Burak
 */
public class OptionsFrame extends javax.swing.JFrame {

    /** Creates new form OptionsFrame */
    public OptionsFrame(MainFrame a) {
        initComponents();
        ancestor = a;
        
        int x = (Toolkit.getDefaultToolkit().getScreenSize().height/2)-this.getHeight()/2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().width/2)-this.getWidth()/2;
        this.setLocation(y, x);
        
        String language="", wordbook="";
        
        try{
            // Open the file that is the first 
            // command line parameter
            FileInputStream fstream = new FileInputStream("Options.dat");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            int count =0;
            while ((strLine = br.readLine()) != null)   {
                // Print the content on the console
                if(count == 0){
                    wordbook = strLine;
                    
                }else if(count == 1){
                    language = strLine;                   
                }
                count++;
            }
            //Close the input stream
            in.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
        
        //prepare the language selected:
        if(Integer.parseInt(language) == 0){
            jButton1.setText("Bestätigen");
            jButton2.setText("Abbrechen");
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Neue Wörter", "Nicht so sicher", "Gut bekannt", "Alle" }));
            jLabel1.setText("Aktuelle Wort-Gruppe:");
            jLabel2.setText("Sprache");
            this.setTitle("Optionen");
        }else if(Integer.parseInt(language) == 1){
            jButton1.setText("Onayla");
            jButton2.setText("İptal");
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yeni Kelimeler", "Emin Olunmayanlar", "İyi Bilinenler", "Hepsi" }));
            jLabel1.setText("Geçerli Sözlük");
            jLabel2.setText("Dil");
            this.setTitle("Seçenekler");
        }else{
            jButton1.setText("Confirm");
            jButton2.setText("Cancel");
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "New Words", "Not so safe", "Well known", "All" }));
            jLabel1.setText("Current Wordbook");
            jLabel2.setText("Language");
            this.setTitle("Options");
        }
        
        jComboBox1.setSelectedIndex(Integer.parseInt(wordbook));
        jComboBox2.setSelectedIndex(Integer.parseInt(language));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Optionen");

        jLabel1.setText("Aktuelle Wort-Gruppe:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Neue Wörter", "Nicht so sicher", "Gut bekannt", "Alles" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Bestätigen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Sprache");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Deutsch", "Türkçe", "English" }));

        jButton2.setText("Abbrechen ");
        jButton2.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                
        try{
            //FileOutputStream ostream = new FileOutputStream(("Options2.dat"));
            BufferedWriter  ou = new BufferedWriter(new FileWriter("Options.dat"));

            ou.write(jComboBox1.getSelectedIndex()+"");
            ou.newLine();
            ou.write(jComboBox2.getSelectedIndex()+"");
            
            //ou.flush();
            ou.close();
        }catch(Exception e){
            System.err.println("Error: " + e.getMessage());
        }
        
        ancestor.setEnabled(true);
        ancestor.languageAndWordlistCheckMain();
        ancestor.loadWordbook();
        ancestor.writeOnButtons();
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        ancestor.setEnabled(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(OptionsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(OptionsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(OptionsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(OptionsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                new OptionsFrame().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
    private MainFrame ancestor;
}
