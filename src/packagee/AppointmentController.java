/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

/**
 *
 * @author paaoo
 */
public class AppointmentController {

    public Response solicitarCita(String id, Patient paciente, Doctor doctor, Specialty specialty, String fechaHora, String reason, boolean type) {
        LocalDateTime datetime;
        try {
            datetime = LocalDateTime.parse(fechaHora);
        } catch (DateTimeParseException e) {
            return new Response("ERROR", "Fecha y hora inválidas, formato correcto: AAAA-MM-DDTHH:MM");
        }

        Appointment cita = new Appointment(id, paciente, doctor, specialty, datetime, reason, type);
        DataStore.citas.add(cita);

        return new Response("SUCCESS", "Cita solicitada correctamente");
    }

    public Response aprobarCita(String idCita) {
        for (Appointment a : DataStore.citas) {
            if (a.getId().equals(idCita)) {
                if (a.getStatus() != AppointmentStatus.REQUESTED) {
                    return new Response("ERROR", "Solo se pueden aprobar citas en estado REQUESTED");
                }
                a.setStatus(AppointmentStatus.PENDING);
                return new Response("SUCCESS", "Cita aprobada en estado PENDING");
            }
        }
        return new Response("ERROR", "Cita no encontrada");
    }

    public Response completarCita(String idCita, String diagnosis, String observations, String recommendedTreatment, String followUp) {
        for (Appointment a : DataStore.citas) {
            if (a.getId().equals(idCita)) {
                if (a.getStatus() != AppointmentStatus.PENDING) {
                    return new Response("ERROR", "Solo se pueden completar citas en estado PENDING");
                }
                a.setDiagnosis(diagnosis);
                a.setObservations(observations);
                a.setRecommendedTreatment(recommendedTreatment);
                a.setFollowUp(followUp);
                a.setStatus(AppointmentStatus.COMPLETED);
                return new Response("SUCCESS", "Cita completada correctamente");
            }
        }
        return new Response("ERROR", "Cita no encontrada");
    }

    public Response cancelarCita(String idCita, String reason) {
        for (Appointment a : DataStore.citas) {
            if (a.getId().equals(idCita)) {
                if (a.getStatus() == AppointmentStatus.COMPLETED) {
                    return new Response("ERROR", "No se puede cancelar una cita completada");
                }
                a.setReason(reason);
                a.setStatus(AppointmentStatus.CANCELED);
                return new Response("SUCCESS", "Cita cancelada correctamente");
            }
        }
        return new Response("ERROR", "Cita no encontrada");
    }

    public Response obtenerCitas() {
        return new Response("SUCCESS", "Lista de citas obtenida: " + DataStore.citas.size());
    }
}
