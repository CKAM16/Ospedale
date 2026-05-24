/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.model.persistence.Observer;

import packagee.core.model.user.User;

/**
 *
 * @author harry
 */
public abstract class Observer {
    
    protected Observable observable;

    public Observer() {
        this.observable = null;
    }
    
    public abstract void notify(User user);
    
    public void setObservable(Observable observable) {
        this.observable = observable;
    }
}
