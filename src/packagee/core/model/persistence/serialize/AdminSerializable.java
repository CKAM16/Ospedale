/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.model.persistence.serialize;

import java.util.HashMap;
import packagee.core.model.user.admin.Administrator;
import packagee.core.model.user.doctor.Doctor;

/**
 *
 * @author harry
 */
public class AdminSerializable implements Serializable{

    private Administrator admin;
    
    public AdminSerializable(Administrator admin){
        this.admin = admin;
    }
    
    @Override
    public HashMap<String, Object> serialize() {
        HashMap<String, Object> serializedData = new HashMap<>();
        
        serializedData.put("type", this.admin.getClass().toString());
        serializedData.put("id", this.admin.getId());
        serializedData.put("username", this.admin.getUsername());
        serializedData.put("firstname", this.admin.getFirstname());
        serializedData.put("lastname", this.admin.getLastname());
        serializedData.put("password", this.admin.getPassword());
        
        return serializedData;
    }
}
