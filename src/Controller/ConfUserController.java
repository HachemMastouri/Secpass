package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import Model.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author hachem
 */
public class ConfUserController implements Initializable {

    @FXML
    private Label alert_label;
    @FXML
    private PasswordField new_pass1;
    @FXML
    private PasswordField actau_password;
    @FXML
    private PasswordField new_pass2;

    
    private User selectedUser;
    @FXML
    private BorderPane bpuc;
    @FXML
    private Label alert_label1;
    
    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ValiderUtil(ActionEvent event) {
    if (!actau_password.getText().equals(selectedUser.getMdp_util().getMdp_plain())) {
        bpuc.getScene().getWindow().hide();
    } else {
        alert_label.setText("Invalid Actual Password !");
        if (new_pass1.getText().equals(new_pass2.getText())) {
        } else {
            alert_label1.setText("Reconfirm password!");
        }
    }
}

    
}
