/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.model.persistence.deserialize;

import java.time.LocalDate;
import java.util.ArrayList;
import org.json.JSONObject;
import packagee.core.model.appointment.Appointment;
import packagee.core.model.hospitalization.Hospitalization;
import packagee.core.model.user.User;
import packagee.core.model.user.patient.Patient;

/**
 *
 * @author harry
 */
public class PatientDeserialize implements Deserializable{

    private long id;
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    
    private String email;
    private String birthdate;
    private boolean gender;
    private long phone;
    private String address;

    @Override
    public User user(JSONObject json) {
        
        this.id = (long) json.get("id");
        this.username = (String) json.get("username");
        this.firstname = (String) json.get("firstname");
        this.lastname = (String) json.get("lastname");
        this.password = (String) json.get("password");
        
        this.email = (String) json.get("email");
        this.birthdate = (String) json.get("birthdate");
        this.gender = (boolean) json.get("gender");
        this.phone = (long) json.get("phone");
        this.address = (String) json.get("address");
        
        Patient p = new Patient(id, username, firstname, lastname, password, email, LocalDate.parse(birthdate), gender, phone, address);
        return p;
    }
    @Override
    public String getType(){
        return "patient";
    }
    
}
