/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.gui;

import com.mycompany.teacher.dao.WordDao;
import com.mycompany.teacher.exsampl.Word;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author firsov
 */
public class DialogDeleteController implements Initializable {

    private Word word;
    private boolean resultAction;
    
    @FXML
    private Button buttonCancel;

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
        resultAction = false;
    }

    public void setWord(Word word) {
        this.word = word;
    }
    
    @FXML
    private void buttonOkAction(){
        WordDao word_dao = new WordDao();
        resultAction = word_dao.deleteWord(word);
        buttonCancelAction();
    }
    
    @FXML
    private void buttonCancelAction(){
        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        stage.close();
    }

    public boolean getResultAction() {
        return resultAction;
    }
    
}
