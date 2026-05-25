/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.controllers;

import java.io.IOException;
import java.time.LocalDate;
import packagee.core.controllers.util.Response;
import packagee.core.model.persistence.JSONSave;
import packagee.core.model.persistence.Observer.Observable;
import packagee.core.model.persistence.Storage;
import packagee.core.model.user.User;
import packagee.core.model.user.patient.Patient;
import packagee.core.model.persistence.UserChanger;
import packagee.core.model.persistence.serialize.PatientSerializable;

/**
 *
 * @author paaoo
 */
public class PatientController extends Observable {

    private JSONSave json;
    
    public PatientController(JSONSave json){
        this.json = json;
    }

    public Response registrarPaciente(String id,String firstname, String lastname,String gender, String birthdate,String address, String phone ,String email, String user,String password, String comPassword) throws IOException {
        String idStr = id;
        if (idStr.length() != 12 || !idStr.matches("\\d+")) {
            return new Response("ERROR", "ID inválido, debe tener 12 dígitos numéricos");
        }


        for (User existente : Storage.getInstance().getPersons()) {
            if (String.valueOf(existente.getId()) == id){
                return new Response("ERROR", "Ya existe un paciente con ese ID");
            }
        }
        
        String telefono = phone;
        if (telefono.length() != 10 || !telefono.matches("\\d+")) {
            return new Response("ERROR", "Teléfono debe tener exactamente 10 dígitos");
        }


        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            return new Response("ERROR", "Email inválido, debe seguir el formato usuario@dominio.com");
        }


        if (!birthdate.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            return new Response("ERROR", "Fecha de nacimiento inválida, formato AAAA-MM-DD");
        }

        long patientID = Long.parseLong(id);
        long patientPhone = Long.parseLong(telefono);
        LocalDate patientBirthdate = LocalDate.parse(birthdate);
        boolean patientGender = Boolean.parseBoolean(gender);
        
        
        Patient p = new Patient(patientID, user, firstname, lastname, password, email, patientBirthdate, patientGender, patientPhone, address);
        Storage.getInstance().getPersons().add(p);
        
        json.SaveUser(new PatientSerializable(p), "json/users.json");
        
        System.out.println("BUENAA");
        
        return new Response("SUCCESS", "Paciente registrado correctamente");
    }

    public Response actualizarPaciente(String id, Patient nuevosDatos) {
        for (User p : Storage.getInstance().getPersons()) {
            if ( p instanceof Patient){
                if (p.getId() == Long.parseLong(id)) {
                    
                    String telefono = String.valueOf(nuevosDatos.getPhone());
                    if (telefono.length() != 10 || !telefono.matches("\\d+")) {
                        return new Response("ERROR", "Teléfono debe tener exactamente 10 dígitos");
                    }
                    if (!nuevosDatos.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                        return new Response("ERROR", "Email inválido");
                    }
                    if (!nuevosDatos.getDate().toString().matches("^\\d{4}-\\d{2}-\\d{2}$")) {
                        return new Response("ERROR", "Fecha de nacimiento inválida");
                    }
                    
                    p.setFirstname(nuevosDatos.getFirstname());
                    p.setLastname(nuevosDatos.getLastname());
                    p.setEmail(nuevosDatos.getEmail());
                    p.setPhone(nuevosDatos.getPhone());
                    p.setAddress(nuevosDatos.getAddress());
                    p.setBirthdate(nuevosDatos.getDate());
                    p.setGender(nuevosDatos.getGender());
                    p.setUsername(nuevosDatos.getUsername());
                    p.setPassword(nuevosDatos.getPassword());
                    
                    System.out.println("ESOOO");
                    return new Response("SUCCESS", "Paciente actualizado correctamente");
                }
            }
        }
        return new Response("ERROR", "Paciente no encontrado");
    }
    
    public Patient buscarPaciente(long id) {
        for (User u : Storage.getInstance().getPersons()) {
            if (u instanceof Patient && u.getId() == id) {
                return (Patient) u;
            }
        }
        return null;
    }

    public Response obtenerPersons() {
        return new Response("SUCCESS", "Lista de getPersons() obtenida: " + Storage.getInstance().getPersons().size());
    }
}
