/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.dao;

import com.mycompany.teacher.exsampl.SettingsApplication;
import com.mycompany.teacher.exsampl.Word;
import com.mycompany.teacher.exsampl.Words;
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
public class Word_dao {
    
    public ObservableList<Words> getAllWord(String lesson){
        ObservableList<Words> lessonWords = FXCollections.observableArrayList();
        String sql = "SELECT * FROM word WHERE name_learn=?";
        try (PreparedStatement ps = DriverManager.getConnection("jdbc:sqlite:"+ SettingsApplication.getApplicationFolder() +"Teacher.db").prepareStatement(sql);) {
            ps.setString(1, lesson);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                lessonWords.add((Words) initWord(resultSet));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Word_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lessonWords;
    }
    
    private Word initWord(ResultSet resultSet){
        Word word = new Word();
        try {
            word.setTextWord(resultSet.getString(2));
            word.setTextTarnslate(resultSet.getString(3));
        } catch (SQLException ex) {
            Logger.getLogger(Word_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return word;
    }
}
