package packagee.core.model.appointment;

import packagee.core.model.appointment.AppointmentStatusInterface;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author harry
 */
public class Request implements AppointmentStatusInterface {

    @Override
    public String getDiagnosis() {
        return null;
    }
    

    @Override
    public String getObservations() {
        return null;
    }

    @Override
    public String getRecommendedTreatment() {
        return null;
    }

    @Override
    public String getFollowUp() {
        return null;
    }
    
    @Override
    public String getStatus() {
        return "Request";
    }
    
}

