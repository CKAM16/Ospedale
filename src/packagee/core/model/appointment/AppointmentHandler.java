/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.model.appointment;

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
    
    public void changeStatus(AppointmentStatusInterface I)
    {
        appointment.setDiagnosis(I.getDiagnosis());
        appointment.setFollowUp(I.getFollowUp());
        appointment.setObservations(I.getObservations());
        appointment.setRecommendedTreatment(I.getRecommendedTreatment());
        
    }
}
