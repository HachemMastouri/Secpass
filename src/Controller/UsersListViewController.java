package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import Model.Password;
import Model.PasswordManager;
import Model.User;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hachem
 */
public class UsersListViewController implements Initializable {

    @FXML
    private ListView<User> Mylistview;
    @FXML
    private Label Mylabel;
    @FXML
    private BorderPane bpls;
    

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Hachem", "Hachem123"));
        users.add(new User("Shefa", "Shefa789"));
        users.add(new User("Khalil", "Khalil456"));
        Collections.sort(users);
        PasswordManager secpass = new PasswordManager("user",new Password("enicar"),users);
        Mylistview.getItems().addAll(secpass.getUsers());
        Mylistview.getSelectionModel().selectedItemProperty().addListener(
        (observable, oldValue, newValue) -> {
                    User selected = Mylistview.getSelectionModel().getSelectedItem();
                    Mylabel.setText(selected.getNom_util());
                }
        );
        
    }    

    @FXML
    private void tologinas(ActionEvent event) throws IOException {
    Stage dialogStage = new Stage();
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("/View/LoginAs.fxml"));
    BorderPane root = (BorderPane) loader.load();
    Scene scene = new Scene(root);
    dialogStage.setScene(scene);
    dialogStage.setTitle("SecPass-UserLogIn");
    LoginAsController controller = loader.getController();
    User selectedUser = Mylistview.getSelectionModel().getSelectedItem();
    if(selectedUser != null){
    bpls.getScene().getWindow().hide();
    controller.setUser(selectedUser);
    controller.setDialogStage(dialogStage);
    dialogStage.showAndWait();}
    else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alert");
            alert.setHeaderText(null);
            alert.setContentText("Select a user !");
            alert.showAndWait();
            }
        }

    @FXML
    private void tousersinteface(ActionEvent event) throws IOException {
            bpls.getScene().getWindow().hide();
            Stage Gp_stage15 = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/View/UsersInterface.fxml"));
            Scene scene = new Scene(root);
            Gp_stage15.setScene(scene);
            Gp_stage15.setTitle("SecPass-ChooseUser");
            Gp_stage15.show();
    }
}
