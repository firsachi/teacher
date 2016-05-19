package com.mycompany.teacher.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.teacher.dao.WordDao;
import com.mycompany.teacher.exsampl.Check;
import com.mycompany.teacher.exsampl.CheckString;
import com.mycompany.teacher.exsampl.Word;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author firsachi
 */
public class DialogWordController implements Initializable {
    
    @FXML
    private Label labelError;
    
    @FXML
    private Label labelWord;
    
    @FXML 
    private Label labelTranslate;
    
    @FXML
    private TextField textFiledWord;
    
    @FXML
    private TextField textFiledTranslate;
    
    @FXML
    private Button buttonOk;
    
    @FXML
    private Button buttonCancel;
    
    private String lesson;
    private Word word;
    private WordDao word_dao;
    private boolean resultAction;
    private String tmpWord;
    private String tmpTranslate;
    private Check check = new Check();
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       word_dao = new WordDao();
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
    private boolean textFiledWordAction(){
       return semdMessage(check.checkEmpty(textFiledWord.getText()), textFiledWord, labelWord);
    }
    
    @FXML
    private boolean textFiledTranslateKeyAction(){
        return semdMessage(check.checkEmpty(textFiledTranslate.getText()), textFiledTranslate, labelTranslate);
    }
    
    private boolean semdMessage(boolean flag, TextField textField, Label label){
        if (flag){
            label.setStyle("-fx-text-fill: black");
            //textField.setStyle("-fx-border-color: gray");
            labelError.setText("");
            buttonOk.setVisible(flag);
            return true;
        }else{
            label.setStyle("-fx-text-fill: red");
            //textField.setStyle("-fx-border-color: red");
            labelError.setText("Поле виділене червоним не повино бути порожнім");
            buttonOk.setVisible(flag);
            return false;
        }
    }
    
    @FXML
    private void buttonOkAction(ActionEvent event){
        fillVariable();
        if (null != word){
            updateItemDetebace();
            buttonCancelAction();
        }else if (textFiledWordAction()& textFiledTranslateKeyAction()) {
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
        word.setLesson(lesson);
        fillWord();
        resultAction = word_dao.addWordb(word);
    }

    private void updateItemDetebace() {
        if (tmpWord.equals(word.getWord())|tmpTranslate.equals(word.getTranslate())){
            fillWord();
            resultAction = word_dao.editWord(word);
        }
    }
    
    private void fillWord(){
        word.setTextWord(tmpWord);
        word.setTextTarnslate(tmpTranslate);
    }
    
    private void fillVariable(){
        tmpWord = textFiledWord.getText().trim();
        tmpTranslate = textFiledTranslate.getText().trim();
    }
    
    public Word getWord() {
        return word;
    }

    public boolean getResultAction() {
        return resultAction;
    }
    
}
