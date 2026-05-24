/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.model.hospitalization;

import java.time.LocalDate;
import packagee.core.model.room.RoomType;
import packagee.core.model.user.doctor.Doctor;
import packagee.core.model.user.patient.Patient;

/**
 *
 * @author harry
 */
public class HospitalizationHandler {

    private Hospitalization hosp;
    
    public HospitalizationHandler(Hospitalization hosp){
        this.hosp = hosp;
    }
    
    public void changeStatus(HospitalizationStatus S){
        hosp.setStatus(S.getStatus());
    }
}
