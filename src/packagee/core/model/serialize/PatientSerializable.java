/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.model.serialize;

import java.time.LocalDate;
import java.util.HashMap;
import packagee.core.model.user.patient.Patient;

/**
 *
 * @author harry
 */
public class PatientSerializable implements Serializable{

    private Patient patient;
    
    public PatientSerializable(Patient patient){
        this.patient = patient;
    }
    
    @Override
    public HashMap<String, Object> serialize() {
        HashMap<String, Object> serializedData = new HashMap<>();
        
        serializedData.put("type", this.patient.getClass().toString());
        serializedData.put("id", this.patient.getId());
        serializedData.put("username", this.patient.getUsername());
        serializedData.put("firstname", this.patient.getFirstname());
        serializedData.put("lastname", this.patient.getLastname());
        serializedData.put("password", this.patient.getPassword());
        serializedData.put("email", this.patient.getEmail());
        serializedData.put("birthdate", this.patient.getDate());
        serializedData.put("gender", this.patient.getGender());
        serializedData.put("phone", this.patient.getPhone());
        serializedData.put("addres", this.patient.getAddress());
        serializedData.put("appointments", this.patient.getAppointments());

        return serializedData;
    }
    
}
