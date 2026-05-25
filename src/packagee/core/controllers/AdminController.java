/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.controllers;

import packagee.core.controllers.util.Response;
import packagee.core.model.persistence.Storage;
import packagee.core.model.user.User;
import packagee.core.model.user.admin.Administrator;

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

        for (User existente : Storage.getInstance().getPersons()) {
            if (existente.getId() == a.getId()) {
                return new Response("ERROR", "Ya existe un administrador con ese ID");
            }
        }

        if (a.getUsername() == null || a.getUsername().trim().isEmpty()) {
            return new Response("ERROR", "El nombre de usuario no puede estar vacío");
        }

        Storage.getInstance().getPersons().add(a);
        return new Response("SUCCESS", "Administrador registrado correctamente");
    }

    public Response actualizarAdministrador(String id, Administrator nuevosDatos) {
        for (User a : Storage.getInstance().getPersons()) {
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
        return new Response("SUCCESS", "Lista de getPersons; obtenida: " + Storage.getInstance().getPersons().size());
    }
}
