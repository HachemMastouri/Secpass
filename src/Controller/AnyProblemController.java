package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author hachem
 */
public class AnyProblemController implements Initializable {

    @FXML
    private BorderPane bphelp;
    @FXML
    private MenuButton select;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void opengithub(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("www.github.com/hachemMastouri"));
    }

    @FXML
    private void openlinkedin(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("www.linkedin.com/in/hachem-mastouri"));
    }

    @FXML
    private void exit(ActionEvent event) {
        bphelp.getScene().getWindow().hide();
    }

    @FXML
    private void verygood(ActionEvent event) {
        select.setText("Very Good");
    }

    @FXML
    private void Good(ActionEvent event) {
        select.setText("Good");
    }

    @FXML
    private void notbad(ActionEvent event) {
        select.setText("Not bad");
    }

    @FXML
    private void bad(ActionEvent event) {
        select.setText("Bad !");
    }

    @FXML
    private void verybad(ActionEvent event) {
        select.setText("Very Bad !!");
    }
    
}
