/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author João Salomão
 */
@Entity(name = "HealthPlan")
@Table(name = "health_plans")
public class HealthPlan {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;
    
    @OneToMany(
        mappedBy = "healthPlan"
        //cascade = CascadeType.REMOVE, 
        //orphanRemoval = false
    )
    private List<Patient> patients;
    
    @Column(name = "appointment_limit")
    private int appointmentLimit;
    
    public HealthPlan() {}

    public HealthPlan(String name, int lcm) {
        this.name = name;
        this.appointmentLimit = lcm;
    }
    
    public HealthPlan(int id, String name, List<Patient> patients, int appointmentLimit) {
        this.id = id;
        this.name = name;
        this.patients = patients;
        this.appointmentLimit = appointmentLimit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public int getAppointmentLimit() {
        return appointmentLimit;
    }

    public void setAppointmentLimit(int appointmentLimit) {
        this.appointmentLimit = appointmentLimit;
    }
    
    
}
