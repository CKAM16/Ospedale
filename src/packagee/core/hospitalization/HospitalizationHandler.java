/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.hospitalization;

import java.time.LocalDate;
import packagee.core.room.RoomType;
import packagee.core.user.doctor.Doctor;
import packagee.core.user.patient.Patient;

/**
 *
 * @author harry
 */
public class HospitalizationHandler {

    private Hospitalization hosp;
    
    public HospitalizationHandler(Hospitalization hosp){
        this.hosp = hosp;
    }
    public boolean cancel(){
        hosp.setStatus(HospitalizationStatus.CANCELED);
        return true;
    }
    public boolean activate(Hospitalization hosp) {
        hosp.setStatus(HospitalizationStatus.ONGOING);
        return true;
    }
}
