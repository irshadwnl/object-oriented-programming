import java.util.HashSet;
import java.util.Set;

// Doctor Class
class Doctor {
    private String name;
    private Set<Patient> patients; // Many-to-Many relationship

    public Doctor(String name) {
        this.name = name;
        this.patients = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void consult(Patient patient) {
        // Establishing a bidirectional association
        patients.add(patient);
        patient.addDoctor(this);
        System.out.println("Dr. " + name + " is consulting patient " + patient.getName());
    }

    public void showPatients() {
        System.out.println("Patients under Dr. " + name + ":");
        for (Patient p : patients) {
            System.out.println("- " + p.getName());
        }
    }
}

// Patient Class
class Patient {
    private String name;
    private Set<Doctor> doctors; // Many-to-Many relationship

    public Patient(String name) {
        this.name = name;
        this.doctors = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void showDoctors() {
        System.out.println(name + " has consulted:");
        for (Doctor d : doctors) {
            System.out.println("- Dr. " + d.getName());
        }
    }
}

// Hospital Class
class Hospital {
    private String hospitalName;
    private Set<Doctor> doctors;
    private Set<Patient> patients;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new HashSet<>();
        this.patients = new HashSet<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void showAllDoctors() {
        System.out.println("Doctors at " + hospitalName + ":");
        for (Doctor d : doctors) {
            System.out.println("- Dr. " + d.getName());
        }
    }

    public void showAllPatients() {
        System.out.println("Patients at " + hospitalName + ":");
        for (Patient p : patients) {
            System.out.println("- " + p.getName());
        }
    }
}

// Main Class
public class HospitalManagement {
    public static void main(String[] args) {
        // Creating Hospital
        Hospital hospital = new Hospital("City General Hospital");

        // Creating Doctors
        Doctor drSmith = new Doctor("Smith");
        Doctor drJones = new Doctor("Jones");

        // Creating Patients
        Patient alice = new Patient("Alice");
        Patient bob = new Patient("Bob");

        // Adding Doctors & Patients to Hospital
        hospital.addDoctor(drSmith);
        hospital.addDoctor(drJones);
        hospital.addPatient(alice);
        hospital.addPatient(bob);

        // Simulating Consultations
        drSmith.consult(alice);
        drSmith.consult(bob);
        drJones.consult(alice);

        // Displaying Data
        hospital.showAllDoctors();
        hospital.showAllPatients();

        drSmith.showPatients();
        drJones.showPatients();

        alice.showDoctors();
        bob.showDoctors();
    }
}
