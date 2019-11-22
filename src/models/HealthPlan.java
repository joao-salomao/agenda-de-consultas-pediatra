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
        mappedBy = "healthPlan",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Patient> patients;
    
    @Column(name = "appointment_limit")
    private int appointmentLimit;
    
    public HealthPlan() {}

    public HealthPlan(int id, String name) {
        this.id = id;
        this.name = name;
    }    
}
