/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.model.persistence.serialize;

import java.time.LocalDate;
import java.util.HashMap;
import packagee.core.model.user.doctor.Doctor;
import packagee.core.model.user.patient.Patient;

/**
 *
 * @author harry
 */
public class DoctorSerializable implements Serializable{

    private Doctor doctor;
    
    public DoctorSerializable(Doctor doctor){
        this.doctor = doctor;
    }
    
    @Override
    public HashMap<String, Object> serialize() {
        HashMap<String, Object> serializedData = new HashMap<>();
        
        serializedData.put("type", this.doctor.getClass().toString());
        serializedData.put("id", this.doctor.getId());
        serializedData.put("username", this.doctor.getUsername());
        serializedData.put("firstname", this.doctor.getFirstname());
        serializedData.put("lastname", this.doctor.getLastname());
        serializedData.put("password", this.doctor.getPassword());
        serializedData.put("specialty", this.doctor.getSpecialty());
        serializedData.put("license number", this.doctor.getLicenceNumber());
        serializedData.put("office", this.doctor.getAssignedOffice());

        return serializedData;
    }
}
