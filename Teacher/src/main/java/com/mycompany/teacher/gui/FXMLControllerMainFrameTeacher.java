package com.mycompany.teacher.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class FXMLControllerMainFrameTeacher implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private TextArea textAreaTranslate;
    
    @FXML
    private MenuBar menuBarMainFarme;
    
    @FXML
    private Button buttonExit;
    
    @FXML
    private void actionButtonExit(){
        Stage stage = (Stage) buttonExit.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void actionButtonSettings() {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/DialogSettings.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("ajlkjdslk");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLControllerMainFrameTeacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void actionBUttonLearn(){
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/DialogLearn.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLControllerMainFrameTeacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void buttonOkAction(){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
