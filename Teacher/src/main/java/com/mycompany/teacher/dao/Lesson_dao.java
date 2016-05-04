/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.dao;

import com.mycompany.teacher.exsampl.SettingsApplication;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author firsov
 */
public class Lesson_dao {
    
    public ObservableList<String> getAllLesson(){
        String sql = "SELECT * FROM lesson";
        ObservableList<String> lessonList = FXCollections.observableArrayList();
        try (PreparedStatement ps = DriverManager.getConnection("jdbc:sqlite:"+ 
                SettingsApplication.getApplicationFolder() +
                "Teacher.db").prepareStatement(sql);) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                lessonList.add(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Lesson_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lessonList;
    }
    
    public String addLesson(int number){
        String sql = "INSERT INTO lesson (id) VALUES (?);";
        String result = number + 1 + "lesson";
        try (PreparedStatement ps = DriverManager.getConnection("jdbc:sqlite:" +
                SettingsApplication.getApplicationFolder() + 
                "Teacher.db").prepareStatement(sql);) {
            ps.setString(1, result);
            ps.executeUpdate();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Lesson_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
