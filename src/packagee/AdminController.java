/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee;

/**
 *
 * @author paaoo
 */
public class AdminController {
    public Response registrarAdministrador(Administrator a) {
        String idStr = String.valueOf(a.getId());
        if (idStr.length() != 12 || !idStr.matches("\\d+")) {
            return new Response("ERROR", "ID inválido, debe tener 12 dígitos numéricos");
        }

        for (Administrator existente : DataStore.administradores) {
            if (existente.getId() == a.getId()) {
                return new Response("ERROR", "Ya existe un administrador con ese ID");
            }
        }

        if (a.getUsername() == null || a.getUsername().trim().isEmpty()) {
            return new Response("ERROR", "El nombre de usuario no puede estar vacío");
        }

        DataStore.administradores.add(a);
        return new Response("SUCCESS", "Administrador registrado correctamente");
    }

    public Response actualizarAdministrador(String id, Administrator nuevosDatos) {
        for (Administrator a : DataStore.administradores) {
            if (a.getId() == Long.parseLong(id)) {
                if (nuevosDatos.getUsername() == null || nuevosDatos.getUsername().trim().isEmpty()) {
                    return new Response("ERROR", "El nombre de usuario no puede estar vacío");
                }
                a.setUsername(nuevosDatos.getUsername());
                a.setFirstname(nuevosDatos.getFirstname());
                a.setLastname(nuevosDatos.getLastname());
                a.setPassword(nuevosDatos.getPassword());

                return new Response("SUCCESS", "Administrador actualizado correctamente");
            }
        }
        return new Response("ERROR", "Administrador no encontrado");
    }

    public Response obtenerAdministradores() {
        return new Response("SUCCESS", "Lista de administradores obtenida: " + DataStore.administradores.size());
    }
}
