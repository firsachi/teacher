package com.mycompany.teacher.gui;

import com.mycompany.teacher.exsampl.SettingsApplication;
import com.mycompany.teacher.exsampl.Word;
import com.mycompany.teacher.model.ModelMain;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControllerMainFrameTeacher implements Initializable {
    
    private ModelMain modelMain;
    private Word word;
    
    @FXML
    private Label labelWordLesson;
    
    @FXML
    private TextArea textAreaTranslate;
    
    @FXML
    private Button buttonExit;
    
    @FXML 
    private Button buttonLearn;
    
    @FXML
    private Button nuttonSettings;
    
    @FXML 
    private Button buttonOk;
    
    @FXML
    private void actionButtonExit(){
        System.exit(0);
    }
    
    @FXML
    private void actionButtonSettings(ActionEvent event) {
        try {
            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.setLocation(getClass().getResource("/fxml/DialogSettings.fxml"));
            fXMLLoader.setResources(ResourceBundle.getBundle("locales.LocaleSettings", 
                    SettingsApplication.getLocale()));
            Stage stage = new Stage();
            Parent root = fXMLLoader.load();
            stage.setScene(new Scene(root));
            stage.setTitle(fXMLLoader.getResources().getString("key.title"));
            stage.sizeToScene();
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)event.getSource()).getScene().getWindow());
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ControllerMainFrameTeacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void actionButtonLearn(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/fxml/DialogLearn.fxml"));
            fxmlLoader.setResources(ResourceBundle.getBundle("locales.LocaleLearn",
                    SettingsApplication.getLocale()));
            Stage stage = new Stage();
            Parent root = fxmlLoader.load();
            stage.setScene(new Scene(root));
            stage.setTitle(fxmlLoader.getResources().getString("key.title"));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)event.getSource()).getScene().getWindow());
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ControllerMainFrameTeacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void buttonOkAction(){
        textAreaTranslate.setEditable(true);
        Stage stage = (Stage) buttonOk.getScene().getWindow();
        stage.hide();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        modelMain = new ModelMain();
        modelMain.fillModel();
        word = modelMain.getElment();
        labelWordLesson.setText(word.getWord());
        labelWordLesson.getStyleClass().add("labelLessonWord");
    }    
}
