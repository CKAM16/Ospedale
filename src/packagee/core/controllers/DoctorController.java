/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.controllers;

import java.io.IOException;
import packagee.core.controllers.util.Response;
import packagee.core.model.persistence.JSONSave;
import packagee.core.model.persistence.Storage;
import packagee.core.model.persistence.serialize.DoctorSerializable;
import packagee.core.model.persistence.serialize.PatientSerializable;
import packagee.core.model.user.User;
import packagee.core.model.user.doctor.Doctor;
import packagee.core.model.user.doctor.Specialty;
import packagee.core.model.user.patient.Patient;

/**
 *
 * @author harry
 */
 public class DoctorController {
     
    private JSONSave json;
    public DoctorController(JSONSave json) {
        this.json = json;
    }
     
     public Response registrarDoctor(String id, String username, String firstname, String lastname, String password, String spec, String licenceNumber, String assignedOffice) throws IOException {
        if (id.length() != 12 || !id.matches("\\d+"))
            return new Response("ERROR", "ID inválido, debe tener 12 dígitos numéricos");

        for (User existente : Storage.getInstance().getPersons()) {
            if (String.valueOf(existente.getId()).equals(id))
                return new Response("ERROR", "Ya existe un doctor con ese ID");
        }

        if (!licenceNumber.matches("^L-\\d{10} MTL$"))
            return new Response("ERROR", "Licencia inválida, formato correcto: L-XXXXXXXXXX MTL");

        if (!assignedOffice.matches("^O-\\d{3}$"))
            return new Response("ERROR", "Oficina inválida, formato correcto: O-XXX");

        Specialty specialty;
        try {
            specialty = Specialty.valueOf(spec.toUpperCase().replace(" & ", "_").replace(" ", "_"));
        } catch (IllegalArgumentException e) {
            return new Response("ERROR", "Especialidad no válida: " + spec);
        }

        Doctor d = new Doctor(Long.parseLong(id), username, firstname, lastname, password, specialty, licenceNumber, assignedOffice);
        Storage.getInstance().addPerson(d);
        try {
            json.SaveUser(new DoctorSerializable(d), "json/users.json");
            } catch (IOException e) {
                return new Response("ERROR", "Error al escribir en el archivo: " + e.getMessage());
            }

        return new Response("SUCCESS", "Doctor registrado correctamente");
    }

    public Response actualizarDoctor(String id, String username, String firstname, String lastname, String password, String spec, String licenceNumber, String assignedOffice) {
        for (User u : Storage.getInstance().getPersons()) {
            if (u instanceof Doctor && String.valueOf(u.getId()).equals(id)) {
                Doctor d = (Doctor) u;

                if (!licenceNumber.matches("^L-\\d{10} MTL$")) {
                    return new Response("ERROR", "Licencia inválida, formato correcto: L-XXXXXXXXXX MTL");
                }
                if (!assignedOffice.matches("^O-\\d{3}$")) {
                    return new Response("ERROR", "Oficina inválida, formato correcto: O-XXX");
                }

                Specialty specialty;
                try {
                    specialty = Specialty.valueOf(spec.toUpperCase().replace(" & ", "_").replace(" ", "_"));
                } catch (IllegalArgumentException e) {
                    return new Response("ERROR", "Especialidad no válida");
                }
                if (spec == null || spec.equalsIgnoreCase("Select one")) {
                    return new Response("ERROR", "Por favor seleccione una especialidad válida");
                }

                d.setUsername(username);
                d.setFirstname(firstname);
                d.setLastname(lastname);
                d.setPassword(password);
                d.setSpecialty(specialty);
                d.setLicenceNumber(licenceNumber);
                d.setAssignedOffice(assignedOffice);

                return new Response("SUCCESS", "Doctor actualizado correctamente");
            }
        }
        return new Response("ERROR", "Doctor no encontrado");
    }
    public Response obtenerDoctores() {
        return new Response("SUCCESS", "Lista de doctores obtenida: " + Storage.getInstance().getPersons().size());
    }
}