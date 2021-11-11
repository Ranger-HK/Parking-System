package view.tm;

public class OnDeliveryTM {
     private String vehicleNumber;
     private String vehicleType;
     private String driverName;
     private String leftTime;

    public OnDeliveryTM() {

    }

    public OnDeliveryTM(String vehicleNumber, String vehicleType, String driverName, String leftTime) {
        this.setVehicleNumber(vehicleNumber);
        this.setVehicleType(vehicleType);
        this.setDriverName(driverName);
        this.setLeftTime(leftTime);
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getLeftTime() {
        return leftTime;
    }

    public void setLeftTime(String leftTime) {
        this.leftTime = leftTime;
    }

    @Override
    public String toString() {
        return "OnDeliveryTM{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", driverName='" + driverName + '\'' +
                ", leftTime='" + leftTime + '\'' +
                '}';
    }
}
