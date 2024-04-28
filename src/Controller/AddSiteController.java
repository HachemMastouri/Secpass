package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import Model.Password;
import Model.Site;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author hachem
 */
public class AddSiteController implements Initializable {

    @FXML
    private TextField nomsite;
    @FXML
    private TextField username;

    
    private SitesController sitesController;
    private Stage stage;
    
    
    public void setSitesController(SitesController sitesController) {
        this.sitesController = sitesController;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Valider(ActionEvent event) {
        String siteName = nomsite.getText();
        String usernamesite = username.getText();
        Site newSite = new Site(siteName, usernamesite, new Password());
        sitesController.addNewSite(newSite);
        stage.close();
    }
    
}
