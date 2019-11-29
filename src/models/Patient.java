/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author João Salomão
 */
@Entity(name = "Patient")
@Table(name = "patients")
public class Patient {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "first_appointment_date")
    @Temporal(TemporalType.DATE)
    private Date firstAppointmentDate;

    @Column(name = "email", unique = true)
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "health_plan_id")
    HealthPlan healthPlan;

    @OneToMany(
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PhoneNumber> numbers;

    @OneToMany(
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Consultation> consultations;

    public Patient(int id, String name, String address, Date birthDate, Date firstAppointmentDate, String email, HealthPlan healthPlan, List<PhoneNumber> numbers, List<Consultation> consultations) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
        this.firstAppointmentDate = firstAppointmentDate;
        this.email = email;
        this.healthPlan = healthPlan;
        this.numbers = numbers;
        this.consultations = consultations;
    }

    public Patient(String name, String address, String email, String birthDate) throws ParseException {
        this.name = name;
        this.address = address;
        this.email = email;
        setBirthDate(birthDate);
    }

    public Patient() {
    }

    public Patient(String name, String address, String email, String birthDate, HealthPlan healthPlan) throws ParseException {
        this.name = name;
        this.address = address;
        this.email = email;
        this.healthPlan = healthPlan;
        setBirthDate(birthDate);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setBirthDate(String birthDate) throws ParseException {
        this.birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(birthDate);
    }

    public Date getFirstAppointmentDate() {
        return firstAppointmentDate;
    }

    public String getFirstAppointmentDateString() {
        if (firstAppointmentDate == null) {
            return "";
        } else {
            return firstAppointmentDate.toString();
        }
    }

    public void setFirstAppointmentDate(Date firstAppointmentDate) {
        this.firstAppointmentDate = firstAppointmentDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HealthPlan getHealthPlan() {
        return healthPlan;
    }
    
    public String getHealthPlanName() {
        return healthPlan == null ? "" : healthPlan.getName();
    }

    public void setHealthPlan(HealthPlan healthPlan) {
        this.healthPlan = healthPlan;
    }

    public List<PhoneNumber> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<PhoneNumber> numbers) {
        this.numbers = numbers;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

}
