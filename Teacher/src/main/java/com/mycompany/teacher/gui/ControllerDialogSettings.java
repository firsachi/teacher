/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.gui;

import com.mycompany.teacher.dao.SettingsDao;
import com.mycompany.teacher.exsampl.SettingsApplication;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 *
 * @author firsachi
 */
public class ControllerDialogSettings implements Initializable{
    
    private final ObservableList<Integer> arrayTimeout;
    private final ObservableList<String> arrayLanguage;
    private final ObservableList<String> arrayMasterValue;
    
    @FXML ComboBox comboBoxLanguage;
    
    @FXML
    private ComboBox comboBoxTimeout;
    
    @FXML
    private ComboBox comboBoxMatesValue;

    @FXML Button buttonOk;
    
    @FXML
    private Button buttonCancel;
    
    public ControllerDialogSettings() {
        this.arrayLanguage = FXCollections.observableArrayList("eng","ukr");
        this.arrayTimeout = FXCollections.observableArrayList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        this.arrayMasterValue = FXCollections.observableArrayList("word", "random", "translate");
    }
    
    @FXML
    private void actionButtonOk(ActionEvent event){
        SettingsDao settings_dao = new SettingsDao();
        settings_dao.setSettings((String)comboBoxLanguage.getValue(),
                (Integer) comboBoxTimeout.getValue(), 
                (String) comboBoxMatesValue.getValue());
        SettingsApplication.setLanuege((String) comboBoxLanguage.getValue());
        SettingsApplication.setTimeout((Integer) comboBoxTimeout.getValue());
        SettingsApplication.setMasterValue((String) comboBoxMatesValue.getValue());
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
        comboBoxLanguage.setValue(SettingsApplication.getLanuege());
        comboBoxTimeout.setItems(arrayTimeout);
        comboBoxTimeout.setValue(SettingsApplication.getTimeout());
        comboBoxMatesValue.setItems(arrayMasterValue);
        comboBoxMatesValue.setValue(SettingsApplication.getMasterValue());
    }
    
}
