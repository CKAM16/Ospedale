/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.prescription;

import packagee.core.apointment.Appointment;
import packagee.core.apointment.AppointmentStatus;
import packagee.core.prescription.Prescription;

/**
 *
 * @author harry
 */
public class PrescriptionFactory {
    
    private Appointment appointment;
    
    public PrescriptionFactory(Appointment appointment)
    {
        this.appointment = appointment;
    }
    
    public boolean prescribe(String medicationName, double dose, String administrationRoute, int treatmentDuration, String additionalInstructions, int frecuency)
    {
        Prescription newPrescription = new Prescription(this.appointment, medicationName, dose, administrationRoute, treatmentDuration, additionalInstructions, frecuency);
        return this.appointment.addPrescription(newPrescription);
    }
}
