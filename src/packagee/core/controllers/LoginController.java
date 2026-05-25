/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.controllers;

import packagee.core.model.persistence.Storage;
import packagee.core.controllers.util.Response;
import packagee.core.model.user.User;

/**
 *
 * @author paaoo
 */
public class LoginController {
    
    private User loggedUser;
    
    public Response login(String username, String password) {
        for (User u : Storage.getInstance().getPersons()) {

            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                loggedUser = u;
                return new Response("SUCCESS", u.getClass().toString());
            }
        }
        System.out.println("NOOB");
        return new Response("ERROR", "Usuario o contraseña incorrectos");
    }

    public Response logout() {
        return new Response("SUCCESS", "Sesión cerrada correctamente");
    }
    public User getLoggedUser(){
        return this.loggedUser;
    }
}

