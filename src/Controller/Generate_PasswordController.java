package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import Model.Password;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author hachem
 */
public class Generate_PasswordController implements Initializable {

    @FXML
    private BorderPane bpgen;
    @FXML
    private Slider MySlider;
    @FXML
    private Label MyLabel;

    /**
     * Initializes the controller class.
     */
    int taille;
    @FXML
    private Label PassGen;
    @FXML
    private Label copied;
    /**
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MySlider.valueProperty().addListener((observableValue,oldValue,newValue)->{
            taille = (int) MySlider.getValue();
            MyLabel.setText(Integer.toString(taille));
        });
    }    

    @FXML
    private void ReturnToInterface(ActionEvent event) throws IOException {
        bpgen.getScene().getWindow().hide();
        Stage streturn = new Stage();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/View/Interface.fxml"));
        
        Scene scene = new Scene(root);
        
        streturn.setScene(scene);
        streturn.setTitle("SecPass-HomePage");
        streturn.show();
    }

    @FXML
    private void Exit(ActionEvent event) {
        bpgen.getScene().getWindow().hide();
    }

    @FXML
    private void GeneratePass(ActionEvent event) {
        Password p = new Password();
        PassGen.setText(p.generate_Password(taille));
    }

    @FXML
    private void Copy(ActionEvent event) {
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();
            content.putString(PassGen.getText());
            clipboard.setContent(content);
            Duration duration = Duration.seconds(2);
            Timeline timeline = new Timeline(new KeyFrame(duration, e -> {
            copied.setText("Copied to Clipboard");
            copied.setVisible(false);}));
            copied.setVisible(true);
            timeline.play();
            
    }
    
}
