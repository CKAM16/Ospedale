/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee.core.controllers;

import java.time.LocalDate;
import packagee.core.controllers.util.Response;
import packagee.core.model.hospitalization.CANCELED;
import packagee.core.model.hospitalization.Hospitalization;
import packagee.core.model.hospitalization.HospitalizationHandler;
import packagee.core.model.hospitalization.ONGOING;
import packagee.core.model.persistence.DataStore;
import packagee.core.model.room.RoomType;
import packagee.core.model.user.doctor.Doctor;
import packagee.core.model.user.patient.Patient;

/**
 *
 * @author paaoo
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class HospitalizationController {

    public Response solicitarHospitalizacion(String id, Patient paciente, Doctor doctor, String fecha, String reason, RoomType roomType, String observations) {
        // Validar fecha en formato AAAA-MM-DD
        LocalDate fechaValida;
        try {
            fechaValida = LocalDate.parse(fecha);
        } catch (Exception e) {
            return new Response("ERROR", "Fecha inválida, formato correcto: AAAA-MM-DD");
        }

        Hospitalization hosp = new Hospitalization(id, paciente, doctor, fechaValida, reason, roomType, observations);
        DataStore.getInstance().getHospitalizations().add(hosp);

        return new Response("SUCCESS", "Hospitalización solicitada correctamente");
    }

    public Response aprobarHospitalizacion(String idHosp) {
        for (Hospitalization h : DataStore.getInstance().getHospitalizations()){
            if (h.getId().equals(idHosp)) {
                if (h.getStatus() != "REQUESTED") {
                    return new Response("ERROR", "Solo se pueden aprobar getHospitalizations() en estado REQUESTED");
                }
                HospitalizationHandler handler = new HospitalizationHandler(h);
                handler.changeStatus(new ONGOING());
                return new Response("SUCCESS", "Hospitalización aprobada y marcada como ONGOING");
            }
        }
        return new Response("ERROR", "Hospitalización no encontrada");
    }

    public Response cancelarHospitalizacion(String idHosp) {
        for (Hospitalization h : DataStore.getInstance().getHospitalizations()) {
            if (h.getId().equals(idHosp)) {
                if (h.getStatus() == "ONGOING") {
                    return new Response("ERROR", "No se puede cancelar una hospitalización en curso");
                }
                HospitalizationHandler handler = new HospitalizationHandler(h);
                handler.changeStatus(new CANCELED());
                return new Response("SUCCESS", "Hospitalización cancelada correctamente");
            }
        }
        return new Response("ERROR", "Hospitalización no encontrada");
    }

    public Response obtenerHospitalizaciones() {
        return new Response("SUCCESS", "Lista de getHospitalizations() obtenida: " + DataStore.getInstance().getHospitalizations().size());
    }
}
