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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class RootConfigController implements Initializable {

    @FXML
    private BorderPane bprt;
    @FXML
    private ListView<User> userslistview;
    @FXML
    private Label selectedlabel;

    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Hachem", "Hachem123"));
        users.add(new User("Ahmed", "Ahmed456"));
        users.add(new User("Shefa", "Shefa789"));
        PasswordManager secpass = new PasswordManager("user",new Password("enicar"),users);
        userslistview.getItems().addAll(secpass.getUsers());
        userslistview.getSelectionModel().selectedItemProperty().addListener(
        (observable, oldValue, newValue) -> {
                    User selected = userslistview.getSelectionModel().getSelectedItem();
                    selectedlabel.setText(selected.getNom_util());
                }
        );
    }    
    public void addNewUser(User newUser) {
        userslistview.getItems().add(newUser);}
    @FXML
    private void adduser(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/AddUser.fxml"));
        Parent root;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        AddUserController addUserController = loader.getController();
        addUserController.setRootConfigController(this);
        Stage addUserStage = new Stage();
        addUserStage.setScene(new Scene(root));
        addUserController.setStage(addUserStage); 
        addUserStage.showAndWait();
    }

    @FXML
    private void removeuser(ActionEvent event) {
        User selectedUser = userslistview.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            userslistview.getItems().remove(selectedUser);
        } else {
            showAlert("Please select a User to remove.");
        }
    }

    @FXML
    private void configure(ActionEvent event) {
        User selectedUser = userslistview.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ConfUser.fxml"));
        Parent root;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        ConfUserController confUserController = loader.getController();
        confUserController.setSelectedUser(selectedUser);
        Stage confUserStage = new Stage();
        confUserStage.setScene(new Scene(root));
        confUserStage.showAndWait();
        } else {
            showAlert("Please select a User to configure.");
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
    private void tousersinterface(ActionEvent event) throws IOException {
            bprt.getScene().getWindow().hide();
            Stage Gp_stage1 = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/View/UsersInterface.fxml"));
            Scene scene = new Scene(root);
            Gp_stage1.setScene(scene);
            Gp_stage1.setTitle("SecPass-ChooseUser");
            Gp_stage1.show();
    }
}
