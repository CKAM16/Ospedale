/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee;
import java.time.LocalDate;
/**
 *
 * @author paaoo
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
        DataStore.hospitalizaciones.add(hosp);

        return new Response("SUCCESS", "Hospitalización solicitada correctamente");
    }

    public Response aprobarHospitalizacion(String idHosp) {
        for (Hospitalization h : DataStore.hospitalizaciones) {
            if (h.getId().equals(idHosp)) {
                if (h.getStatus() != HospitalizationStatus.REQUESTED) {
                    return new Response("ERROR", "Solo se pueden aprobar hospitalizaciones en estado REQUESTED");
                }
                h.setStatus(HospitalizationStatus.ONGOING);
                return new Response("SUCCESS", "Hospitalización aprobada y marcada como ONGOING");
            }
        }
        return new Response("ERROR", "Hospitalización no encontrada");
    }

    public Response cancelarHospitalizacion(String idHosp) {
        for (Hospitalization h : DataStore.hospitalizaciones) {
            if (h.getId().equals(idHosp)) {
                if (h.getStatus() == HospitalizationStatus.ONGOING) {
                    return new Response("ERROR", "No se puede cancelar una hospitalización en curso");
                }
                h.setStatus(HospitalizationStatus.CANCELED);
                return new Response("SUCCESS", "Hospitalización cancelada correctamente");
            }
        }
        return new Response("ERROR", "Hospitalización no encontrada");
    }

    public Response obtenerHospitalizaciones() {
        return new Response("SUCCESS", "Lista de hospitalizaciones obtenida: " + DataStore.hospitalizaciones.size());
    }
}
