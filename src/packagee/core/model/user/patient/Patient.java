/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.model.user.patient;

import packagee.core.model.user.User;
import packagee.core.model.appointment.Appointment;
import java.time.LocalDate;
import java.util.ArrayList;
import packagee.core.model.hospitalization.Hospitalization;

/**
 *
 * @author edangulo
 */
public class Patient extends User {
    
    private String email;

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    private LocalDate birthdate;
    private boolean gender;
    private long phone;
    private String address;
    private ArrayList<Appointment> appointments;
    private Hospitalization hospitalization;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHospitalization(Hospitalization hospitalization) {
        this.hospitalization = hospitalization;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }
    
    public void addAppointment(Appointment a) {
        this.appointments.add(a);
    }

    public Patient(long id, String username, String firstname, String lastname, String password, String email, LocalDate birthdate, boolean gender, long phone, String address) {
        super(id, username, firstname, lastname, password);

        this.email = email;
        this.birthdate = birthdate;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.appointments = new ArrayList<>();
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public LocalDate getDate(){
        return this.birthdate;
    }
    
    public long getPhone(){
        return this.phone;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    public boolean getGender(){
        return this.gender;
    }  

    public String getHospitalizations() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
