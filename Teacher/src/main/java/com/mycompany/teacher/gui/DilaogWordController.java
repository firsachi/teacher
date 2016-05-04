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
    private Word_dao word_dao;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        word_dao = new Word_dao();
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }
    
    public void setWord(Word word){
        this.word = word;
        textFiledWord.setText(word.getWord());
        textFiledTranslate.setText(word.getTranslate());
    }

    @FXML
    private void buttonOkAction(ActionEvent event){
        if (null != word){
            updateItemDetebace();
            buttonCancelAction(event);
        }else {
            addItemDatabace();
            buttonCancelAction(event);
        }
    }
    
    @FXML
    private void buttonCancelAction(ActionEvent event){
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    private void addItemDatabace() {
        word = new Word();
        fillWord();
        word_dao.addWordb(word, lesson);
    }

    private void updateItemDetebace() {
        Word old = new Word();
        old.setTextWord(word.getWord());
        old.setTextTarnslate(word.getTranslate());
        fillWord();
        word_dao.editWord(word, old, lesson);
    }
    
    private void fillWord(){
        word.setTextWord(textFiledWord.getText());
        word.setTextTarnslate(textFiledTranslate.getText());
    }
    
    public Word getWord() {
        return word;
    }


}
