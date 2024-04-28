package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import Model.InvalidEmailException;
import Model.Password;
import Model.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hachem
 */
public class AddUserController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    
    private RootConfigController rootconfig;
    private Stage stage_root;
    
    public void setRootConfigController(RootConfigController rootconfig) {
        this.rootconfig = rootconfig;
    }
    public void setStage(Stage stage) {
        this.stage_root = stage;
    }

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void ValiderUtil(ActionEvent event) {
        try {
            validateEmail(username.getText());
        } catch (InvalidEmailException e) {
            System.out.println("Erreur : " + e.getMessage());}
        String pass_name = password.getText();
        User newUser = new User(username.getText(), pass_name);
        rootconfig.addNewUser(newUser);
        stage_root.close();
    }
    
    private void validateEmail(String email) throws InvalidEmailException {
        if (!email.contains("@")) {
            throw new InvalidEmailException("L'adresse e-mail ne contient pas le caractère '@'.");
        }
    }
    
}
