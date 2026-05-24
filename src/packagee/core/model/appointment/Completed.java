/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.model.appointment;

/**
 *
 * @author harry
 */
public class Completed implements AppointmentStatusInterface {
    
    private String diagnosis;
    private String observations;
    private String treatment;
    private String followUp;
    
    public Completed(String diagnosis,String observations, String treatment, String followUp)
    {
        this.diagnosis = diagnosis;
        this.observations = observations;
        this.treatment = treatment;
        this.followUp  = followUp;
    }
    @Override
    public String getDiagnosis() {
        return this.diagnosis;
    }
    
    @Override
    public String getObservations() {
        return this.observations;
    }

    @Override
    public String getRecommendedTreatment() {
        return this.treatment;
    }

    @Override
    public String getFollowUp() {
        return this.followUp;
    }
    
    @Override
    public String getStatus() {
        return "Completed";
    }
}
