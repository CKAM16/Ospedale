/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.main;

import com.formdev.flatlaf.FlatDarkLaf;
import java.io.IOException;
import javax.swing.UIManager;
import packagee.core.UI.*;
import packagee.core.model.persistence.*;

/**
 *
 * @author harry
 */
public class main {
    
    public static void main(String[] args) throws IOException {
        
        DoctorViewPanel doctorView = new DoctorViewPanel();
        PatientViewPanel patientView = new PatientViewPanel();
        AdminViewPanel adminView = new AdminViewPanel();
        MainMenu mainMenu = new MainMenu();
        
        ViewsManager UI = new ViewsManager(doctorView, patientView, adminView, mainMenu);
        
        JSONLoad json = new JSONLoad();
        json.load("json/users.json");
        
        System.setProperty("flatlaf.useNativeLibrary", "false");

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
        UI.start();
    }
}
