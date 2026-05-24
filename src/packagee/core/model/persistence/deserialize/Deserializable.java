package packagee.core.model.persistence.deserialize;

import org.json.JSONObject;
import packagee.core.model.user.User;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author harry
 */
public interface Deserializable {
    
    public abstract User user(JSONObject json);
    public abstract String getType();
}
