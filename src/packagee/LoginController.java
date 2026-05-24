/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee;

/**
 *
 * @author paaoo
 */
public class LoginController {
    public Response login(String username, String password) {
        for (User u : DataStore.usuarios) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return new Response("SUCCESS", u.getRole());
            }
        }
        return new Response("ERROR", "Usuario o contraseña incorrectos");
    }

    public Response logout() {
        return new Response("SUCCESS", "Sesión cerrada correctamente");
    }
}

