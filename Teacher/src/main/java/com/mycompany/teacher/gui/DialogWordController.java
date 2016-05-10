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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author firsachi
 */
public class DialogWordController implements Initializable {

    @FXML
    private TextField textFiledWord;
    
    @FXML
    private TextField textFiledTranslate;
    
    @FXML
    private Button buttonCancel;
    
    private String lesson;
    private Word word;
    private Word_dao word_dao;
    private boolean resultAction;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       word_dao = new Word_dao();
       resultAction = false;
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
            buttonCancelAction();
        }else {
            addItemDatabace();
            buttonCancelAction();
        }
    }
    
    @FXML
    private void buttonCancelAction(){
        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        stage.close();
    }

    private void addItemDatabace() {
        word = new Word();
        fillWord();
        resultAction = word_dao.addWordb(word);
    }

    private void updateItemDetebace() {
        Word old = new Word();
        old.setTextWord(word.getWord());
        old.setTextTarnslate(word.getTranslate());
        fillWord();
        resultAction = word_dao.editWord(word, old);
    }
    
    private void fillWord(){
        word.setTextWord(textFiledWord.getText().trim());
        word.setTextTarnslate(textFiledTranslate.getText().trim());
    }
    
    public Word getWord() {
        return word;
    }

    public boolean getResultAction() {
        return resultAction;
    }
    
}
