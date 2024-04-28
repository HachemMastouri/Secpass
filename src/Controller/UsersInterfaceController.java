package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hachem
 */
public class UsersInterfaceController implements Initializable {

    @FXML
    private BorderPane bpch;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void toRoot(ActionEvent event) throws IOException {
            bpch.getScene().getWindow().hide();
            Stage Gp_stage2 = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/View/RootInterface.fxml"));
            Scene scene = new Scene(root);
            Gp_stage2.setScene(scene);
            Gp_stage2.setTitle("SecPass-Root");
            Gp_stage2.show();
    }

    @FXML
    private void touserslistview(ActionEvent event) throws IOException {
            bpch.getScene().getWindow().hide();
            Stage Gp_stage3 = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/View/UsersListView.fxml"));
            Scene scene = new Scene(root);
            Gp_stage3.setScene(scene);
            Gp_stage3.setTitle("SecPass-Users");
            Gp_stage3.show();
    }
    
}
