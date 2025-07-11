/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import data.Validation;
import data.WriteSpreadSheet;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author breno.santos.o2b_dot
 */
public class Result extends javax.swing.JDialog {

    private static Validation validation;
    private static String path;

    /**
     * Creates new form Result
     */
    public Result(java.awt.Frame parent, boolean modal, Validation validation, String path) {
        super(parent, modal);
        initComponents();
        this.validation = validation;
        this.path = path;
        result();

    }

    public void result() {
        labelAnalyzerInitialSizeValue.setText("" + validation.getInitialSizeAnalyzer());
        labelMultiInitialSizeValue.setText("" + validation.getInitialSizeMulti());
        labelBopInitialSizeValue.setText("" + validation.getInitialSizeBOP());
        labelAnalyzerAddSizeValue.setText("" + validation.getAddedSizeAnalyzer());
        labelMultiAddSizeValue.setText("" + validation.getAddedSizeMulti());
        labelBopAddSizeValue.setText("" + validation.getAddedSizeBOP());
        labelAnalyzerFinalSizeValue.setText("" + validation.getFinalSizeAnalyzer());
        labelMultiFinalSizeValue.setText("" + validation.getFinalSizeMulti());
        labelBopFinalSizeValue.setText("" + validation.getFinalSizeBOP());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelInitialLength = new javax.swing.JLabel();
        labelBopInitialSize = new javax.swing.JLabel();
        labelMultiInitialSize = new javax.swing.JLabel();
        labelAnalyzerInitialSize = new javax.swing.JLabel();
        labelInitial = new javax.swing.JLabel();
        labelBopInitialSizeValue = new javax.swing.JLabel();
        labelMultiInitialSizeValue = new javax.swing.JLabel();
        labelAnalyzerInitialSizeValue = new javax.swing.JLabel();
        labelEnd = new javax.swing.JLabel();
        labelBopFinalSizeValue = new javax.swing.JLabel();
        labelMultiFinalSizeValue = new javax.swing.JLabel();
        labelAnalyzerFinalSizeValue = new javax.swing.JLabel();
        separator = new javax.swing.JSeparator();
        labelAddLength = new javax.swing.JLabel();
        labelBopAddSize = new javax.swing.JLabel();
        labelMultiAddSize = new javax.swing.JLabel();
        labelAnalyzerAddSize = new javax.swing.JLabel();
        labelBopAddSizeValue = new javax.swing.JLabel();
        labelMultiAddSizeValue = new javax.swing.JLabel();
        labelAnalyzerAddSizeValue = new javax.swing.JLabel();
        buttonPreview = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Resultado");

        labelInitialLength.setText("Total Registros");

        labelBopInitialSize.setText("BOP:");

        labelMultiInitialSize.setText("Multi:");

        labelAnalyzerInitialSize.setText("Analyzer:");

        labelInitial.setText("Início:");

        labelEnd.setText("Fim:");

        labelAddLength.setText("Registros Adicionados");

        labelBopAddSize.setText("BOP:");

        labelMultiAddSize.setText("Multi:");

        labelAnalyzerAddSize.setText("Analyzer:");

        buttonPreview.setText("Visualizar Registros Adicionados");
        buttonPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPreviewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(separator)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelAddLength)
                        .addGap(138, 138, 138))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelInitialLength)
                        .addGap(161, 161, 161))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelInitial)
                            .addComponent(labelEnd))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelBopInitialSize)
                            .addComponent(labelBopInitialSizeValue)
                            .addComponent(labelBopFinalSizeValue))
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMultiInitialSize)
                            .addComponent(labelMultiInitialSizeValue)
                            .addComponent(labelMultiFinalSizeValue))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAnalyzerInitialSize)
                            .addComponent(labelAnalyzerInitialSizeValue)
                            .addComponent(labelAnalyzerFinalSizeValue))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelBopAddSize)
                            .addComponent(labelBopAddSizeValue))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMultiAddSize)
                            .addComponent(labelMultiAddSizeValue))
                        .addGap(111, 111, 111)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAnalyzerAddSizeValue)
                            .addComponent(labelAnalyzerAddSize))
                        .addGap(23, 23, 23))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonPreview)
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelInitialLength)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBopInitialSize)
                    .addComponent(labelAnalyzerInitialSize)
                    .addComponent(labelMultiInitialSize))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelBopInitialSizeValue)
                        .addComponent(labelInitial))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelMultiInitialSizeValue)
                        .addComponent(labelAnalyzerInitialSizeValue)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEnd)
                    .addComponent(labelBopFinalSizeValue)
                    .addComponent(labelMultiFinalSizeValue)
                    .addComponent(labelAnalyzerFinalSizeValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelAddLength)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAnalyzerAddSize)
                    .addComponent(labelBopAddSize)
                    .addComponent(labelMultiAddSize))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBopAddSizeValue)
                    .addComponent(labelMultiAddSizeValue)
                    .addComponent(labelAnalyzerAddSizeValue))
                .addGap(54, 54, 54)
                .addComponent(buttonPreview)
                .addGap(76, 76, 76))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPreviewActionPerformed
        WriteSpreadSheet write = new WriteSpreadSheet();
        try {
            write.writeXlsOrXlsx(path, validation.getAddedBOP(), validation.getAddedMulti(), validation.getAddedAnalyzer());
        } catch (IOException ex) {
            Logger.getLogger(Result.class.getName()).log(Level.SEVERE, "Erro ao gerar o Excel", ex);
            JOptionPane.showMessageDialog(this, "Erro ao criar o arquivo Excel: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) { // Captura o novo erro de formato de arquivo
            Logger.getLogger(Result.class.getName()).log(Level.SEVERE, "Erro de formato de arquivo", ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonPreviewActionPerformed

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
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Result dialog = new Result(new javax.swing.JFrame(), true, validation, path);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonPreview;
    private javax.swing.JLabel labelAddLength;
    private javax.swing.JLabel labelAnalyzerAddSize;
    private javax.swing.JLabel labelAnalyzerAddSizeValue;
    private javax.swing.JLabel labelAnalyzerFinalSizeValue;
    private javax.swing.JLabel labelAnalyzerInitialSize;
    private javax.swing.JLabel labelAnalyzerInitialSizeValue;
    private javax.swing.JLabel labelBopAddSize;
    private javax.swing.JLabel labelBopAddSizeValue;
    private javax.swing.JLabel labelBopFinalSizeValue;
    private javax.swing.JLabel labelBopInitialSize;
    private javax.swing.JLabel labelBopInitialSizeValue;
    private javax.swing.JLabel labelEnd;
    private javax.swing.JLabel labelInitial;
    private javax.swing.JLabel labelInitialLength;
    private javax.swing.JLabel labelMultiAddSize;
    private javax.swing.JLabel labelMultiAddSizeValue;
    private javax.swing.JLabel labelMultiFinalSizeValue;
    private javax.swing.JLabel labelMultiInitialSize;
    private javax.swing.JLabel labelMultiInitialSizeValue;
    private javax.swing.JSeparator separator;
    // End of variables declaration//GEN-END:variables
}
