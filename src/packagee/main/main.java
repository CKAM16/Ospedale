/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.main;

import com.formdev.flatlaf.FlatDarkLaf;
import java.io.IOException;
import javax.swing.UIManager;
import packagee.core.UI.*;
import packagee.core.controllers.*;
import packagee.core.model.persistence.*;
import packagee.core.model.persistence.deserialize.*;

/**
 *
 * @author harry
 */
public class main {
    
    public static void main(String[] args) throws IOException {
        
        Storage storage = Storage.getInstance();
        
        JSONLoad json = new JSONLoad(storage);
        json.addDeserializable(new AdminDeserialize());
        json.addDeserializable(new DoctorDeserialize());
        json.addDeserializable(new PatientDeserialize());
        
        JSONSave jsonsave = new JSONSave();
        json.load("json/users.json");
        
        LoginController login = new LoginController();
        PatientController patient = new PatientController( jsonsave);
        
        System.setProperty("flatlaf.useNativeLibrary", "false");

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                DoctorViewPanel doctorView = new DoctorViewPanel();
                PatientViewPanel patientView = new PatientViewPanel();
                AdminViewPanel adminView = new AdminViewPanel();
                MainMenu mainMenu = new MainMenu(patient, login);

                ViewsManager UI = new ViewsManager(doctorView, patientView, adminView, mainMenu);
                mainMenu.setViewManager(UI);
                
                UI.start();
            };
        });
    }
}
