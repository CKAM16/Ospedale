/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.model.persistence.deserialize;

import org.json.JSONObject;
import packagee.core.model.user.User;
import packagee.core.model.user.admin.Administrator;

/**
 *
 * @author harry
 */
public class AdminDeserialize implements Deserializable{

    private long id;
    private String username;
    private String firstname;
    private String lastname;
    private String password;

    @Override
    public User user(JSONObject json) {
        
        this.id = (int) json.get("id");
        this.username = (String) json.get("username");
        this.firstname = (String) json.get("firstname");
        this.lastname = (String) json.get("lastname");
        this.password = (String) json.get("password");
     
        Administrator a = new Administrator(id, username, firstname, lastname, password);
        return a;
    }

    @Override
    public String getType(){
        return "Administrator";
    }
    
}
