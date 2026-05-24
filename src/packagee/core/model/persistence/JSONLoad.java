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
import org.json.JSONObject;
import packagee.core.model.persistence.deserialize.Deserializable;

/**
 *
 * @author harry
 */
public class JSONLoad {
    
    private ArrayList<Deserializable> deserializables = new ArrayList<>();
    private Storage storage;
            
    public void load(String path) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(path)));
        JSONObject root = new JSONObject(content);
        JSONArray users = root.getJSONArray("users");
        
        for (int i = 0; i < users.length(); i++) {

            JSONObject object = users.getJSONObject(i);
            
            for (Deserializable d : deserializables){
                if (d.getType() == object.get("Type")){
                    storage.addPerson(d.user(object));
                }
            }
        }
    }
    public void addDeserializable(Deserializable d){
        this.deserializables.add(d);
    }
}
    