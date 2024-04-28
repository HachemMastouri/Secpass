package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import Model.Password;
import Model.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hachem
 */
public class LoginAsController implements Initializable {

    @FXML
    private Label alert_user;
    @FXML
    private Label usernamelb;
    @FXML
    private BorderPane bplas;
    
    private User user;
    private Stage dialogStage;
    @FXML
    private PasswordField pass;
    @FXML
    private Label userwelcome;
    
    public void setUser(User user) {
        this.user = user;
        if (user != null) {
            usernamelb.setText(user.getNom_util());
            userwelcome.setText(user.getNom_util());
        }
    }
    
    public void setDialogStage(Stage dialogStage){this.dialogStage = dialogStage;}
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void tosites(ActionEvent event) throws IOException {
        Password pass_input = new Password();
        if (pass_input.auth_hash(this.user.getMdp_util().getMdp_plain() , "abcdefgh").equals(pass_input.auth_hash(pass.getText(),"abcdefgh"))){
        bplas.getScene().getWindow().hide();
        Stage stsites = new Stage();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/View/Sites.fxml"));
        Scene scene = new Scene(root);
        stsites.setScene(scene);
        stsites.setTitle("SecPass-Sites");
        stsites.show();}
        else {
            alert_user.setText("Invalid Password/Username");
        }
    }
    
}
