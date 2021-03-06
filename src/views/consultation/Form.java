/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.consultation;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import models.Consultation;
import models.Patient;
import models.Schedule;
import utils.Utils;
import views.patient.PatientsTable;

/**
 *
 * @author João Salomão
 */
public class Form extends javax.swing.JFrame {

    private boolean isEdit;
    private final Patient patient;
    private Consultation consultation;
    private final PatientsTable patientsTable;
    private final ConsultationsTable consultationsTable;
    private final ArrayList<Schedule> schedules;
    private final ArrayList<Consultation> consultations;

    /**
     * Creates new form Form
     *
     * @param patientsTableList
     * @param consultationsTableList
     * @param edit
     */
    public Form(PatientsTable patientsTableList, ConsultationsTable consultationsTableList, boolean edit) {
        initComponents();
        setLocationRelativeTo(null);

        patientsTable = patientsTableList;
        consultationsTable = consultationsTableList;

        schedules = consultationsTable.getSchedules();
        consultations = consultationsTable.getConsultations();
        isEdit = edit;

        setSchedulesComboBoxList();

        if (isEdit) {
            consultation = consultationsTable.getSelectedConsultation();
            patient = consultation.getPatient();
        } else {
            patient = patientsTable.getSelectedPatient();
        }

        setFieldsText();
    }

    private void setFieldsText() {
        patientNameTextField.setText(patient.getName());
        if (isEdit) {
            dateFormattedTextField.setText(Utils.parseDateToString(consultation.getDate(), null));
            periodFormattedTextField.setText(Utils.parseDateToString(consultation.getPeriod(), "HHmm"));
            isRevisionToggleButton.setSelected(consultation.isIsReview());
            String consultationSchedule = Utils.mapperObjectToComboBox(consultation.getSchedule().getClinicName(), consultation.getSchedule().getId());
            schedulesComboBox.getModel().setSelectedItem(consultationSchedule);
        }
    }

    private void setSchedulesComboBoxList() {
        schedules.forEach((s) -> {
            String clinicName = getScheduleLabel(s);
            schedulesComboBox.addItem(Utils.mapperObjectToComboBox(clinicName, s.getId()));
        });
    }
    
    private String getScheduleLabel(Schedule s) {
        return (s.getClinicName() + " - " 
                + DayOfWeek.of(s.getDayOfWeek()) + " - " 
                + Utils.parseDateToString(s.getFirstAppointmentTime(), "HH:mm") + " ~ " 
                + Utils.parseDateToString(s.getLastAppointmentTime(), "HH:mm")
            );
    }

    private Schedule getSelectedSchedule() {
        Schedule schedule = null;
        String selected = (String) schedulesComboBox.getSelectedItem();
        int id = Integer.parseInt(selected.split("-")[0].trim());

        for (Schedule s : schedules) {
            if (s.getId() == id) {
                schedule = s;
            }
        }
        return schedule;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        patientNameTextField = new javax.swing.JTextField();
        patientNameLabel = new javax.swing.JLabel();
        schedulesComboBox = new javax.swing.JComboBox<>();
        schedulesLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        periodLabel = new javax.swing.JLabel();
        isRevisionToggleButton = new javax.swing.JToggleButton();
        isRevisionLabel = new javax.swing.JLabel();
        leftButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        try {
            dateFormattedTextField = new javax.swing.JFormattedTextField(new javax.swing.text.MaskFormatter("##/##/####"));
            try {
                periodFormattedTextField = new javax.swing.JFormattedTextField(new javax.swing.text.MaskFormatter("##:##"));

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

                jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

                patientNameTextField.setEditable(false);
                patientNameTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

                patientNameLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                patientNameLabel.setText("Paciente");

                schedulesComboBox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

                schedulesLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                schedulesLabel.setText("Clínica");

                dateLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                dateLabel.setText("Data");

                periodLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                periodLabel.setText("Horário");

                isRevisionToggleButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                isRevisionToggleButton.setText("Não");
                isRevisionToggleButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        isRevisionToggleButtonActionPerformed(evt);
                    }
                });

                isRevisionLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                isRevisionLabel.setText("É revisão ?");

                leftButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                leftButton.setText("Sair");
                leftButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        leftButtonActionPerformed(evt);
                    }
                });

                saveButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                saveButton.setText("Salvar");
                saveButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        saveButtonActionPerformed(evt);
                    }
                });

            } catch (Exception e) {
                System.out.println("ERRO AO SETAR MASCARA NO TEXTFIELD: "+e);
            }
            dateFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            dateFormattedTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
            dateFormattedTextField.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    dateFormattedTextFieldActionPerformed(evt);
                }
            });

        } catch (Exception e) {
            System.out.println("ERRO AO SETAR MÁSCARA NO TEXTFIELD: "+e);
        }
        periodFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        periodFormattedTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientNameTextField)
                    .addComponent(schedulesComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(patientNameLabel)
                            .addComponent(schedulesLabel)
                            .addComponent(dateLabel)
                            .addComponent(dateFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(periodLabel)
                                .addGap(117, 117, 117))
                            .addComponent(periodFormattedTextField)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(isRevisionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(isRevisionToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(leftButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveButton)
                .addGap(9, 9, 9))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(patientNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patientNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(schedulesLabel)
                .addGap(7, 7, 7)
                .addComponent(schedulesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel)
                    .addComponent(periodLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(periodFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(isRevisionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(isRevisionToggleButton)
                        .addGap(0, 64, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(leftButton)
                            .addComponent(saveButton))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void isRevisionToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isRevisionToggleButtonActionPerformed
        if (isRevisionToggleButton.isSelected()) {
            isRevisionToggleButton.setText("Sim");
        } else {
            isRevisionToggleButton.setText("Não");
        }
    }//GEN-LAST:event_isRevisionToggleButtonActionPerformed

    private void dateFormattedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateFormattedTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateFormattedTextFieldActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        Date date = Utils.parseStringToDate(dateFormattedTextField.getText(), null);
        Date time = Utils.parseStringToDate(periodFormattedTextField.getText(), "HH:mm");
        Schedule schedule = getSelectedSchedule();
        boolean isReview = isRevisionToggleButton.isSelected();
        int appointmentLimit = patient.getHealthPlan() == null ? -1 : patient.getHealthPlan().getAppointmentLimit();
        
        int validation =  consultationsTable.canMarkConsultation(date, time, schedule.getInitialLunchTime(), 
                schedule.getFinalLunchTime(), appointmentLimit, patient.getConsultations(), schedule.getFirstAppointmentTime(), schedule.getLastAppointmentTime());
        
        switch (validation) {
            case 1:
                JOptionPane.showMessageDialog(this, "Somente é permitido marcar três consultas por dia");
                return;
            case 2:
                JOptionPane.showMessageDialog(this, "O horário da consulta conflita com o horário de almoço");
                return;
            case 3:
                JOptionPane.showMessageDialog(this, "O paciente atingiu o limite de consultas mensais do plano de saúde");
                return;
            case 4:
                JOptionPane.showMessageDialog(this, "O horário da consulta está fora do horário de atendimento");
                return;
            default:
                break;
        }
        
        boolean result;
        
        if (isEdit) {
            consultation.setDate(date);
            consultation.setPeriod(time);
            consultation.setSchedule(schedule);
            consultation.setIsReview(isReview);
            
            result = consultationsTable.updateRow(consultation);
            
            if (result) {
                JOptionPane.showMessageDialog(this, "A consulta foi editada com sucesso !");
            } else {
                JOptionPane.showMessageDialog(this, "Algo deu errado e não foi possível editar a consulta.");
            }
        } else {

            consultation = new Consultation(date, time, isReview, patient, schedule);

            result = consultationsTable.addRow(consultation);

            if (result) {
                isEdit = true;
                JOptionPane.showMessageDialog(this, "A consulta foi marcada com sucesso !");
            } else {
                JOptionPane.showMessageDialog(this, "Algo deu errado e não foi possível cadastrar a consulta.");
            }

        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void leftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_leftButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFormattedTextField dateFormattedTextField;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel isRevisionLabel;
    private javax.swing.JToggleButton isRevisionToggleButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton leftButton;
    private javax.swing.JLabel patientNameLabel;
    private javax.swing.JTextField patientNameTextField;
    private javax.swing.JFormattedTextField periodFormattedTextField;
    private javax.swing.JLabel periodLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox<String> schedulesComboBox;
    private javax.swing.JLabel schedulesLabel;
    // End of variables declaration//GEN-END:variables
}
