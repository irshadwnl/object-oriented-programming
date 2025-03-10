import java.util.*;

abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }
    
    public String getPatientId() {
        return patientId;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }
    
    public abstract double calculateBill(); // Abstract method
}


interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}


class InPatient extends Patient implements MedicalRecord {
    private double dailyCharge;
    private int daysAdmitted;
    private List<String> records = new ArrayList<>();
    
    public InPatient(String patientId, String name, int age, double dailyCharge, int daysAdmitted) {
        super(patientId, name, age);
        this.dailyCharge = dailyCharge;
        this.daysAdmitted = daysAdmitted;
    }
    
    @Override
    public double calculateBill() {
        return dailyCharge * daysAdmitted;
    }
    
    @Override
    public void addRecord(String record) {
        records.add(record);
    }
    
    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ": " + records);
    }
}


class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> records = new ArrayList<>();
    
    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }
    
    @Override
    public double calculateBill() {
        return consultationFee;
    }
    
    @Override
    public void addRecord(String record) {
        records.add(record);
    }
    
    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ": " + records);
    }
}



public class HospitalManagementSystem {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        
        InPatient inPatient = new InPatient("P001", "John Doe", 45, 2000, 5);
        OutPatient outPatient = new OutPatient("P002", "Jane Smith", 30, 500);
        
        inPatient.addRecord("Admitted for surgery");
        inPatient.addRecord("Follow-up scheduled");
        outPatient.addRecord("General checkup");
        
        patients.add(inPatient);
        patients.add(outPatient);
        
        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.println("Total Bill: " + patient.calculateBill());
            
            if (patient instanceof MedicalRecord) {
                ((MedicalRecord) patient).viewRecords();
            }
            System.out.println();
        }
    }
}
