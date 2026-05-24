/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.apointment;

/**
 *
 * @author harry
 */
public class AppointmentHandler {
    private Appointment appointment;
    
    public AppointmentHandler(Appointment appointment)
    {
        this.appointment = appointment;
    }
    
     public boolean complete(String diagnosis, String observations, String treatment, String followUp) {
        this.appointment.setDiagnosis(diagnosis);
        this.appointment.setObservations(observations);
        this.appointment.setRecommendedTreatment(treatment);
        this.appointment.setFollowUp(followUp);
        this.appointment.setStatus(AppointmentStatus.COMPLETED);
        return true;
    }

    public boolean cancel() {
        this.appointment.setStatus(AppointmentStatus.CANCELED);
        return true;
    }
    
    public boolean accept()
    {
        this.appointment.setStatus(AppointmentStatus.PENDING);
        return true;
    }
}
