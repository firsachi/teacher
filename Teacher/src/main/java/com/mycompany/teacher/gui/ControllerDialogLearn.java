/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.gui;

import com.mycompany.teacher.dao.Lesson_dao;
import com.mycompany.teacher.dao.Word_dao;
import com.mycompany.teacher.exsampl.Word;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author firsachi
 */
public class ControllerDialogLearn implements Initializable{
    
    private ObservableList<String> lessonList;
    private Lesson_dao lesson_dao;
    
    private ObservableList<Word> wordList;
    
    @FXML
    private ComboBox comboBoxLesson;
    
    @FXML 
    private TableView tableViewWord;
    
    @FXML
    private TableColumn<Word, String> tableColumnWord;
    
    @FXML 
    private TableColumn<Word, String> tableColumnTranslate;
    
    @FXML
    private void actionComboboxLesson(ActionEvent event){
        fillTable((String) comboBoxLesson.getValue());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lesson_dao = new Lesson_dao();
        lessonList = lesson_dao.getAllLesson();
        comboBoxLesson.setItems(lessonList);
        
    }
    
    private void fillTable(String lesson){
        Word_dao word_dao = new Word_dao();
        tableColumnWord.setCellValueFactory(new PropertyValueFactory<Word, String>("word"));
        tableColumnTranslate.setCellValueFactory(new PropertyValueFactory<Word, String>("translate"));
        tableViewWord.setItems(word_dao.getAllWord(lesson));
    }
}
