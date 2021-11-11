package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.tm.InParkingTM;
import view.tm.OnDeliveryTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class InParkingController {
    public AnchorPane contextInParking;
    public JFXComboBox cmbParking;
    public JFXButton contextLogOut;
    public TableView<InParkingTM> contextInPark;
    public TableView<OnDeliveryTM> contextOnDelivery;
    public TableColumn vehicleParkedTime;
    public TableColumn vehicleNumber;
    public TableColumn vehicleTypes;
    public TableColumn vehicleParkingSlot;
    public TableColumn deliveryDriverName;
    public TableColumn deliveryVehicleNumber;
    public TableColumn deliveryVehicleType;
    public TableColumn deliveryLeftTime;
    private String no;
    private String type;
    private String slotNo;
    private String dateTime;
    private String name;



    public void  clearWindow(Stage stage)  {
        stage.close();
    }


    public void parkOnAction(){

        tmArrayList.add(new InParkingTM(no,type,slotNo,dateTime));
    }
    static ArrayList<InParkingTM>tmArrayList = new ArrayList<>();
    static ArrayList<OnDeliveryTM>tmArrayListDelivery = new ArrayList<>();

    public void initialize(){
        cmbParking.getItems().addAll("In Parking", "On Delivery");
        cmbParking.setValue("In Parking");

        contextInPark.setItems(FXCollections.observableArrayList(tmArrayList));

        vehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        vehicleTypes.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        vehicleParkingSlot.setCellValueFactory(new PropertyValueFactory<>("parkingSlotNo"));
        vehicleParkedTime.setCellValueFactory(new PropertyValueFactory<>("parkingTime"));

        contextOnDelivery.setItems(FXCollections.observableArrayList(tmArrayListDelivery));

        deliveryVehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        deliveryVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        deliveryDriverName.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        deliveryLeftTime.setCellValueFactory(new PropertyValueFactory<>("leftTime"));

    }


    public void addDriverAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddDriver.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene=new Scene(load);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("Parking System (v-1.0.0)");
        stage.show();

    }

    public void logOutAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        contextInParking.getChildren().add(load);



    }

    public void addVehicleAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddVehicle.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene=new Scene(load);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("Parking System (v-1.0.0)");
        stage.show();



    }

    public void cmbAction(ActionEvent actionEvent) {
        if (cmbParking.getValue().equals("On Delivery")) {
            contextLogOut.setVisible(false);
            contextInPark.setVisible(false);
            contextOnDelivery.setVisible(true);
        } else {
            contextLogOut.setVisible(true);
            contextInPark.setVisible(true);
            contextOnDelivery.setVisible(false);
        }

    }
    public void setData(String no, String type, String slotNo, String dateTime){
        this.no=no;
        this.type=type;
        this.slotNo=slotNo;
        this.dateTime=dateTime;
    }

    public void deliveryOnAction() {
        tmArrayListDelivery.add(new OnDeliveryTM(no,type,name,dateTime));
    }

    public void setDatatoDelivery(String no, String type, String name, String dateTime) {
        this.no=no;
        this.type=type;
        this.name=name;
        this.dateTime=dateTime;

    }
}

