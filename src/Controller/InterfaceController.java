package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */

import Model.Password;
import Model.PasswordManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author hachem
 */
public class InterfaceController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label alert;
    
    @FXML
    void ToGeneratePassword(ActionEvent event) throws IOException {
        bp.getScene().getWindow().hide();
        Stage Gp_stage = new Stage();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/View/Generate_Password.fxml"));
        Scene scene = new Scene(root);
        Gp_stage.setScene(scene);
        Gp_stage.setTitle("SecPass-Generate_Password");
        Gp_stage.show();
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void authentification(ActionEvent event) throws IOException{
        Password pass = new Password("enicar");
        Password pass_input = new Password(password.getText());
        PasswordManager p = new PasswordManager("user" , pass);
        if (pass.auth_hash("enicar" , "abcdefgh").equals(pass_input.auth_hash(password.getText(),"abcdefgh")) && (p.getUsername().equals(username.getText()))){
            bp.getScene().getWindow().hide();
            Stage Gp_stage1 = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/View/UsersInterface.fxml"));
            Scene scene = new Scene(root);
            Gp_stage1.setScene(scene);
            Gp_stage1.setTitle("SecPass-ChooseUser");
            Gp_stage1.show();
        }
        else {
            alert.setText("Invalid Password/Username");
        }       
    }   

    @FXML
    private void toanyproblem(ActionEvent event) throws IOException {
        bp.getScene().getWindow().hide();
            Stage Gp_stage1 = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/View/AnyProblem.fxml"));
            Scene scene = new Scene(root);
            Gp_stage1.setScene(scene);
            Gp_stage1.setTitle("SecPass-Feedbacks");
            Gp_stage1.show();
    }
}
