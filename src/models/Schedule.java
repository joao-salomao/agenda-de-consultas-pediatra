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
    private int id;
    
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
    
}
