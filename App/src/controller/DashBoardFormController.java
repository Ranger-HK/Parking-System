package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Bus;
import model.CargoLorry;
import model.Van;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DashBoardFormController {
    public AnchorPane contextDashBoardForm;

    public JFXComboBox cmbVehicle;
    public JFXTextField lblType;
    public JFXComboBox cmbDriver;
    public Label lblNumber;
    public Label lblDate;
    public Label lblTime;
    public JFXButton btnParkVehicleContext;
    public JFXButton btnOnDeliveryContext;


    String[][] vehicle = {{"NA-3434", "Bus"}, {"KA-4563", "Van"}, {"58-3567", "Van"}, {"KA-4563", "Van"}, {"GF-4358", "Van"}, {"CCB-3568", "Van"}, {"LM-6679", "Van"}, {"QA-3369", "Van"}, {"KB-3668", "Cargo Lorry"}, {"JJ-9878", "Cargo Lorry"}, {"GH-5772", "Cargo Lorry"}, {"XY-3536", "Cargo Lorry"}, {"YQ-3536", "Cargo Lorry"}, {"CBB-3566", "Cargo Lorry"}, {"QH-3444", "Cargo Lorry"}

    };

    private ObservableList parentDriversList = FXCollections.observableArrayList();
    private ObservableList parentVehicleList = FXCollections.observableArrayList();


    Van v1 = new Van();
    Bus b1 = new Bus();
    CargoLorry c1 = new CargoLorry();

    public static String no;
    public static String type;

    public String slotNo;
    public String dateTime;
    private String name;

    public String getDateTime(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        return format.format(date);
    }


    public void parkVehicleAction(ActionEvent actionEvent) throws IOException {
        if (type.equals("Van")) {
            v1.park(no, type);
        } else if (type.equals("Bus")) {
            b1.park(no, type);

        } else if (type.equals("Cargo Lorry")) {
            c1.park(no, type);
        }

        slotNo=lblNumber.getText();
        dateTime=getDateTime();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/InParking.fxml"));
        Parent parent = loader.load();
        InParkingController controller = loader.getController();
        controller.setData(no,type,slotNo,dateTime);
        controller.parkOnAction();

    }


    public void managementLoginAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/LogIn.fxml"));
        Parent parent = loader.load();
        LoginController controller = (LoginController) loader.getController();
        Stage stage = new Stage();
        controller.getStage((Stage) contextDashBoardForm.getScene().getWindow());
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle(" Parking System(v-1.0.0)");
        stage.show();


    }

    public void onDeliveryShiftAction(ActionEvent actionEvent) throws IOException {
        v1.leavePark(no, type);
        b1.leavePark(no, type);
        c1.leavePark(no, type);

        name = String.valueOf(cmbDriver.getValue());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/InParking.fxml"));
        Parent parent = loader.load();
        InParkingController controller = loader.getController();
        controller.setDatatoDelivery(no,type,name,dateTime);
        controller.deliveryOnAction();

    }

    public void Time() throws InterruptedException {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm a");
            lblTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }


    public void Date() throws InterruptedException {

        SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        lblDate.setText(DateFormatter.format(date));


    }

    public void initialize() throws InterruptedException {
        cmbAddValues();
        Time();
        Date();

        cmbDriver.setItems(parentDriversList);//add data to Driver cmb
        Bindings.bindContentBidirectional(parentDriversList, AddDriverController.getDriversList());

        cmbVehicle.setItems(parentVehicleList);//add data to Driver cmb
        Bindings.bindContentBidirectional(parentVehicleList, AddVehicleController.getVehicleList());
    }

    public void openCmb(ActionEvent actionEvent) {
        for (int i = 0; i < vehicle.length; i++) {
            for (int j = 0; j < vehicle[1].length; j++) {
                if (vehicle[i][0].equals(String.valueOf(cmbVehicle.getValue()))) {
                    lblType.setText(vehicle[i][1]);
                    break;
                }
                no = String.valueOf(cmbVehicle.getValue());
                type = lblType.getText();
                setParkingNo();
                break;
            }
        }
    }


    private void setParkingNo() {
        if (type.equals("Van")) {
            lblNumber.setText(v1.setSlot(no, type));


            if (v1.setSlot(no, type).equals("Parked")) {
                btnParkVehicleContext.setDisable(true);
                btnOnDeliveryContext.setDisable(false);

            } else {
                btnOnDeliveryContext.setDisable(true);
                btnParkVehicleContext.setDisable(false);

            }

        } else if (type.equals("Bus")) {
            lblNumber.setText(b1.setSlot(no, type));


            if (b1.setSlot(no, type).equals("Parked")) {
                btnParkVehicleContext.setDisable(true);
                btnOnDeliveryContext.setDisable(false);

            } else {
                btnOnDeliveryContext.setDisable(true);
                btnParkVehicleContext.setDisable(false);


            }

        } else if (type.equals("Cargo Lorry")) {
            lblNumber.setText(c1.setSlot(no, type));


            if (c1.setSlot(no, type).equals("Parked")) {
                btnParkVehicleContext.setDisable(true);
                btnOnDeliveryContext.setDisable(false);

            } else {
                btnOnDeliveryContext.setDisable(true);
                btnParkVehicleContext.setDisable(false);

            }
        }

    }

    public void cmbAddValues() {
        for (int i = 0; i < vehicle.length; i++) {
            cmbVehicle.getItems().addAll(vehicle[i][0]);

        }
    }
}


