package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginController {
    public AnchorPane contextLogin;
    public JFXButton btnCancel;
    public JFXPasswordField txtfldPassword;
    public JFXTextField txtfldUserName;
    public Label warningLbl;
    public JFXButton txtLogin;



    public void backToDashBoardForm(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();


    }



    public void openInParking(ActionEvent actionEvent) throws IOException {

        if (txtfldPassword.getText().equals("") & txtfldUserName.getText().equals("")){

            URL resource = getClass().getResource("../view/InParking.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window   = (Stage) contextLogin.getScene().getWindow();
            window.setScene(new Scene(load));
            closeWindow();



        }else{
            warningLbl.setVisible(true);
            txtfldUserName.requestFocus();
            txtfldPassword.clear();
        }

    }
    private Stage stage=null;
    void getStage(Stage stage){
        this.stage=stage;
    }
    public void closeWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/InParking.fxml"));
        Parent parent = loader.load();
        InParkingController controller =(InParkingController) loader.getController();
        controller.clearWindow(stage);

    }

    public void moveToPassword(ActionEvent actionEvent) {
        txtfldPassword.requestFocus();
    }

    public void moveToLogin(ActionEvent actionEvent) {
        txtLogin.requestFocus();
    }
}
