/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author firsachi
 */
public class DialogCheckWordController implements Initializable{
    
    @FXML 
    private Button buttonOk;
    
    @FXML 
    private Label labelInfo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       // buttonOk.setMnemonicParsing(true);
    }
    
    public void setInfo(String text){
        labelInfo.setText(text);
    }
    
    @FXML
    private void buttomOkAction(){
        Stage stage = (Stage) buttonOk.getScene().getWindow();
        stage.close();
    }
    
}
