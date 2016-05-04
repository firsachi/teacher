/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.gui;

import com.mycompany.teacher.dao.Lesson_dao;
import com.mycompany.teacher.dao.Word_dao;
import com.mycompany.teacher.exsampl.SettingsApplication;
import com.mycompany.teacher.exsampl.Word;
import com.mycompany.teacher.exsampl.Words;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author firsachi
 */
public class ControllerDialogLearn implements Initializable{
    
    private DilaogWordController dilaogWordController;
    private ObservableList<String> lessonList;
    private Lesson_dao lesson_dao;
    
    private ObservableList<Words> wordList;
    
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
        wordList = word_dao.getAllWord(lesson);
        tableColumnWord.setCellValueFactory(new PropertyValueFactory<Word, String>("word"));
        tableColumnTranslate.setCellValueFactory(new PropertyValueFactory<Word, String>("translate"));
        tableViewWord.setItems(wordList);
    }
    
    @FXML
    private void actionButtonAdd(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/fxml/DialogWord.fxml"));
            fxmlLoader.setResources(ResourceBundle.getBundle("locales.LocaleAddWord",
                    SettingsApplication.getLocale()));
           
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle(fxmlLoader.getResources().getString("key.title"));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)event.getSource()).getScene().getWindow());
            stage.show();
            dilaogWordController = fxmlLoader.getController();
            dilaogWordController.setLesson((String) comboBoxLesson.getValue());
            wordList.add((Words) dilaogWordController.getWord());
        } catch (IOException ex) {
            Logger.getLogger(ControllerDialogLearn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void buttonDeleteWordAction(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/fxml/DialogDelete.fxml"));
            fxmlLoader.setResources(ResourceBundle.getBundle("locales.LocaleDeleteWord",
                    SettingsApplication.getLocale()));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle(fxmlLoader.getResources().getString("key.title"));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ControllerDialogLearn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
