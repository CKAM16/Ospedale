/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.model.persistence.serialize;

import java.util.HashMap;

/**
 *
 * @author harry
 */
public interface Serializable {
    
    public abstract HashMap<String, Object> serialize();
    
}
