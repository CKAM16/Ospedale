/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.model.persistence;

import java.util.ArrayList;
import packagee.core.model.user.User;

/**
 *
 * @author harry
 */
public class Storage {

    private static Storage instance;

    private ArrayList<User> persons;
    
    private Storage() {
        this.persons = new ArrayList<>();
    }
    
    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }
    
    public boolean addPerson(User user) {
        for (User u : this.persons) {
            if (u.getId() == user.getId()) {
                return false;
            }
        }
        this.persons.add(user);
        return true;
    }
    
    public User getPerson(int id) {
        for (User u : this.persons) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }
    
    public boolean delPerson(int id) {
        for (User u : this.persons) {
            if (u.getId() == id) {
                this.persons.remove(u);
                return true;
            }
        }
        return false;
    }
    
}