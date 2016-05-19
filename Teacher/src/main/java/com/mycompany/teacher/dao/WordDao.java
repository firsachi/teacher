/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.dao;

import com.mycompany.teacher.exsampl.ConnectSQLLite;
import com.mycompany.teacher.exsampl.Word;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author firsov
 */
public class WordDao {
    
    public ObservableList<Word> getAllWord(String lesson){
        ObservableList<Word> lessonWords = FXCollections.observableArrayList();
        String sql = "SELECT * FROM words WHERE lesson=?";
        try (PreparedStatement ps = ConnectSQLLite.getConnection().prepareStatement(sql);) {
            ps.setString(1, lesson);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                lessonWords.add((Word) initWord(resultSet));
            }
        } catch (SQLException ex) {
            Logger.getLogger(WordDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lessonWords;
    }
    
    public boolean addWordb(Word word){
        boolean result = false;
        String sql = "INSERT INTO words (lesson,word,translate)VALUES (?,?,?)";
        try (PreparedStatement ps = ConnectSQLLite.getConnection().prepareStatement(sql);) {
            ps.setString(1, word.getLesson());
            ps.setString(2, word.getWord());
            ps.setString(3, word.getTranslate());
            ps.executeUpdate();
            result = true;
        } catch (SQLException ex) {
            Logger.getLogger(WordDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public boolean editWord(Word word){
        String sql = "UPDATE words SET word=?,translate=? WHERE id=?";
         try (PreparedStatement ps = ConnectSQLLite.getConnection().prepareStatement(sql);) {
            ps.setString(1, word.getWord());
            ps.setString(2, word.getTranslate());
            ps.setInt(3, word.getId());
            ps.executeUpdate();
            return true;
         } catch (SQLException ex) {
            Logger.getLogger(WordDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteWord(Word word) {
        String sql = "DELETE FROM words WHERE id=?";
        try (PreparedStatement ps = ConnectSQLLite.getConnection().prepareStatement(sql);) {
            ps.setInt(1, word.getId());
            ps.executeUpdate();
            return  true;
        } catch (SQLException ex) {
            Logger.getLogger(WordDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Word> getLessonLast() {
        String sql ="SELECT * FROM words WHERE lesson = (SELECT * from lessons ORDER BY id DESC LIMIT 1)";
        return resultSelect(sql);
    }
    
    public ArrayList<Word> randomLesson(){
        String sql = "SELECT * FROM words WHERE lesson = (SELECT * FROM lessons ORDER BY RANDOM() LIMIT 1)";
        return resultSelect(sql);
    }
        
    private ArrayList<Word> resultSelect(String sql) {
        ArrayList<Word> resultArray = new ArrayList<>();
        try (PreparedStatement ps = ConnectSQLLite.getConnection().prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                resultArray.add(initWord(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(WordDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultArray;
    }
    
    private Word initWord(ResultSet resultSet){
        
        try {
            Word word = new Word(resultSet.getInt(1));
            word.setLesson(resultSet.getString(2));
            word.setTextWord(resultSet.getString(3));
            word.setTextTarnslate(resultSet.getString(4));
            return word;
        } catch (SQLException ex) {
            Logger.getLogger(WordDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
