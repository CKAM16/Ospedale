/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.model.persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.json.JSONArray;
import packagee.core.model.persistence.serialize.Serializable;
import org.json.JSONObject;

/**
 *
 * @author harry
 */
public class JSONSave {

    public void SaveUser(Serializable s, String path) throws IOException{
        
        JSONObject object = new JSONObject(s.serialize());
        
        String content = new String(Files.readAllBytes(Paths.get(path)));
        JSONObject root = new JSONObject(content);
        JSONArray users = root.getJSONArray("users");
        
        users.put(object);

        Files.write(Paths.get(path), root.toString(4).getBytes());
    }
}
