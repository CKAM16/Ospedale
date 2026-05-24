/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.model.persistence.Observer;

import java.util.ArrayList;
import packagee.core.model.user.User;

/**
 *
 * @author harry
 */
public abstract class Observable {
    
    protected ArrayList<Observer> observers;

    public Observable() {
        this.observers = new ArrayList<>();
    }
    
    public boolean addObserver(Observer observer) {
        this.observers.add(observer);
        observer.setObservable(this);
        System.out.println(observer + " is observing " + this);
        return true;
    }
    
    protected void notifyAll(User user) {
        for (Observer observer : this.observers) {
            observer.notify(user);
        }
    }
}
