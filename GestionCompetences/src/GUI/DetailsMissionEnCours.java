/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import gestionFichiers.lecteur;
import gestioncompetences.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Entrax
 */
public class DetailsMissionEnCours extends javax.swing.JFrame {

    private static String libelle, dateDebut, duree, etat;
    private MissionPreparation mission;

    private final HashMap<String, HashMap<String, Integer>> competencesMission = lecteur.getCompetencesParMission(lecteur.cheminCompetencesMission);

    /**
     * Creates new form DetailsMissionPreparation
     */
    public DetailsMissionEnCours(String libelle, String dateDebut, String duree, String etat) throws IOException {
        initComponents();
        DetailsMissionEnCours.libelle = libelle;
        DetailsMissionEnCours.dateDebut = dateDebut;
        DetailsMissionEnCours.duree = duree;
        DetailsMissionEnCours.etat = etat;
        jLabelLibelleMission.setText(libelle);

        MissionPreparation m = MissionPreparation.getMissionByLibelle(libelle);
        if (m == null) {
            this.mission = new MissionPreparation(libelle, dateDebut, duree, etat, "0");
        } else {
            this.mission = new MissionPreparation(m.getLibelle(), m.getDateDebut(), m.getDuree(), m.getEtat(), m.getNbRequis());
        }

        this.mission.addCompetence(competencesMission);
        HashMap<Competence, Integer> competenceMission = new HashMap<>();
        competenceMission = this.mission.getPersonnelRequis();
        for (Competence cp : competenceMission.keySet()) {
            tableCompetencesMissionModel.addRow(new Object[]{cp.getIdCompetence(), cp.getNomEN(), cp.getNomFR(), competenceMission.get(cp)});
        }
        for (Competence competence : lecteur.getCompetences(lecteur.cheminCompetences)) {
            comboBoxCompetencesMissionModel.addElement(competence.toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonSaveCompetencesMission = new javax.swing.JButton();
        jButtonAddCompetenceMission = new javax.swing.JButton();
        comboBoxCompetencesMissionModel = new DefaultComboBoxModel<String>(new String [] {});
        jComboBoxCompetencesMission = new javax.swing.JComboBox<>();
        jButtonDeleteCompetenceMission = new javax.swing.JButton();
        jLabelLibelleMission = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCompetencesMissionModel = new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Identifiant", "Libellé EN", "Libellé FR", "Nb Requis"
            })
            {
                @Override
                public boolean isCellEditable(int row, int column)
                {
                    return false;
                }
            };
            jTableCompetencesMission = new javax.swing.JTable();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("Détails Mission en Cours");

            jButtonSaveCompetencesMission.setText("Enregister");
            jButtonSaveCompetencesMission.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButtonSaveCompetencesMissionMouseClicked(evt);
                }
            });

            jButtonAddCompetenceMission.setText("Ajouter");
            jButtonAddCompetenceMission.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButtonAddCompetenceMissionMouseClicked(evt);
                }
            });

            jComboBoxCompetencesMission.setModel(comboBoxCompetencesMissionModel);

            jButtonDeleteCompetenceMission.setText("Supprimer");
            jButtonDeleteCompetenceMission.setEnabled(false);
            jButtonDeleteCompetenceMission.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButtonDeleteCompetenceMissionMouseClicked(evt);
                }
            });

            jTableCompetencesMission.setAutoCreateRowSorter(true);
            jTableCompetencesMission.setModel(tableCompetencesMissionModel);
            jScrollPane2.setViewportView(jTableCompetencesMission);

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabelLibelleMission)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonDeleteCompetenceMission)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBoxCompetencesMission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonAddCompetenceMission)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonSaveCompetencesMission)))
                    .addContainerGap())
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelLibelleMission)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonSaveCompetencesMission)
                        .addComponent(jButtonAddCompetenceMission)
                        .addComponent(jComboBoxCompetencesMission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonDeleteCompetenceMission))
                    .addContainerGap())
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveCompetencesMissionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSaveCompetencesMissionMouseClicked
        // TODO add your handling code here:
        for (Iterator<Competence> iterator = this.mission.getPersonnelRequis().keySet().iterator(); iterator.hasNext();) {
            Competence cp = iterator.next();
            iterator.remove();
        }
        for (int i = 0; i < tableCompetencesMissionModel.getRowCount(); i++) {
            Competence cp = new Competence(tableCompetencesMissionModel.getValueAt(i, 0).toString(),
                    tableCompetencesMissionModel.getValueAt(i, 1).toString(),
                    tableCompetencesMissionModel.getValueAt(i, 2).toString());
            this.mission.addCompetence(cp, Integer.parseInt(tableCompetencesMissionModel.getValueAt(i, 3).toString()));
        }
        HashMap<String, Integer> idCompetences = new HashMap<>();
        for (Competence cp : this.mission.getPersonnelRequis().keySet()) {
            idCompetences.put(cp.getIdCompetence(), this.mission.getPersonnelRequis().get(cp));
        }
        competencesMission.put(this.mission.getLibelle(), idCompetences);

        try {
            gestionFichiers.writer.sauvegarderCompetencesMissionPreparation(competencesMission);
        } catch (IOException ex) {
            Logger.getLogger(DetailsMissionEnCours.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.dispose();
    }//GEN-LAST:event_jButtonSaveCompetencesMissionMouseClicked

    private void jButtonAddCompetenceMissionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddCompetenceMissionMouseClicked
        // TODO add your handling code here:
        Competence cp = new Competence(comboBoxCompetencesMissionModel.getSelectedItem().toString());
        tableCompetencesMissionModel.addRow(new Object[]{cp.getIdCompetence(), cp.getNomEN(), cp.getNomFR(), "0"});
    }//GEN-LAST:event_jButtonAddCompetenceMissionMouseClicked

    private void jButtonDeleteCompetenceMissionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDeleteCompetenceMissionMouseClicked
        // TODO add your handling code here:
        if (jTableCompetencesMission.getSelectedRow() != -1) {
            tableCompetencesMissionModel.removeRow(jTableCompetencesMission.getSelectedRow());
        }
    }//GEN-LAST:event_jButtonDeleteCompetenceMissionMouseClicked

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
            java.util.logging.Logger.getLogger(DetailsMissionEnCours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailsMissionEnCours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailsMissionEnCours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailsMissionEnCours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DetailsMissionEnCours(DetailsMissionEnCours.libelle, DetailsMissionEnCours.dateDebut, DetailsMissionEnCours.duree, DetailsMissionEnCours.etat).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(DetailsMissionEnCours.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddCompetenceMission;
    private javax.swing.JButton jButtonDeleteCompetenceMission;
    private javax.swing.JButton jButtonSaveCompetencesMission;
    private javax.swing.JComboBox<String> jComboBoxCompetencesMission;
    private javax.swing.JLabel jLabelLibelleMission;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCompetencesMission;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel tableCompetencesMissionModel;
    DefaultComboBoxModel<String> comboBoxCompetencesMissionModel;
}
