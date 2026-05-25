/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packagee;

/**
 *
 * @author paaoo
 */
public class PrescriptionController {


    public Response agregarPrescripcion(Appointment cita, String medicamento, double dosis, String via, int duracion, String instrucciones, int frecuencia) {
        if (medicamento == null || medicamento.trim().isEmpty()) {
            return new Response("ERROR", "El nombre del medicamento no puede estar vacío");
        }
        if (dosis <= 0) {
            return new Response("ERROR", "La dosis debe ser mayor a 0");
        }
        if (via == null || via.trim().isEmpty()) {
            return new Response("ERROR", "La vía de administración no puede estar vacía");
        }
        if (duracion <= 0) {
            return new Response("ERROR", "La duración del tratamiento debe ser mayor a 0 días");
        }
        if (frecuencia <= 0) {
            return new Response("ERROR", "La frecuencia debe ser mayor a 0");
        }

        Prescription p = new Prescription(cita, medicamento, dosis, via, duracion, instrucciones, frecuencia);
        return new Response("SUCCESS", "Prescripción agregada correctamente");
    }

    public Response obtenerPrescripciones(Appointment cita) {
        return new Response("SUCCESS", "Prescripciones de la cita " + cita.getId() + ": " + cita.getStatus());
    }

    public Response actualizarPrescripcion(Prescription p, double nuevaDosis, int nuevaDuracion, int nuevaFrecuencia, String nuevasInstrucciones) {
        if (nuevaDosis <= 0) {
            return new Response("ERROR", "La dosis debe ser mayor a 0");
        }
        if (nuevaDuracion <= 0) {
            return new Response("ERROR", "La duración debe ser mayor a 0 días");
        }
        if (nuevaFrecuencia <= 0) {
            return new Response("ERROR", "La frecuencia debe ser mayor a 0");
        }

p.setAdditionalInstructions(nuevasInstrucciones);
        return new Response("SUCCESS", "Prescripción actualizada correctamente");
    }

    public Response eliminarPrescripcion(Appointment cita, Prescription p) {
        boolean removed = cita.addPrescription(p); 
        if (!removed) {
            return new Response("ERROR", "No se pudo eliminar la prescripción");
        }
        return new Response("SUCCESS", "Prescripción eliminada correctamente");
    }
}


