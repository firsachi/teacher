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
    
    private ObservableList<String> lessonList;
    private FXMLLoader fxmlLoader;
    private ObservableList<Word> wordList;
    private Stage stage;
    
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
        Lesson_dao lesson_dao = new Lesson_dao();
        lessonList = lesson_dao.getAllLesson();
        comboBoxLesson.setItems(lessonList);
    }
    
    @FXML
    private void buttonAddLessonAction(ActionEvent event){
        Lesson_dao lesson = new Lesson_dao();
        String nameLesson = lesson.addLesson(lessonList.size());
        lessonList.add(nameLesson);
        comboBoxLesson.setValue(nameLesson);
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
        String pachLocale = "locales.LocaleAddWord";
        String pachFXML = "/fxml/DialogWord.fxml";
        configSceneAddEdit(pachFXML, pachLocale, event);
        DialogWordController wordController = fxmlLoader.getController();
        wordController.setLesson((String) comboBoxLesson.getValue());
        stage.showAndWait();
        if(wordController.getResultAction()){
            wordList.add(wordController.getWord());
        }
    }
    
    @FXML
    private void buttonDeleteWordAction(ActionEvent event){
        String pachLocale = "locales.LocaleDeleteWord";
        String pachFXML = "/fxml/DialogDelete.fxml";
        configSceneAddEdit(pachFXML, pachLocale, event);
        DialogDeleteController deleteController = fxmlLoader.getController();
        deleteController.setLesson((String) comboBoxLesson.getValue());
        deleteController.setWord((Word) tableViewWord.getSelectionModel().getSelectedItem());
        stage.showAndWait();
        if(deleteController.getResultAction()){
            wordList.remove(tableViewWord.getSelectionModel().getSelectedIndex());
        }
    }
    
    @FXML
    private void buttonEditWordAction(ActionEvent event){
        String pachLocale = "locales.LocaleEditWord";
        String pachFXML = "/fxml/DialogWord.fxml";
        configSceneAddEdit(pachFXML, pachLocale, event);
        DialogWordController wordController = fxmlLoader.getController();
        wordController.setWord((Word) tableViewWord.getSelectionModel().getSelectedItem());
        wordController.setLesson((String) comboBoxLesson.getValue());
        stage.showAndWait();
        if (wordController.getResultAction()){
            wordList.set(tableViewWord.getSelectionModel().getSelectedIndex(), wordController.getWord());
        }
    }
    
    private void configSceneAddEdit(String pachFXML, String pachLocale, ActionEvent event ){
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(pachFXML));
        fxmlLoader.setResources(ResourceBundle.getBundle(pachLocale,
                    SettingsApplication.getLocale()));     
        Parent root;
        stage = new Stage();
        try {
            root = fxmlLoader.load();
            stage.setScene(new Scene(root));
            stage.setTitle(fxmlLoader.getResources().getString("key.title"));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)event.getSource()).getScene().getWindow());
        } catch (IOException ex) {
            Logger.getLogger(ControllerDialogLearn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
