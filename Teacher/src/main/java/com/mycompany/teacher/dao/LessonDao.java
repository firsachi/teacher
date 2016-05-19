/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.dao;

import com.mycompany.teacher.exsampl.ConnectSQLLite;
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
public class LessonDao {
    
    public ObservableList<String> getAllLesson(){
        String sql = "SELECT * FROM lessons";
        ObservableList<String> lessonList = FXCollections.observableArrayList();
        try (PreparedStatement ps = ConnectSQLLite.getConnection().prepareStatement(sql);) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                lessonList.add(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lessonList;
    }
    
    public String addLesson(int number){
        String sql = "INSERT INTO lessons (id) VALUES (?);";
        String result = number + 1 + "lesson";
        try (PreparedStatement ps = ConnectSQLLite.getConnection().prepareStatement(sql);) {
            ps.setString(1, result);
            ps.executeUpdate();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(LessonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
