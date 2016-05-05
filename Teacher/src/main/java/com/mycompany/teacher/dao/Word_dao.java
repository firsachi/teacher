/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.dao;

import com.mycompany.teacher.exsampl.SettingsApplication;
import com.mycompany.teacher.exsampl.Word;
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
    
    public ObservableList<Word> getAllWord(String lesson){
        ObservableList<Word> lessonWords = FXCollections.observableArrayList();
        String sql = "SELECT * FROM word WHERE lesson=?";
        try (PreparedStatement ps = DriverManager.getConnection("jdbc:sqlite:"+ SettingsApplication.getApplicationFolder() +"Teacher.db").prepareStatement(sql);) {
            ps.setString(1, lesson);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                lessonWords.add((Word) initWord(resultSet));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Word_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lessonWords;
    }
    
    public void addWordb(Word word, String lesson){
        String sql = "INSERT INTO word (lesson,word,translate) VALUES (?,?,?)";
        try (PreparedStatement ps = DriverManager.getConnection("jdbc:sqlite:" +
                SettingsApplication.getApplicationFolder() +
                "Teacher.db").prepareStatement(sql);) {
            ps.setString(1, lesson);
            ps.setString(2, word.getWord());
            ps.setString(3, word.getTranslate());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Word_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editWord(Word word, Word oldWord, String lesson){
        String sql = "UPDATE word SET word=?,translate=? WHERE word=? AND translate=? AND lesson=?";
         try (PreparedStatement ps = DriverManager.getConnection("jdbc:sqlite:" +
                SettingsApplication.getApplicationFolder() +
                "Teacher.db").prepareStatement(sql);) {
            ps.setString(1, word.getWord());
            ps.setString(2, word.getTranslate());
            ps.setString(3, oldWord.getWord());
            ps.setString(4, oldWord.getTranslate());
            ps.setString(5, lesson);
            ps.executeUpdate();
         } catch (SQLException ex) {
            Logger.getLogger(Word_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public void deleteWord(Word word, String lesson) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
