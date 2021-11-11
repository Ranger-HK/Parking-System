package view.tm;

public class InParkingTM {
    private String vehicleNumber;
    private String vehicleType;
    private String parkingSlotNo;
    private String parkingTime;

    public InParkingTM() {
    }

    public InParkingTM(String vehicleNumber, String vehicleType, String parkingSlotNo, String parkingTime) {
        this.setVehicleNumber(vehicleNumber);
        this.setVehicleType(vehicleType);
        this.setParkingSlotNo(parkingSlotNo);
        this.setParkingTime(parkingTime);
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

    public String getParkingSlotNo() {
        return parkingSlotNo;
    }

    public void setParkingSlotNo(String parkingSlotNo) {
        this.parkingSlotNo = parkingSlotNo;
    }

    public String getParkingTime() {
        return parkingTime;
    }

    public void setParkingTime(String parkingTime) {
        this.parkingTime = parkingTime;
    }

    @Override
    public String toString() {
        return "InParkingTM{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", parkingSlotNo='" + parkingSlotNo + '\'' +
                ", parkingTime='" + parkingTime + '\'' +
                '}';
    }
}
