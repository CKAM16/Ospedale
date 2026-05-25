/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.UI;

import packagee.core.model.user.User;
import packagee.core.model.user.admin.Administrator;
import packagee.core.model.user.doctor.Doctor;
import packagee.core.model.user.patient.Patient;

/**
 *
 * @author harry
 */
public class ViewsManager {
    
    private DoctorViewPanel DoctorView;
    private PatientViewPanel PatientView;
    private AdminViewPanel AdminView;
    private MainMenu MainMenu;
    private javax.swing.JFrame previous;

    public ViewsManager(DoctorViewPanel DoctorView, PatientViewPanel PatientView, AdminViewPanel AdminView, MainMenu MainMenu) {
        
        this.DoctorView = DoctorView;
        this.PatientView = PatientView;
        this.AdminView = AdminView;
        this.MainMenu = MainMenu;
    }
    
    public void start(){
        
        this.MainMenu.setVisible(true);
        this.DoctorView.setVisible(false);
        this.PatientView.setVisible(false);
        this.AdminView.setVisible(false);
   
    }
    
    public void goToDoctorView(){
        
        this.MainMenu.setVisible(false);
        this.DoctorView.setVisible(true);
        this.PatientView.setVisible(false);
        this.AdminView.setVisible(false);
        
    }
    
    public void goToAdminView(){
        
        this.MainMenu.setVisible(false);
        this.DoctorView.setVisible(false);
        this.PatientView.setVisible(false);
        this.AdminView.setVisible(true);
        
    }
    
    public void goToPatientView(){
        
        this.MainMenu.setVisible(false);
        this.DoctorView.setVisible(false);
        this.PatientView.setVisible(true);
        this.AdminView.setVisible(false);
        
    }
    public void navigateAfterLogin(User user) {
        
        if (user instanceof Doctor) {
            goToDoctorView();
        } else if (user instanceof Patient) {
            goToPatientView();
        } else if (user instanceof Administrator) {
            goToAdminView();
        }
    }
    public void goBackAdmin(){
        
        this.MainMenu.setVisible(false);
        this.DoctorView.setVisible(false);
        this.PatientView.setVisible(false);
        this.AdminView.setVisible(true);
    }
    public void returnToMenu(){
        
        this.MainMenu.setVisible(true);
        this.DoctorView.setVisible(false);
        this.PatientView.setVisible(false);
        this.AdminView.setVisible(false);
    }
    
   
}
