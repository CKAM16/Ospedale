/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.model.hospitalization;

/**
 *
 * @author harry
 */
public class CANCELED implements HospitalizationStatus{

    @Override
    public String getStatus() {
        return "CANCELED";
    }
    
}
