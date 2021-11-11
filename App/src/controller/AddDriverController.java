package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Driver;

import java.util.ArrayList;

public class AddDriverController {
    public AnchorPane contextAddDriver;
    public JFXButton driverId;
    public JFXTextField txtName;
    public JFXTextField txtNic;
    public JFXTextField txtAddress;
    public JFXTextField txtLicenseNo;
    public JFXTextField txtContactNo;
    public String name;
    public String driverNic;
    public String licenseNum;
    public String driverAddress;
    public int ContactNo;


    public static ObservableList getDriversList() {
        return driversList;
    }

    public static ObservableList driversList = FXCollections.observableArrayList();


    public void addDriver(ActionEvent actionEvent) {
        Stage stage = (Stage) driverId.getScene().getWindow();
        stage.close();
        name=txtName.getText();
        driverNic=txtNic.getText();
        licenseNum = txtLicenseNo.getText();
        driverAddress = txtAddress.getText();

        try {
            ContactNo = Integer.parseInt(txtContactNo.getText());
        } catch (NumberFormatException e) {
            System.out.println("contact number not string");
        }
        ArrayList<Driver> drivers = new ArrayList<Driver>();

        Driver drivers1 = new Driver(name, driverNic, licenseNum, driverAddress, ContactNo);
        drivers.add(drivers1);
        clearField();


        for (Driver temp : drivers) {
            driversList.add(temp);
        }
    }
    public void clearField() {
        txtName.clear();
        txtNic.clear();
        txtLicenseNo.clear();
        txtContactNo.clear();
        txtAddress.clear();
    }

    public void moveToNic(ActionEvent actionEvent) {
        txtNic.requestFocus();
    }

    public void moveToLicenseNo(ActionEvent actionEvent) {
        txtLicenseNo.requestFocus();
    }

    public void moveToContactNo(ActionEvent actionEvent) {
        txtContactNo.requestFocus();
    }

    public void moveToAddress(ActionEvent actionEvent) {
        txtAddress.requestFocus();

    }
}
