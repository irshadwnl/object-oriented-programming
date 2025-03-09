class Device{
    int id;
    String status;
    public Device(int id, String status) {
        this.id = id;
        this.status = status;
    }
    public void displaInfo(){
        System.out.println("Device id: "+id);
        System.out.println("Device status: "+status);
    }
}

class Thermostat extends Device{
    String tempSetting;
    public Thermostat(int id, String status,String tempSetting) {
            super(id, status);
            this.tempSetting=tempSetting;
        }
    
    public void displaInfo(){
        super.displaInfo();
        System.out.println("TempSetting: "+tempSetting);
    }

}
public class SmartHome {
    public static void main(String[] args) {
        Thermostat t=new Thermostat(20, "Acitve", "Extreme Warm");
        t.displaInfo();
    }
}
