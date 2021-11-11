package model;

public class Driver {
    private String driverName;
    private String nic;
    private String driverLicenseNum;
    private String address;
    private int contactNum;

    public Driver(String driverName, String nic, String driverLicenseNum, String address, int contactNum) {
        this.setDriverName(driverName);
        this.setNic(nic);
        this.setDriverLicenseNum(driverLicenseNum);
        this.setAddress(address);
        this.setContactNum(contactNum);
    }

    public Driver() {

    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDriverLicenseNum() {
        return driverLicenseNum;
    }

    public void setDriverLicenseNum(String driverLicenseNum) {
        this.driverLicenseNum = driverLicenseNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContactNum() {
        return contactNum;
    }

    public void setContactNum(int contactNum) {
        this.contactNum = contactNum;
    }

    @Override
    public String toString() {
        return driverName;


    }
}
