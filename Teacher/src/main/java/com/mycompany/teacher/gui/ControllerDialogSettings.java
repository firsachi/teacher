/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.gui;

import com.mycompany.teacher.exsampl.Settings;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author firsachi
 */
public class ControllerDialogSettings implements Initializable{
    
    private final ObservableList<Integer> arrayTimeout;
    private final ObservableList<String> arrayLanguage;
    
    @FXML
    private Label labelLanguage;
    
    @FXML
    private Label labelTimeout;
    
    @FXML ComboBox comboBoxLanguage;
    
    @FXML
    private ComboBox comboBoxTimeout;

    @FXML Button buttonOk;
    
    @FXML
    private Button buttonCancel;
    
    public ControllerDialogSettings() {
        this.arrayLanguage = FXCollections.observableArrayList("eng","ukr");
        this.arrayTimeout = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
    }
    
    @FXML
    private void actionButtonOk(){
        Settings.setIndexLanuege((String) comboBoxLanguage.getValue());
        actionButtonCancel();
    }

    @FXML
    private void actionButtonCancel(){
        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBoxLanguage.setItems(arrayLanguage);
        comboBoxLanguage.setValue(Settings.getIndexLanuege());
        comboBoxTimeout.setItems(arrayTimeout);
        comboBoxTimeout.setValue(Settings.getTimeout());
    }
    
}
