package packagee.core.controllers;
 
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import packagee.core.controllers.util.Response;
import packagee.core.model.appointment.Appointment;
import packagee.core.model.appointment.AppointmentHandler;
import packagee.core.model.appointment.Canceled;
import packagee.core.model.appointment.Completed;
import packagee.core.model.appointment.Pending;
import packagee.core.model.persistence.DataStore;
import packagee.core.model.user.doctor.Doctor;
import packagee.core.model.user.doctor.Specialty;
import packagee.core.model.user.patient.Patient;

/**
 *
 * @author harry
 */
 
public class AppointmentController {
 
    public Response solicitarCita(String id, Patient paciente, Doctor doctor, Specialty specialty, String fechaHora, String reason, boolean type) {
        LocalDateTime datetime;
        try {
            datetime = LocalDateTime.parse(fechaHora);
        } catch (DateTimeParseException e) {
            return new Response("ERROR", "Fecha y hora inválidas, formato: AAAA-MM-DDTHH:MM");
        }
 
        Appointment cita = new Appointment(id, paciente, doctor, specialty, datetime, reason, type);
        DataStore.getInstance().getAppointments().add(cita);
        paciente.addAppointment(cita);
        doctor.addAppointment(cita);
        return new Response("SUCCESS", "Cita solicitada correctamente");
    }
 
    public Response aprobarCita(String idCita) {
        for (Appointment a : DataStore.getInstance().getAppointments()) {
            if (a.getId().equals(idCita)) {
                if (!"REQUESTED".equals(a.getStatus()))
                    return new Response("ERROR", "Solo se pueden aprobar citas en estado REQUESTED");
                AppointmentHandler handler = new AppointmentHandler(a);
                handler.changeStatus(new Pending());
                return new Response("SUCCESS", "Cita aprobada, estado: PENDING");
            }
        }
        return new Response("ERROR", "Cita no encontrada");
    }
 
    public Response completarCita(String idCita, String diagnosis, String observations,
            String recommendedTreatment, String followUp) {
        for (Appointment a : DataStore.getInstance().getAppointments()) {
            if (a.getId().equals(idCita)) {
                if (!"PENDING".equals(a.getStatus()))
                    return new Response("ERROR", "Solo se pueden completar citas en estado PENDING");
                AppointmentHandler handler = new AppointmentHandler(a);
                handler.changeStatus(new Completed(diagnosis, observations, recommendedTreatment, followUp));
                return new Response("SUCCESS", "Cita completada correctamente");
            }
        }
        return new Response("ERROR", "Cita no encontrada");
    }
 
    public Response cancelarCita(String idCita, String reason) {
        for (Appointment a : DataStore.getInstance().getAppointments()) {
            if (a.getId().equals(idCita)) {
                if ("COMPLETED".equals(a.getStatus()))
                    return new Response("ERROR", "No se puede cancelar una cita completada");
                AppointmentHandler handler = new AppointmentHandler(a);
                handler.changeStatus(new Canceled());
                return new Response("SUCCESS", "Cita cancelada correctamente");
            }
        }
        return new Response("ERROR", "Cita no encontrada");
    }
 
    public Response obtenerCitas() {
        return new Response("SUCCESS", "Total citas: " + DataStore.getInstance().getAppointments().size());
    }
}