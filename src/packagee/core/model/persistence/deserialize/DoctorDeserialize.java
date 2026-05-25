/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.model.persistence.deserialize;

import java.time.LocalDate;
import java.util.ArrayList;
import org.json.JSONObject;
import packagee.core.model.user.doctor.Specialty;
import packagee.core.model.appointment.Appointment;
import packagee.core.model.hospitalization.Hospitalization;
import packagee.core.model.user.User;
import packagee.core.model.user.doctor.Doctor;
import packagee.core.model.user.patient.Patient;

/**
 *
 * @author harry
 */
public class DoctorDeserialize implements Deserializable{

    private long id;
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    
    private String specialty;
    private String licenceNumber;
    private String assignedOffice;

    @Override
    public User user(JSONObject json) {
        
        this.id = (long) json.get("id");
        this.username = (String) json.get("username");
        this.firstname = (String) json.get("firstname");
        this.lastname = (String) json.get("lastname");
        this.password = (String) json.get("password");
        
        this.specialty = (String) json.get("specialty");
        this.licenceNumber = (String) json.get("licenceNumber");
        this.assignedOffice = (String) json.get("assignedOffice");
        
        Doctor d = new Doctor(id, username, firstname, lastname, password, Specialty.valueOf(specialty), licenceNumber, assignedOffice);
        return d;
    }
    @Override
    public String getType(){
        return "doctor";
    }
    
}
