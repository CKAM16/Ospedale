package packagee.core.controllers;
 
import java.io.IOException;
import java.time.LocalDate;
import packagee.core.controllers.util.Response;
import packagee.core.model.persistence.JSONSave;
import packagee.core.model.persistence.Observer.Observable;
import packagee.core.model.persistence.Storage;
import packagee.core.model.user.User;
import packagee.core.model.user.patient.Patient;
import packagee.core.model.persistence.serialize.PatientSerializable;

/**
 *
 * @author harry
 */
 
public class PatientController extends Observable {
 
    private JSONSave json;
 
    public PatientController(JSONSave json) {
        this.json = json;
    }
 
    public Response registrarPaciente(String id, String firstname, String lastname, String gender, String birthdate, String address, String phone, String email, String user, String password, String comPassword) throws IOException {
 
        if (id.length() != 12 || !id.matches("\\d+"))
            return new Response("ERROR", "ID inválido, debe tener 12 dígitos numéricos");
 
        for (User existente : Storage.getInstance().getPersons()) {
            if (String.valueOf(existente.getId()).equals(id))
                return new Response("ERROR", "Ya existe un paciente con ese ID");
        }
 
        if (phone.length() != 10 || !phone.matches("\\d+"))
            return new Response("ERROR", "Teléfono debe tener exactamente 10 dígitos");
 
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
            return new Response("ERROR", "Email inválido");
 
        if (!birthdate.matches("^\\d{4}-\\d{2}-\\d{2}$"))
            return new Response("ERROR", "Fecha de nacimiento inválida, formato AAAA-MM-DD");
 
        if (!password.equals(comPassword))
            return new Response("ERROR", "Las contraseñas no coinciden");
 
        long patientID = Long.parseLong(id);
        long patientPhone = Long.parseLong(phone);
        LocalDate patientBirthdate = LocalDate.parse(birthdate);
        boolean patientGender = gender.equals("1"); // 1=Female, 2=Male from combobox index
 
        Patient p = new Patient(patientID, user, firstname, lastname, password,
                email, patientBirthdate, patientGender, patientPhone, address);
        Storage.getInstance().getPersons().add(p);
        this.notifyAll(p, p);
 
        json.SaveUser(new PatientSerializable(p), "json/users.json");
 
        return new Response("SUCCESS", "Paciente registrado correctamente");
    }
 
    public Response actualizarPaciente(String id, String firstname, String lastname,
            String gender, String birthdate, String address, String phone,
            String email, String user, String password, String comPassword) {
 
        for (User u : Storage.getInstance().getPersons()) {
            if (u instanceof Patient && String.valueOf(u.getId()).equals(id)) {
                Patient p = (Patient) u;
 
                if (phone.length() != 10 || !phone.matches("\\d+"))
                    return new Response("ERROR", "Teléfono debe tener exactamente 10 dígitos");
 
                if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
                    return new Response("ERROR", "Email inválido");
 
                if (!birthdate.matches("^\\d{4}-\\d{2}-\\d{2}$"))
                    return new Response("ERROR", "Fecha de nacimiento inválida");
 
                p.setFirstname(firstname);
                p.setLastname(lastname);
                p.setEmail(email);
                p.setPhone(Long.parseLong(phone));
                p.setAddress(address);
                p.setBirthdate(LocalDate.parse(birthdate));
                p.setGender(gender.equals("1"));
                p.setUsername(user);
                p.setPassword(password);
                this.notifyAll(p, p);
 
                return new Response("SUCCESS", "Paciente actualizado correctamente");
            }
        }
        return new Response("ERROR", "Paciente no encontrado");
    }
 
    public Patient buscarPaciente(long id) {
        for (User u : Storage.getInstance().getPersons()) {
            if (u instanceof Patient && u.getId() == id)
                return (Patient) u;
        }
        return null;
    }
 
    public Response obtenerPersons() {
        return new Response("SUCCESS", "Lista de pacientes: " + Storage.getInstance().getPersons().size());
    }
}