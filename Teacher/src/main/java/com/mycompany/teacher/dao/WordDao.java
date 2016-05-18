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
        String sql = "SELECT * FROM word WHERE lesson=?";
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
        String sql = "INSERT INTO word (lesson,word,translate) VALUES (?,?,?)";
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
    
    public boolean editWord(Word word, Word oldWord){
        if(oldWord.equals(word)){
            return true;
        }
        String sql = "UPDATE word SET word=?,translate=? WHERE word=? AND translate=? AND lesson=?";
         try (PreparedStatement ps = ConnectSQLLite.getConnection().prepareStatement(sql);) {
            ps.setString(1, word.getWord());
            ps.setString(2, word.getTranslate());
            ps.setString(3, oldWord.getWord());
            ps.setString(4, oldWord.getTranslate());
            ps.setString(5, word.getLesson());
            ps.executeUpdate();
            return true;
         } catch (SQLException ex) {
            Logger.getLogger(WordDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteWord(Word word) {
        String sql = "DELETE FROM word WHERE lesson=? AND word=? AND translate=?";
        try (PreparedStatement ps = ConnectSQLLite.getConnection().prepareStatement(sql);) {
            ps.setString(1, word.getLesson());
            ps.setString(2, word.getWord());
            ps.setString(3, word.getTranslate());
            ps.executeUpdate();
            return  true;
        } catch (SQLException ex) {
            Logger.getLogger(WordDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Word> getLessonLast() {
        String sql ="SELECT * FROM word WHERE lesson = (SELECT * from lesson ORDER BY id DESC LIMIT 1)";
        return resultSelect(sql);
    }
    
    public ArrayList<Word> randomLesson(){
        String sql = "SELECT * FROM word WHERE lesson = (SELECT * FROM lesson ORDER BY RANDOM() LIMIT 1)";
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
        Word word = new Word();
        try {
            word.setLesson(resultSet.getString(1));
            word.setTextWord(resultSet.getString(2));
            word.setTextTarnslate(resultSet.getString(3));
        } catch (SQLException ex) {
            Logger.getLogger(WordDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return word;
    }

}
