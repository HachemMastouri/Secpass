package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import Model.Password;
import Model.PasswordManager;
import Model.Root;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class RootInterfaceController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private TextField rootname;
    @FXML
    private PasswordField passroot;
    @FXML
    private Label alert_root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void authentification_root(ActionEvent event) throws IOException {
        Password pass = new Password("Root");
        Password pass_input = new Password(passroot.getText());
        Root root_user = new Root("Root" , pass);
        if (pass.auth_hash("Root" , "abcdefgh").equals(pass_input.auth_hash(passroot.getText(),"abcdefgh")) && (root_user.getNom_util().equals(rootname.getText()))){
            bp.getScene().getWindow().hide();
            Stage Gp_stage1 = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/View/RootConfig.fxml"));
            Scene scene = new Scene(root);
            Gp_stage1.setScene(scene);
            Gp_stage1.setTitle("SecPass-Root");
            Gp_stage1.show();
        }
        else {
            alert_root.setText("Invalid Password/Username");
        }
    }
    
}
