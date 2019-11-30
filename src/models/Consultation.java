/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author João Salomão
 */

@Entity(name = "Consultation")
@Table(name = "consultations")
public class Consultation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;

    @Temporal(TemporalType.TIME)
    @Column(name = "period")
    private Date period;

    @Temporal(TemporalType.DATE)
    @Column(name = "max_date")
    private Date maxDate;

    @Column(name = "is_review")
    private boolean isReview;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;
    
    public Consultation(){}

    public Consultation(int id, Date date, Date period, Date maxDate, boolean isReview, Patient patient, Schedule schedule) {
        this.id = id;
        this.date = date;
        this.period = period;
        this.maxDate = maxDate;
        this.isReview = isReview;
        this.patient = patient;
        this.schedule = schedule;
    }

    public Consultation(Date date, Date period, boolean isReview, Patient patient, Schedule schedule) {
        this.date = date;
        this.period = period;
        this.isReview = isReview;
        this.patient = patient;
        this.schedule = schedule;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getPeriod() {
        return period;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }

    public Date getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(Date maxDate) {
        this.maxDate = maxDate;
    }

    public boolean isIsReview() {
        return isReview;
    }

    public void setIsReview(boolean isReview) {
        this.isReview = isReview;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    
    
}
