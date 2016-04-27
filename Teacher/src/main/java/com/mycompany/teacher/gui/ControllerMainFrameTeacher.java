package com.mycompany.teacher.gui;

import com.mycompany.teacher.exsampl.Settings;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class ControllerMainFrameTeacher implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private TextArea textAreaTranslate;
    
    @FXML
    private MenuBar menuBarMainFarme;
    
    @FXML
    private Button buttonExit;
    
    @FXML 
    private Button buttonOk;
    
    @FXML
    private void actionButtonExit(){
        Stage stage = (Stage) buttonExit.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void actionButtonSettings() {
        try {
            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.setLocation(getClass().getResource("/fxml/DialogSettings.fxml"));
            fXMLLoader.setResources(ResourceBundle.getBundle("locales.LocaleSettings", 
                    new Locale(Settings.getIndexLanuege())));
            Stage stage = new Stage();
            Parent root = fXMLLoader.load();
            stage.setScene(new Scene(root));
            stage.setTitle(fXMLLoader.getResources().getString("key.title"));
            stage.sizeToScene();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ControllerMainFrameTeacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void actionButtonLearn(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/fxml/DialogLearn.fxml"));
            fxmlLoader.setResources(ResourceBundle.getBundle("locales.LocaleLearn",
                    new Locale(Settings.getIndexLanuege())));
            Stage stage = new Stage();
            Parent root = fxmlLoader.load();
            stage.setScene(new Scene(root));
            stage.setTitle(fxmlLoader.getResources().getString("key.title"));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ControllerMainFrameTeacher.class.getName()).log(Level.SEVERE, null, ex);
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
