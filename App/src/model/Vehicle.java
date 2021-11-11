package model;

abstract public class Vehicle {
    String vehicleNumber;
    String vehicleType;
    int maximumWeight;
    int numOfPassengers;

    abstract public void park(String vehicleNumber,String vehicleType);

    abstract public void leavePark(String vehicleNumber,String vehicleType);

    abstract public String setSlot(String vehicleNumber,String vehicleType);


}
