package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.VehicleData;

import java.util.ArrayList;

public class AddVehicleController {
    public AnchorPane contextAddVehicle;
    public JFXTextField txtAddVehicle;
    public JFXTextField txtWeight;
    public JFXTextField txtPassengers;
    public JFXComboBox cmbVehicleType;
    public JFXButton txtAddVehicleContext;
    public String number;
    public String type;
    public int weight;
    public int noPassenger;



    public static ObservableList vehicleList = FXCollections.observableArrayList();

    public static ObservableList getVehicleList() {
        return vehicleList;
    }

    public void moveToWeight(ActionEvent actionEvent) {
        txtWeight.requestFocus();
    }

    public void moveToPassengers(ActionEvent actionEvent) {
        txtPassengers.requestFocus();
    }

    public void openAddVehicle(ActionEvent actionEvent) {
        Stage stage = (Stage) txtAddVehicleContext.getScene().getWindow();
        stage.close();
        number = txtAddVehicle.getText();
        type =(String) cmbVehicleType.getValue();
        weight = Integer.parseInt(txtWeight.getText());
        noPassenger = Integer.parseInt(txtPassengers.getText());

        ArrayList<VehicleData> dataArrayList = new ArrayList<>();
        VehicleData vehicleData = new VehicleData(number,type,weight,noPassenger);
        dataArrayList.add(vehicleData);
        for (VehicleData temp : dataArrayList) {
            vehicleList.add(temp);
        }
        clearField();


    }

    public void openVehicleType(ActionEvent actionEvent) {


    }

    public void initialize(){

        cmbVehicleType.getItems().addAll(
                "Van","Cargo Lorry","Bus"
        );
    }
    public void clearField() {
        txtAddVehicle.clear();
        txtWeight.clear();
        txtPassengers.clear();



    }
}
