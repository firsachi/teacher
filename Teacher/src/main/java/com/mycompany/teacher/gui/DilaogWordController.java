package com.mycompany.teacher.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.teacher.dao.Word_dao;
import com.mycompany.teacher.exsampl.Word;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author firsachi
 */
public class DilaogWordController implements Initializable {

    @FXML
    private TextField textFiledWord;
    
    @FXML
    private TextField textFiledTranslate;
    
    private String lesson;
    private Word word;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    @FXML
    private void buttonOkAction(ActionEvent event){
        adddb();
        buttonCancelAction(event);
    }
    
    @FXML
    private void buttonCancelAction(ActionEvent event){
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    private void adddb() {
        word = new Word();
        word.setTextWord(textFiledWord.getText());
        word.setTextTarnslate(textFiledTranslate.getText());
        Word_dao word_dao = new Word_dao();
        word_dao.addWordb(word, lesson);
    }

    public Word getWord() {
        return word;
    }
    
    
}
