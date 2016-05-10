/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.exsampl;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author firsov
 */
public class Word {
    
    private final SimpleStringProperty word = new SimpleStringProperty("");
    private final SimpleStringProperty tarnslate = new SimpleStringProperty("");
    private String lesson;

    public void setTextWord(String textWord) {
        this.word.set(textWord.toLowerCase());
    }

    public void setTextTarnslate(String textTarnslate) {
        this.tarnslate.set(textTarnslate.toLowerCase());
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public SimpleStringProperty getWordProperty() {
        return word;
    }

    public SimpleStringProperty getTarnslateprProperty() {
        return tarnslate;
    }
    
    public String getWord(){
        return word.get();
    }
    
    public String getTranslate(){
        return tarnslate.get();
    }

    public String getLesson() {
        return lesson;
    }
    
}
