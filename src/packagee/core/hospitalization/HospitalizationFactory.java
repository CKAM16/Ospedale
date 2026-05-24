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
public class HospitalizationFactory {

    public Hospitalization create(String id, Patient patient, Doctor doctor, LocalDate date, String reason, RoomType roomType, String observations){
        Hospitalization hosp = new Hospitalization( id,  patient,  doctor,  date,  reason,  roomType,  observations);
        patient.setHospitalization(hosp);
        doctor.addHospitalization(hosp);
        return hosp;
    }
}
