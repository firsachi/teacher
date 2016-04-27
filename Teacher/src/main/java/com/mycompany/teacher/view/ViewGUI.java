/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.view;

import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author firsov
 */
public class ViewGUI extends Application{
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.setLocation(getClass().getResource("/fxml/MainFrameTeacher.fxml"));
        fXMLLoader.setResources(ResourceBundle.getBundle("locales.LocaleTeacher", new Locale("eng")));
        
        Parent root = fXMLLoader.load();
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        primaryStage.setTitle(fXMLLoader.getResources().getString("main.frame"));
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}
