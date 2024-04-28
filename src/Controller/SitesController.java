package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import Model.Password;
import Model.Site;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hachem
 */
public class SitesController implements Initializable {

    @FXML
    private TableColumn<Site, String> site;
    @FXML
    private TableColumn<Site, String> username;
    @FXML
    private TableColumn<Site, String> password;
    @FXML
    private TableColumn<Site, String> hash;
    @FXML
    private TableView<Site> table;
    @FXML
    private BorderPane bpst;
    
    
    ObservableList<Site> list = FXCollections.observableArrayList(
            new Site("Facebook","Hachem.mastouri@gmail.com",new Password()),
            new Site("Twitter","Hachem.mastouri@gmail.com",new Password()),
            new Site("Gmail","Hachem.mastouri@gmail.com",new Password()),
            new Site("Instagram","Hachem.mastouri@gmail.com",new Password()));
    ObservableList<Site> list1 = FXCollections.observableArrayList(
            new Site("Facebook","Ahmed.Mastouri",new Password()),
            new Site("Twitter","Hachem.mastouri@gmail.com",new Password()),
            new Site("Gmail","Hachem.mastouri@gmail.com",new Password()),
            new Site("Instagram","Hachem.mastouri@gmail.com",new Password()));
    
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        site.setCellValueFactory(cellData -> {
            Site site1 = cellData.getValue();
            return new SimpleStringProperty(site1.getSite_nom());
        });
         
        username.setCellValueFactory(cellData -> {
            Site site1 = cellData.getValue();
            return new SimpleStringProperty(site1.getUsername());
        });
         
        
        hash.setCellValueFactory(cellData -> {
            Site site1 = cellData.getValue();
            return new SimpleStringProperty(site1.getMdp_site().chiffrer());
        });
        
        password.setCellValueFactory(cellData -> {
            return new SimpleStringProperty("***************");
        });
        
         table.setItems(list);
    
   }
    public void addNewSite(Site newSite) {
        list.add(newSite);}

    @FXML
    private void AddSite(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/AddSite.fxml"));
        Parent root;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        AddSiteController addSiteController = loader.getController();
        addSiteController.setSitesController(this);
        Stage addSiteStage = new Stage();
        addSiteStage.setScene(new Scene(root));
        addSiteController.setStage(addSiteStage); 
        addSiteStage.showAndWait();
    }

    @FXML
    private void RemoveSite(ActionEvent event) {
        Site selectedSite = table.getSelectionModel().getSelectedItem();
        if (selectedSite != null) {
            list.remove(selectedSite);
        } else {
            showAlert("Please select a site to remove.");
        }
    }

    @FXML
    private void ShowPassword(ActionEvent event) {
        Site selectedSite = table.getSelectionModel().getSelectedItem();
        if (selectedSite != null) {
            String password = selectedSite.getMdp_site().dechiffrer(selectedSite.getMdp_site().chiffrer(), selectedSite.getMdp_site().getSalt());
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();
            content.putString(password);
            clipboard.setContent(content);
            showAlert("Copied to your clipboard , Paste it :) ");
        } else {
            showAlert("Please select a site to show the password.");
        }
    }
    
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    
}

    @FXML
    private void touserslistview(ActionEvent event) throws IOException {
            bpst.getScene().getWindow().hide();
            Stage Gp_stage34 = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/View/UsersListView.fxml"));
            Scene scene = new Scene(root);
            Gp_stage34.setScene(scene);
            Gp_stage34.setTitle("SecPass-Users");
            Gp_stage34.show();
    }
}
