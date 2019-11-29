/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.Connection;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import models.Consultation;

/**
 *
 * @author João Salomão
 */
public class ConsultationsController {

    private final EntityManager entityManager;

    public ConsultationsController() {
        entityManager = Connection.getEntityManager();
    }

    public ArrayList<Consultation> all() {
        try {
            ArrayList<Consultation> patients = (ArrayList<Consultation>) entityManager
                    .createQuery("FROM Consultation as consultations")
                    .getResultList();
            return patients;
        } catch (Exception e) {
            System.out.println("ERRO AO PEGAR TODOS OS PLANOS DE SAÚDE DO BANCO: " + e.getMessage());
            return null;
        }
    }
}
