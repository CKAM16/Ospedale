/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.model.persistence;

import java.util.ArrayList;
import packagee.core.model.appointment.Appointment;
import packagee.core.model.hospitalization.Hospitalization;
import packagee.core.model.prescription.Prescription;
import packagee.core.model.user.User;

/**
 *
 * @author harry
 */
public class DataStore {
    private static DataStore instance;
    
    private ArrayList<Hospitalization> hospitalizations;
    private ArrayList<Appointment> appointments;

    public static void setInstance(DataStore instance) {
        DataStore.instance = instance;
    }

    public void setHospitalizations(ArrayList<Hospitalization> hospitalizations) {
        this.hospitalizations = hospitalizations;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void setPrescriptions(ArrayList<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public ArrayList<Hospitalization> getHospitalizations() {
        return hospitalizations;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public ArrayList<Prescription> getPrescriptions() {
        return prescriptions;
    }
    private ArrayList<Prescription> prescriptions;
    
    private DataStore() {
        this.hospitalizations = new ArrayList<>();
        this.appointments = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }
    
    public static DataStore getInstance() {
        if (instance == null) {
            instance = new DataStore();
        }
        return instance;
    }
}
