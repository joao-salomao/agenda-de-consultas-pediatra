/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author João Salomão
 */
@Entity(name = "Schedule")
@Table(name = "schedules")
public class Schedule {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "clinic_name")
    private String clinicName;
    
    @Column(name = "day_of_week")
    private int dayOfWeek;
    
    @Temporal(TemporalType.TIME)
    @Column(name = "first_appointment_time")
    private Date firstAppointmentTime;
    
    @Temporal(TemporalType.TIME)
    @Column(name = "last_appointment_time")
    private Date lastAppointmentTime;
    
    @Temporal(TemporalType.TIME)
    @Column(name = "initial_lunch_time")
    private Date initialLunchTime;
    
    @Temporal(TemporalType.TIME)
    @Column(name = "final_lunch_time")
    private Date finalLunchTime;
    
    @Column(name = "consultation_period", columnDefinition = "INT(2) default 30", insertable = false, updatable = true)
    private int consultationPeriod;
    
    @OneToMany(
        mappedBy = "schedule",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    List<Consultation> consultations;

    public Schedule() {}
    
    public Schedule(int id, String clinicName, int dayOfWeek, Date firstAppointmentTime, Date lastAppointmentTime, Date initialLunchTime, Date finalLunchTime, int consultationPeriod, List<Consultation> consultations) {
        this.id = id;
        this.clinicName = clinicName;
        this.dayOfWeek = dayOfWeek;
        this.firstAppointmentTime = firstAppointmentTime;
        this.lastAppointmentTime = lastAppointmentTime;
        this.initialLunchTime = initialLunchTime;
        this.finalLunchTime = finalLunchTime;
        this.consultationPeriod = consultationPeriod;
        this.consultations = consultations;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Date getFirstAppointmentTime() {
        return firstAppointmentTime;
    }

    public void setFirstAppointmentTime(Date firstAppointmentTime) {
        this.firstAppointmentTime = firstAppointmentTime;
    }

    public Date getLastAppointmentTime() {
        return lastAppointmentTime;
    }

    public void setLastAppointmentTime(Date lastAppointmentTime) {
        this.lastAppointmentTime = lastAppointmentTime;
    }

    public Date getInitialLunchTime() {
        return initialLunchTime;
    }

    public void setInitialLunchTime(Date initialLunchTime) {
        this.initialLunchTime = initialLunchTime;
    }

    public Date getFinalLunchTime() {
        return finalLunchTime;
    }

    public void setFinalLunchTime(Date finalLunchTime) {
        this.finalLunchTime = finalLunchTime;
    }

    public int getConsultationPeriod() {
        return consultationPeriod;
    }

    public void setConsultationPeriod(int consultationPeriod) {
        this.consultationPeriod = consultationPeriod;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }
    
    
    
}
