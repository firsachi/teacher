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
    private int toggle;
    
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
    private void buttonStartAction(){
        modelMain.clear();
        start();
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
    private void buttonOkAction(ActionEvent event){
        Stage stage = (Stage) buttonOk.getScene().getWindow();
        stage.hide();
        chekInputTranslate(textAreaTranslate.getText().trim().toLowerCase(), event);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       start();
    } 
    
    private void start(){
        modelMain = new ModelMain();
        modelMain.fillModel();
        fill();
        labelWordLesson.getStyleClass().add("labelLessonWord");
    }

    private void chekInputTranslate(String text, ActionEvent event) {
        messageDialog(text, event);
        try {
            Thread.sleep(SettingsApplication.getTimeout() *60000);
            fill();
            Stage stage = (Stage) buttonOk.getScene().getWindow();
            stage.show();
        } catch (InterruptedException ex) {
            Logger.getLogger(ControllerMainFrameTeacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fill(){
        word = modelMain.getElment();
        switch (SettingsApplication.getMasterValue()){
            case "word" :
                labelWordLesson.setText(word.getWord());
                toggle = 0;
            break;
            case "random" :
                toggle = (int)(Math.random() * 1);
                if(0 == toggle){
                    labelWordLesson.setText(word.getWord());
                }else{
                    labelWordLesson.setText(word.getTranslate());
                }
            break;
            case "translate" :
                labelWordLesson.setText(word.getTranslate());
                toggle = 1;
            break;
        }
        textAreaTranslate.setText("");
    }
    
    private void messageDialog(String text, ActionEvent event){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/CheckWord.fxml"));
        fxmlLoader.setResources(ResourceBundle.getBundle("locales.LocaleCheckWord", 
            SettingsApplication.getLocale()));
        Stage stage = new Stage();
        try {
            Parent root = fxmlLoader.load();
            stage.setScene(new Scene(root));
        } catch (IOException ex) {
            Logger.getLogger(ControllerMainFrameTeacher.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage.setTitle(fxmlLoader.getResources().getString("key.title"));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node)event.getSource()).getScene().getWindow());
        DialogCheckWordController checkController = fxmlLoader.getController();
        if (text.equals(isValue())){
            checkController.setInfo(fxmlLoader.getResources().getString("key.labelMeassageGood"));
            modelMain.deleteItem();
        }else{
            checkController.setInfo(fxmlLoader.getResources().getString("key.laabelMeassageBead"));
        }
        stage.showAndWait();
    }
    
    private String isValue(){
        if (0 == toggle){
            return word.getTranslate();
        }else{
            return word.getWord();
        }
    }
    
}
