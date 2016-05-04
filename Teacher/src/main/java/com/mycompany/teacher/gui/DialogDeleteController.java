/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.gui;

import com.mycompany.teacher.exsampl.Word;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author firsov
 */
public class DialogDeleteController implements Initializable {
    
    private String lesson;
    private Word word;
    @FXML
    private Label labelInfo;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }
    
    @FXML
    private void buttonOkAction(){
        
    }
    
}
