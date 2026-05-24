/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee;

/**
 *
 * @author paaoo
 */
public class PatientController {

  
    public Response registrarPaciente(Patient p) {
        
        if (p.getId().length() != 12 || !p.getId().matches("\\d+")) {
            return new Response("ERROR", "ID inválido, debe tener 12 dígitos numéricos");
        }
        for (Patient existente : DataStore.pacientes) {
            if (existente.getId().equals(p.getId())) {
                return new Response("ERROR", "Ya existe un paciente con ese ID");
            }
        }

        if (p.getTelefono().length() != 10 || !p.getTelefono().matches("\\d+")) {
            return new Response("ERROR", "Teléfono debe tener exactamente 10 dígitos");
        }

        if (!p.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            return new Response("ERROR", "Email inválido, debe seguir el formato usuario@dominio.com");
        }

       //(AAAA-MM-DD)
        if (!p.getBirthdate().matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            return new Response("ERROR", "Fecha de nacimiento inválida, formato AAAA-MM-DD");
        }

        DataStore.pacientes.add(p);
        return new Response("SUCCESS", "Paciente registrado correctamente");
    }

    public Response actualizarPaciente(String id, Patient nuevosDatos) {
        for (Patient p : DataStore.pacientes) {
            if (p.getId().equals(id)) {
                // Validaciones iguales a registrar
                if (nuevosDatos.getTelefono().length() != 10 || !nuevosDatos.getTelefono().matches("\\d+")) {
                    return new Response("ERROR", "Teléfono debe tener exactamente 10 dígitos");
                }
                if (!nuevosDatos.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    return new Response("ERROR", "Email inválido");
                }
                if (!nuevosDatos.getFechaNacimiento().matches("^\\d{4}-\\d{2}-\\d{2}$")) {
                    return new Response("ERROR", "Fecha de nacimiento inválida");
                }

                p.update(nuevosDatos);
                return new Response("SUCCESS", "Paciente actualizado correctamente");
            }
        }
        return new Response("ERROR", "Paciente no encontrado");
    }

    public Response obtenerPacientes() {
        return new Response("SUCCESS", "Lista de pacientes obtenida: " + DataStore.pacientes.size());
    }
}
