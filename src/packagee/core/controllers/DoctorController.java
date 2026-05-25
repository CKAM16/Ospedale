/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.controllers;

import packagee.core.controllers.util.Response;
import packagee.core.model.persistence.Storage;
import packagee.core.model.user.User;
import packagee.core.model.user.doctor.Doctor;
import packagee.core.model.user.doctor.Specialty;

/**
 *
 * @author paaoo
 */
public class DoctorController {
    
    public Response registrarDoctor(String id, String username, String firstname, String lastname, String password, String specialty, String licenceNumber, String assignedOffice) {
        
        String idStr = id;
        if (idStr.length() != 12 || !idStr.matches("\\d+")) {
            return new Response("ERROR", "ID inválido, debe tener 12 dígitos numéricos");
        }

        for (User existente : Storage.getInstance().getPersons()) {
            if (String.valueOf(existente.getId()) == id) {
                return new Response("ERROR", "Ya existe un doctor con ese ID");
            }
        }

        //formato L-XXXXXXXXXX MTL
        if (!licenceNumber.matches("^L-\\d{10} MTL$")) {
            return new Response("ERROR", "Licencia inválida, formato correcto: L-XXXXXXXXXX MTL");
        }

        // formato O-XXX
        if (!assignedOffice.matches("^O-\\d{3}$")) {
            return new Response("ERROR", "Oficina inválida, formato correcto: O-XXX");
        }

        
        if (specialty == null) {
            return new Response("ERROR", "Especialidad no puede estar vacía");
        }
        long doctorID = Long.parseLong(id);
        Specialty doctorSpecialty = Specialty.valueOf(specialty);
        
        Doctor d = new Doctor(doctorID, username, firstname, lastname, password, doctorSpecialty, licenceNumber, assignedOffice);
        Storage.getInstance().getPersons().add(d);
        return new Response("SUCCESS", "Doctor registrado correctamente");
    }

    public Response actualizarDoctor(String id, Doctor nuevosDatos) {
        
        for (User d : Storage.getInstance().getPersons()) {
            if( d instanceof Doctor){
                if (d.getId() == Long.parseLong(id)) {

                    if (!nuevosDatos.getLicenceNumber().matches("^L-\\d{10} MTL$")) {
                        return new Response("ERROR", "Licencia inválida, formato correcto: L-XXXXXXXXXX MTL");
                    }
                    if (!nuevosDatos.getAssignedOffice().matches("^O-\\d{3}$")) {
                        return new Response("ERROR", "Oficina inválida, formato correcto: O-XXX");
                    }
                    if (nuevosDatos.getSpecialty() == null) {
                        return new Response("ERROR", "Especialidad no puede estar vacía");
                    }

                    d.setLicenceNumber(nuevosDatos.getLicenceNumber());
                    d.setAssignedOffice(nuevosDatos.getAssignedOffice());
                    d.setSpecialty(nuevosDatos.getSpecialty());

                    return new Response("SUCCESS", "Doctor actualizado correctamente");
                }
            }
        }
        return new Response("ERROR", "Doctor no encontrado");
    }

    public Response obtenerDoctores() {
        return new Response("SUCCESS", "Lista de getPersons() obtenida: " + Storage.getInstance().getPersons().size());
    }
}