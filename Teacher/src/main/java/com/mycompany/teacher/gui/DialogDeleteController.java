/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.gui;

import com.mycompany.teacher.dao.Word_dao;
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
    private boolean resultAction;

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

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public void setWord(Word word) {
        this.word = word;
    }
    
    @FXML
    private void buttonOkAction(){
        Word_dao word_dao = new Word_dao();
        word_dao.deleteWord(word, lesson);
    }

    public boolean isResultAction() {
        return resultAction;
    }
    
}
